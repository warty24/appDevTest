package com.pages;

public class Pages {
    private static MainPage mainPage;
    private static LoginPage loginPage;

    public static MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }
    public static LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }
}
