package com.pcehr.ao.executors;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pcehr.ao.global.action.Action;
import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.ao.global.verifiers.Verifier;
import com.pcehr.ao.mygov.pageactions.MyGovAuthenticationPageAction;
import com.pcehr.ao.mygov.pageactions.MyGovHomePageAction;
import com.pcehr.ao.mygov.pageactions.MyGovLoginPageAction;
import com.pcehr.ao.mygov.verifiers.MyGovAuthenticationVerifier;
import com.pcehr.ao.mygov.verifiers.MyGovHomePageVerifier;
import com.pcehr.ao.mygov.verifiers.MyGovLoginPageVerifier;
import com.pcehr.ao.selenium.ncp.verifiers.DiagnosticImagingReportsVerifier;
import com.pcehr.ao.selenium.ncp.verifiers.HomePageVerfier;
import com.pcehr.ao.selenium.ncp.verifiers.LoginPageVerifier;
import com.pcehr.ao.selenium.ncp.verifiers.LogoutVerifier;
import com.pcehr.ao.selenium.ncp.verifiers.MedicareOverviewVerfier;
import com.pcehr.ao.selenium.ncp.verifiers.NotificationSettingsPageVerifier;
import com.pcehr.ao.selenium.ncp.verifiers.PathologyReportsVerifier;
import com.pcehr.ao.selenium.ncp.verifiers.PersonalHealthNotesVerifier;
import com.pcehr.ao.selenium.ncp.verifiers.PersonalHealthSummaryVerifier;
import com.pcehr.ao.selenium.ncp.verifiers.ProfileVerifier;
import com.pcehr.ao.selenium.ncp.verifiers.SharedHealthSummaryVerifier;
import com.pcehr.base.utils.BrowserFactory;
import com.pcehr.base.utils.CustomException;
import com.pcehr.base.utils.LoadCommonProperties;
import com.pcehr.base.utils.MailUtility;
import com.pcehr.base.utils.NCPLoadEnvironmentProperties;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcehr.base.utils.UtilityMethods;
import com.pcher.ao.selenium.ncp.pageactions.ClinicalRecordsPageActions;
import com.pcher.ao.selenium.ncp.pageactions.HealthRecordHomeAction;
import com.pcher.ao.selenium.ncp.pageactions.KeyInformatinAddedAction;
import com.pcher.ao.selenium.ncp.pageactions.LandingPageAction;
import com.pcher.ao.selenium.ncp.pageactions.LoginPageAction;
import com.pcher.ao.selenium.ncp.pageactions.ProfilePageAction;

