/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import data.ConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristina
 */
public class Recetas {
    
    private int id;
    private int autor;
    private String titulo;
    private int numCom;
    private String instrucciones;
    private ArrayList<String> ingredientes;
    private String foto;
    private String video;
    private int likes;
    private ArrayList<String> etiquetas;
    private Date fechaPubl;
    
    private ArrayList<Comentarios> comentarios;
    private ArrayList<Integer> amigos;
    
    private ConnectionPool poolConexiones;
    private Connection conexion;
    
    private Statement statement;
    private ResultSet products;
    
    
    public Recetas(){
        poolConexiones = ConnectionPool.getInstance();
        conexion = poolConexiones.getConnection();
        
        id = 0;
        autor = 0;
        titulo = "";
        numCom = 0;
        instrucciones = "";
        ingredientes = new ArrayList<String>();
        foto = "";
        video = "";
        likes = 0;
        etiquetas = new ArrayList<String>();
        fechaPubl = null;
    }
    
    public Recetas(int id, int autor, String titulo, int numCom, String instrucciones,
            ArrayList<String> ingredientes, String foto, String video, int likes, ArrayList<String> etiquetas, Date fechaPubl){
        poolConexiones = ConnectionPool.getInstance();
        conexion = poolConexiones.getConnection();
        
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.numCom = numCom;
        this.instrucciones = instrucciones;
        this.ingredientes = ingredientes;
        this.foto = foto;
        this.video = video;
        this.likes = likes;
        this.etiquetas = etiquetas;
        this.fechaPubl = fechaPubl;
        
    }
    
    public Recetas(int id, String titulo, String instrucciones, String foto, String video){
        this.id = id;
        this.titulo = titulo;
        this.instrucciones = instrucciones;
        this.foto = foto;
        this.video = video;
    }
    
    public int getId(){return id;}
    public int getAutor(){return autor;}
    public String getTitulo(){return titulo;}
    public int getNumCom(){return numCom;}
    public String getInstrucciones(){return instrucciones;}
    public ArrayList<String> getIngredientes(){return ingredientes;}
    public String getFoto(){return foto;}
    public String getVideo(){return video;}
    public int getLikes(){return likes;}
    public ArrayList<String> getEtiquetas(){return etiquetas;}
    public Date getFechaPubl(){return fechaPubl;}
    
    public ArrayList<Comentarios> getComentarios(){return comentarios;}
    public ArrayList<Integer> getAmigos(){return amigos;}//hay que ver que es mejor, si hacer el array de ids o de los usuarios.
    
    public void recogerReceta(int id){
        String [] ingre, eti;
        Comentarios com = new Comentarios();
        
        try {
            statement = conexion.createStatement();
            products = statement.executeQuery("SELECT * FROM RECETA R WHERE R.idreceta="+ id +"");
            if(products.next()){
                this.autor = products.getInt("autor");
                this.numCom = products.getInt("numerocomensales");
                this.likes = products.getInt("likes");
                this.titulo = products.getString("titulo");
                this.instrucciones = products.getString("intrucciones");
                this.foto = products.getString("foto");
                this.video = products.getString("video");
                ingre = new String[products.getString("ingredientes").split(";").length];
                ingre = products.getString("ingredientes").split(";");
                for(int i=0;i<ingre.length;i++){
                    this.ingredientes.add(ingre[i]);
                }
                eti = new String[products.getString("etiquetas").split(";").length];
                eti = products.getString("etiquetas").split(";");
                for(int i=0;i<eti.length;i++){
                    this.etiquetas.add(eti[i]);
                }
                this.fechaPubl = products.getDate("fechapubl");
                
                this.comentarios = com.recogerComentario(id);
                //Faltan recoger los amigos que tiene
            }
        } catch (SQLException ex) {
            Logger.getLogger(Recetas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String obtenerAutor(int id){
        try {
            statement = conexion.createStatement();
            products = statement.executeQuery("SELECT U.USERNAME FROM USUARIO U WHERE U.IDUSUARIO="+ id +"");
            if(products.next()){
                return products.getString("username");
            }
            else return null;
        } catch (SQLException ex) {
            Logger.getLogger(Recetas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void anyadirLike(int id, int autor){
        try {
            statement = conexion.createStatement();
            products = statement.executeQuery("INSERT INTO FAVORITO (IDUSUARIO, IDRECETA) VALUES ("+autor+","+id+")");
            
        } catch (SQLException ex) {
            Logger.getLogger(Recetas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void anyadirFav(int id, int autor){
        try {
            statement = conexion.createStatement();
            products = statement.executeQuery("INSERT INTO GUSTADO (IDUSUARIO, IDRECETA) VALUES ("+autor+","+id+")");
            
        } catch (SQLException ex) {
            Logger.getLogger(Recetas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Recetas> filtrarRecetas(String etiqueta) throws SQLException{
        
        ArrayList<Recetas> listaRecetas = new ArrayList<Recetas>();
        
        String query = "SELECT idreceta, titulo, intrucciones, foto, video FROM receta WHERE etiquetas LIKE '%"+etiqueta+"%' ";
        
        statement = conexion.createStatement();
        products = statement.executeQuery(query);
        
        while(products.next()){
            int idReceta = products.getInt ("idreceta");
            String tituloReceta = products.getString ("titulo");
            String instruccionesReceta = products.getString ("intrucciones");
            String fotoReceta = products.getString ("foto");
            String videoReceta = products.getString("video");
            listaRecetas.add(new Recetas(idReceta, tituloReceta, instruccionesReceta, fotoReceta, videoReceta));
        }
                 
        products.close();
        statement.close();
        poolConexiones.freeConnection(conexion); 
                
        return listaRecetas;
                        
    }
    public void setAutor(int autor){
        this.autor = autor;
    }
    public void setComensales(int comensales){
        this.numCom = comensales;
    }

    public void setPreparacion(String preparacion) {
        this.instrucciones = preparacion;
    }
    public void setTitulo (String titulo){
        this.titulo = titulo;
    }
    public void  setEtiquetas (ArrayList etiquetas){
        this.etiquetas = etiquetas;
    }
    public void setFecha(Date fecha){
        this.fechaPubl = fecha;
    }
    public void subirReceta() throws SQLException{
        poolConexiones = ConnectionPool.getInstance();
        conexion = poolConexiones.getConnection();
        
        statement = conexion.createStatement();
        statement.executeQuery("INSERT INTO RECETA (AUTOR,TITULO,NUMEROCOMENSALES,INSTRUCCIONES,INGREDIENTES,FOTO, VIDEO,ETIQUETAS,FECHAPUBL) VALUES ("+autor+","+titulo+","+numCom+","+instrucciones+","+ingredientes+","+","+foto+","+video+","+etiquetas+","+fechaPubl);
        
    
    
    }
    
}
