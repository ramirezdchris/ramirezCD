<%-- 
    Document   : agregarA
    Created on : 12-05-2019, 01:29:15 PM
    Author     : christian.ramirezusa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../head.jsp" %>
    </head>
    <body>
        <%@include file="panelA.jsp" %> 
        <br><br><br><br><br><br>
        <form>
            <div class="container" style="border: 5px dotted black ; border-radius: 50px;">
                <br><br><br>
                <div class="row">

                    <div class="col-md-6">
                        <label class="badge-info">Nombre del Niño</label>
                        <input value="${sessionScope.Id}" hidden="">
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
                        <button class="btn btn-block" >Ingresar</button>
                    </div>

                </div>

                <br>
            </div>

        </form>
             
        
        
        <%@include file="../footer.jsp" %>
    </body>
</html>
