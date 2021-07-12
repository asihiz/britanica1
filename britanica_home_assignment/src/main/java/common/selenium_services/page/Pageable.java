package common.selenium_services.page;


import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.driver.SeleniumDriver;
import org.openqa.selenium.WebDriver;

public interface Pageable {

    public SeleniumDecorator decorator = SeleniumDecorator.getInstance();

    WebDriver driver = decorator.getDriver();

    void prepareElements();

    String getPageUniqueIdentifier() ;

//     <T> T getValidate();
//
//     <T> T getActivate();

}
