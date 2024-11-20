import java.io.*;
import java.net.*;

public class Client {
    private static final String ADDRESS;

    private static final ArrayList<String> servers = new ArrayList<>();
    servers.add("127.0.0.1");

    private static final ArrayList<Long> serverPings = new ArrayList<>();

    private static final int PORT = 13795;

    private Socket socket;

    private PrintWriter output;

    private BufferedReader input;

    public static long pingServer(String ipToServer) {
        try {
            InetAddress serverAdress = InetAddress.getByName(ipToServer);
            long startTime = System.currentTimeMillis();
            boolean reachable = serverAddress.isReachable(5000);
            long endTime = System.currentTimeMillis();

            if (reachable) {
                return endTime - startTime;
            } else {
                return Long.MAX_VALUE;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Long.MAX_VALUE;
        }
    }

    public static String serverToGoTo(String server1, String server2) {
        for (int i = 0; i < servers.size(); i++) {
            long latency = pingServer(i);
            serverPings.add(latency);
        }
        int bestPingIndex = 0;
        for (int j = 0; j < serverPings.size(); j++) {
            if (serverPings.get(i) < serverPings.get(bestPingIndex)) {
                bestPingIndex = i;
            }
        }

        return servers.get(bestPingIndex);
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

        output.println("bello");
        // BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        // String messageFromPlayer;
        // while ((messageFromPlayer = userInput.readLine()) != null) {
        //     output.println(messageFromPlayer);
        // }
    }
}
