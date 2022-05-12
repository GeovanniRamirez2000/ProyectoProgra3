<%-- 
    Document   : index
    Created on : 5/05/2022, 05:31:43 PM
    Author     : GEOVARU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Layout/layout.jsp"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="col-md-12" >
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
                            <a class="nav-link collapsed" href="Mantenimiento/createModules.jsp" data-bs-toggle="collapse" data-bs-target="#collapseCliente" aria-expanded="false" aria-controls="collapseCliente">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                    Módulos
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseCliente" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="ControllerExamenParcial2?accion=verCliente">odulos</a>
                                    <a class="nav-link" href="ControllerExamenParcial2?accion=crearCliente">Crear Clientes</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseProducto" aria-expanded="false" aria-controls="collapseProducto">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Productos
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseProducto" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="ControllerExamenParcial2?accion=verProducto">Ver Productos</a>
                                    <a class="nav-link" href="ControllerExamenParcial2?accion=crearProducto">Crear Producto</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLugares" aria-expanded="false" aria-controls="collapseLugares">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Lugares
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLugares" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Departamentos
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="ControllerExamenParcial2?accion=verDepartamento">Ver Departamentos</a>
                                            <a class="nav-link" href="ControllerExamenParcial2?accion=crearDepartamento">Crear Departamento</a>
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Municipios
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="ControllerExamenParcial2?accion=verMunicipio">Ver Municipios</a>
                                            <a class="nav-link" href="ControllerExamenParcial2?accion=crearMunicipio">Crear Municipio</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePedido" aria-expanded="false" aria-controls="collapsePedido">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Pedidos
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePedido" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="ControllerExamenParcial2?accion=pedido">Crear Pedido</a>
                                </nav>
                            </div>
                        </div>
                    </div>
                </nav>


            </div>
        </div>
        <div id="layoutSidenav_content">
            <main >

                <div class="container-fluid px-4 row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-10 ">
                        <br>
                        <h1 class="mt-5">Proyecto</h1>
                        <ul >
                            <li >Alfredo Geovanni Ramirez Tzunun</li>
                            <li >Rudy</li>
                            <li >Maria</li>
                            <li >Alex</li>
                        </ul>
                    </div>

                </div>
            </main>

        </div>
    </body>
</html>
