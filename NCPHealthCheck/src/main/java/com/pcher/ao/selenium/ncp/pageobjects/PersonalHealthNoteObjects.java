package com.pcher.ao.selenium.ncp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * 
 * @author dinesh.kaki
 *
 */
public class PersonalHealthNoteObjects {

	
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Personal Health Note')]")
	public WebElement personalHealthNoteLink;
	
	@FindBy(how = How.XPATH, using = "html/body/div[3]/div[3]/div/div/button")
	public WebElement addPersonalHealthNote;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='eventdate']")
	public WebElement eventDateBox;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='title']")
	public WebElement titleBox;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='description']")
	public WebElement descriptionBox;
	
	//@FindBy(how=How.XPATH,using=".//*[@id='top']/div[3]/div[3]/div/h1")
	@FindBy(how=How.XPATH,using="//h1[contains(text(),'Personal Health Notes')]")
	public WebElement personalHealthNotesText;
	
	
	@FindBy(how = How.XPATH, using = ".//*[@id='add-phn']")
	public WebElement submitButton;
	

}
