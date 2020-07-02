package com.pages;

import com.core.base.PageTools;
import org.openqa.selenium.By;

public class LoginPage  extends PageTools {

    private By mailField = By.xpath("//input[@name=\"email\"]");
    private By pswdField = By.xpath("//input[@name=\"password\"]");

    public void enterUserName(String name) {
        type(name,mailField);
    }
    public void enterPassword(String pswd) {
        type(pswd,pswdField);
    }
    public void submit () {
        clickEnterButton();
    }

    public String getTitle () { return getTile();}
}
