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
    </head>
    <body>
        <%@include file="../panelA.jsp" %> 
        <br><br><br><br><br><br>
        <form action="nino?action=add&apoderado=${sessionScope.Id}" method="POST">
            <div class="container" style="border: 5px dotted black ; border-radius: 50px;">
                <br><br><br>
                <div class="row">                    
                    <div class="col-md-6">
                         
                    </div>
                    <div class="col-md-6">                         
                        
                    </div>
                </div>
                <br>
                <div class="row justify-content-center">
                    <div class="col-md-4" style="border:  #000 solid">
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
    </body>
</html>
