package BroadCasting;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class Server 
{
    public static void main(String [] args) throws IOException
    {
        Scanner x=new Scanner(System.in);
        
        System.out.print("Enter the number of systems needed to be connected: ");
                int n=x.nextInt();
                
        try
        {
            ServerSocket ss=new ServerSocket(3333);
            Socket s[]=new Socket[n];
            for(int i=0;i<n;i++)
            {
                s[i]=ss.accept();  
                System.out.println("System "+(i+1)+" connected");
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String sss = br.readLine();

            for(int i=0;i<n;i++)
            {
                DataOutputStream dout=new DataOutputStream(s[i].getOutputStream());
                dout.writeUTF(sss);
                dout.close();
                s[i].close();
            }
            System.out.println("Message sent to systems");
                
                
        }
        catch(Exception e)
        {
            
        }
    }
    
}
