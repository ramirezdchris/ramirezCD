<%-- 
    Document   : menu
    Created on : 11-29-2019, 10:48:54 AM
    Author     : christian.ramirezusa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="/head.jsp" %>        
    </head>
    <body>        
        <div class="row" style="margin-right: 0px;">
            <div class="col-md-3" style="padding-right: 0px;">
                <div style=""><%@include file="panel.jsp" %></div>
            </div>
            <div class="col-md-9" style="margin-right: 0; padding-right: 0px;">
                <div class="row"  style="margin-right: 0px;">
                    <div class="col-md-6">
                        <br>
                        <h1>Añadir recorridos</h1><br>
                        <br>                        
                        <form action="recorrido?action=add" method="POST">
                            <h3>Colegios</h3>
                            <select class="form-control" style="width: 400px;" name="txtColegios">
                                <option value="" selected disabled hidden>Selecionar Colegio</option> 
                                <c:forEach items="${lista1}" var="b">
                                    <option value="${b.idColegio}">${b.nombreColegio}</option>
                                </c:forEach>
                            </select><br>

                            <h3>Barrios</h3>
                            <select class="form-control" style="width: 400px;" name="txtBarrio">
                                <option value="" selected disabled hidden>Selecionar Barrio</option> 
                                <c:forEach items="${lista2}" var="c">
                                    <option value="${c.idBarrio}">${c.barrio}</option>
                                </c:forEach>
                            </select><br>

                            <h3>Modalidades</h3>
                            <select class="form-control" style="width: 400px;" name="txtModalidad">
                                <option value="" selected disabled hidden>Selecionar Modalidad</option> 
                                <c:forEach items="${lista3}" var="a">
                                    <option value="${a.idModalidad}">${a.modalidad}&nbsp;${a.recoger}&nbsp;${a.dejar}</option>
                                </c:forEach>
                            </select>
                            <br>
                            <h3>Equipo de trabajo</h3>
                            <select class="form-control" style="width: 400px;" name="txtBusesChofer">
                                <option value="" selected disabled hidden>Selecionar Equipo</option> 
                                <c:forEach items="${list}" var="v">
                                    <option value="${v.idBusesChofer}">${v.idBuses.placa} ${v.idChofer.nombreChofer} ${v.idAsistente.nombreAsistente}</option>                                    
                                </c:forEach>                                
                            </select>
                            <br><br>
                            <button class="btn btn-success">Agregar Recorrido</button>
                            <br><br><br>
                            <h2>${msg}</h2>
                        </form>
                    </div>
                    <div class="col-md-3">
                        <br><br>
                        <a href="buseschofer?action=list" class="btn btn-success" style="width: 100%; height: 100px; font-size: 20px; border-radius: 50px; padding-top: 25px; background: #2e353d; color: white;">Listado de equipos<br><i class="fa fa-list"></i></a>
                    </div>
                    <div class="col-md-3">
                        <br><br>
                        <a class="btn btn-success" style="width: 100%; height: 100px; font-size: 20px; border-radius: 50px; padding-top: 25px; background: #2e353d; color: white;">Cambiar Equipos<br><i class="fa fa-retweet"></i></a>
                    </div>  
                </div>

            </div>
        </div>


        <table>
            <thead>

            </thead>
            <tbody>
                <tr>

                </tr>
            </tbody>
        </table>
        <%@include file="/footer.jsp" %>

    </body>
</html>
