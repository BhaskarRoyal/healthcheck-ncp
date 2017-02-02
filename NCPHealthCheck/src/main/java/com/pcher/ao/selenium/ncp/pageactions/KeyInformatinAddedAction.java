/**
 * 
 */
package com.pcher.ao.selenium.ncp.pageactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;

import com.pcehr.ao.global.action.Action;
import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.base.utils.BrowserFactory;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcehr.base.utils.UtilityMethods;
import com.pcher.ao.selenium.ncp.pageobjects.KeyInformationAddedObjects;

/**
 * @author bhaskara.vallapu
 *
 */
public class KeyInformatinAddedAction extends KeyInformationAddedObjects implements Action{
	Logger logger=Logger.getLogger("KeyInformatinAddedAction");

	@Override
	public boolean performAction(String action) throws HealthCheckException {
		 logger.info("Enter into clickOnPersonalInfoLink method");
		 try {
			 if(HealthCheckConstants.KEY_INFORMATION_PERSONAL_HEALTH_SUMMARY.equals(action)){
				 personalHealthSummary();
			 }else if(HealthCheckConstants.KEY_INFORMATION_PERSONAL_HEALTH_NOTES.equals(action)){
				 personalHealthNotes();
			 }else if(HealthCheckConstants.UPLOAD_DOCUMENTS.equals(action)){
				 uploadDocuments();
			 }
		
		} catch(TimeoutException e){
			 logger.fatal("Exception occured - Time out",e);
			 throw new HealthCheckException(HealthCheckConstants.HOME_PAGE_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}catch(Exception e){
			logger.fatal("Exception occured at clickOnPersonalInfoLink method");
			throw new HealthCheckException(HealthCheckConstants.HOME_PAGE_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}
		 return false;
	}

	
	  public boolean uploadDocuments() throws HealthCheckException {
		 try {
				logger.info("Enter into personalHealthNotesLink method");
				 UtilityMethods.clickElement(personalHealthNoteLink, BrowserFactory.loadUrl());
	             
				
				 UtilityMethods.awaitForPageToLoad(addApersonalHealthNotebutton, BrowserFactory.loadUrl());
				 if(addApersonalHealthNotebutton.isEnabled() && addApersonalHealthNotebutton.isDisplayed()){
				 UtilityMethods.clickElement(addApersonalHealthNotebutton, BrowserFactory.loadUrl());
				 }
				 else{
					 TakesScreenshotTest.takeScreenShot();
					 logger.info("MyGov is in read only mode so  addApersonalHealthNotebutton  is in disable mode..");
					 return true;
				 }
				 logger.info("personalHealthNotesLink successful");
				 return false;
			
		} catch(TimeoutException e){
			 logger.fatal("Exception occured - Time out",e);
			 throw new HealthCheckException(HealthCheckConstants.UPLOAD_DOCUMENTS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}catch(Exception e){
			logger.fatal("Exception occured at personalHealthNotes method");
			throw new HealthCheckException(HealthCheckConstants.UPLOAD_DOCUMENTS_FAILED );
		}
	}

	public boolean personalHealthNotes() throws HealthCheckException {
	
		 try {
				logger.info("Enter into personalHealthNotesLink method");
				 UtilityMethods.clickElement(personalHealthNoteLink, BrowserFactory.loadUrl());
				 logger.info("personalHealthNotesLink successful");
			
		} catch(TimeoutException e){
			 logger.fatal("Exception occured - Time out",e);
			 throw new HealthCheckException(HealthCheckConstants.KEY_INFORMATION_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}catch(Exception e){
			logger.fatal("Exception occured at personalHealthNotes method");
			throw new HealthCheckException(HealthCheckConstants.KEY_INFORMATION_STATUS_FAILED );
		}
		 return false;
	}


	public boolean personalHealthSummary() throws HealthCheckException {
		 try {
			 logger.info("Enter into personalHealthSummary method");
				 UtilityMethods.clickElement(personalHealthSummaryLink, BrowserFactory.loadUrl());
				 logger.info("personalHealthSummary successful");
			
		} catch(TimeoutException e){
			 logger.fatal("Exception occured - Time out",e);
			 throw new HealthCheckException(HealthCheckConstants.KEY_INFORMATION_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}catch(Exception e){
			logger.fatal("Exception occured at personalHealthSummary method");
			throw new HealthCheckException(HealthCheckConstants.KEY_INFORMATION_STATUS_FAILED );
		}
		 return false;
	}

}

