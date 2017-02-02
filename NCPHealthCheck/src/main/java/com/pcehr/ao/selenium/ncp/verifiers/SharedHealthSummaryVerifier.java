package com.pcehr.ao.selenium.ncp.verifiers;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.ao.global.verifiers.Verifier;
import com.pcehr.base.utils.NCPLoadEnvironmentProperties;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcher.ao.selenium.ncp.pageobjects.SharedHealthSummaryObject;

public class SharedHealthSummaryVerifier extends SharedHealthSummaryObject implements Verifier {

	Logger logger=Logger.getLogger("SharedHealthSummaryObject");
	
	@Override
	public boolean verify(String action) throws HealthCheckException {
		
		try {
			String textMsg=sharedHealthSummaryTxtVerify.getText();
			
			logger.fatal("Entering SharedHealthSummaryObject verification");
			
			if(NCPLoadEnvironmentProperties.SHARED_HEALTH_SUMMARY_VERIFIER_TEXT.equals(textMsg)){
				logger.fatal("Leaving SharedHealthSummaryObject");
				return true;
			}else {
				logger.fatal("SharedHealthSummaryObject failed.Aborting");
				TakesScreenshotTest.takeScreenShot();
				throw new HealthCheckException(HealthCheckConstants.SHARED_HEALTH_SUMMARY_STATUS_FAILED);
			}
			
		} catch(TimeoutException toe){
			logger.fatal("TimeoutException occured at SharedHealthSummaryVerifier");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.SHARED_HEALTH_SUMMARY_STATUS_FAILED);
		}
		catch(NoSuchElementException e){
			logger.fatal("TimeoutException occured at SharedHealthSummaryVerifier");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.SHARED_HEALTH_SUMMARY_STATUS_FAILED);
		}
    		
		catch(HealthCheckException e){
			throw e;
		}catch(Exception e){
			logger.fatal("Exception occured:");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.SHARED_HEALTH_SUMMARY_STATUS_FAILED);
		}
	}
}
	
