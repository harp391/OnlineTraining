package webDriverPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleAppCheck {

	public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        
        driver.get("http://www.google.ca");
        
       String appTitle = driver.getTitle();
       System.out.println("Application Title is: "+appTitle);
       
       if (appTitle.equalsIgnoreCase("google")) {
		System.out.println("Pass");
	} else {
		System.out.println("Fail");
	}
       driver.close();
	}

}
