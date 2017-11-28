<%-- 
    Document   : descubrir
    Created on : 30-abr-2017, 20:37:52
    Author     : Cristina
--%>

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
<script type="application/javascript">    
            $(document).ready(function(){
                    $(".des").attr('id','selected');
            });
        </script>
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
        <%@include file="barraInicio.html"%>
  </section>
    
    <!--ACABA EL MARCO-->

   <section id="sliderSection">
    <div class="row">
      <div class="col-lg-8 col-md-8 col-sm-8">
        <div class="slick_slider">
          <div class="single_iteam"> <a href="#"> <img src="../images/sorullos.jpg" alt=""></a>
            <div class="slider_article">
              <h2><a class="slider_tittle" href="#">Receta de Sorullos de maíz</a></h2>
              <h2><a class="slider_tittle" href="#">Alfonso Rodríguez Chamizo</a></h2>
              <p>Los sorullos de maíz son una receta original de Puerto Rico, donde la harina de maíz se utiliza a diario en la elaboración de muchos...</p>
            </div>
          </div>
          <div class="single_iteam"> <a href="#"> <img src="../images/queque.jpg" alt=""></a>
            <div class="slider_article">
              <h2><a class="slider_tittle" href="#">Receta de Queque tradicional</a></h2>
              <h2><a class="slider_tittle" href="#">Antonio Pérez Martínez</a></h2>
              <p>La receta de queque fácil que te proponemos en RecetasGratis.net es una de las más sencillas de elaborar y el resultado es delicioso. Para hacer esta...</p>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-md-4 col-sm-4">
        <div class="latest_post">
          <h2><span>Ranking</span></h2>
          <div class="latest_post_container">
            <ul class="latest_postnav">
              <li>
                 <div class="rank"><img class="rank" alt="" src="../images/uno.png"></div>
                <div class="media"> <a href="#" class="media-left"> <img alt="" src="../images/ensalada.jpg"> </a>
                  <div class="media-body"> <a href="#" class="catg_title"> Receta de Ensalada de pasta fría con atún</a> </div>
                </div>
              </li>
              <li>
                <div class="rank"><img class="rank" alt="" src="../images/dos.png"></div>
                <div class="media"> <a href="#" class="media-left"> <img alt="" src="../images/bollos.jpg"> </a>
                  <div class="media-body"> <a href="#" class="catg_title"> Receta de Bollos suizos caseros</a> </div>
                </div>
              </li>
              <li>
                  <div class="rank"><img class="rank" alt="" src="../images/tres.png"></div>
                   <div class="media"><a href="#" class="media-left"> <img alt="" src="../images/torta.jpg"> </a>
                  <div class="media-body"> <a href="#" class="catg_title"> Receta de Torta de chocolate casera</a> </div>
                </div>
              </li>
              <li>
                  <div class="rank"><img class="rank" alt="" src="../images/cuatro.png"></div>
                <div class="media"> <a href="#" class="media-left"> <img alt="" src="../images/vasitos.jpg"> </a>
                  <div class="media-body"> <a href="#" class="catg_title"> Receta de Vasitos tres chocolates</a> </div>
                </div>
              </li>
              <li>
                  <div class="rank"><img class="rank" alt="" src="../images/cinco.png"></div>
                <div class="media"> <a href="#" class="media-left"> <img alt="" src="../images/arepas.jpg"> </a>
                  <div class="media-body"> <a href="#" class="catg_title"> Receta de Arepas de zanahoria Fitness</a> </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
        <div class="latest_post usuarios">
          <h2><span>Usuarios</span></h2>
          <div class="latest_post_container">
            <ul class="latest_postnav">
              <li>
                <div class="media"> <a href="#" class="media-left"> <img alt="" src="../images/usu1.jpg"> </a>
                  <div class="media-body"> <a class="nombre" href="#" class="catg_title"> Rosario</a>
                  <a class="btn btn-primary msg_btn enviar"><i class="fa fa-envelope-o fa-1x" aria-hidden="true"></i></a></div>
                </div>
              </li>
              <li>
                <div class="media"> <a href="#" class="media-left"> <img alt="" src="../images/usu2.jpg"> </a>
                  <div class="media-body"> <a class="nombre" href="#" class="catg_title"> Eleonor Fischer</a>
                  <a class="btn btn-primary msg_btn enviar"><i class="fa fa-envelope-o fa-1x" aria-hidden="true"></i></a></div>
                </div>
              </li>
              <li>
                   <div class="media"><a href="#" class="media-left"> <img alt="" src="../images/usu3.jpg"> </a>
                  <div class="media-body"> <a class="nombre" href="#" class="catg_title"> Clara Inés Rodríguez</a>  
                  <a class="btn btn-primary msg_btn enviar"><i class="fa fa-envelope-o fa-1x" aria-hidden="true"></i></a></div>
                </div>
              </li>
              <li>
                <div class="media"> <a href="#" class="media-left"> <img alt="" src="../images/usu4.jpg"> </a>
                  <div class="media-body"> <a class="nombre" href="#" class="catg_title"> Catina Barbero Diaz</a>  
                  <a class="btn btn-primary msg_btn enviar"><i class="fa fa-envelope-o fa-1x" aria-hidden="true"></i></a></div>
                </div>
              </li>
              <li>
                <div class="media"> <a href="#" class="media-left"> <img alt="" src="../images/usu5.jpg"> </a>
                  <div class="media-body"> <a class="nombre" href="#" class="catg_title"> Montse Morote Ortega</a>  
                  <a class="btn btn-primary msg_btn enviar"><i class="fa fa-envelope-o fa-1x" aria-hidden="true"></i></a></div>
                </div>
              </li>
            </ul>
          </div>
        </div>
    </div>
          </div>
  </section>
  
    <%@include file="footer.html"%>
  
  

</div>
</body>
</html>
