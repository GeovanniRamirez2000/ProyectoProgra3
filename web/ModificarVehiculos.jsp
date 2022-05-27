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
                                Seleccione la nueva marca
                                <select name="id_marca" class="form-control" id="inputPassword2">
                                    <%
                                        
                                    DaoVehiculos daomarca = new DaoVehiculos();
                                    List<ModelMarca> lstmarca = daomarca.listarMarca();
                                    Iterator<ModelMarca> iteratorMarca2 = lstmarca.iterator();
                                    ModelMarca mostrarMarca = null;
                                    while (iteratorMarca2.hasNext()){
                                           mostrarMarca = iteratorMarca2.next(); 
                                    %>
                                    <option value="<%=mostrarMarca.getId_marca() %>"><%=mostrarMarca.getDescripcion() %></option>
                                   <%}%>
                                </select>
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <input type="text" readonly="readonly" value="<%=vehiculo.getTipo_de_vehiculo() %>" class="form-control" id="inputPassword2">
                                 Seleccione el nuevo estado del vehiculo
                                <select name="id_tipo_vehiculo" class="form-control" id="inputPassword2">
                                    <%
                                        DaoVehiculos daotipoVe = new DaoVehiculos();
                                    List<ModelTipo_Vehiculo> lstTipo = daotipoVe.listarTipo_V();
                                    Iterator<ModelTipo_Vehiculo> iteratorTipoVe2 = lstTipo.iterator();
                                    ModelTipo_Vehiculo mostrarTipoVehiculo = null;
                                    while (iteratorTipoVe2.hasNext()){
                                           mostrarTipoVehiculo = iteratorTipoVe2.next(); 
                                    %>
                                    <option value="<%=mostrarTipoVehiculo.getId_tipo_vehiculo() %>"><%=mostrarTipoVehiculo.getDescripcion() %></option>
                                   <%}%>
                                </select>
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <input type="text" readonly="readonly" value="<%=vehiculo.getEstado() %>" class="form-control" id="inputPassword2">
                                 Seleccione el nuevo estado
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
                                 <label class="mr-5">Ingrese el nuevo modelo</label>
                                 <input type="text" name="modelo" class="form-control" id="inputPassword2" placeholder="Nuevo modelo">
                            </div>
                             
                            <button type="submit" name="accion" value="update" class="btn btn-primary mb-2" >Actualizar</button>
                            <a class="btn btn-primary mb-2" href="ControllerVehiculo?accion=read"  > Regresar</a>
                      </form>
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>