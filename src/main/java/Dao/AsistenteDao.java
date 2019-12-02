/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.AsistenteBean;
import Modelo.AsistenteBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author christian.ramirezusa
 */
public class AsistenteDao {

    Conexion con = new Conexion();

    PreparedStatement ps;
    ResultSet rs;

    String sql;

    public boolean add(AsistenteBean ab) {
        sql = "INSERT INTO Asistente VALUES(?,?,?,?)";

        try {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, ab.getIdAsistente());
            ps.setString(2, ab.getDui());
            ps.setString(3, ab.getNombreAsistente());
            ps.setString(4, ab.getApellidoAsistente());            
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }

    public List<AsistenteBean> list() {
        sql = "SELECT * FROM Asistente";

        try {
            ps = con.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            List<AsistenteBean> list = new ArrayList<>();
            
            while (rs.next()) {
                AsistenteBean ab = new AsistenteBean();
                ab.setIdAsistente(rs.getInt(1));
                ab.setDui(rs.getString(2));
                ab.setNombreAsistente(rs.getString(3));
                ab.setApellidoAsistente(rs.getString(4));                
                list.add(ab);                
            }
            return list;

        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean update(AsistenteBean ab) {
        sql = "UPDATE Asistente SET dui = ?, nombreAsistente = ?, apellidoAsistente = ? WHERE idAsistente = ?";

        try {
            ps = con.conectar().prepareStatement(sql);                                                            
            ps.setString(1, ab.getDui());
            ps.setString(2, ab.getNombreAsistente());
            ps.setString(3, ab.getApellidoAsistente());
            ps.setInt(4, ab.getIdAsistente());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }
    
}
