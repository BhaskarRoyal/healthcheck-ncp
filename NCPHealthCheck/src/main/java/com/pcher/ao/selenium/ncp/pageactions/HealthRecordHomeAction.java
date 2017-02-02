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
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcehr.base.utils.UtilityMethods;
import com.pcher.ao.selenium.ncp.pageobjects.HealthRecordHomePageObject;

/**
 * @author bhaskara.vallapu This class holds the functionalities that are
 *         referred by the HealthRecordHomepage
 */
public class HealthRecordHomeAction extends HealthRecordHomePageObject implements Action {
	Logger logger = Logger.getLogger("HealthRecordHomeAction");

	@Override
	public boolean performAction(String action) throws HealthCheckException {
		logger.info("Enter into HealthRecordHome  perfromAction method");

		if (HealthCheckConstants.MEDICARE_OVERVIEW.equals(action)) {
			medicareOverview();
		} else if (HealthCheckConstants.PERSONAL_HEALTH_SUMMARY.equals(action)) {
			keyInformation();
		} else if (HealthCheckConstants.PERSONAL_HEALTH_NOTES.equals(action)) {
			keyInformation();
		} else if (HealthCheckConstants.CLINICAL_RECORDS.equals(action)) {
			clinicalRecord();
		} else if (HealthCheckConstants.NOTIFICATION_SETTINGS.equals(action)) {
			notificationSettings();
		} else if (HealthCheckConstants.VIEW_ADVANCE_CARE_PAGE.equals(action)) {
			viewAdvanceCarePlanning();
		} else if (HealthCheckConstants.MEDICINES_PAGE.equals(action)) {
			medicines();
		}

		else if (HealthCheckConstants.MY_CHILDHOOD_DEVELOPMENT_PAGE.equals(action)) {
			myChildHoodDevelopement();
		} else if (HealthCheckConstants.BROWSE_ALL.equals(action)) {
			browseAllProfile();
		} else if (HealthCheckConstants.LOGOUT.equals(action)) {
			logout();
		}

		return false;
	}

	
	

	


	/**
	 * 
	 * @return
	 * @throws HealthCheckException
	 */
	public boolean logout() throws HealthCheckException {
		logger.info("Enter into logout Verifier  method");
		try {
			UtilityMethods.clickElement(represenative,BrowserFactory.loadUrl());
			UtilityMethods.clickElement(logoutlink,BrowserFactory.loadUrl());
			logger.info("logout Verifier successful");

		} catch(NoSuchElementException e){
			logger.fatal("Exception occured - Element not found",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.LOGOUT_STATUS_FAILED);
		}

		catch(TimeoutException e){
			logger.fatal("Exception occured - Time out logout",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.LOGOUT_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}catch(Exception e){
			logger.fatal("Exception occured at logout method");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.LOGOUT_STATUS_FAILED );
		}
		return false;
	}

