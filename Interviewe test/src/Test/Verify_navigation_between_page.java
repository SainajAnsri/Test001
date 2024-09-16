package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Verify_navigation_between_page {

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

	 
		WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")); // Locate the correct button for the product
		addToCartButton.click();
		
		WebElement cart_count_icon = driver.findElement( By.xpath( "//a[@class=\"shopping_cart_link\"]"));
		cart_count_icon.click();
		
		WebElement product_page = driver.findElement( By.xpath( "//button[@id=\"react-burger-menu-btn\"]"));
		product_page.click();
		
		WebElement all_product = driver.findElement( By.xpath( "//a[@id=\"inventory_sidebar_link\"]"));
		all_product.click();
		 
	        if (driver.getTitle().contains("Cart Page"))
	        {  
	            System.out.println("Cart page loaded successfully.");
	        } else {
	            System.out.println("Failed to load cart page.");
	        }

 
	        driver.quit();
	    

	}

}
