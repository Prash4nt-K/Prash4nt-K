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
import sanjeevani.dbutil.DBConnection;

/**
 *
 * @author HP
 */
public class ReceptionistDao {
      
    
    public static boolean addDataInDatabase(String userid,String username,String password)throws SQLException
    {
       PreparedStatement pstm = DBConnection.getConnection().prepareStatement("select empid from employees where empname=?");
       pstm.setString(1,username);
       ResultSet rss = pstm.executeQuery();
       rss.next();
       String empid = rss.getString("empid");
       
       PreparedStatement ps = DBConnection.getConnection().prepareStatement("insert into users values(?,?,?,?,'Receptionist')");
       ps.setString(1,userid);
       ps.setString(2,username);
       ps.setString(3, empid);
       ps.setString(4,password);
       int temp =ps.executeUpdate();
       if(temp!=0)
       {
            return true;
       }
       else
       {
            return false;
       }
       
            
    }
    
    public static ArrayList getListOfEmpidOfReceptionist() throws SQLException
    {
        ArrayList <String> empidlist = new ArrayList <>();
        Statement stmm =  DBConnection.getConnection().createStatement();
        ResultSet rs = stmm.executeQuery("select empid from users where usertype='Receptionist'");
        
        while(rs.next())
        {
            String temp = rs.getString("empid");
            empidlist.add(temp);
        }
        return empidlist;
    }
    
public static ArrayList getNotRegistersdEmployeeIdFromTable() throws SQLException
{
    ArrayList <String> empidlist = new ArrayList();
    Statement stm = DBConnection.getConnection().createStatement();
    ResultSet rs = stm.executeQuery("select empname from employees where role = 'Receptionist' and empid not in(select empid from users where usertype='Receptionist')");
    while(rs.next())
    {
        empidlist.add(rs.getString("empname"));
    }
    return empidlist;
}

public static boolean deleteReceptionist (String empid) throws SQLException
    {
       PreparedStatement pstm = DBConnection.getConnection().prepareStatement("delete from users where empid=?");
       pstm.setString(1,empid);  
       pstm.executeUpdate();
       
       PreparedStatement psm = DBConnection.getConnection().prepareStatement("delete from employees where empid=?");
       psm.setString(1,empid);  
       if(psm.executeUpdate()!=0)
        {
            return true;
        }
        else
        {
            return false;    
        }
    
    
}


public static ResultSet getAllData() throws SQLException
{
     Statement stmm =  DBConnection.getConnection().createStatement();
     ResultSet rs = stmm.executeQuery("select * from employees where role='Receptionist'");
     return rs;
}




}