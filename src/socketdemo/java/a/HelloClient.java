package socketdemo.java.a;

import java.io.*;
import java.net.*;
public class HelloClient {

	public static void main(String[] args) throws IOException{
	Socket hellosocket = null;
	BufferedReader in = null; 
	try
	{
		hellosocket = new Socket("localhost",9999);
		in = new BufferedReader(new InputStreamReader(hellosocket.getInputStream()));	
	}
	catch(UnknownHostException e)
	{
		System.err.println("Don't know about the local host.");
		System.exit(1);
	}
	catch (IOException e)
	{
		System.err.println("Couldn't get I/O for the connection");
		System.exit(1);
	}
	System.out.println(in.readLine());
	in.close();
	hellosocket.close();
	}

}
