package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Verify_view_catr {

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

		WebElement cartIcon = driver.findElement(By.xpath( "//button[@id=\"add-to-cart-sauce-labs-backpack\"]")); 
		cartIcon.click();


		WebElement cartItemsContainer = driver.findElement(By.xpath( "//a[@class=\"shopping_cart_link\"]")); 


		List<WebElement> cartItems = cartItemsContainer.findElements(By.className("cart-item-class"));  

		for (WebElement item : cartItems) 
		{
			System.out.println(item.getText());
		}


		String[] expectedItems = {"Product 1", "Product 2", "Product 3"};

		for (String expectedItem : expectedItems) 
		{
			boolean itemFound = cartItems.stream()
					.anyMatch(item -> item.getText().contains(expectedItem));

			if (!itemFound) 
			{
				System.out.println("Item not found: " + expectedItem);
			}
		}


		driver.quit();


	}

}
