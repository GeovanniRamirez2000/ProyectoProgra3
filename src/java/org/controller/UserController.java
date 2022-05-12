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
import org.dao.DaoUser;
import org.models.ModelUser;

/**
 *
 * @author GEOVARU
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    String inicio = "Usuario/index.jsp";
    String crear = "Usuario/create.jsp";
    String ver = "Usuario/show.jsp";

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
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
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
        ModelUser infoModel = new ModelUser();
        DaoUser infoDAO = new DaoUser();

        switch (action) {
            case "index":
                acceso = inicio;
                break;

            case "create":
                acceso = crear;
                break;

            case "show":
                request.setAttribute("idUsuario", request.getParameter("id"));
                acceso = ver;
                break;
            case "store":
                int idRol = Integer.parseInt(request.getParameter("idRol"));
                int activo = Integer.parseInt(request.getParameter("activo"));
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String usuario = request.getParameter("usuario");
                String password = request.getParameter("password");
                String fechaCrea = request.getParameter("fechaCrea");
                String fechaMod = request.getParameter("fechaMod");
                String usuarioCrea = request.getParameter("usuarioCrea");
                String usuarioMod = request.getParameter("usuarioMod");
                String codigo = request.getParameter("codigo");

                infoModel.setIdRol(idRol);
                infoModel.setActivo(activo);
                infoModel.setNombre(nombre);
                infoModel.setApellido(apellido);
                infoModel.setUsuario(usuario);
                infoModel.setPassword(password);
                infoModel.setFechaCrea(fechaCrea);
                infoModel.setFechaMod(fechaMod);
                infoModel.setUsuarioCrea(usuarioCrea);
                infoModel.setUsuarioMod(usuarioMod);
                infoModel.setCodigo(codigo);

                infoDAO.insertar(infoModel);

                acceso = inicio;
                break;
            case "update":
                int idUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
                idRol = Integer.parseInt(request.getParameter("idRol"));
                activo = Integer.parseInt(request.getParameter("activo"));
                nombre = request.getParameter("nombre");
                apellido = request.getParameter("apellido");
                usuario = request.getParameter("usuario");
                password = request.getParameter("password");
                fechaCrea = request.getParameter("fechaCrea");
                fechaMod = request.getParameter("fechaMod");
                usuarioCrea = request.getParameter("usuarioCrea");
                usuarioMod = request.getParameter("usuarioMod");
                codigo = request.getParameter("codigo");

                infoModel.setIdRol(idRol);
                infoModel.setActivo(activo);
                infoModel.setNombre(nombre);
                infoModel.setApellido(apellido);
                infoModel.setUsuario(usuario);
                infoModel.setPassword(password);
                infoModel.setFechaCrea(fechaCrea);
                infoModel.setFechaMod(fechaMod);
                infoModel.setUsuarioCrea(usuarioCrea);
                infoModel.setUsuarioMod(usuarioMod);
                infoModel.setCodigo(codigo);

                infoDAO.modificar(infoModel);
                acceso = crear;
                break;
            case "delete":
                infoModel.setIdUsuario(Integer.parseInt(request.getParameter("id")));
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
