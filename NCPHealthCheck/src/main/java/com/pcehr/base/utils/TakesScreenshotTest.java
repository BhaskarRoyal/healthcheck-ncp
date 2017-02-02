package com.pcehr.base.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author pavan.kumar.as
 *
 */
public class TakesScreenshotTest {	
	static Logger logger = Logger.getLogger("TakesScreenshotTest");
	
	public static void takeScreenShot() {		
		logger.info("Entered into the takeScreenShot");
		try{
			WebDriver driver = BrowserFactory.loadUrl();
			Decryptor decryptor = new Decryptor();
			Properties prop=new Properties();
			if(null!=driver.getCurrentUrl()){
				driver.getCurrentUrl();
				File scourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
				java.util.Date date= new java.util.Date();
				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH-mm-SS");
				String formattedDate = sdf.format(date);
				File file = new File(LoadCommonProperties.SCREEN_SHOT_PATH+"Screenshot_"+formattedDate+".jpg");
				logger.info("Path"+file.getAbsolutePath());
				FileUtils.copyFile(scourceFile,file );
			}else{
				logger.info("URL to capture the screenshot is empty.");
			}
		  }catch(Exception e){
			logger.error("Exception Occured at TakesScreenshotTest method::",e);
		}	    
	    logger.info("Leaving takeScreenShot");
	}
	
	
	
}
