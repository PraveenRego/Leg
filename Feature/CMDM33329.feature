Feature: CMDM-33329:Admin Console: PI11 Assessment Builder E2E Testing and Prod Readiness

Scenario: CMDM-33394: Generic Assessment Submit Button Group in LTSS and CMDM-34437 - Add Expand, Collapse and Total Questions within the Main Section
  	 Given user log in to LTSSadmin
  	 When I enter Username as "clientadmin" and Password as "Test"
   	 Then login should be successful
     Then I enter the market name as "Iowa"
 	 Then I click on Assessment builder
	 Then I click on Add Assessment and add Assessment
	 And I click on Add Question
	 Then Clear the stored section values from previous scenarios
	 Then Clear the stored Concept ID values from previous scenarios
	 Then Add Question with "Default Section Question_Checkbox","Checkbox" in Assessment Section "0"
#	 Then Mark as required Question for Assessment
#	 Then Save the Concept ID for the question
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Default Section Question_Checkbox Group","Checkbox Group" in Assessment Section "0"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then I select Answeroption as "Yes and No" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	  Then Add Question with "Default Section Question_Date","Date" in Assessment Section "0"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then When I click on submit and add new in add question user shall land on the same page
        Then Add Question with "Default Section Question_Drop down","Drop down" in Assessment Section "0"
     Then Mark as required Question for Assessment
     Then Save the Concept ID for the question
     Then I select Answeroption as "Yes,No and Not Applicable" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Default Section Question_Radio button","Radio Button" in Assessment Section "0"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then I select Answeroption as "Gender" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
		 Then Add Question with "Default Section Question_Signature","Signature" in Assessment Section "0"
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Default Section Question_Text Area","Text Area" in Assessment Section "0"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then When I click on submit and add new in add question user shall land on the same page
 Then Add Question with "Default Section Question_Text Field","Text Field" in Assessment Section "0"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then When I click on submit in add question user shall land on the previous page
	 Then Click on Add Section
	 And Add Main Section
	 And I click on Add Question
	 Then Add Question with "Main Section Question_Checkbox","Checkbox" in Assessment Section "1"
#	 Then Mark as required Question for Assessment
#	 Then Save the Concept ID for the question
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Main Section Question_Checkbox Group","Checkbox Group" in Assessment Section "1"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then I select Answeroption as "Yes and No" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
		 Then Add Question with "Main Section Question_Date","Date" in Assessment Section "1"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then When I click on submit and add new in add question user shall land on the same page
    Then Add Question with "Main Section Question_Drop down","Drop down" in Assessment Section "1"
     Then Mark as required Question for Assessment
     Then Save the Concept ID for the question
     Then I select Answeroption as "Yes,No and Not Applicable" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	  Then Add Question with "Main Section Question_Radio button","Radio Button" in Assessment Section "1"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then I select Answeroption as "Gender" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Main Section Question_Signature","Signature" in Assessment Section "1"
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Main Section Question_Text Area","Text Area" in Assessment Section "1"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Main Section Question_Text Field","Text Field" in Assessment Section "1"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then When I click on submit in add question user shall land on the previous page
	 Then Click on Add Section
	 And Add Sub Section without Main Section
	 And I click on Add Question
	  Then Add Question with "SubSection without Main Section Question_Checkbox","Checkbox" in Assessment Section "2"
