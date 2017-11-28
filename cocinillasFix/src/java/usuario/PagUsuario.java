/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import modelo.Usuario;

/**
 *
 * @author dizzy
 */
public class PagUsuario extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
                    {
        String id = request.getParameter("usuario");
        
        Usuario usuario = new Usuario();
        try {
            usuario = usuario.getInstanciaUsuario(id);
        } catch (SQLException ex) {
            Logger.getLogger(PagUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("usuarioPag",usuario);
        
        RequestDispatcher rd = request.getRequestDispatcher("/pages/pagusuario.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(PagUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
