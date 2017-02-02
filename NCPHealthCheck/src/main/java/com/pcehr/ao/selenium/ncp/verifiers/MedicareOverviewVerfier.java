package com.pcehr.ao.selenium.ncp.verifiers;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.ao.global.verifiers.Verifier;
import com.pcehr.base.utils.NCPLoadEnvironmentProperties;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcher.ao.selenium.ncp.pageobjects.MedicareOverviewObject;

public class MedicareOverviewVerfier extends MedicareOverviewObject implements Verifier {
	Logger logger=Logger.getLogger("MedicareOverviewVerfier");
	@Override
	public boolean verify(String action) throws HealthCheckException {
		
		try {
			String textMsg=medicareVerifierText.getText();
			
			logger.fatal("Entering MedicareOverview page verification");
			
			if(NCPLoadEnvironmentProperties.MEDICARE_OVERVIEW_VERIFIER_TEXT.equals(textMsg)){
				logger.fatal("Leaving MedicareOverviewVerfier");
				return true;
			}else {
				logger.fatal("MedicareOverviewVerfier failed.Aborting");
				TakesScreenshotTest.takeScreenShot();
				throw new HealthCheckException(HealthCheckConstants.MEDICARE_OVERVIEW_STATUS_FAILED);
			}

		}
		
		catch(NoSuchElementException e){
			logger.fatal("Execption occured::Element not found",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.MEDICARE_OVERVIEW_STATUS_FAILED);
		}
		catch(TimeoutException e){
			logger.fatal("Execption occured::Time out",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.MEDICARE_OVERVIEW_STATUS_FAILED);
		}
		catch(HealthCheckException e){
			throw e;
		}catch(Exception e){
			logger.fatal("MedicareOverviewVerfier page verification failed.Aborting",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.MEDICARE_OVERVIEW_STATUS_FAILED);
		}
   }
}
