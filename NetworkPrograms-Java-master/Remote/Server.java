/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Remote;

import java.io.*;
import java.io.InputStreamReader;
import java.net.*;
import static javafx.scene.input.KeyCode.H;

/**
 *
 * @author lallu
 */
public class Server 
{
    public static void main(String []args)
    {
        try
        {
           int port;
           BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the port address");
            port=Integer.parseInt(b.readLine());
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server is ready to receive command");
            System.out.println("Waiting");
            Socket s = ss.accept();
            if(s.isConnected()==true)
            {
                System.out.println("Client is connected successfully");
            }
            InputStream in = s.getInputStream();
            OutputStream o = s.getOutputStream();
            BufferedReader b1 = new BufferedReader(new InputStreamReader(in));
            String cmd=b1.readLine();
            PrintWriter p = new PrintWriter(o);
            p.println(cmd);
            Runtime r = Runtime.getRuntime();
            Process pp;
            pp = exec(cmd);
            System.out.println("The"+cmd+"command is executed successfully");
            p.flush();
            o.close();
            in.close();
        }
        catch(Exception e)
        {
            System.out.println("Error :"+e.getMessage());
        }
    }

    private static Process exec(String cmd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
