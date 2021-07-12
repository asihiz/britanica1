package common.page_objects;

import common.selenium_services.page.Pageable;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SearchPage implements Pageable {

    private static final By SEARCH_LOCATOR = By.id("js-site-search-input");

    private WebElement search;

    private final static Logger logger = Logger.getLogger(SearchPage.class);

    public SearchPage(){
    }

    @Override
    public void prepareElements() {
        search = driver.findElement(SEARCH_LOCATOR);
    }

    public void search(String searchVal) {
        decorator.scrollToElement(search);
        search.sendKeys(searchVal);
        search.sendKeys(Keys.ENTER);
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "";
}



}
