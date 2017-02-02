package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.pcehr.ao.executors.NCPHealthCheckExecutor;
import com.pcehr.base.utils.NCPLoadEnvironmentProperties;


/**
 * 
 * @author bhaskara.vallapu
 *
 */
public class KeyInformationAddedObjects {
	
	
	@FindBy(how=How.XPATH, using=".//*[@id='top']/div[4]/div[2]/div[1]/div[1]/div/div/a[2]/div[2]/div[1]/p")
	public WebElement keyInformationAddedLink;

	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Personal Health Notes')]")
	public WebElement personalHealthNoteLink;
	
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Personal Health Summary')]")
	public WebElement personalHealthSummaryLink;
	
	//@FindBy(how = How.XPATH, using = ".//*[@id='top']/div[3]/div[4]/div/div/button")
	@FindBy(how = How.XPATH, using = ".//*[@id='top']/div[4]/div[4]/div/div/button")
	public WebElement addApersonalHealthNotebutton;
	

}
