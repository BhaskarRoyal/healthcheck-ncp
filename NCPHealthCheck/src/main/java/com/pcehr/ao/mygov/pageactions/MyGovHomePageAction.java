/**
 * 
 */
package com.pcehr.ao.mygov.pageactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.action.Action;
import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.ao.mygov.pageobjects.MyGovHomePageObject;
import com.pcehr.base.utils.BrowserFactory;
import com.pcehr.base.utils.CustomException;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcehr.base.utils.UtilityMethods;

/**
 * @author bhaskara.vallapu
 *
 */
public class MyGovHomePageAction extends MyGovHomePageObject implements Action {

	Logger logger=Logger.getLogger("MyGovHomePageAction");
	@Override
	public boolean performAction(String action) throws HealthCheckException, CustomException, Exception {
              try {
				logger.info("Enter into the MyGovHomePageAction method ");
				try{
					UtilityMethods.clickElement(myHealthRecordServiceLinkid, BrowserFactory.loadUrl());
				}catch(StaleElementReferenceException e){
					logger.info("refreshing the refernce again in the DOM");
			       	UtilityMethods.clickElement(myHealthRecordServiceLinkid, BrowserFactory.loadUrl());	
				}
				
				logger.info("MyGovHome page success..");
				return true;
			} 
              
              catch (TimeoutException e) {
               logger.fatal("Exception occured::",e);
               TakesScreenshotTest.takeScreenShot();
               throw new HealthCheckException(HealthCheckConstants.MYGOV_HOME_PAGE_FAILED);
              }		
              catch (NoSuchElementException e) {
            	  logger.fatal("Exception occured::",e);
            	  TakesScreenshotTest.takeScreenShot();
                  throw new HealthCheckException(HealthCheckConstants.MYGOV_HOME_PAGE_FAILED);
  			}		
              catch (Exception e) {
            	  logger.fatal("Exception occured::",e);
            	  TakesScreenshotTest.takeScreenShot();
                  throw new HealthCheckException(HealthCheckConstants.MYGOV_HOME_PAGE_FAILED);
			}		
	}
	

}
