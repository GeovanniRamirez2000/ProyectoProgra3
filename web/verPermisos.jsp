<%-- 
    Document   : createModules
    Created on : 11/05/2022, 08:22:14 PM
    Author     : MSarazua
--%>

<%@page import="org.models.ModelPermisos"%>
<%@page import="org.dao.DaoPermiso"%>
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
                        <center><h1 class="mt-5">Modificar permisos</h1></center>
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
                   
                   
                    <%
                             DaoPermiso daoPermiso = new DaoPermiso();
                                    List<ModelPermisos> lstModulos2 = daoPermiso.listar();
                                    Iterator<ModelPermisos> iteratorpermiso = lstModulos2.iterator();
                                    ModelPermisos mostrarpermiso = null;
                                    while (iteratorpermiso.hasNext()){
                                           mostrarpermiso = iteratorpermiso.next();                  
                    %>                     
                    <tbody>
                        <tr>
                            <td class="text-center" name="id"><%= mostrarpermiso.getId_permiso() %></td>
                            <td class="text-center">
                                <select name="modulo">
                                
                                <option value="<%=mostrarpermiso.getId_permiso()%>"><%= mostrarpermiso.getId_modulo() %></option>
                                
                                
                                </select>
                            </td>
                            <td class="text-center">
                                <select name="rol">
                              
                                <option value="<%= mostrarpermiso.getId_permiso() %>"><%= mostrarpermiso.getDescrol() %></option>
                                
                                </select>
                            </td> 
                              <td class="text-center">
                                  <input type="date" name="fecha_crea" value="<%=mostrarpermiso.getFechaCrea()%>">
                              </td>
                              <td class="text-center">
                                  <input type="date" name="fecha_mod" value="<%=mostrarpermiso.getFechaMod()%>">
                              </td>
                              <td class="text-center">
                                  <input type="text" name="usuario_crea" value="<%=mostrarpermiso.getUsuarioCrea()%>">
                              </td>
                              <td class="text-center">
                                  <input type="text" name="usuario_mod" value="<%=mostrarpermiso.getUsuarioMod()%>">
                              </td>
                            <td class="text-center">
                                <select name="estado">
                                    <option value="<%=mostrarpermiso.getId_permiso()%>"><%=mostrarpermiso.getActivo()%></option>
                                    <!--<option value="<%=mostrarpermiso.getActivo()%>">Activo</option>-->
                                </select>
                            </td>
                             <td class="text-center">
                                 <a href="editarPermisos.jsp">editar</a>
                                 <a href="PermisosController?accion=eliminar&id=<%= mostrarpermiso.getId_permiso() %>">Eliminar</a>
                             </td>
                        </tr>
                        <%}%><br><br><br>
                    </tbody>
                </table>                 
                        <a href="Permisos.jsp">Regresar</a>
                      </form>
                    <h1>hola</h1>
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>