#	 Then Mark as required Question for Assessment
#	 Then Save the Concept ID for the question
	 Then When I click on submit and add new in add question user shall land on the same page
	  Then Add Question with "SubSection without Main Section Question_Checkbox group","Checkbox Group" in Assessment Section "2"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then I select Answeroption as "Yes and No" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "SubSection without Main Section Question_Date","Date" in Assessment Section "2"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then When I click on submit and add new in add question user shall land on the same page
    Then Add Question with "SubSection without Main Section Question_Drop down","Drop down" in Assessment Section "2"
     Then Mark as required Question for Assessment
     Then Save the Concept ID for the question
     Then I select Answeroption as "Yes,No and Not Applicable" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "SubSection without Main Section Question_Radio button","Radio Button" in Assessment Section "2"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then I select Answeroption as "Gender" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "SubSection without Main Section Question_Signature","Signature" in Assessment Section "2"
	 Then When I click on submit and add new in add question user shall land on the same page
	  Then Add Question with "SubSection without Main Section Question_Text Area","Text Area" in Assessment Section "2"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then When I click on submit and add new in add question user shall land on the same page
	Then Add Question with "SubSection without Main Section Question_Text Field","Text Field" in Assessment Section "2"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then When I click on submit in add question user shall land on the previous page
	 Then Click on Add Section
	 And Add Sub Section
	 And I click on Add Question
	 	 Then Add Question with "SubSection with Main Section Question_Checkbox","Checkbox" in Assessment Section "2"
#	 Then Mark as required Question for Assessment
#	 Then Save the Concept ID for the question
	 Then When I click on submit and add new in add question user shall land on the same page
	  Then Add Question with "SubSection with Main Section Question_Checkbox group","Checkbox Group" in Assessment Section "2"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then I select Answeroption as "Yes and No" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	  Then Add Question with "SubSection with Main Section Question_Date","Date" in Assessment Section "2"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then When I click on submit and add new in add question user shall land on the same page
     Then Add Question with "SubSection with Main Section Question_Drop down","Drop down" in Assessment Section "2"
     Then Mark as required Question for Assessment
     Then Save the Concept ID for the question
     Then I select Answeroption as "Yes,No and Not Applicable" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	  Then Add Question with "SubSection with Main Section Question_Radio button","Radio Button" in Assessment Section "2"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then I select Answeroption as "Gender" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	  Then Add Question with "SubSection with Main Section Question_Signature","Signature" in Assessment Section "2"
	 Then When I click on submit and add new in add question user shall land on the same page
	  Then Add Question with "SubSection with Main Section Question_Text Area","Text Area" in Assessment Section "2"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then When I click on submit and add new in add question user shall land on the same page
	  Then Add Question with "SubSection with Main Section Question_Text Field","Text Field" in Assessment Section "2"
	 Then Mark as required Question for Assessment
	 Then Save the Concept ID for the question
	 Then When I click on submit in add question user shall land on the previous page
	 Then Click on Add Section
	 And Add Second Main Section
	 And I click on Add Question
	 Then Add Question with "Main Section2 Question_Checkbox","Checkbox" in Assessment Section "4"
#	 Then Mark as required Question for Assessment
#	 Then Save the Concept ID for the question
	 Then When I click on submit and add new in add question user shall land on the same page
		 Then Add Question with "Main Section2 Question_Chekbox group","Checkbox Group" in Assessment Section "4"
#	 Then Mark as required Question for Assessment
#	 Then Save the Concept ID for the question
	 Then I select Answeroption as "Yes and No" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Main Section2 Question_Date","Date" in Assessment Section "4"
#	 Then Mark as required Question for Assessment
#	 Then Save the Concept ID for the question
	 Then When I click on submit and add new in add question user shall land on the same page
      Then Add Question with "Main Section2 Question_Drop down","Drop down" in Assessment Section "4"
#     Then Mark as required Question for Assessment
#     Then Save the Concept ID for the question
     Then I select Answeroption as "Yes,No and Not Applicable" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Main Section2 Question_Radio button","Radio Button" in Assessment Section "4"
#	 Then Mark as required Question for Assessment
#	 Then Save the Concept ID for the question
	 Then I select Answeroption as "Gender" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Main Section2 Question_Signature","Signature" in Assessment Section "4"
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Main Section2 Question_Text Area","Text Area" in Assessment Section "4"
#	 Then Mark as required Question for Assessment
#	 Then Save the Concept ID for the question
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Main Section2 Question_Text Field","Text Field" in Assessment Section "4"
#	 Then Mark as required Question for Assessment
#	 Then Save the Concept ID for the question
	 Then When I click on submit in add question user shall land on the previous page
	 Then When I click on submit in add assessment user shall land on the previous page
	 Then filter the Assessment
	 Then Verify presence of Preview button
	 Then Click on Preview of the created Assessment
	 Then Verify navigation to Preview page
	 Then Validate Submit Button group in Preview page
	 Then Verify clicking on Back button navigates user out of Preview Page
	 Then filter the Assessment
	 Then Click on Preview of the created Assessment
	 Then Verify Expand All and Collape All links in the Preview page
	 Then Click on Expand All link and validate
	 Then Click on Collapse All link and validate
	 Then Verify Count of required questions is displayed for the Main Section and validate
