/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.ApoderadoDao;
import Modelo.ApoderadoBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ApoderadoServlet", urlPatterns = {"/apoderado"})
public class ApoderadoServlet extends HttpServlet {

    RequestDispatcher rd;
    String msg;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch(action){
            case "add": add(request, response); break;
            case "menu": menu(request, response); break;
            default: System.out.println("No entreo a ningun metodo");
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
        ApoderadoBean apb = new ApoderadoBean(0);
        ApoderadoDao apd = new ApoderadoDao();
        
        apb.setNombreApoderado(request.getParameter("txtNombres"));
        apb.setApellidoApoderado(request.getParameter("txtApellidos"));
        apb.setDireccionApoderado(request.getParameter("txtDireccion"));
        apb.setTelefono(request.getParameter("txtTelefono"));
        apb.setCorreo(request.getParameter("txtCorreo"));
        apb.setDui(request.getParameter("txtDui"));
        
        System.out.println(apb.getCorreo());
        
        if(apd.add(apb)){
            msg = "Sus credenciales para iniciar sesion son: " +apb.getCorreo() +" " +"Contraseña: " +apb.getDui();
            request.setAttribute("msg", msg);
            rd = request.getRequestDispatcher("/crearCuenta.jsp");
            rd.forward(request, response);
        }else{
            msg = "Error al crear cuenta";
            request.setAttribute("msg", msg);
            rd = request.getRequestDispatcher("/crearCuenta.jsp");
            rd.forward(request, response);
        }
                
    }
    
    
    protected void menu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                                
            rd = request.getRequestDispatcher("/Apoderado/menu.jsp");
            rd.forward(request, response);                        
    }
    
    
    

}
