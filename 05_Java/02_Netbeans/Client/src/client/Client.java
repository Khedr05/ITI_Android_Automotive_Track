import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        try {
            mySocket = new Socket("127.0.0.1", 5005);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());

            // Send a test message to the server
            ps.println("Test Test");

            // Receive and print the server's reply
            String replyMsg = dis.readLine();
            System.out.println(replyMsg);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (dis != null) dis.close();
                if (mySocket != null) mySocket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
