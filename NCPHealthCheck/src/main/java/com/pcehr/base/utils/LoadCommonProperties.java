/**
 * 
 */
package com.pcehr.base.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author bhaskara.vallapu
 *
 */
public class LoadCommonProperties {
	
	Logger logger=Logger.getLogger("LoadCommonProperties");
	/**
	 * @author bhaskara.vallapu
	 * This class wil loads the common propeties 
	 */

	public static final String configPropPath="./properties/config.properties";

	/*
	 * common properties
	 */
	public static String URL;
	public static String PROXY_HTTP;
	public  static String PROXY_PORT;
	public static String HOST;
	public static String PORT;
	public static String SUCCESS_SUBJECT;
	public static String FAILURE_SUBJECT;
	public static String THREASHOLD_MAIL_SUBJECT;
	public static String THREASHOLD_MAIL_BODY;
	public static String TO;
	public static String FROM;
	public static String CC;
	public static String BCC;
	public static String GENERAL_TO;
	public static String THRESHOLD_TO;
	public static String SPECIFIC_TO;
	public static String LOG_FILE_PATH="Result_Logs/";
	public static String SCREEN_SHOT_PATH;
	public static String HEALTH_CHECK_SUBJECT;
	public static String HEALTH_CHECK_BODY;
	
	public static String  OEMAgentTempPath;
	
	public static String FLAG;
	
	/**
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

		
		URL=decryptor.desCipher(prop.getProperty("URL"));
		PROXY_HTTP=decryptor.desCipher(prop.getProperty("PROXY_HTTP"));
		PROXY_PORT=decryptor.desCipher(prop.getProperty("PROXY_PORT"));
		SCREEN_SHOT_PATH=decryptor.desCipher(prop.getProperty("SCREEN_SHOT_PATH"));
		FROM=decryptor.desCipher(prop.getProperty("FROM"));
		HOST=decryptor.desCipher(prop.getProperty("HOST"));
		PORT=decryptor.desCipher(prop.getProperty("PORT"));

		SUCCESS_SUBJECT=decryptor.desCipher(prop.getProperty("SUCCESS_SUBJECT"));
		THREASHOLD_MAIL_SUBJECT=decryptor.desCipher(prop.getProperty("THREASHOLD_MAIL_SUBJECT"));
		FAILURE_SUBJECT=decryptor.desCipher(prop.getProperty("FAILURE_SUBJECT"));
		THREASHOLD_MAIL_BODY=decryptor.desCipher(prop.getProperty("THREASHOLD_MAIL_BODY"));
		CC=decryptor.desCipher(prop.getProperty("CC"));
		BCC=decryptor.desCipher(prop.getProperty("BCC"));
		GENERAL_TO=decryptor.desCipher(prop.getProperty("GENERAL_TO"));
		THRESHOLD_TO=decryptor.desCipher(prop.getProperty("THRESHOLD_TO"));
		SPECIFIC_TO=decryptor.desCipher(prop.getProperty("SPECIFIC_TO"));
		
		HEALTH_CHECK_SUBJECT=decryptor.desCipher(prop.getProperty("HEALTH_CHECK_SUBJECT"));
		HEALTH_CHECK_BODY=decryptor.desCipher(prop.getProperty("HEALTH_CHECK_BODY"));
		
		OEMAgentTempPath=decryptor.desCipher(prop.getProperty("OEMAgentTempPath"));
       
	}
}



