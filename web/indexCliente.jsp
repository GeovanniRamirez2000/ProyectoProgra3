<%-- 
    Document   : index
    Created on : 5/05/2022, 08:20:18 PM
    Author     : GEOVARU
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Layout/layout.jsp"/>
<%@page import="java.util.Iterator"%>
<%@page import="org.models.ModelCliente"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoCliente"%>
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
                        <h1 class="mt-5">Usuario</h1>
                        <br />
                        <a class=" mr-5 col-12 mb-2 col-lg-3 col-md-3 col-sm-5 btn btn-info "  href="ClienteController?accion=create"  >Crear</a>
                        <br />
                        <table border="1" width="1" cellspacing="1" class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="text-center">Id</th>
                                    <th class="text-center">Nombre</th>
                                    <th class="text-center">Usuario</th>
                                    <th class="text-center">Pass</th>
                                    <th class="text-center">Rol</th>
                                    <th class="text-center">Fecha creacion</th>
                                    <th class="text-center">Fecha Actualizacion</th>
                                    <th class="text-center">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>

                                <%

                                    DaoCliente infoDao = new DaoCliente();
                                    List<ModelCliente> lstModel = infoDao.listar();
                                    Iterator<ModelCliente> iteratorRoll = lstModel.iterator();
                                    ModelCliente info = null;

                                    while (iteratorRoll.hasNext()) {
                                        info = iteratorRoll.next();
                                %>   

                                <tr>
                                    <td class="text-center"><%= info.getIdCliente()%></td>
                                    <td class="text-center"><%= info.getNit()%> <%= info.getApellido()%></td>
                                    <td class="text-center"><%= info.getNombre()%></td>
                                    <td class="text-center"><%= info.getApellido()%></td>
                                    <td class="text-center"><%= info.getTelefono()%></td>
                                    <td class="text-center"><%= info.getDireccion()%></td>
                                    <td class="text-center"> 
                                        <a class="btn btn-info" href="ClienteController?accion=editar&idCliente=<%=info.getIdCliente()%>">Editar</a>
                                        <a class="btn btn-danger" href="ClienteController?accion=delete&idCliente=<%=info.getIdCliente()%>">Eliminar</a>
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

