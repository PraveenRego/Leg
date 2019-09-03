package com.adminbuilder.Pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.adminbuilder.baseutility.WebAction;

public class GlobalValues {
	WebAction  webaction = new WebAction();
	public static String URL = "";
	public static String anthemText = " logo";
	public static ArrayList<String> MarketList = new ArrayList<String>(Arrays.asList("Florida","Iowa"));
	public static ArrayList<String> Answersectiongridheaders = new ArrayList<String>(Arrays.asList("Answer Order","Answer Text","Score Value"));
	public static ArrayList<String> ScoringCategorygridheaders = new ArrayList<String>(Arrays.asList("Score Range Value","Score Range"));
	public static ArrayList<String> SectionType = new ArrayList<String>(Arrays.asList("Main Section","Sub Section"));
	public static ArrayList<String> AssessmentTemplateGrid = new ArrayList<String>(Arrays.asList("Section Order","Section Name","Main Section Name"));
	
	public static ArrayList<String> TemplateGridExpandRow = new ArrayList<String>(Arrays.asList("Question Order","Question Description","Scoring Category"));
	
	public static List<String> QuestionResponseTypedropdownvalues = new ArrayList<String>(Arrays.asList("Checkbox","Checkbox Group","Date","Drop down","Radio Button","Signature","Text Area","Text Field"));
    public static ArrayList<String> AssessmentSectiondropdownvalues = new ArrayList<String>(Arrays.asList("Default Section"));
    public String Assessment = "Assessment" + webaction.generaterandomstring();
    public String MainSection = "Main Section " + webaction.generaterandomstring();
    public String SubSection = "Sub Section " + webaction.generaterandomstring();
	public static ArrayList<String> MarketList_grid = new ArrayList<String>(Arrays.asList("Market"));
	public static ArrayList<String> ClientAdmin_dropdowns = new ArrayList<String>(Arrays.asList("Market Setup","User & User Role Management","Dashboards","WorkFlows & Tasks","Assessment/Form Builder"));
	public static ArrayList<String> MarketsSetup = new ArrayList<String>(Arrays.asList("Case Assignment Behavior","Case Statuses/Reasons","External Links","Market Announcements"));
	public static ArrayList<String> UserUserRoleManagement = new ArrayList<String>(Arrays.asList("User Maintenance","User Role Management"));
	public static ArrayList<String> Dashboards = new ArrayList<String>(Arrays.asList("Dashboards View","Case Assignment View","Member Banner/Overview"));
	public static ArrayList<String> WorkFlows_Tasks = new ArrayList<String>(Arrays.asList("Workflow Managment","Task Management"));
	public static ArrayList<String> Assessment_Form_Builder = new ArrayList<String>(Arrays.asList("Assessment Builder"));
	
	public static ArrayList<String> AssessmentBuilderPageGrid = new ArrayList<String>(Arrays.asList(" Assessment Name "," Assessment Association "," Last Modified Date "," Publish Date "," Publish Status "));
	public static ArrayList<String> valuetohold = new ArrayList<>();
	public static ArrayList<String> LinktoTasksgrid = new ArrayList<String>(Arrays.asList("Task","Required","Linked Date"));
	 public static int rownumber;
	 public static ArrayList<String> BranchedQuestionsGrid = new ArrayList<String>(Arrays.asList("Section","Question Description"));
	 public static ArrayList<String> BranchedQuestionsChildGrid = new ArrayList<String>(Arrays.asList("Section Name","Question Description"));
	 public static String Assessmentname;
	 
	 public static ArrayList<String> PublishGrid = new ArrayList<String>(Arrays.asList("Environment","Effective Date","Last Updated By","Last Updated on","Publish On","Publish Status" ));
	 public static String AssesmentModifiedon;
	 public static ArrayList<String> addsectionvaluestohold = new ArrayList<String>(Arrays.asList("Default Section"));
	public static ArrayList<String> addmainsectionvaluestohold = new ArrayList<String>(Arrays.asList("Default Section"));
	public static List<String> dropdownvaluesinpreview=new ArrayList<String>(Arrays.asList("Yes", "No","Not Applicable"));
	public static ArrayList<String> addquestionvaluestohold = new ArrayList<>();
	public static List<String> InsertAnsweroptions = new ArrayList<String>(Arrays.asList("Yes and No","Yes,No and Not Applicable","Gender"));
	public static int numberofrowsbeforedelete = 0;
	 
	 
	public static ArrayList<String> AnsweroptionRelationship = new ArrayList<String>(Arrays.asList("Adult Child","Brother/Sister","Brother/Sister-In-Law",
			"Court-Appointed Guardian","Cousin","Employee","Ex-Spouse","Father","Fiduciary","Friend","Adult Grandchild","Grandparent",
			"Guardian","Health Care Surrogate","Life Partner","Mother","Mother/Father-In-Law","Nephew/Niece","Neighbor","Other Adult",
			"Other Relationship","Provider/Facility Staff","Parent","Power of Attorney","Significant Other","Son/Daughter-In-Law",
			"Spouse","Stepchild","Stepfather","Stepmother","Uncle/Aunt","Unknown","Ward"));
	public static ArrayList<String> AnsweroptionRace = new ArrayList<String>(Arrays.asList("White","Black/African American","Asian",
			"American Indian/Alaska Native","Native Hawaiian/Pacific Islander","Other"));
	public static ArrayList<String> AnsweroptionEthnicity = new ArrayList<String>(Arrays.asList("Hispanic/Latino","Other"));
	public static ArrayList<String> AnsweroptionMaritalStatus = new ArrayList<String>(Arrays.asList("Married","Single","Separated",
			"Widowed","Divorced","Partner"));
	public static ArrayList<String> AnsweroptionAssistance = new ArrayList<String>(Arrays.asList("No assistance needed",
			"Uses assistive device","Needs supervision or prompt","Needs assistance (but not total help)",
			"Needs total assistance (cannot do at all)"));
	public static ArrayList<String> AnsweroptionSeverity = new ArrayList<String>(Arrays.asList("Severe","Moderate","Mild"));
	public static ArrayList<String> AnsweroptionFrequencyoftherapy = new ArrayList<String>(Arrays.asList("NA or None","Monthly","Weekly",
			"Several times a week","Daily","Several times a day"));
	
	
	
	 //LightHouse Variables
	 public  String lTestcaseName;
	 public  String lStartDateTime;
	 public  String lEndDateTime;
	 public  String lElapsedTime;
	 
}