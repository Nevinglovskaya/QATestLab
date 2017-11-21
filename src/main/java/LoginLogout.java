import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginLogout {
    public static void main(String[] args) {
        String url = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
        String email = "webinar.test@gmail.com";
        String password = "Xcg7299bnSmMuRLp9ITw";
        WebDriver driver = Launcher.initChromeDriver();
        driver.get(url);

        /* Login */
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("passwd"));
        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        submitButton.click();
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* Logout */
        WebElement userIcon = driver.findElement(By.className("employee_avatar_small"));
        userIcon.click();
        WebElement logoutButton = driver.findElement(By.id("header_logout"));
        logoutButton.click();

        /* Close the browser */
        driver.quit();
    }
}
