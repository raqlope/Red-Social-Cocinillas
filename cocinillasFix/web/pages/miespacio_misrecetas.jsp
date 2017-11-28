<%-- 
    Document   : miespacio_misrecetas
    Created on : Apr 28, 2017, 1:52:07 PM
    Author     : dizzy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Mis Recetas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="../css/font.css">  
        <link rel="stylesheet" type="text/css" href="../css/marco.css">
        <link rel="stylesheet" type="text/css" href="../css/miespacio.css">
        <script type="application/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script type="application/javascript">    
            $(document).ready(function(){
                    $(".recetas").attr('id','selected');
                    $(".espacio").addClass('active');
            });
        </script>
    </head>
    <body>  
<a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
<div class="container">
      <header id="header">
  </header>
  <section id="navArea">
    
    
      <%@include file="cabecera.html"%>
      
      <%@include file="barranavMiespacio.html"%>

  <section id="recetas">
       <ul class="receta">
           <li class="name">Pizza de Verduras</li>
           <li class="date">20 Enero 2015</li>         
           <li class="buttons">
                <a class="btn btn-primary" href="./modificarReceta.html"><i class="fa fa-pencil-square-o fa-1x" aria-hidden="true"></i>Editar</a>
                <a class="btn btn-danger" href="#"><i class="fa fa-trash-o fa-1x" aria-hidden="true"></i>Eliminar</a>
           </li>    
           <li class="wrap"><div class="likes">2</div><img src="../images/Like-icon.png"></li>
       </ul>
      <ul class="receta">
           <li class="name">Bacalao al horno</li>
           <li class="date">1 Febrero 2015</li>         
           <li class="buttons">
                <a class="btn btn-primary" href="./modificarReceta.html"><i class="fa fa-pencil-square-o fa-1x" aria-hidden="true"></i>Editar</a>
                <a class="btn btn-danger" href="#"><i class="fa fa-trash-o fa-1x" aria-hidden="true"></i>Eliminar</a>
           </li>    
           <li class="wrap"><div class="likes">10</div><img src="../images/Like-icon.png"></li>
       </ul>
      <ul class="receta">
           <li class="name">Alcachofas con jamón</li>
           <li class="date">26 Enero 2016</li>         
           <li class="buttons">
                <a class="btn btn-primary" href="./modificarReceta.html"><i class="fa fa-pencil-square-o fa-1x" aria-hidden="true"></i>Editar</a>
                <a class="btn btn-danger" href="#"><i class="fa fa-trash-o fa-1x" aria-hidden="true"></i>Eliminar</a>
           </li>    
           <li class="wrap"><div class="likes">25</div><img src="../images/Like-icon.png"></li>
       </ul>
  </section>
    
  </section>
  
 
 <%@include file="footer.html" %>
 </div>
</body>
</html>
