/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.models.ModelRoll;
import org.dao.DaoRoll;
/**
 *
 * @author INSPIRON 7000 SERIES
 */
@WebServlet(name = "RollController", urlPatterns = {"/RollController"})
public class RollController extends HttpServlet {

   
    
     String listar = "createRolls.jsp";
     String listar2 = "viewRolls.jsp";
    
    String add = "Cliente/clienteIngreso.jsp";
    String edit = "updateRolls.jsp";
    String delete = "";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RollController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RollController at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        String acceso = "";
        String action = request.getParameter("accion");
       
        ModelRoll roll = new ModelRoll();
        DaoRoll daoRoll = new DaoRoll();
       

        switch (action) {
            case "read":
                acceso = listar2;
                break;

            case "nuevo":
                acceso = add;
                break;

            case "create":
               
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                String activo = request.getParameter("estado");
                String usuariocrea = request.getParameter("Ucreador");
                String usuariomod = request.getParameter("Umod");
                String fechacreacion = request.getParameter("fcreacion");
                String fechamod = request.getParameter("fmod");
                
                roll.setNombre(nombre);
                roll.setDescripcion(descripcion);
                roll.setActivo(Integer.parseInt(activo));
                roll.setUCreador(usuariocrea);
                roll.setUMod(usuariomod);
                roll.setFechaCrea(fechacreacion);
                roll.setFechaMod(fechamod);
                daoRoll.insertar(roll);
                acceso = listar;
                
               
                break;
            case "create2":
                
                String idCliente = request.getParameter("CLIENTE");
                String observacion = request.getParameter("COMENTARIO");
                String pais = request.getParameter("PAIS");
                String total = request.getParameter("TOTAL");
                String totalusd = request.getParameter("TOTALUSD");
                String tipopago = request.getParameter("TIPO_PAGO");
                String fecha = request.getParameter("FECHA");
               
              
                break;
            case "editar":
                
                request.setAttribute("idRoll", request.getParameter("id"));
               
                acceso = edit;
                break;
            case "update":
          
                int idRol = Integer.parseInt(request.getParameter("idrol"));
              
               
                nombre = request.getParameter("nombre");
                descripcion = request.getParameter("descripcion");
                activo = request.getParameter("estado");
                usuariocrea = request.getParameter("Ucreador");
                usuariomod = request.getParameter("Umod");
                fechacreacion = request.getParameter("fcreacion");
                fechamod = request.getParameter("fmod");
                
                roll.setIdRol(idRol);
                roll.setNombre(nombre);
                roll.setDescripcion(descripcion);
                roll.setActivo(Integer.parseInt(activo));
                roll.setUCreador(usuariocrea);
                roll.setUMod(usuariomod);
                roll.setFechaCrea(fechacreacion);
                roll.setFechaMod(fechamod);
                
                daoRoll.modificar(roll);

                
                
                
                acceso = listar2;
                
                break;
            case "delete":
              
               roll.setIdRol(Integer.parseInt(request.getParameter("id")));
               daoRoll.eliminar(roll);
                
                
             
                acceso = listar2;
                break;

        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso); //invoca de modo directo un recurso web
        vista.forward(request, response);
        
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