package socketdemo.java.a;

import java.io.*;
import java.net.*;

public class UdpSend {

	public static void main(String[] args) {
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		try
		{
			ds = new DatagramSocket(3000);
		}
		catch(SocketException ex)
		{		}
		String str = "hello world!";
		try
		{
			dp = new DatagramPacket(str.getBytes(),str.length(), InetAddress.getByName("localhost"), 9000);
		}
		catch(Exception e1){}
		try
		{
			ds.send(dp);
		}
		catch(IOException ei){}
		ds.close();
	}

}
