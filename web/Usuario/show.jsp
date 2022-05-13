<%-- 
    Document   : show
    Created on : 12/05/2022, 05:16:58 PM
    Author     : GEOVARU
--%>


<%@page import="org.models.ModelUser"%>
<%@page import="org.models.ModelRoll"%>
<%@page import="org.dao.DaoUser"%>
<%@page import="org.dao.DaoRoll"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../Layout/layout.jsp"/>
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
                        <h1 class="mt-5">Actualizar Usuario</h1>

                        <form class="container row" class="row g-3" action="UserController" method="get">
                            <%
                                DaoUser daoUser = new DaoUser();
                                int idUser = Integer.parseInt((String) request.getAttribute("idUsuario"));
                                ModelUser usua = new ModelUser();
                                usua = daoUser.list(idUser);

                            %>
                            <input type="hidden" name="IdUsuario" value="<%= usua.getIdUsuario()%>">
                            <div class="form-group mx-sm-3 mb-2  col-3">
                                <label class="mr-5">Nombre</label>
                                <input type="text" value="<%= usua.getNombre()%>" name="nombre" class="form-control" id="inputPassword2" >
                            </div>
                            <div class="form-group mx-sm-3 mb-2  col-3">
                                <label class="mr-5">Apellido</label>
                                <input type="text" value="<%= usua.getApellido()%>" name="apellido" class="form-control" id="inputPassword2" >
                            </div>

                            <div class="form-group mx-sm-3 mb-2  col-3">
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
                            <div class="form-group mx-sm-3 mb-2  col-3">
                                <label class="mr-5">Estado</label>
                                <select name="estado" class="custom-select custom-select-sm">
                                    <option value="1"  <%
                                        if (usua.getActivo() == 1) {
                                            %>selected   <%
                                                }
                                            %>>Activo</option>
                                    <option value="0"  <%
                                        if (usua.getActivo() == 0) {
                                            %>selected   <%
                                                }
                                            %>>Inactivo</option>
                                </select>
                            </div>


                            <div class="form-group mx-sm-3 mb-2  col-3">
                                <label class="mr-5">Usuario creador</label>
                                <input type="text" value="<%= usua.getUsuarioCrea()%>" name="Ucreador" class="form-control" id="inputPassword2" placeholder="Usuario creador">
                            </div>
                            <div class="form-group mx-sm-3 mb-2  col-3">
                                <label class="mr-5">Usuario Mod</label>
                                <input type="text" value="<%= usua.getUsuarioMod()%>" name="Umod" class="form-control" id="inputPassword2" placeholder="Usuario Mod">
                            </div>
                            <div class="form-group mx-sm-3 mb-2  col-3">
                                <label class="mr-5">Fecha creación</label>
                                <input type="date" value="<%= usua.getFechaCrea()%>" name="fcreacion" class="form-control" id="inputPassword2" placeholder="Fecha creación">
                            </div>
                            <div class="form-group mx-sm-3 mb-2  col-3">
                                <label class="mr-5">Fecha Mod</label>
                                <input type="date" value="<%= usua.getFechaMod()%>" name="fmod" class="form-control" id="inputPassword2" placeholder="Fecha Mod">
                            </div>   
                            <div class="col-12">
                            </div>   
                            <button type="submit" name="accion" value="update" class="btn btn-primary form-group mx-sm-3 mb-2  col-5" >Actualizar</button>
                            <a class="btn btn-primary form-group mx-sm-3 mb-2  col-5" href="UserController?accion=read"  > Regresar</a>
                        </form>
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>

