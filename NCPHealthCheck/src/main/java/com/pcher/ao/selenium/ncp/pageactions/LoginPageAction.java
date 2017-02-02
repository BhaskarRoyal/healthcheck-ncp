package com.pcher.ao.selenium.ncp.pageactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.action.Action;
import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.base.utils.BrowserFactory;
import com.pcehr.base.utils.CustomException;
import com.pcehr.base.utils.NCPLoadEnvironmentProperties;
import com.pcehr.base.utils.UtilityMethods;
import com.pcher.ao.selenium.ncp.pageobjects.LoginPageObject;

/**
 * @author bhaskara.vallapu

 * This class will holds the services that are offered by LoginPage like
   Login by entering UserName and Password.
 */

public class LoginPageAction extends LoginPageObject implements Action{
		Logger logger=Logger.getLogger("LoginPageAction");

		@Override
		public boolean performAction(String action) throws HealthCheckException, CustomException, Exception {
			try {
				 logger.info("Enter into the performBackEndLogin method");
				 usernameField.sendKeys(NCPLoadEnvironmentProperties.UserName);
				 passwordField.sendKeys(NCPLoadEnvironmentProperties.PassWord);
				 UtilityMethods.clickElement(loginButton, BrowserFactory.loadUrl());
				 logger.info("login Successful - Leaving");
			} catch(TimeoutException e){
				 logger.fatal("Exception occured - Time out",e);
				 throw new HealthCheckException(HealthCheckConstants.LANDING_PAGE_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
			}catch (Exception e) {
				 logger.fatal("Exception occured at doLogin Method",e);
				 throw new HealthCheckException(HealthCheckConstants.LANDING_PAGE_STATUS_FAILED);
			}
			return true;
		}
}
			
