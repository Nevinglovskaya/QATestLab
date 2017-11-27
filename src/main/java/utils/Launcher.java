package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Launcher {
    private static WebDriver getWebDriver(Browsers browser) {
        switch(browser) {
            case CHROME:
            default:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
                return new FirefoxDriver();
            case IE:
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/drivers/MicrosoftWebDriver.exe");
                return new EdgeDriver();
        }
    }

    public static EventFiringWebDriver getConfiguredDriver(Browsers browser) {
        WebDriver driver = getWebDriver(browser);
        driver.manage().window().maximize();
        EventFiringWebDriver webDriver = new EventFiringWebDriver(driver);
        webDriver.register(new EventHandler());
        return webDriver;
    }

    public enum Browsers {
        CHROME, IE, FIREFOX
    }
}
