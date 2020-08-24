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
import sanjeevani.pojo.PatientPojo;

/**
 *
 * @author HP
 */
public class PatientDao {
    
    
      public static String getNextPatientIdFromPatientTable () throws SQLException
{
        String PatientId;
        Statement stm = DBConnection.getConnection().createStatement();
        ResultSet rs = stm.executeQuery("select max(p_id) from patient");
        rs.next();
        PatientId = rs.getString("max(p_id)").substring(1);  
        int temp = Integer.parseInt(PatientId);
        temp = temp+1;
        PatientId = "P"+Integer.toString(temp);
        return PatientId;
    
}
    
 public static boolean addPatientInDatabase(PatientPojo pp)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, pp.getP_id());
        ps.setString(2, pp.getF_name());
        ps.setString(3, pp.getS_name());
        ps.setInt(4, pp.getAge());
        ps.setString(5, pp.getOPD());
        ps.setString(6, pp.getGender());
        ps.setString(7, pp.getM_status());
        ps.setDate(8, pp.getDate());
        ps.setString(9, pp.getAddress());
        ps.setString(10, pp.getCity());
        ps.setString(11, pp.getMno());
        ps.setString(12, pp.getDoctor_id());
        int ans=ps.executeUpdate();
        return ans>0;
    }      
 
 
 
     
 public static boolean addUpdatedPatientInDatabase(PatientPojo pp)throws SQLException
    {               
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("update patient set OPD=?,F_NAME=?,S_NAME=?,AGE=?,GENDER=?,M_STATUS=?,ADDRESS=?,CITY=?,PHONE_NO=?,P_DATE=? where P_ID=?");
        ps.setString(1, pp.getOPD());
        ps.setString(2, pp.getF_name());
        ps.setString(3, pp.getS_name());
        ps.setInt(4, pp.getAge());
        ps.setString(5, pp.getP_id());
        ps.setString(5, pp.getGender());
        ps.setString(6, pp.getM_status());
        ps.setString(7, pp.getAddress());
        ps.setString(8, pp.getCity());
        ps.setString(9, pp.getMno());
        ps.setDate(10, pp.getDate());
        ps.setString(11, pp.getP_id());
        int ans=ps.executeUpdate();
        return ans>0;
    }      
      
      public static ResultSet getAllData(String docid) throws SQLException
{
     PreparedStatement pstmm =  DBConnection.getConnection().prepareStatement("select P_ID,F_NAME,S_NAME,OPD from patient where DOCTOR_ID=?");
     pstmm.setString(1,docid);
     ResultSet rs = pstmm.executeQuery();
     return rs;
}


      public static ArrayList getListOfPatientidOfPatients() throws SQLException
    {
        ArrayList <String> patientidlist = new ArrayList <>();
        Statement stmm =  DBConnection.getConnection().createStatement();
        ResultSet rs = stmm.executeQuery("select P_ID from patient");
        
        while(rs.next())
        {
            String temp = rs.getString("P_ID");
            patientidlist.add(temp);
        }
        return patientidlist;
    }
      
      
      
       public static boolean deletePatient (String patientid) throws SQLException
    {
       PreparedStatement psm = DBConnection.getConnection().prepareStatement("delete from patient where P_ID=?");
       psm.setString(1,patientid);  
       if(psm.executeUpdate()!=0)
        {
            return true;
        }
        else
        {
            return false;    
        }
    
    }  
      
      
       public static ResultSet getDetailsOfPatientInFrame(String patientId) throws SQLException
       {
       PreparedStatement psm = DBConnection.getConnection().prepareStatement("select * from patient where P_ID=?");
       psm.setString(1,patientId);  
       ResultSet rs = psm.executeQuery();
       return rs;
       }
       
       public static ResultSet getAllData() throws SQLException
{
     Statement stmm =  DBConnection.getConnection().createStatement();
     ResultSet rs = stmm.executeQuery("select * from patient");
     return rs;
}
       
       
}

