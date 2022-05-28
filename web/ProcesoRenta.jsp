<%-- 
    Document   : Renta
    Created on : 26/05/2022, 07:19:46 PM
    Author     : josea
--%>

<%@page import="org.models.Modelvehiculo"%>
<%@page import="org.models.ModelEstado"%>
<%@page import="org.models.ModelTipo_Vehiculo"%>
<%@page import="org.dao.DaoVehiculos"%>
<%@page import="org.models.ModelUser"%>
<%@page import="org.models.ModelTipoPago"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.models.ModelCliente"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoRenta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Layout/layout.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <div class="row">
  <div class="col-sm-2">.col-sm-4</div>
  <div class="col-sm-10">
      <br><br>
        <h1>Proceso de renta</h1>
    <center>
      
    </center>
    <center><form class="container col-10 col-md-10 col-lg-10" action="ControllerRentas" method="get">
               <%
                          
                         DaoVehiculos daoVehiculo = new DaoVehiculos();
                          int idVehiculo = Integer.parseInt((String) request.getAttribute("idVehiculo"));
                          Modelvehiculo vehiculo = new Modelvehiculo();
                          vehiculo = daoVehiculo.list(idVehiculo);
                         
                         
                      %>
            Serie<br>
            <select name="serie" class="form-select">
                <option value="A">A</option>
                <option value="B">B</option>
            </select><br>
            
            Cliente<br>
            <select name="id_cliente" class="form-control">
                 <%
                                        DaoRenta daoRenta = new DaoRenta();
                                        List<ModelCliente> lstRenta = daoRenta.listarCliente();
                                        Iterator<ModelCliente> iteratorRenta = lstRenta.iterator();
                                        ModelCliente mostrarCliente = null;
                                        while (iteratorRenta.hasNext()){
                                               mostrarCliente = iteratorRenta.next(); 
                                    %>
                <option value="<%=mostrarCliente.getIdCliente() %>"><%=mostrarCliente.getNombre() %></option>
                <%}%>
            </select><br>
            Usuario<br>
             <select name="id_usuario" class="form-select">
                  <%
                                         
                                        DaoRenta daoUsuario = new DaoRenta();
                                        List<ModelUser> lstUsuario = daoUsuario.listar();
                                        Iterator<ModelUser> iteratorUsuario = lstUsuario.iterator();
                                        ModelUser mostrarUsuario = null;
                                        while (iteratorUsuario.hasNext()){
                                               mostrarUsuario = iteratorUsuario.next(); 
                                   
                                    %>
                <option value="<%=mostrarUsuario.getIdUsuario() %>"><%=mostrarUsuario.getNombre() %></option>
                <%}%>
             </select><br>
             Tipo pago<br>
             <select name="id_tipo_pago" class="form-select">
                 <%
                                        DaoRenta daoRenta2 = new DaoRenta();
                                        List<ModelTipoPago> lstRenta2 = daoRenta2.listarTipoPago();
                                        Iterator<ModelTipoPago> iteratorRenta2 = lstRenta2.iterator();
                                        ModelTipoPago mostrarTipoPago = null;
                                        while (iteratorRenta2.hasNext()){
                                               mostrarTipoPago = iteratorRenta2.next(); 
                                    %>
                <option value="<%=mostrarTipoPago.getIdTipoPago() %>"><%=mostrarTipoPago.getDescripcion() %></option>
               <%}%>
             </select><br>
             Fecha prestamo<br>
             <input type="date" name="fecha_prestamo" class="form-control"><br>
             Fecha devolucion<br>
             <input type="date" name="fecha_devolucion" class="form-control"><br>
               <p>Tipo de vehiculo</p>
                <select name="id_vehiculo" class="form-select">
                     
                    <option value="<%=vehiculo.getId_vehiculo() %>"><%=vehiculo.getMarca() %></option>
                    
                </select><br>
               
                <br>
                Precio de alquiler<br>
                <input type="text" name="precio_alquiler" class="form-control"><br>
                 Total<br>
             <input type="text" name="total" class="form-control"><br>
             <input class="btn btn-primary mb-2" type="submit" name="accion" value="ProcesoRenta">
            <a class="btn btn-primary mb-2" href="ControllerVehiculo?accion=regresar"> Regresar al inicio</a>
        </form></center>
        </div>
      </div>
    </body>
</html>
