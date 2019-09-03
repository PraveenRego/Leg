Feature: CMDM-30411:Admin Console: Question Back-End Linking/Mapping to DataMart for GBD Questions
   Scenario: CMDM-33385_Admin Console: Generate unique Concept ID for each question
   Given user log in to LTSSadmin
   When I enter Username as "clientadmin" and Password as "Test"
   Then login should be successful
   Then I enter the market name as "Iowa"
   Then I click on Assessment builder
  Then I click on Add Assessment with assessment name "AssessmenttestCM54567634" and do not click
   And I click on Add Question
   Then I Validate concept id
 
 And Verify Default section in Template Grid - enters "Question - Default Section", "Signature", "Default Section"
 
#  Then When I click on submit in add question user shall land on the previous page
 #  Then When I click on submit in add question user shall land on the previous page
   Then I Edit recently changed Assesment
   And I click on Existing question   
  Then I click on Edit Assesment
   And I click on Add Question
  Then I Validate concept id
