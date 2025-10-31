import java.io.*;
import java.net.*;
import java.util.Scanner;

public class NameClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;
        Scanner sc = new Scanner(System.in);

        try {
            // إرسال قائمة الأسماء مرة واحدة
            System.out.print("Enter list of names (comma separated): ");
            String names = sc.nextLine();

            Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("ADD:" + names);
            System.out.println("Server: " + in.readLine());
            socket.close();

            // الآن يسأل العميل عن أسماء
            while (true) {
                System.out.print("\nEnter name to search (or 'exit'): ");
                String name = sc.nextLine();
                if (name.equalsIgnoreCase("exit")) break;

                socket = new Socket(host, port);
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                out.println("SEARCH:" + name);
                System.out.println("Server: " + in.readLine());
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
