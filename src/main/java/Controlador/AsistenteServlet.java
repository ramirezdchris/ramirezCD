/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.AsistenteDao;
import Modelo.AsistenteBean;
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
@WebServlet(name = "AsistenteServlet", urlPatterns = {"/asistente"})
public class AsistenteServlet extends HttpServlet {

    
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
            
        AsistenteBean ab = new AsistenteBean(0);
        AsistenteDao ad = new AsistenteDao();
        
        String dui = request.getParameter("txtDui");
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");                
        
        ab.setDui(dui);
        ab.setNombreAsistente(nombre);
        ab.setApellidoAsistente(apellido);        
                
        if(ad.add(ab)){
            list(request, response);
        }
    }
    
    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        AsistenteBean ab = new AsistenteBean(0);
        AsistenteDao ad = new AsistenteDao();
        
        List<AsistenteBean> list = ad.list();
        request.setAttribute("list", list);
        rd = request.getRequestDispatcher("/SuperAdministrador/asistente.jsp");
        rd.forward(request, response);
        
    }
    
}
