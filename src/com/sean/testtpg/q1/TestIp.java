/**
 *
 */
package com.sean.testtpg.q1;

import org.junit.Test;

/**
 * @author sean
 *
 */
public class TestIp {
	@Test
	public void foo_file(){
		String filename = "resource/ip.txt";
		IPValidationRegex ipValid = new IPValidationRegex();
		
		for(String errorIp: ipValid.filterInvalidIP(filename)){
			System.out.println(errorIp);
		}
	}
	
	@Test
	public void foo_valid_ip(){
		
		IPValidationRegex ipValid = new IPValidationRegex();
		
		String ip = "0.0.0.0";
		assert ipValid.isIPValid(ip) == true : "wrong";
		System.out.println("pass test: " +ip);
		
		ip = "198.168.1.10";
		assert ipValid.isIPValid(ip) == true : "wrong";
		System.out.println("pass test: " +ip);
		
		ip = "255.255.255.255";
		assert ipValid.isIPValid(ip) == true : "wrong";
		System.out.println("pass test: " +ip);
		
		ip = "000.000.000.000";
		assert ipValid.isIPValid(ip) == true : "wrong";
		System.out.println("pass test: " +ip);
	}
	
	@Test
	public void foo_invalid_ip(){
		
		IPValidationRegex ipValid = new IPValidationRegex();
		
		String ip = "a.b.c.d";
		assert ipValid.isIPValid(ip) == false : "wrong";
		System.out.println("pass test: " +ip);
		
		ip = "255.255.255.256";
		assert ipValid.isIPValid(ip) == false : "wrong";
		System.out.println("pass test: " +ip);
		
		ip = "1.1.1.1234";
		assert ipValid.isIPValid(ip) == false : "wrong";
		System.out.println("pass test: " +ip);
		
		ip = "12121212";
		assert ipValid.isIPValid(ip) == false : "wrong";
		System.out.println("pass test: " +ip);
		
		ip = ".12.12.12";
		assert ipValid.isIPValid(ip) == false : "wrong";
		System.out.println("pass test: " +ip);
	}


}
