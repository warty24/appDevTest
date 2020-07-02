package com.actions;

public class Actions {

    private static MainPageActions mainPageActions;
    private static LoginPageActions loginPageActions;

    public static MainPageActions mainPageActions() {
        if (mainPageActions == null) {
            mainPageActions = new MainPageActions();
        }
        return mainPageActions;
    }
    public static LoginPageActions loginPageActions() {
        if (loginPageActions == null) {
            loginPageActions = new LoginPageActions();
        }
        return loginPageActions;
    }
}
