package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Verify_invalid_login {

	public static void main(String[] args) {
		 
		 System.setProperty("webdriver.chrome.driver","D:\\New Eclipse\\Selenium\\Driver\\chromedriver.exe");

	     ChromeOptions co = new ChromeOptions();
	     co.addArguments( "--remote-allow-origins=*");

	     WebDriver driver = new ChromeDriver(co);
	    
        driver.get("https://www.saucedemo.com/"); 

		WebElement usernameField = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
		usernameField.sendKeys("standard_user2");

		WebElement passwordField = driver.findElement(By.xpath("//input[@id=\"password\"]")); 
		passwordField.sendKeys("secret_sauce1");

		WebElement loginButton = driver.findElement( By.xpath("//input[@id=\"login-button\"]"));
		loginButton.click();
 
        WebElement errorMessage = driver.findElement(By.className("error-button"));  

        
        if (errorMessage.isDisplayed())
        {
            System.out.println("Error message is displayed: " + errorMessage.getText());
        }
        else 
        {
            System.out.println("Error message is not displayed.");
        }
 
        driver.quit();
    }
	}


