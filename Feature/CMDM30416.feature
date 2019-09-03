
Feature: CMDM-30416:Admin Console: Assessments - Incorporate Existing Assessment Builder Functionality

#Scenario: CMDM-30604_Admin Console Create login page for LTSS Admin Console
#   	 Given user log in to LTSSadmin
#   When I enter Username as "clientadmin" and Password as "Test"
#   Then login should be successful
#    And logout should be successful
#    Then I enter Username as "client" and Password as "Test"
#    Then login should be unsuccessful
#    
# 	Scenario: CMDM-30996_Admin Console Add records to answer choice grid, CMDM-31991_Admin Console: Enhancements to the applications Part1	
#	Given user log in to LTSSadmin
#   When I enter Username as "clientadmin" and Password as "Test"
#   Then login should be successful
#   Then I enter the market name as "Iowa"
#   Then I click on Assessment builder
#   Then I click on Add Assessment with assessment name "Test"
#   And I click on Add Question
#   Then User enters "Question Description2", "Date", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
#   Then When I select "Date" from question response the correct section is displayed
#   Then When I select "Drop down" from question response the correct section is displayed
#   Then When I select "Radio Button" from question response the correct section is displayed
#   Then When I select "Text Area" from question response the correct section is displayed
#   Then When I select "Text Field" from question response the correct section is displayed
#   Then When I select "Checkbox Group" from question response the correct section is displayed
#   Then When user does not make a selection in the insert answer, Answer Order and Answer Text is mandatory
#   Then User select AnswerText "Noo" and Answerscore "" , click add and verify the grid
#   Then Validate the form is reset
#   
#  
#   Scenario: CMDM-30780_Admin Console: Insert Answer to a Question and CMDM-30976_Admin Console: Edit or Delete answer choice to a question
#   Given user log in to LTSSadmin
#   When I enter Username as "clientadmin" and Password as "Test"
#   Then login should be successful
#   Then I enter the market name as "Iowa"
#   Then I click on Assessment builder
#   Then I click on Add Assessment with assessment name "Test"
#   And I click on Add Question
#   Then When I select "Drop down" from question response the correct section is displayed
#   Then I select Answeroption as "Yes and No" and click on add
#   Then Validate Answer order adjust when a new answer option with previously added order is added
#   Then Validate the Answer grid for the choosen option as "Yes and No"
#   Then When I select "Radio Button" from question response the correct section is displayed
#   Then I select Answeroption as "Yes,No and Not Applicable" and click on add
#   Then Validate Answer order adjust when a new answer option with previously added order is added
#   Then Validate the Answer grid for the choosen option as "Yes,No and Not Applicable"
#   Then I click on Edit row from answer grid
#   Then I click on scoring switch
#   Then User select AnswerText "Noo" and Answerscore "2" , click edit and verify the grid
#    Then Enter "Abcde" and Validate Answer order accepts only numerical value
#   Then Enter "11de" and Validate Answer order accepts only numerical value
#   Then Validate the form is reset
#   Then I click on Delete row from answer grid and verify the records
#   And Close Driver
#   
#   
#   Scenario: CMDM-30747_Admin Console Add records to answer choice grid	
#   Given user log in to LTSSadmin
#   When I enter Username as "clientadmin" and Password as "Test"
#   Then login should be successful
#   Then I enter the market name as "Iowa"
#   Then I click on Assessment builder
#   Then I click on Add Assessment with assessment name "Test"
#   And I click on Add Question
#   Then When I select "Radio Button" from question response the correct section is displayed
#   Then I click on scoring switch
#   Then Validate the fields present in answer section
#   Then Validate that error message displayed when answerorder is "Answer" and scoringvalue is "Score"
#   Then Validate the headers in the answer grid
#     
#   
#   Scenario: CMDM-31133_Admin Console: Create answer options grid inside questions grid
#   Given user log in to LTSSadmin
#   When I enter Username as "clientadmin" and Password as "Test"
#   Then login should be successful
#   Then I enter the market name as "Iowa"
#   Then I click on Assessment builder
#   Then I click on Add Assessment with assessment name "Test"
#   And I click on Add Question
#   Then When I select "Drop down" from question response the correct section is displayed
#   Then I select Answeroption as "Yes and No" and click on add
#   Then Validate the Answer grid for the choosen option as "Yes and No"
#   Then When I click on submit and add new in add question user shall land on the same page
#   Then When I select "Checkbox Group" from question response the correct section is displayed 
#   Then User select AnswerText "Noo" and Answerscore "" , click add and verify the grid
#    Then User enters "Question Description2", "Checkbox Group", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
#   Then When I click on submit in add question user shall land on the previous page
#   
#   
#   Scenario: CMDM-30783_Create Add Assessment page
#    	Given user log in to LTSSadmin
#	   	When I enter Username as "clientadmin" and Password as "Test"
#    	Then login should be successful
#    	Then I enter the market name as "Iowa"
#    	Then I click on Assessment builder
#    	Then I click on Add Assessment
#    	Then Verify Add Assessment page
#    	And Adding an Assessment
# 		And Verifying Added Assessment
#    	And Close Driver
#    	
#    	
#    Scenario: CMDM-31564_Edit an existing Assessment and CMDM-30977_Create "Add Section" page and CMDM-32020_Refactor - Add Section Validations
#    	Given user log in to LTSSadmin
#	   	When I enter Username as "clientadmin" and Password as "Test"
#    	Then login should be successful
#    	Then I enter the market name as "Iowa"
#	   	Then I click on Assessment builder
#	   	Then I click on Add Assessment with assessment name "Test" and do not click
#	   	And Adding an Assessment
#	   	Then Click on Edit Assessment
#	   	Then Editing the added Assessment
#	   	Then I click on Add Assessment with assessment name "Test"
#	   	Then Click on Add Section
#		Then Verifying the Section Modal window
#		And Adding and Verifying Main Section
#		Then Click on Add Section
#		And Adding the Second Main Section
#		Then Click on Add Section
#		And Adding and Verifying Sub Section
#		And I click on Add Question	
#		And Verifying the Added Sections in Assessment Section dropdown in Add Question page
#		Then Click on Add Section
#		And Verifying the Added Sections in Assessment Section dropdown in Add Section page	
#		And Close Driver
#		
#		Scenario: CMDM-31067_Create Assessment builder template grid
#    	Given user log in to LTSSadmin
#   		When I enter Username as "clientadmin" and Password as "Test"
#    	Then login should be successful
#    	Given I enter the market name as "Iowa"
#	   	Then I click on Assessment builder
#	   	Then I click on Add Assessment with assessment name "Test" and do not click
#	   	Then Click on Add Section
#	   	And Adding and Verifying Main Section
#    	Then Verify Assessment Template Grid
#		And Filtering the Assessment Template Grid	
#		And Verify Default section in Template Grid - enters "Question - Default Section", "Text Field"
#    	And Close Driver
#   	
#    	Scenario: CMDM-30784:Create Add Questions view, CMDM-31015:Add Questions data persist and CMDM-31576:Add Signature for Question Response Type at Add Question page
#	   Given user log in to LTSSadmin
#	   When I enter Username as "clientadmin" and Password as "Test"
#	   Then login should be successful
#	   Then I enter the market name as "Iowa"
# 	   Then I click on Assessment builder
#	   Then I click on Add Assessment with assessment name "Test"
#	   And I click on Add Question
#	   Then When I click on Back user shall land on the previous page
#	   And I click on Add Question
#	   Then Validate Add Question
#	   Then I select Answeroption as "Yes and No" and click on add
#	   Then When I click on submit and add new in add question user shall land on the same page
#	   And Validate form is saved and cleared for next question
#	  Then User enters "Question Description2", "Date", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
#	  Then When I click on submit in add question user shall land on the previous page
#	   Then Verify Assessment Template displays the added questions
#	   And Validate database for Questions added by user
#	 
Scenario: CMDM-30784:Create Add Questions view, CMDM-31015:Add Questions data persist, CMDM-31576:Add Signature for Question Response Type at Add Question page, CMDM-30978:Edit an existing Questions at an assessment template page,
    	CMDM-32117:Required Field: Assessment Section at Add/ Edit Question page,CMDM-30979:Delete an existing Questions at an assessment template page and CMDM-32227:Spike: Product Improvement Validations,
    	CMDM-33051:Add/Edit Question: Question Response type: Checkbox group
		Given user log in to LTSSadmin
	   	When I enter Username as "clientadmin" and Password as "Test"
	   	Then login should be successful
	   	Then I enter the market name as "Iowa"
 	   	Then I click on Assessment builder
	   	Then I click on Add Assessment with assessment name "Assessment Test 07062019"
	   	And I click on Add Scoring Category
   		Then When I enter CategoryName as "TestCategory" validate Add button is enabled
   		Then Enter ScoreRangeValue as "Range1" , ScoreLowRange as "2" and ScoreHighRange as "5" and submit
   		Then When I click on submit user shall land on the previous page
		Then Click on Add Section
		And Add Main Section
		Then Click on Add Section
		And Add Second Main Section
		Then Click on Add Section
		And Add Sub Section
		And I click on Add Question
