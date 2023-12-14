package stepdefinations;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import TestUtilities.CommonUtilities;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RedBusTestMethods {

	CommonUtilities cb=new CommonUtilities();
	Properties objectRepo=new Properties();
	public RedBusTestMethods(){
		try {
			FileInputStream input=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\TestUtilities\\objectRepository.properties");
			objectRepo.load(input);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage()+ ":ObjectRepo File Not Found");
		}
	}

	
	@When("Login To Account")
	public void login_account(){	
		List<WebElement> skipEle=CommonUtilities.driver.findElements(By.id(objectRepo.getProperty("skiplocation_id")));
		if(skipEle.size()>0)
			skipEle.get(0).click();
		
		List<WebElement> skipPopup=CommonUtilities.driver.findElements(By.id(objectRepo.getProperty("skip_rating_id")));
		if(skipPopup.size()>0)
			skipPopup.get(0).click();
		
		WebElement acc=CommonUtilities.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectRepo.getProperty("acc"))));
		acc.click();
				
		WebElement loginBtn=CommonUtilities.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(objectRepo.getProperty("login_id"))));
		loginBtn.click();
		
		WebElement googleLogin=CommonUtilities.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectRepo.getProperty("google_Login"))));
		googleLogin.click();
				
		List<WebElement> chooseAccount=CommonUtilities.driver.findElements(By.xpath(objectRepo.getProperty("Choose_Account")));
		if(chooseAccount.size()>0)
			chooseAccount.get(0).click();
	}
	
	
	
	@Then("Profile Page is Displayed")
	 public void validate_profilePage() {
		
		Assert.assertTrue(CommonUtilities.driver.findElements(By.id(objectRepo.getProperty("Login_Details_id"))).size()>0,"Profile details not displayed");
		System.out.println("Profile Details are properly displayed");
		
		cb.scrollAndClick("Logout");
		
		WebElement logout_Popup=CommonUtilities.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(objectRepo.getProperty("Logoutpopup_id"))));
		logout_Popup.click();
	}
	
	
	@When("Search Buses for {string}")
	public void search_bus(String actualdate) {
		WebElement home=CommonUtilities.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectRepo.getProperty("Home"))));
		home.click();
		WebElement from_loc=CommonUtilities.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectRepo.getProperty("From_Loc"))));
		from_loc.click();
		WebElement searchFromLoc=CommonUtilities.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(objectRepo.getProperty("Search_Loc_id"))));
		searchFromLoc.sendKeys("Sangamwadi");
		
		List<WebElement> l=CommonUtilities.driver.findElements(By.id(objectRepo.getProperty("Loc_Res_id")));
		for(WebElement e:l)
		{
			if(e.getText().contains("Sangamwadi"))
				{
					e.click();
					break;
				}
		}
		
		WebElement to_loc=CommonUtilities.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectRepo.getProperty("To_Loc"))));
		to_loc.click();
		WebElement searchToLoc=CommonUtilities.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(objectRepo.getProperty("Search_Loc_id"))));
		searchToLoc.sendKeys("Mumbai");
		
		l.clear();
		l=CommonUtilities.driver.findElements(By.id(objectRepo.getProperty("Loc_Res_id")));
		for(WebElement e:l)
		{
			if(e.getText().contains("Mumbai"))
				{
					e.click();
					break;
				}
		}
		
		
		WebElement date=CommonUtilities.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectRepo.getProperty("Date"))));
		date.click();
		
		String dateStamp = LocalDate.now().plusDays(Integer.parseInt(actualdate.substring(12))).format(DateTimeFormatter.ofPattern("dd"));

		List<WebElement> days=CommonUtilities.driver.findElements(By.id(objectRepo.getProperty("Days_id")));
		int f=0;
		for(WebElement day: days)
		{
			String text=day.getText();
			if(text.length()==1)
				text='0'+text;
			if(text.equals(dateStamp))
			{
				day.click();
				f++;
				break;
			}
		}
		
	}
	
	
	@Then("Bus Details are Displayed")
	public void bus_details_are_displayed() {
	    String busCount=CommonUtilities.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectRepo.getProperty("Bus_Count")))).getText();
	    Assert.assertTrue(Integer.parseInt(busCount.split(" Buses")[0])>0,"Bus info not available");
	    System.out.println(busCount +" on this route");
	    
	    WebElement backBtn=CommonUtilities.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectRepo.getProperty("BackBtn"))));
	    backBtn.click();
	    
	    WebElement acc=CommonUtilities.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectRepo.getProperty("acc"))));
		acc.click();
	    
	    cb.scrollAndClick("Logout");
		
		WebElement logout_Popup=CommonUtilities.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(objectRepo.getProperty("Logoutpopup_id"))));
		logout_Popup.click();
	   
	}
	
	
}
