import java.io.*;
import java.net.*;

public class Client {
    private static final String ADDRESS = "127.0.0.1";

    private static final int PORT = 13795;

    private Socket socket;

    private PrintWriter output;

    private BufferedReader input;

    public static void main(String arg[]) throws IOException {
        Client client = new Client();
        client.connectToServer();
        client.startListening();
    }

    public void connectToServer() throws IOException {
        socket = new Socket(ADDRESS, PORT);
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Server connected!");
    }

    public void startListening() throws IOException {
        new Thread(() -> {
            try {
                String message;
                while ((message = input.readLine()) != null) {
                    System.out.println("Recieved : " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String messageFromPlayer;
        while ((messageFromPlayer = userInput.readLine()) != null) {
            output.println(messageFromPlayer);
        }
    }
}