#	 Then Verify Main Section exists and expand the accordian
	 Then Click and verify Validate Form button
	 And Close Driver	
	  
	Scenario: CMDM-34060 : Prod Readiness:Fix Breadcrumbs for LTSS Assessment Builder
			
		Given user log in to LTSSadmin
	   	When I enter Username as "clientadmin" and Password as "Test"
    	Then login should be successful
    	Then I enter the market name as "Iowa"
    	And Verify the page breadcrumb as "Dashboard"
    	Then I click on Assessment builder
    	And Verify the page breadcrumb as "AssessmentBuilder"
    	Then I click on Add Assessment
    	And Verify the page breadcrumb as "Assessment"
   		And Adding an Assessment
  		And Verifying Added Assessment
   		Then I click on Edit Assessment only
   		And Verify the page breadcrumb as "Assessment"
    	Then I click on Link to Tasks
   		And Verify the page breadcrumb as "AssessmentAssociation"
   		Then Click on Back button
   		Then I click on Add Question
   		And Verify the page breadcrumb as "Question"
   		Then Click on Back button
   		Then I click on Add Scoring Category
   		And Verify the page breadcrumb as "ScoringCategory"
   		Then Click on Back button
   		Then I click on Add Combine Scoring Category
   		And Verify the page breadcrumb as "ScoringCategory"
   		Then Click on Back button
   #		Then I click on Add Question
   		Then Verify Default section in Template Grid - enters "Question - Default Section", "Date", "Default Section"
	    Then I click on Default Question Edit
	    And Verify the page breadcrumb as "Question"
	    Then Click on Back button
	    Then I click on Add Scoring Category
	    Then When I enter CategoryName as "CategoryAdd1" validate Add button is enabled
   		Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "1" and ScoreHighRange as "6" and submit
   		Then When I click on submit user shall land on the previous page
   		And I click on Add Scoring Category
   		Then When I enter CategoryName as "CategoryAdd2" validate Add button is enabled
   		Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "7" and ScoreHighRange as "8" and submit
     	Then When I click on submit user shall land on the previous page
 		Then Click on Edit button of Scoring category grid
	    And Verify the page breadcrumb as "ScoringCategory"
   		Then Click on Back button
   		Then I click on Add Combine Scoring Category
		Then Enter Group Category Description as "Groupcategoryadd"
   		Then Select the first value from Scoring Category
   		Then Select the first value from Scoring Category
   		Then Enter in Combine Scoring Categories, ScoreRangeValue as "TestRange" , ScoreLowRange as "4" and ScoreHighRange as "6" and submit
   		Then When I click on submit user shall land on the previous page
   		Then Click on Edit button of Scoring category grid
	    And Verify the page breadcrumb as "ScoringCategory"
   		Then Click on Back button		
    	Then Navigating to "Markets" page by clicking on breadcrumb
    	And Verify the page breadcrumb as "Markets"
   		And Close Driver
   
 Scenario: CMDM-34634: System generated Section label
   		Given user log in to LTSSadmin
	   	When I enter Username as "clientadmin" and Password as "Test"
    	Then login should be successful
    	Then I enter the market name as "Iowa"
    	Then I click on Assessment builder
    	Then I click on Add Assessment
    	And Adding an Assessment
    	And Verifying Added Assessment
	   	Then I click on Edit Assessment only
	   	Then Click on Add Section
	   	Then Sub Section Validation1
	   	Then Navigating to "Assessment Builder" page by clicking on breadcrumb
	  	Then I click on Assessment builder
    	And Verifying Added Assessment
	   	Then I click on Edit Assessment only
	   	Then Click on Add Section
	   	Then Sub Section Validation2
	   	And Close Driver
	   	
  	
