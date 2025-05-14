<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlydiemthidaihoc.entity;
import com.mycompany.quanlydiemthidaihoc.utils.FileUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */

@XmlRootElement(name = "SpecialPerson")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpecialPerson extends Person implements Serializable
{
    private static final long serialVersionUID = 1L;
   // private int id;
  //  private String name;
  //  private int year;
  //  private String address;
    private Date OpeningDate;
    private String type;
    private byte[] picture;
    //private SimpleDateFormat fDate=new SimpleDateFormat("dd/MM/yyyy");
    public SpecialPerson() 
    {
        
    }
    public SpecialPerson(int id, String name, Date birthday, String address, String OpeningDate, String type, byte[] image) throws ParseException 
    {
        super();
        SimpleDateFormat fDate=new SimpleDateFormat("dd/MM/yyyy");
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.OpeningDate = fDate.parse(OpeningDate);
        this.type=type;
        this.picture=image;
    }
    
    public Date getOpeningDate() 
    {
        return this.OpeningDate;
    }

    public void setOpeningDate(Date OpeningDate) 
    {
        //SimpleDateFormat fDate=new SimpleDateFormat("dd/MM/yyyy");
        this.OpeningDate = OpeningDate;
    }
    
    public String getType() 
    {
        return this.type;
    }

    public void setType(String type) 
    {
        this.type = type;
    }
    public byte[] getImage()
    {
        return picture;
    }
    
    public void setImage(byte[] image)
    {
        this.picture=image;
    }
}
=======
package com.mycompany.quanlydiemthidaihoc.entity;
import com.mycompany.quanlydiemthidaihoc.entity.Person;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.*;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@XmlRootElement(name = "SpecialPerson")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpecialPerson extends Person {
    private static final long serialVersionUID = 1L;

    private String type;

    @XmlJavaTypeAdapter(DateAdapter.class)  // Use DateAdapter for the Date field
    private Date OpeningDate;

    @XmlElement(name = "picture")
    private String pictureBase64; // Store image as Base64 string

    // Default constructor
    public SpecialPerson() {}

    // Parameterized constructor
    public SpecialPerson(int id, String name, Date birthday, String address, String openingDate, String type, byte[] image) throws ParseException {
        super(id, name, birthday, address);  // Assuming Person class requires these parameters
        SimpleDateFormat fDate = new SimpleDateFormat("dd/MM/yyyy");
        this.OpeningDate = fDate.parse(openingDate);
        this.type = type;
        this.setImage(image);  // Encode image to Base64
    }

    // Getter and Setter methods
    public Date getOpeningDate() {
        return this.OpeningDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.OpeningDate = openingDate;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Base64 encoding before saving image to XML
    public void setImage(byte[] image) {
        if (image != null) {
            this.pictureBase64 = Base64.getEncoder().encodeToString(image);
        } else {
            this.pictureBase64 = null;
        }
    }

    // Base64 decoding when reading image from XML
    public byte[] getImage() {
        if (this.pictureBase64 != null) {
            return Base64.getDecoder().decode(this.pictureBase64);
        }
        return null;
    }

    // Helper method to convert image file to byte array
    public byte[] convertImageToByteArray(String imagePath) throws IOException {
        File file = new File(imagePath);
        return Files.readAllBytes(file.toPath());
    }

    // Getters and setters for other fields
    // Assuming these fields are in the Person class or can be added directly in this class
    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public Date getBirthday() {
        return super.getBirthday();
    }

    public void setBirthday(Date birthday) {
        super.setBirthday(birthday);
    }

    public String getAddress() {
        return super.getAddress();
    }

    public void setAddress(String address) {
        super.setAddress(address);
    }
}

>>>>>>> b156958 (View fix)
