<%-- 
    Document   : createRolls
    Created on : may 12, 2022, 1:00:58 p.m.
    Author     : INSPIRON 7000 SERIES
--%>

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
                        <h1 class="mt-5">Crear Roles</h1>
                        <form id="form-work" class=""  action="ControllerCliente" method="get"></form>
                        <form class="container col-10 col-md-10 col-lg-10" class="row g-3" action="RollController" method="get">
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Nombre</label>
                                <input type="text" name="nombre" class="form-control" id="inputPassword2" placeholder="Nombre">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Descripción</label>
                                <input type="text" name="descripcion" class="form-control" id="inputPassword2" placeholder="Descripción">
                            </div>
                             <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Estado</label>
                                <select name="estado" class="custom-select custom-select-sm">
                                    <option selected>Seleccionar opción</option>
                                    <option value="1">Activo</option>
                                    <option value="0">Inactivo</option>
                                </select>
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Usuario creador</label>
                                <input type="text" name="Ucreador" class="form-control" id="inputPassword2" placeholder="Usuario creador">
                            </div>
                             <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Usuario Mod</label>
                                <input type="text" name="Umod" class="form-control" id="inputPassword2" placeholder="Usuario Mod">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Fecha creación</label>
                                <input type="date" name="fcreacion" class="form-control" id="inputPassword2" placeholder="Fecha creación">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Fecha Mod</label>
                                <input type="date" name="fmod" class="form-control" id="inputPassword2" placeholder="Fecha Mod">
                            </div>                        
                            <button type="submit" name="accion" value="create" class="btn btn-primary mb-2" >Agregar Roll</button>
                           
                      </form>
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>

