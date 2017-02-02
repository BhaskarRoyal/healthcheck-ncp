package com.pcehr.ao.selenium.ncp.verifiers;



import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.verifiers.Verifier;
import com.pcehr.base.utils.BrowserFactory;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcehr.base.utils.UtilityMethods;
import com.pcher.ao.selenium.ncp.pageobjects.HealthRecordHomePageObject;

public class LogoutVerifier extends HealthRecordHomePageObject implements Verifier {
	Logger logger=Logger.getLogger("LogoutVerifier");
	@Override
	public boolean verify(String action)  {
		 logger.info("Enter into logout method");
		 try {   
			     UtilityMethods.clickElement(logoutlink,BrowserFactory.loadUrl());
				 logger.info("logout Failed");
				 TakesScreenshotTest.takeScreenShot();
				 return false;
		} catch(NoSuchElementException e){
			 logger.fatal("logout Sucessfull...");
			 return true;
		}catch(TimeoutException e){
			 logger.fatal(" logout Sucessfull");
			 return true;
		}catch(Throwable e){
			logger.fatal("logout Sucessfull");
			return true;
		}
		
	}
	
}
