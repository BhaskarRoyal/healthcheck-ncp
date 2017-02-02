package com.pcehr.ao.selenium.ncp.verifiers;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.ao.global.verifiers.Verifier;
import com.pcehr.base.utils.NCPLoadEnvironmentProperties;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcher.ao.selenium.ncp.pageobjects.DiagnosticImagingReportsObject;

public class DiagnosticImagingReportsVerifier extends DiagnosticImagingReportsObject implements Verifier {
	
	Logger logger=Logger.getLogger("DiagnosticImagingReportsVerifier");
	
	@Override
	public boolean verify(String action) throws HealthCheckException {
		
		try {
			String textMsg=diagnostic_verify_text.getText();
			
			logger.fatal("Entering DiagnosticImagingReportsVerifier verification");
			
			if(NCPLoadEnvironmentProperties.DIAGNOSTIC_IMAGING_REPORTS_VERIFIER_TEXT.equals(textMsg)){
				logger.fatal("Leaving DiagnosticImagingReportsVerifier");
				return true;
			}else {
				logger.fatal("DiagnosticImagingReportsVerifier failed.Aborting");
				TakesScreenshotTest.takeScreenShot();
				throw new HealthCheckException(HealthCheckConstants.DIAGONASTIC_IMAGE_REPORT_STATUS_FAILED);
			}
			
		} 
		catch(NoSuchElementException e){
			logger.fatal("Exception occured::Element not found",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.DIAGONASTIC_IMAGE_REPORT_STATUS_FAILED);
			
		}
		catch(TimeoutException e){
			logger.fatal("Exception occured::Time out",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.DIAGONASTIC_IMAGE_REPORT_STATUS_FAILED);
			
		}
		catch(HealthCheckException e){
			throw e;
		}catch(Exception e){
			logger.fatal("DiagnosticImagingReports page verification failed.Aborting",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.DIAGONASTIC_IMAGE_REPORT_STATUS_FAILED);
		}
   }
}
		

