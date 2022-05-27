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

                        <form class="container row col-12" action="UserController" method="get">

                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Nombre</label>
                                <input type="text" value="" name="nombre" class="form-control" id="inputPassword2" >
                            </div>
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Apellido</label>
                                <input type="text" value="" name="apellido" class="form-control" id="inputPassword2" >
                            </div>

                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Rol</label>
                                <select required="" name="idRol" class="form-control">
                                    <%
                                        DaoRoll daoTProducto = new DaoRoll();
                                        ModelRoll pr = null;
                                        List<ModelRoll> lstProducto = daoTProducto.listar();
                                        Iterator<ModelRoll> iteratorPr = lstProducto.iterator();
                                        while (iteratorPr.hasNext()) {
                                            pr = iteratorPr.next();
                                    %>
                                    <option value="<%=pr.getIdRol()%>" ><%=pr.getDescripcion()%></option>      
                                    <%
                                        }
                                    %>

                                </select>
                            </div>
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Estado</label>
                                <select name="activo" class="custom-select custom-select-sm">
                                    <option value="1" >Activo</option>
                                    <option value="0" >Inactivo</option>
                                </select>
                            </div>
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Usuario</label>
                                <input type="text" value="" name="usuario" class="form-control" id="inputPassword2" placeholder="Usuario creador">
                            </div>
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Password</label>
                                <input type="text" value="" name="password" class="form-control" id="inputPassword2" placeholder="Usuario creador">
                            </div>
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Usuario creador</label>
                                <input type="text" value="" name="usuarioCrea" class="form-control" id="inputPassword2" placeholder="Usuario creador">
                            </div>
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Usuario Mod</label>
                                <input type="text" value="" name="usuarioMod" class="form-control" id="inputPassword2" placeholder="Usuario Mod">
                            </div>
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Fecha creación</label>
                                <input type="date" value="" name="fechaCrea" class="form-control" id="inputPassword2" placeholder="Fecha creación">
                            </div>
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Fecha Mod</label>
                                <input type="date" value="" name="fechaMod" class="form-control" id="inputPassword2" placeholder="Fecha Mod">
                            </div>   
                            <div class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5">
                                <label class="mr-5">Codigo</label>
                                <input type="text" value="" name="codigo" class="form-control" id="inputPassword2" placeholder="Fecha Mod">
                            </div>   
                            <div class="col-12">
                            </div>   

                            <button type="submit" name="accion" value="store" class=" col-12 mb-2 col-lg-3 col-md-3 col-sm-5 btn btn-primary " >Crear</button>

                            <a class=" mr-5 col-12 mb-2 col-lg-3 col-md-3 col-sm-5 btn btn-secondary "  href="UserController?accion=read" >Regresar</a>

                        </form>
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>

