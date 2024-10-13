package chatclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class chatClientfxml extends BorderPane {

    protected final FlowPane flowPane;
    protected final TextField textField;
    protected final Button sendBtn;
    protected final TextArea textArea;

    Socket invitation;
    DataInputStream ear;
    PrintStream mouth;

    public chatClientfxml() {

        try {
            invitation = new Socket("127.0.0.1", 5005);
            ear = new DataInputStream(invitation.getInputStream());
            mouth = new PrintStream(invitation.getOutputStream());

        } catch (IOException ex) {
            Logger.getLogger(chatClientfxml.class.getName()).log(Level.SEVERE, null, ex);
        }

        new Thread() {
            public void run() {
                try {
                    while (true) {
                        String msg = ear.readLine();
                        if (msg == null) {
                            break;
                        }
                        textArea.appendText(msg + "\n");
                    }
                } catch (SocketException ex) {
                    Logger.getLogger(chatClientfxml.class.getName()).log(Level.INFO, "Connection reset: {0}", ex.getMessage());
                } catch (IOException ex) {
                    Logger.getLogger(chatClientfxml.class.getName()).log(Level.SEVERE, "Connection lost", ex);
                } finally {
                    cleanup();
                }
            }
        }.start();

        flowPane = new FlowPane();
        textField = new TextField();
        sendBtn = new Button();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setPrefHeight(65.0);
        flowPane.setPrefWidth(600.0);

        textField.setPrefHeight(40.0);
        textField.setPrefWidth(466.0);

        sendBtn.setMnemonicParsing(false);
        sendBtn.setPrefHeight(31.0);
        sendBtn.setPrefWidth(116.0);
        sendBtn.setText("Send");
        setBottom(flowPane);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setEditable(false);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        flowPane.getChildren().add(textField);
        flowPane.getChildren().add(sendBtn);

        sendBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String msg = textField.getText();
                mouth.println(msg);
                textField.clear();
            }
        });
    }

    private void cleanup() {
        try {
            if (ear != null) {
                ear.close();
            }
            if (mouth != null) {
                mouth.close();
            }
            if (invitation != null) {
                invitation.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(chatClientfxml.class.getName()).log(Level.SEVERE, "Error during cleanup", ex);
        }
    }
}
