import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.*;
import utils.Launcher;

public class MyTest {
    public static void main(String[] args) {
        EventFiringWebDriver driver = Launcher.getConfiguredDriver(Launcher.Browsers.CHROME);
        String category = "test";

        /* Login */
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.fillEmailInput();
        loginPage.fillPassInput();
        loginPage.clickLoginBtn();

        /* Go to Category page */
        VerticalMenu menu = new VerticalMenu(driver);
        menu.clickOnCatalogueSubtab(VerticalMenu.CatalogueSubtabs.CATEGORIES);

        /* Add a new category */
        AddCategoryPage addCategoryPage = new CategoriesPage(driver).clickAddCategoryBtn();
        addCategoryPage.fillNameInput(category);
        CategoriesPage categoriesPage = addCategoryPage.clickSubmitBtn();
        boolean isAlert = categoriesPage.isSuccessAlertPresent();
        if (isAlert) {
            System.out.println("Category was successfully created");
        } else {
            System.out.println("Category was not created");
        }

        /* Check if the created category is in the table */
        categoriesPage.filterByName(category);
        categoriesPage.isCategoryPresentInTable(category);

        /* Postcondition - Delete created category*/
        categoriesPage.deleteCategory(category);
        driver.quit();
    }
}
