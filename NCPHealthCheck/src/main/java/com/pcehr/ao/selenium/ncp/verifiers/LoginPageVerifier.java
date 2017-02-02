package com.pcehr.ao.selenium.ncp.verifiers;


import org.apache.log4j.Logger;

import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.ao.global.verifiers.Verifier;
import com.pcehr.base.utils.BrowserFactory;
import com.pcehr.base.utils.CustomException;
import com.pcehr.base.utils.NCPLoadEnvironmentProperties;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcehr.base.utils.UtilityMethods;
import com.pcher.ao.selenium.ncp.pageobjects.LandingPageObject;

public class LoginPageVerifier extends LandingPageObject implements Verifier {

	 static Logger logger=Logger.getLogger("LoginPageVerifier");

	@Override
	public boolean verify(String action) throws HealthCheckException, CustomException, Exception {
		try{
			logger.info("Enter  into the  LandingPageVerifier method");
			UtilityMethods.awaitForPageToLoad(myHealthRecordText, BrowserFactory.loadUrl());
			String myHealthText=myHealthRecordText.getText();
			logger.fatal(myHealthText+"Entering Landing page verification"+myHealthRecordText.getText());
			if(NCPLoadEnvironmentProperties.LANDING_PAGE_VERIFIER_MY_HEALTH_RECORD.equals(myHealthText)){
				logger.fatal("Leaving Landing page verification");
				return true;
			}else {
				logger.fatal("Landing page verification failed.Aborting");
				TakesScreenshotTest.takeScreenShot();
				throw new HealthCheckException(HealthCheckConstants.LANDING_PAGE_STATUS_FAILED);
			}	
		}catch(HealthCheckException e){
			throw e;
		}catch(Exception e){
			logger.fatal("Landing page verification failed.Aborting",e);
			throw new HealthCheckException(HealthCheckConstants.LANDING_PAGE_STATUS_FAILED,e);
		}
		
	}
	
	

}