Scenario: CMDM-34230:Add Instructions static value  Question Response Type
              Given user log in to LTSSadmin
              When I enter Username as "clientadmin" and Password as "Test"
              Then login should be successful
              Then I enter the market name as "Iowa"
             Then I click on Assessment builder
              Then I click on Add Assessment and add Assessment
              And I click on Add Question
              Then I verify that Instructions is added as a static value
              Then Clear the stored section values from previous scenarios
              Then Add Question with "Default Section Question Description1","Instruction(s)" in Assessment Section "0"
              Then Save the Question Description for the question
              Then Validate answer section is not displayed for Instructions
              Then When I click on submit in add question user shall land on the previous page
              Then Click on Add Section
              And Add Main Section
              And I click on Add Question
              Then Add Question with "Main Section Question Description1","Instruction(s)" in Assessment Section "1"
              Then Save the Question Description for the question
              Then When I click on submit in add question user shall land on the previous page
              Then Click on Add Section
              And Add Sub Section without Main Section
              And I click on Add Question
              Then Add Question with "Sub Section without main Question Description1","Instruction(s)" in Assessment Section "2"
              Then Save the Question Description for the question
              Then When I click on submit in add question user shall land on the previous page
              Then Click on Add Section
              And Add Sub Section
              And I click on Add Question
              Then Add Question with "Sub Section with main Question Description1","Instruction(s)" in Assessment Section "2"
              Then Save the Question Description for the question
              Then When I click on submit in add question user shall land on the previous page
              Then When I click on submit in add assessment user shall land on the previous page
             Then filter the Assessment
             Then Click on Preview of the created Assessment
             Then Click on Expand All link and validate
             Then Verify Question Description content for Instructions Question Response Type
             And Close Driver 
	 
	   		   	
	  Scenario: CMDM-34723: Admin Console: Question Page: Hide include in scoring when answer response type = Instructions

	 		 Given user log in to LTSSadmin
  		 When I enter Username as "clientadmin" and Password as "Test"
 			 Then login should be successful
 		   Then I enter the market name as "Iowa"
   		 Then I click on Assessment builder
   		  Then I click on Add Assessment and add Assessment
   		 And I click on Add Question
  		 Then User enters "Question Description2", "Date", "Concept Code Description2", "Concept Code", "Default Section" and "Tool tip2"
    	 Then When I select "Instruction(s)" from question response the correct section is displayed
  		 Then Validate Include in scoring toggle is not displayed
 		 
  	Scenario: CMDM-33395_Prod Readiness: Add Section - display Submit button group instead hiding
  	 Given user log in to LTSSadmin
  		 When I enter Username as "clientadmin" and Password as "Test"
 			 Then login should be successful
 		   Then I enter the market name as "Iowa"
   		 Then I click on Assessment builder
   		 Then I click on Add Assessment
   		 And Adding an Assessment
    	And Verifying Added Assessment
	   		And I click on Edit Assessment only
   		  Then Click on Add Section
   	 		 And Validate Section modal window button group
   		 And Adding and Verifying Main Section
   		 And validate Edit Section modal window button group
   		  Then Click on Add Section
   		 And Validate Duplicate section modal window button group

