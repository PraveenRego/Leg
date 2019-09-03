
package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.adminbuilder.Pages.MarketPlace;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Then;

public class stepdefMarketPlace{
	Logger Log = Logger.getLogger("stepdefMarketPlace.class");
	PageObjectManager pageObjectManager; 
	MarketPlace marketplace;
	TestContext testContext;
	public stepdefMarketPlace(TestContext context) {
		 testContext = context;
		 marketplace = testContext.getPageObjectManager().getMarketPlace();
		 }
	 @Then("^I enter the market name as \"([^\"]*)\"$") 
	 public void click_markets(String MarketName) throws InterruptedException { 
		marketplace.selectLTSSadmin();
		 marketplace.click_markets(MarketName);
	   
	 }
	 
	 @Then("^validating Market List page$") 
	   public void MarketListPage() throws Exception {
		 marketplace.selectLTSSadmin();
		marketplace.validate_MarketList();
	} 
	 
	@Then("^Validating the \"([^\"]*)\" Market Specific Page$")
	 public void MarketPage(String MarketName) throws Exception {
		 
		marketplace.validate_MarketSpecificPage(MarketName);
	} 
	
	@Then("^Navigating to Market list page$")
	public void Marketlistpage() throws Exception {
		marketplace.ClickAnthem();
	}	
	
	@Then("^Select CM product admin$") 
	public void selectCMProductAdmin() throws InterruptedException { 
	marketplace.selectCMProductAdmin();

	}
	
	
}