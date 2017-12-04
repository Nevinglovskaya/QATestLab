package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateTo(String var1, WebDriver driver) {

    }

    public void afterNavigateTo(String var1, WebDriver driver) {

    }

    public void beforeNavigateBack(WebDriver driver) {

    }

    public void afterNavigateBack(WebDriver driver) {

    }

    public void beforeNavigateForward(WebDriver driver) {

    }

    public void afterNavigateForward(WebDriver driver) {

    }

    public void beforeNavigateRefresh(WebDriver driver) {
        System.out.println("Refreshing page");
    }

    public void afterNavigateRefresh(WebDriver driver) {
        System.out.println("Page was refreshed");
    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Search for element " + by.toString());
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Element searched " + by.toString() + " was found");
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        String elementName = element.getText();
        System.out.println("Click on element: " + elementName);
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Element was clicked on");
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] var3) {

    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] var3) {

    }

    public void beforeScript(String var1, WebDriver driver) {

    }

    public void afterScript(String var1, WebDriver driver) {

    }

    public void onException(Throwable var1, WebDriver driver) {

    }
}
