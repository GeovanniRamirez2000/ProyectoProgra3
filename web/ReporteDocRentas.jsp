<%-- 
    Document   : ReporteDocRentas
    Created on : 27/05/2022, 12:05:57 AM
    Author     : GEOVARU
--%>


<%@page import="org.models.ModelRenta"%>
<%@page import="org.dao.DaoRenta"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.models.ModelRoll"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoRoll"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.Modelvehiculo"%>
<%@page import="org.dao.DaoVehiculos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
     <script language="javascript">
    function imprimir()
    {
     if (window.print) window.print()
     else alert("puede utilizar Crtl+p");
    }
   </script>
    <body class="col-md-12" >
<center>
        <div id="layoutSidenav_content">
            <main >

                <div class="container-fluid px-4 row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-10 ">
                        <br>
                        <h1 class="mt-5">Reporte de Rentas</h1>
                        <table>
                            <thead>
                                <tr>
                                    <th class="text-center">ID_RENTA</th>
                                    <th class="text-center">SERIE</th>
                                    <th class="text-center">NOMBRE</th>
                                    <th class="text-center">DESCRIPCION</th>
                                    <th class="text-center">FECHA_PRESTAMO</th>
                                    <th class="text-center">FECHA_DEVOLUCION</th>
                                    <th class="text-center">TOTAL</th>

                                </tr>
                            </thead>

                            <%
                                DaoRenta daoMostrar = new DaoRenta();
                                List<ModelRenta> lstRentas = daoMostrar.MostrarRentas();
                                Iterator<ModelRenta> iteratorRentas = lstRentas.iterator();
                                ModelRenta mostrarRentas = null;
                                while (iteratorRentas.hasNext()) {
                                    mostrarRentas = iteratorRentas.next();
                            %>                     
                            <tbody>
                                <tr>
                                    <td class="text-center">
                                        <%=mostrarRentas.getID_RENTA()%>
                                    </td>

                                    <td class="text-center">
                                        <%=mostrarRentas.getSERIE()%> 
                                    </td>
                                    <td class="text-center">
                                        <%=mostrarRentas.getNombre()%> 
                                    </td> 
                                    <td class="text-center">
                                        <%=mostrarRentas.getDescripcion()%>
                                    </td>
                                    <td class="text-center">
                                        <%=mostrarRentas.getFECHA_PRESTAMO()%> 
                                    </td>
                                    <td class="text-center">
                                        <%=mostrarRentas.getFECHA_DEVOLUCION()%> 
                                    </td>
                                    <td class="text-center">
                                        <%=mostrarRentas.getTotal()%> 
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
