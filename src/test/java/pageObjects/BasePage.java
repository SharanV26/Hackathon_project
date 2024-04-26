package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	   public WebDriver driver;
	   public WebDriverWait mywait;
	   public JavascriptExecutor js;
//	   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	   public FluentWait<WebDriver> wait;
	   public Actions act;
    
	   public BasePage(WebDriver driver){    //Initializing driver,wait,JS,PageFactory
		   
		     this.driver=driver;
		     mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		     wait=new FluentWait<WebDriver>(driver);
		     wait.withTimeout(Duration.ofSeconds(30));
	         wait.pollingEvery(Duration.ofSeconds(5));
		      wait.ignoring(NoSuchElementException.class);
			 js=(JavascriptExecutor) driver;
			 act=new Actions(driver);
		     PageFactory.initElements(driver,this);
	   }
}
