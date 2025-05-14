package com.mycompany.quanlydiemthidaihoc.action;

import com.mycompany.quanlydiemthidaihoc.entity.StudentXML;
import com.mycompany.quanlydiemthidaihoc.entity.Student;
import com.mycompany.quanlydiemthidaihoc.utils.FileUtils;
import com.mycompany.quanlydiemthidaihoc.view.StudentView;
import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;

public class ManagerStudent {

    private static final String STUDENT_FILE_NAME = "Students.xml";  // Đổi tên file thành Students.xml
    private List<Student> listStudents;  // Đổi từ Residents thành Student
    private StudentView studentView;  // Đổi từ ResidentView thành StudentView

    public ManagerStudent() {  // Đổi tên class từ ManagerResidents thành ManagerStudent
        this.listStudents = readListStudents();
        if (listStudents == null) {
            listStudents = new ArrayList<Student>();
        }
    }
    // Inside ManagerStudent class

    public boolean isStudentIDUnique(Student student) {
        // Assuming you have a list of students called 'studentsList'
        for (Student existingStudent : listStudents) {
            if (existingStudent.getId() == student.getId()) {
                return false;  // ID already exists
            }
        }
        return true;  // ID is unique
    }
public List<Student> readListStudents() {
    List<Student> list = new ArrayList<Student>();
    
    // Đọc file XML và chuyển đổi thành đối tượng StudentXML
    StudentXML studentXML = (StudentXML) FileUtils.readXMLFile(STUDENT_FILE_NAME, StudentXML.class);
    
    if (studentXML != null) {
        // Lấy danh sách sinh viên từ đối tượng StudentXML
        list = studentXML.getStudentList();
    }
    
    return list;
}

    public void writeListStudents(List<Student> students) {  // Đổi từ Residents thành Students
        StudentXML studentXML = new StudentXML();
        studentXML.setStudentList(students);  // Đổi từ setResidents thành setStudents
        FileUtils.writeXMLtoFile(STUDENT_FILE_NAME, studentXML);  // Đổi từ Residents.xml thành Students.xml
    }

    public List<Student> searchStudentName(String search) {  // Đổi từ searchResidentName thành searchStudentName
        List<Student> temp = new ArrayList<Student>();
        for (Student student : listStudents) {  // Đổi từ Residents thành Student
            if (student.getName().toLowerCase().contains(search.toLowerCase())) {
                temp.add(student);
            }
        }
        return temp;
    }

    public List<Student> searchStudentAddress(String search) {  // Đổi từ searchResidentAddress thành searchStudentAddress
        List<Student> temp = new ArrayList<Student>();
        for (Student student : listStudents) {  // Đổi từ Residents thành Student
            if (student.getAddress().toLowerCase().contains(search.toLowerCase())) {
                temp.add(student);
            }
        }
        return temp;
    }

