package com.pcehr.base.utils;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

public class Decryptor {

	/**
	 * @param args
	 */
	Logger logger = Logger.getLogger("Decryptor");	
	private final static String ALGORITHM = "DES";	    
    private final static String secretKey = "01234567";	
    
    /**
     * This method decrypts the encrypted text 
     * @param encrytedText
     * @return
     * @throws Exception
     */
	public String desCipher(String encrytedText) throws Exception{
		//logger.info("Entered into the decryptor");
		byte[] decryResult = null;
	
		try{
			if(secretKey==null || secretKey.length()!=8){
				throw new Exception("secretkey length should be 8");
			}
			
			SecretKey key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
			//logger.info("key...."+key);
			
			Cipher cipher = Cipher.getInstance(ALGORITHM);
	        cipher.init(Cipher.DECRYPT_MODE, key);	        
	        decryResult = (cipher.doFinal(toByte(encrytedText)));	      
	        
		}catch(Exception e){
			logger.info("Exception occured ",e);
			//throw new MyException("Exception occured at the desCiper method, please look into the log files");
			throw e;
		}
		//logger.info("leaving decryptor");
		return new String(decryResult);
		 
	}
	
	private static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];

        for (int i = 0; i < len; i++) {
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();      
            
        }
        return result;
    }

}
