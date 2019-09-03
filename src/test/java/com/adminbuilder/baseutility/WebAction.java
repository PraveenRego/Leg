package com.adminbuilder.baseutility;



import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adminbuilder.Pages.GlobalValues;
import com.adminbuilder.configutility.ConfReader;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import cucumber.api.Scenario;


public class WebAction {
	

//	private static WebAction InstanceReader = new WebAction();
	/*public static WebAction getInstance(){
		driverType = getBrowser();
	return InstanceReader;
	
}*/
	
	 private WebDriver driver;
	 private static DriverType driverType;
	 private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	 private static String path = new File("").getAbsolutePath();
	 private static String fileToUpdate = "C:\\Users\\AF83579\\TestProjects\\Testproj\\Resources\\ExecutionLog.csv";
		private static File inputFile = new File(fileToUpdate);
		static List<String[]> csvBody;
		
	 public enum DriverType {
		 FIREFOX,
		 CHROME,
		 INTERNETEXPLORER
	}
	 
		 
	
	 public WebDriver getDriver()  {
	 if(driver == null) {
		try {
			driver = createDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	 }
	return driver;
	 
	 }
	 
	 private WebDriver createDriver()  {
		 
		 String Env = System.getProperty("target.env"); 
		 String Grid = System.getProperty("target.grid");

	     
	    if(Env == null && Grid == null) {
	    	GlobalValues.URL = ConfReader.getInstance().getConfData("URL", "config");
	    	driver = createLocalDriver();
	    }
	      
	    else {
	    		try {
	    			GlobalValues.URL = System.getProperty("target.env"); 
					driver = createRemoteDriver(Grid);
				} catch (Exception e) {
					e.printStackTrace();
				}
	   	    }
	    return driver;
	 }
	 
	 
	 private WebDriver createLocalDriver() {
		 driverType = getBrowser();
		 switch (driverType) {     
	        
	        case CHROME : 
	         System.setProperty(CHROME_DRIVER_PROPERTY, path + ConfReader.getInstance().getConfData("chromedriverpath", "config"));
	         ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("useAutomationExtension", false); 
	         driver = new ChromeDriver(options);
	    	break;
	    	
	    	//Not implemented yet - for future use
	        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
	        break;
		
	        default:
	        	throw new RuntimeException("Browser Name not matched : " + driverType);
	        }
	 
	        
	 return driver;
	 }
	 
	 private WebDriver createRemoteDriver(String Grid)  {
		 driverType = getBrowser();
	        switch (driverType) {     
	        
	        case CHROME : 
	        	DesiredCapabilities capability = DesiredCapabilities.chrome();
               capability.setCapability(ChromeOptions.CAPABILITY, chromeoptions());
               try {
					driver = new RemoteWebDriver(new URL(Grid),capability);
				} catch (Exception e) {
					e.printStackTrace();
				}
	    	break;
	    	
	    	//Not implemented yet - for future use
	        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
	        break;
	        
			default:
				throw new RuntimeException("Browser Name not matched : " + driverType);
				
	        }
	 
	        
	 return driver;
	 } 
	 
	 public void closeDriver() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.quit();
	 }
	 
	 
	 private static DriverType getBrowser() {
		 String browserName = ConfReader.getInstance().getConfData("browser", "config");
		 if(browserName == null || browserName.equalsIgnoreCase("chrome")) return DriverType.CHROME;
		 	else if(browserName.equalsIgnoreCase("iexplorer")) return DriverType.INTERNETEXPLORER;
		 	else throw new RuntimeException("Browser Name Key value in Config.property is not matched : " + browserName);
		 }
	 
	 private ChromeOptions chromeoptions() {
		 
         ChromeOptions options = new ChromeOptions();
         options.addArguments("start-maximized"); // open Browser in maximized mode
         options.addArguments("disable-infobars"); // disabling infobars
         options.addArguments("--disable-extensions"); // disabling extensions
         options.addArguments("--disable-gpu"); // applicable to windows os only
         options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
         options.addArguments("--no-sandbox");// Bypass OS security model
         options.setExperimentalOption("useAutomationExtension", false); // chrome is unable to find its reference in scoped_dirXXXXX folder
         return options;
	 }	
	
	 public enum FieldType {
		 name,
		 id,
		 xpath,
		 link,
		 partiallink,
		 css,
		 classname
		}
	 
	 public enum ElementType {
		 Textbox,
		 Dropdown,
		 
		}
	       
