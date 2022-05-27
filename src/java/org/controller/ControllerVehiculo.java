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
import org.dao.DaoVehiculos;
import org.models.Modelvehiculo;

/**
 *
 * @author josea
 */
@WebServlet(name = "ControllerVehiculo", urlPatterns = {"/ControllerVehiculo"})
public class ControllerVehiculo extends HttpServlet {
String edit="ModificarVehiculos.jsp";
String editestado="ModificarEstadoVehiculos.jsp";
String regresar="verVehiculos.jsp";
String regresar2= "cambiarEstadoVehiculos.jsp";
String inicio="index.jsp";
String agregar="IngresarVehiculos.jsp";
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
            out.println("<title>Servlet ControllerVehiculo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerVehiculo at " + request.getContextPath() + "</h1>");
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
        Modelvehiculo obj1= new Modelvehiculo();
        DaoVehiculos objve= new DaoVehiculos();
        switch (action){
            case "ingresar":
             //int id_vehiculo=Integer.parseInt(request.getParameter("id_vehiculo"));
             int id_tipo_vehiculo=Integer.parseInt(request.getParameter("id_tipo_vehiculo"));
             int id_marca=Integer.parseInt(request.getParameter("id_marca"));
             int id_vehiculo_estado=Integer.parseInt(request.getParameter("id_vehiculo_estado")); 
             String Modelo=request.getParameter("modelo");
             
             //obj1.setId_vehiculo(id_vehiculo);
             obj1.setId_marca(id_marca);
             obj1.setId_tipo_vehiculo(id_tipo_vehiculo);
             obj1.setId_vehiculo_estado(id_vehiculo_estado);
             obj1.setModelo(Modelo);
             objve.insertar(obj1);
                //System.out.println(id_vehiculo);
                System.out.println(id_tipo_vehiculo);
                System.out.println(id_marca);
                System.out.println(id_vehiculo_estado);
                System.out.println(Modelo);
             
              acceso = agregar;
            break;
            case "read":
                acceso=regresar;
               
              break;
              case "read2":
                acceso=regresar2;
               
              break;
            case "eliminar":
                  int id=Integer.parseInt(request.getParameter("id"));
                  obj1.setId_vehiculo(id);
                  System.out.println(obj1);
                  objve.eliminar(obj1);
                   acceso=regresar;
               
                
                break;
            case "editar":
                //int idmod=Integer.parseInt(request.getParameter("id"));
                request.setAttribute("idVehiculo", request.getParameter("id"));
                /*obj1.setId_vehiculo(idmod);
                objve.list(id);*/
                acceso=edit;
               break;
               case "cambio":
                //int idmod=Integer.parseInt(request.getParameter("id"));
                request.setAttribute("idVehiculo", request.getParameter("id"));
                /*obj1.setId_vehiculo(idmod);
                objve.list(id);*/
                acceso=editestado;
               break;
             case "update":
                int id_vehiculo=Integer.parseInt(request.getParameter("id_vehiculo"));
                int id_tipo_vehiculo2=Integer.parseInt(request.getParameter("id_tipo_vehiculo"));
                int id_marca2=Integer.parseInt(request.getParameter("id_marca"));
                int id_vehiculo_estado2=Integer.parseInt(request.getParameter("id_vehiculo_estado")); 
                String Modelo2=request.getParameter("modelo");
                
                obj1.setId_vehiculo(id_vehiculo);
                obj1.setId_marca(id_marca2);
                obj1.setId_tipo_vehiculo(id_tipo_vehiculo2);
                obj1.setId_vehiculo_estado(id_vehiculo_estado2);
                obj1.setModelo(Modelo2);
                objve.editar(obj1);
                acceso=regresar;
                
                break;
                case "updateEstado":
                int id_vehiculo2=Integer.parseInt(request.getParameter("id_vehiculo"));
                int id_vehiculo_estado3=Integer.parseInt(request.getParameter("id_vehiculo_estado")); 
                 obj1.setId_vehiculo(id_vehiculo2);
                obj1.setId_vehiculo_estado(id_vehiculo_estado3);
                objve.editarEstado(obj1);
                acceso=regresar2;
                break;
                case "updateEstado2":
                int id_vehiculo3=Integer.parseInt(request.getParameter("id_vehiculo"));
                int id_vehiculo_estado4=Integer.parseInt(request.getParameter("id_vehiculo_estado")); 
                 obj1.setId_vehiculo(id_vehiculo3);
                obj1.setId_vehiculo_estado(id_vehiculo_estado4);
                objve.editarEstado(obj1);
                acceso=regresar2;
                break;
             case "regresar":
                   acceso=inicio;
                 break;
             case "agregar":
                 acceso=agregar;
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
