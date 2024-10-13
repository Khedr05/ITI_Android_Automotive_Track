/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sherif
 */
public class ChatServer {

    ServerSocket serverSocket;

    public ChatServer() throws IOException {
        serverSocket = new ServerSocket(5005);
        while (true) {
            Socket s = serverSocket.accept();
            new ChatHandler(s);
        }
    }

    public static void main(String[] args) throws IOException {
        new ChatServer();
    }
}

class ChatHandler extends Thread {

    DataInputStream dis;
    PrintStream ps;
    static Vector<ChatHandler> clientsVector
            = new Vector<ChatHandler>();

    public ChatHandler(Socket cs) {
        try {
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
            ChatHandler.clientsVector.add(this);
            start();
        } catch (IOException ex) {
            Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void run() {
        while (true) {
            String str;
            try {
                str = dis.readLine();
                sendMessageToAll(str);
            } catch (IOException ex) {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void sendMessageToAll(String msg) {
// for(ChatHandler ch : clientsVector)
        for (int i = 0; i < clientsVector.size(); i++) {
            clientsVector.get(i).ps.println(msg);
        }
    }
}
