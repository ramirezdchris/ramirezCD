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

        <div class="container" style="border: 1px black solid;">
            <br><br><br>
            <div class="row">
                <div class="col-md-6">
                    <input value="${sessionScope.Id}" hidden="">
                    <input type="text" name="txtNombre" class="form-control">  
                </div>
                    <div class="col-md-6">
                        <input type="text" name="txtApellido" class="form-control">  
                    <center><button class="btn-block" >Ingresar</button></center>
                    </div>

                <form>



                    
                </form>
            </div>
        </div>




        <%@include file="../footer.jsp" %>
    </body>
</html>
