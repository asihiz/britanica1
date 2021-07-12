package common.selenium_services.page;

import common.selenium_services.decorator.SeleniumDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;

public interface PageVerifiable {

    static String METHOD_NAME = "getPageUniqueIdentifier";
    final static Logger logger = Logger.getLogger(PageVerifiable.class);

    default <T> boolean validateInPage(T instance, Class clazz) throws NotInPageException {
        logger.info("Validating is in page to page " + clazz.getName());
        WebDriver driver = SeleniumDecorator.getInstance().getDriver();
        return verify(getUniqueId(instance, clazz), driver.getCurrentUrl());
    }

    default <T> String getUniqueId(T instance, Class clazz){
        try {
            Method method = clazz.getMethod(METHOD_NAME);
            return (String) method.invoke(instance);
        } catch (Throwable t){
            logger.warn(t.getMessage(), t);
            throw new RuntimeException(t);
        }
    }

    default boolean verify(String dynamicIdentifier, String url) throws NotInPageException{
        if(url.contains(dynamicIdentifier)) {
            logger.info("You expected : " + dynamicIdentifier + " You are in : " + url);
            return true;
        } else {
            logger.warn("You expected : " + dynamicIdentifier + " You are in : " + url);
            report(dynamicIdentifier, url);
            return false;
        }
    }

    default void report(String pageClassName, String url) throws NotInPageException{
        throw new NotInPageException("The page URL is not as expected, you are not in the correct location. " +
                "You expected : " + pageClassName + " You are in : " + url);
    }
}
