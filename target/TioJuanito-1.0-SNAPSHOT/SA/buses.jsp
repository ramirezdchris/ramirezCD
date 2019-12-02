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
                        <h4 class="modal-title">Agregar Buses</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>                        

                    <div class="model-body" style="padding: 1rem;">
                        <form action="buses" method="GET" autocomplete="on" class="my-3" id="agregar">                                
                            <div class="row">
                                <div class="col">
                                    <div class="input-group">                                      
                                        <span class="input-group-text">Placa</span>
                                        <input type="text" class="form-control" name="txtPlaca"  id="txtPlaca" placeholder="">
                                    </div>                                    
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <br>
                                <div class="col">
                                    <div class="input-group">                                      
                                        <span class="input-group-text">Marca</span>
                                        <input type="text" class="form-control" name="txtMarca"  id="txtMarca" placeholder="">
                                    </div>                                    
                                </div>                                    
                            </div>
                            <br>
                            <div class="row">
                                <br>
                                <div class="col">
                                    <div class="input-group">                                      
                                        <span class="input-group-text">Modelo</span>
                                        <input type="text" class="form-control" name="txtModelo"  id="txtModelo" placeholder="">
                                    </div>                                    
                                </div>                                    
                            </div>
                            <br>
                            <div class="row">
                                <br>
                                <div class="col">
                                    <div class="input-group">                                      
                                        <span class="input-group-text">Asientos</span>
                                        <input type="text" class="form-control" name="txtAsientos"  id="txtAsientos" placeholder="">
                                    </div>                                    
                                </div>                                    
                            </div>
                            <br>                                                                                                
                            <br>
                            <div>
                                <button  type="submit" name="action" value="add" class="btn btn-success" onclick="return  validarAddPais();">Agregar</button>                                      
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
                        <h1>Mantenimieto Buses</h1><br>
                        <input type="submit" value="Agregar Nuevo Bus" name="add" class="btn btn-default btn-sm " style="float: left; height: 60px; border-radius: 15px; background-color: #5dc1b9;" data-toggle="modal" data-target="#myModal"/><br><br>
                    </div>
                    <div class="col-md-4">
                        
                    </div>
                    <div class="col-md-1">                            
                    </div>                        
                </div>
                <br><br>
                <div class="row"  style="margin-right: 0px;">
                    <div class="col-md-3"> 
                        <table class="table table-active">
                            <thead>
                            <th>ID</th>
                            <th>Placa</th>
                            <th>Marca</th>
                            <th>Modelo</th>
                            <th>Asistentos</th>      
                            <th colspan="2">Acciones</th> 
                            </thead>
                            <tbody>
                                <c:forEach items="${list}" var="v">
                                <tr>                                    
                                    <td>${v.idBuses}</td>
                                    <td>${v.placa}</td>
                                    <td>${v.marca}</td>
                                    <td>${v.modelo}</td>
                                    <td>${v.asientos}</td>
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
