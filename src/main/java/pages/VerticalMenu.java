package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerticalMenu {
    private EventFiringWebDriver driver;

    private By catalogueTab = By.id("subtab-AdminCatalog");
    private By productsSubtab = By.id("subtab-AdminProducts");
    private By categoriesSubtab = By.id("subtab-AdminCategories");
    private By monitoringSubtab = By.id("subtab-AdminTracking");
    private By attributesSubtab = By.id("subtab-AdminParentAttributesGroups");

    public VerticalMenu(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCatalogueSubtab(CatalogueSubtabs subtab) {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogueTab));
        actions.moveToElement(driver.findElement(catalogueTab)).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsSubtab));
        switch (subtab) {
            case PRODUCTS:
                driver.findElement(productsSubtab).click();
                break;
            case CATEGORIES:
                driver.findElement(categoriesSubtab).click();
//                newPage = new CategoriesPage(driver);
                break;
            case MONITORING:
                driver.findElement(monitoringSubtab).click();
                break;
            case ATTRIBUTES:
                driver.findElement(attributesSubtab).click();
                break;
            default:
                System.out.println(subtab + " subtab is not present in Catalogue");
        }
    }

    public enum CatalogueSubtabs {
        PRODUCTS, CATEGORIES, MONITORING, ATTRIBUTES
    }
}
