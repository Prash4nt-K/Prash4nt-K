/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import sanjeevani.dbutil.DBConnection;
import sanjeevani.pojo.User;
import sanjeevani.pojo.UserProfile;

/**
 *
 * @author HP
 */
public class UserDao {

    public static String vadlidateUser(User u) throws SQLException {
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("select username from users where userid=? and password=? and usertype=?");
        ps.setString(1, u.getUserId());
        ps.setString(2, u.getPassword());
        ps.setString(3, u.getUserType());
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            UserProfile.setUsername(rs.getString("username"));
            return rs.getString(1);
        }
        return null;
    }
    public static boolean changePassword(String idSelectedByUser,String newPassword) throws SQLException
    {
        boolean ret;
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement("update users set password=? where userid=?");
        pstm.setString(1,newPassword);
        pstm.setString(2,idSelectedByUser);
        if(pstm.executeUpdate()!=0)
        {
            ret=true;
        }
        else
        {
            ret=false;    
        }
    return ret;
     
    }
    
    public static HashMap getReceptionistList() throws SQLException
    {
       HashMap<String,String> receptionistlist = new HashMap<>();
       
       Statement stm = DBConnection.getConnection().createStatement();
       ResultSet rs = stm.executeQuery("select userid,password from users where usertype='Receptionist'");
       while(rs.next())
       {
           String id=rs.getString("userid");
           String password=rs.getString("password");
           receptionistlist.put(id,password);    
       }
       return receptionistlist; 
    }
    
    

     public static String getNameOfReceptionist(String userId) throws SQLException
    {
      PreparedStatement psm = DBConnection.getConnection().prepareStatement("select username from users where userid=?");
      psm.setString(1, userId);
      ResultSet rs = psm.executeQuery();
      rs.next();
      return rs.getString("username");
        
    }
    
}