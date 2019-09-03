package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.adminbuilder.Pages.AssessmentBuilderaddQuestion;
import com.adminbuilder.Pages.AssessmentBuilderaddQuestion.UpdateType;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class stepdefassessmentBuilderaddQuestion extends WebAction {
	TestContext testContext;
	Logger Log = Logger.getLogger("stepdefassessmentBuilderaddQuestion.class");
	PageObjectManager pageObjectManager; 
	AssessmentBuilderaddQuestion assessmentbuilderaddquestion;

	public stepdefassessmentBuilderaddQuestion(TestContext context) {
		 testContext = context;
		 assessmentbuilderaddquestion = testContext.getPageObjectManager().getassessmentBuilderaddQuestion();
		 }
	 
	 @Then("^When I select \"([^\"]*)\" from question response the correct section is displayed$") 
	 public void validateanswersection(String Questionresponsetype) throws InterruptedException { 
		
		 assessmentbuilderaddquestion.validateanswersection(Questionresponsetype);
	 }
	 
	 @Then("^When user does not make a selection in the insert answer, Answer Order and Answer Text is mandatory$") 
	 public void validateanswermandatory() throws InterruptedException { 
		
		 assessmentbuilderaddquestion.validateanswermandatory();
	 }
	 
	 @Then("^User select AnswerText \"([^\"]*)\" and Answerscore \"([^\"]*)\" , click add and verify the grid$") 
	 public void Addanswer(String AnswerText, String AnswerScore) throws InterruptedException { 
		
		 assessmentbuilderaddquestion.AddEditanswer( AnswerText,AnswerScore,UpdateType.Add);
	 }
	 
	 @Then("^When User add duplicate vaues, AnswerText \"([^\"]*)\" and Answerscore \"([^\"]*)\" , verify error message is displayed$") 
	 public void Addanswererror(String AnswerText, String AnswerScore) throws InterruptedException { 
		 
		 assessmentbuilderaddquestion.AddEditanswererror(AnswerText,AnswerScore,UpdateType.Add);
	 }
	 
	 @Then("^When User edit duplicate vaues, AnswerText \"([^\"]*)\" and Answerscore \"([^\"]*)\" , verify error message is displayed$") 
	 public void Editanswererror(String AnswerText, String AnswerScore) throws InterruptedException { 
		 
		 assessmentbuilderaddquestion.AddEditanswererror(AnswerText,AnswerScore,UpdateType.Edit);
	 }
	 
	 @Then("^Validate the form is reset$") 
	 public void validateformreset() throws InterruptedException { 
		
		 assessmentbuilderaddquestion.validateformreset();
	 } 
	 
	 @Then("^User select AnswerText \"([^\"]*)\" and Answerscore \"([^\"]*)\" , click edit and verify the grid$") 
	 public void Editanswer(String AnswerText, String AnswerScore) throws InterruptedException { 
		 
		 assessmentbuilderaddquestion.AddEditanswer(AnswerText,AnswerScore,UpdateType.Edit);
	 }
	 
	 @Then("^I select Answeroption as \"([^\"]*)\" and click on add$") 
	 public void selectansweroption(String option) throws InterruptedException { 
		 
		 assessmentbuilderaddquestion.selectanswerandadd(option);
	 }
	 
	 @Then("^Validate the Answer grid for the choosen option as \"([^\"]*)\"$") 
	 public void verifytheaddedanswer(String option) throws InterruptedException { 
		 
		 assessmentbuilderaddquestion.verifyanswergrid(option);
	 }
	 
	 @Then("^I click on Edit row from answer grid$") 
	 public void clickeditrow() throws InterruptedException { 
		 
		 assessmentbuilderaddquestion.clickedit();
	 }
	 
	 @Then("^I click on Delete row from answer grid and verify the records$") 
	 public void clickdeleterow() throws InterruptedException { 
		 
		 assessmentbuilderaddquestion.clickdeleteandverify();
	 }
	 
	 @Then("^Validate the fields present in answer section$") 
	 public void validateanswersection() throws InterruptedException { 
		 
		 assessmentbuilderaddquestion.validateanswersection();
	 }
	 
	 @Then("^Validate that error message displayed when answerorder is \"([^\"]*)\" and scoringvalue is \"([^\"]*)\"$") 
	 public void validateanswerorderandscoringvalue(String AnswerOrder, String AnswerScoreValue) throws InterruptedException { 
		 
		 assessmentbuilderaddquestion.validateanswerorderandscoringvalue(AnswerOrder, AnswerScoreValue);
	 }
	 
	 @Then("^Validate the headers in the answer grid$") 
	 public void validateanswergrid() throws InterruptedException { 
		 
		 assessmentbuilderaddquestion.validateanswergrid();
	 }
	 
	 @Then("^When I click on submit in add question user shall land on the previous page$") 
	 public void clicksubmit() throws InterruptedException { 
		
		 assessmentbuilderaddquestion.clicksubmit();
	 }
	
	@Then("^When I click on submit and add new in add question user shall land on the same page$") 
	 public void clicksubmitandaddnew() throws InterruptedException { 
		
		assessmentbuilderaddquestion.clicksubmitandaddnew();
	 }
	
	@Then("^When I click on submit error message is displayed$") 
	 public void clicksubmitandverifyerrorforscoring() throws InterruptedException { 
		
		assessmentbuilderaddquestion.clicksubmitandverifyerrorforscoring();
	 }
	
	@Then("^I click on scoring switch$") 
	 public void clickscoringswitch() throws InterruptedException { 
		
		assessmentbuilderaddquestion.clickscoringswitch();
	 }
	
	 @Then("^Validate the Scoring Category field dropdown$") 
	 public void validateScoringCategoryfielddropdown() throws InterruptedException { 
		
		assessmentbuilderaddquestion.validateScoringCategoryfielddropdown();
	 }
	
	@Then("^Validate Add Question$")
	public void checkAddQuestionsPage() throws InterruptedException {
	      
		assessmentbuilderaddquestion.validatequestionsection();
	}
	
	  
	@Then("^Verify Checkbox and Checkbox Group changes$")
	public void verifycheckboxandcheckboxgroup() throws InterruptedException {
	      
		assessmentbuilderaddquestion.verifycheckboxandcheckboxgroup();
	}
	
	  @Then("^Validate form is saved and cleared for next question$")
	   public void checkformiscleared() throws InterruptedException {
	          
		  assessmentbuilderaddquestion.validateformiscleared();
	   } 
	  
	  @Then("^User enters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	   public void filldetailsforsecondquestion(String QuesDesc,String QuesResTyp,String ConcCodeDesc,String ConcCode,String ConcID,String AssmntSect,String Tooltip) throws InterruptedException {
	          
		  assessmentbuilderaddquestion.filldetailsforsecondquestion(QuesDesc,QuesResTyp,ConcCodeDesc,ConcCode,ConcID,AssmntSect,Tooltip);
	   } 
	  
	  @Then("^Verify Assessment Template displays the added questions$")
	    public void verifyassmnttemplateforaddedquestions() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifyassmnttemplateforaddedquestions();
	    }  
	  
	  @And("^Validate database for Questions added by user$") 
      public void validatedatabaseforaddquestions() throws InterruptedException{
		  assessmentbuilderaddquestion.checkdatabaseforaddquestions();
          
      } 
	  @And("^Validate Answer order adjust when a new answer option with previously added order is added$") 
      public void validateAnswerorderprepopulate() throws InterruptedException{
		  assessmentbuilderaddquestion.validateAnswerorderprepopulate();
          
      } 
	  
      @And("^Enter \"([^\"]*)\" and Validate Answer order accepts only numerical value$") 
      public void validateAnswerordererrormsg(String strAnswerorder) throws InterruptedException{
		  assessmentbuilderaddquestion.validateAnswerordererrormsg(strAnswerorder);
          
      }
      
      
      @Then("^Add Question with \"([^\"]*)\",\"([^\"]*)\" in Assessment Section \"([^\"]*)\"$")
	  public void addquestion(String QuesDesc,String QuesRespType,String Section) throws InterruptedException {
		           
		  assessmentbuilderaddquestion.addquestion(QuesDesc,QuesRespType,Section);
	    }
      
      @And("^Add Main Section$")
		public void AddingMainsection() throws Exception {
		 assessmentbuilderaddquestion.AddMainSection();
	 }
      
      
      @And("^Add Second Main Section$")
		public void SecondMainSection() throws Exception {
		 assessmentbuilderaddquestion.AddSecondMainSection();
		}
    
      
    @And("^Add Sub Section$")
		public void AddingSubsection() throws Exception {
		 assessmentbuilderaddquestion.AddSubSection();
		 
		}
    
    @Then("^filter the Assessment$")
	    public void filtertheassessment() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.filtertheassessment();
	    }
    
    
    @Then("^Verify presence of Preview button$")
	    public void verifypreviewbtn() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifypreviewbtn();
	    }
    
    @Then("^Click on Preview of the created Assessment$")
	    public void clickonassessmentpreview() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.clickonassessmentpreview();
	    }
    
    @Then("^Verify navigation to Preview page$")
	    public void verifynavigationtopreview() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifynavigationtopreview();
	    }
    
    @Then("^Verify Default Section in Preview page with \"([^\"]*)\",\"([^\"]*)\" in Assessment Section \"([^\"]*)\"$")
	    public void verifydefaultsectioninpreviewpage(String Quesdesc,String QuesRespType,String section) throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifydefaultsectioninpreviewpage(Quesdesc,QuesRespType,section);
	    }
    
    @Then("^Verify Main Section exists and expand the accordian$")
	    public void verifyandexpandmainsection() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifyandexpandmainsection();
	    }
    
    @Then("^Verify Main Section in Preview page with \"([^\"]*)\",\"([^\"]*)\" in Assessment Section \"([^\"]*)\"$")
	    public void verifymainsectioninpreviewpage(String Quesdesc,String QuesRespType,String section) throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifymainsectioninpreviewpage(Quesdesc,QuesRespType,section);
	    }
	  
    @Then("^Verify SubSection with main header in Preview page$")
	    public void verifysubsectionwithmainheader() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifysubsectionwithmainheader();
	    }
    
    @Then("Verify SubSection with Main Section in Preview Page with \"([^\"]*)\",\"([^\"]*)\" in Assessment Section \"([^\"]*)\"$")
	    public void verifysubsectionwithmaininpreviewpage(String Quesdesc,String QuesRespType,String section) throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifysubsectionwithmaininpreviewpage(Quesdesc,QuesRespType,section);
	    }
	  
    @Then("Verify Subsection without main header in Preview page$")
	    public void verifysubsectionwitouthmainheaderinpreviewpage() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifysubsectionwitouthmainheaderinpreviewpage();
	    }
    
    
    @Then("^Verify SubSection without Main Section in Preview Page with \"([^\"]*)\",\"([^\"]*)\" in Assessment Section \"([^\"]*)\"$")
	    public void verifysubsectionwithoutmaininpreviewpage(String Quesdesc,String QuesRespType,String section) throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifysubsectionwithoutmaininpreviewpage(Quesdesc,QuesRespType,section);
	    }
    
    
	  @Then("^Verify the Question Order and Question Id of \"([^\"]*)\" section in Assessment template grid$" )
	    public void verifyquestionordernumber(String section) throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifyquestionordernumber(section);
	    }
	  
	  
	  @Then("^Verify Section Order number in Assessment template grid for \"([^\"]*)\"$")
	     public void verifysectionordernumber(String section) throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifysectionordernumber(section);
	    }
    
	  @And("^Add Sub Section without Main Section$")
		public void AddingSubsectionwithoutMainSection() throws Exception {
		 assessmentbuilderaddquestion.AddingSubsectionwithoutMainSection();
		 
		}
	  
	  

	  @And("^Add Second Sub Section without Main Section$")
		public void AddingsecondSubsectionwithoutMainSection() throws Exception {
		 assessmentbuilderaddquestion.AddingsecondSubsectionwithoutMainSection();
		 
		}
	  
	  @Then("^Update Main Section Type as Second Main Section for Second SubSection$" )
	    public void updateassessmentsection() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.updateassessmentsection();
	    }
	  
    @Then("^Verify clicking on browser back button navigates user out of Preview Page$")
	    public void verifynavigatingoutofpreviewpage() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifynavigatingoutofpreviewpage();
	    }
    
    @Then("^validate submit button is disabled when one or more mandatory fields user inputs are removed$")
	public void validatesubmitbtndisabled() throws InterruptedException {
	      
		assessmentbuilderaddquestion.validatesubmitbtndisabled();
	}
    
    
    @Then("^Validate whether the fields are reset and previously added data is cleared$")
	public void validatefieldsresetafterclickingback() throws InterruptedException {
	      
		assessmentbuilderaddquestion.validatefieldsresetafterclickingback();
	}
    
    @Then("^verify Please Select is a static value in Insert Answer$")
	public void verifystaticvalue() throws InterruptedException {
	      
		assessmentbuilderaddquestion.verifystaticvalue();
	}  
   
    
    @Then("^Validate Edit option for each question$")
	    public void verifyeditquestionoption() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifyeditquestionbutton();
	    } 
    
    @Then("^Validate navigation to Edit Question Page of question \"([^\"]*)\"$")
	    public void verifyeditquestionpagenavigation(String questionnum) throws InterruptedException {
	 
		  assessmentbuilderaddquestion.verifyeditquestionpagenavigation(questionnum);
	    }
    
    @Then("^Validate Question section details displaying user provided input in Edit Question page$")
	    public void verifyeditquestionpagedetails() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifyeditquestionpagedetails();
	    }
    
    @Then("^Validate buttons in the Edit Question page$")
	    public void verifyeditquestionpagebuttons() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifyeditquestionpagebuttons();
	    }
    
    @Then("^I Edit the Question section$")
	    public void editquestionpagedetails() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.editquestionpagedetails();
	    }
    
    @Then("^I click on submit button$")
	    public void clicksubmitineditquestion() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.clicksubmitineditquestion();
	    }
    
    @Then("^Validate Delete option for each question$")
	    public void verifydeletequestionoption() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifydeletequestionbutton();
	    } 
    
    @Then("^I click on Delete button of first question$")
	    public void clickdeletequestionoption() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.clickdeletequestionoption();
	    }
    
    @Then("^Validate Modal window on clicking delete button of a Question$")
	    public void verifymodalwindowdeletequestion() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.verifymodalwindowdeletequestion();
	    }
    
    @Then("^I click on Cancel button and validate whether the modal window is closed$")
	    public void validateclickoncancel() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.validateclickoncancel();
	    }
    
    @Then("^I click on Yes in the modal window and validate whether the question is removed from Assessment Template grid$")
	    public void validateclickonyes() throws InterruptedException {
	           
		  assessmentbuilderaddquestion.validateclickonyes();
	    } 
    
      
      
}
