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
import com.pcher.ao.selenium.ncp.pageobjects.DischargePageObjects;

public class DischargeSummaryVerifier extends DischargePageObjects implements Verifier {
Logger logger=Logger.getLogger("DischargeSummaryVerifier");
	@Override
	public boolean verify(String action) throws HealthCheckException, CustomException, Exception {
		try {
			logger.info("Enter into the DischargeSummaryVerifier method");
			UtilityMethods.awaitForPageToLoad(dischargeSummaryText, BrowserFactory.loadUrl());
			String vdischargeSummariesText=dischargeSummaryText.getText();
			if (vdischargeSummariesText.equals(NCPLoadEnvironmentProperties.DISCHARGE_SUMMARY_VERIFIER_TEXT)){
				logger.info("DischargeSummary Verifier --Success");
				return true;
			}
			else{
			logger.fatal("DischargeSummary Verifier -- Failed");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.DISCHARGE_SUMMARY_FAILED);
		}	
	}catch(HealthCheckException e){
		throw e;
	}catch(Exception e){
		logger.fatal(" DischargeSummary page verification failed.Aborting",e);
		throw new HealthCheckException(HealthCheckConstants.DISCHARGE_SUMMARY_FAILED,e);
	}
		
	}
}
