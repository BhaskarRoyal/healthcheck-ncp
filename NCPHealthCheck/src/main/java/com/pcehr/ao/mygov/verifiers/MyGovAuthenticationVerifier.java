/**
 * 
 */
package com.pcehr.ao.mygov.verifiers;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.ao.global.verifiers.Verifier;
import com.pcehr.ao.mygov.pageobjects.MyGovAuthenticationPageObject;
import com.pcehr.base.utils.CustomException;
import com.pcehr.base.utils.TakesScreenshotTest;

/**
 * @author bhaskara.vallapu
 *
 */
public class MyGovAuthenticationVerifier extends MyGovAuthenticationPageObject implements Verifier {
 Logger logger =Logger.getLogger("MyGovAuthenticationVerifier");
	@Override
	public boolean verify(String action) throws HealthCheckException, CustomException, Exception {
		
		try {
			logger.info("Enter into the myGov Auth Verifier method");
			if(questionNameText!=null){
				logger.info("myGovAuthentication verifier success");
				return true;
			}
			else{
				logger.info("myGovAuthentication  verifier failed");
				TakesScreenshotTest.takeScreenShot();
				return false;
			}
		}
			catch (TimeoutException e) {
				 logger.fatal("TimeoutException occured::" ,e);
				 TakesScreenshotTest.takeScreenShot();
				 throw new HealthCheckException(HealthCheckConstants.MYGOV_AUTHENTICATION_PAGEFAILED);
				}
			 catch (NoSuchElementException e) {
				 logger.fatal("Exeception occured:: NosuchElement" ,e);
				 TakesScreenshotTest.takeScreenShot();
				 throw new HealthCheckException(HealthCheckConstants.MYGOV_AUTHENTICATION_PAGEFAILED);
			
		} catch (Exception e) {
			logger.fatal("Exeception occured::" ,e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.MYGOV_AUTHENTICATION_PAGEFAILED);
		}
	}
}
