package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import factory.BaseClass;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	  
	
	//Finding WebElements 
//	@FindBy(xpath="(//input[@type='text'])[1]")
//	WebElement searchInputBox;
	
	By search=By.xpath("(//input[@type='text'])[1]");
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement searchInputBox;
	
	@FindBy(xpath="(//button[@type='button' and @aria-label='Submit Search'])[2]") 
	WebElement searchButton;
	
	public String getTitle() {
		String title=driver.getTitle();
		return title;
	}
	
	public boolean isSearchInputBoxPresent() {
		Boolean result=searchInputBox.isDisplayed();
		return result;
	}
	
	public boolean isSearchButtonPresent() {
		Boolean result=searchButton.isDisplayed();
		return result; 
	}
	
	public boolean isSearchInputBoxEnabled() {
		Boolean result=searchInputBox.isEnabled();
		return result;
	}
	
	public boolean isSearchButtonClickable() {
		Boolean result=searchButton.isEnabled();
		return result; 
	}
	
	public void search(String value) {
		searchInputBox.sendKeys(value);
		js.executeScript("arguments[0].click()",searchButton);
	}
	
	public Boolean searchResult(String exp) {
		String result=BaseClass.getDriver().findElement(By.xpath("//div[@class='rc-SearchResultsHeader']//span")).getText();
	    if(result.contains(exp)) {
	    	return true;
	    }else
	    {
	    	return false;
	    }
	}
	
	public void clickSearchInputBox()
	{
		
		searchInputBox.click();
	}
	
	public void searchCourse(String string) throws InterruptedException {
//	{	Thread.sleep(10000);
//		
//			       
//		mywait.until(ExpectedConditions.visibilityOfElementLocated(search));
//		WebElement searchInputBox =wait.until(driver -> driver.findElement(By.xpath("(//input[@type='text'])[1]")));
//		searchInputBox.sendKeys(string);
//	    js.executeScript("arguments[0].value='Web development Courses';",searchButton);
		Thread.sleep(2000);
		System.out.println("A");
//		act.click(searchInputBox).perform();
//		searchInputBox.sendKeys(string);
		System.out.println("D");
		Thread.sleep(2000);
		act.sendKeys(searchInputBox,string).perform();
		System.out.println("B");
	}
	
	public void clickSearchButton() throws InterruptedException
	{
		BaseClass.getLogger().info("Clicking search button");
		Thread.sleep(2000);
		searchInputBox.sendKeys(Keys.ENTER);
		System.out.println("C");
//		js.executeScript("arguments[0].click();",searchButton);

	}
	
	public boolean checkSearchPage() {
		
		if((driver.getTitle()).contains("Coursera"))
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	public void PageClose() {
	      driver.close();
	   }
}