#	    Then validate submit button is disabled when one or more mandatory fields user inputs are removed
	    Then When I click on Back user shall land on the previous page
	    And I click on Add Question
	    Then Validate whether the fields are reset and previously added data is cleared
	    Then Validate Add Question
	    Then Verify Checkbox and Checkbox Group changes
	    Then verify Please Select is a static value in Insert Answer
	    Then I select Answeroption as "Yes and No" and click on add
	    Then When I click on submit and add new in add question user shall land on the same page
	    And Validate form is saved and cleared for next question
	    Then User enters "Question Description2", "Drop down", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
	    Then I select Answeroption as "Gender" and click on add
	    Then When I click on submit in add question user shall land on the previous page
	    And I click on Add Question
	    Then When I click on Back user shall land on the previous page
	    Then Verify Assessment Template displays the added questions
	    And Validate database for Questions added by user
	    Then Validate Edit option for each question
	    Then Validate navigation to Edit Question Page of question "1"
#	    Then Validate breadcrumbs displayed
	    Then Validate Question section details displaying user provided input in Edit Question page
	    Then Validate buttons in the Edit Question page
	    Then I Edit the Question section
	    And I click on submit button
	    Then Validate Delete option for each question
	    Then I click on Delete button of first question
	    Then Validate Modal window on clicking delete button of a Question
	    Then I click on Cancel button and validate whether the modal window is closed
	    Then I click on Delete button of first question
	    Then I click on Yes in the modal window and validate whether the question is removed from Assessment Template grid
	    And Close Driver 	

