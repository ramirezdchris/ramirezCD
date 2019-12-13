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

    public boolean add(NinoBean nb) {

        sql = "INSERT INTO nino VALUES(?,?,?,?)";
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

    public List<NinoBean> list(int id) {
        sql = "SELECT a.nombreNino, a.apellidoNino, b.nombreApoderado FROM Nino a\n"
                + "INNER JOIN apoderado b ON b.idApoderado = a.idApoderado WHERE a.idApoderado = ?;";

        try {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            List<NinoBean> list = new ArrayList<>();

            while (rs.next()) {
                NinoBean nb = new NinoBean();
                ApoderadoBean apb = new ApoderadoBean();
                //nb.setIdNino(rs.getInt());
                nb.setNombreNino(rs.getString(1));
                nb.setApellidoNino(rs.getString(2));
                apb.setNombreApoderado(rs.getString(3));
                nb.setIdApoderado(apb);
                list.add(nb);
            }
            return list;

        } catch (Exception e) {
            System.out.println("Aqui esta");
            System.out.println("Error: " + e.getMessage());
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
