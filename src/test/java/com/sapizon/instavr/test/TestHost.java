package com.sapizon.instavr.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestHost {
	
	public static void main(String[] args ) throws IOException {
		
		String messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()+ ":8080/Users/apple/Documents/InstaVR/src/main/java/com/sapizon/instavr/reports/15_11_2017_03_33_02.html";
		System.out.println(messageBody);
	}

}
