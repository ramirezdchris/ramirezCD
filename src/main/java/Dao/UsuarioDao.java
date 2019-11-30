/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.UsuariosBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author christian.ramirezusa
 */
public class UsuarioDao {
    Conexion con = new Conexion();
    
    PreparedStatement ps;
    ResultSet rs;
    
    String sql;
    
    public String login(String user, String pass){
        sql = "SELECT rol FROM usuarios WHERE username = ? AND clave = ?";
        try {
            ps = con.conectar().prepareStatement(sql);            
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            String rol = "null";
            while(rs.next()){
                UsuariosBean ub = new UsuariosBean();                
                ub.setRol(rs.getString(1));
                rol = ub.getRol();
                return rol;
            }
            return rol;
        } catch (Exception e) {
            return null;
        }
    }
}
