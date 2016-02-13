package streamdemoset.java.a;

import java.io.*;
public class DataStreamDemo {

	public static void main(String[] args) throws IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream("Order.txt"));
		double[] prices = {18.99,9.22,14.22,5.22,4.21};
		int[] units = {10,10,20,39,40};
		String[] descs = {"T-shirt","Cup","Toy","Pin","Chain"};
		for (int i=0;i<prices.length;i++)
		{
			out.writeDouble(prices[i]);
			out.writeChar('\t');
			out.writeInt(units[i]);
			out.writeChar('\t');
			out.writeChars(descs[i]);
			out.writeChar('\n');
		}
		out.close();
		
		DataInputStream in = new DataInputStream(new FileInputStream("Order.txt"));
		double price;
		int unit;
		StringBuffer desc;
		double total = 0.0;
		
		try
		{
			while(true)
			{
				price = in.readDouble();
				in.readChar();
				unit = in.readInt();
				in.readChar();
				char chr;
				desc = new StringBuffer();
				while ((chr = in.readChar()) != '\n')
				{
					desc.append(chr);
				}
				System.out.println("Order Information: "+"Product Name: "+desc+", \tNumber: "+unit+", \tPrice: "+price);
				total = total + unit * price;
			}
		}
		catch (EOFException e)
		{
			System.out.println("\nTotal price: "+total);
		}
	}

}
