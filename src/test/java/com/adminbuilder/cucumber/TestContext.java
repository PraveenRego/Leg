package com.adminbuilder.cucumber;

import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.baseutility.WebAction;

public class TestContext {
	 private WebAction webDriverManager;
	 private PageObjectManager pageObjectManager;
	 public ScenarioContext scenarioContext;
	 
	 public TestContext(){
		 webDriverManager = new WebAction();
		 pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		 
	 }
	 
	 public WebAction getWebDriverManager() {
	 return webDriverManager;
	 }
	 
	 public PageObjectManager getPageObjectManager() {
		 return pageObjectManager;
		 }
	 
	 public ScenarioContext getScenarioContext() {
		 return scenarioContext;
		 }
	 
	}
