<%-- 
    Document   : registrarDevolucion
    Created on : may 26, 2022, 11:36:20 p.m.
    Author     : INSPIRON 7000 SERIES
--%>

<%@page import="org.models.ModelRenta"%>
<%@page import="org.dao.DaoRenta"%>
<%@page import="org.models.Modelvehiculo"%>
<%@page import="org.models.ModelUser"%>
<%@page import="org.dao.DaoUser"%>
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
                        <h1 class="mt-5">Registrar Devolucion</h1>
                        <form id="form-work" class=""  action="ControllerDevolucion" method="get"></form>
                        <form class="container col-10 col-md-10 col-lg-10" class="row g-3" action="ControllerDevolucion" method="get">
                             <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Renta</label>
                                 <select name="id_renta" class="custom-select custom-select-sm">
                     <%
                                    DaoRenta daorenta = new DaoRenta();
                                    List<ModelRenta> lstrenta = daorenta.MostrarRentas();
                                    Iterator<ModelRenta> iteratorRenta = lstrenta.iterator(); 
                                    ModelRenta mostrarRenta = null;
                                  
                                    while (iteratorRenta.hasNext()){
                                            mostrarRenta = iteratorRenta.next(); 
                                %>
                    <option value="<%= mostrarRenta.getID_RENTA() %>">#<%= mostrarRenta.getID_RENTA()  %>--CLIENTE:  <%= mostrarRenta.getNombre()  %></option>
                     <%}%>
                </select>
                               
                            </div>
                            
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Serie </label>
                               
                                  <select name="serie" class="form-control">
                                        <option value="A">A</option>
                                        <option value="B">B</option>
                                    </select><br>
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Fecha </label>
                                <input type="date" name="fecha" class="form-control" id="inputPassword2" placeholder="" >
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Observaciones </label>
                                <input type="text" name="observaciones" class="form-control" id="inputPassword2" placeholder="" >
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Usuario</label>
                                 <select name="id_usuario" class="custom-select custom-select-sm">
                     <%
                                    DaoUser daouser = new DaoUser();
                                    List<ModelUser> lstuser = daouser.listar();
                                    Iterator<ModelUser> iteratorUser = lstuser.iterator(); 
                                    ModelUser mostrarUser = null;
                                  
                                    while (iteratorUser.hasNext()){
                                            mostrarUser = iteratorUser.next(); 
                                %>
                    <option value="<%= mostrarUser.getIdUsuario()%>"><%= mostrarUser.getNombre() %></option>
                     <%}%>
                </select>
                               
                            </div>
                 <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Dias de atraso </label>
                                <input type="text" name="dias_atraso" class="form-control" id="inputPassword2" placeholder="" >
                            </div>
                 <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Vehiculo</label>
                                 <select name="id_vehiculo" class="custom-select custom-select-sm">
                     <%
                                    DaoVehiculos daovehiculo = new DaoVehiculos();
                                    List<Modelvehiculo> lstvehiculo = daovehiculo.listarVehiculosRentados();
                                    Iterator<Modelvehiculo> iteratorVehiculo =  lstvehiculo.iterator();
                                    Modelvehiculo mostrarVehiculo = null;
                                  
                                  
                                    while (iteratorVehiculo.hasNext()){
                                            mostrarVehiculo = iteratorVehiculo.next(); 
                                %>
                    <option value="<%= mostrarVehiculo.getId_vehiculo() %>"><%= mostrarVehiculo.getModelo() %> ID: <%= mostrarVehiculo.getId_vehiculo() %> MARCA: <%= mostrarVehiculo.getMarca() %> </option>
                     <%}%>
                </select>
                               
                            </div>
                          
                            
                                                  
                            <button type="submit" name="accion" value="ingresar" class="btn btn-primary mb-2" >Registrar Devolución</button>
                           
                      </form>
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>