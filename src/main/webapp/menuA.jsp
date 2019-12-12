<%-- 
    Document   : menu
    Created on : 11-29-2019, 10:49:36 AM
    Author     : christian.ramirezusa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="head.jsp" %>
        <style>
            img{
                height: 250px;
                width: 250px;
                padding: 0px 0px 0px 0px;
            }
            h3{
                margin-top: 10px;
            }
            
        </style>
        
    </head>
    <body>
        <img src="https://fondosdepantallaymuchomas.files.wordpress.com/2010/09/415.jpg" id="fondo" style="opacity: 0.7;">
        <div class="container-fluid">
            <div class="row">
                <div class="col-6" style="text-align: right; margin-top: 40px;">
                    <h2>Bienvenido/a ${sessionScope.Nombre} &nbsp; ${sessionScope.Id}</h2>
                    <input type="text" value="${sessionScope.Nombre}" hidden/>
                </div>
                <div class="col-6" style="text-align: right; margin-top: 10px;">
                    <a href="login?action=salir" style="margin: 60px 120px 0px 0px" class="btn btn-danger">Salir</a>
                </div>
            </div>
            <div class="row" style="text-align: center; margin-top: 50px;">
                <div class="col-md-2">                    
                </div>
                <div class="col-md-3">
                    <!-- <i class="fa fa-home"></i> -->
                    <a href="#"><img src="https://www.juegosalairelibre.com/cdnassets/MA800580-Casita-VISBY-1_l.png"></a>
                    <h3>Inicio</h3>
                </div>

                <div class="col-md-3" style="margin: 0px 0px 0px 0px;">
                    <!--<i class="fa fa-child"></i>-->
                    <a href="Apoderado/agregarA.jsp"><img src="https://cdn.pixabay.com/photo/2016/04/01/09/18/boy-1299263_960_720.png"></a>
                    <h3>Agregar Niños</h3>
                </div>
                <div class="col-md-3">
                    <!--<i class="fa fa-map-marker"></i>-->
                    <a href="#"><img src="https://pngimage.net/wp-content/uploads/2018/06/recorrido-png-5.png"></a>
                    <h3>Recorridos</h3>
                </div>         

            </div>
        </div>

    
    <%@include file="footer.jsp" %>
</body>
</html>
