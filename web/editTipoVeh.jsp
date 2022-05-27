<%-- 
    Document   : editTipoVeh
    Created on : 26/05/2022, 11:23:08 PM
    Author     : MSarazua
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.ModelTipo_Vehiculo"%>
<%@page import="org.dao.DaoTipoVeh"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Layout/layout.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar tipo vehículo</title>
    </head>
    <body class="col-md-12" >

        <div id="layoutSidenav_content">
            <main >
                <div class="container-fluid px-4 row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-10 ">
                        <br>
                        <h1 class="mt-5">Modificar módulos</h1>
                        <form class="container col-10 col-md-10 col-lg-10" class="row g-3" action="TipoVehController" method="get">
                            <%
                                DaoTipoVeh daoTipoVeh = new DaoTipoVeh();
                                //Variable que nos envian desde el controller por medio de la instrucción setAttribute
                                int idTipo = Integer.parseInt((String) request.getAttribute("idTipo"));
                                ModelTipo_Vehiculo tipo = new ModelTipo_Vehiculo();
                                tipo = daoTipoVeh.list(idTipo);
                            %>
                            <input type="hidden" name="codigo" value="<%= tipo.getId_tipo_vehiculo()%>">
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Descripción</label>
                                <input type="text" name="descripcion" class="form-control" value="<%= tipo.getDescripcion()%>" id="inputPassword2" placeholder="Descripción">
                            </div>
                            <button type="submit" name="accion" value="update" class="btn btn-success btn-lg btn-block info">Actualizar</button>
                      </form>
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>
