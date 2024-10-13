/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import dto.Contact;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author Sherif
 */
public class DAO {

    public static int newContact(Contact contact) throws SQLException {
        int insertionStatus = 0;
        DriverManager.registerDriver(new ClientDriver());
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/contactList", "root", "root");
        PreparedStatement statment = con.prepareStatement("INSERT INTO contact VALUES (?,?,?,?,?,?)");
        statment.setInt(1, contact.getId());
        statment.setString(2, contact.getfName());
        statment.setString(3, contact.getmName());
        statment.setString(4, contact.getlName());
        statment.setString(5, contact.getPhone());
        statment.setString(6, contact.getEmail());
        insertionStatus = statment.executeUpdate();
        return insertionStatus;
    }

    public static Vector<Contact> getAllContacts() throws SQLException {
        Vector<Contact> contacts = new Vector<>();
        DriverManager.registerDriver(new ClientDriver());
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/contactList", "root", "root");
        PreparedStatement statment = con.prepareStatement("SELECT * FROM contact");
        ResultSet resultSet = statment.executeQuery();

        while (resultSet.next()) {
            Contact contact = new Contact();
            contact.setId(resultSet.getInt("id"));
            contact.setfName(resultSet.getString("fName"));
            contact.setmName(resultSet.getString("mName"));
            contact.setlName(resultSet.getString("lName"));
            contact.setEmail(resultSet.getString("email"));
            contact.setPhone(resultSet.getString("phone"));
            contacts.add(contact);
        }
        return contacts;
    }

    public static int updateContact(Contact contact) throws SQLException {
        int updateStatus = 0;
        DriverManager.registerDriver(new ClientDriver());
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/contactList", "root", "root");
        PreparedStatement statment = con.prepareStatement("UPDATE contact SET fname = ?, mname = ?, lname = ?, phone = ?, email = ? WHERE id = ?");
        statment.setString(1, contact.getfName());
        statment.setString(2, contact.getmName());
        statment.setString(3, contact.getlName());
        statment.setString(4, contact.getPhone());
        statment.setString(5, contact.getEmail());
        statment.setInt(6, contact.getId());
        updateStatus = statment.executeUpdate();
        return updateStatus;
    }

    public static int deleteContact(int id) throws SQLException {
        int deleteStatus = 0;
        DriverManager.registerDriver(new ClientDriver());
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/contactList", "root", "root");
        PreparedStatement statement = con.prepareStatement("DELETE FROM contact WHERE id = ?");
        statement.setInt(1, id);
        deleteStatus = statement.executeUpdate();
        return deleteStatus;
    }

}
