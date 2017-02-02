package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdvanceCarePlanningPageObjects {
	
	@FindBy(how=How.XPATH,using=".//*[@id='acpOverviewView']/div/div/div/h1")
	public WebElement advanceCarePlanningOverViewText;

	@FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/h1")
	public WebElement advanceCareTextVerify;
}
