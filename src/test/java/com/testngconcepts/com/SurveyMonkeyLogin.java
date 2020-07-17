package com.testngconcepts.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SurveyMonkeyLogin {
	
	WebDriver driver;
	//Page Objects or Object Repository
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.xpath("//button[contains(@type,'submit')]");
	By signUpLink = By.linkText("Sign Up");
	By dashboardLink = By.linkText("Dashboard");
	
	//Invoke Chrome, Maximize, Open Application, deleteCookies
	@BeforeMethod
	public void init_Setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();// Opening new chrome browser
		driver.manage().window().maximize();//maximize application
		driver.manage().deleteAllCookies();//delete all cookies
		driver.get("https://www.surveymonkey.com/user/sign-in/?ut_source=megamenu");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	//Test1--> Verify Title
	@Test(priority=1, enabled=true)
	public void checkApplicationTitle() {
		System.out.println("Checking applcation title");
		String appTitle = driver.getTitle();
		Assert.assertEquals(appTitle, "Log in to your account");
	}
	//Test2--> Verify SignUp
	@Test(priority=2)
	public void signUpText() {
		System.out.println("Checking signup link");
		boolean status = driver.findElement(signUpLink).isDisplayed();
		Assert.assertTrue(status);
	}
	//Test3--> Verify Login is successful
	@Test(priority=3)
	public void login() {
		driver.findElement(username).sendKeys("seleniumtraining1");
		driver.findElement(password).sendKeys("selenium1234");
		driver.findElement(loginButton).click();
		//Verify Login is Successful
		String dashboardText = driver.findElement(dashboardLink).getText();
		Assert.assertEquals(dashboardText, "Dashboard");
	}
	//Close Application
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}