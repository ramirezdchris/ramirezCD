/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.BusesBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author christian.ramirezusa
 */
public class BusesDao {

    Conexion con = new Conexion();

    PreparedStatement ps;
    ResultSet rs;

    String sql;

    public boolean add(BusesBean bb) {
        sql = "INSERT INTO Buses VALUES(?,?,?,?,?)";

        try {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, bb.getIdBuses());
            ps.setString(2, bb.getPlaca());
            ps.setString(3, bb.getMarca());
            ps.setString(4, bb.getModelo());
            ps.setInt(5, bb.getAsientos());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }

    public List<BusesBean> list() {
        sql = "SELECT * FROM Buses";

        try {
            ps = con.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            List<BusesBean> list = new ArrayList<>();
            
            while (rs.next()) {
                BusesBean bb = new BusesBean();
                bb.setIdBuses(rs.getInt(1));
                bb.setPlaca(rs.getString(2));
                bb.setMarca(rs.getString(3));
                bb.setModelo(rs.getString(4));
                bb.setAsientos(rs.getInt(5));
                list.add(bb);                
            }
            return list;

        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean update(BusesBean bb) {
        sql = "UPDATE buses SET placa = ?, marca = ?, modelo = ?, asientos = ? WHERE idBuses = ?";

        try {
            ps = con.conectar().prepareStatement(sql);                        
            ps.setString(1, bb.getPlaca());
            ps.setString(2, bb.getMarca());
            ps.setString(3, bb.getModelo());
            ps.setInt(4, bb.getAsientos());
            ps.setInt(5, bb.getIdBuses());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }
    
}
