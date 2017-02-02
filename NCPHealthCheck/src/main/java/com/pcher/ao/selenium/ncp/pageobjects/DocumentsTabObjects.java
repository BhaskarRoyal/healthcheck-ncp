package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author bhaskara.vallapu
 *
 */
public class DocumentsTabObjects {

	@FindBy(how = How.XPATH, using = ".//span[text()='View all Clinical Records']")
	public WebElement clinicalRecords;

	@FindBy(how = How.XPATH, using = ".//span[text()='View Prescription & Dispense information']")
	public WebElement medicineRecords;

	@FindBy(how = How.XPATH, using = ".//span[text()='View Medicare Overview']")
	public WebElement medicareRecords;

	@FindBy(how = How.XPATH, using = ".//span[text()='View Advance Care Planning']")
	public WebElement advancedCarePlanning;

	@FindBy(how = How.XPATH, using = ".//span[contains(text(), 'View Key Information']")
	public WebElement keyInformation;
	
	
	@FindBy(how = How.XPATH, using = "//span[starts-with(text(),'View Key Information I')]")
    public WebElement keyInformationAdded;
	
	@FindBy(how = How.XPATH, using = ".//span[text()='View Childhood Development']")
	public WebElement childhoodDevelopment;

}
