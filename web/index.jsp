<%-- 
    Document   : index
    Created on : 5/05/2022, 05:31:43 PM
    Author     : GEOVARU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    </head>
    <body class="col-md-12" >

        <div id="layoutSidenav_content">
            <main >
                <br><br><br>
                <center><h1>Login</h1></center>
     <center><form action="LoginController" method="POST">
               <div class="form-group">
                   <input class="form-control" style="background-color: #D1F0FF" type="text" name="USUARIO" placeholder="Ingresar usuario">
               </div>
               <div class="form-group">
                   <input class="form-control" style="background-color: #D1F0FF" type="PASSWORD" name="PASSWORD" placeholder="Ingresar contraseña">
               </div><br>
                <input class="btn btn-lg btn-primary" style="border-radius: 20px;" type="submit" name="accion" value="Ingresar">
                <input type="reset" class="btn btn-lg btn-danger" style="border-radius: 20px;" value="borrar">
                
               </form></center>
        
                
            </main>

        </div>
    </body>
</html>
