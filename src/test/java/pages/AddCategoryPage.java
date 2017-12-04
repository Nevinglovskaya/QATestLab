package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCategoryPage {
    EventFiringWebDriver driver;

    private By nameInput = By.id("name_1");
    private By submitBtn = By.id("category_form_submit_btn");

    public AddCategoryPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void fillNameInput(String name) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        driver.findElement(nameInput).sendKeys(name);
    }

    public CategoriesPage clickSubmitBtn() {
        driver.findElement(submitBtn).click();
        return new CategoriesPage(driver);
    }
}