Scenario: CMDM-31990:Generate order of Section and Question after user update
		Given user log in to LTSSadmin
	   	When I enter Username as "clientadmin" and Password as "Test"
	   	Then login should be successful
	   	Then I enter the market name as "Iowa"
	   	Then I click on Assessment builder
	   	Then I click on Add Assessment with assessment name "Assessment Test 11062019"
	   	And I click on Add Question
	   	Then Add Question with "Question Description1","Date" in Assessment Section "0"
	   	Then When I click on submit and add new in add question user shall land on the same page
	   	Then Add Question with "Question Description2","Date" in Assessment Section "0"
	   	Then When I click on submit and add new in add question user shall land on the same page
	   	Then Add Question with "Question Description3","Date" in Assessment Section "0"
	   	Then When I click on submit and add new in add question user shall land on the same page
	   	Then Add Question with "Question Description4","Date" in Assessment Section "0"
	   	Then When I click on submit in add question user shall land on the previous page
	   	Then Verify the Question Order and Question Id of "lnkexpanddefaultsection" section in Assessment template grid
#	   	Then Validate navigation to Edit Question Page of question "4"
#	   	Then I Edit Question Order of Question 4 to 2
#	    And I click on submit button
#	   Then Verify the Question Order and Question Id of "lnkexpanddefaultsection" section in Assessment template grid
	   	Then Click on Add Section
		And Add Main Section
		Then Verify Section Order number in Assessment template grid for "txtfirstmainsectionsectionorder"
		Then Click on Add Section
		And Add Sub Section
		Then Verify Section Order number in Assessment template grid for "txtsubundermainsectionorder"
		And I click on Add Question
	  Then Add Question with "Question Description5","Date" in Assessment Section "2"
	   Then When I click on submit in add question user shall land on the previous page
	   Then Verify the Question Order and Question Id of "lnkexpandsubsectionwithmain" section in Assessment template grid
	   Then Click on Add Section
		And Add Sub Section without Main Section
	  Then Verify Section Order number in Assessment template grid for "txtsubwithoutmainsectionorder"
	   Then Click on Add Section
	   And Add Second Main Section
	   Then Verify Section Order number in Assessment template grid for "txtsecondmainsectionorder"
	   Then Click on Add Section
	   And Add Second Sub Section without Main Section
	   Then Verify Section Order number in Assessment template grid for "txtsecondsubwithoutmainsectionorder"
#	   Then Update Main Section Type as Second Main Section for Second SubSection 
#	   Then Verify Section Order number in Assessment template grid for "txtsecondsubafterupdate"
#	   And I click on Add Question
#	   Then When I click on submit in add question user shall land on the previous page
#	   Then Verify the Question Order and Question Id of "lnkexpandsubsection2" section in Assessment template grid
	   And Close Driver  	
