/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.ApoderadoBean;
import Modelo.NinoBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author christian.ramirezusa
 */
public class NinoDao {
    Conexion con = new Conexion();
    
    PreparedStatement ps;
    ResultSet rs;
    
    String sql;
    
    public boolean add(NinoBean nb){
        
        sql = "INSERT INTO nino VALUES(?,?,?)";
        try {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, nb.getIdNino());
            ps.setString(2, nb.getNombreNino());
            ps.setString(3, nb.getApellidoNino());
            ps.setInt(4, nb.getIdApoderado().getIdApoderado());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println(ps);
            return false;
        }
    }
    
    public List<NinoBean> list() {
        sql = "SELECT a.nombreNino, a.apellidoNino, b.nombreApoderado FROM Nino a"
                + "INNER JOIN apoderado b ON b.idApoderado = a.idApoderado";

        try {
            ps = con.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            List<NinoBean> list = new ArrayList<>();
            
            while (rs.next()) {
                NinoBean nb = new NinoBean();
                ApoderadoBean apb = new ApoderadoBean();
                nb.setIdNino(rs.getInt(1));
                nb.setNombreNino(rs.getString(2));                
                nb.setApellidoNino(rs.getString(3));
                apb.setNombreApoderado(rs.getString(4));
                nb.setIdApoderado(apb);
                list.add(nb);                
            }
            return list;

        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean update(NinoBean nb) {
        sql = "UPDATE Nino SET nombreNino = ?, apellidoNino WHERE idNino = ? AND idApoderado = ?";

        try {
            ps = con.conectar().prepareStatement(sql);                                                                        
            ps.setString(1, nb.getNombreNino());
            ps.setString(2, nb.getApellidoNino());
            ps.setInt(3, nb.getIdNino());            
            ps.setInt(4, nb.getIdApoderado().getIdApoderado());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }
}

