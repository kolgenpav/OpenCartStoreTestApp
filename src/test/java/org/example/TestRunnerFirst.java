package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.opencartpages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * The common functionality for OpenCart site tests.
 */
public class TestRunnerFirst {
    private final String BASE_URL = "https://demo.opencart.com/";
    public static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static WebDriver driver;

    @BeforeAll
    public static void setClass() {
        //Uncomment for Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Uncomment for Firefox
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDownClass() {
        if (driver != null) {
            driver.quit(); // close()
        }
    }

    @BeforeEach
    public void setUp() {
        // Open site
        driver.get(BASE_URL);
    }

    protected HomePage loadApplication() {
        return new HomePage(driver);
    }
}
