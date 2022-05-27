<%-- 
    Document   : IngresarMarca
    Created on : 26/05/2022, 09:08:52 PM
    Author     : MSarazua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Layout/layout.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar Marcas</title>
    </head>
    <body class="col-md-12" >

        <div id="layoutSidenav_content">
            <main >
                <div class="container-fluid px-4 row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-10 ">
                        <br>
                        <h1 class="mt-5">Crear Marcas</h1>
                        <form id="form-work" class=""  action="ControllerCliente" method="get"></form>
                        <form class="container col-10 col-md-10 col-lg-10" class="row g-3" action="MarcasController" method="get">
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Descripción</label>
                                <input type="text" name="descripcion" class="form-control" id="inputPassword2" placeholder="Descripción">
                            </div>
                            <button type="submit" name="accion" value="create" class="btn btn-primary mb-2" >Agregar Marca</button>
                      </form>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
