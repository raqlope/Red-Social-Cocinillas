/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userManagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

import security.Hash;
/**
 *
 * @author Esther
 */

public class Registro extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        String usuario = request.getParameter("user");
        String correo = request.getParameter("email");
        String contrasenya = request.getParameter("password");
        String contrasenyaDebeCoincidir = request.getParameter("password2");
        
        
        if(!(contrasenya.equals(contrasenyaDebeCoincidir))){
            response.sendRedirect("/pages/registro.jsp?error=contrasenya&usuario="+usuario+"&correo="+correo);
            return;
        }
        else{   
            String contrasenyaC = "";
            
            try{
                contrasenyaC = new Hash().doHash(contrasenya);
            }catch(NoSuchAlgorithmException e){e.printStackTrace(); return;}
            
            
            Usuario instanciaUser = new Usuario(usuario,contrasenyaC,correo);
            
            try {
                if(instanciaUser.checkExisteUsername()){
                    response.sendRedirect("/pages/registro.jsp?error=user&correo="+correo);
                    return;
                }
                if(instanciaUser.checkExisteCorreo()){
                    response.sendRedirect("/pintages/registro.jsp?error=correo&user="+usuario);
                    return;
                }
               
                instanciaUser.addUsuario();
            }catch (SQLException ex) {
                ex.printStackTrace();
                response.sendRedirect("/pages/registro.jsp?error=sql");
                return;
            }
            
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario",instanciaUser);
            response.sendRedirect("/pages/principal.jsp");
            
        }
    }
}