	 Logger Log = Logger.getLogger("WebAction.class");
 
	 public void openURL(WebDriver driver) {
		 driver.get(GlobalValues.URL);
	      	driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			System.out.println("Entered URL");
	 }
    
    public boolean validateobjectreadonly(String strxpath, WebDriver driver){  
    
    	WebElement readOnly = driver.findElement(By.xpath(strxpath));
    	
    	
    	if((readOnly.getAttribute("disabled")) != null){
    		return true;
    	}
    	else
    		return false;
    	
    
    }
    
    public boolean validateswitchchecked(String strxpath, WebDriver driver){  
        
    	WebElement switchcheck = driver.findElement(By.xpath(strxpath));
    	
    	
    	if((switchcheck.getAttribute("class").contains("checked"))){
    		return true;
    	}
    	else
    		return false;
    	
    
    }
    
 
public boolean enter_text( String fieldValue, FieldType fieldType,String objProp, WebDriver driver) {
		
			if (fieldValue != null && !fieldValue.isEmpty()) {
				
				System.out.println(driver.getTitle().toString());
				
				WebElement element;
				
			 switch (fieldType) {
			 
			 case name : 
				 element = (new WebDriverWait(driver, 25))
					.until(ExpectedConditions
							.presenceOfElementLocated(By.name(objProp)));
				 element.clear();
				 element.sendKeys(fieldValue);
				 return true;
			case id : 
				 element = (new WebDriverWait(driver, 25))
					.until(ExpectedConditions
							.presenceOfElementLocated(By.id(objProp)));
				 element.clear();
				 element.sendKeys(fieldValue);
				 return true;
				 
			 case xpath : 	 
				 element = (new WebDriverWait(driver, 25))
					.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath(objProp)));
				 element.clear();
				 element.sendKeys(fieldValue);
				 return true;
				 
			 case link : 
				 element = (new WebDriverWait(driver, 25))
					.until(ExpectedConditions
							.presenceOfElementLocated(By
									.linkText(objProp)));
				 element.clear();
				 element.sendKeys(fieldValue);
				 return true;
				 
			 case partiallink : 	 
				 element = (new WebDriverWait(driver, 25))
					.until(ExpectedConditions
							.presenceOfElementLocated(By
									.partialLinkText(objProp)));
				 element.clear();
				 element.sendKeys(fieldValue);
				 return true;
				 
			 case css : 
				 element = (new WebDriverWait(driver, 25))
					.until(ExpectedConditions
							.presenceOfElementLocated(By
									.cssSelector(objProp)));
				 element.clear();
				 element.sendKeys(fieldValue);
				 return true;
				 
			 case classname : 
				 element = (new WebDriverWait(driver, 25))
					.until(ExpectedConditions
							.presenceOfElementLocated(By
									.className(objProp)));
				 element.clear();
				 element.sendKeys(fieldValue);
				 return true;
				 
			 default:
				 Log.info("fieldType not matched : " + fieldType); 
				 return false;
				 
			 }
			 
				
			}
			return false;		

		

	}

public boolean click(FieldType fieldType, String objProp, WebDriver driver) {
	
	WebElement element;
		
	 switch (fieldType) {
	 
	 case name : 
		 element = (new WebDriverWait(driver, 25))
			.until(ExpectedConditions
					.presenceOfElementLocated(By.name(objProp)));
		 element.click();
		 return true;
	case id : 
		 element = (new WebDriverWait(driver, 25))
			.until(ExpectedConditions
					.presenceOfElementLocated(By.id(objProp)));
		element.click();
		 return true;
		 
	 case xpath : 	 
		 element = (new WebDriverWait(driver, 25)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(objProp)));
		 element.click();
		 return true;
		 
	 case link : 
		 element = (new WebDriverWait(driver, 25))
			.until(ExpectedConditions
					.presenceOfElementLocated(By
							.linkText(objProp)));
		 element.click();
		 return true;
		 
	 case partiallink : 	 
		 element = (new WebDriverWait(driver, 25))
			.until(ExpectedConditions
					.presenceOfElementLocated(By
							.partialLinkText(objProp)));
		 element.click();
		 return true;
		 
	 case css : 
		 element = (new WebDriverWait(driver, 25))
			.until(ExpectedConditions
					.presenceOfElementLocated(By
							.cssSelector(objProp)));
		 element.click();
		 return true;
		 
	 case classname : 
		 element = (new WebDriverWait(driver, 25))
			.until(ExpectedConditions
					.presenceOfElementLocated(By
							.className(objProp)));
		 element.click();
		 return true;
		 
	 default:
		 Log.info("fieldType not matched : " + fieldType); 
		 return false;
		 
	 }	
	
    
}

