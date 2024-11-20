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


public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -240840600533728354L;

    private static Map<Integer, ClientHandler> clients = new HashMap<>();
    private static int idCount = 1;

    private static final int PORT = 13795;

    private static Player player;
    private static boolean da = true;

    private static boolean dashing = true;

    public static String databaseStatement;

    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static final int WIDTH = (int) screenSize.getWidth(), HEIGHT = (int) screenSize.getHeight();
    private Thread thread;
    public static Handler handler;

    public static boolean PlayerMode2 = false;

    private Random r;
    private HUD hud;
    private Spawn spawner;

    private demoHUD demohud;
    private Menu menu;
    private Shop shop;
    private boolean running = false;
    public static boolean paused = false;

    public int diff = 0;

    public enum STATE {
        Menu,
        Intro,
        Help,
        Options,
        Credits,
        End,
        Shop,
        Select,
        Game,
        Profile
    };

    public static STATE gameState = STATE.Intro;

    public Game() {
        handler = new Handler();
        hud = new HUD();
        da = true;
        demohud = new demoHUD();
        shop = new Shop(handler, hud);
        menu = new Menu(this, handler, hud);
        this.addKeyListener(new KeyInput(handler, this));
        this.addMouseListener(menu);
        this.addMouseListener(shop);
        new Window(WIDTH, HEIGHT, "QBism Testing 2", this);

        spawner = new Spawn(handler, hud, this);

        r = new Random();
        if (gameState == STATE.Game) {
            handler.addObject(new Player1(WIDTH / 2, HEIGHT / 2, ID.Player1, handler));
            handler.addObject(new BasicEnemy(r.nextInt(WIDTH / 2) + 50, r.nextInt(HEIGHT / 2) + 50, ID.BasicEnemy, handler));
        } else {
            for (int i = 0; i < 45; i++) {
                handler.addObject(new MenuParticle(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.MenuParticle, handler));
            }
        }
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            HUD.scheduler.shutdown();
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        if (gameState == STATE.Game) {
            if (PlayerMode2) {
                if (da) {
                    da = false;
                    handler.addObject(new Player2(WIDTH / 2, HEIGHT / 2, ID.Player2, handler));
                }
            }
            if(!paused) {
                handler.tick();
                hud.tick();
                spawner.tick();
                if (hud.HEALTH <= 0 || hud.P2HEALTH <= 0) {
                    da = true;
                    hud.HEALTH = 100;
                    hud.P2HEALTH = 100;
//                    hud.revivePrompt = true;
                    gameState = STATE.End;
                    handler.clearEnemies();
                    for (int i = 0; i < 30; i++) {
                        handler.addObject(new MenuParticle(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.MenuParticle, handler));
                    }
                }
            }
        } else if (gameState == STATE.Menu || gameState == STATE.Select || gameState == STATE.Help || gameState == STATE.Profile || gameState == STATE.Options || gameState == STATE.Credits) {
            handler.tick();
            menu.tick();
            hud.p1points = 0;
            hud.p2points = 0;
            hud.score = 0;
            Spawn.scoreKeep = 0;
            hud.scoreKeep = 0;
        } else if (gameState == STATE.End) {
            handler.tick();
            menu.tick();
        } else if (gameState == STATE.Shop) {
            paused = false;
        } else if (gameState == STATE.Intro) {
            demohud.tick();
            handler.tick();
            menu.tick();
            hud.p1points = 0;
            hud.p2points = 0;
            hud.score = 0;
            Spawn.scoreKeep = 0;
            hud.scoreKeep = 0;
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        if (paused) {
            g.setFont(new Font("arial", 1, Game.WIDTH / 35));
            g.setColor(Color.WHITE);
            g.drawString("PAUSED", WIDTH / 2 - (WIDTH / 17), HEIGHT / 2 - (HEIGHT / 30));
        }

        if (gameState == STATE.Game) {
            handler.render(g);
            hud.render(g);
            hud.show321();
        } else if (gameState == STATE.Shop) {
            shop.render(g);
        } else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select || gameState == STATE.Profile || gameState == STATE.Options || gameState == STATE.Credits) {
            handler.render(g);
            menu.render(g);
        } else if (gameState == STATE.Intro) {
            menu.render(g);
            if (demohud.renderThis) demohud.render(g);
            else handler.render(g);
        }

        g.dispose();
        bs.show();
    }

    public static float clamp(float var, float min, float max) {
        if (var >= max) return var = max;
        else if (var <= min) return var = min;
        else return var;
    }

    public static void play(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            player = new Player(fileInputStream);
            player.play();
        } catch (IOException | JavaLayerException e) {
            e.printStackTrace();
        }
    }

    private static Connection findConnection(String databaseUser, String databasePassword, String databaseUrl) throws SQLException {
        return DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
    }

    public static void main(String[] args) throws IOException {
        new Game();
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
        while (true) {
            play("sounds/music.mp3");
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
