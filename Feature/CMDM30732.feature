Feature: CMDM-30732:Admin Console: Clone Assessment/Form Details (LTSS-Specific)

Scenario: CMDM-33353: Create Assessment Cloning UI and CMDM-33356: Duplicate Check on Assessment Cloning and CMDM-33391:Validations for cloning Assessments and CMDM-33390:Generate new Concept IDs for Cloned Assessment and CMDM-34641: Cloning validations for target market

	    Given user log in to LTSSadmin
	   	When I enter Username as "clientadmin" and Password as "Test"
    	Then login should be successful
    	Then I enter the market name as "Iowa"
   		Then I click on Assessment builder
    	Then I click on Add Assessment
    	And Adding an Assessment
   		And Verifying Added Assessment
     	Then Click on Clone Assessment
    	Then Verifying the CloneAssessment modal window 	
    	And I click on Edit Assessment only
    	Then I click on Add Question
    	And Verify Default section in Template Grid - enters "Question - Default Section", "Signature", "Default Section"
    	Then When I click on submit in add assessment user shall land on the previous page
    	
    	And Verifying Added Assessment
    	Then I click on Link button from Assessment Dashboard
   		Then validate Add button enabled with Taskname "Annual Assessment"
   		Then Click Add button
   		Then When I click on submit in add assessment user shall land on the previous page


    	Then When I click Publish button in grid
  		Then When I select Environment as "SIT3"
   	Then When I enter Effective date as current date
  		Then Click on Publish button in Publish page
   		Then When I validate Publish grid "BeforeClone"
   		Then Click on Back button
   		And Verifying Added Assessment
    	
   		Then I click on Link button from Assessment Dashboard
   		Then validate Add button enabled with Taskname "Annual Assessment"
   		Then Click Add button
   		Then When I validate Task grid "BeforeClone"
   		Then When I click on submit in add assessment user shall land on the previous page
   
    	Then When I click Publish button in grid
  		Then When I select Environment as "SIT3"
   		Then When I enter Effective date as current date
  		Then Click on Publish button in Publish page
   		Then When I validate Publish grid "BeforeClone"
   		Then Click on Back button
      		
   		And Verifying Added Assessment
   		Then Click on Clone Assessment
    #	Then I click on Assessment builder
    #	Then I click on Add Assessment
    #	And Adding an Assessment
   #		And Verifying Added Assessment
     #	Then Click on Clone Assessment
    	Then Verifying the CloneAssessment modal window 	
    	And I click on Edit Assessment only
    	Then I click on Add Question
    	And Verify Default section in Template Grid - enters "Question - Default Section", "Signature", "Default Section"
    	Then When I click on submit in add assessment user shall land on the previous page
 		Then Click on Clone Assessment
    	Then Cloning the assessment into different market "Florida"
    	Then Validating the Success message after cloning the assessment
    	And Verifying Added Assessment
    	Then Click on Clone Assessment
    	Then Validating the Duplicate Clone Assessment "Florida", "Iowa"			    	
    	Then Navigating to "Markets" page by clicking on breadcrumb
   		Then Select market as "Florida"
    #	Then Navigating to "Markets" page by clicking on breadcrumb
   #		Given I enter the market name as "Florida"	
   		Then I click on Assessment builder
		And Verifying Added Assessment
		Then When I click Publish button in grid
		Then When I validate Publish grid "AfterClone"
		Then Click on Back button
		And Verifying Added Assessment
   		Then I click on Link button from Assessment Dashboard
   		Then When I validate Task grid "AfterClone"
   		Then Click on Back button
   		
   		And Verifying Added Assessment
		And I click on Edit Assessment only
		Then Validate Concept ID of CLoned Assessment
		Then Click on Back button
		And Close Driver
			

			