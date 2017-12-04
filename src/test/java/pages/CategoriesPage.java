package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CategoriesPage extends VerticalMenu {
    private EventFiringWebDriver driver;

    private By addCategoryBtn = By.id("page-header-desc-category-new_category");
    private By successAlert = By.className("alert-success");
    private By nameFilterInput = By.cssSelector("input[name=categoryFilter_name]");
    private By filterSearchBtn = By.id("submitFilterButtoncategory");
    private By categoriesInTable = By.cssSelector("tbody tr");
    private By categoryCheckbox = By.name("categoryBox[]");
    private By groupActionsBtn = By.xpath("//button[contains(text(), 'Групповые действия')]");
    private By deleteAllBtn = By.xpath("//a[contains(., 'Удалить выбранное')]");
    private By deleteBtn = By.xpath("//button[contains(., 'Удалить')]");

    public CategoriesPage(EventFiringWebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AddCategoryPage clickAddCategoryBtn() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(addCategoryBtn));
        driver.findElement(addCategoryBtn).click();
        return new AddCategoryPage(driver);
    }

    public boolean isSuccessAlertPresent() {
        boolean alertIsPresent = false;
        String alert = driver.findElements(successAlert).get(0).getText().trim().toLowerCase();
        if (alert.contains("создано")) {
            alertIsPresent = true;
            return alertIsPresent;
        }
        return alertIsPresent;
    }

    public void fillNameFilter(String name) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(nameFilterInput));
        driver.findElement(nameFilterInput).sendKeys(name);
    }

    public void filterByName(String name) {
        fillNameFilter(name);
        WebElement searchBtn = driver.findElement(filterSearchBtn);
        searchBtn.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.stalenessOf(searchBtn));
    }

    public List<WebElement> searchForCategoryByName(String category) {
        List<WebElement> rowsWithCategory = new ArrayList<>();
        List<WebElement> rows = driver.findElements(categoriesInTable);
        System.out.println("Rows in table - " + rows.size());
        for (WebElement row : rows) {
            String categoryName = row.findElements(By.tagName("td")).get(2).getText().trim();
            if (categoryName.equals(category)) {
                rowsWithCategory.add(row);
            }
        }
        switch (rowsWithCategory.size()) {
            case 0:
                System.out.println("No category with " + category + " name was found");
                break;
            case 1:
                System.out.println("There was found 1 category named " + category);
                break;
            default:
                System.out.println("There were found " + rowsWithCategory.size() + " categories with " + category + " name");
        }
        return rowsWithCategory;
    }

    public boolean isCategoryPresentInTable(String category) {
        boolean isPresent = false;
        List<WebElement> rows = searchForCategoryByName(category);
        if (rows.size() > 0) {
            isPresent = true;
        }
        return isPresent;
    }

    public void deleteCategory(String category) {
        List<WebElement> rows = searchForCategoryByName(category);
        for (WebElement row : rows) {
            row.findElement(categoryCheckbox).click();
        }
        driver.findElement(groupActionsBtn).click();
        driver.findElement(deleteAllBtn).click();
        driver.switchTo().alert().accept();
        driver.findElement(deleteBtn).click();
        System.out.println(category + " category has been successfully deleted");
    }
}
