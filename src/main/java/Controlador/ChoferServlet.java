/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.ChoferDao;
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
@WebServlet(name = "ChoferServlet", urlPatterns = {"/chofer"})
public class ChoferServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
    }

    protected void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        ChoferBean cb = new ChoferBean(0);
        ChoferDao cd = new ChoferDao();
        
        String dui = request.getParameter("txtDui");
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String licencia = request.getParameter("txtLicencia");        
        
        cb.setDui(dui);
        cb.setNombreChofer(nombre);
        cb.setApellidoChofer(apellido);
        cb.setLicencia(licencia);
                
        if(cd.add(cb)){
            list(request, response);
        }
    }
    
    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        ChoferBean cb = new ChoferBean(0);
        ChoferDao cd = new ChoferDao();
        
        List<ChoferBean> list = cd.list();
        request.setAttribute("list", list);
        rd = request.getRequestDispatcher("/SuperAdministrador/chofer.jsp");
        rd.forward(request, response);
        
    }
    

}
