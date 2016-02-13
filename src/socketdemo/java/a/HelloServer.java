package socketdemo.java.a;

import java.net.*;
import java.io.*;
public class HelloServer {

	public static void main(String[] args) throws IOException{
		ServerSocket serversocket = null;
		PrintWriter out = null;
		try
		{
			serversocket = new ServerSocket(9999);
		}
		catch (IOException e)
		{
			System.err.println("Can not listen on port: 9999.");
			System.exit(1);
		}
		Socket clientsocket = null;
		try
		{
			clientsocket = serversocket.accept();
		}
		catch (IOException e1)
		{
			System.err.println("Accept failed");
			System.exit(1);
		}
		out = new PrintWriter(clientsocket.getOutputStream(),true);
		out.println("hello world!");
		clientsocket.close();
		serversocket.close();
	}

}
