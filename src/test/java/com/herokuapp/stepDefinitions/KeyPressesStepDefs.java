package com.herokuapp.stepDefinitions;

import com.herokuapp.pages.KeyPressesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class KeyPressesStepDefs {

    KeyPressesPage keyPressesPage=new KeyPressesPage();

    @When("the user enters {string} below")
    public void the_user_enters_below(String keys) {

        switch(keys){
            case "BACK_SPACE" :
                keyPressesPage.keysInputButton.sendKeys(Keys.BACK_SPACE);
                break;

            case "TAB" :
                keyPressesPage.keysInputButton.sendKeys(Keys.TAB);
                break;

            case "CONTROL" :
                keyPressesPage.keysInputButton.sendKeys(Keys.CONTROL);
                break;

            case "SPACE" :
                keyPressesPage.keysInputButton.sendKeys(Keys.SPACE);
                break;
        }
    }

    @Then("verify that the text is displayed after every {string} press")
    public void verify_that_the_text_is_displayed_after_every_key_press(String keys) {

        Assert.assertTrue(keyPressesPage.textDisplayed.getText().contains(keys));
    }
}
