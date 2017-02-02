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
import com.pcehr.ao.mygov.pageobjects.MyGovAuthenticationPageObject;
import com.pcehr.base.utils.BrowserFactory;
import com.pcehr.base.utils.CustomException;
import com.pcehr.base.utils.NCPLoadEnvironmentProperties;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcehr.base.utils.UtilityMethods;

/**
 * @author bhaskara.vallapu
 *
 */
public class MyGovLoginPageVerifier extends MyGovAuthenticationPageObject implements Verifier{
 Logger logger=Logger.getLogger("MyGovLoginPageVerifier");
	@Override
	public boolean verify(String action) throws HealthCheckException, CustomException, Exception {
		try{
			logger.info("Enter  into the  myGovlogin verifier method");
			Thread.sleep(2000);
			UtilityMethods.awaitForPageToLoad(questionText, BrowserFactory.loadUrl());
			String vquestionText=questionText.getText();
			logger.info(NCPLoadEnvironmentProperties.MYGOV_LOGIN_QUESTIONTEXT_VERIFIER+"Entering myGovlogin verification"+vquestionText);
			if(NCPLoadEnvironmentProperties.MYGOV_LOGIN_QUESTIONTEXT_VERIFIER.equals(vquestionText)){
				logger.fatal("Leaving myGovlogin  verification");
				return true;
			}else {
				logger.fatal("myGovlogin  verification failed.Aborting");
				TakesScreenshotTest.takeScreenShot();
				throw new HealthCheckException(HealthCheckConstants.MYGOV_LOGIN_PAGE_FAILED);
			}	
		}
		catch(NoSuchElementException e){
			logger.fatal("Nosuch element exception occured::" ,e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.MYGOV_LOGIN_PAGE_FAILED);
			
		}
		catch(TimeoutException e){
			logger.fatal("TimeoutException occured::",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.MYGOV_LOGIN_PAGE_FAILED);
		}
		catch(HealthCheckException e){
			throw e;
		}catch(Exception e){
			logger.fatal("myGovlogin verification failed.Aborting",e);
			throw new HealthCheckException(HealthCheckConstants.MYGOV_LOGIN_PAGE_FAILED);
		}
		
		
		
	}

}
