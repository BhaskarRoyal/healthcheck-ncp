package com.pcher.ao.selenium.ncp.pageactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.action.Action;
import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.base.utils.BrowserFactory;
import com.pcehr.base.utils.UtilityMethods;
import com.pcher.ao.selenium.ncp.pageobjects.BrowseAllTabObjects;

public class BrowseAllTabAction extends BrowseAllTabObjects implements Action {
	
	Logger logger=Logger.getLogger("BrowseAllTabAction");
	
	@Override
	public boolean performAction(String action) throws HealthCheckException {
		 logger.info("Enter into BrowseAllTabAction method");
	
			 if(HealthCheckConstants.BROWSE_ALL_PROFILE.equals(action)){
				 profileLink();
			 }
				 
		
		 return false;
	}

	/**
	 * 
	 * @return
	 * @throws HealthCheckException
	 */
	public boolean profileLink() throws HealthCheckException {
		 logger.info("Enter into browse all profileLink method");
		 try { 
				 UtilityMethods.clickElement(profile, BrowserFactory.loadUrl());
				 logger.info("browse all profileLink successful");
			
		} catch(TimeoutException e){
			 logger.fatal("Exception occured - Time out profileLink",e);
			 throw new HealthCheckException(HealthCheckConstants.BROWSE_ALL_PROFILE_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}catch(Exception e){
			logger.fatal("Exception occured at profileLink method");
			throw new HealthCheckException(HealthCheckConstants.BROWSE_ALL_PROFILE_FAILED );
		}
		 return false;
	}

}
