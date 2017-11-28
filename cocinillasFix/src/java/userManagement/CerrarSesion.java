/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userManagement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author Cristina
 */

public class CerrarSesion extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException{
        
        HttpSession sesion = req.getSession();
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        if(usuario == null){System.out.println("ERROR"); return;}
        try {
            usuario.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace(); 
            return;
        }
        
        sesion.invalidate();
        
        
        resp.sendRedirect("/pages/login.jsp");
    }
    
}
