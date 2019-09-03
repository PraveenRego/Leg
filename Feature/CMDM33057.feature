Feature: CMDM-33057 - Admin Console: Assessment Builder Versioning

	Scenario: CMDM-34052 - Display previous versions of an assessment and CMDM-34053 - Validations for Edit & Publish modal window for versioning and CMDM-34055 - Navigate user to Edit Assessment of the previous version and CMDM-34056 - Navigate user to Re-Publish Assessment of the previous version	and CMDM-34982 - Versioning functionality improvements and CMDm-34058 - Update assessment Metadata from selected version to working model (Tech US)
	
			Given user log in to LTSSadmin
	   	When I enter Username as "clientadmin" and Password as "Test"
    	Then login should be successful
    	Then I enter the market name as "Iowa"
    	Then I click on Assessment builder
    #	Then I click on Add Assessment
      #And Adding an Assessment
 			And Verifying Added Assessment
 		
   		Then I click on Link button from Assessment Dashboard
   		Then validate Add button enabled with Taskname "Annual Assessment"
   		Then Click Add button
   		Then When I click on submit in add assessment user shall land on the previous page
 		
 			Then When I click Publish button in grid
  		Then When I select Environment as "SIT3"
   		Then When I enter Effective date as current date
  		Then Click on Publish button in Publish page
  		Then Click on Back button
  		
   		And Verifying Added Assessment  
   		When I click on Tempalte grid expand row 	   
			Then Verifying the previous versioning grid
			Then Validating the pagination of the Versioning grid
			Then I click on Edit Assessment Versioning button
			Then Validating the Edit Assessment Versioning modal window
			Then Click on Cancel button
			Then I Click on Re-Publish Versioning button
			Then Validating the Re-Publish Assessment modal window
			Then Click on Cancel button
			
			Then I click on Edit Assessment Versioning button
			Then Click on Submit button
			And Verify the page breadcrumb as "Assessment"
			Then Click on Back button
			
			And Verifying Added Assessment
			When I click on Tempalte grid expand row
			Then I Click on Re-Publish Versioning button
			Then Click on Submit button
			And Verify the page breadcrumb as "PublishAssessment"
			Then Click on Back button
			
			And Verifying Added Assessment
			When I click on Tempalte grid expand row
			Then Validating the Assessment name after click on Edit versioning	
			Then Click on Back button
			And Verifying Added Assessment
			When I click on Tempalte grid expand row
			Then Validaitng the Assesssment name after click on Republish Assessment
			Then Click on Back button
			
			And Verifying Added Assessment
			Then I click on Edit Assessment only
			And Editing the added Assessment
			When I click on Tempalte grid expand row
			Then Validating the Assessment name after click on Edit versioning	
			Then Click on Back button
			And Verifying Added Assessment
			When I click on Tempalte grid expand row
			Then Validaitng the Assesssment name after click on Republish Assessment
			Then Click on Back button