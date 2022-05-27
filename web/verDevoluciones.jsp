<%-- 
    Document   : verDevoluciones
    Created on : may 26, 2022, 11:25:17 p.m.
    Author     : INSPIRON 7000 SERIES
--%>

<%@page import="org.models.ModelDevolucion"%>
<%@page import="org.dao.DaoDevolucion"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.models.ModelRoll"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoRoll"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.Modelvehiculo"%>
<%@page import="org.dao.DaoVehiculos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Layout/layout.jsp"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="col-md-12" >

        <div id="layoutSidenav_content">
            <main >

                <div class="container-fluid px-4 row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-10 ">
                        <br>
                        <h1 class="mt-5">Ver Devoluciones</h1>
                        <table border="1" width="1" cellspacing="1" class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="text-center">#</th>
                            <th class="text-center">RENTA</th>
                            <th class="text-center">SERIE</th>
                            <th class="text-center">FECHA</th>
                            <th class="text-center">OBSERVACIONES</th>
                            <th class="text-center">USUARIO</th>
                            <th class="text-center">DIAS ATRASO</th>
                            <th class="text-center">MORA</th>
                          
                        </tr>
                    </thead>
                  
                   <%
                        DaoDevolucion daoDevolucion = new DaoDevolucion();
                        List<ModelDevolucion> lstDevolucion = daoDevolucion.listarDevoluciones();
                        Iterator<ModelDevolucion> iteratorDevolucion = lstDevolucion.iterator();
                        ModelDevolucion mostrarDevoluciones = null;
                        while (iteratorDevolucion.hasNext()){
                           mostrarDevoluciones = iteratorDevolucion.next();            
                    %>                     
                    <tbody>
                        <tr>
                            <td class="text-center">
                                <%= mostrarDevoluciones.getId_devolucion()%>
                            </td>
                                
                            <td class="text-center">
                                <%= mostrarDevoluciones.getId_renta() %> 
                            </td>
                            <td class="text-center">
                               <%= mostrarDevoluciones.getSerie() %> 
                            </td> 
                              <td class="text-center">
                                <%= mostrarDevoluciones.getFecha() %>
                              </td>
                              <td class="text-center">
                                 <%= mostrarDevoluciones.getObservaciones() %> 
                              </td>
                              <td class="text-center">
                                 <%= mostrarDevoluciones.getUsuario() %>
                                 
                              </td>
                              <td class="text-center">
                                 <%= mostrarDevoluciones.getDias_atraso() %> 
                              </td>
                              <td class="text-center">
                                 <%= mostrarDevoluciones.getMora() %> 
                              </td>
                             
                               
                            
                          
                         
                        </tr>
                        <%}%>
                    
                       
<br><br>
                    <br>
                    </tbody>
                </table>
                        
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>
