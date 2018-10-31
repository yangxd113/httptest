package com.my.test.httptest;

import java.security.MessageDigest;

public class getToken {
	public static void main(String[] args) {
        String ss="APP_IDGSLTTIMESTAMP2018-10-31 16:06:06 100TRANS_ID20181031160606100335423";   
        String token2=getToken2(ss);
        System.out.println("md5只后："+token2);  
	}

	public static String getToken2(String data) {
		 String key = "2upSooFphWPSdsm8a6eIQY9Ino27rgyc";
		String resultString = data+key ;
		String result="";
		try {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update((resultString).getBytes("UTF-8"));
		byte b[] = md5.digest();
		 
		int i;
		StringBuffer buf = new StringBuffer("");
		 
		for(int offset=0; offset<b.length; offset++){
			i = b[offset];
			if(i<0){
				i+=256;
			}
			if(i<16){
				buf.append("0");
			}
			buf.append(Integer.toHexString(i));
		}
		
		 result = buf.toString();
		System.out.println("result = " + result);
		} catch (Exception exception) {
		}
		return result;
	}

}
