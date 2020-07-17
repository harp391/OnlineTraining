package webDriverPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstWebDriverCode {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		//TopCasting
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		String win = driver.getWindowHandle();
		System.out.println(win);
		
		driver.quit();
		driver.close();
		
		/*WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver();*/
	}

}
