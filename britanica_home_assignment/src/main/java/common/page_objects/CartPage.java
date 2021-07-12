package common.page_objects;

import common.selenium_services.page.Pageable;
import common.selenium_services.page.Preparable;
import common.selenium_services.page.Verifiable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.general_util.GeneralUtils;

public class CartPage implements Pageable , Preparable, Verifiable {

    private static final By SHIPPING_FEE = By.className("infoSubText");
    private static final By PRICE = By.className("miglog-prod-totalPrize");
    private static final By TOTAL_PRICE = By.xpath("//*[@id=\"cartContainer\"]/div/div/footer/div[2]/div/div/div[1]/span/small");

    private WebElement shippingFee;
    private WebElement price;
    private WebElement total;

    public CartPage(){

    }

    @Override
    public void prepareElements() {
        shippingFee = driver.findElement(SHIPPING_FEE);
        price = driver.findElement(PRICE);
        total = driver.findElement(TOTAL_PRICE);
    }

    public Float getPrice() {
        return new Float(GeneralUtils.removeNoNumeric(price.getText()));
    }

    public Float getShippingFee() {
        return new Float(GeneralUtils.removeNoNumeric(shippingFee.getText()));
    }

    @SuppressWarnings("AssertEqualsBetweenInconvertibleTypes")
    public void verifyCartPrice(Float expectedPrice){
            Assert.assertEquals(java.util.Optional.ofNullable(expectedPrice), java.util.Optional.of(getPrice() + getShippingFee()));
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "https://www.shufersal.co.il/online/he/search?q=%D7%97%D7%9C%D7%91:pricePerUnit-asc";
    }
}
