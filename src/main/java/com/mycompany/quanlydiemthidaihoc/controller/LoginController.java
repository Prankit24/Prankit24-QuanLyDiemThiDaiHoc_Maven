package com.mycompany.quanlydiemthidaihoc.controller;

import com.mycompany.quanlydiemthidaihoc.action.CheckLogin;
import com.mycompany.quanlydiemthidaihoc.entity.User;
import com.mycompany.quanlydiemthidaihoc.view.LoginView;
import com.mycompany.quanlydiemthidaihoc.view.MainView;
import com.mycompany.quanlydiemthidaihoc.view.ManagerView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginController {

    private CheckLogin checkLogin;
    private LoginView loginView;
    private MainView mainView;

    public LoginController(LoginView view) {
        this.loginView = view;
        this.checkLogin = new CheckLogin();
        view.addLoginListener(new LoginListener());
    }

    public void showLoginView() {
        loginView.setVisible(true);
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Lấy thông tin tài khoản từ LoginView
            User user = loginView.getUser();
            
            // Kiểm tra tài khoản và mật khẩu
            if (checkLogin.checkUser(user)) {
                // Nếu đăng nhập thành công, tạo đối tượng MainView và MainController
                mainView = new MainView();
                MainController mainController = new MainController(mainView);
                mainController.showMainView();  // Hiển thị MainView

                // Ẩn LoginView
                loginView.setVisible(false);
            } else {
                // Hiển thị thông báo lỗi nếu đăng nhập không thành công
                loginView.showMessage("Tên đăng nhập hoặc mật khẩu không đúng.");
            }
        }
    }
}
