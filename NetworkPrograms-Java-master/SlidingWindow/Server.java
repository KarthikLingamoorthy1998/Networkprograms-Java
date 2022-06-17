/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlidingWindow;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;
import java.io.*;
import java.rmi.*;

/**
 *
 * @author lallu
 */
public class Server 
{
    public static void main(String args[])throws Exception
    {
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        ServerSocket ss = new ServerSocket(10);
        Socket s = ss.accept();
        DataInputStream in = new DataInputStream(System.in);
        DataInputStream in1 = new DataInputStream(s.getInputStream());
        String sbuff[] = new String[8];
        PrintStream p;
        int sptr =0,sws=8,nf,ano,i;
        String ch;
        do
        {
            p=new PrintStream(s.getOutputStream());
            System.out.println("Enter the no of frames = ");
            nf = Integer.parseInt(buf.readLine());
            p.println(nf);
            if(nf<=sws-1)
            {
                System.out.println("Enter "+nf+" Message to send\n");
                for(i=0;i<=nf;i++)
                {
                    sbuff[sptr]= buf.readLine();
                    p.println(sbuff[sptr]);
                    sptr=++sptr%8;
                }
                sws=sws-nf;
                System.out.println("Acknowledgement received");
                ano=Integer.parseInt(buf.readLine());
                System.out.println("For "+ano+" frames");
                sws+=nf;
            }
            else
            {
                System.out.println("The no of frames exceeds window size \n");
                break;
            }
            System.out.println("\nDo you want to send some more frames : ");
            ch=buf.readLine();
            p.println(ch);
        }while(ch.equals("Yes"));
        s.close();
        
    }
    
}
