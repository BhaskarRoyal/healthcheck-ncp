/**
 * 
 */
package com.pcehr.ao.mygov.pageactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.action.Action;
import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
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
public class MyGovAuthenticationPageAction extends MyGovAuthenticationPageObject implements Action {
	Logger logger=Logger.getLogger("MyGovAuthenticationPageAction");
	@Override
	public boolean performAction(String action) throws HealthCheckException, CustomException, Exception {
		try {
			logger.info("Enter into the perfromAuthenticationAction method");
			Thread.sleep(2000); 
			UtilityMethods.awaitForPageToLoad(questionNameText, BrowserFactory.loadUrl());
			String vQuestion=questionNameText.getText();
			if(vQuestion.equalsIgnoreCase(NCPLoadEnvironmentProperties.sq1)){
				logger.info(NCPLoadEnvironmentProperties.sq1 + "" +vQuestion);
				answersTextFiled.clear();
				logger.info(NCPLoadEnvironmentProperties.sa1);
				answersTextFiled.sendKeys(NCPLoadEnvironmentProperties.sa1);
			}
			else 
				if(vQuestion.equalsIgnoreCase(NCPLoadEnvironmentProperties.sq2)){
				logger.info(NCPLoadEnvironmentProperties.sq2 + "" +vQuestion);
				answersTextFiled.clear();
				logger.info(NCPLoadEnvironmentProperties.sa2);
				answersTextFiled.sendKeys(NCPLoadEnvironmentProperties.sa2);
			}
		    else 
				if(vQuestion.equalsIgnoreCase(NCPLoadEnvironmentProperties.sq3)){
				logger.info(NCPLoadEnvironmentProperties.sq3 + "" +vQuestion);
				answersTextFiled.clear();
				logger.info(NCPLoadEnvironmentProperties.sa3);
				answersTextFiled.sendKeys(NCPLoadEnvironmentProperties.sa3);
			}
			else 
				if(vQuestion.equalsIgnoreCase(NCPLoadEnvironmentProperties.sq4)) {
				logger.info(NCPLoadEnvironmentProperties.sq4 + "" +vQuestion);
				answersTextFiled.clear();
				logger.info(NCPLoadEnvironmentProperties.sa4);
				answersTextFiled.sendKeys(NCPLoadEnvironmentProperties.sa4);
			}
			else{
				logger.info(NCPLoadEnvironmentProperties.sq5 + vQuestion);
				answersTextFiled.clear();
				logger.info(NCPLoadEnvironmentProperties.sa5);
				answersTextFiled.sendKeys(NCPLoadEnvironmentProperties.sa5);
			
			}
			UtilityMethods.clickElement(nextButton, BrowserFactory.loadUrl());
			logger.info("Authentication--- success");
			return true;
		}catch(NoSuchElementException e){
			logger.fatal("Exception occured ::NoSuchElement",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.MYGOV_AUTHENTICATION_PAGEFAILED);
		}
		catch(TimeoutException e){
			logger.fatal("Exception occured :: TimeOutException",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.MYGOV_AUTHENTICATION_PAGEFAILED);

		}catch (Exception e) {
			logger.fatal("Exception" ,e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.MYGOV_AUTHENTICATION_PAGEFAILED);
		}

		


	}
}
