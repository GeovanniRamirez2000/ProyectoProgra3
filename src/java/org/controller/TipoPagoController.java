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
import org.dao.DaoTipoPago;
import org.models.ModelTipoPago;

/**
 *
 * @author GEOVARU
 */
@WebServlet(name = "TipoPagoController", urlPatterns = {"/TipoPagoController"})
public class TipoPagoController extends HttpServlet {

    String inicio = "indexTipoPago.jsp";
    String crear = "createTipoPago.jsp";
    String ver = "showTipoPago.jsp";

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
            out.println("<title>Servlet TipoPagoController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TipoPagoController at " + request.getContextPath() + "</h1>");
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
        ModelTipoPago infoModel = new ModelTipoPago();
        DaoTipoPago infoDAO = new DaoTipoPago();

        switch (action) {
            case "read":
                acceso = inicio;
                break;

            case "create":
                acceso = crear;
                break;

            case "editar":
                request.setAttribute("idTipoPago", request.getParameter("idTipoPago"));
                acceso = ver;
                break;
            case "store":
                String descripcion = request.getParameter("descripcion");

                infoModel.setDescripcion(descripcion);

                infoDAO.insertar(infoModel);
                acceso = inicio;
                break;
            case "update":

                int idTipoPago = Integer.parseInt(request.getParameter("idTipoPago"));
                descripcion = request.getParameter("descripcion");
                infoModel.setIdTipoPago(idTipoPago);
                infoModel.setDescripcion(descripcion);

                infoDAO.modificar(infoModel);
                acceso = inicio;
                break;
            case "delete":
                infoModel.setIdTipoPago(Integer.parseInt(request.getParameter("idTipoPago")));
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
