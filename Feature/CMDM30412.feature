Feature: CMDM-30412:Admin Console: LTSS Market Structure

	 Scenario: CMDM-30513_Create Market Place list page
		Given user log in to LTSSadmin
   		When I enter Username as "clientadmin" and Password as "Test"
    	Then login should be successful 
    	Then validating Market List page
    	And Close Driver