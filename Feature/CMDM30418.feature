Feature: CMDM-30418_Admin Console: Choosing LTSS Market to Configure
 
	Scenario: CMDM-30516_Create Market Specific Dashboard
		Given user log in to LTSSadmin
  		When I enter Username as "clientadmin" and Password as "Test"
   		Then login should be successful
   		Given I enter the market name as "Iowa"	
		Then Validating the "Iowa" Market Specific Page
		Then Verify the Menu Bar in Selected Market Dashboard
		Then Navigating to Market list page
   		Given I enter the market name as "Florida"	 
		Then Validating the "Florida" Market Specific Page
		Then Verify the Menu Bar in Selected Market Dashboard
		Then Navigating to Market list page
		Given I enter the market name as "Iowa"	
   		Then I click on Assessment builder
   		Then Verify Assessment Builder page
    	And Close Driver

