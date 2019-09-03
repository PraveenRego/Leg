Feature: NoEpic:Test

Scenario: CMDM-34251_Admin builder: Question Page: Add pagination on answer grid and add records to Insert Answer	
	Given user log in to LTSSadmin
   When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
    Then I click on Add Assessment and add Assessment
   And I click on Add Question
     Then User enters "Question DescriptionRelationship", "Drop down", "Concept Code Description2", "Concept Code", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Relationship" and click on add
	Then Validate the Answer grid for the choosen option as "Relationship"
	Then When I click on submit and add new in add question user shall land on the same page
Then User enters "Question DescriptionRace", "Drop down", "Concept Code Description2", "Concept Code", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Race" and click on add
	Then Validate the Answer grid for the choosen option as "Race"
	Then When I click on submit and add new in add question user shall land on the same page
	Then User enters "Question DescriptionEthnicity", "Drop down", "Concept Code Description2", "Concept Code", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Ethnicity" and click on add
	Then Validate the Answer grid for the choosen option as "Ethnicity"
	Then When I click on submit and add new in add question user shall land on the same page
		Then User enters "Question DescriptionMaritalStatus", "Drop down", "Concept Code Description2", "Concept Code", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Marital Status" and click on add
	Then Validate the Answer grid for the choosen option as "Marital Status"
	Then When I click on submit and add new in add question user shall land on the same page
	Then User enters "Question DescriptionAssistance", "Drop down", "Concept Code Description2", "Concept Code", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Assistance" and click on add
	Then Validate the Answer grid for the choosen option as "Assistance"
	Then When I click on submit and add new in add question user shall land on the same page
	Then User enters "Question DescriptionSeverity", "Drop down", "Concept Code Description2", "Concept Code", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Severity" and click on add
	Then Validate the Answer grid for the choosen option as "Severity"
	Then When I click on submit and add new in add question user shall land on the same page
		Then User enters "Question DescriptionFrequencyoftherapy", "Drop down", "Concept Code Description2", "Concept Code", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Frequency of therapy" and click on add
	Then Validate the Answer grid for the choosen option as "Frequency of therapy"
	Then When I click on submit and add new in add question user shall land on the same page
Then User enters "Question DescriptionPhysicianSpecialty", "Drop down", "Concept Code Description2", "Concept Code", "Default Section" and "Tool tip2"
	Then I select Answeroption as "Physician Specialty" and click on add
	Then Validate the Answer grid for the choosen option as "Physician Specialty"
	Then When I click on submit and add new in add question user shall land on the same page
	
		Scenario: CMDM-34531_Admin Console: Scoring enhancements
    Given user log in to LTSSadmin
   When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
   Then I click on Add Assessment and add Assessment
	And I click on Add Question
   And I Add question description as "Description one"
   Then validate answer score when "Checkbox" as Questionresponsetype 
   Then I Enter Answer Score as "10" 
   Then I Enter Assesment section as "Default Section"
   Then I click Submit in Add question page
   And I click on Add Question
   And I Add question description as "Description two"
   Then validate answer score when "Text Field" as Questionresponsetype
   Then I Enter Answer Score as "10" 
   Then I Enter Assesment section as "Default Section"
   Then I click Submit in Add question page
   
      	Scenario: CMDM-32804_Admin Console: Duplicate check in answer option
	Given user log in to LTSSadmin
   	When I enter Username as "clientadmin" and Password as "Test1250"
   	Then login should be successful
	Then Select CM product admin
	Then Select the Admin builder tool from the menu
	Then Verify the programs present on dashboard
	Then Verify Assessment Builder page headers
	Then Verify Assessment Builder page buttons
    And Close Driver
 
   
   