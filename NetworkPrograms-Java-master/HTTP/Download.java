/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTTP;

/**
 *
 * @author lallu
 */
import java.io.*;
import java.rmi.*;
import java.net.*;

public class Download 
{
    public static void main(String[] args) 
    {
        String file = "abcd.jpg";
        try
        {
            System.setProperty("http.agent", "Chrome");
            URL url = new URL("https://wallpaper-house.com/data/out/8/wallpaper2you_253917.jpg");
            byte [] buf = new byte[2048];
            InputStream in = url.openStream();
            OutputStream out = new FileOutputStream(file);
            int i=0;
            System.out.println("Downloading the image");
            while((i=in.read(buf))!=-1)
            {
                out.write(buf,0,i);
            }
            in.close();
            out.close();
            System.out.println("Image downloaded Successfully");
        }
        catch(Exception e)
        {
            System.out.println("Error : "+e.getMessage());
        }
    }
}
