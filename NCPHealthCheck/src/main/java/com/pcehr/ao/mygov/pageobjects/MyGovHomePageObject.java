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
public class MyGovHomePageObject {

	
	@FindBy(how = How.CSS, using="img[alt='My Health Record logo']")
	public WebElement myHealthRecordServiceLinkid;
	
	
	
}
