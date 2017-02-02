/**
 * 
 */
package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author bhaskara.vallapu
 * This class will stores the all the possible locators available in loginPage
 *
 */
public class LoginPageObject {

	/*
	 *  NCP WebElements
	 */


	//Define User name Field
	@FindBy(how=How.ID, using="j_username")
	public  WebElement usernameField;

	//Define Password Field
	@FindBy(how=How.ID, using="j_password")
	public WebElement passwordField;

	//Define Login Button
	@FindBy(how=How.XPATH, using=".//*[@id='submit']")
	public WebElement loginButton;


	







}

