package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Verify_checkout_process {

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
		

		WebElement cartIcon = driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]"));
		cartIcon.click();
		
		WebElement cartItemsContainer = driver.findElement(By.xpath( "//a[@class=\"shopping_cart_link\"]")); 
		cartItemsContainer.click();
		
		WebElement Checkout = driver.findElement( By.xpath( "//button[@id=\"checkout\"]"));
		Checkout.click();
		
		WebElement First_name = driver.findElement( By.xpath( "//input[@id=\"first-name\"]"));
		First_name.sendKeys( "SAINAJ");
		
		WebElement  Last_name = driver.findElement( By.xpath( "// input[@id=\"last-name\"]"));
		Last_name.sendKeys( "ANSARI");
		
	   WebElement Zip_code = driver.findElement( By.xpath( " //input[@id=\"postal-code\"]"));
	   Zip_code.sendKeys( "441801");
	   
	   WebElement  continue_button = driver.findElement(By.xpath( " //input[@id=\"continue\"]"));
	   continue_button.click();
	   
	   WebElement confirmationMessage = driver.findElement(By.xpath( "//div[@class=\"summary_info\"]")); // Adjust selector

       if (confirmationMessage.isDisplayed()) {
           System.out.println("Order confirmation page is displayed.");
       } else {
           System.out.println("Order confirmation page was not displayed.");
       }

       // Close the browser
       driver.quit();
	}

}
