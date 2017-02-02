/**
 * 
 */
package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class ClinicalRecordsPageObjects {

	@FindBy(how = How.XPATH, using = "//h1[@class='intro__heading']")
	public WebElement ClinicalRecordsHeader;

	@FindBy(how=How.XPATH, using=".//*[@title='Documents']")
	public WebElement documentsTab;

	@FindBy(how=How.XPATH,using="html/body/div[4]/div[1]/div[1]/div/div/a[1]/div[1]/div[1]/h4/strong")
	public WebElement clinicalRecordsLink;



	/**
	 * @author bhaskara.vallapu
	 * 
	 */

	// Clinical Records

	//Discharge summary
	@FindBy(how = How.XPATH, using = ".//*[@class ='card__heading' and text()='Discharge Summaries']")
	public static WebElement dischargeSummaryLink;


	


	//E-Referral
	@FindBy(how = How.XPATH, using =".//*[@class ='card__heading' and text()='e-Referrals']")
	public static WebElement eReferralLink;
	
	
	//Pathology
	@FindBy(how = How.XPATH, using = ".//*[@class ='card__heading' and text()='Pathology Reports']")
	public static WebElement pathologyReportsLink;


	//Event Summary
	@FindBy(how = How.XPATH, using = ".//*[@class ='card__heading' and text()='Event Summaries']")
	public static WebElement eventSummaryLink;

	
	
	
	

	//Shared Health Summary
	@FindBy(how = How.XPATH, using = ".//*[@class ='card__heading' and text()='Shared Health Summaries']")
	public static WebElement sharedHealthSummaryLink;



	//Specialist letter
	@FindBy(how = How.XPATH, using = ".//*[@class ='card__heading' and text()='Specialist Letters']")
	public static WebElement specialistLetterLink;

	
	   

	
	

	//Diagnostic Imaging
	@FindBy(how = How.XPATH, using = ".//*[@class ='card__heading' and text()='Diagnostic Imaging Reports']")
	public static WebElement diagnosticImagingReportsLink;







}
