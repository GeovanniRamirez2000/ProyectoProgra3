
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
                        <h1 class="mt-5">Cambiar Estado de Vehiculos Manualmente</h1>
                        <table table border="1" width="1" cellspacing="1" class="table table-bordered">
                            <br />
                        <a class=" mr-5 col-12 mb-2 col-lg-3 col-md-3 col-sm-5 btn btn-success "  href="IngresarVehiculos.jsp"  >+ Agregar Vehiculo</a>
                        <br />
                    <thead>
                        <tr>
                            <th class="text-center">ID_VEHICULO</th>
                            <th class="text-center">MARCA</th>
                            <th class="text-center">TIPO DE VEHICULO</th>
                            <th class="text-center">ESTADO DEL VEHICULO</th>
                            <th class="text-center">MODELO</th>
                            <th class="text-center">OPCION</th>
                          
                        </tr>
                    </thead>
                  
                    <%
                        DaoVehiculos daoMostrar = new DaoVehiculos();
                        List<Modelvehiculo> lstEstado = daoMostrar.listarVehiculos();
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
                              <td class="text-center">
                                 <a href="ControllerVehiculo?accion=cambio&id=<%=mostrarVehiculos.getId_vehiculo()%>"><img style="width: 35%" src="editar.png"></a>
                                 
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
