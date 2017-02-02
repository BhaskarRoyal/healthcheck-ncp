/**
 * 
 */
package com.pcehr.ao.selenium.ncp.verifiers;

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
import com.pcher.ao.selenium.ncp.pageobjects.PersonalHealthNoteObjects;

/**
 * @author bhaskara.vallapu
 *
 */
public class PersonalHealthNotesVerifier extends PersonalHealthNoteObjects implements Verifier{
	Logger logger=Logger.getLogger("PersonalHealthNotesVerifier");
	@Override
	public boolean verify(String action) throws HealthCheckException, CustomException, Exception {
		try {
             logger.info("Enter into the personalHealthNoteVerfier..");
             UtilityMethods.awaitForPageToLoad(personalHealthNotesText, BrowserFactory.loadUrl());
             String vPersonalHealthNotesText=personalHealthNotesText.getText();
             logger.info("Personal healthnotesText"+vPersonalHealthNotesText + "NCPLoadEnvironmentProperties" +NCPLoadEnvironmentProperties.PERSONAL_HEALTH_NOTE_VERIFIER_TEXT);
             if(vPersonalHealthNotesText.equals(NCPLoadEnvironmentProperties.PERSONAL_HEALTH_NOTE_VERIFIER_TEXT)){
            	 logger.info("personalHealthNote verifer -- success");
            	 return true;
             }else{
            	 TakesScreenshotTest.takeScreenShot();
            	 logger.info("personalHealthnotes verifier -- fail");
             }

		} catch(NoSuchElementException e){
			logger.fatal("Exception occured :: Element not found",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.PERSONAL_HEALTH_NOTES_STATUS_FAILED);
		}
		
		catch(TimeoutException e){
			logger.fatal("Exception occured :: Timeout",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.PERSONAL_HEALTH_NOTES_STATUS_FAILED);
		}
		catch(HealthCheckException e){
			throw e;
		}catch(Exception e){
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.PERSONAL_HEALTH_NOTES_STATUS_FAILED);
		}
		
		
		return false;
	}

}
