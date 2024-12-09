import java.awt.*;
import java.awt.image.BufferStrategy;
import java.sql.*;
import java.util.Random;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.*;
import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;
import org.postgresql.util.PSQLException;


public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -240840600533728354L;

    private static Player player;

    static Teleport teleport;

    private static boolean da = true;

    private static boolean da2 = true;

    private static boolean da3 = true;

    private static boolean da5 = true;

    public static MusicPlayer playerOfDamage = new MusicPlayer("sounds/hurt.wav");

    public static MusicPlayer playerOfOver = new MusicPlayer("sounds/gameOver.wav");

    private static boolean da4 = true;

    public static boolean squadronMode = false;

    public static int map = 0;

    public static boolean normalWon = false;

    public static boolean hardWon = false;

    public static boolean p2normalWon = false;

    public static boolean p2hardWon = false;

    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static final int WIDTH = (int) screenSize.getWidth(), HEIGHT = (int) screenSize.getHeight();
    private Thread thread;
    public static Handler handler;

    public static boolean PlayerMode2 = false;

    public static boolean Mode1v1 = false;

    public static boolean Mode2v2 = false;

    public static boolean Mode3v3 = false;


    static Client client;


    static DataSource dataSource = createDataSource();
    static Connection conn;

    static {
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Random r;
    public static HUD hud;
    private Spawn spawner;

    private demoHUD demohud;
    private Menu menu;
    private Shop shop;
    private boolean running = false;
    public static boolean paused = false;

    public static int diff = 0;

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
        Profile,
        Rank,
        Online,
        Choosing,
        Map,
        ChooseHard,
        Finished;
    };

    public static STATE gameState = STATE.Intro;

    public Game() throws SQLException {
        handler = new Handler();
        hud = new HUD();
        da = true;
        demohud = new demoHUD();
        shop = new Shop(handler, hud);
        menu = new Menu(this, handler, hud);
        this.addKeyListener(new KeyInput(handler, this));
        this.addMouseListener(menu);
        this.addMouseListener(shop);
        new Window(WIDTH, HEIGHT, "QBism Testing 3", this);

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
                try {
                    tick();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                delta--;
            }
            if (running) {
                try {
                    render();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    private void tick() throws SQLException {
        if (Menu.XP == 10) dbSet(conn, "UPDATE stats SET level = " + Menu.playerLevel + 1 + " WHERE userName = " + Menu.playerName);
        if (gameState == STATE.Game) {
            if (map == 1) {
                if (da2) {
                    da2 = false;
                    handler.addObject(new Wall(Game.WIDTH / 3, Game.HEIGHT / 2 - (Game.HEIGHT / 4), Game.WIDTH / 3, Game.HEIGHT / 15, ID.Wall, handler));
                }
            }
            if (map == 2) {
                if (da3) {
                    da3 = false;
                    handler.addObject(new Thorn(Game.WIDTH / 15, HEIGHT - 100, ID.Thorn, "straight forward", handler));
                    handler.addObject(new Thorn(Game.WIDTH / 15 + 55, HEIGHT - 100, ID.Thorn, "straight forward", handler));
                    handler.addObject(new Thorn(Game.WIDTH / 15 + 55 + 55, HEIGHT - 100, ID.Thorn, "straight forward", handler));
                    handler.addObject(new Thorn(Game.WIDTH / 15 + 60 + 60 + 60, HEIGHT - 100, ID.Thorn, "straight forward", handler));
                }
            }
            if (map == 3) {
                if (da4) {
                    da4 = false;
                    handler.addObject(new Thorn(0, 60, ID.Thorn, "right", handler));
                    handler.addObject(new Thorn(70, 0, ID.Thorn, "backward", handler));

                    handler.addObject(new Wall(Game.WIDTH / 2 - (Game.WIDTH / 15), Game.HEIGHT - (Game.HEIGHT / 5), Game.WIDTH / 25, Game.HEIGHT / 5, ID.Wall, handler));
                    handler.addObject(new Thorn(Game.WIDTH / 2 - (Game.WIDTH / 16), Game.HEIGHT - (Game.HEIGHT / 5) - 70, ID.Thorn, "straight forward", handler));

                    handler.addObject(new Wall(Game.WIDTH - (Game.WIDTH / 6), Game.HEIGHT / 3, Game.WIDTH / 6, Game.HEIGHT / 13, ID.Wall, handler));
                }
            }
            if (map == 4) {
                if (da5) {
                    da5 = false;
                    handler.addObject(new Wall(0, Game.HEIGHT - (Game.HEIGHT / 3), Game.WIDTH / 4, Game.HEIGHT / 15, ID.Wall, handler));
                    handler.addObject(new Thorn(Game.WIDTH / 4 - 180, Game.HEIGHT - (Game.HEIGHT / 3) - 70, ID.Thorn, "straight forward", handler));
                    handler.addObject(new Thorn(Game.WIDTH / 4 - 120, Game.HEIGHT - (Game.HEIGHT / 3) - 70, ID.Thorn, "straight forward", handler));
                    handler.addObject(new Thorn(Game.WIDTH / 4 - 60, Game.HEIGHT - (Game.HEIGHT / 3) - 70, ID.Thorn, "straight forward", handler));

                    handler.addObject(new Wall(Game.WIDTH / 2 + (Game.WIDTH / 25), Game.HEIGHT - Game.HEIGHT / 3, Game.WIDTH / 30, Game.HEIGHT / 3, ID.Wall, handler));
                    handler.addObject(new Thorn(Game.WIDTH / 2 + (Game.WIDTH / 25), Game.HEIGHT - (Game.HEIGHT / 3) - 70, ID.Thorn, "straight forward", handler));

                    handler.addObject(new Wall(Game.WIDTH - (Game.WIDTH / 3), 0, Game.WIDTH / 30, Game.HEIGHT / 3, ID.Wall, handler));
                    handler.addObject(new Thorn(Game.WIDTH - (Game.WIDTH / 3) + Game.WIDTH / 30, Game.HEIGHT / 3 - 250, ID.Thorn, "right", handler));
                    handler.addObject(new Thorn(Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 30), Game.HEIGHT / 3 - 75, ID.Thorn, "right", handler));
                }
            }
            if (KeyInput.t1On || KeyInput.t2On) {
                teleport = new Teleport();
                this.addMouseListener(teleport);
                teleport.tick();
            }
            if (PlayerMode2) {
                if (da) {
                    da = false;
                    handler.addObject(new Player2(WIDTH / 2, HEIGHT / 2, ID.Player2, null, null, handler));
                }
            }
            if(!paused) {
                handler.tick();
                hud.tick();
                spawner.tick();
                if (hud.HEALTH <= 0 || hud.P2HEALTH <= 0) {
                    da = true;
                    if (PlayerMode2) dbSet(conn, "UPDATE stats SET games = " + (Menu.games + 2) + " WHERE userName = " + Menu.playerName);
                    else dbSet(conn, "UPDATE stats SET games = " + (Menu.games + 1) + " WHERE userName = " + Menu.playerName);
                    if (Menu.volume) playerOfOver.playMusic();
                    hud.HEALTH = 100;
                    hud.P2HEALTH = 100;
//                    hud.revivePrompt = true;
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            playerOfOver.stopMusic();
                        }
                    }, 1000);
                    String message = "score : " + HUD.getScore() + " player : " + Menu.playerName;
                    int starter = -1;
                    for (int i = 0; i < message.length(); i++) {
                        if (Character.isDigit(message.charAt(i))) {
                            starter = i;
                            break;
                        }
                    }

                    if (starter != -1) {
                        int ender = starter;
                        while (ender < message.length() && Character.isDigit(message.charAt(ender))) {
                            ender++;
                        }

                        String numberInString = message.substring(starter, ender);

                        int score = Integer.parseInt(numberInString);
                        String name = message.substring(18 + (ender - starter));

                        if (score > Server.bestScore) {
                            Server.bestScore = score;
                            Server.bestName = name;
                        }
                        else if (score > Server.secondBestScore && score < Server.bestScore) {
                            Server.secondBestScore = score;
                            Server.bestName2 = name;
                        }
                        else if (score > Server.thirdBestScore && score < Server.secondBestScore) {
                            Server.thirdBestScore = score;
                            Server.bestName3 = name;
                        }
                        else if (score > Server.fourthBestScore && score < Server.thirdBestScore) {
                            Server.fourthBestScore = score;
                            Server.bestName4 = name;
                        }
                        else if (score > Server.fifthBestScore && score < Server.fourthBestScore) {
                            Server.fifthBestScore = score;
                            Server.bestName5 = name;
                        }
                    }
                    gameState = STATE.End;
                    handler.clearEnemies();
                    for (int i = 0; i < 30; i++) {
                        handler.addObject(new MenuParticle(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.MenuParticle, handler));
                    }
                }
            }
        } else if (gameState == STATE.Menu || gameState == STATE.Select || gameState == STATE.Help || gameState == STATE.Profile || gameState == STATE.Options || gameState == STATE.Credits || gameState == STATE.Rank || gameState == STATE.Online || gameState == STATE.Map || gameState == STATE.ChooseHard) {
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
        } else if (gameState == STATE.Choosing) {
            handler.tick();
            menu.tick();
            hud.p1points = 0;
            hud.p2points = 0;
            hud.score = 0;
            Spawn.scoreKeep = 0;
            hud.scoreKeep = 0;
        }
    }


    private void render() throws SQLException {
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
            if (KeyInput.t1On || KeyInput.t2On) {
                teleport = new Teleport();
                teleport.render(g);
            }
            handler.render(g);
            hud.render(g);
            hud.show321();
        } else if (gameState == STATE.Shop) {
            shop.render(g);
        } else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select || gameState == STATE.Profile || gameState == STATE.Options || gameState == STATE.Credits || gameState == STATE.Rank || gameState == STATE.Online || gameState == STATE.Map || gameState == STATE.ChooseHard) {
            handler.render(g);
            menu.render(g);
        } else if (gameState == STATE.Intro) {
            menu.render(g);
            if (demohud.renderThis) demohud.render(g);
            else handler.render(g);
        } else if (gameState == STATE.Choosing) {
            handler.render(g);
            menu.render(g);
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

    public static boolean isItThere(String name) throws SQLException {
        String message = dbGet(conn, "SELECT userName FROM stats WHERE userName = " + name, "userName");
        return !Objects.equals(message, "not found");
    }

    public static DataSource createDataSource() {
        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(Private.db_url);
        return dataSource;
    }

    public static void dbSet(Connection conn, String databaseStatement) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(databaseStatement);
        statement.execute();
    }

    public static String dbGet(Connection conn, String databaseStatement, String columnToGet) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(databaseStatement);
        ResultSet rs =  statement.executeQuery();
        if (rs.next()) return rs.getString(columnToGet);
        else return "not found";
    }

    public static Array dbGetArray(Connection conn, String databaseStatement, String columnToGet) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(databaseStatement);
        ResultSet rs =  statement.executeQuery();
        if (rs.next()) return rs.getArray(columnToGet);
        else return null;
    }

    public static void main(String[] args) throws SQLException {
        new Game();
        try {
            client = new Client();
            client.connectToServer();
            client.startListening();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        MusicPlayer playerOfGame = new MusicPlayer("sounds/gameMusic.wav");
        MusicPlayer playerOfMenu = new MusicPlayer("sounds/menuMusic.wav");

        while (true) {
            if (!Menu.volume) {
                playerOfMenu.stopMusic();
                playerOfGame.stopMusic();
            } else {
                if (gameState == STATE.Game) {
                    if (playerOfMenu.isPlaying()) {
                        playerOfMenu.stopMusic();
                        playerOfGame.playMusic();
                    } else playerOfGame.playMusic();
                } else {
                    if (playerOfGame.isPlaying()) {
                        playerOfGame.stopMusic();
                        playerOfMenu.playMusic();
                    } else playerOfMenu.playMusic();
                }
            }
        }
    }
}
