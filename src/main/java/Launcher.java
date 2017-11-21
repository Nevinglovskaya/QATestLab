import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launcher {
    public static void main(String[] args) {
        WebDriver driver = initChromeDriver();
        driver.get("https://bing.com");
        WebElement field = driver.findElement(By.id("sb_form_q"));
        field.sendKeys("selenium");
        WebElement button = driver.findElement(By.name("go"));
        button.click();
    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        return new ChromeDriver();
    }
}
