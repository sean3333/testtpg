package com.sean.testtpg.q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * question 1: regular expression to validate input IP addresses
 * @author sean
 *
 */
public class IPValidationRegex {
	
	public static void main(String[] args) throws IOException{
		
		System.out.print("Please enter the filename: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
		String filename = "";
		filename=br.readLine();
		
		IPValidationRegex ipValid = new IPValidationRegex();
		
		for(String errorIp: ipValid.filterInvalidIP(filename)){
			System.out.println(errorIp);
		}
	}

	// regular expression string for IP addresses validation
	// Leading zeros are allowed, eg. 000, 010
	private final String validStr = "(^\\d|\\d{2}|[0-1]\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|\\d{2}|[0-1]\\d{2}|2[0-4]\\d|25[0-5])){3}$";

	/**
	 * validate a single ip address
	 * 
	 * @param ipAddress
	 * @return
	 */
	public boolean isIPValid(String ipAddress) {

		if (ipAddress == null) {
			return false;
		}

		// remove leading and tailing whitespace
		String ipAddr = ipAddress.trim();
		if (ipAddr.equals("") || ipAddr.length() > 15) {
			return false;
		}

		Pattern pattern = Pattern.compile(validStr);
		Matcher matcher = pattern.matcher(ipAddr);

		return matcher.find();
	}

	/**
	 * input: filename
	 * output: invalid ip from the file
	 * @param filename
	 * @return
	 */
	public List<String> filterInvalidIP(String filename) {
		List<String> results = new ArrayList<String>();

		BufferedReader br = null;

		try {

			br = new BufferedReader(new FileReader(filename));

			String line = "";

			while ((line = br.readLine()) != null) {

				// filter out any invalid IP address
				if (!isIPValid(line)) {
					results.add(line);					
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("can not read the file: " + filename 
					+ " with errors: \n" + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				br = null;
			}
		}

		return results;
	}

}
