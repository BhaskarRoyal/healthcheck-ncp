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
public class MyGovAuthenticationPageObject {
	
/*
	
	 *  MyGov WebElements
	 
*/
	//Define question  Field
	@FindBy(how=How.XPATH, using=".//*[@id='labelQuestion']/b")
	public  WebElement questionText;


	@FindBy(how=How.XPATH, using=".//*[@id='labelStoredQuestion']/b")
	public  WebElement questionNameText;

	@FindBy(how=How.XPATH, using=".//*[@id='answer']")
	public  WebElement answersTextFiled;


	@FindBy(how=How.XPATH, using=".//*[@id='next']")
	public  WebElement nextButton;


}
