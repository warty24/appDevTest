package com.core.base;

import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.Exist;
import com.core.allure.AllureLogger;
import com.core.utils.LocatorParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class PageTools extends AllureLogger {

    private static String getPreviousMethodNameAsText() {
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        String replacedMethodName = methodName.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
        return replacedMethodName.substring(0, 1).toUpperCase() + replacedMethodName.substring(1).toLowerCase();
    }

    private By byLocator(By by, Object... args) {
        return LocatorParser.parseLocator(by, args);
    }

    protected SelenideElement getSelenideElement(By by, Object... args) {
        return $(byLocator(by, args));
    }

    protected Actions getActions() {
        return Selenide.actions();
    }
    protected String getTile() {return Selenide.title();}

    /**
     * Should be
     */
    protected ElementsCollection shouldBe(CollectionCondition condition, By by, Object... args) {
        return $$(byLocator(by, args)).shouldBe(condition);
    }

    protected SelenideElement shouldBe(Condition condition, By by, Object... args) {
        return $(byLocator(by, args)).shouldBe(condition);
    }

    /**
     * Main Actions
     */
    protected void click(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        shouldBe(Condition.visible, by, args).click();
    }

    protected void jsClick(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        Selenide.executeJavaScript("arguments[0].click();", shouldBe(Condition.exist, by, args));
    }

    protected void type(String text, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " '" + text + "', element --> " + byLocator(by, args));
        wipeText(by);
        shouldBe(Condition.enabled, by, args).append(text);
    }

    protected void wipeText(By by, Object... args) {
        int stringSize = shouldBe(Condition.enabled, by, args).getWrappedElement().getAttribute("value").length();
        for (int i = 0; i < stringSize; i++) {
            shouldBe(Condition.enabled, by, args).sendKeys(Keys.BACK_SPACE);
        }
    }

    protected void typeIntoFrame(String text, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " '" + text + "', element --> " + byLocator(by, args));
        shouldBe(Condition.visible, by, args).clear();
        shouldBe(Condition.visible, by, args).sendKeys(text);
    }

    protected void selectOption(String option, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " --> " + option + ", element --> " + byLocator(by, args));
        shouldBe(Condition.visible, by, args).selectOption(option);
    }

    protected void mouseHover(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        shouldBe(Condition.visible, by, args).hover();
    }

    protected void clickEnterButton() {
        getActions().sendKeys(Keys.ENTER).perform();
    }

    protected void pressAndHoldShift() {
        getActions().keyDown(Keys.SHIFT).perform();
    }

    protected void releaseShift() {
        getActions().keyUp(Keys.SHIFT).perform();
    }

    protected void dragAndDrop(By b1, By b2){
//        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by1, args));
        getActions().dragAndDrop(getSelenideElement(b1), getSelenideElement(b2)).perform();
    }

    protected void scrollToElement(By by, Object... args) {
//        logInfo(getPreviousMethodNameAsText() + ", elements --> " + byLocator(by, args));
        waitForElementVisibility(byLocator(by, args));
        Selenide.executeJavaScript("arguments[0].scrollIntoView();", shouldBe(Condition.exist, by, args));
    }

    protected void waitForElementVisibility(By by, Object... args) {
        shouldBe(Condition.visible, by, args);
    }

    protected void waitForElementInvisibility(By by, Object... args) {
        shouldBe(Condition.hidden, by, args);
    }

    protected void waitForElementClickable(By by, Object... args) {
        shouldBe(Condition.visible, by, args);
        shouldBe(Condition.enabled, by, args);
    }

    /**
     * Is condition
     */
    /*Working without wait*/
    protected boolean isCondition(Condition condition, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", condition --> " + condition.getName() + ", element --> " + byLocator(by, args));
        return getSelenideElement(by, args).is(condition);
    }

    /*Working with wait*/
    protected boolean isElementVisible(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        return isCondition(Condition.visible, by, args);
    }

    /*Working with wait*/
    protected boolean isElementExists(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        return isCondition(Condition.exist, by, args);
    }

    /*Working with wait*/
    protected boolean isElementEnabled(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        return isCondition(Condition.enabled, by, args);
    }

    /**
     * Getters
     */
    protected String getElementText(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        return shouldBe(Condition.visible, by, args).text();
    }

    protected String getElementAttributeValue(String attr, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        return shouldBe(Condition.enabled, by, args).attr(attr);
    }

    protected String getElementCssValue(String attr, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        return shouldBe(Condition.enabled, by, args).getCssValue(attr);
    }

    protected List<SelenideElement> getElements(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", elements --> " + byLocator(by, args));
        return shouldBe(sizeGreaterThan(-1), by, args);
//        return $$(byLocator(by, args));
    }

    protected List<String> getElementsText(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", elements --> " + byLocator(by, args));
        return shouldBe(sizeGreaterThan(-1), by, args).texts();
//        return $$(byLocator(by, args)).texts();
    }

    /**
     * Strings
     */
    protected String cutStrFromTo(String s, char from, char to) {
        return s.substring(s.indexOf(from) + 1, s.lastIndexOf(to)-1);
    }

    /**
     * Other
     */

    protected void waitASec () {
        Selenide.sleep(10000);
    }
    protected int randomNumber (int min, int max) {
        return (int) (Math.random() * max) + min;
    }
    protected int randomNumber (int max) {
        return (int) (Math.random() * max);
    }
    protected String lowCase (String str) {
        return str.toLowerCase();
    }



}
