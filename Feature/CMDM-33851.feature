Feature: CMDM-33851:Admin Console: CMDM: Automation

 Scenario: CMDM-32809_Admin Console: Reuse Add Question page for CMDM assessment builder
 Given user log in to LTSSadmin
 When I enter Username as "clientadmin" and Password as "Test1250"
 Then login should be successful
 Then Select CM product admin
 Then Select the Admin builder tool from the menu
 Then Verify the programs present on dashboard
 Then Verify Assessment Builder page headers
 Then Verify Assessment Builder page buttons
 

#Scenario: CMDM-32901_Admin Console: Scoring: Create Combine Scoring Categories page
#   Given user log in to LTSSadmin
#   	When I enter Username as "clientadmin" and Password as "Test1250"
#   	Then login should be successful
#	Then Select CM product admin
#	When I enter Username as "clientadmin" and Password as "Test1250"
#	Then Select the Admin builder tool from the menu
#	Then Verify the programs present on dashboard
#	Then Click the programs present on dashboard
#   Then I click on Add Assessment with assessment name "Test"
#    And I click on Add Scoring Category
#   Then When I enter CategoryName as "CategoryAdd1" validate Add button is enabled
#   Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "1" and ScoreHighRange as "6" and submit
#    Then When I click on submit user shall land on the previous page
#    And I click on Add Scoring Category
#   Then When I enter CategoryName as "CategoryAdd2" validate Add button is enabled
#   Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "7" and ScoreHighRange as "8" and submit
#     Then When I click on submit user shall land on the previous page
# 	And I click on Add Scoring Category
#   Then When I enter CategoryName as "CategoryAdd3" validate Add button is enabled
#   Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "9" and ScoreHighRange as "11" and submit
#     Then When I click on submit user shall land on the previous page
#   And I click on Add Combine Scoring Category
#   Then Validate Page title
#   Then Validate the fields present in Combined Scoring Page
#   Then Enter Group Category Description as "Groupcategoryadd"
#    Then Select the first value from Scoring Category
#   Then Select the first value from Scoring Category
#   Then set added scoring category value
#   Then When I select invalid ScoreLowRange as "Low" and ScoreHighRange as "High" validate error message displayed in combine score category
#   Then When I select high ScoreLowRange as "5" and low ScoreHighRange as "2" validate error message displayed
#     Then Enter in Combine Scoring Categories, ScoreRangeValue as "TestRange" , ScoreLowRange as "2" and ScoreHighRange as "6" and submit
#    Then When I select overlapped ScoreRangeValue as "TestRange", ScoreLowRange as "2" and ScoreHighRange as "4" validate error message displayed
#   Then When I click on submit user shall land on the previous page
#   And I click on Add Combine Scoring Category
#   Then When I click on Back user shall land on the previous page
#   Then Filter the scoring categories grid with Scoring Category name "Groupcategoryadd"
#   Then Verify the Filter of Group scoring categories grid with Scoring Category name "Groupcategoryadd",ScoreRangeValue "TestRange", ScoreLowRange "2" and ScoreHighRange "6"
# 	 And Close Driver


Scenario: CMDM-32120 CMDM-32121_Admin Console: Branching: Create branching question modalGiven user log in to LTSSadmin, CMDM-32234 Admin Console: Branching: 
			  Display branching logic question on the assessment page, CMDM-32122_Admin Console: Branching: Edit / Delete Branching logic questions
  	  Given user log in to LTSSadmin
   	When I enter Username as "clientadmin" and Password as "Test1250"
   	Then login should be successful
	Then Select CM product admin
	When I enter Username as "clientadmin" and Password as "Test1250"
	Then Select the Admin builder tool from the menu
	Then Verify the programs present on dashboard
	Then Click the programs present on dashboard
   Then I click on Add Assessment with assessment name "Test"
   Then I click on Add Section with section name as "Main"
   Then I click on Add Question
   And I Add question description as "Description"
   Then When I select "Drop down" from question response the correct section is displayed
   Then I select Section as "Main"
   Then I select Answeroption as "Yes and No" and click on add
   Then Verify no child grid is present when no branch section is added
   Then When I click on submit in add question user shall land on the previous page
   Then Verify no child grid is present when no branch section is added in Question grid as "Description"
   Then I click on Add Question
   And I Add question description as "Description one"
   Then When I select "Checkbox Group" from question response the correct section is displayed
   Then I select Section as "Main"
   Then I select Answeroption as "Yes,No and Not Applicable" and click on add
   Then I click branching button
   Then verify on load section as "Main"
   Then verify all sections present in filter
   Then verify picklist in modal
   Then verify Add button enable and disable
   Then Add question
   Then verify Branched Questions grid
   Then verify Submit and Close buttons in modal
   Then When I click Submit verify question is added as a branched question is "Main" and question description is "Description"
   Then I click Submit in Add question page
   Then verify Branching in Question is "Main" and question description is "Description" and question branched is "Description one"
   And I click on Add Question
   And I Add question description as "Description two"
   Then When I select "Checkbox Group" from question response the correct section is displayed
   Then I select Section as "Main"
    Then I select Answeroption as "Yes and No" and click on add
   Then I click branching button
   Then verify all sections present in filter
   Then Add question
    Then When I click Submit verify question is added as a branched question is "Main" and question description is "Description"
 	 Then I click branching button
 	 Then verify on load section as "Main"
 	 Then Add question
 	 Then Edit the values in branch questions and verify 	 
 	 Then When I click Delete button verify question is deleted from the branched question
 	 Then I click Submit&AddNew in Add question page
  	Then I click Back in Add question page
    Then verify Branching in Question is "Main" and question description is "Description" and question branched is "Description two"
     And I click on Add Question
 	And I Add question description as "Description three"
 	Then When I select "Drop down" from question response the correct section is displayed
   Then I select Section as "Main"
    Then I select Answeroption as "Yes,No and Not Applicable" and click on add
    Then I click branching button
    Then verify all sections present in filter
    Then Add question
   Then verify Branched Questions grid
   Then When I click Close verify question is not added as a branched question
   And Close Driver
   
   
   Scenario: CMDM-32900_CMDM_Admin Console: Add/Edit Scoring category
	Given user log in to LTSSadmin
   	When I enter Username as "clientadmin" and Password as "Test1250"
   	Then login should be successful
	Then Select CM product admin
	When I enter Username as "clientadmin" and Password as "Test1250"
	Then Select the Admin builder tool from the menu
	Then Verify the programs present on dashboard
	Then Click the programs present on dashboard
   Then I click on Add Assessment with assessment name "Test33851Story"
   And I click on Add Scoring Category
   Then When I enter CategoryName as "CategoryAdd" validate Add button is enabled
   Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "1" and ScoreHighRange as "6" and submit
   Then I click on Edit row from answer grid
   Then Enter ScoreRangeValue as "EditRange" , ScoreLowRange as "3" and ScoreHighRange as "8" and Save
   Then I click on Delete row from answer grid and verify the records
   And Close Driver
   
   Scenario: CMDM-32804_Admin Console: Create Program selection page
	Given user log in to LTSSadmin
   	When I enter Username as "clientadmin" and Password as "Test1250"
   	Then login should be successful
	Then Select CM product admin
	When I enter Username as "clientadmin" and Password as "Test1250"
	Then Select the Admin builder tool from the menu
	Then Verify the programs present on dashboard
	And Close Driver