#
#	Scenario: CMDM-31738_Admin Console: Add label for Insert Answer functionality	
#	Given user log in to LTSSadmin
#   	When I enter Username as "clientadmin" and Password as "Test"
#   	Then login should be successful
#   	Then I enter the market name as "Iowa"
#   	Then I click on Assessment builder
#   	Then I click on Add Assessment with assessment name "Test"
#  	 And I click on Add Question
#	Then When I select "Drop down" from question response the correct section is displayed
#	Then I select Answeroption as "Gender" and click on add
#	Then Validate the Answer grid for the choosen option as "Gender"
#
# 	Scenario: CMDM-32201_Admin Console: Duplicate check in answer option
#	Given user log in to LTSSadmin
#   When I enter Username as "clientadmin" and Password as "Test1250"
#   Then login should be successful
#   Then I enter the market name as "Iowa"
#   Then I click on Assessment builder
#   Then I click on Add Assessment with assessment name "Test3940f"
#   And I click on Add Question	
#	Then When I select "Drop down" from question response the correct section is displayed
#	Then I select Answeroption as "Yes and No" and click on add
#	Then Validate the Answer grid for the choosen option as "Yes and No"
#	Then I select Answeroption as "Yes,No and Not Applicable" and click on add
#   Then Validate the Answer grid for the choosen option as "Yes,No and Not Applicable"
#  Then I click on scoring switch
#	Then Validate the Scoring Category field dropdown
#  Then User select AnswerText "XYZ" and Answerscore "1" , click add and verify the grid
#  Then When User add duplicate vaues, AnswerText "XYZ" and Answerscore "2" , verify error message is displayed
#  Then User select AnswerText "Test" and Answerscore "1" , click add and verify the grid
#  Then I click on Edit row from answer grid
#  Then When User edit duplicate vaues, AnswerText "XYZ" and Answerscore "2" , verify error message is displayed
#
#	Scenario: CMDM-32804_Admin Console: Duplicate check in answer option
#	Given user log in to LTSSadmin
#   	When I enter Username as "clientadmin" and Password as "Test1250"
#   	Then login should be successful
#	Then Select CM product admin
#	Then Select the Admin builder tool from the menu
#	Then Verify the programs present on dashboard
#	Then Verify Assessment Builder page headers
#	Then Verify Assessment Builder page buttons
#	

Scenario: CMDM-34251_Admin builder: Question Page: Add pagination on answer grid and add records to Insert Answer	
	Given user log in to LTSSadmin
   When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
   Then I click on Add Assessment with assessment name "Test"
   And I click on Add Question
   Then User enters "Question DescriptionRelationship", "Drop down", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Relationship" and click on add
	Then Validate the Answer grid for the choosen option as "Relationship"
	Then When I click on submit and add new in add question user shall land on the same page
	Then User enters "Question DescriptionRace", "Drop down", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Race" and click on add
	Then Validate the Answer grid for the choosen option as "Race"
	Then When I click on submit and add new in add question user shall land on the same page
	Then User enters "Question DescriptionEthnicity", "Drop down", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Ethnicity" and click on add
	Then Validate the Answer grid for the choosen option as "Ethnicity"
	Then When I click on submit and add new in add question user shall land on the same page
	Then User enters "Question DescriptionMaritalStatus", "Drop down", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Marital Status" and click on add
	Then Validate the Answer grid for the choosen option as "Marital Status"
	Then When I click on submit and add new in add question user shall land on the same page
	Then User enters "Question DescriptionAssistance", "Drop down", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Assistance" and click on add
	Then Validate the Answer grid for the choosen option as "Assistance"
	Then When I click on submit and add new in add question user shall land on the same page
	Then User enters "Question DescriptionSeverity", "Drop down", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Severity" and click on add
	Then Validate the Answer grid for the choosen option as "Severity"
	Then When I click on submit and add new in add question user shall land on the same page
	Then User enters "Question DescriptionFrequencyoftherapy", "Drop down", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Frequency of therapy" and click on add
	Then Validate the Answer grid for the choosen option as "Frequency of therapy"
	Then When I click on submit and add new in add question user shall land on the same page
	Then User enters "Question DescriptionPhysicianSpecialty", "Drop down", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Physician Specialty" and click on add
	Then Validate the Answer grid for the choosen option as "Physician Specialty"
	Then When I click on submit and add new in add question user shall land on the same page