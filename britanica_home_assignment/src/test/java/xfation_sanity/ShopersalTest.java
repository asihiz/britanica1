package xfation_sanity;

import common.building_blocks.ShopersalService;
import common.page_objects.MilkResultsPage;
import common.selenium_services.driver.SeleniumDriver;
import common.test.BaseTest;
import org.junit.*;
import org.junit.runners.MethodSorters;
import util.general_util.GeneralUtils;

/**
 * Created by asi on 2/19/2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShopersalTest extends BaseTest {

    private ShopersalService shopersalService = ShopersalService.getInstance();
    private String userName;
    private String password;

    @BeforeClass
    public static void beforeClass ()  {
        BaseTest.beforeClass();
    }

    @Before
    public void setUp() {
        super.before(SeleniumDriver.DriverType.CHROME, SeleniumDriver.OS.WINDOWS);
        userName = GeneralUtils.getRandomEmail();
    }

    @Test
    public void shupersalFlowTest() {
//        shopersalService.signUp(FIRST_NAME, LAST_NAME, ID, PHONE, userName, BASE_CLIENT_URL, CLIENT_PASSWORD);
        shopersalService.connect();
        shopersalService.login(CLIENT_USER, CLIENT_PASSWORD);
        shopersalService.goToSupermarket();
        shopersalService.getMilkProduct();
        shopersalService.search("חלב");
        shopersalService.sort(MilkResultsPage.SortOption.FROM_LOW_TO_HIGH);
        shopersalService.addLowestToChart();
        shopersalService.verifyCart(32.00F);
        shopersalService.removeFromCart();
    }


    @After
    public void tearDown()  {
        super.closeDriver();
    }

    @AfterClass
    public static void after() {
        try {
            SeleniumDriver.getInstance().close();
        } catch (Exception e) {

        }


    }

}