package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class LoginPage {
    private EventFiringWebDriver driver;

    private String url = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    private String email = "webinar.test@gmail.com";
    private String password = "Xcg7299bnSmMuRLp9ITw";

    private By emailInput = By.id("email");
    private By passwordInput = By.id("passwd");
    private By loginBtn = By.name("submitLogin");

    public LoginPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void fillEmailInput() {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillPassInput() {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }
}
