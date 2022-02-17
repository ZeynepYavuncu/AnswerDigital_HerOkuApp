package com.herokuapp.stepDefinitions;

import com.herokuapp.pages.InfiniteScrollPage;
import com.herokuapp.utilities.BrowserUtils;
import com.herokuapp.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class InfiniteScrollStepDefs {

    InfiniteScrollPage infiniteScrollPage=new InfiniteScrollPage();
    JavascriptExecutor jse=(JavascriptExecutor) Driver.get();

    @When("the user clicks on {string} button")
    public void the_user_clicks_on_button(String linkName)  {

        infiniteScrollPage.clickLink(linkName);
    }

    @When("the user scroll down twice")
    public void the_user_scroll_down_twice() {

        for (int i =1; i <3; i++) {
            jse.executeScript("window.scrollBy(0, 500)");
            BrowserUtils.waitFor(2);
        }
    }

    @When("the user scroll up to the top of the page")
    public void the_user_scroll_up_to_the_top_of_the_page() {

        jse.executeScript("arguments[0].scrollIntoView();",infiniteScrollPage.infiniteScrollText);
        BrowserUtils.waitFor(2);
    }

    @Then("verify that Infinite Scroll text displayed")
    public void verify_that_Infinite_Scroll_text_displayed() {

        String actualText=infiniteScrollPage.infiniteScrollText.getText();
        String expectedText="Infinite Scroll";
        Assert.assertEquals(actualText,expectedText);
    }

}
