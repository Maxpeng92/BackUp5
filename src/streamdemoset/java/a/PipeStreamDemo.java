package streamdemoset.java.a;

import java.io.*;

class Sender extends Thread
{
	private PipedOutputStream out = new PipedOutputStream();
	public PipedOutputStream getOutputStream()
	{
		return out;
	}
	public void run()
	{
		String s = new String("Receiver, Hello!");
		try
		{
			out.write(s.getBytes());
			out.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}

class Receiver extends Thread
{
	private PipedInputStream in = new PipedInputStream();
	public PipedInputStream getIuputStream()
	{
		return in;
	}
	public void run()
	{
		String s = null;
		byte buff[] = new byte[1024];
		try
		{
			int len = in.read(buff);
			s = new String(buff,0,len);
			System.out.println("Message received: "+s);
			in.close();
		}
		catch(IOException e1)
		{
			System.out.println(e1.getMessage());
		}
	}

}
public class PipeStreamDemo {

	public static void main(String[] args) {
		try
		{
			Sender sender = new Sender();
			Receiver receiver = new Receiver();
			PipedOutputStream out = sender.getOutputStream();
			PipedInputStream in = receiver.getIuputStream();
			out.connect(in);
			sender.start();
			receiver.start();
		}
		catch(IOException e2)
		{
			System.out.println(e2.getMessage());
		}
	}

}
