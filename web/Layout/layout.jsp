<%-- 
    Document   : index
    Created on : 5/05/2022, 05:31:43 PM
    Author     : GEOVARU
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.ModuleModel"%>
<%@page import="org.dao.DaoModule"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>ProyectoWeb</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="/ExamenParcial2">PROGRAMACION 3</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Visualizar</div>
                            <a class="nav-link" href="index.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Inicio
                            </a>
                            <div class="sb-sidenav-menu-heading">Mantenimientos</div>
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="indexModules.jsp">Módulos</a>
                            </nav>
                            <a class="nav-link collapsed" href="createRolls.jsp" data-bs-toggle="collapse" data-bs-target="#collapseProducto" aria-expanded="false" aria-controls="collapseProducto">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Roles
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseProducto" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="createRolls.jsp">Crear Roles</a>
                                    <a class="nav-link" href="viewRolls.jsp">Ver Roles</a>
                                </nav>
                            </div>
                            
                            <a class="nav-link collapsed" href="indexUser.jsp" data-bs-toggle="collapse" data-bs-target="#collapseUser" aria-expanded="false" aria-controls="collapseProducto">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Usuarios
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseUser" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="createUser.jsp">Crear Usuarios</a>
                                    <a class="nav-link" href="indexUser.jsp">Ver Usuarios</a>
                                </nav>
                            </div>
                             <a class="nav-link collapsed" href="IngresarVehiculos.jsp" data-bs-toggle="collapse" data-bs-target="#collapseVeh" aria-expanded="false" aria-controls="collapseVeh">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Vehiculos
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseVeh" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="IngresarVehiculos.jsp">Ingresar Vehiculos</a>
                                     <a class="nav-link" href="verVehiculos.jsp">Ver Vehiculos</a>
                                </nav>
                            </div>
                             <a class="nav-link collapsed" href="Usuario/index.jsp" data-bs-toggle="collapse" data-bs-target="#collapseVehE" aria-expanded="false" aria-controls="collapseVehE">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Estado Vehiculos
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseVehE" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cambiarEstadoVehiculos.jsp">Cambiar Estado</a>
                          
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="IngresarVehiculos.jsp" data-bs-toggle="collapse" data-bs-target="#collapseMarca" aria-expanded="false" aria-controls="collapseVeh">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Marcas
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseMarca" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="IngresarMarca.jsp">Ingresar Marca</a>
                                     <a class="nav-link" href="verMarcas.jsp">Ver Marca</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePedido" aria-expanded="false" aria-controls="collapsePedido">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Permisos
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePedido" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="Permisos.jsp">Agregar permisos</a>
                                </nav>
                            </div>
                            <%
                                DaoModule daoModule = new DaoModule();
                                List<ModuleModel> lstModulos = daoModule.listarMenu();
                                Iterator<ModuleModel> iteratorCliente = lstModulos.iterator();
                                ModuleModel module = null;
                                while (iteratorCliente.hasNext()){
                                module = iteratorCliente.next();
                            %>
                            <a class="nav-link" href="<%= module.getPath()%>">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                <%= module.getNombre()%>
                            </a>
                            <%}%>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>