package common.selenium_services.page;

import common.page_objects.*;
import org.apache.log4j.Logger;

public final class PageFactory implements PageVerifiable {

    private final String PREPARE_ELEMENTS_METHOD_NAME = "prepareElements";

    private final static Logger logger = Logger.getLogger(PageFactory.class);

    public <T extends Pageable> T createPage(Page page) {

        T instance = null;
        try {
            instance = (T) page.getClazz().newInstance();
            page.getClazz().getMethod(PREPARE_ELEMENTS_METHOD_NAME).invoke(instance);
            logger.info("Page " + instance.toString() + " created successfully");
            if (page.isValidateOnPage) {
                PageVerifiable.super.validateInPage(instance, page.clazz);
            }
        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
        }
        return instance;
    }

    public enum Page {

        HOME (HomePage.class, true),
        LOGIN (LoginPage.class, false),
        SIGN_UP(SignUpPage.class, true),
        SUPERMARKET(SupermarketPage.class, true),
        SEARCH(SearchPage.class, true),
        MILK_RESULTS(MilkResultsPage.class, true),
        REMOVE_FROM_CART(RemoveFromCartPage.class, false),

        CART(CartPage.class, true),
        CONNECT (ConnectPage.class, false);

        private Class<? extends Pageable> clazz;
        private boolean isValidateOnPage;

        Page(Class<? extends Pageable> clazz, boolean isValidateOnPage){
            this.setClazz(clazz);
            this.isValidateOnPage = isValidateOnPage;
        }

        public Class<? extends Pageable> getClazz() {
            return clazz;
        }

        public void setClazz(Class<? extends Pageable> clazz) {
            this.clazz = clazz;
        }
    }

}