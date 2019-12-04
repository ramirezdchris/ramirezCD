/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.BarrioDao;
import Modelo.BarrioBean;
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
@WebServlet(name = "BarrioServlet", urlPatterns = {"/barrio"})
public class BarrioServlet extends HttpServlet {

    
    RequestDispatcher rd;
    String msg;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            
        BarrioBean barriobean = new BarrioBean(0);
        BarrioDao barriodao = new BarrioDao();
        
        String barrio = request.getParameter("txtBarrio");
        String direccion = request.getParameter("txtDireccion");
        
        
        
        barriobean.setBarrio(barrio);        
                
        if(barriodao.add(barriobean)){
            list(request, response);
        }
    }
    
    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        BarrioBean barriobean = new BarrioBean(0);
        BarrioDao barriodao = new BarrioDao();
        
        List<BarrioBean> list = barriodao.list();
        request.setAttribute("list", list);
        rd = request.getRequestDispatcher("/SuperAdministrador/barrio.jsp");
        rd.forward(request, response);
        
    }
    

}
