package net.lotusdev.medusa.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Builder.java
 * @author Jabaar
 *
 */

public class Builder {
	public static File curDir = new File(System.getProperty("user.dir"), "config.dat");
	public static String eUser;
	public static String ePass;
	public static int timeout;
	
	public static void makeConfig() {
		try {			
			if(!curDir.exists()) {
				curDir.createNewFile();
			}			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static File getConfig() {
		return curDir;
	}
	
	public static void writeConfig() {
		try {
			/**
			 * Writes user set data to config file.
			 */
			BufferedWriter out = new BufferedWriter(new FileWriter(curDir));
			out.write("#DO NOT MODIFY THIS FILE.");
			out.write("eUser:" + getEmailUser());
			out.write("ePass:" + getEmailPass());
			out.close();
		}catch(Exception e) {
			
		}
	}
	
	public static void readConfig() {
		try {
			if(curDir.exists()) {
				BufferedReader in = new BufferedReader(new FileReader(curDir));
				String inLine; 
				for(int i = 0; (inLine = in.readLine()) != null; i++) {
					String[] parseVar = inLine.split(":");
                	if(inLine.startsWith("#"))
                		return;
                	else if(parseVar[0].startsWith("eUser"))
                		setEmailUser(parseVar[1]);
                	else if(parseVar[0].startsWith("ePass"))
                		setEmailPass(parseVar[1]);
                }
				in.close();
			}
		}catch(Exception e) {
			
		}
	}
	
	/**
	 * Getters and setters for main input and output variables.
	 */
	public static void setEmailUser(String eUser) {
		Builder.eUser = eUser;
	}
	
	public static void setEmailPass(String ePass) {
		Builder.ePass = ePass;
	}
		
	public static void setTimeout(int time) {
		/**
		 * Set the timeout to a int and multiply by 60 to get minute value.
		 */
		timeout = (time * 60);
	}
	
	public static String getEmailUser() {
		return eUser;
	}
	
	public static String getEmailPass() {
		return ePass;
	}
}
