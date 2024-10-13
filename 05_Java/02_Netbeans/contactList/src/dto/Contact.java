/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Sherif
 */
public class Contact {

    private int id;
    private String fName;
    private String mName;
    private String lName;
    private String email;
    private String phone;

    public Contact(int id, String fName, String mName, String lName, String email, String phone) {
        this.id = id;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
    }

    public Contact() {
        this.id = 0;
        this.fName = "";
        this.mName = "";
        this.lName = "";
        this.email = "";
        this.phone = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