public boolean waitForLoadingToBecomeInvisible(WebDriver driver) {

	WebDriverWait wait =new WebDriverWait(driver, 50);
	
	if(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ConfReader.getInstance().getConfData("msgLoading", "config"))))) {
		return true;
	}
	
	else{
		return false;
	}
	
}


public boolean waitForObjectToBecomeInvisible(String xpath) {
	
	WebDriverWait wait =new WebDriverWait(driver, 50);
	
	if(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)))) {
		return true;
	}
	
	else{
		return false;
	}
	
}

public boolean waitForObjectToBecomeVisible(String xpath, WebDriver driver) {

	WebDriverWait wait =new WebDriverWait(driver, 50);
	
	if(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))) != null){
		return true;
	}
	
	else{
		return false;
	}
	
}

public boolean validateobjectexists(String strxpath, WebDriver driver) {	
	
	if((driver.findElements(By.xpath(strxpath))).size() !=0){
		if(driver.findElement(By.xpath(strxpath)).isDisplayed()){
			return true;
		}
		else
			return false;
	}
	else
	{
		return false ;
	}
	
} 

public boolean validateobjectmandatory(String strxpath, WebDriver driver){   
   	WebElement requiredfield = driver.findElement(By.xpath(strxpath));
    	
	    	if((requiredfield.getAttribute("class")).contains("required")){
	    		return true;
	    	}
	    	else
	    		return false;
	   } 


public boolean waitforPageload(WebDriver driver, String xpath ) throws Exception{     
    
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	WebDriverWait wait =new WebDriverWait(driver, 50);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	if( js.executeScript("return document.readyState").equals("complete")){
		return true;
	}
	else{
		return false;
	}
	

}

public boolean enterTextbox(String Fieldname,String Text, WebDriver driver) throws InterruptedException{     
	
	if(!(Text.isEmpty())) {
	WebDriverWait wait = new WebDriverWait(driver, 15);
	if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ConfReader.getInstance().getConfData("lblTextbox", "generic").replace("<fieldname>", Fieldname)))) != null) {

	WebElement AssessmentText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ConfReader.getInstance().getConfData("inpTextbox", "generic").replace("<fieldname>", Fieldname))));
	Thread.sleep(1000);
	AssessmentText.clear();
	Thread.sleep(1000);
	AssessmentText.clear();
	AssessmentText.sendKeys(Text);
	AssessmentText.sendKeys(Keys.TAB);
	System.out.println("Entered Text in field" + Fieldname);
	return true;
	}
	else {
		System.out.println("Field not found" + Fieldname);
		return false;
	}
	}
	else {
		return false;
	}
} 

public boolean selectDropdown(String Fieldname,String option, WebDriver driver) throws InterruptedException{     
	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ConfReader.getInstance().getConfData("lblDropdown", "generic").replace("<fieldname>", Fieldname)))) != null) {

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ConfReader.getInstance().getConfData("inpDropdown", "generic").replace("<fieldname>", Fieldname)))).click();
	
	String optionname = ConfReader.getInstance().getConfData("optDropdown", "generic").replace("<fieldname>", Fieldname).replace("<option>", option);
	
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionname))).click();
	System.out.println("Entered Text in field" + Fieldname);
	return true;

	}else {
		System.out.println("Field not found" + Fieldname);
		return false;
	}
} 

public boolean validateDropdown(String Fieldname, List<String> Expectedvalues){
	List<WebElement> ListWE = new ArrayList<WebElement>();
	List<String> ListStr = new ArrayList<String>();
	ListWE = driver.findElements(By.xpath(ConfReader.getInstance().getConfData("inpDropdown", "generic").replace("<fieldname>", Fieldname)));
	for(int i=1;i<=ListWE.size();i++){
		String s = driver.findElement(By.xpath("("+ ConfReader.getInstance().getConfData("inpDropdown", "generic").replace("<fieldname>", Fieldname) +")[" +i+ "]" )).getText();
		if(!s.equalsIgnoreCase("")){
			ListStr.add(s);
		}
	}
	
	if(ListStr.containsAll(Expectedvalues)){
		
		return true;
	}
	else{
	return false;
	}
}


