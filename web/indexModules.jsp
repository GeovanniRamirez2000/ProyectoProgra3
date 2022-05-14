<%-- 
    Document   : indexModules
    Created on : 13/05/2022, 06:13:38 PM
    Author     : MSarazua
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.ModuleModel"%>
<%@page import="org.dao.DaoModule"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Layout/layout.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Módulos</title>
    </head>
    <body class="col-md-12">
        <div id="layoutSidenav_content">
            <main>
                <div class="col-md-2"></div>
                    <div class="container-fluid px-4 row"> 
                        <div class="col-md-10" style="margin-left: 15%">
                        <br>
                        <h1 class="mt-5">Módulos</h1>
                        <br />
                        <table border="1" width="1" cellspacing="1" class="table table-bordered">
                            <thead>
                              <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Descripción</th>
                                <th scope="col">Path</th>
                                <th scope="col">Nivel</th>
                                <th scope="col">Módulo padre</th>
                                <th scope="col">Fecha creación</th>
                                <th scope="col">Fecha Mod.</th>
                                <th scope="col">Usuario Creador</th>
                                <th scope="col">Usuario Mod.</th>
                                <th scope="col">Estado</th>
                                <th scope="col">Acciones</th>
                              </tr>
                            </thead>
                            <tbody>

                                <%
                                    String estado = "";
                                    String nivel = "";
                                    DaoModule daoModule = new DaoModule();
                                    List<ModuleModel> lstModulos = daoModule.listar();
                                    Iterator<ModuleModel> iteratorCliente = lstModulos.iterator();
                                    ModuleModel module = null;
                                    while (iteratorCliente.hasNext()){
                                    module = iteratorCliente.next();
                                    if(module.getEstado() == 1){
                                        estado = "ACTIVO";
                                    }else{
                                        estado = "INACTIVO";
                                    }
                                    if(module.getNivel() == "1"){
                                        nivel = "PADRE";
                                    }else if(module.getNivel() == "2"){
                                        nivel = "HIJO";
                                    }
                                %>
                                <tr>
                                    <td><%= module.getIdModulo()%></td>
                                    <td><%= module.getNombre()%></td>
                                    <td><%= module.getDescripcion()%></td>
                                    <td><%= module.getPath()%></td>
                                    <td><%= module.getNivel() %></td>
                                    <td><%= module.getIdModPadre()%></td>
                                    <td><%= module.getFechaCreacion()%></td>
                                    <td><%= module.getFechaMod()%></td>
                                    <td><%= module.getUCreador()%></td>
                                    <td><%= module.getUMod()%></td>
                                    <td><%= estado %></td>
                                    <td class="text-center">                                
                                        <a href="ModuleController?accion=editar&id=<%=module.getIdModulo()%>"><img style="width: 50%" src="editar.png"></a>
                                    </td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                            <a type="submit" href="createModules.jsp" class="btn btn-success btn-lg btn-block info">Agregar</a>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
