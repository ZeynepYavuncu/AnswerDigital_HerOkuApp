package com.herokuapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InfiniteScrollPage extends BasePage{

    @FindBy(tagName = "h3")
    public WebElement infiniteScrollText;
}
