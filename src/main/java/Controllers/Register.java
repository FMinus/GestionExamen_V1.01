/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.UploadBean;
import ConnectionMongo.ConnectionAdmin;
import ConnectionMongo.ConnectionEtudiant;
import ConnectionMongo.ConnectionProfesseur;
import Metier.Admin;
import Metier.Etudiant;
import Metier.Professor;
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

@ManagedBean
@SessionScoped
public class Register implements Serializable
{
    @Inject 
    Etudiant etudiant;
    
    @Inject
    Professor professor;
    
    @Inject 
    Admin admin;
    
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

    public Professor getProfessor()
    {
        return professor;
    }

    public void setProfessor(Professor professor)
    {
        this.professor = professor;
    }

    public Admin getAdmin()
    {
        return admin;
    }

    public void setAdmin(Admin admin)
    {
        this.admin = admin;
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
        
        String hashedEmail = hashGenerator(etudiant.getEmail()).toString();
        uploadBean.upload(hashedEmail+"."+avatarExtention); 
        etudiant.setUrlAvatar(hashedEmail+"."+avatarExtention);
        
        //System.out.println("Password : "+etudiant.getPassword());
        //System.out.println("Avatar Name : "+etudiant.getUrlAvatar());
        
        conn.registerEtudiant(etudiant);
        
    }
    
    public void registerProfessor() throws UnsupportedEncodingException, NoSuchAlgorithmException, IOException
    {
        ConnectionProfesseur conn= new ConnectionProfesseur();
       
     
        String[] str = uploadBean.getFile().getContentType().split("/");
        String avatarExtention = str[1];
        
        
        String hashedEmail = hashGenerator(professor.getEmail()).toString();
        uploadBean.upload(hashedEmail+"."+avatarExtention); 
        professor.setUrlAvatar(hashedEmail+"."+avatarExtention);
        
        conn.registerProfessor(professor.toProfessorEntity()); 
    }
    
    public void registerAdmin() throws UnsupportedEncodingException, NoSuchAlgorithmException, IOException
    {
        ConnectionAdmin conn= new ConnectionAdmin();
       
     
        String[] str = uploadBean.getFile().getContentType().split("/");
        String avatarExtention = str[1];
        
        
        String hashedEmail = hashGenerator(admin.getEmail()).toString();
        uploadBean.upload(hashedEmail+"."+avatarExtention); 
        admin.setUrlAvatar(hashedEmail+"."+avatarExtention);
        
        conn.registerAdmin(admin.toAdminEntity()); 
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
