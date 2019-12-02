/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.BusesDao;
import Modelo.BusesBean;
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
@WebServlet(name = "BusesServlet", urlPatterns = {"/buses"})
public class BusesServlet extends HttpServlet {

    RequestDispatcher rd;
    String msg;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hola");
        String action = request.getParameter("action");
        
        switch(action){
            case "add": add(request, response); break;
            case "list": list(request, response); break;
            default: System.err.println("No entro a ningun metodo"); break;
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

    protected void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        BusesBean bb = new BusesBean(0);
        BusesDao bd = new BusesDao();
        
        String placa = request.getParameter("txtPlaca");
        String marca = request.getParameter("txtMarca");
        String modelo = request.getParameter("txtModelo");
        int asientos = Integer.parseInt(request.getParameter("txtAsientos"));
        
        bb.setPlaca(placa);
        bb.setMarca(marca);
        bb.setModelo(modelo);
        bb.setAsientos(asientos);
                
        if(bd.add(bb)){
            list(request, response);
        }
    }
    
    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        BusesBean bb = new BusesBean(0);
        BusesDao bd = new BusesDao();
        
        List<BusesBean> list = bd.list();
        request.setAttribute("list", list);
        rd = request.getRequestDispatcher("/buses.jsp");
        rd.forward(request, response);
        
    }
    
    

}
