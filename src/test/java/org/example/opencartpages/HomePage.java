package org.example.opencartpages;

import org.openqa.selenium.WebDriver;

/**
 * The home page - dummy.
 *
 * @author Hennadii Kolomoiets
 */
public class HomePage extends TopPart {

    public static final String EXPECTED_HOMEPAGE_TITLE = "Your Store";
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Page Object

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    // Functional

    // Business Logic

}
