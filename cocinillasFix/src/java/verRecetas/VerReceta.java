/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verRecetas;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import modelo.Recetas;
 
 /**
  *
  * @author Cristina
  */
 @WebServlet("/verReceta")
 public class VerReceta extends HttpServlet {
     public void doGet(HttpServletRequest req, HttpServletResponse resp) 
             throws IOException, ServletException{
         
         int id = Integer.parseInt(req.getParameter("rec"));
        
         Recetas receta = new Recetas();
         receta.recogerReceta(id);
         
        RequestDispatcher rd = req.getRequestDispatcher("/pages/receta.jsp");
        
        req.setAttribute("autor", receta.obtenerAutor(receta.getAutor()));
        req.setAttribute("idautor", receta.getAutor());
        req.setAttribute("numCom", receta.getNumCom());
        req.setAttribute("likes", receta.getLikes());
        req.setAttribute("titulo", receta.getTitulo());
        req.setAttribute("ingredientes", receta.getIngredientes());
        req.setAttribute("instrucciones", receta.getInstrucciones());
        req.setAttribute("foto", receta.getFoto());
        req.setAttribute("video", receta.getVideo());
        req.setAttribute("etiquetas", receta.getEtiquetas());
        req.setAttribute("fechaPubl", receta.getFechaPubl());
        req.setAttribute("id", id);
        req.setAttribute("comentarios", receta.getComentarios());
         //req.getSession().setAttribute("amigos", receta.getAmigos());
         
        rd.forward(req, resp);
     }
     
 }
