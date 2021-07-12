package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import common.selenium_services.page.Preparable;
import common.selenium_services.page.Verifiable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage implements Pageable , Preparable, Verifiable {

    private static final By USER_NAME_LOCATOR = By.id("j_username");
    private static final By PASSWORD_LOCATOR = By.id("j_password");
    private static final By SIGN_IN_LOCATOR = By.xpath("//*[@id=\"loginForm\"]/div[3]/button");

    private WebElement userName;
    private WebElement password;
    private WebElement singIn;

    public LoginPage(){

    }

    @Override
    public void prepareElements() {
//        connect = driver.findElement(CONNECT_LOCATOR);
        userName = driver.findElement(USER_NAME_LOCATOR);
        password = driver.findElement(PASSWORD_LOCATOR);
        singIn = driver.findElement(SIGN_IN_LOCATOR);
    }

    public void login(String userName, String password){
//        connect.click();
        decorator.clear(this.userName).senkKeys(this.userName, userName);
        decorator.clear(this.password).senkKeys(this.password, password);
        singIn.click();
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "https://www.shufersal.co.il/online/he/login";
    }
}
