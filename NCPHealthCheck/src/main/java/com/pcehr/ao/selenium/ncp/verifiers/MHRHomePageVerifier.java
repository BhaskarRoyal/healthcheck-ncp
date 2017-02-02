/**
 * 
 */
package com.pcehr.ao.selenium.ncp.verifiers;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.ao.global.verifiers.Verifier;
import com.pcehr.base.utils.CustomException;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcher.ao.selenium.ncp.pageobjects.MHRHomepageObject;

/**
 * @author bhaskara.vallapu
 *
 */
public class MHRHomePageVerifier extends MHRHomepageObject implements Verifier {
Logger logger=Logger.getLogger("MHRHomePageVerifier");
	@Override
	public boolean verify(String action) throws HealthCheckException, CustomException, Exception {
		try {
			logger.info("Enter into the MHRHomePageVerifier verify method");
			if(myHealthRecordMemberLogoPanelLink!=null){
				logger.info("MHRHome page verifier success..");
				return true;
			}
			else{
				logger.fatal("Exception occured at MHRHome page verifier method");
				TakesScreenshotTest.takeScreenShot();
				return false;
			}
			
		}
		catch(TimeoutException e){
			logger.fatal("Exception occured:: Timeout",e);
			throw new HealthCheckException(HealthCheckConstants.MYGOV_HOME_PAGE_FAILED, e);
		}
		
		catch(NoSuchElementException e){
			logger.fatal("Exception occured :: NosuchElement found",e);
			throw new HealthCheckException(HealthCheckConstants.MYGOV_HOME_PAGE_FAILED, e);
			
		}
		catch (Exception e) {
			logger.fatal("Exception occured ::",e);
			throw new HealthCheckException(HealthCheckConstants.MYGOV_HOME_PAGE_FAILED, e);
		}
		
	}

}
