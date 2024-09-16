package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Verify_Add_to_cart {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\New Eclipse\\Selenium\\Driver\\chromedriver.exe");

		ChromeOptions co = new ChromeOptions();
		co.addArguments( "--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(co);

		driver.get("https://www.saucedemo.com/"); 

		WebElement usernameField = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
		usernameField.sendKeys("standard_user");

		WebElement passwordField = driver.findElement(By.xpath("//input[@id=\"password\"]")); 
		passwordField.sendKeys("secret_sauce");

		WebElement loginButton = driver.findElement( By.xpath("//input[@id=\"login-button\"]"));
		loginButton.click();

		WebElement productLink = driver.findElement(By.linkText("Sauce Labs Backpack"));  
		productLink.click();
		
		WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")); // Locate the correct button for the product
		addToCartButton.click();


		WebElement cartCount = driver.findElement(By.className("shopping_cart_badge")); // Adjust the locator if necessary
		String count = cartCount.getText();

		if (count.equals("1")) 
		{
			System.out.println("Cart count is correct: " + count);
		}
		else
		{
			System.out.println("Cart count is incorrect. Expected: 1, Found: " + count);
		}


		driver.quit();

	}

}