public class NCPHealthCheckExecutor {
	public static Logger logger=Logger.getLogger("NCPHealthCheckExecutor");
	private static WebDriver driver;
	public static void main(String[] args) throws Exception {

		GregorianCalendar gcStart = new GregorianCalendar();
		long startTime = gcStart.getTimeInMillis();
		logger.info("start Time" +startTime);
		long endTime=0;
		NCPHealthCheckExecutor executor = new NCPHealthCheckExecutor();
		NCPLoadEnvironmentProperties prop=new NCPLoadEnvironmentProperties();
		WebDriver driver= null;
		LinkedHashMap<String,Boolean> status = executor.loadStatusMap();

		try {
			driver=BrowserFactory.loadUrl();
			Verifier verify=null;
			Action action=null;

			
		   /**
		    * checking read_only_hc flag value
		    * if it is true, then it executes the read_only_hc flow
		    * else normal flow will execute.
		    */
			
			//read_only_hc flow....
             if(NCPLoadEnvironmentProperties.NCP_READ_ONLY!= null && NCPLoadEnvironmentProperties.NCP_READ_ONLY.equals("true")){
            	logger.info("read_only_hc flow executing......");
            	 if (NCPLoadEnvironmentProperties.Perform_login != null
 						&& NCPLoadEnvironmentProperties.Perform_login.equals("yes")) {
 					action = PageFactory.initElements(driver, LoginPageAction.class);
 					action.performAction(HealthCheckConstants.LOGIN_PAGE);
 					status.put(HealthCheckConstants.LOGIN_PAGE, true);

 					// backEndLoginPageVerifier
 					verify = PageFactory.initElements(driver, LoginPageVerifier.class);
 					verify.verify(null);
 					status.put(HealthCheckConstants.LOGIN_PAGE, verify.verify(null));
 				} 
            	 
            	// frontEnd login Action(MYGOV)

 				if (NCPLoadEnvironmentProperties.Perform_myGovLogin != null
 						&& NCPLoadEnvironmentProperties.Perform_myGovLogin.equals("yes")) {
 					action = PageFactory.initElements(driver, MyGovLoginPageAction.class);
 					action.performAction(null);
 					status.put(HealthCheckConstants.MYGOV_LOGIN_PAGE, true);
 					logger.info("Status of the login page" + status.get(HealthCheckConstants.MYGOV_LOGIN_PAGE));

 					// FronEndlogin PageVerifier(MYGOV)
 					verify = PageFactory.initElements(driver, MyGovLoginPageVerifier.class);
 					verify.verify(null);
 					status.put(HealthCheckConstants.MYGOV_LOGIN_PAGE, verify.verify(null));
 				}
 				// Authentication page action(MYGOV)

 				if (NCPLoadEnvironmentProperties.Perform_myGovAuthentication != null
 						&& NCPLoadEnvironmentProperties.Perform_myGovAuthentication.equals("yes")) {
 					action = PageFactory.initElements(driver, MyGovAuthenticationPageAction.class);
 					action.performAction(null);

 					// Authentication verifier
 					verify = PageFactory.initElements(driver, MyGovAuthenticationVerifier.class);
 					verify.verify(null);
 					status.put(HealthCheckConstants.MYGOV_AUTHENTICATION_PAGE, verify.verify(null));
 				}

 				// myGovHomePage Action(MYGOV)
 				if (NCPLoadEnvironmentProperties.Perform_myGovHomePage != null
 						&& NCPLoadEnvironmentProperties.Perform_myGovHomePage.equals("yes")) {
 					action = PageFactory.initElements(driver, MyGovHomePageAction.class);
 					action.performAction(null);

 					// myHomepageVerifier
 					verify = PageFactory.initElements(driver, MyGovHomePageVerifier.class);
 					verify.verify(null);
 					status.put(HealthCheckConstants.MYGOV_HOME_PAGE, verify.verify(null));
 				}


            	 
            	// landingPage action
 				if (NCPLoadEnvironmentProperties.Perform_landing != null
 						&& NCPLoadEnvironmentProperties.Perform_landing.equals("yes")) {
 					action = PageFactory.initElements(driver, LandingPageAction.class);
 					action.performAction(null);

 					// landingpage verifier
 					verify = PageFactory.initElements(driver, HomePageVerfier.class);
 					verify.verify(null);
 					status.put(HealthCheckConstants.LANDING_PAGE, verify.verify(null));
 				}
 			   // PersonalHealthNote Page
				if (NCPLoadEnvironmentProperties.Perform_personalHealthNotes!= null
						&& NCPLoadEnvironmentProperties.Perform_personalHealthNotes.equals("yes")) {
					action = PageFactory.initElements(driver, HealthRecordHomeAction.class);
					action.performAction(HealthCheckConstants.PERSONAL_HEALTH_NOTES);
					action = PageFactory.initElements(driver, KeyInformatinAddedAction.class);
					action.performAction(HealthCheckConstants.UPLOAD_DOCUMENTS);

					// verify PersonalHealthNotes
					verify = PageFactory.initElements(driver, PersonalHealthNotesVerifier.class);
					status.put(HealthCheckConstants.PERSONAL_HEALTH_NOTES, verify.verify(null));
				}

				// Demographics

				if (NCPLoadEnvironmentProperties.Perform_demographics != null
						&& NCPLoadEnvironmentProperties.Perform_demographics.equals("yes")) {
					action = PageFactory.initElements(driver, HealthRecordHomeAction.class);
					action.performAction(HealthCheckConstants.BROWSE_ALL);
					action = PageFactory.initElements(driver, ProfilePageAction.class);
					action.performAction(HealthCheckConstants.DEMOGRAPHICS_PAGE);

					// Verify Demographics
					verify = PageFactory.initElements(driver, ProfileVerifier.class);
					status.put(HealthCheckConstants.DEMOGRAPHICS_PAGE, verify.verify(null));
				}
 				//notification Settings
				
				if (NCPLoadEnvironmentProperties.Perform_notificationSettings!= null
						&& NCPLoadEnvironmentProperties.Perform_notificationSettings.equals("yes")) {
					action = PageFactory.initElements(driver, HealthRecordHomeAction.class);
					action.performAction(HealthCheckConstants.NOTIFICATION_SETTINGS);
					

					// verify notification Settings
					verify = PageFactory.initElements(driver, NotificationSettingsPageVerifier.class);
					status.put(HealthCheckConstants.NOTIFICATION_SETTINGS, verify.verify(null));
				}

            	 
            	 
             }
			
			

  		   /**
  		    * checking read_only_hc flag value
  		    * if it is true, then it executes the read_only_hc flow
  		    * else normal flow will execute.
  		    */
             
             //Normal NCP hc flow...
			else {
				logger.info("normal_ncp_hc flow executing......");
				// Login Page
				if (NCPLoadEnvironmentProperties.Perform_login != null
						&& NCPLoadEnvironmentProperties.Perform_login.equals("yes")) {
					action = PageFactory.initElements(driver, LoginPageAction.class);
					action.performAction(HealthCheckConstants.LOGIN_PAGE);
					status.put(HealthCheckConstants.LOGIN_PAGE, true);

					// backEndLoginPageVerifier
					verify = PageFactory.initElements(driver, LoginPageVerifier.class);
					verify.verify(null);
					status.put(HealthCheckConstants.LOGIN_PAGE, verify.verify(null));
				}
				
				// frontEnd login Action(MYGOV)

				if (NCPLoadEnvironmentProperties.Perform_myGovLogin != null
						&& NCPLoadEnvironmentProperties.Perform_myGovLogin.equals("yes")) {
					action = PageFactory.initElements(driver, MyGovLoginPageAction.class);
					action.performAction(null);
					status.put(HealthCheckConstants.MYGOV_LOGIN_PAGE, true);
					logger.info("Status of the login page" + status.get(HealthCheckConstants.MYGOV_LOGIN_PAGE));

					// FronEndlogin PageVerifier(MYGOV)
					verify = PageFactory.initElements(driver, MyGovLoginPageVerifier.class);
					verify.verify(null);
					status.put(HealthCheckConstants.MYGOV_LOGIN_PAGE, verify.verify(null));
				}
				// Authentication page action(MYGOV)

				if (NCPLoadEnvironmentProperties.Perform_myGovAuthentication != null
						&& NCPLoadEnvironmentProperties.Perform_myGovAuthentication.equals("yes")) {
					action = PageFactory.initElements(driver, MyGovAuthenticationPageAction.class);
					action.performAction(null);

					// Authentication verifier
					verify = PageFactory.initElements(driver, MyGovAuthenticationVerifier.class);
					verify.verify(null);
					status.put(HealthCheckConstants.MYGOV_AUTHENTICATION_PAGE, verify.verify(null));
				}

				// myGovHomePage Action(MYGOV)
				if (NCPLoadEnvironmentProperties.Perform_myGovHomePage != null
						&& NCPLoadEnvironmentProperties.Perform_myGovHomePage.equals("yes")) {
					action = PageFactory.initElements(driver, MyGovHomePageAction.class);
					action.performAction(null);

					// myHomepageVerifier
					verify = PageFactory.initElements(driver, MyGovHomePageVerifier.class);
					verify.verify(null);
					status.put(HealthCheckConstants.MYGOV_HOME_PAGE, verify.verify(null));
				}


				// landingPage action
				if (NCPLoadEnvironmentProperties.Perform_landing != null
						&& NCPLoadEnvironmentProperties.Perform_landing.equals("yes")) {
					action = PageFactory.initElements(driver, LandingPageAction.class);
					action.performAction(null);

					// landingpage verifier
					verify = PageFactory.initElements(driver, HomePageVerfier.class);
					verify.verify(null);
					status.put(HealthCheckConstants.LANDING_PAGE, verify.verify(null));
				}

				
				// Click on medicare overview
				if (NCPLoadEnvironmentProperties.Perform_medicareOverview != null
						&& NCPLoadEnvironmentProperties.Perform_medicareOverview.equals("yes")) {
					action = PageFactory.initElements(driver, HealthRecordHomeAction.class);
					action.performAction(HealthCheckConstants.MEDICARE_OVERVIEW);

					// Verify medicare overview
					verify = PageFactory.initElements(driver, MedicareOverviewVerfier.class);
					status.put(HealthCheckConstants.MEDICARE_OVERVIEW, verify.verify(null));
				}

				// PersonalHealthSummary Page

				if (NCPLoadEnvironmentProperties.Perform_personalHealthSummary != null
						&& NCPLoadEnvironmentProperties.Perform_personalHealthSummary.equals("yes")) {
					action = PageFactory.initElements(driver, HealthRecordHomeAction.class);
					action.performAction(HealthCheckConstants.PERSONAL_HEALTH_SUMMARY);

					action = PageFactory.initElements(driver, KeyInformatinAddedAction.class);
					action.performAction(HealthCheckConstants.KEY_INFORMATION_PERSONAL_HEALTH_SUMMARY);

					// Verify Personal health summary
					verify = PageFactory.initElements(driver, PersonalHealthSummaryVerifier.class);
					status.put(HealthCheckConstants.PERSONAL_HEALTH_SUMMARY, verify.verify(null));
				}

				// PersonalHealthNote Page
				if (NCPLoadEnvironmentProperties.Perform_personalHealthNotes!= null
						&& NCPLoadEnvironmentProperties.Perform_personalHealthNotes.equals("yes")) {
					action = PageFactory.initElements(driver, HealthRecordHomeAction.class);
					action.performAction(HealthCheckConstants.PERSONAL_HEALTH_NOTES);
					
					action = PageFactory.initElements(driver, KeyInformatinAddedAction.class);
					action.performAction(HealthCheckConstants.KEY_INFORMATION_PERSONAL_HEALTH_NOTES);

					// verify PersonalHealthNotes
					verify = PageFactory.initElements(driver, PersonalHealthNotesVerifier.class);
					status.put(HealthCheckConstants.PERSONAL_HEALTH_NOTES, verify.verify(null));
				}

				// Pathology page
				if (NCPLoadEnvironmentProperties.Perform_pathology != null
						&& NCPLoadEnvironmentProperties.Perform_pathology.equals("yes")) {
					action = PageFactory.initElements(driver, HealthRecordHomeAction.class);
					action.performAction(HealthCheckConstants.CLINICAL_RECORDS);
					action = PageFactory.initElements(driver, ClinicalRecordsPageActions.class);
					action.performAction(HealthCheckConstants.PATHOLOGY_REPORT);

					// Verify Pathology
					verify = PageFactory.initElements(driver, PathologyReportsVerifier.class);
					status.put(HealthCheckConstants.PATHOLOGY_REPORT, verify.verify(null));
				}

				// Shared health summary page
				if (NCPLoadEnvironmentProperties.Perform_sharedHealthSummary != null
						&& NCPLoadEnvironmentProperties.Perform_sharedHealthSummary.equals("yes")) {
					action = PageFactory.initElements(driver, HealthRecordHomeAction.class);
					action.performAction(HealthCheckConstants.CLINICAL_RECORDS);
					action = PageFactory.initElements(driver, ClinicalRecordsPageActions.class);
					action.performAction(HealthCheckConstants.SHARED_HEALTH_SUMMARY);

					// Verify Shared health summary
					verify = PageFactory.initElements(driver, SharedHealthSummaryVerifier.class);
					status.put(HealthCheckConstants.SHARED_HEALTH_SUMMARY, verify.verify(null));
				}

				// Diagnostic page
				if (NCPLoadEnvironmentProperties.Perform_diagnostic != null
						&& NCPLoadEnvironmentProperties.Perform_diagnostic.equals("yes")) {
					action = PageFactory.initElements(driver, HealthRecordHomeAction.class);
					action.performAction(HealthCheckConstants.CLINICAL_RECORDS);
					action = PageFactory.initElements(driver, ClinicalRecordsPageActions.class);
					action.performAction(HealthCheckConstants.DIAGONASTIC_IMAGE);

					// Verify Diagnostic
					verify = PageFactory.initElements(driver, DiagnosticImagingReportsVerifier.class);
					status.put(HealthCheckConstants.DIAGONASTIC_IMAGE, verify.verify(null));
				}

				// Demographics

				if (NCPLoadEnvironmentProperties.Perform_demographics != null
						&& NCPLoadEnvironmentProperties.Perform_demographics.equals("yes")) {
					action = PageFactory.initElements(driver, HealthRecordHomeAction.class);
					action.performAction(HealthCheckConstants.BROWSE_ALL);
					action = PageFactory.initElements(driver, ProfilePageAction.class);
					action.performAction(HealthCheckConstants.DEMOGRAPHICS_PAGE);

					// Verify Demographics
					verify = PageFactory.initElements(driver, ProfileVerifier.class);
					status.put(HealthCheckConstants.DEMOGRAPHICS_PAGE, verify.verify(null));
				}
				if (NCPLoadEnvironmentProperties.Perform_notificationSettings!= null
						&& NCPLoadEnvironmentProperties.Perform_notificationSettings.equals("yes")) {
					action = PageFactory.initElements(driver, HealthRecordHomeAction.class);
					action.performAction(HealthCheckConstants.NOTIFICATION_SETTINGS);
					

					// verify PersonalHealthNotes
					verify = PageFactory.initElements(driver, NotificationSettingsPageVerifier.class);
					status.put(HealthCheckConstants.NOTIFICATION_SETTINGS, verify.verify(null));
				}
			}
				if (NCPLoadEnvironmentProperties.Perform_logout != null
						&& NCPLoadEnvironmentProperties.Perform_logout.equals("yes")) {
					// Logout
					action = PageFactory.initElements(driver, HealthRecordHomeAction.class);
					action.performAction(HealthCheckConstants.LOGOUT);

					// Verify Logout
					verify = PageFactory.initElements(driver, LogoutVerifier.class);
					status.put(HealthCheckConstants.LOGOUT, verify.verify(null));
				}
			
		} catch (CustomException e) {
			throw new HealthCheckException("Exception occured  at main method please look into the logs", e);

		} catch (HealthCheckException e) {
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException("Exception occured  at main method please look into the logs", e);

		} catch (Exception e) {
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException("Exception occured  at main method please look into the logs", e);
		} finally {
			BrowserFactory.release();
			GregorianCalendar gc = new GregorianCalendar();
			endTime = gc.getTimeInMillis();
			logger.fatal("Health check completed on " + gc.getTime());
			logger.fatal("stats" + status);
			HashMap<String, Object> healthchkStatus = UtilityMethods.executionMessageStatus(status);
			writeLogFile((String) healthchkStatus.get("MESSAGE"));
			writeStatusLogFile((Boolean) healthchkStatus.get("STATUS"), startTime, endTime);
			MailUtility.mailStatus(healthchkStatus);

		}

	}

