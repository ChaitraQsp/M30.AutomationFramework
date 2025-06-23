package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.By;
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
public class AddProductToCartTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void tc_001_AddproductToCartTest() throws IOException
	{
		// Read The Test Data from excel File
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Inventory", 1, 2);

		// Step 4: Click on product
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnProduct(driver, PRODUCTNAME);
		
		//Step 5: add product to Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();
		
		// Step 5: Navigate to cart
		ip.clickOnCartContainerBtn();

		// Step 6: Validate for the product in Cart
		CartPage cp = new CartPage(driver);
		String productInCart = cp.captureItemName();
		Assert.assertEquals(productInCart, PRODUCTNAME);
		System.out.println(productInCart);
		
		Assert.assertTrue(productInCart.equals(PRODUCTNAME));
		

	}
	
	@Test
	public void sample()
	{
		//Assert.fail();
		System.out.println("demo");
	}

}
