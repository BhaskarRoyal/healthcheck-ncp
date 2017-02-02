package com.pcehr.base.utils;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.pcehr.ao.global.constants.HealthCheckConstants;




/**
 * This class handles sending email notification.
 * @author pavan.kumar.as
 *
 */
public class MailNotification {

	private static Logger logger = Logger.getLogger("MailNotification");
	/**
	 * This method sends email notification through outlook. Depending on destinationType sends email notification.
	 * destination type can be normal or specific.
	 * @param prop
	 * @param result
	 * @param destinationType
	 */	
	public void sendMail(String statusMsg,Boolean result, String destinationType){
		logger.info("I am into the sendMail");
		try {
			Properties props = new Properties();	
			props.put("mail.smtp.host",LoadCommonProperties.HOST);
			props.put("mail.smtp.port",LoadCommonProperties.PORT);	
			Session session = Session.getInstance(props); 
			logger.fatal("LoadCommonProperties.HOST"+LoadCommonProperties.HOST);
			logger.fatal("LoadCommonProperties.PORT"+LoadCommonProperties.PORT);
			String dest;
			String subject=null;
			String body="";

			if(destinationType.contentEquals(HealthCheckConstants.NORMAL_EMAIL_TYPE)){
				dest = LoadCommonProperties.GENERAL_TO;
			}else if(destinationType.contentEquals(HealthCheckConstants.THRESHOLD_EMAIL_TYPE)){
				dest = LoadCommonProperties.THRESHOLD_TO;
			}else{
				dest=LoadCommonProperties.SPECIFIC_TO;
			}		


			if(!destinationType.contentEquals(HealthCheckConstants.THRESHOLD_EMAIL_TYPE)) {				  
				if(result){
					subject=LoadCommonProperties.SUCCESS_SUBJECT;				  
					}else{
						subject=LoadCommonProperties.FAILURE_SUBJECT;
					}					  
				body = body.concat(statusMsg+"\n\n");		

			} else{
				subject = LoadCommonProperties.THREASHOLD_MAIL_SUBJECT;
				body =LoadCommonProperties.THREASHOLD_MAIL_BODY;
			}

			logger.info(LoadCommonProperties.HEALTH_CHECK_SUBJECT+"\t"+subject);
			logger.info(LoadCommonProperties.HEALTH_CHECK_BODY+"\t"+body);

			//Close the input stream

			//send email using SMTP  
			Message message = new MimeMessage(session);		
			message.setFrom(new InternetAddress(LoadCommonProperties.FROM));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(dest));
			message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(LoadCommonProperties.CC));
			message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse(LoadCommonProperties.BCC));
			message.setSubject(subject);
			message.setText(body);			
			Transport.send(message); 
			logger.info("Email sent successfully"); 

		} catch (MessagingException e) {
			logger.fatal("MessagingException-",e);
		}  catch(Exception e){
			logger.fatal("Excepiton-",e);
		}
	}
	
	
}
