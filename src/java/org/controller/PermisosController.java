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
import org.dao.DaoPermiso;
import org.models.ModelPermisos;
import org.models.ModuleModel;

/**
 *
 * @author josea
 */
@WebServlet(name = "PermisosController", urlPatterns = {"/PermisosController"})
public class PermisosController extends HttpServlet {
    String agregar="Permisos.jsp";
    String eliminar="verPermisos.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        rd=request.getRequestDispatcher("/Permisos.jsp");
        rd.forward(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PermisosController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PermisosController at " + request.getContextPath() + "</h1>");
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
        
        String acceso="";        
        String action = request.getParameter("accion");
        System.out.println(action);
        ModelPermisos permiso=new ModelPermisos();
        DaoPermiso permisos=new DaoPermiso();
        switch (action){
            case "Agregar":
                String Modulo=request.getParameter("modulo");
                String Rol=request.getParameter("rol");
                String FechaCrea=request.getParameter("fecha_crea");
                String FechaMod=request.getParameter("fecha_mod");
                String Usuariocrea=request.getParameter("usuario_crea");
                String UsuarioMod=request.getParameter("usuario_mod");
                String Activo=request.getParameter("estado");
                
                permiso.setId_modulo(Integer.parseInt(Modulo));
                permiso.setId_rol(Integer.parseInt(Rol));
                permiso.setFechaCrea(FechaCrea);
                permiso.setFechaMod(FechaMod);
                permiso.setUsuarioCrea(Usuariocrea);
                permiso.setUsuarioMod(UsuarioMod);
                permiso.setActivo(Integer.parseInt(Activo));
                
                permisos.insertar(permiso);
                
                System.out.println(Modulo);
                System.out.println(Rol);
                System.out.println(Usuariocrea);
                System.out.println(FechaCrea);
                System.out.println(FechaMod);
                System.out.println(UsuarioMod);
                System.out.println(Activo);
                
                acceso = agregar;
            break;
            case "ver":
               List<ModelPermisos> lstModulos2 = permisos.listar();
               Iterator<ModelPermisos> iteratorpermiso = lstModulos2.iterator();
               ModelPermisos mostrarPermisos = null;
               while (iteratorpermiso.hasNext()){
               mostrarPermisos = iteratorpermiso.next(); 
                    mostrarPermisos.getId_modulo();
                    System.out.println(mostrarPermisos.getId_rol());
                    mostrarPermisos.getFechaCrea();
                    System.out.println(mostrarPermisos.getFechaMod());
                    System.out.println(mostrarPermisos.getUsuarioCrea());
                    System.out.println(mostrarPermisos.getUsuarioMod());
                    System.out.println(mostrarPermisos.getActivo());
               }
                
                acceso=agregar;
                    break;
            case "eliminar":
                   String IdPermiso=request.getParameter("id");
                   permiso.setId_permiso(Integer.parseInt(IdPermiso));
                   permisos.eliminar(permiso);
                   acceso=eliminar;
                
                break;
            case "editar":
                String id2=request.getParameter("id");
                System.out.println(id2);
                String Modulo2=request.getParameter("modulo");
                String Rol2=request.getParameter("rol");
                String FechaCrea2=request.getParameter("fecha_crea");
                String FechaMod2=request.getParameter("fecha_mod");
                String Usuariocrea2=request.getParameter("usuario_crea");
                String UsuarioMod2=request.getParameter("usuario_mod");
                String Activo2=request.getParameter("estado");
                
                permiso.setId_permiso(Integer.parseInt(id2));
                permiso.setId_modulo(Integer.parseInt(Modulo2));
                permiso.setId_rol(Integer.parseInt(Rol2));
                permiso.setFechaCrea(FechaCrea2);
                permiso.setFechaMod(FechaMod2);
                permiso.setUsuarioCrea(Usuariocrea2);
                permiso.setUsuarioMod(UsuarioMod2);
                permiso.setActivo(Integer.parseInt(Activo2));
                permisos.modificar(permiso);
                
                System.out.println(Modulo2);
                System.out.println(Rol2);
                System.out.println(Usuariocrea2);
                System.out.println(FechaCrea2);
                System.out.println(FechaMod2);
                System.out.println(UsuarioMod2);
                System.out.println(Activo2);
                
                acceso=eliminar;
               break;
            
       
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso); //invoca de modo directo un recurso web
        vista.forward(request, response);
        
        
        
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
