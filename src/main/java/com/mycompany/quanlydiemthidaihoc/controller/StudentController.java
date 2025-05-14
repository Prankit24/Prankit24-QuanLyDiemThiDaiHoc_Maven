package com.mycompany.quanlydiemthidaihoc.controller;

import com.mycompany.quanlydiemthidaihoc.action.ManagerStudent;
import com.mycompany.quanlydiemthidaihoc.entity.Student;
import com.mycompany.quanlydiemthidaihoc.view.StudentView;
import com.mycompany.quanlydiemthidaihoc.view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class StudentController {

    private StudentView studentView;
    private ManagerStudent managerStudents;
    private MainView mainView;
<<<<<<< HEAD
    

    // Constructor nhận vào cả StudentView và MainView
    
=======
>>>>>>> b156958 (View fix)

    public StudentController(StudentView studentView, MainView mainView) {
        this.studentView = studentView;
        this.mainView = mainView;
        this.managerStudents = new ManagerStudent();

        studentView.addUndoListener(new UndoListener());
        studentView.addAddStudentListener(new AddStudentListener());
        studentView.addListStudentSelectionListener(new ListStudentsSelectionListener());
        studentView.addEditStudentListener(new EditStudentListener());
        studentView.addClearListener(new ClearStudentListener());
        studentView.addDeleteStudentListener(new DeleteStudentListener());
        studentView.addSortStudentListener(new SortStudentsListener());
        studentView.addSearchListener(new SearchStudentListener());
    }

    public void showStudentView() {
        List<Student> studentList = managerStudents.getListStudents();
        studentView.setVisible(true);
        studentView.showListStudents(studentList);
        studentView.showCountListStudents(studentList);
        studentView.showStatisticTypeCMT(studentList);
        studentView.showStatisticIDCard(studentList);
    }

    class UndoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentView.setVisible(false);
            mainView.setVisible(true);
        }
    }

    class AddStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                try {
                    if (!managerStudents.isStudentIDUnique(student)) {
                        throw new IllegalArgumentException("Lỗi: Mã sinh viên đã tồn tại!");
                    }

                    managerStudents.add(student);
                    updateStudentView();
                    studentView.showMessage("Thêm thành công!");
                } catch (IllegalArgumentException ex) {
                    studentView.showMessage(ex.getMessage());
                }
            }
        }
    }

    class EditStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
<<<<<<< HEAD
                try {
                    managerStudents.edit(student);
                    updateStudentView();
                    studentView.showMessage("Cập nhật thành công!");
                } catch (ParseException ex) {
                    Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
                }
=======
                managerStudents.edit(student);
                updateStudentView();
                studentView.showMessage("Cập nhật thành công!");
>>>>>>> b156958 (View fix)
            }
        }
    }

    class DeleteStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                managerStudents.delete(student);
                updateStudentView();
                studentView.clearStudentInfo();
                studentView.showMessage("Xóa thành công!");
            }
        }
    }

    class ListStudentsSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            List<Student> studentList = managerStudents.getListStudents();
            try {
                studentView.fillStudentFromSelectedRow(studentList);
            } catch (ParseException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class ClearStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentView.clearStudentInfo();
        }
    }

    class SortStudentsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int check = studentView.getChooseSelectSort();
            if (check == 1) {
                managerStudents.sortStudentsByID();
            } else if (check == 2) {
                managerStudents.sortStudentsByName();
            } else {
                studentView.showMessage("Bạn chưa chọn tiêu chí sắp xếp");
                return;
            }
            studentView.showListStudents(managerStudents.getListStudents());
        }
    }

    class SearchStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<Student> temp = new ArrayList<>();
            int check = studentView.getChooseSelectSearch();
            String search = studentView.validateSearch();
            if (check == 1) {
                temp = managerStudents.searchStudentID(search);
            } else if (check == 2) {
                temp = managerStudents.searchStudentName(search);
            }
            if (!temp.isEmpty()) {
                studentView.showListStudents(temp);
            } else {
                studentView.showMessage("Không tìm thấy kết quả!");
            }
        }
    }

    private void updateStudentView() {
        List<Student> students = managerStudents.getListStudents();
        studentView.showStudents(null); // Cập nhật vùng hiển thị chi tiết nếu cần
        studentView.showListStudents(students);
        studentView.showCountListStudents(students);
        studentView.showStatisticTypeCMT(students);
        studentView.showStatisticIDCard(students);
    }
}
