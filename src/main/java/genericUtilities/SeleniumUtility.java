package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to Selenium tool
 * @author Chaitra M
 *
 */
public class SeleniumUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will add implicitly wait for 10 seconds
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10 seconds for the Webelement to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for 10 seconds for the Webelement to be Clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by visible Text
	 * @param element
	 * @param VisibleText
	 */
	public void handleDropDown(WebElement element, String VisibleText)
	{
		Select s = new Select(element);
		s.selectByVisibleText(VisibleText);
	}
	
	/**
	 * This method will handle dropdown by value
	 * @param element
	 * @param VisibleText
	 */
	public void handleDropDown(String value, WebElement element)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will perform mouse hovering Action on a web element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	//drag and drop , Double click, right click, click and hold, release, scroll
	
	/**
	 * This method will perform Drag and drop Action 
	 * @param driver
	 * @param src Element
	 * @param target Element
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcEle, WebElement tarEle)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcEle,tarEle).perform();
	}
	
	/**
	 * This method will perform double Click Action on a web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform Right click Action on a web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform click and hold Action on a web element
	 * @param driver
	 * @param element
	 */
	public void ClickAndHoldAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	/**
	 * This method will perform release Action on a web element
	 * @param driver
	 * @param element
	 */
	public void releaseAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.release(element).perform();
	}
	
	/**
	 * This method will perform scroll Action on a webelement
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	/**
	 * This method will handle Frame by frame index
	 * @param driver
	 * @param frameindex
	 */
	public void handleFrame(WebDriver driver, int frameindex)
	{
		driver.switchTo().frame(frameindex);
	}
	
	/**
	 * This method will handle Frame by frame name or ID
	 * @param driver
	 * @param frameNameOrId
	 */
	public void handleFrame(WebDriver driver, String frameNameOrId)
	{
		driver.switchTo().frame(frameNameOrId);
	}
	
	/**
	 * This method will handle Frame by Frame Element
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method will switch to immediate parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will accept Alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel Alert pop up
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will enter data into Alert pop up
	 * @param driver
	 * @param data
	 */
	public void enterAlertData(WebDriver driver, String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	
	/**
	 * This method will capture the text from Alert pop up and return to caller
	 * @param driver
	 * @return text
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will switch to the required window
	 * @param driver
	 * @param windowID
	 */
	public void switchToWindow(WebDriver driver, String windowID)
	{
		driver.switchTo().window(windowID);
		
	}
	
	/**
	 * This method will scroll down the page by 500 units
	 * @param driver
	 */
	public void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);", "");		
	}
	
	/**
	 * This method will capture the screenshot and return the path to Caller
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws IOException
	 */
	public String captureScreenshot(WebDriver driver, String screenshotname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+screenshotname+".png");
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath(); //For Extent Reports
	}
	
	
	
	
	
	
	
	
	

}
