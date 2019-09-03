package com.adminbuilder.stepDefinition;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.adminbuilder.Pages.LoginPage;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When; 

 

public class stepdefLogin extends WebAction { 

	TestContext testContext;
	WebDriver driver;
	Logger Log = Logger.getLogger("stepdefLogin.class");
	PageObjectManager pageObjectManager; 
	LoginPage login;

	public stepdefLogin(TestContext context) {
		 testContext = context;
		 login = testContext.getPageObjectManager().getLoginPage();
		 }
	
	
@Given("^user log in to LTSSadmin$") 
   public void user_navigates_to_Nimbus() {

	login.host_URL();
   } 
   
  	
   @When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$") 
   public void I_enter_Username_as_and_Password_as(String u_name, String pwd) throws IOException, InterruptedException {
	   
		login.Login_admin(u_name, pwd);
	   
   }
    
   @Then("^login should be successful$") 
   public void validateloginsuccessful() throws InterruptedException { 
	  
		login.validate_loginsuccessfull();
   
   }

   @Then("^logout should be successful$") 
   public void logout() { 
	  
		login.logout();
   
   }
   
   @Then("^login should be unsuccessful$") 
   public void validateloginunsuccessful() throws InterruptedException { 
	  
		login.validate_loginunsuccessfull();
   
   }
   
   @Then("^Close Driver$") 
   public void closedriver() throws InterruptedException { 
	   login.closeDriver();
   
   }
	
}