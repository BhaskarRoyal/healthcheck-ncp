package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePageObjects {

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Browse All')]")
	public WebElement browseAllTab;

	@FindBy(how = How.XPATH, using = ".//*[@id='nav--exapnded']/div/div/div/div/ul/li[4]/a")
	public WebElement profileAndSetting;
	
	
	@FindBy(how = How.XPATH, using = ".//*[@id='defenceForceStatus1']")
	public static WebElement defenceForceStatusChoice;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='indigenousStatus3']")
	public static WebElement indigenousStatusChoice;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='questionIndigenousStatusQuestion']/h4")
	public WebElement indigenousStatus;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='submitprofile']")
	public WebElement save;
   
	@FindBy(how = How.XPATH, using = ".//*[@id='okConfirm']")
	public  WebElement okButton;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='top']/div[3]/div[2]/div[3]/h1")
	//@FindBy(how = How.XPATH, using = ".//*[@id='top']/div[4]/div[2]/div[3]/h1")
	public  WebElement profilePageVerifierTxt;
	
	
	
	//@FindBy(how = How.XPATH, using = ".//*[@id='questionDefenceForceStatus']/div[1]/div[1]/div/label")
	@FindBy(how = How.XPATH, using = ".//*[@class='radio__label radio--dark-blue' and text()='No, I have never served in the ADF']")
	public  WebElement radioButton2;
	
	@FindBy(how = How.XPATH, using = ".//*[@class='radio__label radio--dark-blue' and text()='Yes and I have a DVA file number']")
	public  WebElement radioButton;
	
	@FindBy(how = How.XPATH, using = ".//*[@class='radio__label radio--dark-blue' and text()='Yes but I do not have a DVA file number']")
	public  WebElement radioButton1;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='questionDefenceForceStatus']/div[2]/div/div/div/button")
	public  WebElement clearButton;
	
	
	@FindBy(how = How.XPATH, using = ".//div[@class='radio']")
	public  WebElement radiobuttons;
	
	
}
