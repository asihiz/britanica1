package common.page_objects;

import common.building_blocks.ShopersalService;
import common.selenium_services.page.Pageable;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class MilkResultsPage implements Pageable {

    //    private static final By RESULT_SORT_BY_DDL = By.linkText("מיין לפי:");
    private static final By RESULT_SORT_BY_DDL = By.xpath("//*[@id=\"sortForm1\"]/div/button/span[1]");
    private static final By RESULT_ITEM = By.className("text");
//private static final By ADD_TO_CART_ITEM = By.xpath("//p*[@id=\"mainProductGrid\"]/li[1]/div[1]/div[4]/button[1]");
private static final By ADD_TO_CART_ITEM = By.className("js-add-to-cart");

    private static final By PRICE_ITEM = By.className("number");
    private static final By SHIPPING_FEE = By.className("infoSubText");
    //*[@id="mainProductGrid"]/li[1]/div[1]/div[4]/button[1]




    private WebElement sortBy;

    private final static Logger logger = Logger.getLogger(MilkResultsPage.class);

    public MilkResultsPage(){
    }

    @Override
    public void prepareElements() {
        sortBy = driver.findElement(RESULT_SORT_BY_DDL);
    }

    public void sort(SortOption sortOption) {
        decorator.handleDropDown(sortBy, RESULT_ITEM, sortOption.value);
    }
//
    public void addLowestToChart() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElements(ADD_TO_CART_ITEM).get(0 ).click();
    }




    public enum SortOption {

        FROM_LOW_TO_HIGH("מחיר: נמוך עד גבוה");

        String value;

        SortOption(String value){
            this.value = value;
        }


    }

    @Override
    public String getPageUniqueIdentifier() {
        return "";
    }



}
