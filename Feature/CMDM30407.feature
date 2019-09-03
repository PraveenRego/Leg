Feature: CMDM-30407_Admin Console: Assessments - Incorporate Existing Assessment Builder Functionality

 Scenario: CMDM-32734_Admin Console Preview of an Assessment at Assessment/Forms Grid 
   	 Given user log in to LTSSadmin
  	 When I enter Username as "clientadmin" and Password as "Test"
   	 Then login should be successful
     Then I enter the market name as "Iowa"
 	 Then I click on Assessment builder
	 Then I click on Add Assessment with assessment name "Assessment Test 2752019"
	 And I click on Add Question
	 Then Add Question with "Default Section Question Description1","Checkbox" in Assessment Section "0"
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Default Section Question Description2","Checkbox Group" in Assessment Section "0"
	 Then I select Answeroption as "Yes and No" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Default Section Question Description3","Date" in Assessment Section "0"
	 Then When I click on submit and add new in add question user shall land on the same page
     Then Add Question with "Default Section Question Description4","Drop down" in Assessment Section "0"
     Then I select Answeroption as "Yes,No and Not Applicable" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Default Section Question Description5","Radio Button" in Assessment Section "0"
	 Then I select Answeroption as "Gender" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Default Section Question Description6","Signature" in Assessment Section "0"
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Default Section Question Description7","Text Area" in Assessment Section "0"
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Default Section Question Description8","Text Field" in Assessment Section "0"
	 Then When I click on submit in add question user shall land on the previous page
	 Then Click on Add Section
	 And Add Main Section
	 And I click on Add Question
	 Then Add Question with "Main Section Question Description1","Checkbox" in Assessment Section "1"
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Main Section Question Description2","Checkbox Group" in Assessment Section "1"
	 Then I select Answeroption as "Yes and No" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Main Section Question Description3","Date" in Assessment Section "1"
	 Then When I click on submit and add new in add question user shall land on the same page
     Then Add Question with "Main Section Question Description4","Drop down" in Assessment Section "1"
     Then I select Answeroption as "Yes,No and Not Applicable" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Main Section Question Description5","Radio Button" in Assessment Section "1"
	 Then I select Answeroption as "Gender" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Main Section Question Description6","Signature" in Assessment Section "1"
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Main Section Question Description7","Text Area" in Assessment Section "1"
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "Main Section Question Description8","Text Field" in Assessment Section "1"
	 Then When I click on submit in add question user shall land on the previous page
	 Then Click on Add Section
	 And Add Sub Section without Main Section
	 And I click on Add Question
	 Then Add Question with "SubSection without Main Section Question Description1","Checkbox" in Assessment Section "2"
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "SubSection without Main Section Question Description2","Checkbox Group" in Assessment Section "2"
	 Then I select Answeroption as "Yes and No" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "SubSection without Main Section Question Description3","Date" in Assessment Section "2"
	 Then When I click on submit and add new in add question user shall land on the same page
     Then Add Question with "SubSection without Main Section Question Description4","Drop down" in Assessment Section "2"
     Then I select Answeroption as "Yes,No and Not Applicable" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "SubSection without Main Section Question Description5","Radio Button" in Assessment Section "2"
	 Then I select Answeroption as "Gender" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "SubSection without Main Section Question Description6","Signature" in Assessment Section "2"
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "SubSection without Main Section Question Description7","Text Area" in Assessment Section "2"
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "SubSection without Main Section Question Description8","Text Field" in Assessment Section "2"
	 Then When I click on submit in add question user shall land on the previous page
	 Then Click on Add Section
	 And Add Sub Section
	 And I click on Add Question
	 Then Add Question with "SubSection with Main Section Question Description1","Checkbox" in Assessment Section "2"
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "SubSection with Main Section Question Description2","Checkbox Group" in Assessment Section "2"
	 Then I select Answeroption as "Yes and No" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "SubSection with Main Section Question Description3","Date" in Assessment Section "2"
	 Then When I click on submit and add new in add question user shall land on the same page
     Then Add Question with "SubSection with Main Section Question Description4","Drop down" in Assessment Section "2"
     Then I select Answeroption as "Yes,No and Not Applicable" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "SubSection with Main Section Question Description5","Radio Button" in Assessment Section "2"
	 Then I select Answeroption as "Gender" and click on add
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "SubSection with Main Section Question Description6","Signature" in Assessment Section "2"
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "SubSection with Main Section Question Description7","Text Area" in Assessment Section "2"
	 Then When I click on submit and add new in add question user shall land on the same page
	 Then Add Question with "SubSection with Main Section Question Description8","Text Field" in Assessment Section "2"
	 Then When I click on submit in add question user shall land on the previous page
	 Then When I click on submit in add assessment user shall land on the previous page
	 Then filter the Assessment
	 Then Verify presence of Preview button
	 Then Click on Preview of the created Assessment
	 Then Verify navigation to Preview page
	 Then Verify Default Section in Preview page with "Default Section Question Description1","Checkbox" in Assessment Section "0"
	 Then Verify Default Section in Preview page with "Default Section Question Description2","Checkbox Group" in Assessment Section "0"
	 Then Verify Default Section in Preview page with "Default Section Question Description3","Date" in Assessment Section "0"
	 Then Verify Default Section in Preview page with "Default Section Question Description4","Drop down" in Assessment Section "0"
	 Then Verify Default Section in Preview page with "Default Section Question Description5","Radio Button" in Assessment Section "0"
	 Then Verify Default Section in Preview page with "Default Section Question Description6","Signature" in Assessment Section "0"
	 Then Verify Default Section in Preview page with "Default Section Question Description7","Text Area" in Assessment Section "0"
	 Then Verify Default Section in Preview page with "Default Section Question Description8","Text Field" in Assessment Section "0"
	 Then Verify Main Section exists and expand the accordian
	 Then Verify Main Section in Preview page with "Main Section Question Description1","Checkbox" in Assessment Section "1"
	 Then Verify Main Section in Preview page with "Main Section Question Description2","Checkbox Group" in Assessment Section "1"
	 Then Verify Main Section in Preview page with "Main Section Question Description3","Date" in Assessment Section "1"
	 Then Verify Main Section in Preview page with "Main Section Question Description4","Drop down" in Assessment Section "1"
	 Then Verify Main Section in Preview page with "Main Section Question Description5","Radio Button" in Assessment Section "1"
	 Then Verify Main Section in Preview page with "Main Section Question Description6","Signature" in Assessment Section "1"
	 Then Verify Main Section in Preview page with "Main Section Question Description7","Text Area" in Assessment Section "1"
	 Then Verify Main Section in Preview page with "Main Section Question Description8","Text Field" in Assessment Section "1"
	 Then Verify SubSection with main header in Preview page
	 Then Verify SubSection with Main Section in Preview Page with "SubSection with Main Section Question Description1","Checkbox" in Assessment Section "2"
	 Then Verify SubSection with Main Section in Preview Page with "SubSection with Main Section Question Description2","Checkbox Group" in Assessment Section "2"
	 Then Verify SubSection with Main Section in Preview Page with "SubSection with Main Section Question Description3","Date" in Assessment Section "2"
	 Then Verify SubSection with Main Section in Preview Page with "SubSection with Main Section Question Description4","Drop down" in Assessment Section "2"
	 Then Verify SubSection with Main Section in Preview Page with "SubSection with Main Section Question Description5","Radio Button" in Assessment Section "2"
	 Then Verify SubSection with Main Section in Preview Page with "SubSection with Main Section Question Description6","Signature" in Assessment Section "2"
	 Then Verify SubSection with Main Section in Preview Page with "SubSection with Main Section Question Description7","Text Area" in Assessment Section "2"
	 Then Verify SubSection with Main Section in Preview Page with "SubSection with Main Section Question Description8","Text Field" in Assessment Section "2"
	 Then Verify Subsection without main header in Preview page
	 Then Verify SubSection without Main Section in Preview Page with "SubSection without Main Section Question Description1","Checkbox" in Assessment Section "2"
	 Then Verify SubSection without Main Section in Preview Page with "SubSection without Main Section Question Description2","Checkbox Group" in Assessment Section "2"
	 Then Verify SubSection without Main Section in Preview Page with "SubSection without Main Section Question Description3","Date" in Assessment Section "2"
	 Then Verify SubSection without Main Section in Preview Page with "SubSection without Main Section Question Description4","Drop down" in Assessment Section "2"
	 Then Verify SubSection without Main Section in Preview Page with "SubSection without Main Section Question Description5","Radio Button" in Assessment Section "2"
	 Then Verify SubSection without Main Section in Preview Page with "SubSection without Main Section Question Description6","Signature" in Assessment Section "2"
	 Then Verify SubSection without Main Section in Preview Page with "SubSection without Main Section Question Description7","Text Area" in Assessment Section "2"
	 Then Verify SubSection without Main Section in Preview Page with "SubSection without Main Section Question Description8","Text Field" in Assessment Section "2"
	 Then Verify clicking on browser back button navigates user out of Preview Page
	 And Close Driver
	 