	/**
	 * 
	 * @return
	 */
	private LinkedHashMap<String,Boolean> loadStatusMap(){
		LinkedHashMap<String, Boolean> status = new LinkedHashMap<String, Boolean>();
		if(NCPLoadEnvironmentProperties.NCP_READ_ONLY != null && NCPLoadEnvironmentProperties.NCP_READ_ONLY.equals("true")){
			if (NCPLoadEnvironmentProperties.Perform_login != null
					&& NCPLoadEnvironmentProperties.Perform_login.equals("yes")) {
				status.put(HealthCheckConstants.LOGIN_PAGE, false);
			}
			if (NCPLoadEnvironmentProperties.Perform_landing != null
					&& NCPLoadEnvironmentProperties.Perform_landing.equals("yes")) {
				status.put(HealthCheckConstants.LANDING_PAGE, false);
			}
			
			if (NCPLoadEnvironmentProperties.Perform_personalHealthNotes != null
					&& NCPLoadEnvironmentProperties.Perform_personalHealthNotes.equals("yes")) {
				status.put(HealthCheckConstants.PERSONAL_HEALTH_NOTES, false);
			}
			
			if (NCPLoadEnvironmentProperties.Perform_demographics != null
					&& NCPLoadEnvironmentProperties.Perform_demographics.equals("yes")) {
			status.put(HealthCheckConstants.DEMOGRAPHICS_PAGE, false);
			}
			if (NCPLoadEnvironmentProperties.Perform_logout != null
					&& NCPLoadEnvironmentProperties.Perform_logout.equals("yes")) {
			status.put(HealthCheckConstants.LOGOUT, false);
			}
		}
		else{
			
		if (NCPLoadEnvironmentProperties.Perform_myGovLogin != null
				&& NCPLoadEnvironmentProperties.Perform_myGovLogin.equals("yes")) {
			status.put(HealthCheckConstants.MYGOV_LOGIN_PAGE, false);
		}
		if (NCPLoadEnvironmentProperties.Perform_myGovAuthentication != null
				&& NCPLoadEnvironmentProperties.Perform_myGovAuthentication.equals("yes")) {
			status.put(HealthCheckConstants.MYGOV_AUTHENTICATION_PAGE, false);
		}
		if (NCPLoadEnvironmentProperties.Perform_myGovHomePage != null
				&& NCPLoadEnvironmentProperties.Perform_medicareOverview.equals("yes")) {
			status.put(HealthCheckConstants.MYGOV_HOME_PAGE, false);
		}
		if (NCPLoadEnvironmentProperties.Perform_login != null
				&& NCPLoadEnvironmentProperties.Perform_login.equals("yes")) {
			status.put(HealthCheckConstants.LOGIN_PAGE, false);
		}
		if (NCPLoadEnvironmentProperties.Perform_landing != null
				&& NCPLoadEnvironmentProperties.Perform_landing.equals("yes")) {
			status.put(HealthCheckConstants.LANDING_PAGE, false);
		}
		if (NCPLoadEnvironmentProperties.Perform_medicareOverview != null
				&& NCPLoadEnvironmentProperties.Perform_medicareOverview.equals("yes")) {
			status.put(HealthCheckConstants.MEDICARE_OVERVIEW, false);
		}
		if (NCPLoadEnvironmentProperties.Perform_personalHealthSummary != null
				&& NCPLoadEnvironmentProperties.Perform_personalHealthSummary.equals("yes")) {
			status.put(HealthCheckConstants.PERSONAL_HEALTH_SUMMARY, false);
		}
		if (NCPLoadEnvironmentProperties.Perform_notificationSettings != null
				&& NCPLoadEnvironmentProperties.Perform_notificationSettings.equals("yes")) {
			status.put(HealthCheckConstants.NOTIFICATION_SETTINGS, false);
		}
		
		if (NCPLoadEnvironmentProperties.Perform_personalHealthNotes != null
				&& NCPLoadEnvironmentProperties.Perform_personalHealthNotes.equals("yes")) {
			status.put(HealthCheckConstants.PERSONAL_HEALTH_NOTES, false);
		}
		if (NCPLoadEnvironmentProperties.Perform_sharedHealthSummary != null
				&& NCPLoadEnvironmentProperties.Perform_sharedHealthSummary.equals("yes")) {
			status.put(HealthCheckConstants.SHARED_HEALTH_SUMMARY, false);
		}

		if (NCPLoadEnvironmentProperties.Perform_pathology != null
				&& NCPLoadEnvironmentProperties.Perform_pathology.equals("yes")) {
			status.put(HealthCheckConstants.PATHOLOGY_REPORT, false);
		}
		if (NCPLoadEnvironmentProperties.Perform_diagnostic != null
				&& NCPLoadEnvironmentProperties.Perform_diagnostic.equals("yes")) {
			status.put(HealthCheckConstants.DIAGONASTIC_IMAGE, false);
		}
		if (NCPLoadEnvironmentProperties.Perform_demographics != null
				&& NCPLoadEnvironmentProperties.Perform_demographics.equals("yes")) {
		status.put(HealthCheckConstants.DEMOGRAPHICS_PAGE, false);
		}
		if (NCPLoadEnvironmentProperties.Perform_logout != null
				&& NCPLoadEnvironmentProperties.Perform_logout.equals("yes")) {
		status.put(HealthCheckConstants.LOGOUT, false);
		}
	}
		logger.info("Initial Status.." + status);
		return status;
	}

