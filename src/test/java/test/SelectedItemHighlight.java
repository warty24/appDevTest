package test;

import com.actions.Actions;
import com.core.base.BaseTest;
import com.core.utils.Constants;
import com.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectedItemHighlight extends BaseTest {


    @Test
    public void selectedHighlight () {
        Actions.loginPageActions().logIn(Constants.USERNAME, Constants.PASSWORD);
        Assert.assertTrue(Pages.mainPage().isSelectedElementsHightlighted());
    }
}
