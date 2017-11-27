//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import utils.Launcher;
//
//public class MainMenu {
//    static WebDriver driver = Launcher.initChromeDriver();
//
//    public static void main(String[] args) {
//        String url = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
//        String email = "webinar.test@gmail.com";
//        String password = "Xcg7299bnSmMuRLp9ITw";
//        driver.get(url);
//
//        /* Login */
//        WebElement emailField = driver.findElement(By.id("email"));
//        WebElement passwordField = driver.findElement(By.id("passwd"));
//        WebElement submitButton = driver.findElement(By.name("submitLogin"));
//        emailField.clear();
//        emailField.sendKeys(email);
//        passwordField.clear();
//        passwordField.sendKeys(password);
//        submitButton.click();
//        try {
//            Thread.sleep(250);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        /* Dashboard */
//        WebElement dashboard = driver.findElement(By.id("tab-AdminDashboard"));
//        dashboard.click();
//        String dashboardTitle = searchForTitle();
//        System.out.println("Dashboard page title is " + dashboardTitle);
//        refreshPageAndVerifyItIsTheSame(dashboardTitle, dashboard);
//
//        /* Orders */
//        WebElement orders = driver.findElement(By.id("subtab-AdminParentOrders"));
//        orders.click();
//        String ordersTitle = searchForTitle();
//        System.out.println("Orders page title is " + ordersTitle);
//        refreshPageAndVerifyItIsTheSame(ordersTitle, orders);
//
//        /* Catalogue */
//        WebElement catalogue = driver.findElement(By.xpath("//li[@id='subtab-AdminCatalog']/a"));
//        catalogue.click();
//        String catalogueTitle = searchForTitle();
//        System.out.println("Catalogue page title is " + catalogueTitle);
//        refreshPageAndVerifyItIsTheSame(catalogueTitle, catalogue);
//
//        /* Clients */
//        WebElement clients = driver.findElement(By.xpath("//span[contains(text(), 'Клиенты')]"));
//        clients.click();
//        String clientsTitle = searchForTitle();
//        System.out.println("Clients page title is " + clientsTitle);
//        refreshPageAndVerifyItIsTheSame(clientsTitle, clients);
//
//        /* Support */
//        WebElement support = driver.findElement(By.id("subtab-AdminParentCustomerThreads"));
//        support.click();
//        String supportTitle = searchForTitle();
//        System.out.println("Support page title is " + supportTitle);
//        refreshPageAndVerifyItIsTheSame(supportTitle, support);
//
//        /* Statistics */
//        WebElement statistics = driver.findElement(By.id("subtab-AdminStats"));
//        statistics.click();
//        String statisticsTitle = searchForTitle();
//        System.out.println("Statistics page title is " + statisticsTitle);
//        refreshPageAndVerifyItIsTheSame(statisticsTitle, statistics);
//
//        /* Modules */
//        WebElement modules = driver.findElement(By.id("subtab-AdminParentModulesSf"));
//        modules.click();
//        String modulesTitle = searchForTitle();
//        System.out.println("Statistics page title is " + modulesTitle);
//        refreshPageAndVerifyItIsTheSame(modulesTitle, modules);
//
//        /* Design */
//        WebElement design = driver.findElement(By.xpath("//span[contains(text(), 'Design')]"));
//        design.click();
//        String designTitle = searchForTitle();
//        System.out.println("Statistics page title is " + designTitle);
//        refreshPageAndVerifyItIsTheSame(designTitle, design);
//
//        /* Delivery */
//        WebElement delivery = driver.findElement(By.id("subtab-AdminParentShipping"));
//        delivery.click();
//        String deliveryTitle = searchForTitle();
//        System.out.println("Statistics page title is " + deliveryTitle);
//        refreshPageAndVerifyItIsTheSame(deliveryTitle, delivery);
//
//        /* Payment */
//        WebElement payment = driver.findElement(By.id("subtab-AdminParentPayment"));
//        payment.click();
//        String paymentTitle = searchForTitle();
//        System.out.println("Statistics page title is " + paymentTitle);
//        refreshPageAndVerifyItIsTheSame(paymentTitle, payment);
//
//        /* International */
//        WebElement international = driver.findElement(By.id("subtab-AdminInternational"));
//        international.click();
//        String internationalTitle = searchForTitle();
//        System.out.println("Statistics page title is " + internationalTitle);
//        refreshPageAndVerifyItIsTheSame(internationalTitle, international);
//
//        /* Shop Parameters */
//        WebElement shopParameters = driver.findElement(By.id("subtab-ShopParameters"));
//        shopParameters.click();
//        String shopParametersTitle = searchForTitle();
//        System.out.println("Statistics page title is " + shopParametersTitle);
//        refreshPageAndVerifyItIsTheSame(shopParametersTitle, shopParameters);
//
//        /* Configuration */
//        WebElement configuration = driver.findElement(By.id("subtab-AdminAdvancedParameters"));
//        configuration.click();
//        String configurationTitle = searchForTitle();
//        System.out.println("Statistics page title is " + configurationTitle);
//        refreshPageAndVerifyItIsTheSame(configurationTitle, configuration);
//
//        /* Close the browser */
//        driver.quit();
//    }
//
//    static String searchForTitle() {
//        if (driver.findElements(By.className("page-title")).size() > 0) {
//            return driver.findElement(By.className("page-title")).getText().trim();
//        } else {
//            return driver.findElement(By.xpath("//h2[@class='title']")).getText().trim();
//        }
//    }
//
//    static void refreshPageAndVerifyItIsTheSame(String pageTitle, WebElement element) {
//        driver.navigate().refresh();
//        if (!pageTitle.equals(searchForTitle())) {
//            System.out.println(element.getText().trim() + " page was changed after refresh");
//        }
//    }
//}
