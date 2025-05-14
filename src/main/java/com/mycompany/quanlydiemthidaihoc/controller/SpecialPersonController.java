package com.mycompany.quanlydiemthidaihoc.controller;

import com.mycompany.quanlydiemthidaihoc.action.SpecialPersonManager;
import com.mycompany.quanlydiemthidaihoc.entity.SpecialPerson;
<<<<<<< HEAD
import com.mycompany.quanlydiemthidaihoc.view.LoginView;
import com.mycompany.quanlydiemthidaihoc.view.MainView;
import com.mycompany.quanlydiemthidaihoc.view.ManagerView;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 *
 * @author PC
 */


public class SpecialPersonController {

    private SimpleDateFormat fDate = new SimpleDateFormat("dd/MM/yyyy");
=======
import com.mycompany.quanlydiemthidaihoc.view.ManagerView;
import com.mycompany.quanlydiemthidaihoc.view.MainView;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialPersonController {

>>>>>>> b156958 (View fix)
    private SpecialPersonManager specialPersonManager;
    private ManagerView managerView;
    private MainView mainView;

<<<<<<< HEAD
    // Constructor duy nhất nhận cả ManagerView và MainView
=======
    // Constructor that accepts ManagerView and MainView
>>>>>>> b156958 (View fix)
    public SpecialPersonController(ManagerView managerView, MainView mainView) {
        this.managerView = managerView;
        this.mainView = mainView;
        this.specialPersonManager = new SpecialPersonManager();

<<<<<<< HEAD
        // Đăng ký các listener cho các nút
        managerView.addAddSpecialPersonListener(new AddSpecialPersonListener());
        managerView.addEditSpecialPersonListener(new EditSpecialPersonListener());
        managerView.addClearListener(new ClearSpecialPersonListener());
        managerView.addDeleteSpecialPersonListener(new DeleteSpecialPersonListener());
        managerView.addListSpecialPersonSelectionListener(new ListSpecialPersonSelectionListener());
        managerView.addSortByNameListener(new SortSpecialPersonNameListener());
        managerView.addSearchListener(new SearchSpecialPersonViewListener());
        managerView.addSearchDialogListener(new SearchSpecialPersonListener());
        managerView.addSortByYearListener(new SortSpecialPersonYearListener());
        managerView.addSortByIDListener(new SortSpecialPersonIDListener());
        managerView.addSortByOpeningDateListener(new SortSpecialPersonOpeningDateListener());
        managerView.addCancelSearchSpecialPersonListener(new CancelSearchSpecialPersonListener());
        managerView.addImageSpecialPersonListener(new ImageSpecialPersonListener());
        managerView.addCancelDialogListener(new CancelDialogSearchSpecialPersonListener());
        managerView.addUndoListener(new UndoListener());
        managerView.addStatisticListener(new StatisticViewListener());
//        managerView.addStatisticTypeListener(new StatisticSpecialPersonTypeListener());
//        managerView.addStatisticAgeListener(new StatisticSpecialPersonAgeListener());
//        managerView.addStatisticUnderListener(new StatisticClearListener());
//
//        // Sự kiện cho các checkbox và combobox
//        managerView.addCheckBoxListener(new CheckBoxListener());
//        managerView.addComboBoxListener(new ComboBoxListener());
    }
    // Trong SpecialPersonController.java
class ImageSpecialPersonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Xử lý khi người dùng nhấn nút Image
            managerView.SpecialPersonImage();  // Gọi phương thức xử lý ảnh trong ManagerView
        }
=======
        // Register listeners
        managerView.addAddSpecialPersonListener(new AddSpecialPersonListener());
        managerView.addEditSpecialPersonListener(new EditSpecialPersonListener());
        managerView.addDeleteSpecialPersonListener(new DeleteSpecialPersonListener());
        managerView.addSearchListener(new SearchSpecialPersonListener());
        managerView.addSortByNameListener(new SortByNameListener());
        managerView.addSortByOpeningDateListener(new SortByOpeningDateListener());
        managerView.addStatisticListener(new StatisticViewListener());
>>>>>>> b156958 (View fix)
    }

    public void showManagerView() {
        List<SpecialPerson> specialPersonList = specialPersonManager.getListSpecialPersons();
        managerView.showListSpecialPersons(specialPersonList);
        managerView.showCountListSpecialPersons(specialPersonList);
        managerView.setVisible(true);
<<<<<<< HEAD
        mainView.setVisible(false); // Ẩn MainView
    }

    // Các phương thức sự kiện tương ứng với các nút
