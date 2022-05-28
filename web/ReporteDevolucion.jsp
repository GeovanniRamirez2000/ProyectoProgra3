<%-- 
    Document   : ReporteDevolucion
    Created on : 27/05/2022, 12:07:12 AM
    Author     : GEOVARU
--%>

<%@page import="org.models.ModelDevolucion"%>
<%@page import="org.dao.DaoDevolucion"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.Modelvehiculo"%>
<%@page import="org.dao.DaoVehiculos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language="javascript">
    function imprimir()
    {
     if (window.print) window.print()
     else alert("puede utilizar Crtl+p");
    }
   </script>
    </head>
    <body class="col-md-12" >
<center>
        <div id="layoutSidenav_content">
            <main >

                <div class="container-fluid px-4 row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-10 ">
                        <br>
                        <h1 class="mt-5">Reporte de Devoluciones de Vehiculos.</h1>
                        <table>
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
<p><input type="button" name="imprimir" value="presione para imprimir" onClick="javascript:imprimir();"></p>
                    </div>
                </div>
            </main>

        </div>
    </center>
    </body>
   
    
</html>
