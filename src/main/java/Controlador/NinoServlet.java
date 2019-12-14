/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.NinoDao;
import Dao.RecorridoDao;
import Modelo.ApoderadoBean;
import Modelo.NinoBean;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author christian.ramirezusa
 */
@WebServlet(name = "NinoServlet", urlPatterns = {"/nino"})
public class NinoServlet extends HttpServlet {

    RequestDispatcher rd;
    String msg;
    //int apoderado;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch(action){
            case "add": add(request, response); break;
            case "list": list(request, response); break;
            case "list2": listAddRecoriddo(request, response); break;
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
            
        NinoBean ninobean = new NinoBean(0);
        NinoDao ninodao = new NinoDao();
        ApoderadoBean apb = new ApoderadoBean();
        
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        int apoderado = Integer.parseInt(request.getParameter("txtPadre"));
        
        
        
        ninobean.setNombreNino(nombre);
        ninobean.setApellidoNino(apellido);
        apb.setIdApoderado(apoderado);
        ninobean.setIdApoderado(apb);
                
        if(ninodao.add(ninobean)){
            list(request, response);
        }
    }
    
    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        NinoBean ninobean = new NinoBean(0);
        NinoDao ninodao = new NinoDao();
                
        
        int apoderado = Integer.parseInt(request.getParameter("apoderado"));
        List<NinoBean> list = ninodao.list(apoderado);
        request.setAttribute("list", list);
        rd = request.getRequestDispatcher("Apoderado/agregarA.jsp");
        rd.forward(request, response);
        
    }
    
    protected void listAddRecoriddo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        NinoBean ninobean = new NinoBean(0);
        NinoDao ninodao = new NinoDao();
        
        RecorridoBean recob = new RecorridoBean();
        RecorridoDao recod = new RecorridoDao();
        
        
        int apoderado = Integer.parseInt(request.getParameter("apoderado"));
        List<NinoBean> list = ninodao.list(apoderado);
        List<RecorridoBean> list2 = recod.list();
        request.setAttribute("list", list);
        request.setAttribute("list2", list2);
        rd = request.getRequestDispatcher("Apoderado/agregarRecorrido.jsp");
        rd.forward(request, response);
        
    }
    
}
