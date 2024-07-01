/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.jsp_mysql;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Migue
 */
@WebServlet(name = "servletusuario", urlPatterns = {"/servletusuario"})
public class servletusuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if("mostrar".equals(action)){
            mostrarUsuarios(request, response);
        }
        else if("guardar".equals(action)){
            mostrarUsuariosGuardar(request, response);
        }
        else if("modificar".equals(action)){
            mostrarUsuariosModificar(request, response);
        }
        else if("eliminar".equals(action)){
            mostrarUsuariosEliminar(request, response);
        }
        
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String action = request.getParameter("action");
        
        if ("guardar".equals(action)){
            guardarUsuarios(request, response);
        }else if ("modificar".equals(action)){
            modoficarUsuarios(request, response);
        }else if ("eliminar".equals(action)){
            eliminarUsuarios(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    public void guardarUsuarios(HttpServletRequest request, HttpServletResponse responde)
    throws ServletException, IOException{
        
        String nombreP = request.getParameter("nombreP");
        String nombreS = request.getParameter("nombreS");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoS = request.getParameter("apellidoS");
        String carreraU = request.getParameter("carreraU");
        int edad = Integer.parseInt(request.getParameter("edad"));
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.insertarUsuario(nombreP, nombreS, apellidoP, apellidoS, carreraU, edad);
        
        mostrarUsuariosGuardar(request,responde);
                
    }
    
    public void mostrarUsuarios(HttpServletRequest request, HttpServletResponse responde)
    throws ServletException, IOException
    {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        List<EntidadUsuario> usuarios = usuarioDAO.obtenerUsuarios();
        
        request.setAttribute("listausuarios",usuarios);
        
        request.getRequestDispatcher("MostrarEstudiantes.jsp").forward(request, responde);
        
    }
    
    public void mostrarUsuariosGuardar(HttpServletRequest request, HttpServletResponse responde)
    throws ServletException, IOException
    {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        List<EntidadUsuario> usuarios = usuarioDAO.obtenerUsuarios();
        
        request.setAttribute("listausuarios",usuarios);
        
        request.getRequestDispatcher("guardarUsuarios.jsp").forward(request, responde);
        
    }
    
    public void modoficarUsuarios(HttpServletRequest request, HttpServletResponse responde)
    throws ServletException, IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombreP = request.getParameter("nombreP");
        String nombreS = request.getParameter("nombreS");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoS = request.getParameter("apellidoS");
        String carreraU = request.getParameter("carreraU");
        int edad = Integer.parseInt(request.getParameter("edad"));
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.modificarUsuario(id, nombreP, nombreS, apellidoP, apellidoS, carreraU, edad);
        
        mostrarUsuariosModificar(request,responde);
                
    }
    
    public void mostrarUsuariosModificar(HttpServletRequest request, HttpServletResponse responde)
    throws ServletException, IOException
    {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        List<EntidadUsuario> usuarios = usuarioDAO.obtenerUsuarios();
        
        request.setAttribute("listausuarios",usuarios);
        
        request.getRequestDispatcher("modificarUsuarios.jsp").forward(request, responde);
        
    }
    
    public void mostrarUsuariosEliminar(HttpServletRequest request, HttpServletResponse responde)
    throws ServletException, IOException
    {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        List<EntidadUsuario> usuarios = usuarioDAO.obtenerUsuarios();
        
        request.setAttribute("listausuarios",usuarios);
        
        request.getRequestDispatcher("eliminarUsuarios.jsp").forward(request, responde);
        
    }
    
    public void eliminarUsuarios(HttpServletRequest request, HttpServletResponse responde)
    throws ServletException, IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.eliminarUsuario(id);
        
        mostrarUsuariosEliminar(request,responde);
                
    }
}
