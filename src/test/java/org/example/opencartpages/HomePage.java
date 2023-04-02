package org.example.opencartpages;

import org.openqa.selenium.WebDriver;

/**
 * The home page.
 *
 * @author Hennadii Kolomoiets
 */
public class HomePage extends TopPart {

    private static final String homePageTitle = "Your Store";
    public HomePage(WebDriver driver) {
        super(driver);
        if (!homePageTitle.equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the Home page");
        }
    }
}