=======
        mainView.setVisible(false);  // Hide MainView
    }

    // ActionListener to handle Add SpecialPerson
>>>>>>> b156958 (View fix)
    class AddSpecialPersonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            SpecialPerson specialPerson = managerView.getSpecialPersonInfo();
            if (specialPerson != null) {
                specialPersonManager.add(specialPerson);
                managerView.showSpecialPerson(specialPerson);
                managerView.showListSpecialPersons(specialPersonManager.getListSpecialPersons());
                managerView.showCountListSpecialPersons(specialPersonManager.getListSpecialPersons());
                managerView.showMessage("Thêm thành công!");
            }
        }
    }

<<<<<<< HEAD
    class EditSpecialPersonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            SpecialPerson specialPerson = managerView.getSpecialPersonInfo();
            if (specialPerson != null) {
                try {
                    specialPersonManager.edit(specialPerson);
                } catch (ParseException ex) {
                    Logger.getLogger(SpecialPersonController.class.getName()).log(Level.SEVERE, null, ex);
                }
=======
    // ActionListener to handle Edit SpecialPerson
    class EditSpecialPersonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        try {
            SpecialPerson specialPerson = managerView.getSpecialPersonInfo();
            if (specialPerson != null) {
                specialPersonManager.edit(specialPerson);  // Now it will throw ParseException
>>>>>>> b156958 (View fix)
                managerView.showSpecialPerson(specialPerson);
                managerView.showListSpecialPersons(specialPersonManager.getListSpecialPersons());
                managerView.showCountListSpecialPersons(specialPersonManager.getListSpecialPersons());
                managerView.showMessage("Cập nhật thành công!");
            }
<<<<<<< HEAD
        }
    }

=======
        } catch (Exception ex) {
            managerView.showMessage("Lỗi khi cập nhật thông tin. Vui lòng kiểm tra lại dữ liệu.");
        }
    }
}

    // ActionListener to handle Delete SpecialPerson
>>>>>>> b156958 (View fix)
    class DeleteSpecialPersonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            SpecialPerson specialPerson = managerView.getSpecialPersonInfo();
            if (specialPerson != null) {
                specialPersonManager.delete(specialPerson);
                managerView.clearSpecialPersonInfo();
                managerView.showListSpecialPersons(specialPersonManager.getListSpecialPersons());
                managerView.showCountListSpecialPersons(specialPersonManager.getListSpecialPersons());
                managerView.showMessage("Xóa thành công!");
            }
        }
    }

<<<<<<< HEAD
    class ClearSpecialPersonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerView.clearSpecialPersonInfo();
        }
    }

    class SortSpecialPersonNameListener implements ActionListener {
=======
    // ActionListener to handle Search SpecialPerson
    class SearchSpecialPersonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerView.searchNameSpecialPersonInfo();
        }
    }

    // ActionListener to handle Sort by Name
    class SortByNameListener implements ActionListener {
>>>>>>> b156958 (View fix)
        public void actionPerformed(ActionEvent e) {
            specialPersonManager.sortSpecialPersonByName();
            managerView.showListSpecialPersons(specialPersonManager.getListSpecialPersons());
        }
    }

