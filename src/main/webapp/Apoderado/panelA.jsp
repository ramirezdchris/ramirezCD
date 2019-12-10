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
        width: 200px;
        height: 200px;
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


<img id="corredor1" src="https://images.vexels.com/media/users/3/134428/isolated/preview/0952976ee563b42c1decb93327bbed76-autob-s-escolar-desde-el-lado-by-vexels.png" width="300" height="300"  onload='setInterval("correr()", 90)'>
<ul class="nav" style="padding-top: 50px; padding-bottom: 0px;">
    <li style="margin-bottom:  10px;">     
        <label style="font-size: 15px;">${sessionScope.Nombre}</label>
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
        margin-top: 370px;

    }
    .zona_boton {
        text-align: center;
        width: 100%;
        
    }

</style>

<img id="corredor2" src="https://images.vexels.com/media/users/3/134428/isolated/preview/0952976ee563b42c1decb93327bbed76-autob-s-escolar-desde-el-lado-by-vexels.png" onload='setInterval("correr()", 90)'/>        



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




