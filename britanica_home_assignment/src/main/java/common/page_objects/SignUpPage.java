package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.general_util.GeneralUtils;
import util.general_util.poller.Pollable;

public class SignUpPage implements Pageable, Pollable {

    private static final By FIRST_NAME_LOCATOR = By.id("register_firstName");
    private static final By LAST_NAME_LOCATOR = By.id("register_lastName");
    private static final By ID_LOCATOR = By.id("register_idNumber");
    private static final By PHONE_LOCATOR = By.id("register_phone");
    private static final By EMAIL_LOCATOR = By.id("register_email");
    private static final By PASSWORD_LOCATOR = By.id("password");
    private static final By REPEAT_PASSWORD_LOCATOR = By.id("register.checkPwd");
    private static final By SIGN_UP_LOCATOR = By.xpath("//*[@id=\"miglogRegisterForm\"]/div[1]/button");

    private WebElement firstName;
    private WebElement lastName;
    private WebElement id;
    private WebElement phone;
    private WebElement email;
    private WebElement password;
    private WebElement repeatPassord;

    private WebElement singUp;

    private String url;

    private Actions action = new Actions(driver);


    public SignUpPage(){

    }

    @Override
    public void prepareElements() {
        firstName = SeleniumDecorator.getInstance().getDriver().findElement(FIRST_NAME_LOCATOR);
        lastName = SeleniumDecorator.getInstance().getDriver().findElement(LAST_NAME_LOCATOR);
        id = SeleniumDecorator.getInstance().getDriver().findElement(ID_LOCATOR);
        phone = SeleniumDecorator.getInstance().getDriver().findElement(PHONE_LOCATOR);
        email = SeleniumDecorator.getInstance().getDriver().findElement(EMAIL_LOCATOR);
        password = SeleniumDecorator.getInstance().getDriver().findElement(PASSWORD_LOCATOR);
        repeatPassord = SeleniumDecorator.getInstance().getDriver().findElement(REPEAT_PASSWORD_LOCATOR);
    }

    public final void signUp(String firstName, String lastName, String id, String phone, String email, String url, String password){
        decorator.clear(this.firstName).senkKeys(this.firstName, firstName);
        decorator.clear(this.lastName).senkKeys(this.lastName, lastName);
        decorator.clear(this.id).senkKeys(this.id, id);
        decorator.clear(this.phone).senkKeys(this.phone, phone);
        this.url = url;
        decorator.clear(this.email).senkKeys(this.email, email);
        decorator.clear(this.password).senkKeys(this.password, password);
        decorator.clear(this.repeatPassord).senkKeys(this.repeatPassord, password);
        try {
            Pollable.super.waitUntil(10000, 1000, "cant click on register exception");
        } catch (Exception e){
            GeneralUtils.reportError("cant click on register exceptio", e);
        }
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "https://www.shufersal.co.il/online/he/register";
    }

    @Override
    public boolean until() throws Exception {
        try {
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            driver.findElement(SIGN_UP_LOCATOR).click();
            if(driver.getCurrentUrl().equalsIgnoreCase(url)) {
                return true;
            }
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
