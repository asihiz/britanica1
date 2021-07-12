package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import common.selenium_services.page.Preparable;
import common.selenium_services.page.Verifiable;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConnectPage implements Pageable , Preparable, Verifiable {

    private static final By CONNECT_LOCATOR = By.xpath("/html/body/div[29]/div/div/div[3]/a");

    private WebElement connect;

    private final static Logger logger = Logger.getLogger(ConnectPage.class);

    public ConnectPage(){
    }

    @Override
    public void prepareElements() {
        connect = SeleniumDecorator.getInstance().getDriver().findElement(CONNECT_LOCATOR);
    }

    public void connect() {
        connect.click();
    }




    @Override
    public String getPageUniqueIdentifier() {
        return "";
}



}
