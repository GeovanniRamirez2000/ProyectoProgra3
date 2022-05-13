<%-- 
    Document   : viewRolls
    Created on : may 12, 2022, 2:58:09 p.m.
    Author     : INSPIRON 7000 SERIES
--%>

<%@page import="java.util.Iterator"%>
<%@page import="org.models.ModelRoll"%>
<%@page import="java.util.List"%>
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
            <main >

                <div class="container-fluid px-4 row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-10 ">
                        <br>
                        <h1 class="mt-5">Crear Roles</h1>
                        <table border="1" width="1" cellspacing="1" class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="text-center">#</th>
                            <th class="text-center">NOMBRE</th>
                            <th class="text-center">DESCRIPCION</th>
                            <th class="text-center">ESTADO</th>
                            <th class="text-center">USUARIO CREA</th>
                            <th class="text-center">USUARIO MOD</th>
                            <th class="text-center">FECHA CREA</th>
                            <th class="text-center">FECHA MOD</th>
                             <th class="text-center">EDITAR</th>
                          
                        </tr>
                    </thead>
                  
                    <%
                        
                        
                        DaoRoll daoRoll = new DaoRoll();
                        List<ModelRoll> lstRoll = daoRoll.listar();
                        Iterator<ModelRoll> iteratorRoll = lstRoll.iterator();
                        ModelRoll roll = null;
                        
                        while (iteratorRoll.hasNext()){
                            roll = iteratorRoll.next();                        
                    %>                     
                    <tbody>
                        <tr>
                            <td class="text-center"><%= roll.getIdRol() %></td>
                             <td class="text-center"><%= roll.getNombre() %></td>
                              <td class="text-center"><%= roll.getDescripcion() %></td> 
                             <td class="text-center"><%= roll.getActivo() %></td>
                              <td class="text-center"><%= roll.getUCreador() %></td>
                              <td class="text-center"><%= roll.getUMod() %></td>
                            <td class="text-center"><%= roll.getFechaCrea() %></td>
                            <td class="text-center"><%= roll.getFechaMod() %></td>
                             <td class="text-center"> <a href="RollController?accion=editar&id=<%= roll.getIdRol() %>">Editar</a></td>
                             
                               
                            
                          
                         
                        </tr>
                        <%}%>
                    
                       
<br><br>
                    <br>
                    </tbody>
                </table>
                        
                    </div>
                </div>
            </main>

        </div>
    </body>
</html>
