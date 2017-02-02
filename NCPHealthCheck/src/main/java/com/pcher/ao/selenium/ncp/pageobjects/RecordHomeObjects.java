package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RecordHomeObjects {

	@FindBy(how=How.XPATH, using=".//*[@id='profile-div-top']/div/div[2]/div/h1")
	public WebElement  recordHomeText;

	@FindBy(how=How.XPATH , using=".//*[@id='top']/div[3]/div[4]/div[1]/div/div/a/div[1]/div[1]/h2/span[1]")
	public WebElement healthSnapshotImgLink;

	@FindBy(how=How.XPATH , using=".//*[@id='accordian-health-snapshot']/div/div/div[1]/div/div/div[8]/div[1]/h4")
	public WebElement immunisationsVerifyText;


	@FindBy(how=How.XPATH, using =".//*[@id='top']/div[3]/div[5]/div[1]/div/div/a/div[1]/div[1]/h2/span[1]")
	public WebElement personalInformationImageLink;


	@FindBy(how=How.XPATH, using=".//*[@id='accordian-personal-information']/div/div/div[1]/div/div/div[1]/h3")
	public WebElement profileVerifyText;

	
	@FindBy(how=How.XPATH, using=".//*[@id='top']/div[3]/div[6]/div/div/div/div/div[2]/div/a/div/h3")
	public WebElement advanceCarePlanningDocumentLink;


	@FindBy(how=How.XPATH , using=".//*[@id='docSection']/div/a/span[1]/span")
	public WebElement viewDocumentVerifyText;





}
