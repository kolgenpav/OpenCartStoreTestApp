package org.example.opencartpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * THe empty Shopping Cart page.
 *
 * @author Hennadii Kolomoiets
 */
public class ShoppingCartEmptyPage extends TopPart {
    private static final String shoppingCartTitle = "Shopping Cart";
    private static final String shoppingCartEmptyLabelLocator = "#content > p";
    private static final String continueButtonLocator = "#content > div > div > a";

    private final WebElement shoppingCartEmptyLabel;
    private final WebElement continueButton;

    public ShoppingCartEmptyPage(WebDriver driver) {
        super(driver);
        shoppingCartEmptyLabel = driver.findElement(By.cssSelector(shoppingCartEmptyLabelLocator));
        continueButton = driver.findElement(By.cssSelector(continueButtonLocator));
        if (!shoppingCartTitle.equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the Shopping Cart page");
        }
    }

    /**
     * Gets empty Shopping Cart label.
     *
     * @return empty Shopping Cart label: "Your shopping cart is empty!"
     */
    public WebElement getShoppingCartEmptyLabel() {
        return shoppingCartEmptyLabel;
    }

    /**
     * Click on the Continue button in Shopping Cart empty page.
     *
     * @return HomePage object
     */
    public HomePage continueButtonCLick() {
        continueButton.click();
        return new HomePage(driver);
    }
}
