<%-- 
    Document   : createModules
    Created on : 11/05/2022, 08:22:14 PM
    Author     : MSarazua
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
                        <h1 class="mt-5">Crear módulos</h1>
                        <form class="container col-10 col-md-10 col-lg-10" class="row g-3" action="ModuleController" method="get">
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Nombre</label>
                                <input type="text" name="nombre" class="form-control" id="inputPassword2" placeholder="Nombre">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Descripción</label>
                                <input type="text" name="descripcion" class="form-control" id="inputPassword2" placeholder="Descripción">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Path</label>
                                <input type="text" name="path" class="form-control" id="inputPassword2" placeholder="Path">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Nivel</label>
                                <input type="text" name="nivel" class="form-control" id="inputPassword2" placeholder="Nivel">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Módulo padre</label>
                                <input type="text" name="modpadre" class="form-control" id="inputPassword2" placeholder="Módulo padre">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Fecha creación</label>
                                <input type="date" name="fcreacion" class="form-control" id="inputPassword2" placeholder="Fecha creación">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Fecha Mod</label>
                                <input type="date" name="fmod" class="form-control" id="inputPassword2" placeholder="Fecha Mod">
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
                                <label class="mr-5">Estado</label>
                                <select name="estado" class="custom-select custom-select-sm">
                                    <option selected>Seleccionar opción</option>
                                    <option value="1">Activo</option>
                                    <option value="0">Inactivo</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary mb-2">Guardar</button>
                      </form>
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>
