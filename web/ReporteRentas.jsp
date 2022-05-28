<%-- 
    Document   : ReporteRentas
    Created on : 27/05/2022, 12:07:27 AM
    Author     : GEOVARU
--%>

<%@page import="java.util.Iterator"%>
<%@page import="org.models.Modelvehiculo"%>
<%@page import="java.util.List"%>
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
    <body>
    <center>
        <h1>REPORTE DE VEHICULOS RENTADOS</h1>
          <table >
                  
                        <tr>
                            <th class="text-center">ID_VEHICULO</th>
                            <th class="text-center">MARCA</th>
                            <th class="text-center">TIPO DE VEHICULO</th>
                            <th class="text-center">ESTADO DEL VEHICULO</th>
                            <th class="text-center">MODELO</th>
                            <th class="text-center">OPCION</th>

                        </tr>
                 
                   <%
                        DaoVehiculos daoMostrar = new DaoVehiculos();
                        List<Modelvehiculo> lstEstado = daoMostrar.listarVehiculosRentados();
                        Iterator<Modelvehiculo> iteratorVehiculos = lstEstado.iterator();
                        Modelvehiculo mostrarVehiculos = null;
                        while (iteratorVehiculos.hasNext()){
                           mostrarVehiculos = iteratorVehiculos.next();            
                    %>                      
                    <tbody>
                        <tr>
                             <td class="text-center">
                                <%=mostrarVehiculos.getId_vehiculo()%>
                            </td>
                                
                            <td class="text-center">
                                <%=mostrarVehiculos.getMarca()%> 
                            </td>
                            <td class="text-center">
                               <%=mostrarVehiculos.getTipo_de_vehiculo()%> 
                            </td> 
                              <td class="text-center">
                                <%=mostrarVehiculos.getEstado()%>
                              </td>
                              <td class="text-center">
                                 <%=mostrarVehiculos.getModelo()%> 
                              </td>
                              
                        </tr>
                        <br><br><br>
                    </tbody>
                     <%}%>
                </table> 
                </center>
              <center>
   
   <p><input type="button" name="imprimir" value="presione para imprimir" onClick="javascript:imprimir();"></p>
  </center>
                
    </body>
</html>
