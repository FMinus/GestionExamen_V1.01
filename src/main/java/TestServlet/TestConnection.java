/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestServlet;

import Controllers.Login;
import com.mongodb.DB;




import com.mongodb.DB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Ayoub
 */
public class TestConnection extends HttpServlet
{
    @Inject Login log;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.io.UnsupportedEncodingException
     * @throws java.security.NoSuchAlgorithmException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, UnsupportedEncodingException, NoSuchAlgorithmException
    {
        response.setContentType("text/html;charset=UTF-8");
        
        //DAOEtudiant dao = new DAOEtudiant("localhost","GestionExamen",27017);
        
        //List<EtudiantEntity> listEtu = dao.getAllEtudiants("lastName","test");
        
        /*
        Calendar cal = Calendar.getInstance();
        Date t = cal.getTime();
        
         //public Etudiant(String firstName, String lastName, String email, String password, Filiere filiere, Date dateOfBirth, String urlAvatar)
        Etudiant etudiantMetier = new Etudiant("ayoub","deqqaq","ayoub@gmail.com","pass",Filiere.GI,t,"none");
        
        EtudiantEntity etudiantEntity = etudiantMetier.toEtudiantEntity();
        */
        
        log.setEmail("ensa@mail.com");
        log.setPassword("ayoub");
        
        System.out.println(log.loginEtudiant());
        
        
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddAddress</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>MongoDB Server : " + database.getName() + "</h1>");
            //out.println("<h1>MongoDB Collections : " + database.getCollection("Address")+ "</h1>");
            //out.println("<h1>MongoDB Query : " + etu.toString() + "</h1>");
            //out.println("<h1>MongoDB Query : " + listEtu.get(0).toString() + "</h1>");
            //out.println("<h1>MongoDB Query : " + etudiantEntity.toString()+ "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, UnsupportedEncodingException
    {
        try
        {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex)
        {
            Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, UnsupportedEncodingException
    {
        try
        {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex)
        {
            Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
    
   

}
