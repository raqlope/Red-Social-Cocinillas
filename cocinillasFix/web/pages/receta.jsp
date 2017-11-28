<%-- 
    Document   : receta
    Created on : 30-abr-2017, 13:28:57
    Author     : Cristina
--%>

<%@page import="modelo.Usuario"%>
<%@page import="modelo.Comentarios"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cocinillas</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="../css/font.css">  
        <link rel="stylesheet" type="text/css" href="../css/marco.css">
        <link rel="stylesheet" type="text/css" href="../css/style_index.css">
        <script type="application/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <!--div id="preloader">
        <div id="status">&nbsp;</div>
        </div-->
        <!--COMIENZA EL MARCO-->
        <a class="scrollToTop" href="#"></a>
        <div class="container">
            <header id="header">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <div class="header_bottom"></div>
                    </div>
                </div>
            </header>
            <section id="navArea">
                <%@include file="cabecera.html"%>  
            </section>
    
            <!--ACABA EL MARCO-->

            <section id="sliderSection">
                <div class="row">
                    <div class="col-lg-8 col-md-8 col-sm-8">
                        <h3 class="titulo"><%= (String)request.getAttribute("titulo") %></h3>
                        <img src="<%= (String)request.getAttribute("foto") %>" alt=""/>
                        <div class="preparacion">
                            <h5>Preparación:</h5>
                            <p><%= (String)request.getAttribute("instrucciones") %></p>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <div class="latest_post">
                            <input type="image" action="" src="../images/Like-icon.png" class="like" title="Like"/>
                            <input type="image" action="" src="../images/fav.png" class="fav" title="Favorita"/>
                            <h2><span>Ingredientes:</span></h2>
                            <div class="latest_post_container">
                                <ul class="latest_postnav">
                                    <% 
                                        ArrayList<String> ing = (ArrayList<String>)request.getAttribute("ingredientes");

                                        for ( int i=0; i<ing.size();i++){
                                            %><li><%= ing.get(i)%></li><%
                                        }
                                    %>
                                </ul>
                            </div>
                        </div>
                        <div class="latest_post">
                            <h2><span>Usuario</span></h2>
                            <div class="latest_post_container">
                                <div class="media"> <a href=<%="'/pages/accederPagUsuario?usuario="+request.getAttribute("autor")+"'"%> class="media-left"></a>
                                    <div class="media-body"> <a class="nombre" href=<%="'/pages/accederPagUsuario?usuario="+request.getAttribute("autor")+"'"%> class="catg_title"> <%= request.getAttribute("autor") %></a>
                                    <a class="btn btn-primary msg_btn enviar"><i class="fa fa-envelope-o fa-1x" aria-hidden="true"></i></a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <div class="comentario">
                <h3>Deja tu comentario:</h3>
                    <textarea name="texto" cols="90" class="textoCom"></textarea>
                    <input type="submit" value="Comentar" class="coment btn btn-primary msg_btn enviar"/>
                    <input type="hidden" name="id" value="<%= request.getAttribute("id") %>"/>
                <div class="comentarios">
                    <% 
                        ArrayList<Comentarios> com = (ArrayList<Comentarios>)request.getAttribute("comentarios");
                        Usuario autor = new Usuario();
                        
                        if(com!=null){
                            for ( int j=0; j<com.size();j++){
                                autor = autor.getUsuarioById(com.get(j).getAutor());
                                
                                %><a href=<%="'/pages/accederPagUsuario?usuario="+request.getAttribute("autor")+"'"%>><%= autor.getUsername()%></a>
                                <p><%= com.get(j).getFecha()%></p><br>
                                <p id="comentario"><%= com.get(j).getTexto()%><%
                            }
                        }
                    %>
                </div>
            </div>
                                
            <%@include file="footer.html"%>
        </div>
    </body>
</html>