    public List<Student> searchStudentID(String search) {  // Đổi từ searchResidentIDFamily thành searchStudentIDFamily
        List<Student> result = new ArrayList<Student>();
        for (Student student : listStudents) {  // Đổi từ Residents thành Student
            if (String.valueOf(student.getId()).contains(search)) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> searchStudentYear(String year) {  // Đổi từ searchResidentYear thành searchStudentYear
        List<Student> temp = new ArrayList<>();
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

        for (Student student : listStudents) {  // Đổi từ Residents thành Student
            // Chuyển đổi ngày sinh thành chuỗi năm
            String studentYearStr = yearFormat.format(student.getBirthday());  // Đổi từ Residents thành Student

            // So sánh chuỗi năm với năm tìm kiếm
            if (studentYearStr.equals(year)) {  // Đổi từ Residents thành Student
                temp.add(student);
            }
        }
        return temp;
    }

    public void add(Student student) {  // Đổi từ Residents thành Student
        int max = 0;
        for (int i = 0; i < listStudents.size(); i++) {  // Đổi từ Residents thành Student
            if (listStudents.get(i).getId() > max) {
                max = listStudents.get(i).getId();  // Đổi từ Residents thành Student
            }
        }
        student.setId(max + 1);
        listStudents.add(student);  // Đổi từ Residents thành Student
        writeListStudents(listStudents);  // Đổi từ Residents thành Students
    }

    public boolean isCMTUnique(Student student) {  // Đổi từ isCMTUnique với Residents thành isCMTUnique với Student
        String cmt = student.getCMT();  // Đổi từ Residents thành Student
        for (Student existingStudent : listStudents) {  // Đổi từ Residents thành Student
            if (existingStudent.getCMT().equals(cmt)) {  // Đổi từ Residents thành Student
                return false;  // Trùng số CMT
            }
        }
        return true;  // Số CMT không trùng
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(studentView, message);  // Đổi từ residentView thành studentView
    }

    public void edit(Student student) throws ParseException {
        SimpleDateFormat fDate = new SimpleDateFormat("dd/MM/yyyy");
        int size = listStudents.size();  // Duyệt qua danh sách sinh viên
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId() == student.getId()) {
                // Cập nhật các thông tin của student
                listStudents.get(i).setId(student.getId());  // Cập nhật ID
                listStudents.get(i).setName(student.getName());  // Cập nhật tên
                listStudents.get(i).setBirthday(student.getBirthday());  // Cập nhật ngày sinh
                listStudents.get(i).setAddress(student.getAddress());  // Cập nhật địa chỉ
                listStudents.get(i).setGender(student.getGender());  // Cập nhật giới tính
                listStudents.get(i).setSchoolName(student.getSchoolName());  // Cập nhật tên trường
                listStudents.get(i).setExamArea(student.getExamArea());  // Cập nhật khu vực thi
                listStudents.get(i).setIdCard(student.getIdCard());  // Cập nhật số CMND/CCCD
                listStudents.get(i).setMajor(student.getMajor());  // Cập nhật ngành học
                listStudents.get(i).setTypeCMT(student.getTypeCMT());  // Cập nhật loại CMT
                listStudents.get(i).setCMT(student.getCMT());  // Cập nhật số CMT
                listStudents.get(i).setPhoneNumber(student.getPhoneNumber());  // Cập nhật số điện thoại

                writeListStudents(listStudents);
                break;
            }
        }
    }

    public boolean delete(Student student) {  // Đổi từ delete(Residents) thành delete(Student)
        boolean isFound = false;
        int size = listStudents.size();  // Đổi từ Residents thành Student
        for (int i = 0; i < size; i++) {  // Đổi từ Residents thành Student
            if (listStudents.get(i).getId() == student.getId()) {  // Đổi từ Residents thành Student
                listStudents.remove(i);  // Đổi từ Residents thành Student
                isFound = true;
                break;
            }
        }
        if (isFound) {
            // Cập nhật lại ID của các đối tượng sau
            for (int i = 0; i < listStudents.size(); i++) {  // Đổi từ Residents thành Student
                if (listStudents.get(i).getId() > student.getId()) {  // Đổi từ Residents thành Student
                    listStudents.get(i).setId(listStudents.get(i).getId() - 1);  // Đổi từ Residents thành Student
                }
            }
            writeListStudents(listStudents);  // Đổi từ Residents thành Students
            return true;
        }
        return false;
    }

    public void sortStudentsByName() {  // Đổi từ sortResidentsByName thành sortStudentsByName
        Collections.sort(listStudents, new Comparator<Student>() {  // Đổi từ Residents thành Student
            public int compare(Student p1, Student p2) {  // Đổi từ Residents thành Student
                Collator collator = Collator.getInstance(new Locale("vi", "VN"));
                // So sánh tên
                int result = collator.compare(p1.getLastName(), p2.getLastName());  // Đổi từ Residents thành Student
                if (result == 0) {
                    // Nếu tên bằng nhau, so sánh họ lót
                    result = collator.compare(p1.getFirstName(), p2.getFirstName());  // Đổi từ Residents thành Student
                }
                return result;
            }
        });
    }

    public void sortStudentsByIDFamily() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student person1, Student person2) {
                return Integer.compare(person1.getId(), person2.getId());  // Sử dụng Integer.compare() thay vì compareTo()
            }
        });
    }

    public void sortStudentsByID() {  // Đổi từ sortResidentsByID thành sortStudentsByID
        Collections.sort(listStudents, new Comparator<Student>() {  // Đổi từ Residents thành Student
            public int compare(Student person1, Student person2) {  // Đổi từ Residents thành Student
                if (person1.getId() > person2.getId()) {  // Đổi từ Residents thành Student
                    return 1;
                }
                return -1;
            }
        });
    }

    public List<Student> getListStudents() {  // Đổi từ getListResidents thành getListStudents
        return this.listStudents;  // Đổi từ Residents thành Student
    }

    public void setListStudents(List<Student> listStudents) {  // Đổi từ setListResidents thành setListStudents
        this.listStudents = listStudents;  // Đổi từ Residents thành Student
    }
}
