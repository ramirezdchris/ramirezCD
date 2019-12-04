/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.AsistenteBean;
import Modelo.BusesBean;
import Modelo.BusesChoferBean;
import Modelo.ChoferBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author christian.ramirezusa
 */
public class BusChoferDao {

    Conexion con = new Conexion();

    PreparedStatement ps;
    ResultSet rs;

    String sql;

    public boolean add(BusesChoferBean bcb) {

        sql = "INSERT INTO buseschofer VALUES(?,?,?,?)";

        try {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, bcb.getIdBusesChofer());
            ps.setInt(2, bcb.getIdBuses().getIdBuses());
            ps.setInt(3, bcb.getIdChofer().getIdChofer());
            ps.setInt(4, bcb.getIdAsistente().getIdAsistente());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }

    public List<BusesChoferBean> list() {
        sql = "SELECT a.idBusesChofer,b.placa AS PlacadeAutoBus,CONCAT(c.nombreChofer,' ', c.apellidoChofer) AS NombreChofer , CONCAT(d.nombreAsistente,' ', d.apellidoAsistente) AS NombreAsistente FROM buseschofer a\n"
                + "INNER JOIN buses b ON b.idBuses = a.idBuses\n"
                + "INNER JOIN chofer c ON c.idChofer = a.idChofer\n"
                + "INNER JOIN asistente d ON d.idAsistente = a.idAsistente;";

        try {
            ps = con.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            List<BusesChoferBean> list = new ArrayList<>();

            while (rs.next()) {
                BusesChoferBean bcb = new BusesChoferBean();
                BusesBean bb = new BusesBean();
                ChoferBean cb = new ChoferBean();
                AsistenteBean ab = new AsistenteBean();
                
                bcb.setIdBusesChofer(rs.getInt(1));
                bb.setPlaca(rs.getString(2));
                cb.setNombreChofer(rs.getString(3));
                ab.setNombreAsistente(rs.getString(4));
                
                bcb.setIdBuses(bb);
                bcb.setIdChofer(cb);
                bcb.setIdAsistente(ab);

                list.add(bcb);
            }
            return list;
        } catch (Exception e) {
            System.out.println(ps);
            return null;
        }

    }
}