<<<<<<< HEAD
    class SortSpecialPersonYearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            specialPersonManager.sortSpecialPersonByBirthDay();
            managerView.showListSpecialPersons(specialPersonManager.getListSpecialPersons());
        }
    }

    class SortSpecialPersonIDListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            specialPersonManager.sortSpecialPersonByID();
            managerView.showListSpecialPersons(specialPersonManager.getListSpecialPersons());
        }
    }

    class SortSpecialPersonOpeningDateListener implements ActionListener {
=======
    // ActionListener to handle Sort by Opening Date
    class SortByOpeningDateListener implements ActionListener {
>>>>>>> b156958 (View fix)
        public void actionPerformed(ActionEvent e) {
            specialPersonManager.sortSpecialPersonByOpeningDate();
            managerView.showListSpecialPersons(specialPersonManager.getListSpecialPersons());
        }
    }

<<<<<<< HEAD
    class SearchSpecialPersonViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerView.searchNameSpecialPersonInfo();
        }
    }

=======
    // ActionListener to handle Statistics
>>>>>>> b156958 (View fix)
    class StatisticViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerView.displayStatisticView();
        }
    }
<<<<<<< HEAD

    class SearchSpecialPersonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            boolean kt = false;
            List<SpecialPerson> temp = new ArrayList<>();
            int check = managerView.getChooseSelectSearch();
            String search = managerView.validateSearch();
            if (check == 1) {
                // Tìm kiếm theo tên
                temp = specialPersonManager.searchSpecialPersonName(search);
            } else if (check == 2) {
                // Tìm kiếm theo địa chỉ
                temp = specialPersonManager.searchSpecialPersonAddress(search);
            } else if (check == 3) {
                // Tìm kiếm theo loại đối tượng
                temp = specialPersonManager.searchSpecialPersonYear(search);
            }
            if (!temp.isEmpty()) managerView.showListSpecialPersons(temp);
            else managerView.showMessage("Không tìm thấy kết quả!");
        }
    }

    class CancelDialogSearchSpecialPersonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerView.cancelDialogSearchSpecialPersonInfo();
        }
    }

    class CancelSearchSpecialPersonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerView.showListSpecialPersons(specialPersonManager.getListSpecialPersons());
            managerView.cancelSearchSpecialPerson();
        }
    }

    class UndoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainView.setVisible(true);
            managerView.setVisible(false);
        }
    }

    class ListSpecialPersonSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            try {
                managerView.fillSpecialPersonFromSelectedRow();
            } catch (ParseException ex) {
                Logger.getLogger(SpecialPersonController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//    class StatisticSpecialPersonTypeListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            managerView.showStatisticTypeSpecialPersons(specialPersonManager.getListSpecialPersons());
//        }
//    }
//
//    class StatisticSpecialPersonAgeListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            managerView.showStatisticAgeSpecialPersons(specialPersonManager.getListSpecialPersons());
//        }
//    }
//
//    class StatisticClearListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            managerView.clearStatisticView();
//        }
//    }
//
//    // Sự kiện cho các checkbox và combobox
//    class CheckBoxListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            // Xử lý khi người dùng thay đổi trạng thái checkbox
//            if (managerView.getCheckBoxAddress().isSelected()) {
//                // Làm gì đó khi checkbox Address được chọn
//            }
//            if (managerView.getCheckBoxName().isSelected()) {
//                // Làm gì đó khi checkbox Name được chọn
//            }
//            if (managerView.getCheckBoxYear().isSelected()) {
//                // Làm gì đó khi checkbox Year được chọn
//            }
//        }
//    }
//
//    class ComboBoxListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            // Xử lý khi người dùng thay đổi lựa chọn trong ComboBoxType
//            String selectedType = (String) managerView.getComboBoxType().getSelectedItem();
//            // Làm gì đó tùy thuộc vào lựa chọn của ComboBox
//        }
//    }
}
=======
}
>>>>>>> b156958 (View fix)
