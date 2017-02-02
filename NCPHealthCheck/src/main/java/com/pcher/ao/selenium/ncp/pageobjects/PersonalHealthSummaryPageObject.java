/**
 * 
 */
package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author bhaskara.vallapu
 *
 */
public class PersonalHealthSummaryPageObject {
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(),''Personal Health Summary)]")
	public WebElement personalHealthSummaryLink;
	
	//@FindBy(how=How.XPATH,using=".//*[@id='header-details']/div[2]/h1")
	//@FindBy(how=How.XPATH,using=".//*[@id='header-details']/div/div[2]/h1")
	
	@FindBy(how=How.XPATH,using=".//*[@ class='intro__heading']")
	public WebElement pageTextVerifier;
	
	
	
	

}
