#Feature: CMDM-30417:Admin Console:Enabler - Assessments - Ability to Publish to Different Environments w/ No Release Needed
#	Scenario: CMDM-32443_Admin Console: Create publish screen for LTSS assessment
#	
#	Given user log in to LTSSadmin
#   	When I enter Username as "clientadmin" and Password as "Test"
#   	Then login should be successful
#   	Then I enter the market name as "Iowa"
#   	Then I click on Assessment builder
#   	Then I click on Add Assessment with assessment name "Test"
#    Then I click on Add Section with section name as "Main"
#   Then I click on Add Question
#   And I Add question description as "Description"
#   Then When I select "Drop down" from question response the correct section is displayed
#   Then I select Section as "Main"
#   Then I select Answeroption as "Yes and No" and click on add
#   Then When I click on submit after in add question page
#   Then Filter the Assessment grid with the recently added
#   Then When I click Publish button in grid
#   Then Verify attributes in publish assessment page
#   Then Verify Environment and Effective Date are mandatory fields
#   Then When I select Environment as "DEV"
#   Then When I enter Effective Date as "06/06/2019"
#   Then Verify Publish Grid
#   Then When I click Publish button verify Environment as "DEV" and Effective Date as "06/06/2019"
#   Then When I click on Back in Publish page user shall land on the previous page
#    And Close Driver
#   
#  