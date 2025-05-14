package com.mycompany.quanlydiemthidaihoc.entity;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentXML implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "student")
    private List<Student> studentList;

    public StudentXML() {}

    public StudentXML(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
