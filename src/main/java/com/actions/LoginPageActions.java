package com.actions;

import com.pages.Pages;

public class LoginPageActions {
    public void logIn(String name, String pswd){
        Pages.loginPage().enterUserName(name);
        Pages.loginPage().enterPassword(pswd);
        Pages.loginPage().submit();
    }
}
