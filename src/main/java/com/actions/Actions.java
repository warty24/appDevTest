package com.actions;

public class Actions {

    private static LoginPageActions loginPageActions;

    public static LoginPageActions loginPageActions() {
        if (loginPageActions == null) {
            loginPageActions = new LoginPageActions();
        }
        return loginPageActions;
    }
}
