package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DiagnosticImagingReportsObject {
	
	@FindBy(how = How.XPATH, using = ".//h1[@class='intro__heading']")
	public WebElement diagnostic_verify_text;
}
