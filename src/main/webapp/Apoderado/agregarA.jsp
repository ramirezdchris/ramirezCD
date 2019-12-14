<%-- 
    Document   : agregarA
    Created on : 12-05-2019, 01:29:15 PM
    Author     : christian.ramirezusa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../head.jsp" %>
        <style>
            img#corredor1 {

                position: absolute;
                margin-top: 80px;
            }

            img#corredor2 {
                position: absolute;
                -moz-transform: scaleX(-1); /* Firefox */
                -o-transform: scaleX(-1); /* Opera */
                -webkit-transform: scaleX(-1); /* Chrome y Safari */
                transform: scaleX(-1); /* w3org */
                filter: FlipV; /* Internet Explorer */
                margin-top: 500px;

            }
            .zona_boton {
                text-align: center;
                width: 100%;

            }

        </style>
    </head>
    <body>
        <img id="corredor1" src="https://images.vexels.com/media/users/3/134428/isolated/preview/0952976ee563b42c1decb93327bbed76-autob-s-escolar-desde-el-lado-by-vexels.png" width="300" height="300"  onload='setInterval("correr()", 90)'>
        <img id="corredor2" src="https://images.vexels.com/media/users/3/134428/isolated/preview/0952976ee563b42c1decb93327bbed76-autob-s-escolar-desde-el-lado-by-vexels.png" onload='setInterval("correr()", 90)'/>        
        <%@include file="../panelA.jsp" %>
        
        <br><br><br><br><br><br>
        <form action="nino?action=add&apoderado=${sessionScope.Id}" method="POST">
            <div class="container" style="border: 5px dotted black ; border-radius: 50px;">
                <br><br><br>
                <div class="row">                    
                    <div class="col-md-6">
                        <label class="badge-info">Nombre del Niño</label>
                        <input value="${sessionScope.Id}" hidden="" name="txtPadre">
                        <input type="text" name="txtNombre" class="form-control" placeholder="Ingresar Nombre">  
                    </div>
                    <div class="col-md-6">
                        <label class="badge-info">Apellido del niño</label>
                        <input type="text" name="txtApellido" class="form-control" placeholder="Ingresar Apellido">  

                    </div>
                </div>
                <br>
                <div class="row justify-content-center">
                    <div class="col-md-4">
                        <button class="btn btn-block" >Insertar</button>
                    </div>

                </div>
                <br>


            </div>
            <br>
            <br><br><br><br>
            <br><br><br>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3"></div>

                    <div class="col-md-6">
                        <table class="table table-hover">
                            <thead>
                            <th>Nombre</th>
                            <th>Apellido </th>
                            <th>Encargado</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${list}" var="v">
                                    <tr>
                                        <td>${v.nombreNino}</td>
                                        <td>${v.apellidoNino}</td>
                                        <td>${v.idApoderado.nombreApoderado}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-3"></div>
                </div>
            </div>


        </form>


        <%@include file="../footer.jsp" %>
        <script>
            var corredor1 = document.getElementById("corredor1");
            var corredor2 = document.getElementById("corredor2");

            var x_corredor1 = 85;
            var x_corredor2 = 2;

            function correr() {

                if (x_corredor1 <= 85 && x_corredor1 >= 2) { //condición para que se mueva entre estos valores de la pantalla
                    x_corredor1 = x_corredor1 - 1; //movimiento del valor x
                    corredor1.style.left = x_corredor1 + "%"; //aplicar el valor obtenido al left del elemento
                } else { //si no cumple la condición, es decir, se sale de los valores de la pantalla, vuelve a empezar
                    x_corredor1 = 85; //posicion inicial
                    corredor1.style.left = x_corredor1 + "%"; //volvemos a aplicar el valor obtenido al left del elemento
                }

                if (x_corredor2 <= 85 && x_corredor2 >= 2) { //condición para que se mueva entre estos valores de la pantalla
                    x_corredor2 = x_corredor2 + 1; //movimiento del valor x
                    corredor2.style.left = x_corredor2 + "%"; //aplicar el valor obtenido al left del elemento
                } else { //si no cumple la condición, es decir, se sale de los valores de la pantalla, vuelve a empezar
                    x_corredor2 = 2; //posicion inicial
                    corredor2.style.left = x_corredor2 + "%"; //volvemos a aplicar el valor obtenido al left del elemento
                }

            }

        </script> 
    </body>
</html>
