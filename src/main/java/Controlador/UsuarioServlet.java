/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.UsuarioDao;
import Modelo.ApoderadoBean;
import Modelo.UsuariosBean;
import java.io.IOException;
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
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/login"})
public class UsuarioServlet extends HttpServlet {

    RequestDispatcher rd;
    String msg;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch(action){
            case "login": login(request, response); break;
            case "salir": salir(request, response); break;
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

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String user, pass, rol;
        
        user = request.getParameter("txtUsu");
        pass = request.getParameter("txtClave");
        
        System.out.println(user  +pass);
        UsuariosBean ub = new UsuariosBean();
        UsuarioDao ud = new UsuarioDao();
        ApoderadoBean ap = new ApoderadoBean();
        
        
        ub=ud.login(user, pass);
        //System.out.println("Aquien el servlet: " +ub.getIdApoderado());
        //System.out.println("-----------------" +nombre);                
        
        if (ub.getRol() == null) {
            session.setAttribute("rol", "null");
            request.setAttribute("msg", "Credenciales Invalidas");
            rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }else{
            //System.out.println("Aqui en el servlet: " +ub.getIdApoderado().getNombreApoderado());
            if(ub.getRol().equals("Super Administrador")){
                session.setAttribute("Super", ub.getRol());
                
                rd = request.getRequestDispatcher("/menuSA.jsp");
                rd.forward(request, response);
            }
            else if(ub.getRol().equals("Apoderado")){
                //System.out.println("Aqui en el servlet: " +ub.getIdApoderado().getNombreApoderado());
                session.setAttribute("Admin", ub);                
                session.setAttribute("Id", ub.getIdApoderado().getIdApoderado());
                session.setAttribute("Nombre", ub.getIdApoderado().getNombreApoderado());
                rd = request.getRequestDispatcher("/menuA.jsp");
                rd.forward(request, response);
            }
        }       
    }
    
    protected void salir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
       if(session != null){
           session.invalidate();
           rd = request.getRequestDispatcher("TioJuanito/login.jsp");
           rd.forward(request, response);
       }
    }
    

}
