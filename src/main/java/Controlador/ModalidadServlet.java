/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.ModalidadDao;
import Modelo.ModalidadBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ModalidadServlet", urlPatterns = {"/modalidad"})
public class ModalidadServlet extends HttpServlet {

    RequestDispatcher rd;
    String msg;
    
    SimpleDateFormat fhora = new SimpleDateFormat("HH:mm");
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ModalidadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ModalidadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
            
        ModalidadBean modab = new ModalidadBean(0);
        ModalidadDao modah = new ModalidadDao();
        
        String modalidad = request.getParameter("txtModalidad");
        String recoger = request.getParameter("txtRecoger");
        String dejar = request.getParameter("txtDejar");
        
        
        
        modab.setModalidad(modalidad);
        modab.setRecoger(fhora.parse(recoger));
        modab.setDejar(fhora.parse(dejar));
                
        if(modah.add(modab)){
            list(request, response);
        }
    }
    
    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        ModalidadBean modab = new ModalidadBean(0);
        ModalidadDao modah = new ModalidadDao();
        
        List<ModalidadBean> list = modah.list();
        request.setAttribute("list", list);
        rd = request.getRequestDispatcher("/SuperAdministrador/modalidad.jsp");
        rd.forward(request, response);
        
    }

}
