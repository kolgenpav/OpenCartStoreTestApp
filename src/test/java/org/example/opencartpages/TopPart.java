package org.example.opencartpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The page part with top menu, header and main menu.
 *
 * @author Hennadii Kolomoiets
 */
public abstract class TopPart {
    private static final String shoppingCartLinkLocator = "#top > div.container > div.nav.float-end > ul > li:nth-child(4) > a";
    private WebElement shoppingCartLink;

    protected final WebDriver driver;

    public TopPart(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        shoppingCartLink = driver.findElement(By.cssSelector(shoppingCartLinkLocator));
    }

    // Page Object

    // shoppingCart
    public WebElement getShoppingCartLink() {
        return shoppingCartLink;
    }

    public String getShoppingCartLinkText() {
        return getShoppingCartLink().getText();
    }

    public void clickShoppingLinkCart() {
        getShoppingCartLink().click();
    }

    // Functional

    // Business Logic

    /**
     * Click on Shopping Cart link in the top menu.
     *
     * @return ShoppingCartEmptyPage object
     */
    public ShoppingCartEmptyPage shoppingCartLinkClick() {
        clickShoppingLinkCart();
        return new ShoppingCartEmptyPage(driver);
    }
}
