package com.pcehr.base.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


public class NCPLoadEnvironmentProperties {
	Logger logger=Logger.getLogger("NCPLoadEnvironmentProperties");
	/**
	 * @author bhaskara.vallapu
	 * This class wil loads the propeties file
	 */

	public static final String configPropPath="./properties/config.properties";

	/*
	 *  properties
	 */
	public static String UserName;	
	public static  String PassWord;
	public  static String WelcomePage;
	public static String LANDING_PAGE_VERIFIER_MY_HEALTH_RECORD;
	public static String HOME_PAGE_VERIFIER_TEXT;
	public static String ADVANCE_CARE_DOCUMENT_VERIFIER_TEXT;
	public static String MEDICARE_OVERVIEW_VERIFIER_TEXT;
	public static String PERSONAL_HEALTH_SUMMARY_VERIFIER_TEXT;
	public static String DIAGNOSTIC_IMAGING_REPORTS_VERIFIER_TEXT;
	public static String PATHOLOGY_REPORTS_VERIFIER_TEXT;
	public static String SHARED_HEALTH_SUMMARY_VERIFIER_TEXT;
	public static String PROFILE_VERIFIER_TEXT;

	public static String MYGOV_LOGIN_QUESTIONTEXT_VERIFIER;
	public static String sq5;
	public static String sq4;
	public static String sq3;
	public static String sq2;
	public static String sq1;
	public static String sa5;
	public static String sa4;
	public static String sa3;
	public static String sa2;
	public static String sa1;
	
	
	public static String IMMUNISATIONS_VERIFY_TEXT;
	public static String DOCUMENTVERIFY_TEXT;
	public static String DISCHARGE_SUMMARY_VERIFIER_TEXT;
	public static String EREFERRAL_VERIFY_TEXT;
	public static String SPECIALIST_LETTERS_VERIFY_TEXT;
	public static String EVENT_SUMMARY_VERIFIER_TEXT;
	public static String VIEW_ADVANCECARE_PLANNING_OVERVIEWTEXT_VERIFIER;
	public static String PRESCTIPTION_DISPENSE_RECORD_TEXT_VERIFIER;
	public static String PERSONAL_HEALTH_NOTE_VERIFIER_TEXT;
	public static String ACHIVEMENT_DAIRY_PAGE_TEXT_VERIFY;
	public static String GROWTHCHART_PAGE_TEXT_VERIFY;
	public static String HEALTHCHECK_ASSESSMENT_PAGE_TEXT_VERIFIER;
	public static String INFORMATION_FOR_PARENT_PAGE_TEXT_VERIFIER;
	public static String NOTIFICATION_SETTINGS_VERIFIER_TEXT;
	
	public static String NCP_READ_ONLY;
	public static String Perform_login;
	public static String Perform_landing;
	public static String Perform_medicareOverview;
	public static String Perform_personalHealthSummary;
	public static String Perform_personalHealthNotes;
	public static String Perform_pathology;
	public static String Perform_sharedHealthSummary;
	public static String Perform_diagnostic;
	public static String Perform_demographics;
	public static String Perform_notificationSettings;
	public static String Perform_logout;
	public static String Perform_myGovLogin;
	public static String Perform_myGovAuthentication;
	public static String Perform_myGovHomePage;
	public static String PROFILE_NAME;
	
	
	/**
	 * 
	 * generalTo
	 * thresholdTo
	 * specificTo
	 */

