
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
                        <h1 class="mt-5">Rentas</h1>
                        <a class=" mr-5 col-12 mb-2 col-lg-3 col-md-3 col-sm-5 btn btn-success "  href="Renta.jsp"  >+ Agregar Renta</a>
                        <table border="1" width="1" cellspacing="1" class="table table-bordered">
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
                        while (iteratorRentas.hasNext()){
                           mostrarRentas = iteratorRentas.next();            
                    %>                     
                    <tbody>
                        <tr>
                            <td class="text-center">
                                <%=mostrarRentas.getID_RENTA() %>
                            </td>
                                
                            <td class="text-center">
                                <%=mostrarRentas.getSERIE() %> 
                            </td>
                            <td class="text-center">
                               <%=mostrarRentas.getNombre() %> 
                            </td> 
                              <td class="text-center">
                                <%=mostrarRentas.getDescripcion() %>
                              </td>
                              <td class="text-center">
                                 <%=mostrarRentas.getFECHA_PRESTAMO() %> 
                              </td>
                              <td class="text-center">
                                 <%=mostrarRentas.getFECHA_DEVOLUCION() %> 
                              </td>
                              <td class="text-center">
                                 <%=mostrarRentas.getTotal() %> 
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