	private static void writeLogFile(String message) {

		String fileName = "Ncp_logs.txt";
		logger.info("log file path" + LoadCommonProperties.LOG_FILE_PATH);
		String path = LoadCommonProperties.LOG_FILE_PATH;
		try {
			UtilityMethods.writeToFile(fileName, path, message, false);
		} catch (Exception e) {
			logger.fatal("exception occured while writing to a file", e);
		}

	}

	private static void writeStatusLogFile(Boolean status,long startTime,long endTime){

		String fileName="Ncp_status_logfile.txt";
		String path= LoadCommonProperties.LOG_FILE_PATH;
		try {
			StringBuilder stmessage = new StringBuilder();
			stmessage.append("\n");
			stmessage.append("               START_DATE                          END_DATE                                STATUS ");
			stmessage.append("\n");
			stmessage.append('\t'+UtilityMethods.milliSecondsToDate(startTime) +" " +'\t'+'\t'+UtilityMethods.milliSecondsToDate(endTime) + " " +'\t'+'\t'+'\t'+status);
			stmessage.append("\n");
			stmessage.append("================================================================================================================================");
			UtilityMethods.writeToFile(fileName, path, stmessage.toString(),true);
		} catch (Exception e) {
			logger.fatal("exception occured while writing to a file",e);
		}

	}
}
