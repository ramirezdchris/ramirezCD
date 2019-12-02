/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.AsistenteDao;
import Dao.BusChoferDao;
import Dao.BusesDao;
import Dao.ChoferDao;
import Modelo.AsistenteBean;
import Modelo.BusesBean;
import Modelo.BusesChoferBean;
import Modelo.ChoferBean;
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
@WebServlet(name = "BusesChoferServlet", urlPatterns = {"/buseschofer"})
public class BusesChoferServlet extends HttpServlet {

    RequestDispatcher rd;
    String msg;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch(action){
            case "add": add(request, response); break;
            case "list": list(request, response); break;
            case "listas": listas(request, response); break;
            default: System.err.println("No entro a ningun metodo");
        
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
        BusesDao bd = new BusesDao();
        ChoferDao cd = new ChoferDao();
        AsistenteDao ad = new AsistenteDao();
        
        List<BusesBean> lista1 = bd.list();
        List<ChoferBean> lista2 = cd.list();
        List<AsistenteBean> lista3 = ad.list();
        
        request.setAttribute("lista1", lista1);
        request.setAttribute("lista2", lista2);
        request.setAttribute("lista3", lista3);
        
        rd = request.getRequestDispatcher("/BusChofer1.jsp");
        rd.forward(request, response);                        
    }
    
    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BusesChoferBean bcb = new BusesChoferBean();
        BusChoferDao bcd = new BusChoferDao();
        BusesDao bd = new BusesDao();
        ChoferDao cd = new ChoferDao();
        AsistenteDao ad = new AsistenteDao();
        
        List<BusesChoferBean> lista = bcd.list();
                
        request.setAttribute("list", lista);        
        
        rd = request.getRequestDispatcher("/BusChofer2.jsp");
        rd.forward(request, response);                        
    }

    protected void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BusesDao bd = new BusesDao();
        ChoferDao cd = new ChoferDao();
        AsistenteDao ad = new AsistenteDao();
        
        int bus, chofer, asistente;
        bus = Integer.parseInt(request.getParameter("txtBuses"));
        chofer = Integer.parseInt(request.getParameter("txtChofer"));
        asistente = Integer.parseInt(request.getParameter("txtAsistente"));
        
        
        BusesBean bb = new BusesBean(bus);
        ChoferBean cb = new ChoferBean(chofer);
        AsistenteBean ab = new AsistenteBean(asistente);
        
        BusesChoferBean bcb = new BusesChoferBean();
        BusChoferDao bcd = new BusChoferDao();
        bcb.setIdBuses(bb);
        bcb.setIdChofer(cb);
        bcb.setIdAsistente(ab);
        
        
        
        if(bcd.add(bcb)){
            msg = "Equipo insertardo";
            request.setAttribute("msg", msg);
            rd = request.getRequestDispatcher("BusChofer1.jsp");
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
