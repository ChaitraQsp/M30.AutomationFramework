package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplementationUtility.class)
public class AddLowestPriceProductToCartTest extends BaseClass{

	@Test(groups = "RegreesionSuite")
	public void tc_002_AddLowestPriceProductToCartTest() throws IOException	
	{
		// Read The Test Data from excel File
		String SORTOPTION = fUtil.readDataFromExcelFile("Inventory", 4, 2);
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Inventory", 4, 3);

		// Step 4: Click on product
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnLowestPricedProduct(driver, SORTOPTION, PRODUCTNAME);

		// Step 5: add product to Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		// Step 5: Navigate to cart
		ip.clickOnCartContainerBtn();

		// Step 6: Validate for the product in Cart
		CartPage cp = new CartPage(driver);
		String productInCart = cp.captureItemName();
		Assert.assertEquals(productInCart, PRODUCTNAME);
		System.out.println(productInCart);
		


	}

}
