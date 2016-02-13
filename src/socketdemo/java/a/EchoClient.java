package socketdemo.java.a;

import java.io.*;
import java.net.*;

public class EchoClient {

	public static void main(String[] args) throws IOException{
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try
		{
			echoSocket = new Socket("localhost",1111);
			out = new PrintWriter(echoSocket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		}
		catch(UnknownHostException e)
		{
			System.err.println("Don't know about the local host.");
			System.exit(1);
		}
		catch (IOException e1)
		{
			System.err.println("Couldn't get I/O for the connection");
			System.exit(1);
		}
		System.out.println(in.readLine());
		System.out.println(in.readLine());
		BufferedReader stdln = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		
		while((userInput = stdln.readLine()) != null)
		{
			out.println(userInput);
			System.out.println(in.readLine());
		}
		out.close();
		in.close();
		echoSocket.close();
	}

}
