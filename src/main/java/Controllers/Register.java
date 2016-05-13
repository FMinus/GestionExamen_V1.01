/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.UploadBean;
import ConnectionMongo.ConnectionEtudiant;
import Metier.Etudiant;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.security.*;
import java.util.Arrays;

@ManagedBean
@SessionScoped
public class Register implements Serializable
{
    @Inject 
    Etudiant etudiant;
    
    @Inject
    UploadBean uploadBean;

    public Etudiant getEtudiant()
    {
        return etudiant;
    }

    public UploadBean getUploadBean()
    {
        return uploadBean;
    }

    public void setUploadBean(UploadBean uploadBean)
    {
        this.uploadBean = uploadBean;
    }
    
    public void setEtudiant(Etudiant etudiant)
    {
        this.etudiant = etudiant;
    }
    
    public void registerEtudiant() throws UnsupportedEncodingException, NoSuchAlgorithmException, IOException
    {
        ConnectionEtudiant conn= new ConnectionEtudiant();
        //r.registerEtudiant(new Etudiant(this.firstName,this.lastName,this.email,this.password,this.filiere,this.dateOfBirth,this.urlAvatar));
        System.out.println("Avatar Filename : "+uploadBean.getFile().getContentType());
        String[] str = uploadBean.getFile().getContentType().split("/");
        String avatarExtention = str[1];
        
        
        
        System.out.println("Avatar Extention : "+str[1]);
        
        
        //etudiant.setPassword(hashGenerator(etudiant.getPassword()).toString());
        
        String hashedEmail = Arrays.toString(hashGenerator(etudiant.getEmail()));      
        uploadBean.upload(hashedEmail+"."+avatarExtention); 
        etudiant.setUrlAvatar(hashedEmail+"."+avatarExtention);
        
        //System.out.println("Password : "+etudiant.getPassword());
        //System.out.println("Avatar Name : "+etudiant.getUrlAvatar());
        
        conn.registerEtudiant(etudiant);
        
    }
    
    public HttpServletRequest getHttpServletRequest()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        
        return request;
    }
    
    public byte [] hashGenerator(String message) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        byte[] bytesOfMessage = message.getBytes("UTF-8");
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        
        return thedigest;
    }
    
    
    
    
    
    
}
