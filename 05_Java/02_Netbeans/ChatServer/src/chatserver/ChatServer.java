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
import java.net.SocketException;
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
    static Vector<ChatHandler> clientsVector = new Vector<>();

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
        try {
            while (true) {
                String str = dis.readLine();
                if (str == null) {
                    break;  
                }
                sendMessageToAll(str);
            }
        } catch (SocketException ex) {
            Logger.getLogger(ChatHandler.class.getName()).log(Level.INFO, "Client disconnected: {0}", ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, "I/O error occurred", ex);
        } finally {
            cleanup();  
        }
    }

    void sendMessageToAll(String msg) {
        for (int i = 0; i < clientsVector.size(); i++) {
            clientsVector.get(i).ps.println(msg);
        }
    }

    void cleanup() {
        try {
            clientsVector.remove(this);
            if (dis != null) {
                dis.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
