package common.page_objects;

import common.selenium_services.page.Pageable;
import common.selenium_services.page.Preparable;
import common.selenium_services.page.Verifiable;
import org.openqa.selenium.By;

public class RemoveFromCartPage implements Pageable, Preparable, Verifiable {

    private static final By REMOVE_FROM_CART = By.className("miglog-prod-remove");

    @Override
    public void prepareElements() {

    }

    public void removeFromCart() {
        driver.findElement(REMOVE_FROM_CART).click();
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "";
    }
}
