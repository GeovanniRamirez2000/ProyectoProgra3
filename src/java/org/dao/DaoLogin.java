package org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.models.ModuleModel;
import wsUser.ModelUser;


public class DaoLogin {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int num = 0;
    Conexion cn = new Conexion();
    
    public int Validar(String USUARIO, String PASSWORD){        
        try{
            String sql = "select * from USUARIO where USUARIO=? and PASSWORD=?";
            
            con = cn.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, USUARIO);
            ps.setString(2, PASSWORD);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                if(rs.getString("USUARIO").equals(USUARIO) && rs.getString("PASSWORD").equals(PASSWORD)){
                    num = 1;
                }
            }
        }catch(SQLException e){   
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }
    
    
    
    
}
