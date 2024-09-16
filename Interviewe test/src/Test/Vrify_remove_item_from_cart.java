package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Vrify_remove_item_from_cart {

	public static void main(String[] args) throws InterruptedException
	{
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

		WebElement cartIcon = driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]")); 

		cartIcon.click();

		WebElement cartItemsContainer = driver.findElement(By.xpath( "//a[@class=\"shopping_cart_link\"]")); 

		int initialItemCount = cartItemsContainer.findElements(By.className("cart-item-class")).size();  


		WebElement firstItemRemoveButton = cartItemsContainer.findElement(By.xpath( "//button[@id=\"remove-sauce-labs-backpack\"]"));
		firstItemRemoveButton.click();


		Thread.sleep(2000);  

		int updatedItemCount = cartItemsContainer.findElements(By.className("cart-item-class")).size(); // Adjust the selector

		if (updatedItemCount == initialItemCount - 1) 
		{
			System.out.println("Item successfully removed from the cart.");
		} 
		else
		{
			System.out.println("Item removal failed or cart count did not update correctly.");
		}

		driver.quit();
	}



}
