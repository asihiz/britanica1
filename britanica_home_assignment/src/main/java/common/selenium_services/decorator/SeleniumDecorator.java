package common.selenium_services.decorator;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import util.general_util.GeneralUtils;

import java.util.List;
import java.util.Set;

public final class SeleniumDecorator implements WebDriver{

    private static final SeleniumDecorator INSTANCE = new SeleniumDecorator();
    private final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SeleniumDecorator.class);
    private JavascriptExecutor executor;

    private WebDriver driver;

    private SeleniumDecorator() {
        // Avoid reflection calls on Singleton(
        // Private constructor can be called by reflection
        // Solves thread safe issues
        if(INSTANCE != null){
            return;
        }
    }

    public static SeleniumDecorator getInstance(){
        return INSTANCE;
    }

    public  <T extends WebDriver> void setDriver(T driver) {
        this.driver = driver;
    }

    public <T extends WebDriver> T getDriver() {
        return (T) driver;
    }

    public void handleDropDown(WebElement ddl, By listItemLocator, String value){
        ddl.click();
        WebElement item = findElementByTextInList(listItemLocator, value);
        item.click();
    }

    public WebElement findElementByTextInList(By listItemLocator, String value){
        return driver.findElements(listItemLocator).stream().
                filter(we -> we.getText().equalsIgnoreCase(value)).
                findFirst().orElse(null);
    }

    public void elementHover(WebElement we){
        Actions builder = new Actions(driver);
        builder.moveToElement(we).perform();
        builder.moveToElement(we).click().perform();
    }

    public void elementHover(WebElement we, By clickedLocator){
        Actions builder = new Actions(driver);
        builder.moveToElement(we).perform();
        driver.findElement(clickedLocator).click();
    }

    public SeleniumDecorator clear(WebElement we){
        we.clear();
        return this;
    }

    public void scrollToElement(WebElement we){

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", we);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            GeneralUtils.reportError("Error in scrolling to element", e);
        }
    }

    public void clickWithJS(WebElement we) {
        executor =(JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", we);
    }

    public SeleniumDecorator senkKeys(WebElement we, String text){
        we.sendKeys(text);
        logger.info("Adding to element " + we.toString() + " value " + text);
        return this;
    }

    @Override
    public void get(String s) {
        driver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }


}

