/**
 * 
 */
package com.pcehr.base.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pcehr.ao.global.constants.HealthCheckConstants;

/**
 * @author bhaskara.vallapu
 * This class defines the set of methods, that peform common and often-reused functions.
 */
public class UtilityMethods {
	public static Logger logger=Logger.getLogger("BrowserUtilityMethods");
	private final static int  PAGELOAD_MAX_TIMEOUT =60;
	
	

	

	public static void awaitForPageToLoad(WebElement waitForElement, WebDriver driver)
			throws Exception {

		waitForElement = new WebDriverWait(driver, PAGELOAD_MAX_TIMEOUT)
		.until(ExpectedConditions.visibilityOf(waitForElement));
	}

	public static void clickElement (WebElement elementToClick, WebDriver driver) throws Exception
	{
		
		awaitForPageToLoad(elementToClick, driver);
		elementToClick.isEnabled();
		elementToClick.click();

	}
	
	public static void clickElementAndClear (WebElement elementToClick, WebDriver driver) throws Exception
	{
		
		awaitForPageToLoad(elementToClick, driver);
		elementToClick.isEnabled();
		elementToClick.click();
		elementToClick.clear();

	}
	
	//Deletes a file, never throwing an exception. If file is a directory, delete it and all sub-directories. 
	public static void deleteTempFile(){
		try {
			 FileUtils.deleteQuietly(new File(LoadCommonProperties.OEMAgentTempPath));
		} catch (Exception e) {
			logger.fatal("Exception Occured",e);
		} 
			
		
	}
	
	
	
    public static void enterValueToTextBox(WebElement txtBox,String value,WebDriver driver) throws Exception{
    	awaitForPageToLoad(txtBox, driver);
    	txtBox.isEnabled();
    	txtBox.click();
    	txtBox.clear();
		awaitForPageToLoad(txtBox, driver);
		txtBox.sendKeys(value);
    }


    
    public static HashMap<String, Object> executionMessageStatus(LinkedHashMap<String,Boolean> message){
    
    	boolean status= true;
    	StringBuilder txtMessage = new StringBuilder();
    	
    	for(Map.Entry<String,Boolean> entry :message.entrySet()){
    		txtMessage.append(entry.getKey()).append(":").append((entry.getValue().booleanValue()==true)?"SUCCESS":"FAILED").append("\n");;
    		if(entry.getValue().booleanValue()==false){
    			status=false;
    		}
    		
    	}
    	HashMap<String, Object> healthchkStatus = new HashMap<String, Object>();
    	healthchkStatus.put(HealthCheckConstants.MESSAGE, txtMessage.toString());
    	healthchkStatus.put(HealthCheckConstants.STATUS, status);
    	logger.info("healthCheckStatus::" +healthchkStatus);
		return healthchkStatus;
    }
	
    public static void writeToFile(String fileName,String path,String message,boolean overide) throws Exception{
    	FileWriter writer = null;
    	PrintWriter output = null;
    	try{
    		File file = new File(path+fileName);
    		logger.fatal("Absalute path"+file.getAbsolutePath());
    		writer = new FileWriter(file,overide);
    	    output = new PrintWriter(writer);
    	    output.println(message);
    	}catch(Exception e){
    		
    	} finally{
    		if(output!=null)
    		output.close();
    		if(writer!=null)
    		writer.close();
    	
    	}
    }

    /**
     * This mehtod converts milli secs to proper date-time format.
     * @param milliSecs
     * @return
     */
    public static String milliSecondsToDate(long milliSecs){
  	  TimeZone tz = TimeZone.getTimeZone("Australia/Sydney"); 
        Date date = new Date(milliSecs);
        DateFormat dateFormat = new SimpleDateFormat ("dd MMM yyyy HH:mm:ss z");	        
        dateFormat.setTimeZone(tz);
        return dateFormat.format(date);       
    }
    
    
}
