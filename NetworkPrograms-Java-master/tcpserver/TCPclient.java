package tcpserver;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class TCPclient
{
	public static void main(String [] args)
	{
		try
		{
                        Socket s1=new Socket(InetAddress.getLocalHost(),9000);
			//sSocket s = new Socket(InetAddress.getByAddress("localhost",9000));
			byte[] contents = new byte[10000];
			FileOutputStream f = new FileOutputStream("/Users/lallu/Desktop/C.txt");
			BufferedOutputStream b =new BufferedOutputStream(f);
                        InputStream i = s1.getInputStream();
                        FileInputStream fi = new FileInputStream("/Users/lallu/Desktop/C.txt");
                        String c="";
                        int a;
                        while((a=fi.read())!=-1)
                        {
                            c+=(char)a;
      
                        }
                        System.out.println(c);
                        Scanner input = new Scanner(new File("/Users/lallu/Desktop/C.txt"));

                        while (input.hasNextLine())
                            {
                            System.out.println(input.nextLine());
                        }
			int bytesread;
			while((bytesread=i.read(contents))!=-1)
			{
				b.write(contents,0,bytesread);
			}
			b.flush();
			s1.close();
			System.out.println("File saved successfully");
		}
		catch(Exception e)
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
}