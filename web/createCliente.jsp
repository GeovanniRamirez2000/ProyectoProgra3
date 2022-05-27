<%-- 
    Document   : show
    Created on : 12/05/2022, 05:16:58 PM
    Author     : GEOVARU
--%>


<%@page import="org.models.ModelRoll"%>
<%@page import="org.dao.DaoRoll"%>
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
                        <h1 class="mt-5">Crear Usuario</h1>

                        <form class="container row col-12" action="ClienteController" method="get">
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Nit</label>
                                <input type="text" value="" name="nit" class="form-control" id="nit" placeholder="NIT">
                            </div>
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Nombre</label>
                                <input type="text" value="" name="nombre" class="form-control" id="nombre" >
                            </div>
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Apellido</label>
                                <input type="text" value="" name="apellido" class="form-control" id="apellido" >
                            </div>
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Telefono</label>
                                <input type="text" value="" name="telefono" class="form-control" id="telefono" placeholder="Telefono">
                            </div>
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Direccion</label>
                                <input type="text" value="" name="direccion" class="form-control" id="direccion" placeholder="Direccion">
                            </div>   
                            <div class="col-12">
                            </div>   
                            <button type="submit" name="accion" value="store" class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5 btn btn-primary " >Crear</button>
                            <a class=" mr-5 col-12 mb-2 col-lg-3 col-md-3 col-sm-5 btn btn-secondary "  href="ClienteController?accion=read" >Regresar</a>
                        </form>
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>

