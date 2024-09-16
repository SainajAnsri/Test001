package Test;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 
public class Verify_product_visiablity {

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

		 WebElement productList = driver.findElement(By.className("inventory_list")); 
	        if (productList.isDisplayed()) 
	        {
	            System.out.println("Product list is displayed.");
	        } else {
	            System.out.println("Product list is not displayed.");
	            driver.quit();
	            return;
	        }
	        
	        List<WebElement> products = driver.findElements(By.xpath( "//div[@class=\"inventory_list\"]"));  

	        boolean sauceLabsBackpackFound = false;
	        boolean sauceLabsBikeLightFound = false;

	        for (WebElement product : products) {
	            String productName = products.getText();
	            if (productName.equals("Sauce Labs Backpack"))
	            {
	                sauceLabsBackpackFound = true;
	            }
	            else if (productName.equals("Sauce Labs Bike Light"))
	            {
	                sauceLabsBikeLightFound = true;
	            }
	        

	        // Check if both products were found
	        if (sauceLabsBackpackFound && sauceLabsBikeLightFound)
	        {
	            System.out.println("All expected products are present on the page.");
	        } 
	        else 
	        {
	            System.out.println(" All expected products are missing.");
	             
	        }

	        // Close the browser
	        driver.quit();
	    }

	}
}


