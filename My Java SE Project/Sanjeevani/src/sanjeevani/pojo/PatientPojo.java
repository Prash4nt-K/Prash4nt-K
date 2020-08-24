package sanjeevani.pojo;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class PatientPojo {

    public PatientPojo(String OPD, String f_name, String s_name, String Doctor_id,int age, String p_id, String gender, String m_status, String address, String city, String mno, Date date) {
        this.OPD = OPD;
        this.f_name = f_name;
        this.s_name = s_name;
        this.Doctor_id = Doctor_id;
        this.p_id = p_id;
        this.gender = gender;
        this.m_status = m_status;
        this.address = address;
        this.city = city;
        this.mno = mno;
        this.date = date;
        this.age= age;
    }
    
      public PatientPojo(String OPD, String f_name, String s_name,int age, String p_id, String gender, String m_status, String address, String city, String mno, Date date) {
        this.OPD = OPD;
        this.f_name = f_name;
        this.s_name = s_name;
        this.p_id = p_id;
        this.gender = gender;
        this.m_status = m_status;
        this.address = address;
        this.city = city;
        this.mno = mno;
        this.date = date;
        this.age= age;
    }


    public String getOPD() {
        return OPD;
    }

    public void setOPD(String OPD) {
        this.OPD = OPD;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getDoctor_id() {
        return Doctor_id;
    }

    public void setDoctor_id(String Doctor_id) {
        this.Doctor_id = Doctor_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getM_status() {
        return m_status;
    }

    public void setM_status(String m_status) {
        this.m_status = m_status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    private int age;
    private String OPD;
    private String f_name;
    private String s_name;
    private String Doctor_id;
    private String p_id;
    private String gender;
    private String m_status;
    private String address;
    private String city;
    private String mno;
    private Date date;
    
}
