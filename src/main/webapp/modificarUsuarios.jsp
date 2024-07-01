<%-- 
    Document   : modificarUsuarios
    Created on : 19 jun 2024, 18:25:57
    Author     : Migue
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.jsp_mysql.EntidadUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Estudiantes UES</title>
        
        <style>
            body {
                background-color: #ffe6e6; /* Rojo pálido muy leve */
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
        
        <h1>Modificar Estudiantes</h1>
        <a href="index.jsp"><button type="button" class="styled-button">Regresar al menu principal</button></a>
        
        <form action="servletusuario" method ="POST">
            
            <p><label> Id: </label> <input type="text" name="id" id ="idid" readonly>
            <p><label> Primer Nombre: </label> <input type="text" name="nombreP" id ="idnombreP">
            <p><label> Segundo Nombre: </label> <input type="text" name="nombreS" id ="idnombreS">
            <p><label> Primer Apellido: </label> <input type="text" name="apellidoP" id ="idapellidoP">
            <p><label> Segundo apellido: </label> <input type="text" name="apellidoS" id ="idapellidoS">
            <p><label> Carrera: </label> <input type="text" name="carreraU" id ="idcarreraU">
            <p><label> Edad: </label> <input type="number" name="edad" id ="idedad">
                
                <button type="submit" name="action" value="modificar" > Modificar </button>
            
        </form>
        <h3>Lista de usuarios</h3>
        <table border ="1" id = "mitabla">
            
            <tr>
                <th>Id</th>
                <th>Primer Nombre</th>
                <th>Segundo Nombre</th>
                <th>Primer Apellido</th>
                <th>Segundo Apellido</th>
                <th>Carrera</th>
                <th>Edad</th>
                <th>Accion</th>
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
                <td>
                    <button type="submit" onClick="Seleccionar()">Seleccionar</button>
                </td>
                
            </tr>
                <%
                 }
            
            %>
            
        </table>
        <img src="imagenes/729px-Escudo_de_la_Universidad_de_El_Salvador.svg.png" alt="Logo UES" class="logo-right">
    </body>
</html>

<script>
    function Seleccionar(){
        
        var table = document.getElementById("mitabla");
        
        for (var i = 1; i < table.rows.length; i++){
            table.rows[i].onclick = function(){
                
                document.getElementById('idid').value = this.cells[0].innerHTML;
                document.getElementById('idnombreP').value = this.cells[1].innerHTML;
                document.getElementById('idnombreS').value = this.cells[2].innerHTML;
                document.getElementById('idapellidoP').value = this.cells[3].innerHTML;
                document.getElementById('idapellidoS').value = this.cells[4].innerHTML;
                document.getElementById('idcarreraU').value = this.cells[5].innerHTML;
                document.getElementById('idedad').value = this.cells[6].innerHTML;
                
            };
        }
        
    }
</script>