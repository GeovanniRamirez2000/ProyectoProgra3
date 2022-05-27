/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dao.DaoMarcas;
import org.models.ModelMarca;

/**
 *
 * @author MSarazua
 */
@WebServlet(name = "MarcasController", urlPatterns = {"/MarcasController"})
public class MarcasController extends HttpServlet {
    String listar="verMarcas.jsp";

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MarcasController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MarcasController at " + request.getContextPath() + "</h1>");
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
        
        ModelMarca marca = new ModelMarca();
        DaoMarcas daoMarcas = new DaoMarcas();
        
        switch (action){
            /**case "read":
                acceso = listar;
            break;
            
            case "nuevo":
                acceso=add;
            break;*/
                
            case "create" :                
                String descripcion = request.getParameter("descripcion");

                marca.setDescripcion(descripcion);

                daoMarcas.insertar(marca);
                acceso = listar;
            break;
            /**case "editar":
                request.setAttribute("idModulo", request.getParameter("id"));
                acceso = edit;
            break;            */
            case "update" :
                /**int idModulo = Integer.parseInt(request.getParameter("codigo"));
                nombre = request.getParameter("nombre");
                descripcion = request.getParameter("descripcion");
                path = request.getParameter("path");
                nivel = request.getParameter("nivel");
                modpadre= (Integer.parseInt(request.getParameter("modpadre")));
                fcreacion= request.getParameter("fcreacion");
                fmod= request.getParameter("fmod");
                Ucreador= request.getParameter("Ucreador");
                Umod= request.getParameter("Umod");
                estado = (Integer.parseInt(request.getParameter("estado")));
                
                module.setNombre(nombre);
                module.setDescripcion(descripcion);
                module.setPath(path);
                module.setNivel(nivel);
                module.setIdModPadre(modpadre);
                module.setFechaCreacion(fcreacion);
                module.setFechaMod(fmod);
                module.setUCreador(Ucreador);
                module.setUMod(Umod);
                module.setEstado(estado);
                
                daoModule.modificar(module);
                acceso = listar;             */
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
