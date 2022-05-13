<%-- 
    Document   : updateRolls
    Created on : may 12, 2022, 3:18:31 p.m.
    Author     : INSPIRON 7000 SERIES
--%>

<%@page import="org.models.ModelRoll"%>
<%@page import="org.dao.DaoRoll"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Layout/layout.jsp"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="col-md-12" >

        <div id="layoutSidenav_content">
             <h1 class="mt-5">Actualizar Rol</h1> <h1 class="mt-5">Actualizar Rol</h1>
            <main >

                <div class="container-fluid px-4 row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-10 ">
                        <br>
                        <h1 class="mt-5">Actualizar Rol</h1>
                         
                        <form class="container col-10 col-md-10 col-lg-10" class="row g-3" action="RollController" method="get">
                             <%
                          
                          DaoRoll daoRoll = new DaoRoll();
                          int idRoll = Integer.parseInt((String) request.getAttribute("idRoll"));
                          ModelRoll roll = new ModelRoll();
                          roll = daoRoll.list(idRoll);
                         
                      %>
                            <input type="hidden" name="idrol" value="<%= roll.getIdRol() %>">
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Nombre</label>
                                <input type="text" value="<%= roll.getNombre()%>" name="nombre" class="form-control" id="inputPassword2" >
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Descripción</label>
                                <input type="text" value="<%= roll.getDescripcion()%>" name="descripcion" class="form-control" id="inputPassword2" >
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Estado</label>
                                <input type="text" value="<%= roll.getActivo()%>" name="estado" class="form-control" id="inputPassword2" >
                            </div>
                            
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Usuario creador</label>
                                <input type="text" value="<%= roll.getUCreador()%>" name="Ucreador" class="form-control" id="inputPassword2" placeholder="Usuario creador">
                            </div>
                             <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Usuario Mod</label>
                                <input type="text" value="<%= roll.getUMod()%>" name="Umod" class="form-control" id="inputPassword2" placeholder="Usuario Mod">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Fecha creación</label>
                                <input type="date" value="<%= roll.getFechaCrea()%>" name="fcreacion" class="form-control" id="inputPassword2" placeholder="Fecha creación">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Fecha Mod</label>
                                <input type="date" value="<%= roll.getFechaMod()%>" name="fmod" class="form-control" id="inputPassword2" placeholder="Fecha Mod">
                            </div>                        
                            <button type="submit" name="accion" value="update" class="btn btn-primary mb-2" >Actualizar</button>
                            <a class="btn btn-primary mb-2" href="RollController?accion=read"  > Regresar</a>
                      </form>
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>
