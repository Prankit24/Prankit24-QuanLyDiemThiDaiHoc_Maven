/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlydiemthidaihoc.action;

import com.mycompany.quanlydiemthidaihoc.entity.User;

public class CheckLogin {
    

    // Phương thức kiểm tra thông tin đăng nhập
    public boolean checkUser(User user) {
        // Giả sử tài khoản hợp lệ là userName = "admin" và password = "password123"
<<<<<<< HEAD
        if ("admin".equals(user.getUserName()) && "12345".equals(user.getPassword())) {
=======
        if ("admin".equals(user.getUserName()) && "12".equals(user.getPassword())) {
>>>>>>> b156958 (View fix)
            return true;
        }
        return false;
    }
    
}
