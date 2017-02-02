/**
 * 
 */
package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author bhaskara.vallapu
 * This class holds the functionalities that are provided by the my health record home page
 */
public class HealthRecordHomePageObject {
	@FindBy(how = How.XPATH, using = "//*[@title='Record Home']")
	public WebElement recordHomeTab;
	
	//@FindBy(how = How.XPATH, using = "//*[@title='Documents']")
	@FindBy(how = How.XPATH, using = ".//*[@id='top']/div[2]/nav/section[1]/div/div/div/ul/li[2]/a")
	public WebElement documentsTab;
	
	@FindBy(how = How.XPATH, using = "//*[@title='Privacy & Access']")
	public WebElement privacyAndAccessTab;
	
	@FindBy(how = How.XPATH, using = "//*[@title='Profile & Settings']")
	public WebElement  profileAndSettingsTab;
	
	//@FindBy(how = How.XPATH, using = ".//*[@id='nav--10']/li[2]/a")
	@FindBy(how = How.LINK_TEXT, using = "Profile")
	public WebElement  profile;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='top']/div[2]/nav/section[1]/div/div/div/ul/li[5]/a")
	public WebElement browseAllTab;
	
	@FindBy(how = How.XPATH, using = ".//*[@class='intro__heading']")
	public WebElement recordHomeHeadingtext;
	
	@FindBy(how=How.XPATH, using="html/body/div[3]/div[2]/div[2]/div[1]/div[1]/div/div/a/div[1]/div[2]/div/span/span")
	public WebElement pesonalInformationLink;
	
	//@FindBy(how = How.XPATH, using = "html/body/div[4]/div[1]/div[1]/div/div/a[3]")
	@FindBy(how = How.XPATH, using = "//strong[contains(text(), 'Medicare Overview')]")
	public WebElement medicareOverView;
	
	//@FindBy(how = How.XPATH, using=".//*[@id='top']/div[4]/div[2]/div[1]/div[1]/div/div/a[2]/div[1]/div[1]/h4/strong")
	//@FindBy(how = How.XPATH, using=".//*[@id='top']/div[5]/div[2]/div[1]/div/div/div/a[2]/div[1]/div[1]/h4/strong")
	//@FindBy(how = How.XPATH, using=".//*[@id='top']/div[4]/div[2]/div[1]/div/div/div/a[3]/div[1]/div[1]/h4/strong")
	@FindBy(how = How.XPATH, using="//strong[contains(text(), 'Key Information')]")
	public WebElement keyinformation;
	
	//@FindBy(how = How.XPATH, using="html/body/div[4]/div[1]/div[1]/div/div/a[1]")
	@FindBy(how = How.XPATH, using="//strong[contains(text(), 'Clinical Records')]")
	public WebElement clinicalrecordsLink;
	
	@FindBy(how = How.XPATH, using=".//*[@id='top']/div[4]/div[2]/div[1]/div/div/div/a[1]/div[1]/div[1]/h4/strong")
	public WebElement advanceCarePlanningLink;
	

	@FindBy(how = How.XPATH, using="//strong[contains(text(),'Notification Settings')]")
	public WebElement notificationSettingsLink;
	
	@FindBy(how=How.XPATH, using=".//*[@id='top']/div[4]/div[1]/div/div/div/a[2]/div[1]/div[1]/h4/strong")
	public WebElement medicinesLink;
	
	@FindBy(how=How.XPATH, using=".//*[@id='save-pref']")
	public WebElement saveButton;
	
	@FindBy(how=How.XPATH, using=".//*[@id='formNotificationSettings']/div[1]/div/div[6]/div/div[2]/div/label")
	public WebElement emailRadiobutton;
	
	
	@FindBy(how=How.XPATH, using=".//*[@id='top']/div[4]/div[2]/div[1]/div/div/div/a[3]/div[1]/div[1]/h4/strong")
	public WebElement myChildHoodDevelopmentLink;
	
	
	
	@FindBy(how = How.XPATH, using=".//*[@id='dLabel']")
	public WebElement represenative; 
	
	@FindBy(how = How.XPATH, using=".//*[@id='logOutLink']")
	public WebElement logoutlink; 

}
