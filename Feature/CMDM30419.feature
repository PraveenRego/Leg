Feature: CMDM-30419:Admin Console: Enabler - Assessments - Scoring

 Scenario: CMDM-31127_Admin Console: Scoring: Create Add Scoring category page
   Given user log in to LTSSadmin
   When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
   Then I click on Add Assessment with assessment name "Testokg"
   And I click on Add Scoring Category
   Then When I select invalid ScoreLowRange as "Low" and ScoreHighRange as "High" validate error message displayed
  Then When I select high ScoreLowRange as "5" and low ScoreHighRange as "2" validate error message displayed
   Then When I enter CategoryName as "TestCategory" validate Add button is enabled
   Then Enter ScoreRangeValue as "Range1" , ScoreLowRange as "2" and ScoreHighRange as "5" and submit
   Then When I select overlapped ScoreRangeValue as "TestRange", ScoreLowRange as "2" and ScoreHighRange as "4" validate error message displayed
   Then Validate the Scoring Category grid headers
   Then When I click on submit user shall land on the previous page
   And I click on Add Scoring Category
   Then When I click on Back user shall land on the previous page
   And Close Driver 
   
   Scenario: CMDM-31163_Admin Console: Scoring: Edit/Delete scoring Categories
    Given user log in to LTSSadmin
   When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
   Then I click on Add Assessment with assessment name "Test"
   And I click on Add Scoring Category
   Then When I enter CategoryName as "CategoryAdd" validate Add button is enabled
   Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "1" and ScoreHighRange as "6" and submit
   Then I click on Edit row from answer grid
   Then Enter ScoreRangeValue as "EditRange" , ScoreLowRange as "3" and ScoreHighRange as "8" and Save
   Then I click on Delete row from answer grid and verify the records
   And Close Driver
   
   Scenario: CMDM-32164_Admin Console: Scoring: Edit/Delete Scoring Categories
     Given user log in to LTSSadmin
   	When I enter Username as "clientadmin" and Password as "Test"
   	Then login should be successful
   	Then I enter the market name as "Iowa"
   	Then I click on Assessment builder
   	Then I click on Add Assessment with assessment name "Tedfcdfb"
   	And I click on Add Scoring Category
   	Then When I enter CategoryName as "CategoryAdd" validate Add button is enabled
   	Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "1" and ScoreHighRange as "6" and submit
   	Then When I click on submit user shall land on the previous page
   	Then Filter the scoring categories grid with Scoring Category name "CategoryAdd"
   	Then Verify the Filter of scoring categories grid with Scoring Category name "CategoryAdd",ScoreRangeValue "TestRange", ScoreLowRange "1" and ScoreHighRange "6"
   	And click scoringcategories grid edit
  	Then Enter ScoreRangeValue as "TestRange2" , ScoreLowRange as "7" and ScoreHighRange as "9" and submit
  Then I click on Edit row from answer grid
     Then When I edit and select overlapped ScoreRangeValue as "TestRange", ScoreLowRange as "2" and ScoreHighRange as "4" validate error message displayed
   Then Enter ScoreRangeValue as "EditRange" , ScoreLowRange as "10" and ScoreHighRange as "11" and Save
   Then Enter ScoreRangeValue as "SecondTestRange" , ScoreLowRange as "12" and ScoreHighRange as "15" and submit
   	Then When I click on submit user shall land on the previous page
   	Then Verify the Filter of scoring categories grid with Scoring Category name "CategoryAdd",ScoreRangeValue "TestRange", ScoreLowRange "1" and ScoreHighRange "6"
   	Then click scoringcategories grid delete and verify
   	And Close Driver
   
   Scenario: CMDM-31167_Admin Console: Scoring: Edit/Delete Combined Scoring Categories
    Given user log in to LTSSadmin
   When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
   Then I click on Add Assessment with assessment name "Testmbkfm"
   And I click on Add Scoring Category
   Then When I enter CategoryName as "CategoryAdd1" validate Add button is enabled
   Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "1" and ScoreHighRange as "6" and submit
    Then When I click on submit user shall land on the previous page
    And I click on Add Scoring Category
   Then When I enter CategoryName as "CategoryAdd2" validate Add button is enabled
   Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "7" and ScoreHighRange as "8" and submit
     Then When I click on submit user shall land on the previous page
 	And I click on Add Scoring Category
   Then When I enter CategoryName as "CategoryAdd3" validate Add button is enabled
   Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "9" and ScoreHighRange as "11" and submit
     Then When I click on submit user shall land on the previous page
   And I click on Add Combine Scoring Category
   Then Enter Group Category Description as "Groupcategoryadd"
   Then Select the first value from Scoring Category
   Then Select the first value from Scoring Category
   Then Select the first value from Scoring Category
   Then Enter in Combine Scoring Categories, ScoreRangeValue as "TestRange" , ScoreLowRange as "4" and ScoreHighRange as "6" and submit
    Then I click on Edit row from answer grid
   Then When I select high ScoreLowRange as "5" and low ScoreHighRange as "2" validate error message displayed
   Then Enter in Combine Scoring Categories, ScoreRangeValue as "EditRange" , ScoreLowRange as "5" and ScoreHighRange as "9" and save
    Then Enter in Combine Scoring Categories, ScoreRangeValue as "TestRange" , ScoreLowRange as "1" and ScoreHighRange as "4" and submit
   Then I click on Edit row from answer grid
   Then When I edit and select overlapped ScoreRangeValue as "TestRange2", ScoreLowRange as "5" and ScoreHighRange as "7" validate error message displayed
   Then I click on Delete row from answer grid and verify the records
   And Close Driver
  
    Scenario: CMDM-31219_Admin Console: Scoring: Create grid for Scoring category
    Given user log in to LTSSadmin
   	When I enter Username as "clientadmin" and Password as "Test"
   	Then login should be successful
   	Then I enter the market name as "Iowa"
   	Then I click on Assessment builder
   	Then I click on Add Assessment with assessment name "Test"
   	And I click on Add Scoring Category
   	Then When I enter CategoryName as "CategoryAdd" validate Add button is enabled
   	Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "1" and ScoreHighRange as "6" and submit
   	Then When I click on submit user shall land on the previous page
   	Then verify scoring categories header and the grid displays only 5 records per page
   	Then Filter the scoring categories grid with Scoring Category name "CategoryAdd"
   	Then Verify the Filter of scoring categories grid with Scoring Category name "CategoryAdd",ScoreRangeValue "TestRange", ScoreLowRange "1" and ScoreHighRange "6"
   	Then verify scoringcategories grid headers
   	And Close Driver

