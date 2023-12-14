package stepdefinations;

import TestUtilities.CommonUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Hooks {
	
	CommonUtilities cb=new CommonUtilities();
	Properties objectRepo=new Properties();
	@Before
	public void testsetup() {
		cb.launchApplication();
	}
	
	@After
	public void AftertestActions() {
		cb.closeApp();
		
	}
}
