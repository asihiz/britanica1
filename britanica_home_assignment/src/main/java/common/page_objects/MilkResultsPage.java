package common.page_objects;

import common.building_blocks.ShopersalService;
import common.selenium_services.page.Pageable;
import common.selenium_services.page.Preparable;
import common.selenium_services.page.Verifiable;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class MilkResultsPage implements Pageable , Preparable, Verifiable {

    private static final By RESULT_SORT_BY_DDL = By.xpath("//*[@id=\"sortForm1\"]/div/button/span[1]");
    private static final By RESULT_ITEM = By.className("text");
    private static final By ADD_TO_CART_ITEM = By.className("js-add-to-cart");

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

    public void addLowestToChart() {
//        decorator.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElements(ADD_TO_CART_ITEM).get(0).click();
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
