package common.selenium_services.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.general_util.GeneralUtils;
import util.general_util.OsUtils;
import util.properties.PropertiesHandlerImpl;

import java.util.concurrent.TimeUnit;


/**
 * Created by asi on 2/19/2017.
 */
public final class SeleniumDriver {

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_PATH_WINDOWS_PROP = "webdriver.chrome.driver.path.windows";
    private static final String CHROME_PATH_LINUX32_PROP = "webdriver.chrome.driver.path.linux32";
    private static final String CHROME_PATH_LINUX64_PROP = "webdriver.chrome.driver.path.linux64";

    private static final String webDriverManagerServerCommand = "mvn exec:java -Dexec.args=\"server 4041\"";

    private WebDriver driver;
    private final static Logger logger = Logger.getLogger(SeleniumDriver.class);

    // Thread safe
    private static final SeleniumDriver INSTANCE = new SeleniumDriver();

    private SeleniumDriver() {
        // Avoid reflection calls on Singleton(
        // Private constructor can be called by reflection
        // Solves thread safe issues
        if(INSTANCE != null){
            return;
        }
    }

    public static SeleniumDriver getInstance() {
        return INSTANCE;
    }


    public <T extends WebDriver> T createDriver(DriverType dt, OS machine)  {

        try {
            switch (dt){
                case CHROME:
                    driver = createChromeDriver(machine);
                    break;
                case FIRE_FOX:
                    driver = createFireFoxDriver();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            GeneralUtils.reportError("Error creating Driver", e);
             return null;
        }
        configureDriver(driver, dt);
        return (T) driver;
    }

    private <T extends WebDriver> void configureDriver(T driver, DriverType dt) {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
        } catch (Throwable t){
            GeneralUtils.reportError("Error in driver capacities", t);
        }
        print(dt);
    }

    private  WebDriver createChromeDriver(OS machine)  {
        System.setProperty(CHROME_DRIVER, machine.driverPath);
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver createFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public void close() {
        driver.close();
        driver.quit();
    }

    private static void print(DriverType type) {

        logger.info("=========================================================");
        logger.info("============= Created New " + type.name() + " Driver =================");
        logger.info( "=========================================================");
        logger.info("========== Starting New Test In " + type.name() + " Driver ===========");
        logger.info("=========================================================");
        logger.info(type.name() + " driver was created");
    }

    public enum DriverType {

        FIRE_FOX, CHROME;
    }

    public enum OS {

        WINDOWS(PropertiesHandlerImpl.getPropData().getProperty(CHROME_PATH_WINDOWS_PROP)),
        LINUX32(PropertiesHandlerImpl.getPropData().getProperty(CHROME_PATH_LINUX32_PROP)),
        LINUX64(PropertiesHandlerImpl.getPropData().getProperty(CHROME_PATH_LINUX64_PROP));

        public String driverPath;

        OS(String driverPath) {
            this.driverPath = driverPath;
        }

        public static String getDriverPath(){
            if(OsUtils.isWindows()){
                return OS.WINDOWS.driverPath;
            } else {
                return OS.LINUX64.driverPath;
            }
        }

    }

}
