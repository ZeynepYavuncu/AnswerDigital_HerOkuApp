package com.herokuapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "username")
    public WebElement usernameInputBox;

    @FindBy(id="password")
    public WebElement passwordInputBox;

    @FindBy(css = "i.fa.fa-2x.fa-sign-in")
    public WebElement loginButton;

    @FindBy(id = "flash")
    public WebElement warningMsg;

    @FindBy(css = "a.button.secondary.radius")
    public WebElement logOutButton;

    public void login(String username, String password){
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }
}
