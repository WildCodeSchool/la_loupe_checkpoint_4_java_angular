package fr.wcs.dixheures.back;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Encryption {
	static public String crypt( String p_str ) {
		 MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update( p_str.getBytes() );
			byte[] data = md.digest();
			
			StringBuffer buff = new StringBuffer();
			for (byte bytes : data) {
				buff.append(String.format("%02x", bytes & 0xff));
			}
			
			return buff.toString();

		} catch (NoSuchAlgorithmException e) {
			return "no_crypt";
		}
		 
	}
	
	static public String genApikey() {
		return Encryption.crypt("_Saussisson!" + Math.random()*42 );
	}
	
	static public String genToken() {
		return Encryption.crypt("_Jambon!" + Math.random()*420 );
	}
	
	static public String genPasswd( String p_str ) {
		return Encryption.crypt( "_Pâté!" + p_str );
	}

}
