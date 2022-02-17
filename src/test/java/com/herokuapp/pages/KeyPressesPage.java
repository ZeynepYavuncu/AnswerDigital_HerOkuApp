package com.herokuapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeyPressesPage extends BasePage{

    @FindBy(id = "target")
    public WebElement keysInputButton;

    @FindBy(id="result")
    public WebElement textDisplayed;
}
