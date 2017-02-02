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
public class DischargePageObjects {
	
	@FindBy(how = How.XPATH, using = ".//*[@id='top']/div[3]/div[2]/div/div/div/h1")
	public static WebElement dischargeSummaryText;

}
