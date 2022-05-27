<%-- 
    Document   : verMarcas
    Created on : 26/05/2022, 09:10:53 PM
    Author     : MSarazua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.ModelMarca"%>
<%@page import="org.dao.DaoMarcas"%>
<jsp:include page="Layout/layout.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Marcas</title>
    </head>
    <body class="col-md-12" >
        <div id="layoutSidenav_content">
            <main >
                <div class="container-fluid px-4 row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-10 ">
                        <br>
                        <h1 class="mt-5">Marcas</h1>
                        <br />
                        <a class=" mr-5 col-12 mb-2 col-lg-3 col-md-3 col-sm-5 btn btn-success "  href="IngresarMarca.jsp"  >+ Agregar</a>
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
                                    DaoMarcas daoMarcas = new DaoMarcas();
                                    List<ModelMarca> lstMarcas = daoMarcas.listar();
                                    Iterator<ModelMarca> iteratorMarcas = lstMarcas.iterator();
                                    ModelMarca marca = null;
                                    while (iteratorMarcas.hasNext()){
                                        marca = iteratorMarcas.next();           
                                    %>
                                    <tr style="text-align: center">
                                        <td><%= marca.getId_marca()%></td>
                                        <td><%= marca.getDescripcion()%></td>
                                        <td class="text-center">                                
                                            <a href="MarcasController?accion=editar&id=<%=marca.getId_marca()%>"><img style="width: 5%" src="editar.png"></a>
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
