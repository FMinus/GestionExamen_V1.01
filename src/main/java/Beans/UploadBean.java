/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;


@ManagedBean
@RequestScoped
public class UploadBean implements Serializable
{
    private Part file;
    
    String path = "D:/Etude/JavaEE/WorkSpace/GestionExamen_V1.01/src/main/webapp/resources/images/avatars/";
   
    
    
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
            out = new FileOutputStream(new File(path+file.getSubmittedFileName()));
            
            filecontent = file.getInputStream();
            
            int read = 0;
            final byte[] bytes = new byte[1024];
            
            while ((read = filecontent.read(bytes)) != -1) 
            {
                out.write(bytes, 0, read); 
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }
    
    public boolean validateImageExtention()
    {
        String image = file.getSubmittedFileName();   
        return (image.contains("png") || image.contains("jpg") || image.contains("png") || image.contains("gif"));          
    }
    
    public void upload(String fileName) throws IOException
    {
        OutputStream out = null;
        InputStream filecontent = null;
        
        try
        {
            out = new FileOutputStream(new File(path+fileName));
            
            System.out.println("saved to : "+path+fileName);
            
            filecontent = file.getInputStream();
            
            int read = 0;
            final byte[] bytes = new byte[1024];
            
            while ((read = filecontent.read(bytes)) != -1) 
            {
                out.write(bytes, 0, read);
               
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }
    
    
    
    
        
    
}

    
    
    
     

