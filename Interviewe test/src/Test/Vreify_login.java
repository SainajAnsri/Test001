package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Vreify_login {

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

	    System.out.println(" Verify that the user is redirected to the products page");
		   
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.saucedemo.com/"))
        {  
            System.out.println("User successfully redirected to the products page.");
        } else 
        {
            System.out.println("Failed to redirect to the products page.");
        }
        driver.navigate().to("https://www.saucedemo.com/");
        
        System.out.println(" Verify that the username is displayed");
        
     
        WebElement loggedInUser = driver.findElement(By.id("user-name"));
        
        if (loggedInUser.isDisplayed())
        {
            System.out.println("Username is displayed.");
        } 
        else
        {
            System.out.println("Username is not displayed.");
        }
 
        driver.quit();
    }

	}


