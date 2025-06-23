package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

/**
 * This class consists of basic configuration annotations of testng
 * @author Chaitra M
 *
 */
public class BaseClass {
	
	public FileUtility fUtil = new FileUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public JavaUtility jUtil = new JavaUtility();
	
	public WebDriver driver;
	
	//For listeners
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("-------- Database connection successful --------");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String pvalue*/) throws IOException
	{
		String URL = fUtil.readDataFromPropertyFile("url");
		
		//driver = new EdgeDriver();
		
		//For cross crowser execution
//		if(pvalue.equals("firefox"))
//		{
			driver = new FirefoxDriver();
//		}
//		else if(pvalue.equals("edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else
//		{
//			driver = new EdgeDriver();
//		}
		
		
		sUtil.maximizeWindow(driver);;
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
		
		//For Listeners
		sdriver=driver;
		
		System.out.println("-------- Browser launch successful --------");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
	
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("-------- Login to Application successful --------");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApp();
		
		System.out.println("-------- Logout of Application successful --------");
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("-------- Browser closure successful --------");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("-------- Database closure successful --------");
	}
}
