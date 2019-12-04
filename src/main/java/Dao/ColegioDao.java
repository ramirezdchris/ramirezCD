/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.AsistenteBean;
import Modelo.AsistenteBean;
import Modelo.ColegioBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author christian.ramirezusa
 */
public class ColegioDao {

    Conexion con = new Conexion();

    PreparedStatement ps;
    ResultSet rs;

    String sql;

    public boolean add(ColegioBean cb) {
        sql = "INSERT INTO Colegio VALUES(?,?,?)";

        try {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, cb.getIdColegio());
            ps.setString(2, cb.getNombreColegio());
            ps.setString(3, cb.getDireccionColegio());            
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }

    public List<ColegioBean> list() {
        sql = "SELECT * FROM Colegio";

        try {
            ps = con.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            List<ColegioBean> list = new ArrayList<>();
            
            while (rs.next()) {
                ColegioBean cb = new ColegioBean();
                cb.setIdColegio(rs.getInt(1));
                cb.setNombreColegio(rs.getString(2));
                cb.setDireccionColegio(rs.getString(3));                
                list.add(cb);                
            }
            return list;

        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean update(ColegioBean cb) {
        sql = "UPDATE Colegio SET nombreColegio = ?, direcionColegio = ? WHERE idColegio = ?";

        try {
            ps = con.conectar().prepareStatement(sql);                                                                        
            ps.setString(1, cb.getNombreColegio());
            ps.setString(2, cb.getDireccionColegio());
            ps.setInt(3, cb.getIdColegio());            
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }
    
}
