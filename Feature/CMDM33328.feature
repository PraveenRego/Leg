Feature: CMDM-33328:Admin Console: Scoring Annotation Code Generation
	Scenario: CMDM-33368_Admin Console: Create branching logic question on the assessment preview
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
   Then When I click on submit in add question user shall land on the previous page
   Then I click on Add Question
   And I Add question description as "Description one"
   Then When I select "Checkbox Group" from question response the correct section is displayed
   Then I select Section as "Main"
   Then I select Answeroption as "Yes,No and Not Applicable" and click on add
    Then When I click on submit in add question user shall land on the previous page
  Then I click Edit first question
  Then I click branching button
  Then Add question
  Then Click submit in branching modal and add question
  Then Filter Assessment for preview branching
  Then Click on Preview of the created Assessment
  Then Verify question as "Description one" in Preview for option as "Yes" and branching question as "Description"