Scenario: CMDM-31127_Admin Console: Scoring: Create Add Scoring category page
   Given user log in to LTSSadmin
   When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
   Then I click on Add Assessment with assessment name "Testokg"
   And I click on Add Scoring Category
   Then When I select invalid ScoreLowRange as "Low" and ScoreHighRange as "High" validate error message displayed
  Then When I select high ScoreLowRange as "5" and low ScoreHighRange as "2" validate error message displayed
   Then When I enter CategoryName as "TestCategory" validate Add button is enabled
   Then Enter ScoreRangeValue as "Range1" , ScoreLowRange as "2" and ScoreHighRange as "5" and submit
   Then When I select overlapped ScoreRangeValue as "TestRange", ScoreLowRange as "2" and ScoreHighRange as "4" validate error message displayed
   Then Validate the Scoring Category grid headers
   Then When I click on submit user shall land on the previous page
   And I click on Add Scoring Category
   Then When I click on Back user shall land on the previous page
   And Close Driver 
   
   Scenario: CMDM-31163_Admin Console: Scoring: Edit/Delete scoring Categories
    Given user log in to LTSSadmin
   When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
   Then I click on Add Assessment with assessment name "Test"
   And I click on Add Scoring Category
   Then When I enter CategoryName as "CategoryAdd" validate Add button is enabled
   Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "1" and ScoreHighRange as "6" and submit
   Then I click on Edit row from answer grid
   Then Enter ScoreRangeValue as "EditRange" , ScoreLowRange as "3" and ScoreHighRange as "8" and Save
   Then I click on Delete row from answer grid and verify the records
   And Close Driver
   
   Scenario: CMDM-32164_Admin Console: Scoring: Edit/Delete Scoring Categories
     Given user log in to LTSSadmin
   	When I enter Username as "clientadmin" and Password as "Test"
   	Then login should be successful
   	Then I enter the market name as "Iowa"
   	Then I click on Assessment builder
   	Then I click on Add Assessment with assessment name "Tedfcdfb"
   	And I click on Add Scoring Category
   	Then When I enter CategoryName as "CategoryAdd" validate Add button is enabled
   	Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "1" and ScoreHighRange as "6" and submit
   	Then When I click on submit user shall land on the previous page
   	Then Filter the scoring categories grid with Scoring Category name "CategoryAdd"
   	Then Verify the Filter of scoring categories grid with Scoring Category name "CategoryAdd",ScoreRangeValue "TestRange", ScoreLowRange "1" and ScoreHighRange "6"
   	And click scoringcategories grid edit
  	Then Enter ScoreRangeValue as "TestRange2" , ScoreLowRange as "7" and ScoreHighRange as "9" and submit
  Then I click on Edit row from answer grid
     Then When I edit and select overlapped ScoreRangeValue as "TestRange", ScoreLowRange as "2" and ScoreHighRange as "4" validate error message displayed
   Then Enter ScoreRangeValue as "EditRange" , ScoreLowRange as "10" and ScoreHighRange as "11" and Save
   Then Enter ScoreRangeValue as "SecondTestRange" , ScoreLowRange as "12" and ScoreHighRange as "15" and submit
   	Then When I click on submit user shall land on the previous page
   	Then Verify the Filter of scoring categories grid with Scoring Category name "CategoryAdd",ScoreRangeValue "TestRange", ScoreLowRange "1" and ScoreHighRange "6"
   	Then click scoringcategories grid delete and verify
   	And Close Driver
   
   Scenario: CMDM-31167_Admin Console: Scoring: Edit/Delete Combined Scoring Categories
    Given user log in to LTSSadmin
   When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
   Then I click on Add Assessment with assessment name "Testmbkfm"
   And I click on Add Scoring Category
   Then When I enter CategoryName as "CategoryAdd1" validate Add button is enabled
   Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "1" and ScoreHighRange as "6" and submit
    Then When I click on submit user shall land on the previous page
    And I click on Add Scoring Category
   Then When I enter CategoryName as "CategoryAdd2" validate Add button is enabled
   Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "7" and ScoreHighRange as "8" and submit
     Then When I click on submit user shall land on the previous page
 	And I click on Add Scoring Category
   Then When I enter CategoryName as "CategoryAdd3" validate Add button is enabled
   Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "9" and ScoreHighRange as "11" and submit
     Then When I click on submit user shall land on the previous page
   And I click on Add Combine Scoring Category
   Then Enter Group Category Description as "Groupcategoryadd"
   Then Select the first value from Scoring Category
   Then Select the first value from Scoring Category
   Then Select the first value from Scoring Category
   Then Enter in Combine Scoring Categories, ScoreRangeValue as "TestRange" , ScoreLowRange as "4" and ScoreHighRange as "6" and submit
    Then I click on Edit row from answer grid
   Then When I select high ScoreLowRange as "5" and low ScoreHighRange as "2" validate error message displayed
   Then Enter in Combine Scoring Categories, ScoreRangeValue as "EditRange" , ScoreLowRange as "5" and ScoreHighRange as "9" and save
    Then Enter in Combine Scoring Categories, ScoreRangeValue as "TestRange" , ScoreLowRange as "1" and ScoreHighRange as "4" and submit
   Then I click on Edit row from answer grid
   Then When I edit and select overlapped ScoreRangeValue as "TestRange2", ScoreLowRange as "5" and ScoreHighRange as "7" validate error message displayed
   Then I click on Delete row from answer grid and verify the records
   And Close Driver
  
    Scenario: CMDM-31219_Admin Console: Scoring: Create grid for Scoring category
    Given user log in to LTSSadmin
   	When I enter Username as "clientadmin" and Password as "Test"
   	Then login should be successful
   	Then I enter the market name as "Iowa"
   	Then I click on Assessment builder
   	Then I click on Add Assessment with assessment name "Test"
   	And I click on Add Scoring Category
   	Then When I enter CategoryName as "CategoryAdd" validate Add button is enabled
   	Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "1" and ScoreHighRange as "6" and submit
   	Then When I click on submit user shall land on the previous page
   	Then verify scoring categories header and the grid displays only 5 records per page
   	Then Filter the scoring categories grid with Scoring Category name "CategoryAdd"
   	Then Verify the Filter of scoring categories grid with Scoring Category name "CategoryAdd",ScoreRangeValue "TestRange", ScoreLowRange "1" and ScoreHighRange "6"
   	Then verify scoringcategories grid headers
   	And Close Driver

    Scenario: CMDM-31128_Admin Console: Scoring: Create Combine Scoring Categories page, CMDM-31220_Admin Console: Scoring: Create grid for Combined Scoring category
   Given user log in to LTSSadmin
   When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
   Then I click on Add Assessment with assessment name "Test"
    And I click on Add Scoring Category
   Then When I enter CategoryName as "CategoryAdd1" validate Add button is enabled
   Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "1" and ScoreHighRange as "6" and submit
    Then When I click on submit user shall land on the previous page
    And I click on Add Scoring Category
   Then When I enter CategoryName as "CategoryAdd2" validate Add button is enabled
   Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "7" and ScoreHighRange as "8" and submit
     Then When I click on submit user shall land on the previous page
 	And I click on Add Scoring Category
   Then When I enter CategoryName as "CategoryAdd3" validate Add button is enabled
   Then Enter ScoreRangeValue as "TestRange" , ScoreLowRange as "9" and ScoreHighRange as "11" and submit
     Then When I click on submit user shall land on the previous page
   And I click on Add Combine Scoring Category
   Then Validate Page title
   Then Validate the fields present in Combined Scoring Page
   Then Enter Group Category Description as "Groupcategoryadd"
    Then Select the first value from Scoring Category
   Then Select the first value from Scoring Category
   Then set added scoring category value
   Then When I select invalid ScoreLowRange as "Low" and ScoreHighRange as "High" validate error message displayed in combine score category
   Then When I select high ScoreLowRange as "5" and low ScoreHighRange as "2" validate error message displayed
     Then Enter in Combine Scoring Categories, ScoreRangeValue as "TestRange" , ScoreLowRange as "2" and ScoreHighRange as "6" and submit
    Then When I select overlapped ScoreRangeValue as "TestRange", ScoreLowRange as "2" and ScoreHighRange as "4" validate error message displayed
   Then When I click on submit user shall land on the previous page
   And I click on Add Combine Scoring Category
   Then When I click on Back user shall land on the previous page
   Then Filter the scoring categories grid with Scoring Category name "Groupcategoryadd"
   Then Verify the Filter of Group scoring categories grid with Scoring Category name "Groupcategoryadd",ScoreRangeValue "TestRange", ScoreLowRange "2" and ScoreHighRange "6"
 	 And Close Driver

 	Scenario: CMDM-31472_Admin Console: Scoring: Make scoring mandatory field when (Include in scoring= True)	
	Given user log in to LTSSadmin
  	When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
   Then I click on Add Assessment with assessment name "Test"
   And I click on Add Question	
   Then User enters "Question Description2", "Drop down", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
   Then I click on scoring switch
   Then I select Answeroption as "Yes and No" and click on add
   Then When I click on submit error message is displayed
   Then I click on Delete row from answer grid and verify the records
   Then I click on Delete row from answer grid and verify the records
   Then User select AnswerText "No" and Answerscore "" , click add and verify the grid
   Then User enters "Question Description2", "Drop down", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
   Then When I click on submit error message is displayed
    Then I click on Delete row from answer grid and verify the records
   Then User select AnswerText "Yes" and Answerscore "5" , click add and verify the grid
   Then When I click on submit in add question user shall land on the previous page
   And Close Driver
   
   Scenario: CMDM-31472_Admin Console: Scoring: Make scoring mandatory field when (Include in scoring= True)	
	Given user log in to LTSSadmin
  	When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
   Then I click on Add Assessment with assessment name "Test"
   And I click on Add Question	
   Then User enters "Question Description2", "Drop down", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
   Then I click on scoring switch
   Then I select Answeroption as "Yes and No" and click on add
   Then When I click on submit error message is displayed
   Then I click on Delete row from answer grid and verify the records
   Then I click on Delete row from answer grid and verify the records
   Then User select AnswerText "No" and Answerscore "" , click add and verify the grid
   Then User enters "Question Description2", "Drop down", "Concept Code Description2", "Concept Code", "Concept ID2", "Default Section" and "Tool tip2"
   Then When I click on submit error message is displayed
    Then I click on Delete row from answer grid and verify the records
   Then User select AnswerText "Yes" and Answerscore "5" , click add and verify the grid
   Then When I click on submit in add question user shall land on the previous page
   And Close Driver
   
   
   