public String get_text(ElementType elementType,String Fieldname, WebDriver driver) {

	WebElement element;			
		 switch (elementType) {
		 
		 case Textbox : 
			 element = (new WebDriverWait(driver, 25)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ConfReader.getInstance().getConfData("inppreTextbox", "generic").replace("<fieldname>", Fieldname))));
			 return element.getAttribute("textContent");
		case Dropdown : 
			 element = (new WebDriverWait(driver, 25)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ConfReader.getInstance().getConfData("inpDropdown", "generic").replace("<fieldname>", Fieldname))));
			 return element.getText();
			 
		 default:
			 Log.info("elementType not matched : " + elementType); 
			 return "";
			 
		}
}


public String get_text(String xpath, WebDriver driver) {
	
	
	return (new WebDriverWait(driver, 25))
			.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(xpath))).getText();
	
	
}


public String get_attribute(String xpath,String attributename, WebDriver driver) {
	
	
	return (new WebDriverWait(driver, 25))
			.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(xpath))).getAttribute(attributename);
	
	
}

public ArrayList<String> getrecentaddedformfromtable(String tablebodyrowxpath,ArrayList<String> List, WebDriver driver) throws InterruptedException	{
	int size=driver.findElements(By.xpath(tablebodyrowxpath)).size();
	int datasize = driver.findElements(By.xpath(tablebodyrowxpath + "["+size+ "]//td//span/span")).size();
	Thread.sleep(2000);
	for(int i=1;i<=datasize;i++) {
		List.add(driver.findElement(By.xpath("(" + tablebodyrowxpath + "["+size+ "]//td//span/span)[" + i + "]" )).getText());
	}
	return List;
	
	
	
}

public ArrayList<String> getrecentaddedfrommultiselect(String tablebodyrowxpath,ArrayList<String> List, WebDriver driver) throws InterruptedException	{
	int datasize = driver.findElements(By.xpath(tablebodyrowxpath)).size();
	Thread.sleep(2000);
	for(int i=1;i<=datasize;i++) {
		List.add(driver.findElement(By.xpath("(" + tablebodyrowxpath+")["+i+"]" )).getText());
	}
	return List;
	
	
	
}

public ArrayList<String> getrowdata(String tablerowxpath,int rownum, ArrayList<String> List, WebDriver driver)	{
	int datasize = driver.findElements(By.xpath(tablerowxpath + "["+rownum+ "]//td//span/span")).size();
	for(int i=1;i<=datasize;i++) {
		List.add(driver.findElement(By.xpath("(" + tablerowxpath + "["+rownum+ "]//td//span/span)[" + i + "]" )).getText());
	}
	return List;
		
}

public int gettablesize(String tablebodyrowxpath, WebDriver driver)	{
	int size=driver.findElements(By.xpath(tablebodyrowxpath)).size();
	return size;
}


public ArrayList<String> getLists(String rowxpath, WebDriver driver){
	ArrayList<WebElement> ListWE = new ArrayList<WebElement>();
	ArrayList<String> ListStr = new ArrayList<String>();
	ListWE = (ArrayList<WebElement>) driver.findElements(By.xpath(rowxpath));
	for(int i=1;i<=ListWE.size();i++){
		String s = driver.findElement(By.xpath("("+ rowxpath +")[" +i+ "]" )).getText().trim();
		if(!s.equalsIgnoreCase("")){
			ListStr.add(s);
		}
	}
	return ListStr;
		
}

public HashSet<String> getuniqueLists(String rowxpath, WebDriver driver){
	List<WebElement> ListWE = new ArrayList<WebElement>();
	HashSet<String> SetStr = new HashSet<String>();
	ListWE = driver.findElements(By.xpath(rowxpath));
	for(int i=1;i<=ListWE.size();i++){
		String s = driver.findElement(By.xpath("("+ rowxpath +")[" +i+ "]" )).getText().trim();
		if(!s.equalsIgnoreCase("")){
			SetStr.add(s);
		}
	}
	return SetStr;
		
}



public String generaterandomstring(){
	Random rand = new Random();			
	int RandomNumber=rand.nextInt(2000)+1000;
	return Integer.toString(RandomNumber);
}

public boolean validateelementclickable(String strxpath, WebDriver driver)	{
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	if(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(strxpath))) != null){
		return true;
	}
	else
		return false;
		
}

