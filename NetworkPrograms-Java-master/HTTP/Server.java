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
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;


public class Server 
{
    public static void main(String[] args) throws Exception 
    {
        ServerSocket ss = new ServerSocket(4000);
        System.out.println("Server waiting for image");
        Socket s = ss.accept();
        System.out.println("Client Connected");
        InputStream in = s.getInputStream();
        DataInputStream d = new DataInputStream(in);
        int l = d.readInt();
        System.out.println("Image Size : "+l/1024+"KB");
        byte[] data = new byte[l];
        d.readFully(data);
        d.close();
        in.close();
        InputStream in1 = new ByteArrayInputStream(data);
        BufferedImage b = ImageIO.read(in1);
        JFrame f = new JFrame("Server");
        ImageIcon icon = new ImageIcon(b);
        JLabel j = new JLabel();
        j.setIcon(icon);
        f.add(j);
        f.pack();
        f.setVisible(true);
    }
}
