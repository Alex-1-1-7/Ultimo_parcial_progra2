
package com.mycompany.jsp_mysql;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDAO {
    private static final String url="jdbc:mysql://localhost:3306/dbUsUES";
    private static final String username = "root";
    private static final String pass = "A117";
    
    public static Connection obtenerConexion (){
    Connection conn = null;
        
        try {         //en la dependencia com.mysql.cj.jdbc ahi esta el Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,pass);
        }catch (Exception e){
            System.out.println("Error de conexion: "+e.toString());
        }
        return conn; 
    }
    
    public static void cerrarConexion(Connection conn){
        try {
            if (conn != null){
                conn.close();
            }
        }catch (Exception e){
            System.out.println("Error de conexion: "+e.toString());
        }
    }
}
