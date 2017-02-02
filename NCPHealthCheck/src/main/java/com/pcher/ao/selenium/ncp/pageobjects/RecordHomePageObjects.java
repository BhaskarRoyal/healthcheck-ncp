package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * @author dinesh.kaki
 *
 */
public class RecordHomePageObjects {

	@FindBy(how = How.XPATH, using = "//*[@title='Record Home']")
	public WebElement recordHomeTab;
	
	//@FindBy(how = How.XPATH, using = ".//*[@id='top']/div[4]/div/h1")
	@FindBy(how = How.XPATH, using = ".//*[@id='profile-div-top']/div/div[2]/div/h1")
	public WebElement recordHomeText;
	
	@FindBy(how = How.XPATH, using = "//*[@title='Documents']")
	public WebElement documentsTab;
	
	@FindBy(how = How.XPATH, using = "//*[@title='Privacy & Access']")
	public WebElement privacyAndAccessTab;
	
	@FindBy(how = How.XPATH, using = "//*[@title='Profile & Settings']")
	public WebElement  profileAndSettingsTab;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Browse All')]")
	public WebElement browseAllTab;
	
	@FindBy(how = How.XPATH, using = ".//*[@class='intro__heading']")
	public WebElement introHeading;
	
	
	
}
