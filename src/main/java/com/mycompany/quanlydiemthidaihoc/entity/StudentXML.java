package com.mycompany.quanlydiemthidaihoc.entity;

<<<<<<< HEAD
=======
import com.mycompany.quanlydiemthidaihoc.utils.FileUtils;
>>>>>>> b156958 (View fix)
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
<<<<<<< HEAD
}
=======

    // Đọc dữ liệu từ file XML trong phương thức static
    public static StudentXML loadStudentDataFromFile(String filePath) {
        try {
            StudentXML studentXML = (StudentXML) FileUtils.readXMLFile(filePath, StudentXML.class);
            if (studentXML != null) {
                return studentXML;
            } else {
                System.out.println("Không thể đọc dữ liệu từ file XML.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi khi đọc file XML: " + e.getMessage());
            return null;
        }
    }
}

>>>>>>> b156958 (View fix)
