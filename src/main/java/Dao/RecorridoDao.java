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
import Modelo.BusesBean;
import Modelo.BusesChoferBean;
import Modelo.ChoferBean;
import Modelo.ColegioBean;
import Modelo.ModalidadBean;
import Modelo.RecorridoBean;
import Modelo.RecorridoBean;
import Modelo.RecorridoBean;
import Modelo.RecorridoBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author christian.ramirezusa
 */
public class RecorridoDao {

    Conexion con = new Conexion();

    PreparedStatement ps;
    ResultSet rs;

    String sql;

    SimpleDateFormat fhora = new SimpleDateFormat("HH:mm");

    public boolean add(RecorridoBean recob) {
        sql = "INSERT INTO Recorrido VALUES(?,?,?,?,?)";

        try {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, recob.getIdRecorrido());
            ps.setInt(2, recob.getIdModalidad().getIdModalidad());
            ps.setInt(3, recob.getIdBarrio().getIdBarrio());
            ps.setInt(4, recob.getIdColegio().getIdColegio());
            ps.setInt(5, recob.getIdBusesChofer().getIdBusesChofer());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }

    public List<RecorridoBean> list() {
        System.out.println("Entro 0");
        sql = "SELECT a.idRecorrido, b.modalidad, c.barrio, d.nombreColegio,f.placa, f.asientos, g.nombreChofer, h.nombreAsistente FROM recorrido a\n"
                + "INNER JOIN modalidad b ON b.idModalidad = a.idModalidad\n"
                + "INNER JOIN barrio c ON c.idBarrio = a.idBarrio\n"
                + "INNER JOIN colegio d ON d.idColegio = a.idColegio\n"
                + "INNER JOIN buseschofer e ON e.idBusesChofer = a.idBusesChofer\n"
                + "INNER JOIN buses f ON f.idBuses = e.idBuses\n"
                + "INNER JOIN chofer g ON g.idChofer = e.idChofer\n"
                + "INNER JOIN asistente h ON h.idAsistente = e.idAsistente order by a.idRecorrido ASC;";

        try {
            ps = con.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            List<RecorridoBean> list = new ArrayList<>();
            System.out.println("Entro 1");
            while (rs.next()) {
                System.out.println("Entro 2");
                RecorridoBean recob = new RecorridoBean();
                ModalidadBean mdb = new ModalidadBean();
                BarrioBean barriob = new BarrioBean();
                ColegioBean cb = new ColegioBean();

                BusesChoferBean bcb = new BusesChoferBean();
                BusesBean bb = new BusesBean();
                ChoferBean ccb = new ChoferBean();
                AsistenteBean aasb = new AsistenteBean();

                recob.setIdRecorrido(rs.getInt(1));
                mdb.setModalidad(rs.getString(2));
                barriob.setBarrio(rs.getString(3));
                cb.setNombreColegio(rs.getString(4));
                bb.setPlaca(rs.getString(5));
                bb.setAsientos(rs.getInt(6));
                ccb.setNombreChofer(rs.getString(7));
                aasb.setNombreAsistente(rs.getString(8));

                bcb.setIdBuses(bb);
                bcb.setIdChofer(ccb);
                bcb.setIdAsistente(aasb);

                recob.setIdModalidad(mdb);
                recob.setIdBarrio(barriob);
                recob.setIdColegio(cb);

                recob.setIdBusesChofer(bcb);

                System.out.println(recob.getIdBusesChofer().getIdAsistente().getNombreAsistente());
                list.add(recob);
            }
            return list;

        } catch (Exception e) {
            RecorridoBean recob = new RecorridoBean();
            System.out.println(recob.getIdBusesChofer().getIdAsistente().getNombreAsistente());
            System.out.println("No sirvio");
            System.out.println("Error en la lista");
            return null;
        }
    }

    public boolean update(RecorridoBean recob) {
        sql = "UPDATE recorrido SET idModalidad = ?, idBarrio = ?, idColegio = ?, idBusesChofer = ? WHERE idRecorrido = ?";

        try {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, recob.getIdModalidad().getIdModalidad());
            ps.setInt(2, recob.getIdBarrio().getIdBarrio());
            ps.setInt(3, recob.getIdColegio().getIdColegio());
            ps.setInt(4, recob.getIdBusesChofer().getIdBusesChofer());
            ps.setInt(5, recob.getIdRecorrido());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(ps);
            return false;
        }
    }

}
