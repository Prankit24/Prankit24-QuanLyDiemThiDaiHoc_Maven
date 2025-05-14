package com.mycompany.quanlydiemthidaihoc.entity;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
<<<<<<< HEAD
import java.util.Arrays;
=======
>>>>>>> b156958 (View fix)
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student extends Person {
<<<<<<< HEAD
=======

>>>>>>> b156958 (View fix)
    private static final long serialVersionUID = 1L;

    private String gender;
    private String schoolName;
    private String examArea;
    private String idCard;
    private String major;
<<<<<<< HEAD
    private String typeCMT; 
    private String CMT; 
    private String phoneNumber; 
    private String role;
    
=======
    private String typeCMT;
    private String CMT;
    private String phoneNumber;
    private String role;

>>>>>>> b156958 (View fix)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date openingDate;

    private byte[] image;

<<<<<<< HEAD
    public Student() {}
=======
    public Student() {
    }
>>>>>>> b156958 (View fix)

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getExamArea() {
        return examArea;
    }

    public void setExamArea(String examArea) {
        this.examArea = examArea;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTypeCMT() {
        return typeCMT;
    }

    public void setTypeCMT(String typeCMT) {
        this.typeCMT = typeCMT;
    }

    public String getCMT() {
        return CMT;
    }

    public void setCMT(String CMT) {
        this.CMT = CMT;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }
}
<<<<<<< HEAD

=======
>>>>>>> b156958 (View fix)
