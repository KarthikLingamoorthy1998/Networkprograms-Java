/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import java.io.*;
import java.net.*;
public class TCPserver
{
	public static void main(String [] args) throws IOException
	{
		try
		{
			ServerSocket ss = new ServerSocket(9000);
			Socket s = ss.accept();
			InetAddress I = InetAddress.getByName("localhost");
			File f = new File("/Users/lallu/Desktop/C.txt");
			FileInputStream fi = new FileInputStream(f);
			BufferedInputStream b = new BufferedInputStream(fi);
			OutputStream o = s.getOutputStream();
			long current = 0;
			long start = System.nanoTime();
                        long fileLength = f.length();
			while(current!=fileLength)
			{
				int size = 10000;
				if((fileLength-current)>=size)
				{
					current+=size;
				}
				else
				{
					size=(int)(fileLength-current);
					current=fileLength;
				}
				byte[] contents = new byte[size];
				b.read(contents,0,size);
				o.write(contents);
				System.out.println("Sending file ... " + current *100/fileLength + "% complete !");
			}
			o.flush();
			s.close();
			ss.close();
			System.out.println("File sent succesfully");
		}
		catch(Exception e)
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
}