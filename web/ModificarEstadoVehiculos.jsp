<%-- 
    Document   : updateRolls
    Created on : may 12, 2022, 3:18:31 p.m.
    Author     : INSPIRON 7000 SERIES
--%>

<%@page import="org.models.Modelvehiculo"%>
<%@page import="org.models.ModelEstado"%>
<%@page import="org.models.ModelTipo_Vehiculo"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.ModelMarca"%>
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
                        <h1 class="mt-5">Actualizar Vehiculos</h1>
                         
                        <form class="container col-10 col-md-10 col-lg-10" class="row g-3" action="ControllerVehiculo" method="get">
                             <%
                          
                         DaoVehiculos daoVehiculo = new DaoVehiculos();
                          int idVehiculo = Integer.parseInt((String) request.getAttribute("idVehiculo"));
                          Modelvehiculo vehiculo = new Modelvehiculo();
                          vehiculo = daoVehiculo.list(idVehiculo);
                         
                         
                      %>
                            <input type="hidden" name="id_vehiculo" value="<%=vehiculo.getId_vehiculo() %>">
                            <div class="form-group mx-sm-3 mb-2">
                                <input type="text" readonly="readonly" value="<%=vehiculo.getMarca() %>" class="form-control" id="inputPassword2">
                               
                                </select>
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <input type="text" readonly="readonly" value="<%=vehiculo.getTipo_de_vehiculo() %>" class="form-control" id="inputPassword2">
                                
                                </select>
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                               
                                <select name="id_vehiculo_estado" class="form-control" id="inputPassword2">
                                    <%
                                        DaoVehiculos daoEstado = new DaoVehiculos();
                                        List<ModelEstado> lstEstado = daoEstado.listarEstado();
                                        Iterator<ModelEstado> iteratorEstado = lstEstado.iterator();
                                        ModelEstado mostrarEstado = null;
                                        while (iteratorEstado.hasNext()){
                                               mostrarEstado = iteratorEstado.next(); 
                                    %>
                                    <option value="<%=mostrarEstado.getId_vehiculo_estado() %>"><%=mostrarEstado.getDescripcion() %></option>
                                   <%}%>
                                </select>
                            </div>
                            
                            <div class="form-group mx-sm-3 mb-2">
                                <input type="text"  readonly="readonly" value="<%=vehiculo.getModelo() %>" class="form-control" id="inputPassword2" placeholder="Modelo">
                                
                            </div>
                             
                            <button type="submit" name="accion" value="updateEstado" class="btn btn-primary mb-2" >Actualizar</button>
                            <a class="btn btn-primary mb-2" href="ControllerVehiculo?accion=read2"  > Regresar</a>
                      </form>
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>