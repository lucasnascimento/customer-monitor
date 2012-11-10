package br.com.citel.monitor.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class HashCodeManager {

	public String getHashWord(String senha){
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			BigInteger hash = new BigInteger(1, md.digest(senha.getBytes("UTF-8")));
			String s2 = hash.toString(16);
			return s2;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

}
