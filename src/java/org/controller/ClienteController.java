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
import org.dao.DaoCliente;
import org.models.ModelCliente;

/**
 *
 * @author GEOVARU
 */
@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

    String inicio = "indexCliente.jsp";
    String crear = "createCliente.jsp";
    String ver = "showCliente.jsp";

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
            out.println("<title>Servlet ClienteController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteController at " + request.getContextPath() + "</h1>");
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
        String acceso = "";
        String action = request.getParameter("accion");
        ModelCliente infoModel = new ModelCliente();
        DaoCliente infoDAO = new DaoCliente();

        switch (action) {
            case "read":
                acceso = inicio;
                break;

            case "create":
                acceso = crear;
                break;

            case "editar":
                request.setAttribute("idCliente", request.getParameter("idCliente"));
                acceso = ver;
                break;
            case "store":
                String nit = request.getParameter("nit");
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String telefono = request.getParameter("telefono");
                String direccion = request.getParameter("direccion");

                infoModel.setNit(nit);
                infoModel.setNombre(nombre);
                infoModel.setApellido(apellido);
                infoModel.setTelefono(telefono);
                infoModel.setDireccion(direccion);

                infoDAO.insertar(infoModel);
                acceso = inicio;
                break;
            case "update":

                int idCliente = Integer.parseInt(request.getParameter("idCliente"));
                nit = request.getParameter("nit");
                nombre = request.getParameter("nombre");
                apellido = request.getParameter("apellido");
                telefono = request.getParameter("telefono");
                direccion = request.getParameter("direccion");

                infoModel.setIdCliente(idCliente);
                infoModel.setNit(nit);
                infoModel.setNombre(nombre);
                infoModel.setApellido(apellido);
                infoModel.setTelefono(telefono);
                infoModel.setDireccion(direccion);

                infoDAO.modificar(infoModel);
                acceso = inicio;
                break;
            case "delete":
                infoModel.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
                infoDAO.eliminar(infoModel);
                acceso = inicio;
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
