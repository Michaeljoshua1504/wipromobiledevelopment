import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class server {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
    private ServerSocket server = null;

    Scanner sc = new Scanner(System.in);
    List<String> inbox = new ArrayList<>();
    helper h = new helper();
    public server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for the client...");

            socket = server.accept(); // accept the clien to connect

            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            while (true) {
                int choice = h.showOptions();
                switch (choice) {
                    case 1:
                        System.out.print("Enter your message: ");
                        String message = sc.nextLine();
                        h.sendMessage(out, message);
                        break;
                    case 2:
                        inbox.add(h.receiveMessage(input));
                        System.out.println("Inbox: ");
                        inbox.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.println("Thanks for using Java Networking services");
                        sc.close();
                        input.close();
                        out.close();
                        socket.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong choice");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        server s = new server(8000);
    }
}