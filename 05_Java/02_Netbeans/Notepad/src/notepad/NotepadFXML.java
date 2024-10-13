package notepad;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NotepadFXML extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu menu;
    protected final MenuItem menuItemNew;
    protected final MenuItem menuItemOpenLow;
    protected final MenuItem menuItemOpenHigh;
    protected final MenuItem menuItemSaveLow;
    protected final MenuItem menuItemSaveHigh;
    protected final MenuItem menuItemExit;
    protected final Menu menu0;
    protected final MenuItem menuItemCut;
    protected final MenuItem menuItemCopy;
    protected final MenuItem menuItemPaste;
    protected final MenuItem menuItemDelete;
    protected final MenuItem menuItemSelectAll;
    protected final Menu menu1;
    protected final MenuItem menuItemAbout;
    protected final TextArea textArea;
    private Stage myStage;

    public NotepadFXML() {

        menuBar = new MenuBar();
        menu = new Menu();
        menuItemNew = new MenuItem();
        menuItemOpenLow = new MenuItem();
        menuItemOpenHigh = new MenuItem();
        menuItemSaveLow = new MenuItem();
        menuItemSaveHigh = new MenuItem();
        menuItemExit = new MenuItem();
        menu0 = new Menu();
        menuItemCut = new MenuItem();
        menuItemCopy = new MenuItem();
        menuItemPaste = new MenuItem();
        menuItemDelete = new MenuItem();
        menuItemSelectAll = new MenuItem();
        menu1 = new Menu();
        menuItemAbout = new MenuItem();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        menu.setMnemonicParsing(false);
        menu.setText("File");

        menuItemNew.setMnemonicParsing(false);
        menuItemNew.setText("New");
        menuItemNew.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        menuItemNew.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fc = new FileChooser();
                fc.setTitle("Create New File");

                fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
                File file = fc.showSaveDialog(myStage);
                if (file != null) {
                    try {
                        if (file.createNewFile()) {
                            textArea.clear(); 
                            Logger.getLogger(NotepadFXML.class.getName()).log(Level.INFO, "File created: " + file.getName());
                        } else {
                            Logger.getLogger(NotepadFXML.class.getName()).log(Level.WARNING, "File already exists.");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(NotepadFXML.class.getName()).log(Level.SEVERE, "An error occurred while creating the file.", ex);
                    }
                }                
            }
        });
        
        menuItemOpenLow.setMnemonicParsing(false);
        menuItemOpenLow.setText("Open Low");
        menuItemOpenLow.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        menuItemOpenLow.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                FileChooser fc = new FileChooser();
                File file = fc.showOpenDialog(myStage);
                if(file != null)
                {
                FileInputStream fis = null;
                    try {
                        fis = new FileInputStream(file);
                        int size;
                    try {
                        size = fis.available();
                        byte[] b = new byte[size];
                        fis.read(b);
                        textArea.setText(new String(b));
                        fis.close();
                    } catch (IOException ex) {
                        Logger.getLogger(NotepadFXML.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(NotepadFXML.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            fis.close();
                        } catch (IOException ex) {
                            Logger.getLogger(NotepadFXML.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
            }
        });
        
        menuItemOpenHigh.setMnemonicParsing(false);
        menuItemOpenHigh.setText("Open High");
        menuItemOpenHigh.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        menuItemOpenHigh.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fc = new FileChooser();
                File file = fc.showOpenDialog(myStage); 
                if (file != null) {
                    try {
                        FileInputStream fis = new FileInputStream(file);
                        DataInputStream dis = new DataInputStream(fis);
                        String fileContent = dis.readUTF();  
                        textArea.setText(fileContent);  
                        dis.close(); 
                        fis.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(NotepadFXML.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(NotepadFXML.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        
        menuItemSaveLow.setMnemonicParsing(false);
        menuItemSaveLow.setText("Save Low");
        menuItemSaveLow.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        menuItemSaveLow.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fc = new FileChooser();
                byte[] b = textArea.getText().getBytes();
                File file = fc.showSaveDialog(myStage);
                if(file != null)
                {
                    try {
                        FileOutputStream fos = new FileOutputStream(file);
                        fos.write(b);
                        fos.flush();
                        fos.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(NotepadFXML.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(NotepadFXML.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        
        menuItemSaveHigh.setMnemonicParsing(false);
        menuItemSaveHigh.setText("Save High");
        menuItemSaveHigh.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        menuItemSaveHigh.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fc = new FileChooser();
                File file = fc.showSaveDialog(myStage);
                if(file != null)
                {     
                    try {
                        FileOutputStream fos = new FileOutputStream(file);
                        DataOutputStream dos = new DataOutputStream(fos);
                        dos.writeUTF(textArea.getText());
                        fos.close();
                        dos.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(NotepadFXML.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(NotepadFXML.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        menuItemExit.setMnemonicParsing(false);
        menuItemExit.setText("Exit");
        menuItemExit.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        menuItemExit.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        menu0.setMnemonicParsing(false);
        menu0.setText("Edit");

        menuItemCut.setMnemonicParsing(false);
        menuItemCut.setText("Cut");
        menuItemCut.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
        menuItemCut.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.cut();
            }
        });
        
        menuItemCopy.setMnemonicParsing(false);
        menuItemCopy.setText("Copy");
        menuItemCopy.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
        menuItemCopy.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.copy();
            }
        });
        
        menuItemPaste.setMnemonicParsing(false);
        menuItemPaste.setText("Paste");
        menuItemPaste.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));
        menuItemPaste.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.paste();
            }
        });
        
        menuItemDelete.setMnemonicParsing(false);
        menuItemDelete.setText("Delete");
        menuItemDelete.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN));
        menuItemDelete.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int start = textArea.getSelection().getStart();
                int end = textArea.getSelection().getEnd();

                if (start != end) {
                    textArea.deleteText(start, end);
                } 
            }
        });
        
        
        menuItemSelectAll.setMnemonicParsing(false);
        menuItemSelectAll.setText("Select All");
        menuItemSelectAll.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        menuItemSelectAll.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.selectAll();
            }
        });
        
        menu1.setMnemonicParsing(false);
        menu1.setText("Help");

        menuItemAbout.setMnemonicParsing(false);
        menuItemAbout.setText("About");
        menuItemAbout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("About");
                alert.setHeaderText(null);
                alert.setContentText("This is a notepad developed by Sherif Ashraf V1.0");
                alert.showAndWait();
            }
        });
        
        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        menu.getItems().add(menuItemNew);
        menu.getItems().add(menuItemOpenLow);
        menu.getItems().add(menuItemOpenHigh);
        menu.getItems().add(menuItemSaveLow);
        menu.getItems().add(menuItemSaveHigh);
        menu.getItems().add(menuItemExit);
        menuBar.getMenus().add(menu);
        menu0.getItems().add(menuItemCut);
        menu0.getItems().add(menuItemCopy);
        menu0.getItems().add(menuItemPaste);
        menu0.getItems().add(menuItemDelete);
        menu0.getItems().add(menuItemSelectAll);
        menuBar.getMenus().add(menu0);
        menu1.getItems().add(menuItemAbout);
        menuBar.getMenus().add(menu1);

    }

    NotepadFXML(Stage stage) {
        this();
        myStage = stage;
    }
}
