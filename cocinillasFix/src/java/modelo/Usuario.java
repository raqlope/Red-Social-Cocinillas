/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import data.ConnectionPool;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author dizzy
 */
public class Usuario {
    
    //guardamos todos los datos del usuario que inicia sesion y en la pag usuario
    //asi no tenemos que conectar con la DB una y otra vez para acceder a ellos
    private int id;
    private String username;
    private String contrasenya;
    private String email;
    private String fotoPerfil;
    private Date fechaAlta;
    private int tipoUsuario;
    
    public Usuario(){
        id = 0;
        username = "";
        contrasenya = "";
        email = "";
        fotoPerfil = null;
        fechaAlta = null;
        tipoUsuario = 1;
    }
    
    //un constructor para usuarios registrados en el momento
    public Usuario(String username, String contrasenya, String email){
       id = 0;
       this.username = username;
       this.contrasenya = contrasenya;
       this.email = email;
       fotoPerfil = "";
       fechaAlta =  new Date(Calendar.getInstance().getTimeInMillis());
       tipoUsuario = 1; 
    }
    
    //un constructor para adquirir todos los datos del usuario logueado
    public Usuario(int id, String username, String contrasenya, String email,String fotoPerfil, Date fechaAlta, int tipoUsuario){
       this.id = id;
       this.username = username;
       this.contrasenya = contrasenya;
       this.email = email;
       this.fotoPerfil = fotoPerfil;
       this.fechaAlta =  fechaAlta;
       this.tipoUsuario = tipoUsuario; 
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getFotoPerfil(){
        return fotoPerfil;
    }
    
    
    public Date getFechaAlta(){
        return fechaAlta;
    }
    
    public String getTipoUsuario(){
        if(tipoUsuario==1) return "usuario";
        else return "admin";
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setFotoPerfil(String fotoPerfil){
        this.fotoPerfil = fotoPerfil;
    }
    
    
    public void setContrasenya (String contrasenya){
        this.contrasenya = contrasenya;
    }
    
    public boolean checkExisteUsername() throws SQLException{   
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet products = statement.executeQuery("SELECT * FROM USUARIO U WHERE U.USERNAME = '"+username+"'");
        boolean result = products.next();
        pool.freeConnection(connection);  
        return result;
    }
    
    public boolean checkExisteUsername(String username) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet products = statement.executeQuery("SELECT * FROM USUARIO U WHERE U.USERNAME = '"+username+"'");
        boolean result = products.next();
        pool.freeConnection(connection);  
        return result;
    }
    
    public boolean checkExisteCorreo() throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet products = statement.executeQuery("SELECT * FROM USUARIO U WHERE U.EMAIL = '"+email+"'");
        boolean result = products.next();
        pool.freeConnection(connection); 
        return result;
    }
    
    public boolean checkExisteCorreo(String email) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet products = statement.executeQuery("SELECT * FROM USUARIO U WHERE U.EMAIL = '"+email+"'");
        boolean result = products.next();
        pool.freeConnection(connection); 
        return result;
    }
    
    
    //Registra los datos en la instancia en la DB
    public void addUsuario()
        throws SQLException {
        String query = "INSERT INTO USUARIO (EMAIL,USERNAME, CONTRASENYA, FECHAALTA, TIPOUSUARIO) VALUES ('";
        query += email;
        query += "','";
        query += username;
        query += "','";
        query += contrasenya;
        query += "','";
        query += fechaAlta;
        query += "',";
        query += tipoUsuario;
        query += ")";        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);        
        //una vez ejecutada la query tendremos que obtener el id del usuario recien registrado y ponerlo en la instancia actual
        statement = connection.createStatement();
        ResultSet products = statement.executeQuery("SELECT * FROM USUARIO U WHERE U.USERNAME ='"+username+"'");
        products.next();
        id = products.getInt("idusuario");
        pool.freeConnection(connection);         
    }
    
    
    //Dado un id (usuario o email) y una contrasenya, comprueba que son correctas 
    //y en ese caso devuelve la instancia de Usuario con los datos de la DB para ese usuario.
    public Usuario logUsuario(String id, String contrasenya) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet products = statement.executeQuery("SELECT * FROM USUARIO U WHERE (U.USERNAME='"+id+"' OR U.EMAIL ='"+id+"') AND U.CONTRASENYA='"+contrasenya+"'");
        if(products.next()){
         statement = connection.createStatement();
         statement.executeUpdate("UPDATE USUARIO SET CONECTADO=TRUE WHERE IDUSUARIO="+products.getInt("IDUSUARIO"));
         Usuario user = new Usuario(products.getInt("idusuario"),products.getString("username"),products.getString("contrasenya"),
                            products.getString("email"), products.getString("fotoPerfil"),products.getDate("fechaAlta"),
                            products.getInt("tipousuario"));
         pool.freeConnection(connection);
         return user;
        }
        else{
            pool.freeConnection(connection);
            return null;
        }
    }
   
    //Actualiza los datos de la DB con los datos actuales en la instancia.
    public void updateUser()
            throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE USUARIO U SET USERNAME='"+username+"', CONTRASENYA='"+contrasenya+"',FOTOPERFIL ='"+fotoPerfil+"' WHERE U.IDUSUARIO="+id);
        pool.freeConnection(connection);
    }
    
    public Usuario getInstanciaUsuario(String id)
            throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet products = statement.executeQuery("SELECT * FROM USUARIO U WHERE USERNAME='"+id+"'");
        products.next();
        Usuario user = new Usuario(products.getInt("idusuario"),products.getString("username"),"",
                            products.getString("email"), products.getString("fotoPerfil"), products.getDate("fechaAlta"),
                            products.getInt("tipousuario"));
         pool.freeConnection(connection);
         return user;
    }
    
    public Usuario getUsuarioById(int id)
            throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet products = statement.executeQuery("SELECT * FROM USUARIO U WHERE IDUSUARIO='"+id+"'");
        products.next();
        Usuario user = new Usuario(products.getInt("idusuario"),products.getString("username"),"",
                            products.getString("email"), products.getString("fotoPerfil"), products.getDate("fechaAlta"),
                            products.getInt("tipousuario"));
         pool.freeConnection(connection);
         return user;
    }
    
    public void desconectar()
        throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE USUARIO U SET CONECTADO=false WHERE U.IDUSUARIO="+id);
        pool.freeConnection(connection);
    }
}