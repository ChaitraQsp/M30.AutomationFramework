package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class AddLowestPriceProductToCart {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		//create Object of Utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		// Read the Common Data from Property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");

		// Read The Test Data from excel File
		String SORTOPTION = fUtil.readDataFromExcelFile("Inventory", 4, 2);
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Inventory", 4, 3);

		// Step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		// Step 2: Load the URL
		driver.get(URL);

		// Step 3: Login to Application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("login-button")).click();

		// Navigate to dropdown
		WebElement sortDropdwownElement = driver.findElement(By.className("product_sort_container"));
		sUtil.handleDropDown(sortDropdwownElement, SORTOPTION);

		// Click on sorted Product
		driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']")).click();
		driver.findElement(By.id("add-to-cart")).click();

		// Navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();

		// Step 6: Validate for the product in Cart
		String productInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if (productInCart.equals(PRODUCTNAME)) {
			System.out.println(productInCart);
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		// Step 7: Logout of Application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();

	}

}
