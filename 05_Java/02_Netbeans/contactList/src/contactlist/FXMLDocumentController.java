package contactlist;

import db.DAO;
import dto.Contact;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Sherif
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label Idlabel;
    @FXML
    private Label fnamelabel;
    @FXML
    private Label mnamelabel;
    @FXML
    private Label lnamelabel;
    @FXML
    private Label emaillabel;
    @FXML
    private Label phonelabel;
    @FXML
    private TextField idtext;
    @FXML
    private TextField fnametext;
    @FXML
    private TextField mnametext;
    @FXML
    private TextField lnametext;
    @FXML
    private TextField emailtext;
    @FXML
    private TextField phonetext;
    @FXML
    private Button newbtn;
    @FXML
    private Button updatebtn;
    @FXML
    private Button deletebtn;
    @FXML
    private Button firstbtn;
    @FXML
    private Button previousbtn;
    @FXML
    private Button nextbtn;
    @FXML
    private Button lastbtn;

    private Vector<Contact> contacts = new Vector<>();
    private int currentIndex = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            contacts = DAO.getAllContacts(); 
            if (!contacts.isEmpty()) {
                displayContact(contacts.get(0)); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void newBtnAction(ActionEvent event) {
        try {
            int id = Integer.parseInt(idtext.getText());
            String fName = fnametext.getText();
            String mName = mnametext.getText();
            String lName = lnametext.getText();
            String email = emailtext.getText();
            String phone = phonetext.getText();

            Contact newContact = new Contact(id, fName, mName, lName, email, phone);

            int result = DAO.newContact(newContact);

            if (result > 0) {
                System.out.println("Contact added successfully!");
                contacts = DAO.getAllContacts(); 
                currentIndex = contacts.size() - 1; 
                displayContact(contacts.get(currentIndex));
            } else {
                System.out.println("Failed to add contact.");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Please enter a valid number for ID.");
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updatebtnAction(ActionEvent event) {
        try {
            int id = Integer.parseInt(idtext.getText());
            String fName = fnametext.getText();
            String mName = mnametext.getText();
            String lName = lnametext.getText();
            String email = emailtext.getText();
            String phone = phonetext.getText();

            Contact updatedContact = new Contact(id, fName, mName, lName, email, phone);

            int result = DAO.updateContact(updatedContact);

            if (result > 0) {
                System.out.println("Contact updated successfully!");
                contacts = DAO.getAllContacts(); 
                displayContact(contacts.get(currentIndex)); 
            } else {
                System.out.println("Failed to update contact.");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Please enter a valid number for ID.");
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteBtnAction(ActionEvent event) {
        try {
            int id = Integer.parseInt(idtext.getText());

            int result = DAO.deleteContact(id);

            if (result > 0) {
                System.out.println("Contact deleted successfully!");
                contacts = DAO.getAllContacts(); 
                if (!contacts.isEmpty()) {
                    currentIndex = Math.min(currentIndex, contacts.size() - 1); 
                    displayContact(contacts.get(currentIndex));
                } else {
                    idtext.clear();
                    fnametext.clear();
                    mnametext.clear();
                    lnametext.clear();
                    emailtext.clear();
                    phonetext.clear();
                }
            } else {
                System.out.println("Failed to delete contact.");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Please enter a valid number for ID.");
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void firstBtnAction(ActionEvent event) {
        if (!contacts.isEmpty()) {
            currentIndex = 0; 
            displayContact(contacts.get(currentIndex));
        }
    }

    @FXML
    private void previousBtnAction(ActionEvent event) {
        if (!contacts.isEmpty() && currentIndex > 0) {
            currentIndex--;
            displayContact(contacts.get(currentIndex));
        }
    }

    @FXML
    private void nextBtnAction(ActionEvent event) {
        if (!contacts.isEmpty() && currentIndex < contacts.size() - 1) {
            currentIndex++;
            displayContact(contacts.get(currentIndex));
        }
    }

    @FXML
    private void lastBtnAction(ActionEvent event) {
        if (!contacts.isEmpty()) {
            currentIndex = contacts.size() - 1; 
            displayContact(contacts.get(currentIndex));
        }
    }

    private void displayContact(Contact contact) {
        idtext.setText(String.valueOf(contact.getId()));
        fnametext.setText(contact.getfName());
        mnametext.setText(contact.getmName());
        lnametext.setText(contact.getlName());
        emailtext.setText(contact.getEmail());
        phonetext.setText(contact.getPhone());
    }
}
