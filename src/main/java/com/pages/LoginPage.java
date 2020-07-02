package com.pages;

import com.core.base.PageTools;
import org.openqa.selenium.By;

public class LoginPage  extends PageTools {

    private By mailField = By.xpath("//input[@name=\"email\"]");
    private By pswdField = By.xpath("//input[@name=\"password\"]");
    private By invalidPswdMsg = By.xpath("//div [@class =\"auth0-global-message auth0-global-message-error\"]");
    private By blankFieldMsg = By.xpath("//div[@class=\"auth0-lock-error-msg\"]");

    public void enterUserName(String name) {
        type(name,mailField);
    }
    public void enterPassword(String pswd) {
        type(pswd,pswdField);
    }
    public void submit () {
        clickEnterButton();
    }

    public String getMail() {
        return ("mail"+ randomNumber(1000)+"@mail.test");
    }
    public boolean isContainsErrMsg () {
        if(!isElementExists(invalidPswdMsg)) waitASec();
        return (getElementText(invalidPswdMsg).contains("WRONG EMAIL OR PASSWORD."));
    }
    public boolean isContainsBlankFieldErr () {
        return isElementExists(blankFieldMsg);
    }
    public String getTitle () { return getTile();}

}
