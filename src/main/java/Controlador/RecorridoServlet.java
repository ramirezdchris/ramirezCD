/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.BarrioDao;
import Dao.BusChoferDao;
import Dao.ColegioDao;
import Dao.ModalidadDao;
import Dao.RecorridoDao;
import Modelo.BarrioBean;
import Modelo.BusesChoferBean;
import Modelo.ColegioBean;
import Modelo.ModalidadBean;
import Modelo.RecorridoBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author christian.ramirezusa
 */
@WebServlet(name = "RecorridoServlet", urlPatterns = {"/recorrido"})
public class RecorridoServlet extends HttpServlet {

    RequestDispatcher rd;
    String msg;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add": add(request, response); break;
            //case "list": list(request, response); break;
            case "listas":
                listas(request, response);
                break;
            default:
                System.err.println("No entro a ningun metodo");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void listas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ColegioBean cb = new ColegioBean();
        BarrioBean barriob = new BarrioBean();
        ModalidadBean modab = new ModalidadBean();
        BusesChoferBean bcb = new BusesChoferBean();

        BusChoferDao bcd = new BusChoferDao();
        ColegioDao cd = new ColegioDao();
        BarrioDao barriod = new BarrioDao();
        ModalidadDao modad = new ModalidadDao();

        List<ColegioBean> lista1 = cd.list();
        List<BarrioBean> lista2 = barriod.list();
        List<ModalidadBean> lista3 = modad.list();
        List<BusesChoferBean> lista = bcd.list();

        request.setAttribute("lista1", lista1);
        request.setAttribute("lista2", lista2);
        request.setAttribute("lista3", lista3);
        request.setAttribute("list", lista);

        rd = request.getRequestDispatcher("/SuperAdministrador/recorridos.jsp");
        rd.forward(request, response);
    }

    /*
    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BusesChoferBean bcb = new BusesChoferBean();
        BusChoferDao bcd = new BusChoferDao();
        BusesDao bd = new BusesDao();
        ChoferDao cd = new ChoferDao();
        AsistenteDao ad = new AsistenteDao();
        
        List<BusesChoferBean> lista = bcd.list();
                
        request.setAttribute("list", lista);        
        
        rd = request.getRequestDispatcher("/SuperAdministrador/BusChofer2.jsp");
        rd.forward(request, response);                        
    }
     */
    protected void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int colegio, barrio, modalidad, buseschofer;
        colegio = Integer.parseInt(request.getParameter("txtColegios"));
        barrio = Integer.parseInt(request.getParameter("txtBarrio"));
        modalidad = Integer.parseInt(request.getParameter("txtModalidad"));
        buseschofer = Integer.parseInt(request.getParameter("txtBusesChofer"));

        RecorridoBean recob = new RecorridoBean(0);
        ModalidadBean mdb = new ModalidadBean();
        BarrioBean barriob = new BarrioBean();
        ColegioBean cb = new ColegioBean();

        BusesChoferBean bcb = new BusesChoferBean();
        BusChoferDao bcd = new BusChoferDao();
        
        RecorridoDao recorridod = new RecorridoDao();
        
        cb.setIdColegio(colegio);
        barriob.setIdBarrio(barrio);
        mdb.setIdModalidad(modalidad);
        bcb.setIdBusesChofer(buseschofer);
        
        recob.setIdModalidad(mdb);
        recob.setIdBarrio(barriob);
        recob.setIdColegio(cb);
        recob.setIdBusesChofer(bcb);
                
        if (recorridod.add(recob)) {
            msg = "Recorrido insertardo";
            request.setAttribute("msg", msg);
            rd = request.getRequestDispatcher("/SuperAdministrador/recorridos.jsp");
            rd.forward(request, response);
        }

        /*
        List<BusesBean> lista1 = bd.list();
        List<ChoferBean> lista2 = cd.list();
        List<AsistenteBean> lista3 = ad.list();
        
        request.setAttribute("lista1", lista1);
        request.setAttribute("lista2", lista2);
        request.setAttribute("lista3", lista3);
        
        rd = request.getRequestDispatcher("/BusChofer1.jsp");
        rd.forward(request, response);                        */
    }

}
