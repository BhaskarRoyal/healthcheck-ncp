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
import com.pcher.ao.selenium.ncp.pageobjects.PersonalHealthSummaryPageObject;

public class PersonalHealthSummaryVerifier extends PersonalHealthSummaryPageObject implements Verifier {
	Logger logger=Logger.getLogger("PersonalHealthSummaryVerifier");
	@Override
	public boolean verify(String action) throws HealthCheckException {
		
		try{
			UtilityMethods.awaitForPageToLoad(pageTextVerifier, BrowserFactory.loadUrl());
			String textMsg=pageTextVerifier.getText();
			
			
			logger.fatal(pageTextVerifier.getSize()+"Entering PersonalHealthSummaryVerifier"+pageTextVerifier.getTagName());
			
			logger.info("Message"+textMsg+"vText" +NCPLoadEnvironmentProperties.PERSONAL_HEALTH_SUMMARY_VERIFIER_TEXT+"dfsdfd");
			
			if(NCPLoadEnvironmentProperties.PERSONAL_HEALTH_SUMMARY_VERIFIER_TEXT.equals(textMsg)){
				logger.fatal("Leaving PersonalHealthSummaryVerifier");
				return true;
			}else {
				logger.fatal("PersonalHealthSummaryVerifier failed.Aborting");
				TakesScreenshotTest.takeScreenShot();
				throw new HealthCheckException(HealthCheckConstants.PERSONAL_HEALTH_SUMMARY_STATUS_FAILED);
			}
			
		}
		
		
		catch(NoSuchElementException e){
			logger.fatal("Exception occured :: Element not found",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.PERSONAL_HEALTH_SUMMARY_STATUS_FAILED,e);
		}
		
		catch(TimeoutException e){
			logger.fatal("Exception occured :: Timeout",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.PERSONAL_HEALTH_SUMMARY_STATUS_FAILED,e);
		}
		catch(HealthCheckException e){
			throw e;
		}catch(Exception e){
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.PERSONAL_HEALTH_SUMMARY_STATUS_FAILED,e);
		}
		
		
		
	}

}
