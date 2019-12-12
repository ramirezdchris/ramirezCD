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
        <%@include file="../head.jsp" %>        
    </head>
    <body>        
        <div class="row" style="margin-right: 0px;">
            <div class="col-md-3" style="padding-right: 0px;">
                <div style=""><%@include file="../panelSA.jsp" %></div>
            </div>
            <div class="col-md-9" style="margin-right: 0; padding-right: 0px;">
                <div class="row"  style="margin-right: 0px;">
                    <div class="col-md-9"> 
                        <br>
                        <h1>Listado de equipos encargados de recorridos</h1>
                        <br><br>
                        <table class="table table-hover">
                            <thead>
                            <th>Placa de MicroBus</th>
                            <th>Nombre Completo de Chofer</th>
                            <th>Nombre Completo de Asistente</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${list}" var="v">
                                    <tr> 
                                        <td>${v.idBuses.placa}</td>
                                        <td>${v.idChofer.nombreChofer}</td>
                                        <td>${v.idAsistente.nombreAsistente}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>                        
                </div>

            </div>
        </div>







        <%@include file="../footer.jsp" %>

    </body>
</html>
