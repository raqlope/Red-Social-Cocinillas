/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userManagement;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import modelo.Usuario;
import security.Hash;

/**
 *
 * @author Esther
 */
@MultipartConfig
//TODO: Cambiar foto de perfil
public class EditarPerfil extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        
        HttpSession sesion = request.getSession();
        Usuario usuario = (Usuario) sesion.getAttribute("usuario"); 
        
        Part filePart = request.getPart("fotoPerfil");
        //si no se ha subido un archivo el tamaño sera 0 y no se cambiara la foto de perfil
        if(filePart.getSize()!=0){
            File uploads = new File(getServletContext().getRealPath("/subidas"));
            
            File file = File.createTempFile("fotPer-",".jpg",uploads);
        
            try(InputStream fileContent = filePart.getInputStream()){
                Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
                
            String fotoPerfil = "/subidas/"+file.getName();
            usuario.setFotoPerfil(fotoPerfil);
        }
        
        String username = request.getParameter("user");
        String contrasenya = request.getParameter("new_password");
        String contrasenyaDebeCoincidir = request.getParameter("new_password_rpt");
        
        String contrasenyaC = "";
        
        try {
            if(!(username.equals(""))&& !(username.equals(usuario.getUsername()))){
                if(!usuario.checkExisteUsername(username)){
                    usuario.setUsername(username);
                }
                else{response.sendRedirect("/pages/miespacio_editarperfil.jsp?error=usuario"); return;}
            }
        } catch (SQLException ex) {response.sendRedirect("/pages/miespacio_editarperfil.jsp?error=sql"); return;}
        
        if(!contrasenya.equals("")){
            
            if(!contrasenya.equals(contrasenyaDebeCoincidir)){
                response.sendRedirect("/pages/miespacio_editarperfil.jsp?error=contrasenya");
                return;
            }
        
            Hash h = new Hash();
            try {
                contrasenyaC = h.doHash(contrasenyaC);
            } catch (NoSuchAlgorithmException ex) {ex.printStackTrace(); return;}
        
            usuario.setContrasenya(contrasenyaC);
        }
        
        try {
            usuario.updateUser();
        } catch (SQLException ex) {
                ex.printStackTrace();
                response.sendRedirect("/pages/miespacio_editarperfil.jsp?error=sql");
                return;
        }
        
        response.sendRedirect("/pages/miespacio_editarperfil.jsp?error=none");
        return;

    }
}
