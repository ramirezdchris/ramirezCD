<%-- 
    Document   : panelA
    Created on : 12-05-2019, 01:29:01 PM
    Author     : christian.ramirezusa
--%>
<style>


    ul{
        padding-top: 50px;
        margin-right: 0px;
        position: initial;
        background-color: black;                    
    }
    ul li{
        font-family: cursive;
        margin-left: 52px;                   
    }
    ul li a{
        color: white;
        font-size: 15px;  
        text-align: center;        
    }
    a:hover{
        color: yellow;
        font-size: 17px;
    }

    img{
        width: 50px;
        height: 50px;
    }
    
    span{
        color: white;
        font-size: 10px;
    }
    
    
    label{
        padding: 5px 5px 5px 5px;
        color: black;
        border: 2px white solid;
        border-radius: 15px;
        background: yellow;
        
    }

</style>



<ul class="nav" style="padding-top: 30px; padding-bottom: 0px;">
    <li>
        <img src="https://images.vexels.com/media/users/3/134428/isolated/preview/0952976ee563b42c1decb93327bbed76-autob-s-escolar-desde-el-lado-by-vexels.png"/>        
        <br><label style="font-size: 15px;">${sessionScope.Nombre}</label>
    </li>
    
    <li class="nav-item">
        <a class="nav-link active" href="menu.jsp" style="padding: 0px 0px 0px 0px;">Inicio&nbsp;<i class="fa fa-home"></i></a>        
    </li>
    <li class="nav-item">
        <a class="nav-link" href="agregarA.jsp" style="padding: 0px 0px 0px 0px;">Niños&nbsp;<i class="fa fa-child"></i></a>        
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#" style="padding: 0px 0px 0px 0px;">Recorridos Disponibles&nbsp;<i class="fa fa-map-marker"></i></a>
    </li>
    <li class="nav-item" style="padding: 0px 0px 0px 0px; padding-left: 500px; ">
        <a class="nav-link" href="#">Salir</a>
    </li>
</ul>


