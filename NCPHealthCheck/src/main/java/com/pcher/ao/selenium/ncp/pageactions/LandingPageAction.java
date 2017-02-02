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
import com.pcehr.base.utils.UtilityMethods;
import com.pcher.ao.selenium.ncp.pageobjects.LandingPageObject;

/**
 * @author bhaskara.vallapu
 * This class  holds the functionalities that offered by the landing page.
 */
public class LandingPageAction extends LandingPageObject implements Action {
	Logger logger=Logger.getLogger("LandingPageAction");

	@Override
	public boolean performAction(String action) throws HealthCheckException {
		logger.info("Enter into the PerformAction on clickonCardName");
		try{
           
		UtilityMethods.clickElement(card_nameField, BrowserFactory.loadUrl());
			logger.info("Landing page Successful");

		} 
		catch(NoSuchElementException e){
			logger.fatal("Exception occured - Element not found",e);
			 throw new HealthCheckException(HealthCheckConstants.LANDING_PAGE_STATUS_FAILED);
		}
		catch(TimeoutException e){
			 logger.fatal("Exception occured - Time out",e);
			 throw new HealthCheckException(HealthCheckConstants.LANDING_PAGE_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}catch(Exception e){
			logger.fatal("Exception occured at clickOncardName method");
			throw new HealthCheckException(HealthCheckConstants.LANDING_PAGE_STATUS_FAILED);
		}
		logger.info("Leaving the clickonCardName method");
		return true;
	}


}
