package com.adminbuilder.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.adminbuilder.baseutility.WebAction;

public class ExcludedFromAutomation extends WebAction{

	WebAction webaction;
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("CloneAssessment.class");
	GlobalValues global = new GlobalValues();
	String AssessmentName = global.Assessment;
	
	public ExcludedFromAutomation(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	



	public enum Excludedstory {
		TechStory,
		SpikeStory,
		DBStory,
		RefactorStory;
	}
	
	public void excludedStoryStatus(Excludedstory storytype) throws Exception {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(3000);
		switch (storytype) {
		
		case TechStory:
					Log.info("This is a Tech story");
			return;
		case SpikeStory :
				Log.info("This is a Spike story");
			return;
		case RefactorStory :
			Log.info("This is a Refactor story");
			return;
			
		case DBStory :
			Log.info("This is a DB story");
			return;
		}

	
	
}

}


