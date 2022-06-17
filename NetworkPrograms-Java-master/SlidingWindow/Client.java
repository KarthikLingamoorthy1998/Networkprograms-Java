/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlidingWindow;

/**
 *
 * @author lallu
 */
import java.io.*;
import java.io.InputStreamReader;
import java.net.*;
public class Client 
{
    public static void main(String[] args) throws Exception 
    {
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        Socket s = new Socket(InetAddress.getLocalHost(), 10);
        DataInputStream in = new DataInputStream(s.getInputStream());
        PrintStream p = new PrintStream(s.getOutputStream());
        int i=0,rptr =-1,nf,rws=8;
        String rbuf[]=new String [8];
        String ch;
        System.out.println();
        do
        {
            nf=Integer.parseInt(buf.readLine());
            if(nf<=rws-1)
            {
                for(i=1;i<=nf;i++)
                {
                    rptr =++rptr%8;
                    rbuf[rptr]=buf.readLine();
                    System.out.println("The received frames "+rptr+ " is "+rbuf[rptr]);
                    
                }
                rws-=nf;
                System.out.println("\nAcknowledgement sent");
                p.println(rptr+1);
                rws+=nf;
            }
            else
            {
                break;
            }
            System.out.println("\nDo you want to read some more frames : ");
            ch=buf.readLine();
        }while(ch.equals("Yes"));
    }
}
