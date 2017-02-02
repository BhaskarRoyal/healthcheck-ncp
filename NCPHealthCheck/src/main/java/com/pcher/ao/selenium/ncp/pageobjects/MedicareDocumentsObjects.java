package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * 
 * @author dinesh.kaki
 *
 */
public class MedicareDocumentsObjects {

   
	
	@FindBy(how = How.XPATH, using = "html/body/div[4]/div[1]/div[1]/div/div/a[2]/div[1]/div[1]/h4/strong")
	public static WebElement medicareOverviewLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='prescriptions-table']/tbody/tr/td/span")
	public WebElement pbsDocument;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='immunisations-table']/tbody/tr/td/span")
	public WebElement acirDocument;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='donor-register-table']/tbody/tr/td/span")
	public WebElement aodrDocument;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='medicare-services-table']/tbody/tr/td/span")
	public WebElement mbsDocument;
	
}
