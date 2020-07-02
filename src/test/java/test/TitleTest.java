package test;

import com.actions.Actions;
import com.core.base.BaseTest;
import com.core.utils.Constants;
import com.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TitleTest extends BaseTest {
    @Test
    public void titleTest () {
        Actions.loginPageActions().logIn(Constants.USERNAME, Constants.PASSWORD);
        Assert.assertTrue (Pages.loginPage().getTitle().contains(Constants.EXPECTED_MAIN_PAGE_TITLE));
    }
}
