package cz.czechitas.hackaton;

import java.util.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import cz.czechitas.*;

import static org.junit.jupiter.api.Assertions.*;

public class HackatonTest {

    private static WebDriver driver;
    private static HackatonPage hackatonPage;

    private final int maxWaitInSeconds = 10;

    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
        hackatonPage = new HackatonPage(driver);
        hackatonPage.openPage();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("REQ-0021-By clicking login button in header section, user is transfered to „Authentification“ page")
    public void testThereisLoginPage() {
        hackatonPage.login();
        assertEquals("SubmitLogin", hackatonPage.getNameofElementonLoginPage(), "Měli byste být na stránce přihlášení.");
    }

    @ParameterizedTest
    @DisplayName("REQ-0027 – Main sections of home page in correct order")
    @CsvSource({
            "header",
            "xs_room_search_form",
            "hotelInteriorBlock",
            "hotelAmenitiesBlock",
            "hotelRoomsBlock",
            "hotelTestimonialBlock",
            "footer"
    })
    public void testSections(String sectionOnPage) {
        assertTrue(driver.findElement(By.id(sectionOnPage)).isDisplayed(), "Sekce na stránce nejsou správně zobrazeny.");
    }


   @Test
   @DisplayName("REQ-0036 – Login, user is able to SignIn")
   public void loginTest(){

        assertEquals("MY ACCOUNT", hackatonPage.loginComplete(), "Měli byste být na stránce My Account.");
   }

    @Test
    @DisplayName("Website protocol should be https")
    public void testUrlProtocol() {
        driver.  navigate().to(Settings.baseUrl);
        String url = driver.getCurrentUrl();
        assertEquals(Settings.hotelUrl, url, "Tato stranka neni zabezpecena");
    }









}










