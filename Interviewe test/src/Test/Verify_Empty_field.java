package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Verify_Empty_field {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver","D:\\New Eclipse\\Selenium\\Driver\\chromedriver.exe");

		ChromeOptions co = new ChromeOptions();
		co.addArguments( "--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(co);

		driver.get("https://www.saucedemo.com/"); 

		WebElement usernameField = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
		usernameField.clear();


		WebElement passwordField = driver.findElement(By.xpath("//input[@id=\"password\"]")); 
		passwordField.clear();

		WebElement loginButton = driver.findElement( By.xpath("//input[@id=\"login-button\"]"));
		loginButton.click();

		WebElement errorMessage = driver.findElement(By.className( "error-button"));  


		if (errorMessage.isDisplayed())
		{
			System.out.println("Error message is displayed for empty credentials: " + errorMessage.getText());
		} else 
		{
			System.out.println("Error message is not displayed for empty credentials.");
		}


		driver.quit();

	}

}
