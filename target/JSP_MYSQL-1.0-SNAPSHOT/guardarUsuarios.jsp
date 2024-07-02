<%-- 
    Document   : guardarUsuarios
    Created on : 19 jun 2024, 17:00:46
    Author     : Migue
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.jsp_mysql.EntidadUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guardar Estudiantes UES</title>
        
        <style>
            body {
                background-color: #ffe6e6; /* Rojo pálido*/
            }
            
            .logo-right {
                position: absolute;
                top: 40px;
                right: 40px;
                width: 140px; 
            }
            
            .styled-button {
                margin: 5px;
                padding: 10px 20px;
                background-color: #800020; /* rojo vino */
                border: none;
                color: white;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                border-radius: 8px;
                transition-duration: 0.4s;
                cursor: pointer;
            }

            .styled-button:hover {
                background-color: white;
                color: #800020;
                border: 2px solid #800020;
            }
        </style>
    </head>
    <body>
        <h1>Guardar Estudiantes</h1>
        <a href="index.jsp"><button type="button" class="styled-button">Regresar al menu principal</button></a>
        
        <form action="servletusuario" method="POST">
            
            
            <p><label> Primer Nombre: </label> <input type="text" name="nombreP">
            <p><label> Segundo Nombre: </label> <input type="text" name="nombreS">
            <p><label> Primer Apellido: </label> <input type="text" name="apellidoP">
            <p><label> Segundo apellido: </label> <input type="text" name="apellidoS">
            <p><label> Carrera: </label> <input type="text" name="carreraU">
            <p><label> Edad: </label> <input type="number" name="edad">
                
                <button type="submit" name="action" value="guardar"> Guardar </button>
            
        </form>
        <h3>Lista de usuarios</h3>
        <table border ="1">
            
            <tr>
                <th>Id</th>
                <th>Primer Nombre</th>
                <th>Segundo Nombre</th>
                <th>Primer Apellido</th>
                <th>Segundo Apellido</th>
                <th>Carrera</th>
                <th>Edad</th>
            </tr>
            
            <%
                List<EntidadUsuario> usuarios = (List<EntidadUsuario>)request.getAttribute("listausuarios");
            
                for (EntidadUsuario usuario: usuarios){
            %>
            <tr>
                
                <td><%= usuario.getId() %></td>
                <td><%= usuario.getPrimerNombre()%></td>
                <td><%= usuario.getSegundoNombre()%></td>
                <td><%= usuario.getPrimerApellido() %></td>
                <td><%= usuario.getSegundoApellido()%></td>
                <td><%= usuario.getCarrera() %></td>
                <td><%= usuario.getEdad() %></td>
                
            </tr>
                <%
                 }
            
            %>
            
        </table>
        <img src="imagenes/729px-Escudo_de_la_Universidad_de_El_Salvador.svg.png" alt="Logo UES" class="logo-right">
    </body>
</html>
