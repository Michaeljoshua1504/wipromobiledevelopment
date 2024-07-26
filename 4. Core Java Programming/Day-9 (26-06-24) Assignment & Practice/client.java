import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    Scanner sc = new Scanner(System.in);
    helper h = new helper();

    List<String> inbox = new ArrayList<>();

    public client(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

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
        client c = new client("127.0.0.1", 8000);
    }
}