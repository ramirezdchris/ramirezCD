/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Dao.UsuarioDao;
import Modelo.UsuariosBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author christian.ramirezusa
 */
public class Conexion {
    static String db = "TioJuanito";
    static String user = "root";
    static String pass = "root";
    static String url = "jdbc:mysql://localhost/"+db+"?useSSL=false";
    
    Connection conn = null;

    public Conexion() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            if(conn != null){
                System.out.println("Conectado a la base de datos");
            }            
        } catch (Exception e) {
            System.err.println("Error de conexion: "+e);
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar() throws SQLException{
        conn.close();
    }
    
    public static void main(String[] args) {
        Conexion con = new Conexion();
        
        UsuariosBean ub = new UsuariosBean();
        UsuarioDao ud = new UsuarioDao();
        
        
        // Probando metodo del login
        /*
        String user = "cr@gmail.com";
        String clave = "000000-0";
        
        //ub.setUsername(user);
        //ub.setClave(clave);
        
        System.out.println(ud.login(user, clave));*/
        
    }
}