	/**
	 * 
	 * @return
	 * @throws HealthCheckException
	 */
	public boolean browseAllProfile() throws HealthCheckException {
		logger.info("Enter into browseAllProfileLink  method");
		try {
			UtilityMethods.clickElement(browseAllTab,BrowserFactory.loadUrl());
			UtilityMethods.clickElement(profile,BrowserFactory.loadUrl());
			logger.info("browseAllProfileLink successful");

		} 
		catch(NoSuchElementException noe){
			logger.fatal("Exception occured -  NoSuchElementException browseAllProfileLink",noe);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.BROWSE_ALL_FAILED);
		}
		catch(TimeoutException e){
			logger.fatal("Exception occured - Time out browseAllProfileLink",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.BROWSE_ALL_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}catch(Exception e){
			logger.fatal("Exception occured at browseAllProfile method");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.BROWSE_ALL_FAILED );
		}
		return false;
	}


	public boolean medicareOverview() throws HealthCheckException {
		logger.info("Enter into medicareOverview method");
		try {
			UtilityMethods.clickElement(documentsTab,BrowserFactory.loadUrl());
			UtilityMethods.clickElement(medicareOverView, BrowserFactory.loadUrl());
			logger.info("medicareOverview successful");

		} 
		
		catch(NoSuchElementException noe){
			logger.fatal("Exception occured -  NoSuchElementException Medicare Overview",noe);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.MEDICARE_OVERVIEW_STATUS_FAILED);
		}
		catch(TimeoutException e){
			logger.fatal("Exception occured - Time out",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.MEDICARE_OVERVIEW_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}catch(Exception e){
			logger.fatal("Exception occured at medicareOverview method");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.MEDICARE_OVERVIEW_STATUS_FAILED );
		}
		return false;
	}

	/**
	 * 
	 * @return
	 * @throws HealthCheckException
	 */
	public boolean keyInformation() throws HealthCheckException {
		logger.info("Enter into keyInformation method");
		try {
			UtilityMethods.clickElement(documentsTab,BrowserFactory.loadUrl());
			UtilityMethods.clickElement(keyinformation, BrowserFactory.loadUrl());
			logger.info("keyInformation successful");

		}
		catch(NoSuchElementException noe){
			logger.fatal("Exception occured -  NoSuchElementException",noe);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.KEY_INFORMATION_STATUS_FAILED);
		}
		catch(TimeoutException e){
			logger.fatal("Exception occured - Time out",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.KEY_INFORMATION_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}catch(Exception e){
			logger.fatal("Exception occured at keyInformation method");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.KEY_INFORMATION_STATUS_FAILED );
		}
		return false;
	}
	

	/**
	 * 
	 * @return
	 * @throws HealthCheckException
	 */
	public boolean viewAdvanceCarePlanning() throws HealthCheckException {
		logger.info("Enter into viewAdvanceCarePlanning method");
		try {
			UtilityMethods.clickElement(documentsTab,BrowserFactory.loadUrl());
			UtilityMethods.clickElement(advanceCarePlanningLink, BrowserFactory.loadUrl());
			logger.info("viewAdvanceCarePlanning successful");	

		} 
		catch(NoSuchElementException noe){
			logger.fatal("Exception occured -  NoSuchElementException",noe);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.VIEW_ADVANCE_CARE_STATUS_FAILED);
		}
		
		catch(TimeoutException e){
			logger.fatal("Exception occured - Time out clinicalRecord",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.VIEW_ADVANCE_CARE_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}catch(Exception e){
			logger.fatal("Exception occured at clinicalRecord method");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.VIEW_ADVANCE_CARE_STATUS_FAILED );
		}
		return false;
	}
  
	
	
	public boolean  medicines() throws HealthCheckException {
	logger.info("Enter into medicines method");
	try {
		UtilityMethods.clickElement(documentsTab,BrowserFactory.loadUrl());
		UtilityMethods.clickElement(medicinesLink, BrowserFactory.loadUrl());
		logger.info("medicines successful");	

	} 
	catch(NoSuchElementException noe){
		logger.fatal("Exception occured -  NoSuchElementException",noe);
		TakesScreenshotTest.takeScreenShot();
		throw new HealthCheckException(HealthCheckConstants.MEDICINE_PAGE_STATUS_FAILED);
	}
	
	catch(TimeoutException e){
		logger.fatal("Exception occured - Time out medicines",e);
		TakesScreenshotTest.takeScreenShot();
		throw new HealthCheckException(HealthCheckConstants.MEDICINE_PAGE_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
	}catch(Exception e){
		logger.fatal("Exception occured at medicines method");
		TakesScreenshotTest.takeScreenShot();
		throw new HealthCheckException(HealthCheckConstants.MEDICINE_PAGE_STATUS_FAILED );
	}

    return false;
	
	}

	
	
	/**
	 * 
	 * @return
	 * @throws HealthCheckException
	 */
	public boolean clinicalRecord() throws HealthCheckException {
		logger.info("Enter into clinicalRecord method");
		try {
			UtilityMethods.clickElement(documentsTab,BrowserFactory.loadUrl());
			UtilityMethods.clickElement(clinicalrecordsLink, BrowserFactory.loadUrl());
			logger.info("clinicalRecord successful");	

		} 
		catch(NoSuchElementException noe){
			logger.fatal("Exception occured -  NoSuchElementException",noe);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.CLINICAL_RECORD_STATUS_FAILED);
		}
		
		catch(TimeoutException e){
			logger.fatal("Exception occured - Time out clinicalRecord",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.CLINICAL_RECORD_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}catch(Exception e){
			logger.fatal("Exception occured at clinicalRecord method");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.CLINICAL_RECORD_STATUS_FAILED );
		}
		return false;
	}
	
	
	public boolean notificationSettings() throws HealthCheckException{
		logger.info("Enter into notificationSettings method");
		try {
			UtilityMethods.clickElement(profileAndSettingsTab,BrowserFactory.loadUrl());
			UtilityMethods.clickElement(notificationSettingsLink, BrowserFactory.loadUrl());
			
			
			UtilityMethods.clickElement(emailRadiobutton, BrowserFactory.loadUrl());
			
			UtilityMethods.awaitForPageToLoad(saveButton, BrowserFactory.loadUrl());
			if(saveButton.isEnabled() || saveButton.isDisplayed()){
				UtilityMethods.clickElement(saveButton, BrowserFactory.loadUrl());
			}
			else{
				TakesScreenshotTest.takeScreenShot();
				logger.info("MyGov is in read only mode so  saveButton  is in disable mode..");
				return true;
			}
            
			
			logger.info("notificationSettings successful");	

		} 
		catch(NoSuchElementException noe){
			logger.fatal("Exception occured -  NoSuchElementException",noe);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.NOTIFICATION_SETTINGS_FAILED);
		}
		
		catch(TimeoutException e){
			logger.fatal("Exception occured - Time out notificationSettings",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.NOTIFICATION_SETTINGS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}catch(Exception e){
			logger.fatal("Exception occured at notificationSettings method");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.NOTIFICATION_SETTINGS_FAILED );
		}
		return false;
		
	}
	
	
	public boolean  myChildHoodDevelopement() throws HealthCheckException {
		logger.info("Enter into myChildHoodDevelopement method");
		try {
			UtilityMethods.clickElement(documentsTab,BrowserFactory.loadUrl());
			UtilityMethods.clickElement(myChildHoodDevelopmentLink, BrowserFactory.loadUrl());
			logger.info("myChildHoodDevelopement successful");	

		} 
		catch(NoSuchElementException noe){
			logger.fatal("Exception occured -  NoSuchElementException",noe);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.MY_CHILDHOOD_DEVELOPMENT_PAGE_FAILED);
		}
		
		catch(TimeoutException e){
			logger.fatal("Exception occured - Time out myChildHoodDevelopement",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.MY_CHILDHOOD_DEVELOPMENT_PAGE_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
		}catch(Exception e){
			logger.fatal("Exception occured at myChildHoodDevelopement method");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.MY_CHILDHOOD_DEVELOPMENT_PAGE_FAILED );
		}
		return false;
		
	}
}
