import java.io.*;
import java.net.*;
import java.util.*;

public class NameServer {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        int port = 5000;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected.");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String line = in.readLine();
                if (line.startsWith("ADD:")) {
                    String list = line.substring(4);
                    names.clear();
                    for (String n : list.split(",")) {
                        names.add(n.trim());
                    }
                    out.println("LIST_ADDED");
                } else if (line.startsWith("SEARCH:")) {
                    String name = line.substring(7).trim();
                    if (names.contains(name))
                        out.println("FOUND");
                    else
                        out.println("NOT_FOUND");
                } else {
                    out.println("UNKNOWN_COMMAND");
                }

                socket.close();
                System.out.println("Client disconnected.\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
