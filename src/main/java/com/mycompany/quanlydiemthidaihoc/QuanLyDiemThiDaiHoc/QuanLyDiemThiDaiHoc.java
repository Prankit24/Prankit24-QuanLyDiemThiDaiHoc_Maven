/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quanlydiemthidaihoc.QuanLyDiemThiDaiHoc;

import com.mycompany.quanlydiemthidaihoc.controller.LoginController;
import com.mycompany.quanlydiemthidaihoc.view.LoginView;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class QuanLyDiemThiDaiHoc {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true); 
            }
        });
    }
}

