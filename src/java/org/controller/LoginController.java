/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dao.DaoLogin;
import org.dao.DaoPermiso;
import org.dao.DaoUser;
import org.models.ModelPermisos;
import wsUser.ModelUser;

/**
 *
 * @author josea
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
 String ingresar="Layout/ingresar.jsp";
 String login="index.jsp";
  ModelUser usuario = new ModelUser();
  DaoLogin user = new DaoLogin();
  int num = 0;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String index = "index.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");
            if(accion.equalsIgnoreCase("Ingresar")){
                String USUARIO = request.getParameter("USUARIO");
                String PASSWORD = request.getParameter("PASSWORD");
                System.out.println(USUARIO);
                System.out.println(PASSWORD);
                
                num = user.Validar(USUARIO, PASSWORD);
                
                if(num == 1){
                    request.getRequestDispatcher("Layout/ingresar.jsp").forward(request,response);
                    System.out.println("Datos Correctos");
                }else{
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                    System.out.println("Datos incorrectos");
                }
            }
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {
        
        
        
        
       /*String acceso="";        
        String action = request.getParameter("accion");
        System.out.println(action);
       
        switch (action){
            case "ingresar":
                String Usuario=request.getParameter("usuario");
                String password= request.getParameter("password");
                usuario.setUsuario(Usuario);
                usuario.setPassword(password);
                 System.out.println(Usuario);
                System.out.println(password);
                consulta.Login(usuario);
               if((usuario.getUsuario()!=null)&&(usuario.getPassword()!=null)){
                   acceso = ingresar;
               }else{
                   acceso = login;
               }
                
                
            break;
        
            
       
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso); //invoca de modo directo un recurso web
        vista.forward(request, response);*/
        
        
        
        processRequest(request, response);
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
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
