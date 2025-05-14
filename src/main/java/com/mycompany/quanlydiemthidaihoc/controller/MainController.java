package com.mycompany.quanlydiemthidaihoc.controller;

import com.mycompany.quanlydiemthidaihoc.view.LoginView;
import com.mycompany.quanlydiemthidaihoc.view.MainView;
import com.mycompany.quanlydiemthidaihoc.view.StudentView;
import com.mycompany.quanlydiemthidaihoc.view.ManagerView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private LoginView loginView;
    private ManagerView managerView;
    private StudentView studentView;
    private MainView mainView;

    // Constructor
    public MainController(MainView view) {
        this.mainView = view;
        view.addChooseSpecialPersonListener(new ChooseSpecialPersonListener());
        view.addChooseResidentsListener(new ChooseResidentListener());
    }

    public void showMainView() {
        mainView.setVisible(true);
    }

    // Listener cho nút "Quản lý học sinh đặc biệt"
    class ChooseSpecialPersonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (managerView == null) {
                managerView = new ManagerView();
            }
            SpecialPersonController managerController = new SpecialPersonController(managerView, mainView);
            managerController.showManagerView();  // Hiển thị ManagerView
            mainView.setVisible(false);  // Ẩn MainView
        }
    }

    // Listener cho nút "Quản lý học sinh"
    class ChooseResidentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (studentView == null) {
                studentView = new StudentView();
            }
            StudentController studentController = new StudentController(studentView, mainView);
            studentController.showStudentView();  // Hiển thị StudentView
            mainView.setVisible(false);  // Ẩn MainView
        }
    }
}
