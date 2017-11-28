<%-- 
    Document   : miespacio_inbox.jsp
    Created on : Apr 28, 2017, 1:51:01 PM
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
        <title>Inbox</title>
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
                    $(".inbox").attr('id','selected');
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

  <div id="inbox">
      <div class="tab-content">
        <div class="tab-pane fade in active" id="home">
            <div class="list-group">
                <a href="#" class="list-group-item">
                    
                <span class="envelope"><i class="fa fa-envelope-o"></i></span>
                <span class="name">Cocinera15</span> 
                <span class="content">¿Cuántos huevos le echaste al pastel de...</span>
                <span class="badge">15 Feb 17</span> 
                </a>
                <a href="#" class="list-group-item">
                    
                <span class="envelope"><i class="fa fa-envelope-o"></i></span>
                <span class="name">Romsey15</span> 
                <span class="content">Compré los anacardos en una tienda de...</span>
                <span class="badge">15 Ene 17</span> 
                </a>
                <a href="#" class="list-group-item read">
                <span class="envelope"><i class="fa fa-envelope-open"></i></span>
                <span class="name">SuperCocinera178</span> 
                <span class="content">Aquí está el enlace a la tienda: http://www.all...</span>
                <span class="badge">7 Nov 16</span> 
                </a>
            </div>
        </div>
      </div>
  </div>
  </section>
    
 <%@include file="footer.html" %>
 </div>
</body>
</html>
