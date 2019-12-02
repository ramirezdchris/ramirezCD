/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.ChoferBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author christian.ramirezusa
 */
public class ChoferDao {

    Conexion con = new Conexion();

    PreparedStatement ps;
    ResultSet rs;

    String sql;

    public boolean add(ChoferBean cb) {
        sql = "INSERT INTO Chofer VALUES(?,?,?,?,?)";

        try {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, cb.getIdChofer());
            ps.setString(2, cb.getDui());
            ps.setString(3, cb.getNombreChofer());
            ps.setString(4, cb.getApellidoChofer());
            ps.setString(5, cb.getLicencia());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }

    public List<ChoferBean> list() {
        sql = "SELECT * FROM Chofer";

        try {
            ps = con.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            List<ChoferBean> list = new ArrayList<>();
            
            while (rs.next()) {
                ChoferBean cb = new ChoferBean();
                cb.setIdChofer(rs.getInt(1));
                cb.setDui(rs.getString(2));
                cb.setNombreChofer(rs.getString(3));
                cb.setApellidoChofer(rs.getString(4));
                cb.setLicencia(rs.getString(5));
                list.add(cb);                
            }
            return list;

        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean update(ChoferBean cb) {
        sql = "UPDATE Chofer SET dui = ?, nombreChofer = ?, apellidoChofer = ?, licencia = ? WHERE idChofer = ?";

        try {
            ps = con.conectar().prepareStatement(sql);                                                
            ps.setString(1, cb.getDui());
            ps.setString(2, cb.getNombreChofer());
            ps.setString(3, cb.getApellidoChofer());
            ps.setString(4, cb.getLicencia());  
            ps.setInt(5, cb.getIdChofer());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }
    
}
