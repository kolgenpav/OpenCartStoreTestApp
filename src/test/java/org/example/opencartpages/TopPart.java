package org.example.opencartpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The page with top menu, header and main menu.
 *
 * @author Hennadii Kolomoiets
 */
public class TopPart {
    private static final String shoppingCartLinkLocator = "#top > div.container > div.nav.float-end > ul > li:nth-child(4) > a";
    private final WebElement shoppingCartLink;

    protected final WebDriver driver;

    public TopPart(WebDriver driver) {
        this.driver = driver;
        shoppingCartLink = driver.findElement(By.cssSelector(shoppingCartLinkLocator));
    }

    /**
     * Click on Shopping Cart link in the top menu.
     *
     * @return ShoppingCartEmptyPage object
     */
    public ShoppingCartEmptyPage shoppingCartLinkClick() {
        shoppingCartLink.click();
        return new ShoppingCartEmptyPage(driver);
    }
}
