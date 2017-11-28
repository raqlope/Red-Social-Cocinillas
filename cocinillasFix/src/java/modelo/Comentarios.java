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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristina
 */
public class Comentarios {
    
    private int id;
    private int receta;
    private int autor;
    private String texto;
    private Date fecha;
    
    private ConnectionPool poolConexiones;
    private Connection conexion;
    
    private Statement statement;
    private ResultSet products;
    
    public Comentarios(){
        poolConexiones = ConnectionPool.getInstance();
        conexion = poolConexiones.getConnection();
        
        id = 0;
        receta = 0;
        autor = 0;
        texto = "";
        fecha = null;
    }
    
    public Comentarios(int id, int receta, int autor, String texto, Date fecha){
        poolConexiones = ConnectionPool.getInstance();
        conexion = poolConexiones.getConnection();
        
        this.id = id;
        this.receta = receta;
        this.autor = autor;
        this.texto = texto;
        this.fecha = fecha;
    }
    
    public int getId(){return id;}
    public int getReceta(){return receta;}
    public int getAutor(){return autor;}
    public String getTexto(){return texto;}
    public Date getFecha(){return fecha;}
    
    public ArrayList<Comentarios> recogerComentario(int receta){
        ArrayList<Comentarios> comen = null;
        
        try {
            statement = conexion.createStatement();
            products = statement.executeQuery("SELECT * FROM COMENTARIORECETA C WHERE C.idreceta="+ id +"");
            
            while(products.next()){
                comen.add(new Comentarios(products.getInt("idcomentario"),products.getInt("idreceta"),products.getInt("idautor"),products.getString("texto"),products.getDate("fechapubl")));
            }
            
            return comen;
        } catch (SQLException ex) {
            Logger.getLogger(Recetas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void anyadirComentario(int autor, int receta, String texto){
        try {
            statement = conexion.createStatement();
            products = statement.executeQuery("INSERT INTO COMENTARIORECETA (IDRECETA, IDAUTOR, TEXTO, FECHAPUBL) VALUES ("+receta+","+autor+","+texto+","+new Date(Calendar.getInstance().getTimeInMillis())+")");
            
        } catch (SQLException ex) {
            Logger.getLogger(Recetas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