Scenario: CMDM-34944 - Updating Submit Button group Add/Edit Assessment page
  	 Given user log in to LTSSadmin
  		 When I enter Username as "clientadmin" and Password as "Test"
 			 Then login should be successful
 		   Then I enter the market name as "Iowa"
   		 Then I click on Assessment builder
   		 Then I click on Add Assessment
   		 Then Verify the Submit/Back buttons in Add/Edit Assessment page
   		 Then Adding an Assessment
   		 Then Verifying Added Assessment
   		 Then I click on Edit Assessment only
   		 Then Verify the Submit/Back buttons in Add/Edit Assessment page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "!" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "@" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "#" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "$" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "%" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "^" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "&" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "*" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "(" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "+" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "=" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "{" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character ";" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "." in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "," in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "?" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "|" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "~" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "[" in Section label - Add Section page
   		 Then Click on Add Section
   		 Then Validate the error message when the special character "/" in Section label - Add Section page
   		 And Close Driver
   		 
   		    		 Scenario: CMDM-34983 Admin Console: Display error message when publish an assessment and no task is associated
  	 Given user log in to LTSSadmin
  	 When I enter Username as "clientadmin" and Password as "Test"
 	 Then login should be successful
 	 Then I enter the market name as "Iowa"
   	 Then I click on Assessment builder
     Then I click on Add Assessment
     And Adding an Assessment
   	 When When I click on Publish button in grid
     Then When I select Environment as "SIT"
     Then When I enter Effective Date as "08/08/2019"
	 Then Click on Publish button in Publish page
     Then Verify AssessmentAssociation Error message in Publish
     Then When I click on Back in Publish page user shall land on the previous page
   Then I click on Add Assessment with assessment name "Test"
   Then When I click on submit in add assessment user shall land on the previous page
   Then Filter the Assessment grid with the recently added
 	Then I click on Link button from Assessment Dashboard
   Then validate Assessmentname in Link to Task page
   Then validate Add button enabled with Taskname "Annual Assessment"
   Then Click Add button
   Then When I click on submit in add question user shall land on the previous page
    Then Filter the Assessment grid with the recently added
   	Then When I click on Publish button in grid
    Then When I select Environment as "SIT"
    Then When I enter Effective Date as "08/08/2019"
    Then When I click Publish button verify Environment as "SIT" ,AssessmentAssociation as "Annual Assessment" and Effective Date as "08/08/2019"
    Then Verify AssessmentAssociation Error message is Not Display in Publish
    Then Verify Publish Grid
    Then When I click on Back in Publish page user shall land on the previous page
    Then Filter the Assessment grid with the recently added
 	Then I click on Link button from Assessment Dashboard
   Then validate Assessmentname in Link to Task page
   Then validate tasks table headers
   Then I click on delete button
   Then When I click on submit in add question user shall land on the previous page
   Then Filter the Assessment grid with the recently added
   	Then When I click on Publish button in grid
    Then When I select Environment as "SIT"
    Then When I enter Effective Date as "08/08/2019"
    Then Click on Publish button in Publish page
    Then Verify AssessmentAssociation Error message in Publish
     Then When I click on Back in Publish page user shall land on the previous page
   Then I click on Add Assessment with assessment name "Assessmenttest"
   Then I click on Link to Tasks
   Then validate Assessmentname in Link to Task page
    Then validate Add button enabled with Taskname "Annual Assessment"
    Then Click Add button
    Then When I click on submit in add question user shall land on the previous page
    Then When I click on submit in add assessment user shall land on the previous page
    Then Filter the Assessment grid with the recently added
   	Then When I click on Publish button in grid 
    Then When I select Environment as "SIT"
    Then When I enter Effective Date as "08/08/2019"
    Then When I click Publish button verify Environment as "SIT" ,AssessmentAssociation as "Annual Assessment" and Effective Date as "08/08/2019"
    Then Verify AssessmentAssociation Error message is Not Display in Publish
    Then Verify Publish Grid
    Then When I click on Back in Publish page user shall land on the previous page
    Then Filter the Assessment grid with the recently added
 	Then I click on Link button from Assessment Dashboard
   Then validate Assessmentname in Link to Task page
   Then validate tasks table headers
   Then I click on delete button
   Then When I click on submit in add question user shall land on the previous page
   Then Filter the Assessment grid with the recently added
   	Then When I click on Publish button in grid
    Then When I select Environment as "SIT"
    Then When I enter Effective Date as "08/08/2019"
    Then Click on Publish button in Publish page
    Then Verify AssessmentAssociation Error message in Publish