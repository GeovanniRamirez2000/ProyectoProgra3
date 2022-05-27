<%-- 
    Document   : verTipoVeh
    Created on : 26/05/2022, 10:55:25 PM
    Author     : MSarazua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.ModelTipo_Vehiculo"%>
<%@page import="org.dao.DaoTipoVeh"%>
<jsp:include page="Layout/layout.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver tipos de vehículos</title>
    </head>
    <body class="col-md-12" >
        <div id="layoutSidenav_content">
            <main >
                <div class="container-fluid px-4 row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-10 ">
                        <br>
                        <h1 class="mt-5">Tipos de vehículos</h1>
                        <br />
                        <a class=" mr-5 col-12 mb-2 col-lg-3 col-md-3 col-sm-5 btn btn-success "  href="IngresarTipoVeh.jsp"  >+ Agregar</a>
                        <br />
                        <table border="1" width="1" cellspacing="1" class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="text-center">Id</th>
                                    <th class="text-center">Descripción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    DaoTipoVeh daoTipoVeh = new DaoTipoVeh();
                                    List<ModelTipo_Vehiculo> lstTipoVeh = daoTipoVeh.listar();
                                    Iterator<ModelTipo_Vehiculo> iteratorTipoVeh = lstTipoVeh.iterator();
                                    ModelTipo_Vehiculo tipo = null;
                                    while (iteratorTipoVeh.hasNext()){
                                        tipo = iteratorTipoVeh.next();           
                                    %>
                                    <tr style="text-align: center">
                                        <td><%= tipo.getId_tipo_vehiculo()%></td>
                                        <td><%= tipo.getDescripcion()%></td>
                                        <td class="text-center">                                
                                            <a href="TipoVehController?accion=editar&id=<%=tipo.getId_tipo_vehiculo()%>"><img style="width: 5%" src="editar.png"></a>
                                            <a href="TipoVehController?accion=delete&id=<%=tipo.getId_tipo_vehiculo()%>"><img style="width: 5%" src="trash.png"></a>
                                        </td>
                                    </tr>
                                    <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
