package test;

import com.actions.Actions;
import com.core.base.BaseTest;
import com.core.utils.Constants;
import com.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavBarVisible extends BaseTest {
    @Test
    public void navBarVisibleTest() {
        Actions.loginPageActions().logIn(Constants.USERNAME,Constants.PASSWORD);
        Assert.assertTrue(Pages.mainPage().isNavMenuVisible());
    }
}