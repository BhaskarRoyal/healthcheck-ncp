/**
 * 
 */
package com.pcehr.base.utils;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

/**
 * @author bhaskara.vallapu
 *
 */
public  class BrowserFactory {
	  static Logger logger=Logger.getLogger("BrowserFactory");
	  public  static WebDriver driver;
	  
	  private BrowserFactory (){
		  
	  }
	  
	  
	/**
	 * This method creates a fire fox profile and loads the base url of consumer portal.
	 * @return 
	 * @throws CustomException 
	 * @throws Exception 
	 */
	  
	  public static  WebDriver loadUrl() throws CustomException{
		  try{
			  if(driver==null){
			  logger.info("Enterd into the loadUrl");
		      String proxyIP =LoadCommonProperties.PROXY_HTTP;
			  logger.info("proxyIP....."+ proxyIP);
			  String proxyPort = LoadCommonProperties.PROXY_PORT;
			  logger.info("proxyPort...."+ proxyPort);
		  
			  FirefoxProfile profile = new ProfilesIni().getProfile(NCPLoadEnvironmentProperties.PROFILE_NAME);	 
			  FirefoxBinary b = new FirefoxBinary ();
			  profile.setPreference("network.http.prompt-temp-redirect",false);		  
			  profile.setEnableNativeEvents(false);		  
			  profile.setAcceptUntrustedCertificates(true);
			 
			  if(proxyIP.length()>0 && proxyPort.length()>0){
				  logger.info("Firefox manual proxy settings....start");	
				  profile.setPreference("network.proxy.type", 1);		
				  profile.setPreference("network.proxy.http", proxyIP);
				  profile.setPreference("network.proxy.ftp", proxyIP);
				  profile.setPreference("network.proxy.socks",proxyIP);  
				  profile.setPreference("network.proxy.ssl",proxyIP); 
				  profile.setPreference("network.proxy.http_port",Integer.parseInt(proxyPort));
				  profile.setPreference("network.proxy.ftp_port",Integer.parseInt(proxyPort));
				  profile.setPreference("network.proxy.socks_port",Integer.parseInt(proxyPort));  
				  profile.setPreference("network.proxy.ssl_port",Integer.parseInt(proxyPort));		  
				  logger.info("Firefox manual proxy settings....end");
			  }	  
			  else{
				  logger.info("FF manual proxy has NOT set");
			  }
			  driver = new FirefoxDriver(b,profile);	 
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
			  logger.info("maximizes the ff browser");
			  
			  driver.get(LoadCommonProperties.URL);
			  logger.info("Leaving the loadurl");
			  }else{
				  return driver;
			  }
			  
		  }catch(Exception e){
			  logger.error("Exception Occured-",e);
			  throw new CustomException("Exception occured at loadUrl method, please look into the logs");
		  }
		return driver;
		  
	  }
	  
	


	public static void release() {
		// TODO Auto-generated method stub
		driver.quit();
		
	//driver.close();
		
	}

}
