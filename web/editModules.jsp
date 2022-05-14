<%-- 
    Document   : editModules
    Created on : 13/05/2022, 08:09:26 PM
    Author     : MSarazua
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.ModuleModel"%>
<%@page import="org.dao.DaoModule"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Layout/layout.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar módulo</title>
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
                        <form class="container col-10 col-md-10 col-lg-10" class="row g-3" action="ModuleController" method="get">
                            <%
                                DaoModule daoModule = new DaoModule();
                                //Variable que nos envian desde el controller por medio de la instrucción setAttribute
                                int idModulo = Integer.parseInt((String) request.getAttribute("idModulo"));
                                ModuleModel module = new ModuleModel();
                                module = daoModule.list(idModulo);
                            %>
                            <input type="hidden" name="codigo" value="<%= module.getIdModulo()%>">
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Nombre</label>
                                <input type="text" name="nombre" class="form-control" value="<%= module.getNombre()%>" id="inputPassword2" placeholder="Nombre">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Descripción</label>
                                <input type="text" name="descripcion" class="form-control" value="<%= module.getDescripcion()%>" id="inputPassword2" placeholder="Descripción">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Path</label>
                                <input type="text" name="path" class="form-control" value="<%= module.getPath()%>" id="inputPassword2" placeholder="Path">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Nivel</label>
                                <select name="nivel" class="custom-select custom-select-sm">
                                    <option selected value="<%= module.getIdModPadre()%>"><%= module.getIdModPadre()%></option>
                                    <option value="1">Mod. Padre</option>
                                    <option value="2">Mod. Hijo</option>
                                </select>
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Módulo padre</label>
                                <select name="modpadre" class="custom-select custom-select-sm">
                                    <option selected>Seleccionar módulo padre</option>
                                    <option value = "0">Establecer como padre</option>
                                    <%
                                        List<ModuleModel> lstModulos = daoModule.listarMenu();
                                        Iterator<ModuleModel> iteratorCliente = lstModulos.iterator();
                                        module = null;
                                        while (iteratorCliente.hasNext()){
                                        module = iteratorCliente.next();
                                    %>
                                    <option selected="" value="<%= module.getIdModPadre()%>"><%= module.getNombre()%></option>
                                    <%}%>
                                </select>
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Fecha creación</label>
                                <input type="date" name="fcreacion" value="" class="form-control" id="inputPassword2" placeholder="Fecha creación">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Fecha Mod</label>
                                <input type="date" name="fmod" class="form-control" value="" id="inputPassword2" placeholder="Fecha Mod">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Usuario creador</label>
                                <input type="text" name="Ucreador" class="form-control" value="<%= module.getUCreador()%>" id="inputPassword2" placeholder="Usuario creador">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Usuario Mod</label>
                                <input type="text" name="Umod" class="form-control" value="<%= module.getUMod()%>" id="inputPassword2" placeholder="Usuario Mod">
                            </div>
                            <div class="form-group mx-sm-3 mb-2">
                                <label class="mr-5">Estado</label>
                                <select name="estado" class="custom-select custom-select-sm">
                                    <option selected value="<%= module.getEstado()%>"><%= module.getEstado()%></option>
                                    <option value="1">Activo</option>
                                    <option value="0">Inactivo</option>
                                </select>
                            </div>
                            <button type="submit" name="accion" value="update" class="btn btn-success btn-lg btn-block info">Actualizar</button>
                      </form>
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>
