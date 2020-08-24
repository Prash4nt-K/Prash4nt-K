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
public class DoctorDao {
    DoctorDao doc = new DoctorDao();
 
 
    public static ArrayList getNotRegistersdEmployeeIdFromTable() throws SQLException
{
    ArrayList <String> empidlist = new ArrayList();
    Statement stm = DBConnection.getConnection().createStatement();
    ResultSet rs = stm.executeQuery("select empname from employees where role = 'Doctor' and empid not in(select empid from users where usertype='Doctor')");
    while(rs.next())
    {
        empidlist.add(rs.getString("empname"));
    }
    return empidlist;
}
    
    
    public static boolean addDataInDatabase(String UserId,String userName,String passwd,String DoctorId,String Qualification,String Specification) throws SQLException
    {
    PreparedStatement pstm = DBConnection.getConnection().prepareStatement("select empid from employees where empname=?");
    pstm.setString(1,userName);
    ResultSet rss = pstm.executeQuery();
    rss.next();
    String empid = rss.getString("empid");    
        
        
    PreparedStatement ps = DBConnection.getConnection().prepareStatement("insert into users values(?,?,?,?,'Doctor')");
    ps.setString(1,UserId);
    ps.setString(2,userName);
    ps.setString(3, empid);
    ps.setString(4,passwd);
    
    ps.executeUpdate();
    
    PreparedStatement psm = DBConnection.getConnection().prepareStatement("insert into doctors values(?,?,?,?,'Yes')");
    psm.setString(1,UserId);
    psm.setString(2,DoctorId);
    psm.setString(3,Qualification);
    psm.setString(4,Specification);
    
     int temp =psm.executeUpdate();
       if(temp!=0)
       {
            return true;
       }
       else
       {
            return false;
       }
       
        
    }
    
    
    public static String getNextDoctorIdFromDoctorTable () throws SQLException
{
      String DoctorId;
        Statement stm = DBConnection.getConnection().createStatement();
        ResultSet rs = stm.executeQuery("select max(doctorid) from doctors");
        rs.next();
        DoctorId = rs.getString("max(doctorid)").substring(1);  
        int temp = Integer.parseInt(DoctorId);
        temp = temp+1;
        DoctorId = "D"+Integer.toString(temp);
        return DoctorId;
    
}
    
    
    
    
     public static ArrayList getListOfEmpidOfDoctor() throws SQLException
    {
        ArrayList <String> empidlist = new ArrayList <>();
        Statement stmm =  DBConnection.getConnection().createStatement();
        ResultSet rs = stmm.executeQuery("select empid from users where usertype='Doctor'");
        
        while(rs.next())
        {
            String temp = rs.getString("empid");
            empidlist.add(temp);
        }
        return empidlist;
    }
     
     
     public static boolean deleteDoctor (String empid) throws SQLException
    {
       PreparedStatement pstmm = DBConnection.getConnection().prepareStatement("select userid from users where empid=?");
       pstmm.setString(1,empid);  
       ResultSet rs = pstmm.executeQuery();
       rs.next();
       String userid = rs.getString("userid");
        
       PreparedStatement psttmm = DBConnection.getConnection().prepareStatement("update doctors set ACTIVE='No' where userid=?");
       psttmm.setString(1,userid);  
       psttmm.executeUpdate(); 
        
       if(psttmm.executeUpdate()!=0)
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
     ResultSet rs = stmm.executeQuery("select * from employees where role='Doctor'");
     return rs;
}
    
 public static ArrayList getListOfDocidOfDoctor() throws SQLException
    {
        ArrayList <String> docidlist = new ArrayList <>();
        Statement stmm =  DBConnection.getConnection().createStatement();
        ResultSet rs = stmm.executeQuery("select doctorid from doctors");
        
        while(rs.next())
        {
            String temp = rs.getString("doctorid");
            docidlist.add(temp);
        }
        return docidlist;
    }    
 
 public static String retutnDocidWhenDoctorLoginInLoginFrame (String userid) throws SQLException
 {
    PreparedStatement psm = DBConnection.getConnection().prepareStatement("select doctorid from doctors where userid=?");
    psm.setString(1,userid);  
    ResultSet rs = psm.executeQuery();
    rs.next();
    return rs.getString("doctorid");   
 }
 
}
