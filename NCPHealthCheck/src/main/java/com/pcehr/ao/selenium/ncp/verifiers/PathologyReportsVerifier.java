package com.pcehr.ao.selenium.ncp.verifiers;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.ao.global.verifiers.Verifier;
import com.pcehr.base.utils.NCPLoadEnvironmentProperties;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcher.ao.selenium.ncp.pageobjects.PathologyReportsObject;

public class PathologyReportsVerifier extends PathologyReportsObject implements Verifier {

Logger logger=Logger.getLogger("PathologyReportsVerifier");
	

	@Override
	public boolean verify(String action) throws HealthCheckException {
		try {
			String textMsg=pathologyReportsverifyTxt.getText();
			
			logger.fatal("Entering PathologyReportsVerifier verification");
			
			if(NCPLoadEnvironmentProperties.PATHOLOGY_REPORTS_VERIFIER_TEXT.equals(textMsg)){
				logger.fatal("Leaving PathologyReportsVerifier");
				return true;
			}else {
				logger.fatal("PathologyReportsVerifier failed.Aborting");
				TakesScreenshotTest.takeScreenShot();
				throw new HealthCheckException(HealthCheckConstants.PATHOLOGY_REPORT_STATUS_FAILED);
			}
		
		}
		catch(NoSuchElementException e){
			logger.fatal("Exception occured :: Element not found",e );
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.PATHOLOGY_REPORT_STATUS_FAILED);
		}
		catch(TimeoutException e){
			logger.fatal("Exception occured :: Time out",e );
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.PATHOLOGY_REPORT_STATUS_FAILED);
		}
		
		
		catch(HealthCheckException e){
			throw e;
		}catch(Exception e){
			logger.fatal("PathologyReportspage verification failed.Aborting",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.PATHOLOGY_REPORT_STATUS_FAILED);
		}
   }
}

