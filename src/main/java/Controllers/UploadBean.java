/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import org.apache.commons.io.FileUtils;

@ManagedBean
@SessionScoped
public class UploadBean
{
    private Part file;
    private String text;
    
    private final int limit_max_size = 10240000;
    private final String path_to = "D:\\Etude\\JavaEE\\WorkSpace\\GestionExamen_V1.01\\uploads";
    private final String limit_type_file = "gif|jpg|png|jpeg";
    
    
    public Part getFile()
    {
        return file;
    }

    public void setFile(Part file)
    {
        this.file = file;
    }
    
    
    
    public void upload() throws IOException
    {
        OutputStream out = null;
        InputStream filecontent = null;
        
        try
        {
            out = new FileOutputStream(new File("D:\\Etude\\JavaEE\\WorkSpace\\GestionExamen_V1.01\\uploads\\"+file.getSubmittedFileName()));
            
            filecontent = file.getInputStream();
            
            int read = 0;
            final byte[] bytes = new byte[1024];
            
            while ((read = filecontent.read(bytes)) != -1) 
            {
                out.write(bytes, 0, read);
                System.out.println(bytes);
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public boolean validateImage()
    {
        String image = file.getSubmittedFileName();   
        return (image.contains("png") || image.contains("jpg") || image.contains("png") || image.contains("gif"));          
    }
    
        
    
}

    
    
    
     

