package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SupermarketPage implements Pageable {

//    private static final By MILK_PRODUCT_LOCATOR = By.xpath("//*[@id=\"subTileCollapse_A_8\"]/li[3]/a");
      private static final By MILK_PRODUCT_LOCATOR = By.linkText("מוצרי חלב וביצים");

    private static final By SEARCH_LOCATOR = By.id("js-site-search-input");




    private WebElement milkProducts;

    private final static Logger logger = Logger.getLogger(SupermarketPage.class);

    public SupermarketPage(){
    }

    @Override
    public void prepareElements() {
        milkProducts = SeleniumDecorator.getInstance().getDriver().findElement(MILK_PRODUCT_LOCATOR);
    }

    public void getMilkProduct() {
        milkProducts.click();
    }




    @Override
    public String getPageUniqueIdentifier() {
        return "";
}



}
