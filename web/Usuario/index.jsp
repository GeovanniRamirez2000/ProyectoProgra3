<%-- 
    Document   : index
    Created on : 5/05/2022, 08:20:18 PM
    Author     : GEOVARU
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../Layout/layout.jsp"/>
<%@page import="java.util.List"%>
<%@page import="wsUser.ModelUser"%>
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
                        <a class=" mr-5 col-12 mb-2 col-lg-3 col-md-3 col-sm-5 btn btn-info "  href="UserController?accion=create"  >Crear</a>
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

                                    try {
                                        wsUser.ServicioUser_Service service = new wsUser.ServicioUser_Service();
                                        wsUser.ServicioUser port = service.getServicioUserPort();
                                        // TODO process result here
                                        List<wsUser.ModelUser> result = port.getUsuarios();
                                        for (wsUser.ModelUser info : result) {
                                %>  

                                <tr>
                                    <td class="text-center"><%= info.getIdUsuario()%></td>
                                    <td class="text-center"><%= info.getNombre()%> <%= info.getApellido()%></td>
                                    <td class="text-center"><%= info.getUsuario()%></td>
                                    <td class="text-center"><%= info.getPassword()%></td>
                                    <td class="text-center"><%= info.getDescRol()%></td>
                                    <td class="text-center"><%= info.getFechaCrea()%></td>
                                    <td class="text-center"><%= info.getFechaMod()%></td>
                                    <td class="text-center"> 
                                        <a class="btn btn-info" href="UserController?accion=editar&idUsuario=<%=info.getIdUsuario()%>">Editar</a>
                                        <a class="btn btn-danger" href="UserController?accion=delete&idUsuario=<%=info.getIdUsuario()%>">Eliminar</a>
                                    </td>
                                </tr>
                                <%
                                        }
                                    } catch (Exception ex) {
                                        // TODO handle custom exceptions here
                                    }
                                %> 
                            </tbody>
                        </table>


                    </div>
                </div>
            </main>
        </div>
    </body>
</html>

