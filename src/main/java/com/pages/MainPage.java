package com.pages;

import com.core.base.PageTools;
import org.openqa.selenium.By;

public class MainPage extends PageTools {

    private By userMenu = By.xpath ("//span[@class=\"UserMenu__AvatarIcon-sc-1fu4vmt-2 kzRfXZ\"]");
    private By favicon = By.xpath("//link [@rel=\"shortcut icon\"]");
    private By navMenu = By.xpath("//div [@id=\"app\"]/div/div[2]/div/ul");
    private By navMenuItem = By.xpath("//div [@id=\"app\"]/div/div[2]/div/ul/li[%s]/a");
    private By logoButton = By.xpath("//div [@id=\"app\"]/div/div[2]/div/a");
    private By logOutButton = By.xpath("//div [@id=\"app\"]/div/div[2]/div/div");



    public void logOut () {
        click(logOutButton);
        click(logOutButton);
    }

    public boolean isUserMenuExist () {
        getElementText(userMenu);
        return isElementExists(userMenu);
    }
    public boolean isFaviconExist () {
        getElementAttributeValue("href",favicon);
        return isElementExists(favicon);
    }
    public boolean isNavMenuVisible () {
        getElementText(navMenu);
        return isElementVisible(navMenu);
    }
    public boolean isNavMenuContainsItems () {
        getElementText(navMenu);
        for (int i = 1; i <=4; i++) {
            if (!(getElementAttributeValue("href", navMenuItem, i).contains(getElementText(navMenuItem, i).toLowerCase()))) {
                System.out.println(getElementAttributeValue("href", navMenuItem, i) + " Not contains " + getElementText(navMenuItem, i).toLowerCase());
                return false;
            }
        }
        return  true;
    }
    public boolean isLogoButtonRedirectsToMainPage () {
        getElementAttributeValue("href", logoButton);
        return getElementAttributeValue("href", logoButton).contains("/start");
    }
    public boolean isElementsHightlightedAfterHover () {
        String color;
        String highlightedColor;

        for (int i = 1; i <=4; i++) {
            if (i == 1) click(navMenuItem,4);
            if (i == 3) click(navMenuItem,1);
            color = getElementCssValue("color", navMenuItem, i);
            mouseHover(navMenuItem, i);
            highlightedColor = getElementCssValue("color", navMenuItem, i);
            if (color.contentEquals(highlightedColor)) {
                return false;
            }
        }
        return true;
    }
    public boolean isSelectedElementsHightlighted() {
        String notHighlightedFW = getElementCssValue("font-weight", navMenuItem, 4);
        String fw;

        for (int i = 1; i <=4; i++) {
            click(navMenuItem, i);
            fw = getElementCssValue("font-weight", navMenuItem, i);
            if (fw.contentEquals(notHighlightedFW)) return false;
        }
        return true;
    }
}
