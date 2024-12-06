import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Objects;

public class Client {
    private static String address;

    private static final int PORT = 13579;

    private static final ArrayList<String> servers = new ArrayList<>();

    private static final ArrayList<Double> serverPings = new ArrayList<>();
    Socket socket;

    private PrintWriter output;

    private BufferedReader input;

    public static double pingServer(String ip) {
        try {
            String command = "ping -c 1 " + ip;
            if (System.getProperty("os.name").startsWith("Windows")) {
                command = "ping -n 1 " + ip;
            }

            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            double pingTime = Double.MAX_VALUE;

            while ((line = reader.readLine()) != null) {
                if (line.contains("time=")) {
                    String[] parts = line.split("time=");
                    String timeStr = parts[1].split(" ")[0];
                    pingTime = Double.parseDouble(timeStr);
                    break;
                }
            }

            process.waitFor();
            return pingTime;
        } catch (Exception e) {
            System.out.println("Server pinging failed : " + ip + ": " + e.getMessage());
            return Double.MAX_VALUE;
        }
    }

    public static String serverToGoTo() {
        servers.add("127.0.0.1");
        for (int i = 0; i < servers.size(); i++) {
            String tempServer = servers.get(i);
            serverPings.add(pingServer(tempServer));
        }


        int bestPingIndex = 0;
        for (int i = 0; i < serverPings.size(); i++) {
            if (serverPings.get(i) < serverPings.get(bestPingIndex)) {
                bestPingIndex = i;
            }
        }

        return servers.get(bestPingIndex);
    }

    public void connectToServer() throws IOException {
        address = serverToGoTo();
        socket = new Socket(address, PORT);
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Server connected!");
    }

    public void startListening() {
        new Thread(() -> {
            try {
                String message;
                while ((message = input.readLine()) != null) {
                    System.out.println("Recieved : " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendMessage(String message, String idToGoTo) {
        if (Objects.equals(idToGoTo, "all")) {
            output.println(message);
        } else if (!Objects.equals(idToGoTo, "all")) {
            Server.ClientHandler clientToGoTo = Server.clients.get(idToGoTo);
            if (clientToGoTo != null) {
                clientToGoTo.output.println(message);
            } else {
                System.out.println("Client with id " + idToGoTo + " not found.");
            }
        }
    }
}
