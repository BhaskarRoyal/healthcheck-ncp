package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MedicareOverviewObject {

	@FindBy(how=How.XPATH, using=".//*[@class='intro__heading']")
	public WebElement medicareVerifierText;
}
