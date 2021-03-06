<%-- 
    Document   : panel
    Created on : 11-29-2019, 11:44:45 AM
    Author     : christian.ramirezusa
--%>

<div class="nav-side-menu">
    <div class="brand">Tio Juanito - Admin Panel&nbsp;&nbsp;&nbsp;<i class="fa fa-bus"></i></div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>

    <div class="menu-list">

        <ul id="menu-content" class="menu-content collapse out">
            <li>
                <a href="menuSA.jsp">
                    <i class="fa fa-dashboard fa-lg"></i>Inicio
                </a>
            </li>

            <li  data-toggle="collapse" data-target="#products" class="collapsed active">
                <a href="#"><i class="fa fa-road fa-lg"></i> Administraci&oacute;n de Recorridos <span class="arrow"></span></a>
            </li>
            <ul class="sub-menu collapse" id="products">                
                <li><a href="recorrido?action=listas">Agregar Recorrido</a>&nbsp;<i class="fa fa-plus"></i></li>
                <li><a href="modalidad?action=list">Modalidad</a>&nbsp;<i class="fa fa-clock-o "></i></li>
                <li><a href="barrio?action=list">Barrio</a>&nbsp;<i class="fa fa-sitemap "></i></li>
                <li><a href="colegio?action=list">Colegio</a>&nbsp;<i class="fa fa-building-o "></i></li>                
            </ul>

            <li  data-toggle="collapse" data-target="#products2" class="collapsed active">
                <a href="#"><i class="fa fa-edit fa-lg"></i>Administraci&oacute;n de viajes<span class="arrow"></span></a>
            </li>
            <ul class="sub-menu collapse" id="products2">
                <li><a href="#">Control</a>&nbsp;<i class="fa fa-arrows "></i></li>
                <li><a href="#">Fecha</a>&nbsp;<i class="fa fa-calendar-times-o"></i></li>
            </ul>
            
            <li  data-toggle="collapse" data-target="#products3" class="collapsed active">
                <a href="#"><i class="fa fa-edit fa-lg"></i>Administraci&oacute;n de Equipo de Viajes<span class="arrow"></span></a>
            </li>
            <ul class="sub-menu collapse" id="products3">
                <li><a href="#">Equipos</a>&nbsp;<i class="fa fa-list"></i></li>
                <li><a href="buseschofer?action=listas">A�adir equipos</a>&nbsp;<i class="fa fa-plus-circle"></i></li>
                <li><a href="#">Editar Equipos</a>&nbsp;<i class="fa fa-pencil "></i></li>                
            </ul>

            <li data-toggle="collapse" data-target="#service" class="collapsed">
                <a href="#"><i class="fa fa-users fa-lg"></i>Equipo<span class="arrow"></span></a>
            </li>  
            <ul class="sub-menu collapse" id="service">
                <li><a href="chofer?action=list">Choferes</a> &nbsp; <i class="fa fa-id-card"></i></li>
                <li><a href="asistente?action=list">Asistentes</a> &nbsp; <i class="fa fa-hand-spock-o"></i></li>
                <li><a href="buses?action=list">Buses</a> &nbsp;<i class="fa fa-bus"></i></li>
            </ul>
            
            <li>
                <a href="usuario?action=mostrar">
                    <i class="fa fa-user fa-lg"></i> Usuarios
                </a>
            </li>

            <li>
                <a href="opinion?action=mostrar">
                    <i class="fa fa-users fa-lg"></i> Secci&oacute;n de opiniones
                </a>
            </li>
        </ul>
    </div>
</div>



