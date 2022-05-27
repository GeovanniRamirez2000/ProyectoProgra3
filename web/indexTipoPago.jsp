<%-- 
    Document   : indexTipoPago
    Created on : 26/05/2022, 11:15:34 PM
    Author     : GEOVARU
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Layout/layout.jsp"/>
<%@page import="java.util.Iterator"%>
<%@page import="org.models.ModelTipoPago"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoTipoPago"%>
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
                        <h1 class="mt-5">Tipo de Pago</h1>
                        <br />
                        <a class=" mr-5 col-12 mb-2 col-lg-3 col-md-3 col-sm-5 btn btn-info "  href="TipoPagoController?accion=create"  >Crear</a>
                        <br />
                        <table border="1" width="1" cellspacing="1" class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="text-center">Codigo</th>
                                    <th class="text-center">Descripcion</th> 
                                    <th class="text-center">Acciones</th>

                                </tr>
                            </thead>
                            <tbody>

                                <%

                                    DaoTipoPago infoDao = new DaoTipoPago();
                                    List<ModelTipoPago> lstModel = infoDao.listar();
                                    Iterator<ModelTipoPago> infoIterator = lstModel.iterator();
                                    ModelTipoPago info = null;

                                    while (infoIterator.hasNext()) {
                                        info = infoIterator.next();
                                %>   

                                <tr>
                                    <td class="text-center"><%= info.getIdTipoPago()%></td>
                                    <td class="text-center"><%= info.getDescripcion()%></td>
                                    <td class="text-center"> 
                                        <a class="btn btn-info" href="TipoPagoController?accion=editar&idTipoPago=<%=info.getIdTipoPago()%>">Editar</a>
                                        <a class="btn btn-danger" href="TipoPagoController?accion=delete&idTipoPago=<%=info.getIdTipoPago()%>">Eliminar</a>
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

