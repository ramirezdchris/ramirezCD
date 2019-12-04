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
        <div class="modal fade" id="myModal"> 
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Agregar Modalidad</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>                        

                    <div class="model-body" style="padding: 1rem;">
                        <form action="modalidad?action=add" method="POST">                                
                            <div class="row">
                                <div class="col">
                                    <div class="input-group">                                      
                                        <span class="input-group-text">Modalidad</span>
                                        <input type="text" class="form-control" name="txtModalidad"  id="txtModalidad" placeholder="">
                                    </div>                                    
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <br>
                                <div class="col">
                                    <div class="input-group">                                      
                                        <span class="input-group-text">Hora de Recoger</span>
                                        <input type="time" class="form-control" name="txtRecoger"  id="txtRecoger" placeholder="">
                                    </div>                                    
                                </div>                                    
                            </div>                            
                            <br>
                            <div class="row">
                                <br>
                                <div class="col">
                                    <div class="input-group">                                      
                                        <span class="input-group-text">Hora de ir a dejar</span>
                                        <input type="time" class="form-control" name="txtDejar"  id="txtDejar" placeholder="">
                                    </div>                                    
                                </div>                                    
                            </div>
                            <br>                            
                            <br>                                                                                                
                            <br>
                            <div>
                                <button class="btn btn-success">Agregar</button>                                      
                            </div>                                
                        </form>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                    </div>

                </div>

            </div>
        </div>        
        <div class="row" style="margin-right: 0px;">
            <div class="col-md-3" style="padding-right: 0px;">
                <div style=""><%@include file="panel.jsp" %></div>
            </div>
            <div class="col-md-9" style="margin-right: 0; padding-right: 0px;">
                <div class="row"  style="margin-right: 0px;">
                    <div class="col-md-5">
                        <h1>Mantenimieto de Modalidades</h1><br>
                        <input type="submit" value="Agregar Nueva Modalidad" name="add" class="btn btn-default btn-sm " style="float: left; height: 60px; border-radius: 15px; background-color: #5dc1b9;" data-toggle="modal" data-target="#myModal"/><br><br>
                    </div>
                    <div class="col-md-4">
                        
                    </div>
                    <div class="col-md-1">                            
                    </div>                        
                </div>
                <br><br>
                <div class="row"  style="margin-right: 0px;">
                    <div class="col-md-10"> 
                        <table class="table table-active">
                            <thead>
                            <th>ID</th>
                            <th>Modalidad</th>
                            <th>Hora de ir recoger</th>
                            <th>Hora de ir a dejar</th>                            
                            <th colspan="2">Acciones</th> 
                            </thead>
                            <tbody>
                                <c:forEach items="${list}" var="v">
                                <tr>                                    
                                    <td>${v.idModalidad}</td>
                                    <td>${v.modalidad}</td>
                                    <td>${v.recoger}</td>
                                    <td>${v.dejar}</td>
                                    
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table> 
                    </div>

                    <div class="col-md-4">
                        <div class="row"  style="margin-right: 0px;">
                            <div class="col-md-2">   

                            </div>
                            <div class="col-md-4">

                            </div>
                            <div class="col-md-1">                            
                            </div>                        
                        </div> 
                    </div>
                    <div class="col-md-1">                            
                    </div>                        
                </div> 

            </div>
        </div>
        <%@include file="../footer.jsp" %>

    </body>
</html>
