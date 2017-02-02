/**
 * 
 */
package com.pcehr.ao.mygov.verifiers;

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
import com.pcher.ao.selenium.ncp.pageactions.LandingPageAction;

/**
 * @author bhaskara.vallapu
 *
 */
public class MyGovHomePageVerifier extends LandingPageAction implements Verifier {
  Logger logger=Logger.getLogger("MyGovHomePageVerifier");
	@Override
	public boolean verify(String action) throws HealthCheckException, CustomException, Exception {
    try {
    	logger.info("Enter into the MyGov Homepage Verifier method.");
    	UtilityMethods.awaitForPageToLoad(myHealthRecordText, BrowserFactory.loadUrl());
    	 String  vmhrText=myHealthRecordText.getText();
    	 
    	 logger.info(NCPLoadEnvironmentProperties.LANDING_PAGE_VERIFIER_MY_HEALTH_RECORD + "Entering myGov LoginPage Verfier" +vmhrText);
    	 
    	  if(vmhrText.contentEquals(NCPLoadEnvironmentProperties.LANDING_PAGE_VERIFIER_MY_HEALTH_RECORD)){
    		   logger.info("MyGov Homepage verifier success::");
    		   return true;
    	  }
    	  else{
    		   logger.info("MyGov Homepage verifier failed::");
    		   TakesScreenshotTest.takeScreenShot();
    		   return false;
    	  }
    	  
		
	} catch (TimeoutException e) {
		logger.fatal("Exception occured ::Timeout",e);
		TakesScreenshotTest.takeScreenShot();
		throw new HealthCheckException(HealthCheckConstants.MYGOV_HOME_PAGE_FAILED);
	}
    catch (NoSuchElementException e) {
    	logger.fatal("Exception occured ::",e);
    	TakesScreenshotTest.takeScreenShot();
		throw new HealthCheckException(HealthCheckConstants.MYGOV_HOME_PAGE_FAILED);
	}
		
    catch (Exception e) {
    	logger.fatal("Exception occured ::",e);
    	TakesScreenshotTest.takeScreenShot();
		throw new HealthCheckException(HealthCheckConstants.MYGOV_HOME_PAGE_FAILED);
	}
		
	}

}
