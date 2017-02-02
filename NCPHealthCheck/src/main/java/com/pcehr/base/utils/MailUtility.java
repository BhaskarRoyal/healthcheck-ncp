package com.pcehr.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.pcehr.ao.global.constants.HealthCheckConstants;



public class MailUtility {
	
	public static Logger logger=Logger.getLogger("BrowserFactory");
	
	public static void mailStatus(HashMap<String,Object> healthChkStatus) {
		
		InputStream instream = null;
		Properties threasholdProperties = new Properties();
		MailNotification mailNotification = new MailNotification();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		try {
			//ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			instream = new FileInputStream(HealthCheckConstants.THRESHOLD_PROP_FILE);
			
			//instream =classloader.getResourceAsStream(HealthCheckConstants.THRESHOLD_PROP_FILE);
			threasholdProperties.load(instream);
			
			 String stTime= threasholdProperties.getProperty("TH_START_TIME");	
			 int failCount = Integer.parseInt(threasholdProperties.getProperty("TH_FAIL_COUNT"));
			  int totalCount = Integer.parseInt(threasholdProperties.getProperty("TH_TOTAL_COUNT"));
			  int threashold = Integer.parseInt(threasholdProperties.getProperty("TH_THRESHOLD"));
			  
			  java.util.Date datStTime = null;
			  java.util.Date datNextStTime = null;
			  
			  java.util.Date currTime  = new Date((new GregorianCalendar()).getTimeInMillis());
			  
			  if(stTime==null || stTime.length() == 0){
				  datStTime = new Date(currTime.getTime());
			  }else{
				
				  datStTime= formatter.parse(stTime);
			  }
			  
			  Calendar cal = Calendar.getInstance();
			  cal.setTime(datStTime);
			  cal.add(Calendar.HOUR,1);
			  datNextStTime = cal.getTime();  
			  
	
			  if(currTime.equals(datNextStTime)||currTime.after(datNextStTime)){
			  if(failCount>0){
				  logger.info("calculate failpercentage.....");
				  int failePercentage = (failCount*100)/totalCount;
				  logger.info("fail Percentage....."+failePercentage);
				  if(failePercentage>=threashold){
					  logger.info("Send thresh mail notification");
					  mailNotification.sendMail((String)healthChkStatus.get(HealthCheckConstants.MESSAGE), (Boolean)healthChkStatus.get(HealthCheckConstants.STATUS), HealthCheckConstants.THRESHOLD_EMAIL_TYPE);
				  }else{
					  sendMail(healthChkStatus);
				  }
				 }else{
					 sendMail(healthChkStatus);
				 }
			  
				  
				  stTime = formatter.format(datNextStTime);
				  logger.info("stTime..."+stTime);
				  failCount= 0;
				  totalCount=0;
			  }else{
				   sendMail(healthChkStatus);
				  //If failed
				  if(!((boolean)healthChkStatus.get(HealthCheckConstants.STATUS))){
					  failCount++;
				  }
				  totalCount++;
			  }	  
			  threasholdProperties.setProperty("TH_START_TIME", stTime);
			  threasholdProperties.setProperty("TH_FAIL_COUNT", Integer.toString(failCount));
			  threasholdProperties.setProperty("TH_TOTAL_COUNT", Integer.toString(totalCount));
			  threasholdProperties.store(new FileOutputStream(new File(HealthCheckConstants.THRESHOLD_PROP_FILE)),"");	  
			  logger.info("Leaving thresholmail");
		} catch (FileNotFoundException e) {
			logger.fatal("Exception occured",e);
		} catch (IOException e) {
			logger.fatal("Exception occured",e);
		} catch (ParseException e) {
			logger.fatal("Exception occured",e);
		}finally{
			try {
				if(instream!=null)
				instream.close();
			} catch (IOException e) {
				logger.fatal("Exception occured",e);
			
			}
		}
		
	}

	  /**
	   * This method sends an email specific email id if the health check fails consecutively for 3 times otherwise to normal email id.
	   * @param mailNotification
	   * @throws FileNotFoundException
	   * @throws IOException
	   */
	  private static void sendMail(HashMap<String,Object> healthChkStatus) throws FileNotFoundException, IOException {
		  logger.info("Entered into the sendMail");
		  InputStream instream = null;
		  Properties propFail = new Properties();
		  boolean result = (boolean)healthChkStatus.get(HealthCheckConstants.STATUS);
		  MailNotification mailNotification = new MailNotification();
		  try{
				ClassLoader classloader = Thread.currentThread().getContextClassLoader();
				instream =classloader.getResourceAsStream(HealthCheckConstants.FAIL_PROP_FILE);
			    propFail.load(new FileInputStream(HealthCheckConstants.FAIL_PROP_FILE));
			    if(!result){
				  
					 int FailUpdate = Integer.parseInt(propFail.getProperty("FailCount"))+1;
					 propFail.setProperty("FailCount",Integer.toString(FailUpdate));	
					 logger.fatal("FailUpdate"+FailUpdate);
					 // propFail.store(new FileOutputStream(new File(failFile)),"");			 
					 if(Integer.parseInt(propFail.getProperty("FailCount"))% Integer.parseInt(propFail.getProperty("FailMax"))==0 && Integer.parseInt(propFail.getProperty("FailCount"))!=0){
						 //Send notification to specific email id when fails for 3 in a row
						 mailNotification.sendMail((String)healthChkStatus.get(HealthCheckConstants.MESSAGE),(Boolean)healthChkStatus.get(HealthCheckConstants.STATUS),HealthCheckConstants.SPECIFIC_EMAIL_TYPE);
					 }else{
						 //Send notification to normal email id when fails
						 mailNotification.sendMail((String)healthChkStatus.get(HealthCheckConstants.MESSAGE),(Boolean)healthChkStatus.get(HealthCheckConstants.STATUS),HealthCheckConstants.NORMAL_EMAIL_TYPE);
					 }			
					 propFail.store(new FileOutputStream(new File(HealthCheckConstants.FAIL_PROP_FILE)),"");
				 }else{
					 mailNotification.sendMail((String)healthChkStatus.get(HealthCheckConstants.MESSAGE),(Boolean)healthChkStatus.get(HealthCheckConstants.STATUS),HealthCheckConstants.NORMAL_EMAIL_TYPE);
					 //Reseting the FailCount to zero when result is success
					 propFail.setProperty("FailCount",HealthCheckConstants.RESET_FAIL_COUNT);
					 propFail.store(new FileOutputStream(new File(HealthCheckConstants.FAIL_PROP_FILE)),"");
				 }
				 logger.info("Leaving the sendMail");
		  }catch(Exception e){
			  logger.fatal("Exception occured",e);
		  }finally{
				try {
					if(instream!=null)
					instream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.fatal("Exception occured",e);
				}
			}
			 
	  }
}
