package socketdemo.java.a;

import java.io.*;
import java.net.*;

public class UdpReceive {

	public static void main(String[] args) {
		DatagramSocket ds = null;
		byte[] buff = new byte[1024];
		DatagramPacket dp = null;
		try
		{
			ds = new DatagramSocket(9000);
		}
		catch(SocketException ex){}
		
		dp = new DatagramPacket(buff,1024);
		try
		{
			ds.receive(dp);
		}
		catch(IOException e){}
		String str = new String(dp.getData(),0,dp.getLength())+" from "+dp.getAddress().getHostAddress()+" : "+dp.getPort();
		System.out.println(str);
		ds.close();
	}

}
