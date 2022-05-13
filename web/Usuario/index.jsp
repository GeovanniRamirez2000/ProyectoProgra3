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



                        <table border="1" width="1" cellspacing="1" class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="text-center">Id</th>
                                    <th class="text-center">Nombre</th>
                                    <th class="text-center">Nit</th>
                                    <th class="text-center">Telefono</th>
                                    <th class="text-center">Direccion</th>
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
                                    <td class="text-center"><%= info.getFechaCrea()%></td>
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

