package com.pcehr.ao.selenium.ncp.verifiers;

import org.apache.log4j.Logger;

import com.pcehr.ao.global.constants.HealthCheckConstants;
import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.ao.global.verifiers.Verifier;
import com.pcehr.base.utils.BrowserFactory;
import com.pcehr.base.utils.CustomException;
import com.pcehr.base.utils.NCPLoadEnvironmentProperties;
import com.pcehr.base.utils.TakesScreenshotTest;
import com.pcehr.base.utils.UtilityMethods;
import com.pcher.ao.selenium.ncp.pageobjects.NotificationSettingsPageObject;

public class NotificationSettingsPageVerifier extends NotificationSettingsPageObject implements Verifier {
	Logger logger=Logger.getLogger("NotificationSettingsPageVerifier");
	@Override
	public boolean verify(String action) throws HealthCheckException, CustomException, Exception {
		try {
			logger.info("Enter into the NotificationSettingsPageVerifier method");
			UtilityMethods.awaitForPageToLoad(notificationSettingsTextverify, BrowserFactory.loadUrl());
			String vnotificationSettingsTextverify=notificationSettingsTextverify.getText();
			if (vnotificationSettingsTextverify.equals(NCPLoadEnvironmentProperties.NOTIFICATION_SETTINGS_VERIFIER_TEXT)){
				logger.info("NotificationSettingsPageVerifier Verifier --Success");
				return true;
			}
			else{
			logger.fatal("NotificationSettingsPageVerifier Verifier -- Failed");
			TakesScreenshotTest.takeScreenShot();
			throw new HealthCheckException(HealthCheckConstants.NOTIFICATION_SETTINGS_FAILED);
		}	
	}catch(HealthCheckException e){
		throw e;
	}catch(Exception e){
		logger.fatal("NotificationSettingsPage page verification failed.Aborting",e);
		throw new HealthCheckException(HealthCheckConstants.NOTIFICATION_SETTINGS_FAILED,e);
	}
		
	}
}