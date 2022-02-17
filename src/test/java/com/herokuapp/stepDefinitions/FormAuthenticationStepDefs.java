package com.herokuapp.stepDefinitions;

import com.herokuapp.pages.LoginPage;
import com.herokuapp.utilities.ConfigurationReader;
import com.herokuapp.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FormAuthenticationStepDefs {

    LoginPage loginPage=new LoginPage();
    String actualWarningMsg="";

    @Given("the user is on the main url")
    public void the_user_is_on_the_main_url() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters {string} and {string} credentials and login")
    public void the_user_enters_and_credentials_and_login(String username, String password) {

        loginPage.login(username,password);

        if((username.equals(ConfigurationReader.get("username"))&&!password.equals(ConfigurationReader.get("password")))
        || (!username.equals(ConfigurationReader.get("username"))&&password.equals(ConfigurationReader.get("password"))))
        {
            actualWarningMsg=loginPage.warningMsg.getText();

        }else if(username.equals(ConfigurationReader.get("username"))&&password.equals(ConfigurationReader.get("password")))
        {
            actualWarningMsg=loginPage.warningMsg.getText();
            loginPage.logOutButton.click();
        }
    }

    @Then("verify that {string} msg appeared")
    public void verify_that_msg_appeared(String expectedWarningMsg) {

        Assert.assertTrue(actualWarningMsg.contains(expectedWarningMsg));
    }


}
