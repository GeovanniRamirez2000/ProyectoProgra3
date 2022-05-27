<%-- 
    Document   : show
    Created on : 12/05/2022, 05:16:58 PM
    Author     : GEOVARU
--%>


<%@page import="org.models.ModelCliente"%>
<%@page import="org.models.ModelRoll"%>
<%@page import="org.dao.DaoCliente"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
                        <h1 class="mt-5">Actualizar Usuario</h1>

                        <form class="container row col-12" action="ClienteController" method="get">
                            <%
                                DaoCliente infoDao = new DaoCliente();
                                int idUser = Integer.parseInt((String) request.getAttribute("idCliente"));
                                ModelCliente cliList = new ModelCliente();
                                cliList = infoDao.list(idUser);

                            %>
                            <input type="hidden" name="idCliente" value="<%= cliList.getIdCliente()%>">
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Nit</label>
                                <input type="text" value="<%= cliList.getNit()%>" name="nit" class="form-control" id="nit" placeholder="nit">
                            </div>
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Nombre</label>
                                <input type="text" value="<%= cliList.getNombre()%>" name="nombre" class="form-control" id="nombre" >
                            </div>
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Apellido</label>
                                <input type="text" value="<%= cliList.getApellido()%>" name="apellido" class="form-control" id="apellido" >
                            </div>

                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Telefono</label>
                                <input type="text" value="<%= cliList.getTelefono()%>" name="telefono" class="form-control" id="telefono" placeholder="telefono">
                            </div>
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Direccion</label>
                                <input type="text" value="<%= cliList.getDireccion()%>" name="direccion" class="form-control" id="direccion" placeholder="direccion">
                            </div>

                            <div class="col-12">
                            </div>   

                            <button type="submit" name="accion" value="update" class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5 btn btn-primary " >Actualizar</button>

                            <a class=" mr-5 col-12 mb-2 col-lg-3 col-md-3 col-sm-5 btn btn-secondary "  href="ClienteController?accion=read"  > Regresar</a>

                        </form>
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>

