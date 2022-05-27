<%-- 
    Document   : editMarca
    Created on : 26/05/2022, 10:16:20 PM
    Author     : MSarazua
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.ModelMarca"%>
<%@page import="org.dao.DaoMarcas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Layout/layout.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Marca</title>
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
                        <form class="container col-10 col-md-10 col-lg-10" class="row g-3" action="MarcasController" method="get">
                            <%
                                DaoMarcas daoMarcas = new DaoMarcas();
                                //Variable que nos envian desde el controller por medio de la instrucción setAttribute
                                int idMarca = Integer.parseInt((String) request.getAttribute("idMarca"));
                                ModelMarca marca = new ModelMarca();
                                marca = daoMarcas.list(idMarca);
                            %>
                            <input type="hidden" name="codigo" value="<%= marca.getId_marca()%>">
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Descripción</label>
                                <input type="text" name="descripcion" class="form-control" value="<%= marca.getDescripcion()%>" id="inputPassword2" placeholder="Descripción">
                            </div>
                            <button type="submit" name="accion" value="update" class="btn btn-success btn-lg btn-block info">Actualizar</button>
                      </form>
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>
