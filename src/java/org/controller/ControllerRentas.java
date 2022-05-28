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
import org.dao.DaoRenta;
import org.models.ModelRenta;

/**
 *
 * @author josea
 */
@WebServlet(name = "ControllerRentas", urlPatterns = {"/ControllerRentas"})
public class ControllerRentas extends HttpServlet {
String Renta="ProcesoRenta.jsp";
String verRenta="verRenta.jsp";
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
            out.println("<title>Servlet ControllerRentas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerRentas at " + request.getContextPath() + "</h1>");
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
        ModelRenta renta = new ModelRenta();
        DaoRenta opcion = new DaoRenta();
        switch (action){
            case "ingresar":
             //int id_vehiculo=Integer.parseInt(request.getParameter("id_vehiculo"));
             String serie=request.getParameter("serie");
             int id_cliente=Integer.parseInt(request.getParameter("id_cliente"));
             int id_usuario=Integer.parseInt(request.getParameter("id_usuario"));
             int id_tipo_pago=Integer.parseInt(request.getParameter("id_tipo_pago"));
             String fecha_prestamo=request.getParameter("fecha_prestamo");
             String fecha_devolucion=request.getParameter("fecha_devolucion");
             int total=Integer.parseInt(request.getParameter("total"));
             
             renta.setSERIE(serie);
             renta.setID_CLIENTE(id_cliente);
             renta.setID_USUARIO(id_usuario);
             renta.setID_TIPO_PAGO(id_tipo_pago);
             renta.setFECHA_PRESTAMO(fecha_prestamo);
             renta.setFECHA_DEVOLUCION(fecha_devolucion);
             renta.setTotal(total);
         
            break;
            case "renta":
                 request.setAttribute("idVehiculo", request.getParameter("id"));
                 acceso=Renta;
            break;
            case "ProcesoRenta":
                 String Serie=request.getParameter("serie");
                 int cliente =Integer.parseInt(request.getParameter("id_cliente"));
                 int usuario =Integer.parseInt(request.getParameter("id_usuario"));
                 int tipo_pago=Integer.parseInt(request.getParameter("id_tipo_pago"));
                 String fechaPrestamo=request.getParameter("fecha_prestamo");
                 String fechaDevolucion=request.getParameter("fecha_devolucion");
                 int ID=Integer.parseInt(request.getParameter("id_vehiculo"));
                 //int Estado=Integer.parseInt(request.getParameter("id_vehiculo_estado"));
                 int PrecioAlquiler=Integer.parseInt(request.getParameter("precio_alquiler"));
                 int Total=Integer.parseInt(request.getParameter("total"));
                 
                 renta.setSERIE(Serie);
                 renta.setID_CLIENTE(cliente);
                 renta.setID_USUARIO(usuario);
                 renta.setID_TIPO_PAGO(tipo_pago);
                 renta.setFECHA_PRESTAMO(fechaPrestamo);
                 renta.setFECHA_DEVOLUCION(fechaDevolucion);
                 renta.setID_VEHICULO(ID);
                 //renta.setID_VEHICULO_ESTADO(Estado);
                 renta.setPRECIO_ALQUILER(PrecioAlquiler);
                 renta.setTotal(Total);
                 opcion.insertarRenta(renta);
                 opcion.Detalle_renta(renta);
                 opcion.actualizarVehiculo(renta);
                 
                 acceso=verRenta;
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
