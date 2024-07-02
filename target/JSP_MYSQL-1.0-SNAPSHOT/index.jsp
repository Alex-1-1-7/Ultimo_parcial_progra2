<%-- 
    Document   : index
    Created on : 18 jun 2024, 22:50:55
    Author     : Migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Estudiantes UES</title>
        
        <style>
            .botones-container {
                text-align: center;
            }
            
            .botones-container button {
                margin: 5px;
                padding: 10px 20px;
                background-color: #800020; /* Verde */
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
            
            .botones-container button:hover {
                background-color: white;
                color: #4CAF50;
                border: 2px solid #4CAF50;
            }
            
            .logo {
                text-align: center;
                margin-bottom: 20px;
            }
            
            .logo img {
                width: 150px; 
            }

            .center-text {
                text-align: center;
            }
            body {
                background-color: #ffe6e6; 
            }
        </style>
    </head>
    <body>
        <div class="logo">
            <img src="imagenes/729px-Escudo_de_la_Universidad_de_El_Salvador.svg.png" alt="Logo UES">
        </div>
        <h1 class="center-text">REGISTRO DE ESTUDIANTES DE LA UNIVERSIDAD DE EL SALVADOR</h1>
        <h2 class="center-text">Menu Principal</h2>
        
        <div class="botones-container">
            <form action="servletusuario" method="GET">
                <a href="servletusuario?action=mostrar"><button type="button">Mostrar Estudiantes</button></a>
                <a href="servletusuario?action=guardar"><button type="button">Guardar Estudiantes</button></a>
                <a href="servletusuario?action=modificar"><button type="button">Modificar Estudiantes</button></a>
                <a href="servletusuario?action=eliminar"><button type="button">Eliminar Estudiantes</button></a>    
            </form>
        </div>
    </body>
</html>


