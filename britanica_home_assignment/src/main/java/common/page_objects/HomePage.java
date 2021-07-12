package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage implements Pageable {

//    private static final By SIGN_UP_LOCATOR = By.xpath("//*[@id=\"contactInner\"]/div/div[2]/ul/li[2]/a\n");
//    private static final By LOGIN_LOCATOR = By.xpath("//*[@id=\"loginDropdownContainer\"]/button");
    private static final By CONNECT_LOCATOR = By.xpath("//*[@id=\"loginDropdownContainer\"]/button");
    private static final By SUPERMARKET_GO_LOCATOR = By.linkText("סופרמרקט");

    //*[@id="categoryMenu"]/li[1]/a/span


//    private WebElement signUp;
    private WebElement supermarket;

    private WebElement connect;

    private final static Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(){
    }

    @Override
    public void prepareElements() {
//        connect =
//        supermarket = driver.findElement(SUPERMARKET_GO_LOCATOR);
    }

    public void connect() {
        driver.findElement(CONNECT_LOCATOR).click();    }

    public void goToSupermarket() {
        driver.findElement(SUPERMARKET_GO_LOCATOR).click();
    }

//    public void login() {
//        login.click();
//    }



    @Override
    public String getPageUniqueIdentifier() {
        return "https://www.shufersal.co.il/online/";
}



}
