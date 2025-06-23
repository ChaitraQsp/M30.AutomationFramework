package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProductToCart {
	
	public static void main(String[] args) {
		
		//Step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step 2: Load the URL
		driver.get("https://www.saucedemo.com/");
		
		//Step 3: Login to Application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
		
		//Step 4: Add Product to Cart
		driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).click();
		driver.findElement(By.xpath("//button[.='Add to cart']")).click();
		
		//Step 5: Navigate to  cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//Step 6: Validate for the product in Cart
		String productInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if(productInCart.equals("Sauce Labs Backpack"))
		{
			System.out.println(productInCart);
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Step 7: Logout of Application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		
	}

}
