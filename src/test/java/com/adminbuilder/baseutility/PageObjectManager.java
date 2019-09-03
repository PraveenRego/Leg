package com.adminbuilder.baseutility;

import org.openqa.selenium.WebDriver;

import com.adminbuilder.Pages.AssessmentBuilder;
import com.adminbuilder.Pages.AssessmentBuilderAddScoringCategory;
import com.adminbuilder.Pages.AssessmentBuilderCombineScoringCategory;
import com.adminbuilder.Pages.AssessmentBuilderLinktoTask;
import com.adminbuilder.Pages.MenuNavigation;
import com.adminbuilder.Pages.LoginPage;
import com.adminbuilder.Pages.MarketPlace;
import com.adminbuilder.Pages.AssessmentBuilderaddQuestion;
import com.adminbuilder.Pages.BranchingLogic;
import com.adminbuilder.Pages.CMAdminNavigation;
import com.adminbuilder.Pages.Clientadmindashboard;
import com.adminbuilder.Pages.AssessmentBuilderEditScore;
import com.adminbuilder.Pages.Publish;

public class PageObjectManager {
	
	private WebDriver driver;
	private AssessmentBuilder assessmentbuilder;
	private AssessmentBuilderaddQuestion assessmentbuilderaddquestion;
	private MenuNavigation leftnavigation;
	private LoginPage loginpage;
	private MarketPlace marketplace;
	private AssessmentBuilderAddScoringCategory assessmentbuilderaddscoringcategory;
	private AssessmentBuilderCombineScoringCategory assessmentbuildercombinescoringcategory;
	private AssessmentBuilderLinktoTask assessmentbuilderlinktotask;
	private BranchingLogic branchinglogic;
	private AssessmentBuilderEditScore editScore;
	private Publish publish;
	private Clientadmindashboard clientadmindashboard;
	private CMAdminNavigation cmadminnavigation;
	
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}
	
	public AssessmentBuilder getAssessmentBuilder(){

		return (assessmentbuilder == null) ? assessmentbuilder = new AssessmentBuilder(driver) : assessmentbuilder;

	}
	
	public AssessmentBuilderaddQuestion getassessmentBuilderaddQuestion(){

		return (assessmentbuilderaddquestion == null) ? assessmentbuilderaddquestion = new AssessmentBuilderaddQuestion(driver) : assessmentbuilderaddquestion;

	}

	public AssessmentBuilderAddScoringCategory getassessmentbuilderaddscoringcategory(){

		return (assessmentbuilderaddscoringcategory == null) ? assessmentbuilderaddscoringcategory = new AssessmentBuilderAddScoringCategory(driver) : assessmentbuilderaddscoringcategory;

	}
	
	public AssessmentBuilderCombineScoringCategory getassessmentbuildercombinescoringcategory(){

		return (assessmentbuildercombinescoringcategory == null) ? assessmentbuildercombinescoringcategory = new AssessmentBuilderCombineScoringCategory(driver) : assessmentbuildercombinescoringcategory;

	}
	
	public AssessmentBuilderLinktoTask getassessmentbuilderlinktotask(){

		return (assessmentbuilderlinktotask == null) ? assessmentbuilderlinktotask = new AssessmentBuilderLinktoTask(driver) : assessmentbuilderlinktotask;

	}
	
	public MenuNavigation getLeftNavigation(){

		return (leftnavigation == null) ? leftnavigation = new MenuNavigation(driver) : leftnavigation;

	}
	
	public LoginPage getLoginPage(){

		return (loginpage == null) ? loginpage = new LoginPage(driver) : loginpage;

	}
	
	public MarketPlace getMarketPlace(){

		return (marketplace == null) ? marketplace = new MarketPlace(driver) : marketplace;

	}
	
	public BranchingLogic getbranchinglogic(){

		return (branchinglogic == null) ? branchinglogic = new BranchingLogic(driver) : branchinglogic;

	}
	
	public AssessmentBuilderEditScore geteditScore(){

		return (editScore == null) ? editScore = new AssessmentBuilderEditScore(driver) : editScore;

	}
	
	public Publish getPublish(){

		return (publish == null) ? publish = new Publish(driver) : publish;

	}	

	public Clientadmindashboard getClientadmindashboard(){

		return (clientadmindashboard == null) ? clientadmindashboard = new Clientadmindashboard(driver) : clientadmindashboard;

	}	
	public CMAdminNavigation getCMAdminNavigation(){

		return (cmadminnavigation == null) ? cmadminnavigation = new CMAdminNavigation(driver) : cmadminnavigation;

	}
}