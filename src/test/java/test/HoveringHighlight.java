package test;

import com.actions.Actions;
import com.core.base.BaseTest;
import com.core.utils.Constants;
import com.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoveringHighlight extends BaseTest {


    @Test
    public void hoverHighlight () {
        Actions.loginPageActions().logIn(Constants.USERNAME, Constants.PASSWORD);
        Assert.assertTrue(Pages.mainPage().isElementsHightlightedAfterHover());
    }
}
