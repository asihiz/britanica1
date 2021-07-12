package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SummerDressPage implements Pageable {

    private static final By DRESSES_CONTAINER_LOCATOR = By.className("product-container");

    private static final By PRICE_CONTAINER_LOCATOR = By.className("content_price");

    private static final By BOTTOM_CONTAINER_LOCATOR = By.className("button-container");

    private static final By PRODUCT_PRICE_LOCATOR = By.className("product-price");

    private static final By DISCOUNT_LOCATOR = By.className("price-percent-reduction");

    private static final By ADD_TO_CART_LOCATOR = By.className("ajax_add_to_cart_button");

    public static String priceAfterDiscount;

    private List<WebElement> dressesContainer;


    public SummerDressPage(){

    }

    @Override
    public void prepareElements() {
        dressesContainer = SeleniumDecorator.getInstance().getDriver().findElements(DRESSES_CONTAINER_LOCATOR);
    }

    public void doShoppingFlow(){

        for (WebElement dress : dressesContainer){

            SeleniumDecorator.getInstance().elementHover(dress);
            WebElement pricesContainer = dress.findElement(PRICE_CONTAINER_LOCATOR);
            if(!pricesContainer.findElement(DISCOUNT_LOCATOR).getText().equals("")) {
                setPriceAfterDiscount();
                dress.findElement(BOTTOM_CONTAINER_LOCATOR).findElement(ADD_TO_CART_LOCATOR).click();
                break;
            }
        }
    }

    public static String getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public static void setPriceAfterDiscount() {
        priceAfterDiscount = SeleniumDecorator.getInstance().getDriver().findElement(PRODUCT_PRICE_LOCATOR).getText();
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "http://automationpractice.com/index.php?id_category=11&controller=category";
    }

}
