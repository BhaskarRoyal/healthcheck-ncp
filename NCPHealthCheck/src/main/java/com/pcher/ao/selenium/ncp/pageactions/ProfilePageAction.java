/**
 * 
 */
package com.pcher.ao.selenium.ncp.pageactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.action.Action;
import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.base.utils.BrowserFactory;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcehr.base.utils.UtilityMethods;
import com.pcher.ao.selenium.ncp.pageobjects.ProfilePageObjects;

/**
 * @author bhaskara.vallapu
 *
 */
public class ProfilePageAction extends ProfilePageObjects implements Action{
	Logger logger=Logger.getLogger("ProfilePageAction");



	@Override
	public boolean performAction(String action) throws HealthCheckException {
		if(HealthCheckConstants.DEMOGRAPHICS_PAGE.equals(action)){
			performSave();
		}
		return true;
	}

	private boolean performSave() throws HealthCheckException {
		logger.info("Enter into browse all profileLink method");
		try {    
			if(clearButton.isEnabled() && clearButton.isDisplayed()){
				UtilityMethods.clickElement(clearButton, BrowserFactory.loadUrl());	
			}else {
				TakesScreenshotTest.takeScreenShot();
				logger.info("MyGov is in read only mode so  clearButton  is in disable mode..");
				 return true;
			}
			if(radioButton1.isEnabled() && radioButton1.isDisplayed()){
				UtilityMethods.clickElement(radioButton1, BrowserFactory.loadUrl());
			}
			else {
				 logger.info("MyGov is in read only mode so  radioButton  is in disable mode..");
				 return true;
			}
			if(save.isEnabled() && save.isDisplayed()){
				UtilityMethods.clickElement(save, BrowserFactory.loadUrl());
			}else {
				radioButton2.click();
				if(save.isEnabled() && save.isDisplayed()){
					save.click();
				} else{
					logger.info("MyGov is in read only mode so  save  is in disable mode..");
				}
			   return true;
			}
			
			UtilityMethods.awaitForPageToLoad(okButton, BrowserFactory.loadUrl());
			if(okButton.isEnabled() || okButton.isDisplayed()){
				UtilityMethods.clickElement(okButton, BrowserFactory.loadUrl());
			}
			else {
				TakesScreenshotTest.takeScreenShot();
				logger.info("MyGov is in read only mode so  okButton  is in disable mode..");
				 return true;
			}
			
			logger.info("browse all performSave successful");

		} 
		catch(NoSuchElementException noe){
			logger.fatal("Exception occured --- Nosuchelement Found");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.Demographics_STATUS_FAILED);
		}

		catch(TimeoutException e){
			logger.fatal("Exception occured - Time out performSave",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.Demographics_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}catch(Exception e){
			logger.fatal("Exception occured at profileLink method");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.Demographics_STATUS_FAILED );
		}
		return false;
	}


}
