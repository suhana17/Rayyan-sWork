import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private static Map<Integer, ClientHandler> clients = new HashMap<>();
    private static int idCount = 1;

    private static final int PORT = 13795;

    public static String databaseStatement;

    private static Connection findConnection(String databaseUser, String databasePassword, String databaseUrl) throws SQLException {
        return DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
    }

    public static void main(String arg[]) {
        while (true) {
//        Properties properties = new Properties();
//        properties.load(new FileInputStream("database.properties"));
//
//        String databaseUser = properties.getProperty("db.username");
//        String databasePassword = properties.getProperty("db.password");
//        String databaseUrl = properties.getProperty("db.url");
//        try (Connection connection = findConnection(databaseUser, databasePassword, databaseUrl)) {
//            System.out.println("Connected to Postgres!!!");
//            PreparedStatement preparedStatement = connection.prepareStatement(databaseStatement);
//            ResultSet resultSet = preparedStatement.executeQuery()){
//
//            }
//            }
//        } catch (SQLException e) {
//            System.err.println("Failed connecting to Postgres..." + e.getMessage());
//        }
          
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println(PORT + " is the port which the server has started!!!");
          
            Socket clientSocket = serverSocket.accept();
            System.out.println("New player detected! " + clientSocket.getInetAddress());
            ClientHandler clientHandler = new ClientHandler(clientSocket, idCount);
            clients.put(idCount, clientHandler);
            clientHandler.start();

            idCount++;
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter output;
        private BufferedReader input;
        private int id;

        public ClientHandler(Socket socket, int id) throws IOException {
            this.socket = socket;
            this.id = id;
            this.output = new PrintWriter(socket.getOutputStream(), true);
            this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("your id is : " + id);
        }

        public void run() {
            try {
                String message;
                while ((message = input.readLine()) != null) {
                    System.out.println("Message came from client : " + id + " with " + message);

                    if (message.startsWith("goto")) {
                        String[] parts = message.split(" ", 3);
                        if (parts.length == 3) {
                            int idToGoTO = Integer.parseInt(parts[1]);
                            String messageSend = parts[2];

                            sendMessageToClient(idToGoTO, messageSend);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clients.remove(id);
            }
        }

        private void sendMessageToClient(int idToGoTo, String message) {
            ClientHandler targetClient = clients.get(idToGoTo);
            if (targetClient != null) {
                targetClient.output.println("client " + id + " messaged " + message);
            } else {
                output.println("Client " + id + " is not found");
            }
        }
    }
}