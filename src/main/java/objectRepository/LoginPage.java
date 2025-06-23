package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule - 1 create a seperate Pom Class for every web page
	
	//Rule 2: Identify the web elements using @FindBy, @FindBys, @FindAll
	
	//Declaration 
	@FindBy(id = "user-name") 
	private WebElement usernameEdt;
	
	//@FindAll - for identifying single web element with multiple locators - OR operator
	//Auto healing process
	//@FindAll({@FindBy(id = "user-name"),@FindBy(name = "user-name")})
	//private WebElement usernametf;
	
	//@FindBys - for identifying single web element with multiple locators - AND operator
	//@FindBys({@FindBy(id = "user-name"),@FindBy(name = "user-name")})
	//private WebElement usernametf;
	
	@FindBy(id = "password")
	private WebElement passwordEdt;
	
	@FindBy(name = "login-button")
	private WebElement loginBtn;
	
	//Rule 3: Create a constructor for element initialization
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4: Provide Getters to access the web elements
	
	//Utilization
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Library - reusable method - specific to project
	
	/**
	 * This method will perform login operation
	 * @param un
	 * @param pwd
	 */
	public void loginToApp(String un,String pwd)
	{
		usernameEdt.sendKeys(un);
		passwordEdt.sendKeys(pwd);
		loginBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
