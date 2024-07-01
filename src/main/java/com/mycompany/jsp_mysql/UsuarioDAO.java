
package com.mycompany.jsp_mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class UsuarioDAO {
    
    public void insertarUsuario(String nombreP, String nombreS, String apellidoP, String apellidoS, String carreraU, int edad){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try{
            
            conn = ConexionDAO.obtenerConexion();
            String sql = "insert into usuarios (nombreP, nombreS, apellidoP, apellidoS, carreraU, edad) values(?,?,?,?,?,?);";
            stmt = conn.prepareStatement(sql);
            
            
            stmt.setString(1, nombreP);
            stmt.setString(2, nombreS);
            stmt.setString(3, apellidoP);
            stmt.setString(4, apellidoS);
            stmt.setString(5, carreraU);
            stmt.setInt(6, edad);
            
            stmt.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            
            ConexionDAO.cerrarConexion(conn);
            
            try{
                if (stmt != null)
                    stmt.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    
    public List<EntidadUsuario> obtenerUsuarios(){
        
        List<EntidadUsuario> usuarios = new ArrayList<>();
            
            Connection conn =  null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            try{
                conn = ConexionDAO.obtenerConexion();
                String sql = "select * from  usuarios;";
                stmt = conn.prepareStatement(sql);
                
                rs = stmt.executeQuery();
                
                while (rs.next()){
                    
                    EntidadUsuario usuario = new EntidadUsuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setPrimerNombre(rs.getString("nombreP"));
                    usuario.setSegundoNombre(rs.getString("nombreS"));
                    usuario.setPrimerApellido(rs.getString("apellidoP"));
                    usuario.setSegundoApellido(rs.getString("apellidoS"));
                    usuario.setCarrera(rs.getString("carreraU"));
                    usuario.setEdad(rs.getInt("edad"));
                    usuarios.add(usuario);
                    
                }
            } catch(Exception e){
               e.printStackTrace();
            }
            finally{
                ConexionDAO.cerrarConexion(conn);
                try{
                    if (stmt != null) stmt.close();
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                
                try{
                    if (rs != null) rs.close();
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                
            }
            return usuarios;
    }
    
    public void modificarUsuario(int id, String nombreP, String nombreS, String apellidoP, String apellidoS, String carreraU, int edad){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try{
            
            conn = ConexionDAO.obtenerConexion();
            String sql = "update usuarios set nombreP = ?, nombreS = ?, apellidoP = ?, apellidoS = ?, carreraU = ?, edad = ? where id =?;";
            stmt = conn.prepareStatement(sql);
            
            
            stmt.setString(1, nombreP);
            stmt.setString(2, nombreS);
            stmt.setString(3, apellidoP);
            stmt.setString(4, apellidoS);
            stmt.setString(5, carreraU);
            stmt.setInt(6, edad);
            stmt.setInt(7, id);
            
            stmt.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            
            ConexionDAO.cerrarConexion(conn);
            
            try{
                if (stmt != null)
                    stmt.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    public void eliminarUsuario(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try{
            
            conn = ConexionDAO.obtenerConexion();
            String sql = "DELETE from usuarios where id = ?;";
            stmt = conn.prepareStatement(sql);
             
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            
            ConexionDAO.cerrarConexion(conn);
            
            try{
                if (stmt != null)
                    stmt.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
}
