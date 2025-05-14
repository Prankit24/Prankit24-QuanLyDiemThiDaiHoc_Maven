<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
=======
>>>>>>> b156958 (View fix)
package com.mycompany.quanlydiemthidaihoc.entity;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
<<<<<<< HEAD
/**
 *
 * @author Phuong Anh
 */

public class DateAdapter extends XmlAdapter<String, Date> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date unmarshal(String v) throws Exception {
        return dateFormat.parse(v);
=======

public class DateAdapter extends XmlAdapter<String, Date> {
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Date unmarshal(String v) throws Exception {
        return (v == null || v.isEmpty()) ? null : sdf.parse(v);
>>>>>>> b156958 (View fix)
    }

    @Override
    public String marshal(Date v) throws Exception {
<<<<<<< HEAD
        return dateFormat.format(v);
    }
}
=======
        return (v == null) ? "" : sdf.format(v);
    }
}
>>>>>>> b156958 (View fix)
