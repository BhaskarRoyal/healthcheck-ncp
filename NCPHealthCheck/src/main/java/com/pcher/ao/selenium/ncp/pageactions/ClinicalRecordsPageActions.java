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
import com.pcher.ao.selenium.ncp.pageobjects.ClinicalRecordsPageObjects;

/**
 * @author bhaskara.vallapu
 *
 */
public class ClinicalRecordsPageActions extends ClinicalRecordsPageObjects implements Action {
	Logger logger=Logger.getLogger("ClinicalRecordsPageActions");
	
	
		@Override
		public boolean performAction(String action) throws HealthCheckException {
			boolean status =false;
			if(HealthCheckConstants.SHARED_HEALTH_SUMMARY.equals(action)){
				status = clickonSharedHealthSummariesLink();
			}else if(HealthCheckConstants.DIAGONASTIC_IMAGE.equals(action)){
				status = diagnostic();
			}else if(HealthCheckConstants.PATHOLOGY_REPORT.equals(action)){
				status = pathology();
			} else if(HealthCheckConstants.DISCHARGE_SUMMARY_PAGE.equals(action)){
				status=dischargeSummaries();
			}else if(HealthCheckConstants.EREFERRAL_PAGE.equals(action)){
				status=eReferrals();
			}else if(HealthCheckConstants.SPECIALISTLETTER_PAGE.equals(action)){
				status=specialistLetters();
			} else if(HealthCheckConstants.EVENTSUMMARY_PAGE.equals(action)){
				status=eventSummary();
			}
			
			return status;
		}
		
		
		/**
		 * 
		 * @param driver
		 * @return
		 * @throws HealthCheckException
		 */
		public boolean clickonSharedHealthSummariesLink() throws HealthCheckException{
			 logger.info("Enter into clickonSharedHealthSummariesLink method");
			 try {
				     UtilityMethods.clickElement(sharedHealthSummaryLink,BrowserFactory.loadUrl());
					 logger.info("personalHealthInfo successful");
			} 
			 catch(NoSuchElementException e){
				 logger.fatal("Exception occured - Element not found clickonSharedHealthSummariesLink",e);
				 TakesScreenshotTest.takeScreenShot();
				 throw new HealthCheckException(HealthCheckConstants.SHARED_HEALTH_SUMMARY_STATUS_FAILED);
			}
			 catch(TimeoutException e){
				 logger.fatal("Exception occured - Time out clickonSharedHealthSummariesLink",e);
				 TakesScreenshotTest.takeScreenShot();
				 throw new HealthCheckException(HealthCheckConstants.SHARED_HEALTH_SUMMARY_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
			}catch(Exception e){
				logger.fatal("Exception occured at clickonSharedHealthSummariesLink method");
				TakesScreenshotTest.takeScreenShot();
				throw new HealthCheckException(HealthCheckConstants.SHARED_HEALTH_SUMMARY_STATUS_FAILED );
			}
			 return true;
		}
		
		/**
		 * 
		 * @param driver
		 * @return
		 * @throws HealthCheckException
		 */
		public boolean diagnostic() throws HealthCheckException{
			 logger.info("Enter into diagnostic method");
			 try {
				     UtilityMethods.clickElement(diagnosticImagingReportsLink,BrowserFactory.loadUrl());
					 logger.info("personalHealthInfo successful");
			} 
			 catch(NoSuchElementException e){
				 logger.fatal("Exception occured - Element not found diagnostic",e);
				 TakesScreenshotTest.takeScreenShot();
				 throw new HealthCheckException(HealthCheckConstants.DIAGONASTIC_IMAGE_REPORT_STATUS_FAILED);
			}
			 
			 
			 catch(TimeoutException e){
				 logger.fatal("Exception occured - Time out diagnostic",e);
				 TakesScreenshotTest.takeScreenShot();
				 throw new HealthCheckException(HealthCheckConstants.DIAGONASTIC_IMAGE_REPORT_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
			}catch(Exception e){
				logger.fatal("Exception occured at diagnostic method");
				TakesScreenshotTest.takeScreenShot();
				throw new HealthCheckException(HealthCheckConstants.DIAGONASTIC_IMAGE_REPORT_STATUS_FAILED );
			}
			 return true;
		}
		
		/**
		 * 
		 * @param driver
		 * @return
		 * @throws HealthCheckException
		 */
		public boolean pathology() throws HealthCheckException{
			 logger.info("Enter into pathology method");
			 try {
				     UtilityMethods.clickElement(pathologyReportsLink,BrowserFactory.loadUrl());
					 logger.info("pathologyreport successful");
			} 
			 catch(NoSuchElementException e){
				 logger.fatal("Exception occured - NoSuchElement Found",e);
				 throw new HealthCheckException(HealthCheckConstants.PATHOLOGY_REPORT_STATUS_FAILED);
			}
			 
			 
			 catch(TimeoutException e){
				 logger.fatal("Exception occured - Time out diagnostic",e);
				 throw new HealthCheckException(HealthCheckConstants.PATHOLOGY_REPORT_STATUS_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
			}catch(Exception e){
				logger.fatal("Exception occured at diagnostic method");
				throw new HealthCheckException(HealthCheckConstants.PATHOLOGY_REPORT_STATUS_FAILED );
			}
			 return true;
		}
		
		
		/**
		 * 
		 * @param driver
		 * @return
		 * @throws HealthCheckException
		 */
		public boolean dischargeSummaries() throws HealthCheckException{
			 logger.info("Enter into dischargeSummaries method");
			 try {
				     UtilityMethods.clickElement(dischargeSummaryLink,BrowserFactory.loadUrl());
					 logger.info("DischargeSummary successful");
			} 
			 catch(NoSuchElementException e){
				 logger.fatal("Exception occured - NoSuchElement Found",e);
				 throw new HealthCheckException(HealthCheckConstants.DISCHARGE_SUMMARY_FAILED);
			}
			 
			 
			 catch(TimeoutException e){
				 logger.fatal("Exception occured - Time out dischargeSummaries",e);
				 throw new HealthCheckException(HealthCheckConstants.DISCHARGE_SUMMARY_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
			}catch(Exception e){
				logger.fatal("Exception occured at dischargeSummaries method");
				throw new HealthCheckException(HealthCheckConstants.DISCHARGE_SUMMARY_FAILED );
			}
			 return true;
		}
		
		

		/**
		 * 
		 * @param driver
		 * @return
		 * @throws HealthCheckException
		 */
		public boolean eReferrals() throws HealthCheckException{
			 logger.info("Enter into eReferrals method");
			 try {
				     UtilityMethods.clickElement(eReferralLink,BrowserFactory.loadUrl());
					 logger.info("eReferrals successful");
			} 
			 
			 catch(NoSuchElementException e){
				 logger.fatal("Exception occured - NoSuchElement Found",e);
				 throw new HealthCheckException(HealthCheckConstants.EREFERRAL_PAGE_FAILED);
			}
			 
			 catch(TimeoutException e){
				 logger.fatal("Exception occured - Time out eventSummary",e);
				 throw new HealthCheckException(HealthCheckConstants.EREFERRAL_PAGE_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
			}catch(Exception e){
				logger.fatal("Exception occured at eReferrals method");
				throw new HealthCheckException(HealthCheckConstants.EREFERRAL_PAGE_FAILED );
			}
			 return true;
		}
	
		/**
		 * 
		 * @param driver
		 * @return
		 * @throws HealthCheckException
		 */
		public boolean eventSummary() throws HealthCheckException{
			 logger.info("Enter into eventSummary method");
			 try {
				     UtilityMethods.clickElement(eventSummaryLink,BrowserFactory.loadUrl());
					 logger.info("eventSummary successful");
			} 
			 
			 catch(NoSuchElementException e){
				 logger.fatal("Exception occured - NoSuchElement Found",e);
				 throw new HealthCheckException(HealthCheckConstants.EVENTSUMMARY_PAGE_FAILED);
			}
			 
			 catch(TimeoutException e){
				 logger.fatal("Exception occured - Time out eventSummary",e);
				 throw new HealthCheckException(HealthCheckConstants.EVENTSUMMARY_PAGE_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
			}catch(Exception e){
				logger.fatal("Exception occured at eventSummary method");
				throw new HealthCheckException(HealthCheckConstants.EVENTSUMMARY_PAGE_FAILED );
			}
			 return true;
		}
		
		
		/**
		 * 
		 * @param driver
		 * @return
		 * @throws HealthCheckException
		 */
		public boolean specialistLetters() throws HealthCheckException{
			 logger.info("Enter into specialistLetters method");
			 try {
				     UtilityMethods.clickElement(specialistLetterLink,BrowserFactory.loadUrl());
					 logger.info("specialistLetters successful");
			} 
			 
			 catch(NoSuchElementException e){
				 logger.fatal("Exception occured - NoSuchElement Found",e);
				 throw new HealthCheckException(HealthCheckConstants.SPECIALISTLETTER_PAGE_FAILED);
			}
			 
			 catch(TimeoutException e){
				 logger.fatal("Exception occured - Time out specialistLetters",e);
				 throw new HealthCheckException(HealthCheckConstants.SPECIALISTLETTER_PAGE_FAILED + HealthCheckConstants.TIME_OUT_MESSAGE);
			}catch(Exception e){
				logger.fatal("Exception occured at specialistLetters method");
				throw new HealthCheckException(HealthCheckConstants.SPECIALISTLETTER_PAGE_FAILED );
			}
			 return true;
		}
		
		
	}

