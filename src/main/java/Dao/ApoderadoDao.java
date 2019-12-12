/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.ApoderadoBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author christian.ramirezusa
 */
public class ApoderadoDao {
    Conexion con = new Conexion();
    
    PreparedStatement ps;
    ResultSet rs;
    
    String sql;
    
    public boolean add(ApoderadoBean ap){
        sql  = "INSERT INTO Apoderado VALUES(?,?,?,?,?,?,?)";
        
        try {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, ap.getIdApoderado());
            ps.setString(2, ap.getNombreApoderado());
            ps.setString(3, ap.getApellidoApoderado());
            ps.setString(4, ap.getDireccionApoderado());
            ps.setString(5, ap.getTelefono());
            ps.setString(6, ap.getCorreo());
            ps.setString(7, ap.getDui());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }
    
    
    
}
