package com.pcehr.ao.selenium.ncp.verifiers;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.ao.global.verifiers.Verifier;
import com.pcehr.base.utils.BrowserFactory;
import com.pcehr.base.utils.NCPLoadEnvironmentProperties;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcehr.base.utils.UtilityMethods;
import com.pcher.ao.selenium.ncp.pageobjects.ProfilePageObjects;

public class ProfileVerifier extends ProfilePageObjects implements Verifier {

Logger logger=Logger.getLogger("ProfileVerifier");
	
	@Override
	public boolean verify(String action) throws HealthCheckException {
		try{
			UtilityMethods.awaitForPageToLoad(profilePageVerifierTxt, BrowserFactory.loadUrl());
			
			String textMsg=profilePageVerifierTxt.getText();
			
			logger.info(NCPLoadEnvironmentProperties.PROFILE_VERIFIER_TEXT+"Entering ProfileVerifier verification"+textMsg);
			
			logger.info(NCPLoadEnvironmentProperties.PROFILE_VERIFIER_TEXT);
			
			logger.info(textMsg);
			
			if(NCPLoadEnvironmentProperties.PROFILE_VERIFIER_TEXT.equals(textMsg)){
				logger.fatal("Leaving ProfileVerifier");
				return true;
			}else {
				logger.fatal("ProfileVerifier failed.Aborting");
				TakesScreenshotTest.takeScreenShot();
				throw new HealthCheckException(HealthCheckConstants.Demographics_STATUS_FAILED);
			}
		}
		catch(TimeoutException toe){
			logger.fatal("TimeoutException occured at ProfileVerifier");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.Demographics_STATUS_FAILED);
		}
		
		catch(NoSuchElementException toe){
			logger.fatal("NoSuchElementException occured at ProfileVerifier");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.Demographics_STATUS_FAILED);
		}
    		
		catch(HealthCheckException e){
			throw e;
		}catch(Exception e){
			logger.fatal("Exception occured",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.Demographics_STATUS_FAILED);
		}
		
		
	}
}
