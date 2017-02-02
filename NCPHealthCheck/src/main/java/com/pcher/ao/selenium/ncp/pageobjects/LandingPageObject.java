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
public class LandingPageObject {

	//Define cardname field
	//@FindBy(how=How.XPATH, using=".//small[@class='card__authorization']")
	@FindBy(how=How.XPATH, using=".//h4[@class='card__name']")
	public WebElement card_nameField;

	

	@FindBy(how=How.XPATH, using="//*[contains(text(), 'Welcome to My Health Record')]")
	public WebElement myHealthRecordText;

	@FindBy(how = How.XPATH, using = ".//*[@id='div-landing-recordlist']/div[2]/a/span")
	public WebElement createOrAccessEHealthRecordforYourSelfLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='div-landing-recordlist']/div[3]/a/span")
	public WebElement accessOrCreateaEHealthRecordForSomeoneElseLink;



}
