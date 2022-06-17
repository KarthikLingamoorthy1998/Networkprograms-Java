/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.io.*;
import java.net.*;
import java.util.*;
public class UDPserver
{
	public static void main(String [] args) throws IOException
	{
		try
		{
			int i=0;
			byte[] b = new byte [1024];
                        DatagramSocket ds = new DatagramSocket();
                        System.out.println("UDP file sender");
                        File f = new File ("cnlab.txt");
                        FileInputStream fi = new FileInputStream(f);
                        InetAddress in = InetAddress.getLocalHost();
                        while(fi.available()!=0)
                        {
                            b[i]=(byte)fi.read();
                            i++;
                        }
                        fi.close();
                        DatagramPacket dp = new DatagramPacket(b, i, in, 1000);
                        ds.send(dp);
                        System.out.println("The file is sent successfully");
                }
                catch(Exception e)
                {
                    System.out.println("Error : "+e.getMessage());
                }
        }
}