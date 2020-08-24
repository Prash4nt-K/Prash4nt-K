/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class DBConnection {
    
    public static Connection conn;
    
    
    static
    {
     try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sanjeevani","sanjeevani");
        }
    catch(ClassNotFoundException cnfe)
        {
           JOptionPane.showMessageDialog(null,"Cannot load driver !"+cnfe);      
        }
    catch(SQLException sqlex)    
        {
           JOptionPane.showMessageDialog(null,"Problem in DB !"+sqlex);  
        }   
    }
    
    
    
    public static Connection getConnection()
    {
        return conn;
    }
    
    
    public static void closeConnection()
    {
      try
      {
          if(conn!=null)
          {
              conn.close();
              JOptionPane.showMessageDialog(null,"Connection closed succesfully");
          } 
      }
      catch(SQLException sqlex)    
        {
           JOptionPane.showMessageDialog(null,"Problem in closing connection !"+sqlex); 
           sqlex.printStackTrace();
        }  
        
    }
    
}
