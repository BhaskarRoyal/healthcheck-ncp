/**
 * 
 */
package com.pcehr.ao.mygov.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author bhaskara.vallapu
 *
 */
public class MyGovLoginPageObject {
	
	/*
	 *  MyGov WebElements
	 */

	//Define User name Field
	@FindBy(how=How.XPATH, using=".//*[@id='userId']")
	public  WebElement myGovusernameField;

	//Define pass name Field
	@FindBy(how=How.XPATH, using=".//*[@id='password']")
	public  WebElement myGovPasswordField;

	@FindBy(how=How.XPATH, using=".//*[@id='sign-in']")
	public  WebElement myGovSignIn;

	@FindBy(how=How.XPATH, using=".//*[@id='member-logo-panel']/div/div/ul/li/div/p/a/span")
	public  WebElement myHealthRecordLogoPanel;


}
