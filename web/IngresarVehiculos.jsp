<%-- 
    Document   : IngresarVehiculos
    Created on : may 26, 2022, 6:15:47 p.m.
    Author     : INSPIRON 7000 SERIES
--%>


<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

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
                        <h1 class="mt-5">Ingresar Vehiculos</h1>
                        <form id="form-work" class=""  action="ControllerVehiculo" method="get"></form>
                        <form class="container col-10 col-md-10 col-lg-10" class="row g-3" action="ControllerVehiculo" method="get">
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Marca</label>
                                 <select name="id_marca" class="custom-select custom-select-sm">
                    <%
                                    DaoVehiculos daomarca = new DaoVehiculos();
                                    List<ModelMarca> lstmarca = daomarca.listarMarca();
                                    Iterator<ModelMarca> iteratorMarca2 = lstmarca.iterator();
                                    ModelMarca mostrarMarca = null;
                                    while (iteratorMarca2.hasNext()){
                                           mostrarMarca = iteratorMarca2.next(); 
                                %>
                    <option value="<%=mostrarMarca.getId_marca()%>"><%=mostrarMarca.getDescripcion()%></option>
                     <%}%>
                </select>
                               
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Tipo de Vehiculo</label>
                                <select name="id_tipo_vehiculo" class="custom-select custom-select-sm">
                     <%
                                    DaoVehiculos daotipoVe = new DaoVehiculos();
                                    List<ModelTipo_Vehiculo> lstTipo = daotipoVe.listarTipo_V();
                                    Iterator<ModelTipo_Vehiculo> iteratorTipoVe2 = lstTipo.iterator();
                                    ModelTipo_Vehiculo mostrarTipoVehiculo = null;
                                    while (iteratorTipoVe2.hasNext()){
                                           mostrarTipoVehiculo = iteratorTipoVe2.next(); 
                                %>
                    <option value="<%=mostrarTipoVehiculo.getId_tipo_vehiculo()%>"><%=mostrarTipoVehiculo.getDescripcion()%></option>
                    <%}%>
                </select>
                            </div>
                             <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Estado</label>
                               <select name="id_vehiculo_estado" class="custom-select custom-select-sm">
                     <%
                                    DaoVehiculos daoEstado = new DaoVehiculos();
                                    List<ModelEstado> lstEstado = daoEstado.listarEstado();
                                    Iterator<ModelEstado> iteratorEstado = lstEstado.iterator();
                                    ModelEstado mostrarEstado = null;
                                    while (iteratorEstado.hasNext()){
                                           mostrarEstado = iteratorEstado.next(); 
                                %>
                    <option value="<%=mostrarEstado.getId_vehiculo_estado()%>"><%=mostrarEstado.getDescripcion()%></option>
                    <%}%>
                </select>
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Modelo</label>
                                <input type="text" name="modelo" class="form-control" id="inputPassword2" placeholder="2022" value="${idmod}">
                            </div>
                                                  
                            <button type="submit" name="accion" value="ingresar" class="btn btn-primary mb-2" >Agregar Vehiculo</button>
                           
                      </form>
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>

