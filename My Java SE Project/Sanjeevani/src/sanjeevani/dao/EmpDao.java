/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import sanjeevani.dbutil.DBConnection;

/**
 *
 * @author HP
 */
public class EmpDao {
    public static HashMap <String,String> getNonRegisteredReceptionistList() throws SQLException
    {
            Connection conn = DBConnection.getConnection();
            String qry ="Select empid,empname from employees where role='Receptionist' and empid not in(select empid from users where usertype='Receptionist')";
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery(qry);
            HashMap<String,String> receptionist = new HashMap();
            
            while(rs.next())
            {
                String id = rs.getString(1);
                String name = rs.getString(2);
                receptionist.put(id,name);
            }
           return receptionist; 
    }       
    
public static String getNextEmpIdFromEmpTable () throws SQLException
{
      String employeeId;
        Statement stm = DBConnection.getConnection().createStatement();
        ResultSet rs = stm.executeQuery("select max(empid) from employees");
        rs.next();
        employeeId = rs.getString("max(empid)").substring(1);  
        int temp = Integer.parseInt(employeeId);
        temp = temp+1;
        employeeId = "E"+Integer.toString(temp);
        return employeeId;
    
}

public static ArrayList getAllEmpId () throws SQLException
{
    ArrayList <String> arrlist = new ArrayList();
    Statement stmm = DBConnection.getConnection().createStatement();
    ResultSet rs = stmm.executeQuery("select empid from employees");
    
    while(rs.next())
        {
            String temp = rs.getString("empid");
            arrlist.add(temp);
        }
        return arrlist;
    
}

public static boolean addEmployeeDataInDatabase(String id,String name,String job,int salary) throws SQLException
{
     PreparedStatement ps = DBConnection.getConnection().prepareStatement("insert into employees values(?,?,?,?)");
        ps.setString(1,id );
        ps.setString(2,name);
        ps.setString(3,job);
        ps.setInt(4,salary);
        if(ps.executeUpdate()!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
}


public static boolean updateEmployeeDataInDatabase(String id,String name,String job,int salary) throws SQLException
{
     PreparedStatement ps = DBConnection.getConnection().prepareStatement("update employees set empid=?,empname=?,role=?,sal=? where empid=?");
        ps.setString(1,id );
        ps.setString(2,name);
        ps.setString(3,job);
        ps.setInt(4,salary);
        ps.setString(5,id );
        if(ps.executeUpdate()!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
}


public static boolean deleteEmp(String empid) throws SQLException
{
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
     ResultSet rs = stmm.executeQuery("select * from employees");
     return rs;
}




}
