package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
	
	private static WebDriver driver = null;
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver","D:/Selenium/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.store.demoqa.com");
		driver.manage().window().maximize();
		
	}

	
	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		driver.findElement(By.className("account_icon")).click();
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_UserName_and_Password(String uname1, String pass1) throws Throwable {
		driver.findElement(By.id("log")).sendKeys(uname1); 
		 driver.findElement(By.id("pwd")).sendKeys(pass1);
		 driver.findElement(By.id("login")).click();
		 
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Login Successfully");
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		Thread.sleep(5000);
		driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
		System.out.println("LogOut Successfully");
	}


	
	

}
