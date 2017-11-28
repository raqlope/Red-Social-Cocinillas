<%-- 
    Document   : pagusuario
    Created on : Apr 30, 2017, 8:34:30 PM
    Author     : dizzy
--%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
        <%
            Usuario user = (Usuario) request.getAttribute("usuarioPag");
            String fotoPerfil = "";
            String username = "";
            String siguiendo = "false";
            //TODO: Lista de recetas del usuario, implementar seguir a un usuario
            
            fotoPerfil = user.getFotoPerfil();
            username = user.getUsername();
            
            
            %>
    <head>
        <title>Página de <%= username %></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="../css/font.css">    
        <link rel="stylesheet" type="text/css" href="../css/marco.css">
        <link rel="stylesheet" type="text/css" href="../css/style_index.css">
        <link rel="stylesheet" type="text/css" href="../css/pagusuario.css">
    </head>
    <body> 
        
        
<a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
<div class="container">
      <header id="header">
  </header>
  <section id="navArea">
    
      <%@include file="cabecera.html" %>
      
    <div id="user">
      <img id="foto_perfil" src=<%= "'"+fotoPerfil+"'" %> >
      <div class="info">
        <h1 id="username"><%= username %></h1>
        <div id="btns">
            <a class="btn btn-info follow_btn"><i class="fa fa-plus-square fa-1x" aria-hidden="true"></i> Seguir</a>
            <a class="btn btn-primary msg_btn" href="./escribirmensaje.html"><i class="fa fa-envelope-o fa-1x" aria-hidden="true"></i> Enviar mensaje</a>
        </div>
      </div>
    </div>
      <section id="recetas">
       <div class="row"> 
       <div class="receta">
           <div class="fotoreceta"><img src="../images/macarrones.jpg"></div>
           <div class="name"><a>Macarrones con tomate y jamón curado de pavo</a></div>
           <div class="sum"><p>Para la salsa de tomate, pica los ajos, la cebolla y el pimiento verde en dados. Ponlos a pochar en una cazuela con un chorrito de aceite... <br><a class="seguir" href="#">Seguir leyendo</a></div>
       </div>
           
      <div class="receta">
           <div class="fotoreceta"><img src="../images/flan.jpg"></div>
           <div class="name"><a>Flan de Nata</a></div>
           <div class="sum"><p>Coloca las galletas en el mortero y machácalas a tu gusto, o bien reducidas a polvo bien en trozos un poco más grandes e irregulares. Pasa la mezcla a una fuente amplia... <br><a class="seguir" href="#">Seguir leyendo</a></div>
       </div>
       </div>
  </section>
  </section>

      <%@include file="footer.html" %>
</div>
</body>
</html>