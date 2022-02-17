package com.herokuapp.pages;

import com.herokuapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void clickLink(String linkName){
        Driver.get().findElement(By.linkText(linkName)).click();
    }

}
