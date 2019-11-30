<%-- 
    Document   : login
    Created on : 11-26-2019, 03:46:03 PM
    Author     : christian.ramirezusa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Bootstrap 4, from LayoutIt!</title>

        <%@include file="head.jsp" %>   

    </head>
    <body>
        <img src="img/fondoo.jpg" id="fondo">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-4">
                        </div>
                        <div class="col-md-4" style="text-align: center;">
                            <br><br>
                            <div class="card" style="padding: 30px 30px 30px 30px; border: 2px solid gray;">

                                <div><i class="fa fa-user" style="font-size: 100px; text-align: center;"></i>&nbsp;<i class="fa fa-bus" style="font-size: 100px; text-align: center;"></i></div>
                                <div></div>
                                <form role="form" action="login?action=login" method="POST">
                                    <div class="form-group">

                                        <label for="exampleInputEmail1">
                                            Usuario
                                        </label>
                                        <input type="text" class="form-control" name="txtUsu" placeholder="Ingresar Usuario">
                                    </div>
                                    <div class="form-group">

                                        <label for="exampleInputPassword1">
                                            Contraseña
                                        </label>
                                        <input type="password" class="form-control" name="txtClave"  placeholder="Ingresar Contraseña">
                                    </div>						 
                                    <button type="submit" class="btn btn-primary">
                                        Iniciar Sesion<br><i class="fa fa-bus"></i>
                                    </button>
                                    <br><br><br>
                                    <label style="font-size: 20px; color: black;">${msg}</label>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-4">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="footer.jsp" %>   
    </body>
</html>