public boolean validateDropdown(String Fieldname, List<String> Expectedvalues, WebDriver driver) throws InterruptedException{
    WebDriverWait wait = new WebDriverWait(driver, 15);
    List<WebElement> ListWE = new ArrayList<WebElement>();
    List<String> ListStr = new ArrayList<String>();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ConfReader.getInstance().getConfData("inpDropdown", "generic").replace("<fieldname>", Fieldname)))).click();
    Thread.sleep(1000);
    ListWE = driver.findElements(By.xpath(ConfReader.getInstance().getConfData("inpDropdownvalues", "generic").replace("<fieldname>", Fieldname)));
    for(int i=1;i<=ListWE.size();i++){
           String s = driver.findElement(By.xpath("("+ ConfReader.getInstance().getConfData("inpDropdownvalues", "generic").replace("<fieldname>", Fieldname) +")[" +i+ "]" )).getText();
           if(!s.equalsIgnoreCase("")){
                  ListStr.add(s);
           }
    }
    
    if(ListStr.containsAll(Expectedvalues)){
           
           return true;
    }
    else{
    return false;
    }
}

public boolean validatebuttondisabled(String strxpath, WebDriver driver){  
    WebElement buttondisable = driver.findElement(By.xpath(strxpath));
       String s = buttondisable.getAttribute("disabled");
       return Boolean.parseBoolean(s);
}


public String getcurrentdate(String dateFormat, WebDriver driver){ 

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);  
	LocalDateTime now = LocalDateTime.now();
	return dtf.format(now);

}


 public void takescreenshot(Scenario scenario) {  
    
    String screenshotName = scenario.getName().replaceAll(" ", "_") + getcurrentdate("MMDDYYYY", driver);
	try {
		
		File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File destinationPath = new File(System.getProperty("user.dir") + "Reports/screenshots/" + screenshotName + ".png");
		
		Files.copy(sourcePath, destinationPath);   

		Reporter.addScreenCaptureFromPath(destinationPath.toString());
	} catch (IOException e) {
} 
	
    	}
 
 public int getdropdownsize(String dropdownlistxpath, WebDriver driver)     {
     int size=driver.findElements(By.xpath(dropdownlistxpath)).size();
     return size;
}
 

 public boolean switchnewwindow(WebDriver driver) { 
	 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	 System.out.println(tabs.size());
	 try {
		 driver.switchTo().window(tabs.get(0));
		 driver.close();
		 driver.switchTo().window(tabs.get(1));
		 return true;
	 }catch(Exception E) {
		 return false;
	 }
 }
 
 
 public boolean browserback(WebDriver driver) {
		driver.navigate().back();
		return true;
	}


public boolean clear_text(FieldType fieldType,String objProp, WebDriver driver) {
		
		WebElement element;
		 switch (fieldType) {
		 case name : 
			 element = (new WebDriverWait(driver, 25))
				.until(ExpectedConditions
						.presenceOfElementLocated(By.name(objProp)));
			 element.clear();
			 element.sendKeys(Keys.TAB);
			 return true;
		case id : 
			 element = (new WebDriverWait(driver, 25))
				.until(ExpectedConditions
						.presenceOfElementLocated(By.id(objProp)));
			 element.clear();
			 element.sendKeys(Keys.TAB);
			 return true;
			 
		 case xpath : 	 
			 element = (new WebDriverWait(driver, 25))
				.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath(objProp)));
			 element.clear();
			 element.sendKeys(Keys.TAB);
			 return true;
			 
		 case link : 
			 element = (new WebDriverWait(driver, 25))
				.until(ExpectedConditions
						.presenceOfElementLocated(By
								.linkText(objProp)));
			 element.clear();
			 element.sendKeys(Keys.TAB);
			 return true;
			 
		 case partiallink : 	 
			 element = (new WebDriverWait(driver, 25))
				.until(ExpectedConditions
						.presenceOfElementLocated(By
								.partialLinkText(objProp)));
			 element.clear();
			 element.sendKeys(Keys.TAB);
			 return true;
			 
		 case css : 
			 element = (new WebDriverWait(driver, 25))
				.until(ExpectedConditions
						.presenceOfElementLocated(By
								.cssSelector(objProp)));
			 element.clear();
			 element.sendKeys(Keys.TAB);
			 return true;
			 
		 case classname : 
			 element = (new WebDriverWait(driver, 25))
				.until(ExpectedConditions
						.presenceOfElementLocated(By
								.className(objProp)));
			 element.clear();
			 element.sendKeys(Keys.TAB);
			 return true;
			 
		 default:
			 Log.info("fieldType not matched : " + fieldType); 
			 return false;
			 
		 }

}


 
 
 
 
}

