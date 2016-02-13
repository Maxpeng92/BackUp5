package streamdemoset.java.a;

import java.io.*;
public class StreamDemo {

	public static void main(String[] args) {
		File f = new File("/Users/houomoiyuan/Documents/1.txt");
		OutputStream out = null;
		try 
		{
			out = new FileOutputStream(f);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		byte b[] = "Hello World!".getBytes();
		try
		{
			out.write(b);
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		try
		{
			out.close();
		}
		catch(IOException e2)
		{
			e2.printStackTrace();
		}
		
		InputStream in = null;
		try
		{
			in = new FileInputStream(f);
		}
		catch(FileNotFoundException e3)
		{
			e3.printStackTrace();
		}
		byte b1[] = new byte[1024];
		int i = 0;
		try
		{
			i = in.read(b1);
		}
		catch(IOException e4)
		{
			e4.printStackTrace();
		}
		try
		{
			in.close();
		}
		catch(IOException e5)
		{
			e5.printStackTrace();
		}
		System.out.println(new String(b1,0,i));

	}

}
