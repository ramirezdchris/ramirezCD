/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.AsistenteBean;
import Modelo.AsistenteBean;
import Modelo.BarrioBean;
import Modelo.BarrioBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author christian.ramirezusa
 */
public class BarrioDao {

    Conexion con = new Conexion();

    PreparedStatement ps;
    ResultSet rs;

    String sql;

    public boolean add(BarrioBean barb) {
        sql = "INSERT INTO Barrio VALUES(?,?)";

        try {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, barb.getIdBarrio());
            ps.setString(2, barb.getBarrio());            
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }

    public List<BarrioBean> list() {
        sql = "SELECT * FROM Barrio";

        try {
            ps = con.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            List<BarrioBean> list = new ArrayList<>();
            
            while (rs.next()) {
                BarrioBean barb = new BarrioBean();
                barb.setIdBarrio(rs.getInt(1));
                barb.setBarrio(rs.getString(2));                
                list.add(barb);                
            }
            return list;

        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean update(BarrioBean barb) {
        sql = "UPDATE Barrio SET barrio = ? WHERE idBarrio = ?";

        try {
            ps = con.conectar().prepareStatement(sql);                                                                        
            ps.setString(1, barb.getBarrio());
            ps.setInt(2, barb.getIdBarrio());            
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }
    
}
