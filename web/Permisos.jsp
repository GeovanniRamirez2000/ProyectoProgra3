<%-- 
    Document   : createModules
    Created on : 11/05/2022, 08:22:14 PM
    Author     : MSarazua
--%>

<%@page import="org.models.ModuleModel"%>
<%@page import="org.dao.DaoModule"%>
<%@page import="org.models.ModelRoll"%>
<%@page import="org.dao.DaoRoll"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.models.ModelRol"%>
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
                    <div class="col-md-1">
                    </div>
      <div class="col-md-8 ">
                        <br>
                        <center><h1 class="mt-5">Agregar permisos</h1></center>
                        <form class="container col-10 col-md-10 col-lg-10" class="row g-3" action="PermisosController" method="get">
                            <div class="form-group mx-sm-3 mb-2">   
      </div>
         
                    
                    <table border="1" width="1" cellspacing="1" class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="text-center">#</th>
                            <th class="text-center">MODULO</th>
                            <th class="text-center">ROL</th>
                            <th class="text-center">FECHA CREA</th>
                            <th class="text-center">FECHA MOD</th>
                            <th class="text-center">USUARIO_CREA</th>
                            <th class="text-center">USUARIO_MOD</th>
                            <th class="text-center">ACTIVO</th>
                             <th class="text-center">EDITAR</th>
                          
                        </tr>
                    </thead>
                   
                   
                        
                    <tbody>
                        <tr>
                            <td class="text-center">1</td>
                            <td class="text-center">
                                <select name="modulo">
                                <%
                                    DaoModule daomodulo2 = new DaoModule();
                                    List<ModuleModel> lstModulos2 = daomodulo2.listarMenu();
                                    Iterator<ModuleModel> iteratorModulo2 = lstModulos2.iterator();
                                    ModuleModel mostrarModulo = null;
                                    while (iteratorModulo2.hasNext()){
                                           mostrarModulo = iteratorModulo2.next(); 
                                %>
                                <option value="<%=mostrarModulo.getIdModulo()%>"><%=mostrarModulo.getNombre()%></option>
                                
                                <%}%>
                                </select>
                            </td>
                            <td class="text-center">
                                <select name="rol">
                                <%
                                    DaoRoll daoRolltabla = new DaoRoll();
                                    List<ModelRoll> lstRollmenu = daoRolltabla.listar();
                                    Iterator<ModelRoll> iteratorRoll2 = lstRollmenu.iterator();
                                    ModelRoll roll = null;
                                    while (iteratorRoll2.hasNext()){
                                    roll = iteratorRoll2.next(); 
                                %>
                                <option value="<%= roll.getIdRol() %>"><%=roll.getNombre()%></option>
                                <%}%> 
                                </select>
                            </td> 
                              <td class="text-center">
                                  <input type="date" name="fecha_crea">
                              </td>
                              <td class="text-center">
                                  <input type="date" name="fecha_mod">
                              </td>
                              <td class="text-center">
                                  <input type="text" name="usuario_crea">
                              </td>
                              <td class="text-center">
                                  <input type="text" name="usuario_mod">
                              </td>
                            <td class="text-center">
                                <select name="estado">
                                    <option value="0">Inactivo</option>
                                    <option value="1">Activo</option>
                                </select>
                            </td>
                             <td class="text-center">
                                 <a href="RollController?accion=editar&id=<%= roll.getIdRol() %>">Editar</a>
                                 <a href="RollController?accion=eliminar&id=<%= roll.getIdRol() %>">Eliminar</a>
                             </td>
                        </tr>
                        <br><br><br>
                    </tbody>
                </table>             
                        <input type="submit" name="accion" value="Agregar" class="btn btn-primary mb-2">
                        <a href="verPermisos.jsp">Ver permisos</a>
                      </form>
                    
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>
