package com.lib.maskpassword;

import java.io.IOException;

public class mask {
	
	public static final String  maskPassword(){
		 // Method to Mask Password Input with '*'
	   
	        StringBuilder password = new StringBuilder();
	        try {
	            while (true) {
	                char c = (char) System.in.read();
	                if (c == '\n' || c == '\r') // Stop on Enter key
	                    break;
	                password.append(c);
	                System.out.print("*"); // Show '*' instead of actual character
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return password.toString();
	    }
		
	}


