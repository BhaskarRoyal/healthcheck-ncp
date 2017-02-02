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
public class MHRHomepageObject {
	
//Define Web Elements
	@FindBy(how=How.XPATH, using=".//*[@id='member-logo-panel']/div/div/ul/li/div/p/a/img")
	public WebElement myHealthRecordMemberLogoPanelLink; 

	@FindBy(how=How.XPATH, using=".//*[@id='my-gov-logo']/a/img")
	public WebElement myLogoImg;
}
