/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.pojo;

/**
 *
 * @author HP
 */
public class DoctorPojo {
    
    private String empName;
    private String UserId;
    private String passwd;
    private String rePasswd;
    private String DoctorId;
    private String Qualification;
    private String Specification;
    
    
    public String getRePasswd() {
        return rePasswd;
    }

    public void setRePasswd(String rePasswd) {
        this.rePasswd = rePasswd;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }


    public String getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(String DoctorId) {
        this.DoctorId = DoctorId;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String Qualification) {
        this.Qualification = Qualification;
    }

    public String getSpecification() {
        return Specification;
    }

    public void setSpecification(String Specification) {
        this.Specification = Specification;
    }
    
    
}
