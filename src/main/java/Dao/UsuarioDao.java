/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.ApoderadoBean;
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

    public UsuariosBean login(String user, String pass) {
        sql = "SELECT a.rol, b.nombreApoderado, a.idApoderado FROM usuarios a\n"
                + "LEFT JOIN Apoderado b ON b.idApoderado = a.idApoderado WHERE username = ? AND clave = ?";
        
        UsuariosBean ub = new UsuariosBean();
        try {
            ps = con.conectar().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            //String rol = "null";
            
            while (rs.next()) {
                ub = new UsuariosBean();
                ApoderadoBean ap = new ApoderadoBean();
                ub.setRol(rs.getString(1));
                ap.setNombreApoderado(rs.getString(2));
                ap.setIdApoderado(rs.getInt(3));
                ub.setIdApoderado(ap);
                System.out.println("Aqui en el dao 1: " +ub.getRol());
                System.out.println("Aqui en el dao 2: " +ub.getIdApoderado().getNombreApoderado());
                //rol = ub.getRol();
                return ub;
            }
            return ub;
        } catch (Exception e) {            
            return null;
        }
    }
}
