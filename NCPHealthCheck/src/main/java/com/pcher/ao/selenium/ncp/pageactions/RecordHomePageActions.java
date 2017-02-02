package com.pcher.ao.selenium.ncp.pageactions;

import com.pcehr.ao.global.action.Action;
import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.base.utils.BrowserFactory;
import com.pcehr.base.utils.CustomException;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcehr.base.utils.UtilityMethods;
import com.pcher.ao.selenium.ncp.pageobjects.RecordHomeObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;;

public class RecordHomePageActions extends RecordHomeObjects implements Action {
Logger logger=Logger.getLogger("RecordHomePageActions");
	@Override
	public boolean performAction(String action) throws HealthCheckException, CustomException, Exception {
		if(HealthCheckConstants.HEALTHSNAP_SHOT_PAGE.equals(action)){
			healthSnapshot();
		}
		else if(HealthCheckConstants.PERSONAL_INFO_PAGE.equals(action)){
			personalInfo();
		}
		else{
			advanceCarePlanningDocument();
		}
		
		return false;
	}

	public boolean healthSnapshot() throws HealthCheckException{
		try {
			logger.info("Enter into the healthSnapshot method..");
			UtilityMethods.clickElement(healthSnapshotImgLink, BrowserFactory.loadUrl());
			logger.info("clicked on healthSnapshot Link :: Success");	
		} 
		catch (NoSuchElementException  e) {
			logger.fatal("Exception Occured at healthSnapshot method",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.HEALTHSNAP_SHOT_FAILED);
		}
        catch(TimeoutException e){
        	logger.fatal("Exception Occured at healthSnapshot method :: Timeout Exception",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.HEALTHSNAP_SHOT_FAILED);
        }
		
		catch (Exception e) {
			logger.fatal("Exception occured at healthsnapshot method",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.HEALTHSNAP_SHOT_FAILED);
		}
		return false;
		
	}
	
	
	public boolean personalInfo() throws HealthCheckException{
		try {
			logger.info("Enter into the personalInfo method..");
			UtilityMethods.clickElement(personalInformationImageLink, BrowserFactory.loadUrl());
			logger.info("clicked on personalInfo Link :: Success");	
		} 
		catch (NoSuchElementException  e) {
			logger.fatal("Exception Occured at personalInfo method",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.PERSONAL_INFO_FAILED);
		}
        catch(TimeoutException e){
        	logger.fatal("Exception Occured at personalInfo method :: Timeout Exception",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.PERSONAL_INFO_FAILED);
        }
		
		catch (Exception e) {
			logger.fatal("Exception occured at personalInfo method",e);
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.PERSONAL_INFO_FAILED);
		}
		return false;
		
	}
	
	public boolean advanceCarePlanningDocument() throws HealthCheckException{
	  try {
		  logger.info("Enter into the advanceCarePlanningDocument");
		  UtilityMethods.clickElement(advanceCarePlanningDocumentLink, BrowserFactory.loadUrl());
		  logger.info("clicked on advanceCarePlanningDocumentLink :: success");
	} catch (NoSuchElementException  e) {
		logger.fatal("Exception Occured at advanceCarePlanningDocument method",e);
		TakesScreenshotTest.takeScreenShot();
		throw new HealthCheckException(HealthCheckConstants.ADVANCECARE_PLANNING_DOCUMENT_FAILED);
	}
    catch(TimeoutException e){
    	logger.fatal("Exception Occured at advanceCarePlanningDocument method :: Timeout Exception",e);
		TakesScreenshotTest.takeScreenShot();
		throw new HealthCheckException(HealthCheckConstants.ADVANCECARE_PLANNING_DOCUMENT_FAILED);
    }
	
	catch (Exception e) {
		logger.fatal("Exception occured at advanceCarePlanningDocument method",e);
		TakesScreenshotTest.takeScreenShot();
		throw new HealthCheckException(HealthCheckConstants.ADVANCECARE_PLANNING_DOCUMENT_FAILED);
	}
	return false;
	}
	
	
		
	}
	
	
	
	
