/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BroadCasting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
public class Client 
{
     public static void main(String [] args)
    {
        String hostname = "Unknown";
        try
        {
            Socket s=new Socket("14.139.182.35",3333);
            DataInputStream din=new DataInputStream(s.getInputStream());
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
            String str=(String)din.readUTF();
            System.out.println("Message recieved: "+str);
            s.close();
            din.close();
        }
        catch(Exception e)
        {
            
        }
    }
    
}
