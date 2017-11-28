/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userManagement;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import security.Hash;

/**
 *
 * @author dizzy
 */
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        //el usuario se puede loguear con su username o su email
        String id = request.getParameter("id");
        String contrasenya = request.getParameter("password");
        
        String contrasenyaC = "";
        
        try{
            contrasenyaC = new Hash().doHash(contrasenya);
        }catch(NoSuchAlgorithmException e){e.printStackTrace(); return;}
            
        Usuario instanciaUser = new Usuario();
            
        try {
          if(!(instanciaUser.checkExisteUsername(id)) && !(instanciaUser.checkExisteCorreo(id))){
            response.sendRedirect("/pages/login.jsp?error=id");
            return;
          }
          //si si que existe el id como correo o como usuario, queremos guardar el identificador
          //del usuario en una variable para añadirlo a la sesion
          instanciaUser = instanciaUser.logUsuario(id, contrasenyaC);
          //si el usuario no es correcto, este metodo devolverá un número menor que 0
          if(instanciaUser == null){
            response.sendRedirect("/pages/login.jsp?error=pass&id="+id);
            return;
          }
          }catch (SQLException ex) {
                ex.printStackTrace();
                response.sendRedirect("/pages/login.jsp?error=sql");
                return;
          }
            
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario",instanciaUser);
        response.sendRedirect("/pages/principal.jsp");
        }
 }

