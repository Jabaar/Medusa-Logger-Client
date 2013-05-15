package net.lotusdev.medusa.client;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Connection.java
 * @author Jabaar	
 *
 */

public class Connection {
	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	public static ServerSocket server;
	public static Socket connection;
	
	public static void start() {
		try {
			server = new ServerSocket(1336, 100);
			
			while(true) {
				try {
					getConnection();
					setupStreams();
					inTransfer();
				}finally {
					close();
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void close() {
		try {
			out.close();
			in.close();
			connection.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getConnection() {
		try {
			connection = server.accept();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setupStreams() {
		try {
			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();
			in = new ObjectInputStream(connection.getInputStream());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void inTransfer() {
		String msg = "";
		try {
			do {
				try {
					msg = (String)in.readObject();
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
			}while(!msg.equals("END"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void sendCommand(String command) {
		try {
			out.writeObject("cmd - " + command);
			out.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
