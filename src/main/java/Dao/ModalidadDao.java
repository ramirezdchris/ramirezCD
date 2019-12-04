/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.AsistenteBean;
import Modelo.AsistenteBean;
import Modelo.ModalidadBean;
import Modelo.ModalidadBean;
import Modelo.ModalidadBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author christian.ramirezusa
 */
public class ModalidadDao {

    Conexion con = new Conexion();

    PreparedStatement ps;
    ResultSet rs;

    String sql;
    
    SimpleDateFormat fhora = new SimpleDateFormat("HH:mm");

    public boolean add(ModalidadBean modab) {
        sql = "INSERT INTO Modalidad VALUES(?,?,?,?)";

        try {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, modab.getIdModalidad());
            ps.setString(2, modab.getModalidad());            
            ps.setString(3, fhora.format(modab.getRecoger()));
            ps.setString(4, fhora.format(modab.getDejar()));
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }

    public List<ModalidadBean> list() {
        sql = "SELECT * FROM Modalidad";

        try {
            ps = con.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            List<ModalidadBean> list = new ArrayList<>();
            
            while (rs.next()) {
                ModalidadBean modab = new ModalidadBean();
                modab.setIdModalidad(rs.getInt(1));
                modab.setModalidad(rs.getString(2));                
                modab.setRecoger(rs.getTime(3));
                modab.setDejar(rs.getTime(4));
                list.add(modab);                
            }
            return list;

        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean update(ModalidadBean modab) {
        sql = "UPDATE Modalidad SET modalidad = ?, recoger = ?, dejar = ? WHERE idModalidad = ?";

        try {
            ps = con.conectar().prepareStatement(sql);                                                                        
            ps.setString(1, modab.getModalidad());            
            ps.setString(2, fhora.format(modab.getRecoger()));
            ps.setString(3, fhora.format(modab.getDejar()));           
            ps.setInt(4, modab.getIdModalidad());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }
    
}
