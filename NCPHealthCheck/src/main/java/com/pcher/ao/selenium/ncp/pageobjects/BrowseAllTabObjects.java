package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * 
 * @author dinesh.kaki
 *
 */
public class BrowseAllTabObjects {

	
	@FindBy(how = How.XPATH, using = "//*[@title='Record Home']")
	public WebElement recordHomeTab;
	
	@FindBy(how = How.XPATH, using = "//*[@title='Documents']")
	public WebElement documentsTab;
	
	@FindBy(how = How.XPATH, using = "//*[@title='Privacy & Access']")
	public WebElement privacyAndAccessTab;
	
	@FindBy(how = How.XPATH, using = "//*[@title='Profile & Settings']")
	public WebElement  profileAndSettingsTab;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Browse All')]")
	public WebElement browseAllTab;
	
	@FindBy(how = How.XPATH, using = ".//a[@class ='link__secondary' and text()='Documents Home']")
	public static WebElement documentsHome;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Clinical Records')]")
	public static WebElement clinicalRecords;
	
	@FindBy(how = How.XPATH, using = ".//a[@class ='link__secondary' and text()='Medicines']")
	public static WebElement medicines;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Medicare Overview')]")
	public static WebElement medicareOverview;
	
	@FindBy(how = How.XPATH, using = ".//a[@class ='link__secondary' and text()='KeyInfor']")
	public static WebElement KeyInformationAdded;
	
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Key Information I')]")
    public static WebElement keyInformationAdded;
	
	//*[contains(text(),'Create or access a digital health record for a child')]
	
	@FindBy(how = How.XPATH, using = ".//a[@class ='link__secondary' and text()='Advance Care Planning']")
	public static WebElement advancedCarePlanning;
	
	@FindBy(how = How.XPATH, using = ".//a[@class ='link__secondary' and text()='My Childhood Development']")
	public static WebElement myChildhoodDevelopment;
	
	@FindBy(how = How.XPATH, using = ".//a[@class ='link__secondary' and text()='Privacy & Access Home']")
	public static WebElement privacyAndAccessHome;
	
	@FindBy(how = How.XPATH, using = ".//a[@class ='link__secondary' and text()='Access Dashboard']")
	public static WebElement accessDashboard;
	
	@FindBy(how = How.XPATH, using = ".//a[@class ='link__secondary' and text()='Access History']")
	public static WebElement accessHistory;
	
	@FindBy(how = How.XPATH, using = ".//a[@class ='link__secondary' and text()='Manage Document Access']")
	public static WebElement manageDocumentAccess;
	
	@FindBy(how = How.XPATH, using = ".//a[@class ='link__secondary' and text()='Profile & Settings Home']")
	public static WebElement profileAndSettingsHome;

	@FindBy(how = How.XPATH, using = ".//a[@class ='link__secondary' and text()='Profile']")
	public static WebElement profile;
	
	@FindBy(how = How.XPATH, using = ".//a[@class ='link__secondary' and text()='Emergency Contact Details']")
	public static WebElement emergencyContactDetails;
	
	@FindBy(how = How.XPATH, using = ".//a[@class ='link__secondary' and text()='Notification Settings']")
	public static WebElement notificationSettings;
	
	@FindBy(how = How.XPATH, using = ".//a[@class ='link__secondary' and text()='Medicare Information Settings']")
	public static WebElement medicareInformationSettings;
	
}
