/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Remote;

import java.net.*;
import java.io.*;

public class Client 
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            int port;
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the port address");
            port = Integer.parseInt(b.readLine());
            Socket s = new Socket("localhost", port);
            if(s.isConnected()==true)
            {
                System.out.println("Server socket is connected");
            }
            InputStream i = s.getInputStream();
            OutputStream o = s.getOutputStream();
            BufferedReader b1 = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader b2 = new BufferedReader(new InputStreamReader(i));
            System.out.println("Enter the command to be executed");
            PrintWriter p = new PrintWriter(o);
            p.println(b1.readLine());
            p.flush();
            String str = b2.readLine();
            System.out.println(" "+ str+" opened successfully");
            System.out.println("The "+str+" the command is executed successfully");
            p.close();
            i.close();
            o.close();
            
        }
        catch(Exception e)
        {
            System.out.println("Error :"+e.getMessage());
        }

    }
}
