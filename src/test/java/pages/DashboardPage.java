package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private EventFiringWebDriver driver;

    private By userIcon = By.id("employee_infos");
    private By exitBtn = By.id("header_logout");
    private By ordersTab = By.id("subtab-AdminParentOrders");

    public DashboardPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void clickOnUserIcon() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userIcon));
        driver.findElement(userIcon).click();
    }

    public void clickOnExitBtn() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(exitBtn));
        driver.findElement(exitBtn).click();
    }

    public void clickLogoutBtnWithJS() {
        WebElement element = driver.findElement(exitBtn);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }

    public boolean scrollPageDown() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(userIcon));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(0, 1000)");
        return true;
    }

    public void selectOrdersItem() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(userIcon));

        WebElement orderTabElement = driver.findElement(ordersTab);
        Actions actions = new Actions(driver);
        actions.moveToElement(orderTabElement).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subtab-AdminOrders")));
        orderTabElement.findElements(By.cssSelector("li")).get(0).click();
    }
}
