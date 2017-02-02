package com.pcehr.ao.selenium.ncp.verifiers;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.ao.global.verifiers.Verifier;
import com.pcehr.base.utils.BrowserFactory;
import com.pcehr.base.utils.CustomException;
import com.pcehr.base.utils.NCPLoadEnvironmentProperties;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcehr.base.utils.UtilityMethods;
import com.pcher.ao.selenium.ncp.pageobjects.RecordHomeObjects;

public class PersonalInfoVerfier extends RecordHomeObjects implements Verifier {
Logger logger=Logger.getLogger("PersonalInfoVerfier");
	@Override
	public boolean verify(String action) throws HealthCheckException, CustomException, Exception {
		try {
			logger.info("Enter into the personalVerifier method..");
			UtilityMethods.awaitForPageToLoad(profileVerifyText, BrowserFactory.loadUrl());
			String vProfileText=profileVerifyText.getText();
			if(vProfileText.equals(NCPLoadEnvironmentProperties.PROFILE_VERIFIER_TEXT)){
				logger.info("Personal info:: Success");
				return true;
			}
			else{
				logger.fatal("PersonalInfo :: Failed Aborting...");
				TakesScreenshotTest.takeScreenShot();
			}
			
		} catch (NoSuchElementException e) {
			logger.fatal("Exception Occured at PersonalInfo verifier::Element Not Found",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.PERSONAL_INFO_FAILED);

		}

		catch (TimeoutException e) {
			logger.fatal("Exception Occured at PersonalInfo verifier::Timeout Occured",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.PERSONAL_INFO_FAILED);
		}


		catch (Exception e) {
			logger.fatal("Exception Occured at PersonalInfo verifier",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.PERSONAL_INFO_FAILED);
		}
		return false;
	}
	

}
