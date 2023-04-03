package org.example.opencartpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The empty Shopping Cart page.
 *
 * @author Hennadii Kolomoiets
 */
public class ShoppingCartEmptyPage extends TopPart {
    public static final String EXPECTED_SHOPPING_CART_TITLE = "Shopping Cart";
    public static final String EXPECTED_SHOPPING_CART_EMPTY_LABEL = "Your shopping cart is empty!";
    private static final String shoppingCartEmptyLabelLocator = "#content > p";
    private static final String continueButtonLocator = "#content > div > div > a";

    private WebElement shoppingCartLabel;
    private WebElement shoppingCartEmptyLabel;
    private WebElement continueButton;

    public ShoppingCartEmptyPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        shoppingCartEmptyLabel = driver.findElement(By.cssSelector(shoppingCartEmptyLabelLocator));
        continueButton = driver.findElement(By.cssSelector(continueButtonLocator));
    }

    // Page Object

    // Shopping Cart label
    public WebElement getShoppingCartLabel() {
        return shoppingCartLabel;
    }

    public String getShoppingCartLabelText() {
        return getShoppingCartLabel().getText();
    }

    // Shopping Cart empty label
    public WebElement getShoppingCartEmptyLabel() {
        return shoppingCartEmptyLabel;
    }

    public String getShoppingCartEmptyLabelText() {
        return getShoppingCartEmptyLabel().getText();
    }

    // Continue button
    public WebElement getContinueButton() {
        return continueButton;
    }

    public String getContinueButtonText() {
        return getContinueButton().getText();
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    // Functional

    // Business Logic

    public HomePage leaveShoppingCart() {
        clickContinueButton();
        return new HomePage(driver);
    }
}
