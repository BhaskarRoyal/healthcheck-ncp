/**
 * 
 */
package com.pcher.ao.selenium.ncp.pageactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.action.Action;
import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.base.utils.BrowserFactory;
import com.pcehr.base.utils.CustomException;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcehr.base.utils.UtilityMethods;
import com.pcher.ao.selenium.ncp.pageobjects.DocumentsTabObjects;

/**
 * @author bhaskara.vallapu
 *
 */
public class AdvanceCarePlanningPageActions extends DocumentsTabObjects implements Action {

	Logger logger=Logger.getLogger("AdvanceCarePlanningPageActions");
	@Override
	public boolean performAction(String action) throws HealthCheckException, CustomException, Exception {
           try {
			  logger.info("Enter into the AdvanceCarePlanning actions method");
			  UtilityMethods.clickElement(advancedCarePlanning, BrowserFactory.loadUrl());
			  logger.info("clicked on AdvanceCare Planning Link");
		}
           catch(NoSuchElementException e){
				 logger.fatal("Exception occured - Element not found clickonAdvanceCarePlanningLink",e);
				 TakesScreenshotTest.takeScreenShot();
				 throw new HealthCheckException(HealthCheckConstants.ADVANCECARE_PLANNING_DOCUMENT_FAILED);
			}
			 catch(TimeoutException e){
				 logger.fatal("Exception occured - Time out clickonAdvanceCarePlanningLink",e);
				 TakesScreenshotTest.takeScreenShot();
				 throw new HealthCheckException(HealthCheckConstants.ADVANCECARE_PLANNING_DOCUMENT_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
			}catch(Exception e){
				logger.fatal("Exception occured at clickonAdvanceCarePlanningLink method");
				TakesScreenshotTest.takeScreenShot();
				throw new HealthCheckException(HealthCheckConstants.ADVANCECARE_PLANNING_DOCUMENT_FAILED );
			}
		return true;
	}

}
