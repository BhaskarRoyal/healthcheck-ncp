/**
 * 
 */
package com.pcehr.ao.mygov.pageactions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.action.Action;
import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.ao.mygov.pageobjects.MyGovLoginPageObject;
import com.pcehr.base.utils.BrowserFactory;
import com.pcehr.base.utils.CustomException;
import com.pcehr.base.utils.NCPLoadEnvironmentProperties;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcehr.base.utils.UtilityMethods;

/**
 * @author bhaskara.vallapu
 *
 */
public class MyGovLoginPageAction extends MyGovLoginPageObject implements Action{
	Logger logger=Logger.getLogger("MyGovLoginPageAction");

	@Override
	public boolean performAction(String action) throws HealthCheckException, CustomException, Exception {
		
	try {
		logger.info("Enter into the perform MyGovlogin Action method");
		
		Thread.sleep(2000); 
		UtilityMethods.clickElementAndClear(myGovusernameField, BrowserFactory.loadUrl());
		myGovusernameField.sendKeys(NCPLoadEnvironmentProperties.UserName);
		Thread.sleep(2000);   
		UtilityMethods.clickElementAndClear(myGovPasswordField, BrowserFactory.loadUrl());
    	myGovPasswordField.sendKeys(NCPLoadEnvironmentProperties.PassWord);
		UtilityMethods.clickElement(myGovSignIn, BrowserFactory.loadUrl());
		logger.info("MyGovLogin page Successful - Leaving");
	}
	catch(NoSuchElementException e){
		 logger.fatal("Exception occured -  element not found",e);
		 TakesScreenshotTest.takeScreenShot();
		 throw new HealthCheckException(HealthCheckConstants.MYGOV_LOGIN_PAGE_FAILED);
	}
	catch(TimeoutException e){
		 logger.fatal("Exception occured - Time out",e);
		 TakesScreenshotTest.takeScreenShot();
		 throw new HealthCheckException(HealthCheckConstants.MYGOV_LOGIN_PAGE_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
	}catch (Exception e) {
		 logger.fatal("Exception occured at doLogin Method",e);
		 TakesScreenshotTest.takeScreenShot();
		 throw new HealthCheckException(HealthCheckConstants.MYGOV_LOGIN_PAGE_FAILED);
	}
	return false;
}

}
