<%-- 
    Document   : crearCuenta
    Created on : 11-28-2019, 09:37:27 AM
    Author     : christian.ramirezusa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="head.jsp" %>
    </head>
    <body>        
        <div class="container-fluid"><br>
            <img src="img/fondoo.jpg" id="fondo">
            <div class="row">
                <div class="col-md-4">
                    <h3>Registro de cuenta</h3>
                </div>
                <div class="col-md-6">
                    <img src="img/busRegistro.png" style="height: 100px; width: 200px;"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <p>
                        ${msg}
                    </p>
                </div>
                <div class="col-md-6" style="">
                    <form action="apoderado?action=add" method="POST">
                        <div class="row">
                            <div class="col-md-6">                            
                                <br><br><br>
                                <div class="form-group">					 
                                    <label>Nombre</label>
                                    <input type="text" class="form-control" name="txtNombres" placeholder="Nombres"/>
                                </div>
                                <div class="form-group">					 
                                    <label>Apellidos</label>
                                    <input type="text" class="form-control" name="txtApellidos" placeholder="Apellidos"/>
                                </div>
                                <div class="form-group">					 
                                    <label>Direccion</label>
                                    <textarea rows="5" cols="20" class="form-control" name="txtDireccion" placeholder="Direccion donde reside"></textarea>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <br><br><br>
                                <div class="form-group">					 
                                    <label>Telefono</label>
                                    <input type="text" class="form-control" name="txtTelefono" placeholder="Telefono Actual"/>
                                </div>
                                <div class="form-group">					 
                                    <label>Correo</label>
                                    <input type="email" class="form-control" name="txtCorreo" placeholder="Correo Electronico"/>
                                </div>
                                <div class="form-group">					 
                                    <label>Dui</label>
                                    <input type="text" class="form-control" name="txtDui" placeholder="Dui"/>
                                </div>
                                <div class="form-group" style="text-align: center">
                                    <br><br><br><br>
                                    <button type="submit" class="btn btn-primary">
                                        Registrarse
                                    </button>
                                </div>
                            </div>

                        </div>
                    </form>
                </div>                
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
