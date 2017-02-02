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
import com.pcehr.base.utils.UtilityMethods;
import com.pcher.ao.selenium.ncp.pageobjects.MHRHomepageObject;

/**
 * @author bhaskara.vallapu
 *
 */
public class MHRHomepageAction extends MHRHomepageObject implements Action {
	Logger logger=Logger.getLogger("MHRHomepageAction");

	@Override
	public boolean performAction(String action) throws HealthCheckException, CustomException, Exception {
		logger.info("Enter into the MHRHome Page Action method");
		try {
			UtilityMethods.clickElement(myHealthRecordMemberLogoPanelLink, BrowserFactory.loadUrl());
			logger.info("MHRHome page Action performed Success");
			return true;
			
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
