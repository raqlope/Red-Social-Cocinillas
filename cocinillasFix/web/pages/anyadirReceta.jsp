<%-- 
    Document   : anyadirReceta
    Created on : 29-abr-2017, 11:39:15
    Author     : marta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Añadir Receta</title>
        <script type="application/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script> 
            $(document).ready(function() {
                $(".add").click(function() {
                    var intId = $("#masIng div").length + 2;
                    var fieldWrapper = $("<div class=\"ingredientesAñadidos\" id=\"div" + intId + "\"/>");
                    var fName = $("<input type=\"text\" name=\"Ingr"+intId+"\"   placeholder= \"Añadir ingrediente...\"   />");
                    var addButton = $
                    var removeButton = $('<img/>', {
                           "class" :"del", 
                            src:"../images/quita.png"
                         });
                    removeButton.click(function() {
                        $(this).parent().remove();
                    });                                   
                    fieldWrapper.append(fName);
                    fieldWrapper.append(removeButton);
                    $("#masIng").append(fieldWrapper);
                 });
                 var elems = document.getElementsByTagName( "ingredientes" );
                var arr = jQuery.makeArray( elems );
                    $.post('action.do', {arrayData:arr, mode:"insert"});

                });
        </script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="../css/font.css">  
        <link rel="stylesheet" type="text/css" href="../css/marco.css">
        <link rel="stylesheet" type="text/css" href="../css/añadirReceta.css">      
        
    </head>
    <body>  
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
    <nav class="navbar navbar-inverse" role="navigation">
      <%@include file="cabecera.html"%>
    </nav>
    </section>
      <div>
          <form class="anyadirReceta" action="anyadirReceta" method="get" name="formReceta">   
           <div class="general">
                <div id="cuerpoReceta">
                        <div>
                            <input type="text" class="titulo" name="titulo" placeholder= "Titulo de la receta..."  /> 
                            <input type="text" class="comensales" name="comensales" placeholder= "Núm. comensales"  /> 
                        </div>
                        <div>
                            <textarea id="prep" name="prep"  placeholder="Descripción de la receta..."></textarea>
                        </div>
                        <div>
                            <label for="file">Foto<input type="file" name="foto" id="file" class="inputfile"/></label>
                            <label for="file">Video<input type="file" name="video" id="file" class="inputfile" /></label>
                        </div>
                        <div id="etiq">
                            <input type="text" id="etiqueta" name="etiqueta" placeholder= "Etiqueta1;Etiqueta2;Etiqueta3;..."  /> 
                        </div>                            
                        <div>
                            <input class="ok" value="Añadir" type="button">
                            <a href="principal.html"><input class="cancel" type="button" value="Cancelar"></a>
                        </div>                        
                </div>
                <div class="ingredientes">
                    <div>
                    <h2>Ingredientes:</h2>
                    </div>
                    <div>                        
                        <fieldset id="masIng">
                            <input type="text" id="ing1" name="Ing1" placeholder= "Añadir ingrediente..."  />                            
                            <img class ="add" src="../images/mas.png">                            
                        </fieldset>                        
                    </div>
                </div>
            </div>
        </form>

      </div>
  
      
    <footer id="footer">
  <%@include file="footer.html"%>
      
      
    </footer>
  
</div>
</body>
</html>

