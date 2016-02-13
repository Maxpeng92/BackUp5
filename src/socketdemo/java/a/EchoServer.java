package socketdemo.java.a;

import java.io.*;
import java.net.*;
public class EchoServer {

	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try
		{
			serverSocket = new ServerSocket(1111);
		}
		catch (IOException e)
		{
			System.err.println("Can not listen on port: 1111.");
			System.exit(1);
		}
		Socket incoming = null;
		while(true)
		{
			incoming = serverSocket.accept();
			out = new PrintWriter(incoming.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
			out.println("Hello!");
			out.println("Enter BYE to exit");
			out.flush();
			while(true)
			{
				String str = in.readLine();
				if (str == null)
				{
					break;
				}
				else
				{
					out.println("Echo: "+str);
					out.flush();
					if (str.trim().equalsIgnoreCase("BYE"))
						break;
				}
			}
			out.close();
			in.close();
			serverSocket.close();
		}

	}

}
