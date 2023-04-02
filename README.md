# OpenCartStoreTestApp

 This is repository for Teacher`s TAQC
 Selenium WebDriver Assignment
 and WebDriver Waits Assignment
 and Page-Object Approach Assignment

### Requirements - Selenium WebDriver Assignment:
Prepare a test method with the following scenario.
1. Go to https://demo.opencart.com/
2. Select currency Euro.
3. Click on the Desktops and Mac menu.
4. Check whether the product "iMac" at the price of 111.55 euros is present on the page.

### Requirements - WebDriver Waits Assignment:
1. Go to the site
   https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/
2. In the first table (Uncontrolled Mode item), enter the letter L in the City filter.
3. Check the presence in the column of the cities of Las Vegas and London.

### Requirements - Page-Object Approach Assignment:
1. Write a PageObject class of ShoppingCartEmptyPage that corresponds to an empty Shopping Cart page.
   The class must inherit from the TopPart.java base class.
2. Add three fields (webelements) to the class:
   - Label: Shopping Cart
   - Label: Your shopping cart is empty!
   - Button: Continue.
3. Implement the constructor, methods for obtaining the text of the fields, click on the Continue button.
4. When you click on Continue, go to HomePage.

   Prepare the following test script:
1. go to https://demo.opencart.com/ get HomePage
2. in the main menu of the HomePage, click on Shopping Cart
3. Check that the page is empty (check the content of the label: "Your shopping cart is empty!")
4. click on the Continue button
5. Make sure the HomePage is loaded.

### Info - Selenium WebDriver Assignment:
1. There are 3 test: 
- with CSS, 
- with XPath,
- with combined locators.
The iMacPriceVerifyByCombinedLocators() is optimal.
2. You can test with Chrome or Firefox browser - choose in setClass() method.

### Info - WebDriver Waits Assignment:
1. Test passes without any Wait objects.
2. You can test with Chrome or Firefox browser - choose in setClass() method.

### Info - Page-Object Approach Assignment:
1. The PageObject model classes are located in the org.example.opencartpages package.
2. In the ShoppingCartEmptyPage and HomePage constructors the verifying of the objects by its titles was organized.
3. You can test with Chrome or Firefox browser - choose in setClass() method.