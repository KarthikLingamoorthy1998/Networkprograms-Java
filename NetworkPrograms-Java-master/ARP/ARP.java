/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 *
 * @author lallu
 */
public class ARP 
{
    public static void main(String[] args) {
        try  
        {
            BufferedReader buf = new BufferedReader (new InputStreamReader(System.in));
            System.out.println("Enter the name : ");
            String str = buf.readLine();
            InetAddress in = InetAddress.getByName(str);
            System.out.println(in);
            NetworkInterface net = NetworkInterface.getByInetAddress(in);
            byte[] mac = net.getHardwareAddress();
            int i;
            if(mac!=null)
            {
                System.out.println("Mac address is :");
                for(i=0;i<mac.length;i++)
                {
                    System.out.format("%02X %s",mac[i],(i<mac.length-1)?"-":"");
                }
                System.out.println();
                
            }
            else
            {
                System.out.println("MAC address not found");
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
