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
import com.pcher.ao.selenium.ncp.pageobjects.RecordHomePageObjects;

public class HomePageVerfier extends RecordHomePageObjects implements Verifier {
	static Logger logger=Logger.getLogger("HomePageVerfier");
	
	@Override
	public boolean verify(String action) throws HealthCheckException {
		
		
		logger.fatal("Entering Landing page verification");
		try{
			UtilityMethods.awaitForPageToLoad(recordHomeText, BrowserFactory.loadUrl());
			String textMsg=recordHomeText.getText();
			logger.fatal(NCPLoadEnvironmentProperties.HOME_PAGE_VERIFIER_TEXT+"Home page verification"+textMsg);
			
			if(NCPLoadEnvironmentProperties.HOME_PAGE_VERIFIER_TEXT.contains(textMsg)){
				logger.fatal("Leaving Home page verification");
				return true;
			}
			
			else {
				logger.fatal("Home page verification failed.Aborting");
				TakesScreenshotTest.takeScreenShot();
				throw new HealthCheckException(HealthCheckConstants.LANDING_PAGE_STATUS_FAILED);
			}
		}

		catch(NoSuchElementException e){
			logger.fatal("Exception occured :: Element not found",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.LANDING_PAGE_STATUS_FAILED);
		}
		
		catch(TimeoutException e){
			logger.fatal("Exception occured :: Timeout",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.LANDING_PAGE_STATUS_FAILED);
		}
		catch(HealthCheckException e){
			throw e;
		}catch(Exception e){
			logger.fatal("Landing page verification failed.Aborting",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.LANDING_PAGE_STATUS_FAILED);
		}
		
	}

}
