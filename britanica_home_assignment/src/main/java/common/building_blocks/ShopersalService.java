package common.building_blocks;


import common.page_objects.*;
import common.selenium_services.page.PageFactory;

/**
 * Created by asih on 8/31/2017.
 */
public class ShopersalService {

    private static final ShopersalService INSTANCE = new ShopersalService();

    private PageFactory pageFactory = new PageFactory();

    private LoginPage loginPage;

    private HomePage homePage;

    private SignUpPage signUpPage;

    private ConnectPage connectPage;

    private SupermarketPage supermarketPage;

    private SearchPage searchPage;

    private MilkResultsPage milkResultsPage;

    private CartPage cartPage;


    private ShopersalService() {
        // Avoid reflection calls on Singleton(
        // Private constructor can be called by reflection
        // Solve thread safe issues
        if (INSTANCE != null) {
            return;
        }
    }

    public static ShopersalService getInstance() {
        return INSTANCE;
    }

    public final void signUp(String firstName, String lastName, String id, String phone, String email, String url, String password){
        signUpPage = pageFactory.createPage(PageFactory.Page.SIGN_UP);
        signUpPage.signUp(firstName, lastName, id, phone, email, url, password);
    }

    public void connect() {
        homePage = pageFactory.createPage(PageFactory.Page.HOME);
        homePage.connect();
    }

    public void login(String userName, String password) {
        loginPage = pageFactory.createPage(PageFactory.Page.LOGIN);
        loginPage.login(userName, password);
    }

    public void goToSupermarket() {
        homePage = pageFactory.createPage(PageFactory.Page.HOME);
        homePage.goToSupermarket();
    }

    public void getMilkProduct() {
        supermarketPage = pageFactory.createPage(PageFactory.Page.SUPERMARKET);
        supermarketPage.getMilkProduct();
    }

    public void search(String searchVal) {
        searchPage = pageFactory.createPage(PageFactory.Page.SEARCH);
        searchPage.search(searchVal);
    }

    public void sort(MilkResultsPage.SortOption sortOption) {
        milkResultsPage = pageFactory.createPage(PageFactory.Page.MILK_RESULTS);
        milkResultsPage.sort(sortOption);
    }

    public void addLowestToChart() {
        milkResultsPage = pageFactory.createPage(PageFactory.Page.MILK_RESULTS);
        milkResultsPage.addLowestToChart();
    }

    public void verifyCart(Float expectedPrice) {
        cartPage = pageFactory.createPage(PageFactory.Page.CART);
        cartPage.verifyCartPrice(expectedPrice);
    }






//    public void connect() {
//        connectPage = pageFactory.createPage(PageFactory.Page.CONNECT);
//        connectPage.connect();
//
//    }
//
//    public final void signUp() {
//        homePage = pageFactory.createPage(PageFactory.Page.HOME);
//        homePage.signUp();
//    }

//    public final void signUp(String userName, String password) {
////        signIn();
//        login(userName, password);
//    }

//    public void enterSummerDressMenu(ShoppingStoreMenu.ShopMenu shopMenu) {
//        shoppingStoreMenu = pageFactory.createPage(PageFactory.Page.SHOPPING_STORE_MENU);
//        shopMenu.enterSummerDressMenu(shopMenu);

//    public final void doShoppingFlow() {
//        summerDressPage = pageFactory.createPage(PageFactory.Page.SUMMER_DRESS);
//        summerDressPage.doShoppingFlow();
//    }

//    public final void approvePurchaseDiscount() {
//        purchaseApprovalPage = pageFactory.createPage(PageFactory.Page.PURCHASE_APPROVAL);
//        purchaseApprovalPage.approveDiscount();
//    }

}

