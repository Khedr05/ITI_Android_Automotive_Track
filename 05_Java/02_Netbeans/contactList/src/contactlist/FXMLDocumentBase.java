package contactlist;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class FXMLDocumentBase extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final RowConstraints rowConstraints5;
    protected final Label Idlabel;
    protected final Label fnamelabel;
    protected final Label mnamelabel;
    protected final Label lnamelabel;
    protected final Label emaillabel;
    protected final Label phonelabel;
    protected final TextField idtext;
    protected final TextField fnametext;
    protected final TextField mnametext;
    protected final TextField lnametext;
    protected final TextField emailtext;
    protected final TextField phonetext;
    protected final FlowPane flowPane;
    protected final Button newbtn;
    protected final Button updatebtn;
    protected final Button deletebtn;
    protected final Button firstbtn;
    protected final Button Previousbtn;
    protected final Button nextbtn;
    protected final Button lastbtn;

    public FXMLDocumentBase() {

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        Idlabel = new Label();
        fnamelabel = new Label();
        mnamelabel = new Label();
        lnamelabel = new Label();
        emaillabel = new Label();
        phonelabel = new Label();
        idtext = new TextField();
        fnametext = new TextField();
        mnametext = new TextField();
        lnametext = new TextField();
        emailtext = new TextField();
        phonetext = new TextField();
        flowPane = new FlowPane();
        newbtn = new Button();
        updatebtn = new Button();
        deletebtn = new Button();
        firstbtn = new Button();
        Previousbtn = new Button();
        nextbtn = new Button();
        lastbtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(293.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(132.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(468.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(468.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPrefHeight(30.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        Idlabel.setText("Id");

        GridPane.setRowIndex(fnamelabel, 1);
        fnamelabel.setText("First Name");

        GridPane.setRowIndex(mnamelabel, 2);
        mnamelabel.setText("Midlle Name");

        GridPane.setRowIndex(lnamelabel, 3);
        lnamelabel.setText("Last Name");

        GridPane.setRowIndex(emaillabel, 4);
        emaillabel.setText("Email");

        GridPane.setRowIndex(phonelabel, 5);
        phonelabel.setText("Phone");

        GridPane.setColumnIndex(idtext, 1);

        GridPane.setColumnIndex(fnametext, 1);
        GridPane.setRowIndex(fnametext, 1);

        GridPane.setColumnIndex(mnametext, 1);
        GridPane.setRowIndex(mnametext, 2);

        GridPane.setColumnIndex(lnametext, 1);
        GridPane.setRowIndex(lnametext, 3);

        GridPane.setColumnIndex(emailtext, 1);
        GridPane.setRowIndex(emailtext, 4);

        GridPane.setColumnIndex(phonetext, 1);
        GridPane.setRowIndex(phonetext, 5);

        GridPane.setColumnIndex(flowPane, 1);
        GridPane.setRowIndex(flowPane, 6);
        flowPane.setPrefHeight(200.0);
        flowPane.setPrefWidth(200.0);

        newbtn.setMnemonicParsing(false);
        newbtn.setOnAction(this::newBtnAction);
        newbtn.setText("New");

        updatebtn.setMnemonicParsing(false);
        updatebtn.setOnAction(this::updatebtnAction);
        updatebtn.setText("Update");

        deletebtn.setMnemonicParsing(false);
        deletebtn.setOnAction(this::deleteBtnAction);
        deletebtn.setText("Delete");

        firstbtn.setMnemonicParsing(false);
        firstbtn.setOnAction(this::firstBtnAction);
        firstbtn.setText("First");

        Previousbtn.setMnemonicParsing(false);
        Previousbtn.setOnAction(this::previousBtnAction);
        Previousbtn.setText("previous");

        nextbtn.setMnemonicParsing(false);
        nextbtn.setOnAction(this::nextBtnAction);
        nextbtn.setText("Next");

        lastbtn.setMnemonicParsing(false);
        lastbtn.setOnAction(this::lastBtnAction);
        lastbtn.setText("Last");

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getRowConstraints().add(rowConstraints2);
        getRowConstraints().add(rowConstraints3);
        getRowConstraints().add(rowConstraints4);
        getRowConstraints().add(rowConstraints5);
        getChildren().add(Idlabel);
        getChildren().add(fnamelabel);
        getChildren().add(mnamelabel);
        getChildren().add(lnamelabel);
        getChildren().add(emaillabel);
        getChildren().add(phonelabel);
        getChildren().add(idtext);
        getChildren().add(fnametext);
        getChildren().add(mnametext);
        getChildren().add(lnametext);
        getChildren().add(emailtext);
        getChildren().add(phonetext);
        flowPane.getChildren().add(newbtn);
        flowPane.getChildren().add(updatebtn);
        flowPane.getChildren().add(deletebtn);
        flowPane.getChildren().add(firstbtn);
        flowPane.getChildren().add(Previousbtn);
        flowPane.getChildren().add(nextbtn);
        flowPane.getChildren().add(lastbtn);
        getChildren().add(flowPane);

    }

    protected  void newBtnAction(javafx.event.ActionEvent actionEvent){};

    protected  void updatebtnAction(javafx.event.ActionEvent actionEvent){};

    protected  void deleteBtnAction(javafx.event.ActionEvent actionEvent){};

    protected  void firstBtnAction(javafx.event.ActionEvent actionEvent){};

    protected  void previousBtnAction(javafx.event.ActionEvent actionEvent){};

    protected  void nextBtnAction(javafx.event.ActionEvent actionEvent){};

    protected  void lastBtnAction(javafx.event.ActionEvent actionEvent){};

}