	static{
		try {
			loadProperties();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void loadProperties() throws Exception{
		Decryptor decryptor=new Decryptor();
		Properties prop = new Properties();
		InputStream proFile = null;

		try {
			proFile = new FileInputStream(configPropPath);
			prop.load(proFile);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (proFile != null) {
				try {
					proFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}


		/*
		 * NCP properties
		 */
		
		
		UserName=decryptor.desCipher(prop.getProperty("UserName"));
		PassWord=decryptor.desCipher(prop.getProperty("PassWord"));
	    LANDING_PAGE_VERIFIER_MY_HEALTH_RECORD=decryptor.desCipher(prop.getProperty("LANDING_PAGE_VERIFIER_MY_HEALTH_RECORD"));
		HOME_PAGE_VERIFIER_TEXT=decryptor.desCipher(prop.getProperty("HOME_PAGE_VERIFIER_TEXT"));
		MEDICARE_OVERVIEW_VERIFIER_TEXT=decryptor.desCipher(prop.getProperty("MEDICARE_OVERVIEW_VERIFIER_TEXT"));
		ADVANCE_CARE_DOCUMENT_VERIFIER_TEXT=decryptor.desCipher(prop.getProperty("ADVANCE_CARE_DOCUMENT_VERIFIER_TEXT"));
		PERSONAL_HEALTH_SUMMARY_VERIFIER_TEXT=decryptor.desCipher(prop.getProperty("PERSONAL_HEALTH_SUMMARY_VERIFIER_TEXT"));
		DIAGNOSTIC_IMAGING_REPORTS_VERIFIER_TEXT=decryptor.desCipher(prop.getProperty("DIAGNOSTIC_IMAGING_REPORTS_VERIFIER_TEXT"));
		PATHOLOGY_REPORTS_VERIFIER_TEXT=decryptor.desCipher(prop.getProperty("PATHOLOGY_REPORTS_VERIFIER_TEXT"));
		SHARED_HEALTH_SUMMARY_VERIFIER_TEXT=decryptor.desCipher(prop.getProperty("SHARED_HEALTH_SUMMARY_VERIFIER_TEXT"));
		PROFILE_VERIFIER_TEXT=decryptor.desCipher(prop.getProperty("PROFILE_VERIFIER_TEXT"));
		
		sq5=decryptor.desCipher(prop.getProperty("SQ5"));
		sq4=decryptor.desCipher(prop.getProperty("SQ4"));
		sq3=decryptor.desCipher(prop.getProperty("SQ3"));
		sq2=decryptor.desCipher(prop.getProperty("SQ2"));
		sq1=decryptor.desCipher(prop.getProperty("SQ1"));

		sa5=decryptor.desCipher(prop.getProperty("SA5"));
		sa4=decryptor.desCipher(prop.getProperty("SA4"));
		sa3=decryptor.desCipher(prop.getProperty("SA3"));
		sa2=decryptor.desCipher(prop.getProperty("SA2"));
		sa1=decryptor.desCipher(prop.getProperty("SA1"));
		
		MYGOV_LOGIN_QUESTIONTEXT_VERIFIER=decryptor.desCipher(prop.getProperty("MYGOV_LOGIN_QUESTIONTEXT_VERIFIER"));
		PERSONAL_HEALTH_NOTE_VERIFIER_TEXT=decryptor.desCipher(prop.getProperty("PERSONAL_HEALTH_NOTE_VERIFIER_TEXT"));
		NOTIFICATION_SETTINGS_VERIFIER_TEXT=decryptor.desCipher(prop.getProperty("NOTIFICATION_SETTINGS_VERIFIER_TEXT"));
		PROFILE_NAME=decryptor.desCipher(prop.getProperty("PROFILE_NAME"));
		NCP_READ_ONLY=prop.getProperty("NCP_READ_ONLY");
		
		
		Perform_login=prop.getProperty("Perform_login");
		Perform_landing=prop.getProperty("Perform_landing");
		Perform_myGovLogin=prop.getProperty("Perform_myGovLogin");
		Perform_myGovHomePage=prop.getProperty("Perform_myGovHomePage");
		Perform_myGovAuthentication=prop.getProperty("Perform_myGovAuthentication");
		Perform_personalHealthSummary=prop.getProperty("Perform_personalHealthSummary");
		Perform_medicareOverview=prop.getProperty("Perform_medicareOverview");
		Perform_personalHealthNotes=prop.getProperty("Perform_personalHealthNotes");
		Perform_pathology=prop.getProperty("Perform_pathology");
		Perform_sharedHealthSummary=prop.getProperty("Perform_sharedHealthSummary");
		Perform_diagnostic=prop.getProperty("Perform_diagnostic");
		Perform_notificationSettings=prop.getProperty("Perform_notificationSettings");
		Perform_demographics=prop.getProperty("Perform_demographics");
		Perform_logout=prop.getProperty("Perform_logout");
	}
}



