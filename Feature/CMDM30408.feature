Feature: CMDM-30408:Admin Console: Enabler - Entity Attribute Add/Edit Screen - Branching Rules

	Scenario: CMDM-32120 CMDM-32121_Admin Console: Branching: Create branching question modalGiven user log in to LTSSadmin, CMDM-32234 Admin Console: Branching: 
			  Display branching logic question on the assessment page, CMDM-32122_Admin Console: Branching: Edit / Delete Branching logic questions
  	Given user log in to LTSSadmin
   When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
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
   
   
