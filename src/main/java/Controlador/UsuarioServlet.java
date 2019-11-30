/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.UsuarioDao;
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
        
        rol = ud.login(user, pass);
        
        if (rol == "null") {
            session.setAttribute("rol", "null");
            request.setAttribute("msg", "Credenciales Invalidas");
            rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }else{
            if(rol.equals("Super Administrador")){
                session.setAttribute("Super", rol);
                rd = request.getRequestDispatcher("/SA/menu.jsp");
                rd.forward(request, response);
            }
            else if(rol.equals("Apoderado")){
                session.setAttribute("Admin", rol);
                rd = request.getRequestDispatcher("/Apoderado/menu.jsp");
                rd.forward(request, response);
            }
        }       
    }
    
    protected void salir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
       if(session != null){
           session.invalidate();
           rd = request.getRequestDispatcher("login.jsp");
           rd.forward(request, response);
       }
    }
    

}
