/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTTP;

import java.io.*;
import java.rmi.*;
import java.net.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class Client 
{
    public static void main(String[] args) throws Exception
    {
        Socket s;
        BufferedImage i =null;
        s=new Socket("localhost", 4000);
        System.out.println("Client is running");
        try
        {
            System.out.println("Reading image");
            i=ImageIO.read(new File ("chocolate.jpg"));
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ImageIO.write(i, "jpg", b);
            b.flush();
            byte[] by = b.toByteArray();
            b.close();
            System.out.println("Sending the Image");
            OutputStream out = s.getOutputStream();
            DataOutputStream d = new DataOutputStream(out);
            d.writeInt(by.length);
            d.write(by,0,by.length);
            System.out.println("Image Sent to Server");
            d.close();
            out.close();
            s.close();
        }
        catch(Exception e)
        {
            System.out.println("Error : "+e.getMessage());
        }
    }
}
