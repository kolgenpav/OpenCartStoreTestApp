package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Map;

/**
 * Go to the site
 * <a href="https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/">...</a>
 * In the first table (Uncontrolled Mode item), enter the letter L in the City filter.
 * Check the presence in the column of the cities of Las Vegas and London.
 * <p>
 * You can test with Chrome or Firefox browser - choose in setClass() method.
 *
 * @author Hennadii Kolomoiets
 */
public class CityFilterTest {
//    public static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static WebDriver driver;
    private static Map<String, Object> vars;
    static JavascriptExecutor js;

    @BeforeAll
    public static void setClass() {
        //Uncomment for Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Uncomment for Firefox
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDownClass() {
        if (driver != null) {
            driver.quit(); // close()
        }
    }

    @BeforeEach
    public void setUp() {
        // Open site
        driver.get("https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/");
    }

    @DisplayName("Las Vegas OR London city presence verifying after filter with first city name letter")
    @Test
    public void cityFilterTest() {
        //click on cookie button if present
        List<WebElement> cookieButton = driver.findElements(By.cssSelector(".cookie-module--button--3dBOi"));
        if (!cookieButton.isEmpty()) {
            cookieButton.get(0).click();
        }
        //selectFrame with cities table
        driver.switchTo().frame(0);
        //find city name filter input field
        String cityFilterCssSelector = "table.MuiTable-root > thead > tr:nth-child(2) > th:nth-child(3) > div > div > input";
        WebElement cityFilter = driver.findElement(By.cssSelector(cityFilterCssSelector));
        // type "L" letter to the city name filter
        cityFilter.sendKeys("L");
        // Find cells with cities that start with "L"
        String lCityCsselectorPrefix = ".MuiTableRow-root:nth-child(";
        String lCityCsselectorSuffix = ") > .MuiTableCell-body:nth-child(3)";
        List<WebElement> lCities;
        int lCityCount = 1;
        do {
            lCities = driver.findElements(By.cssSelector(lCityCsselectorPrefix + lCityCount + lCityCsselectorSuffix));
            if (lCities.size() > 0) {
                WebElement LCity = lCities.get(0);
                String lCityName = LCity.getText();
                System.out.println(lCityCount + " city is " + lCityName);
                Assertions.assertTrue("Las Vegas".equals(lCityName)
                        || "London".equals(lCityName));
                lCityCount++;
            }
        } while (lCities.size() > 0);
    }
}
