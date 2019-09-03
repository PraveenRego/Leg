Feature: CMDM-30406:Admin Console: Associate Assessments/Forms to Tasks (LTSS-Specific)

 Scenario: CMDM-31582_Admin Console: Create assessment linking to task page (From Assessment page), CMDM-32149_Admin Builder: 
 Change validation logic for submit button on Assessment linking to task
	Given user log in to LTSSadmin
   	When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
   Then I click on Add Assessment with assessment name "Assessment31582"
   Then I click on Link to Tasks
   Then validate Assessmentname in Link to Task page
   Then validate Add button enabled with Taskname "Annual Assessment"
   Then Click Add button
   Then validate tasks table headers
   Then validate delete button
   Then validate table data in the link to task grid with Taskname "Annual Assessment" and Required field "No"
   Then When I click on submit in add question user shall land on the previous page
    Then I click on Link to Tasks
    Then validate table data in the link to task grid with Taskname "Annual Assessment" and Required field "No"
    Then Get the row number from grid
    Then validate Add button enabled with Taskname "Initial Outreach"
    Then Set the Assessment form switch
    Then Click Add button
    Then validate table data in the link to task grid with Taskname "Initial Outreach" and Required field "Yes"
    Then When I click on Back user shall land on the previous page
    Then I click on Link to Tasks
    Then Validate that after Back button the added value is not present in grid
    And Close Driver
    
    Scenario: CMDM-31583_Admin Console: Create assessment linking to task page (From Dashboard)
	Given user log in to LTSSadmin
   When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
   Then I click on Add Assessment with assessment name "AssessmenttestCMDM31583"
   Then When I click on submit in add assessment user shall land on the previous page
   Then Filter the Assessment grid with the recently added
 	Then I click on Link button from Assessment Dashboard
   Then validate Assessmentname in Link to Task page
   Then validate Add button enabled with Taskname "Case Assignment"
   Then Click Add button
   Then validate tasks table headers
   Then validate delete button
   Then validate table data in the link to task grid with Taskname "Case Assignment" and Required field "No"
   Then When I click on submit in add assessment user shall land on the previous page
   Then Filter the Assessment grid with the recently added
    Then I click on Link button from Assessment Dashboard
    Then validate table data in the link to task grid with Taskname "Case Assignment" and Required field "No"
    Then Get the row number from grid
    Then validate Add button enabled with Taskname "Demographic Change"
    Then Set the Assessment form switch
    Then Click Add button
    Then validate table data in the link to task grid with Taskname "Demographic Change" and Required field "Yes"
    Then When I click on Back user shall land on the previous page
    Then Filter the Assessment grid with the recently added
     Then I click on Link button from Assessment Dashboard
     Then Validate that after Back button the added value is not present in grid
    And Close Driver
    
