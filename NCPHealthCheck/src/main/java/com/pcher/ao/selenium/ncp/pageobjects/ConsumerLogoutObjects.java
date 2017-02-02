package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author dinesh.kaki
 *
 */
public class ConsumerLogoutObjects {

	@FindBy(how = How.XPATH, using = ".//h6[@class='switcher__date']")
	public WebElement userDropDownLink;
	
	@FindBy(how = How.XPATH, using = ".//span[@class='switcher__login']")
	public WebElement logoutLink;	
		
}
