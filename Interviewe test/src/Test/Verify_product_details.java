package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Verify_product_details {

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


		WebElement productName = driver.findElement(By.className("inventory_details_name")); 
		WebElement productDescription = driver.findElement(By.className("inventory_details_desc"));
		WebElement productPrice = driver.findElement(By.className("inventory_details_price"));

		String expectedProductName = "Sauce Labs Backpack";
		String expectedProductDescription = "Carry all the things with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
		String expectedProductPrice = "$29.99";


		if (productName.getText().equals(expectedProductName)) {
			System.out.println("Product name is correct: " + productName.getText());
		}
		else 
		{
			System.out.println("Product name is incorrect. Expected: " + expectedProductName + ", Found: " + productName.getText());
		}


		if (productDescription.getText().equals(expectedProductDescription)) 
		{
			System.out.println("Product description is correct.");
		} 
		else 
		{
			System.out.println("Product description is incorrect.");
		}

		if (productPrice.getText().equals(expectedProductPrice)) {
			System.out.println
			("Product price is correct.");
		} 
		else 
		{
			System.out.println("Product price is incorrect. Expected: ");
		}


		driver.quit();
	}


}


