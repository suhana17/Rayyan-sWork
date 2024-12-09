import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Random;
import java.util.TimerTask;
import javax.naming.Name;
import javax.swing.*;
import java.util.Timer;

public class Menu extends MouseAdapter {

    Game game;
    Handler handler;
    HUD hud;

    public static boolean showStart = false;

    public static boolean skins = false;

    public static String playerName = "QBer";

    public static int XP = 0;

    public static int games = 0;

    public static int points = 0;

    public static int[] achievements = {};

    private boolean da6 = false;

    public static int totalCubes = 0;

    public static int maxCube = 0;

    public static int playerLevel = 1;

    public static float distance = Player1.distanceY + Player1.distanceX;

    public static boolean trans1Main = false;

    private static boolean trans5Difficulty = false;

    public static boolean trans4Difficulty = false;

    public static boolean trans6Difficulty = false;

    public static boolean trans1Intro = false;

    public static boolean trans2Help = false;

    public static boolean trans3Help = false;

    public static boolean trans4Help = false;

    public static boolean trans5Help = false;

    public static boolean trans2Main = false;

    public static boolean trans3Main = false;

    public static boolean trans1Options = false;

    public static boolean trans2Options = false;

    public static boolean trans3Options = false;

    public static boolean trans1Credits = false;

    public static boolean trans2Profile = false;

    public static boolean trans3Profile = false;

    public static boolean trans4Profile = false;

    public static boolean trans5Profile = false;

    public static boolean trans1Help = false;

    public static boolean trans1End = false;

    public static boolean trans1Difficulty = false;

    public static boolean trans1Online = false;

    public static boolean trans2Online = false;

    public static boolean trans3Online = false;

    public static boolean trans4Online = false;

    public static boolean trans1Choosing = false;

    public static boolean trans1Map = false;

    public static boolean trans2Map = false;

    public static boolean volume = true;

    public static boolean cancelled = false;

    public static boolean locked = false;

    public static String skin = "plain";

    public static boolean chooseNewName = false;

    private boolean squadron = false;

    private boolean normal = false;

    private boolean hard = false;

    public static boolean trans2Difficulty = false;

    public static boolean trans3Difficulty = false;

    public static boolean trans1Profile = false;

    public static boolean trans1Rank = false;

    public static boolean trans1Choose = false;

    public static boolean trans2Choose = false;

    public static boolean trans3Choose = false;

    public static boolean controlsHelp = false;

    public static boolean enemiesHelp = false;

    public static boolean homeHelp = true;

    public static boolean levelsHelp = false;

    public static boolean objectiveHelp = false;

    private final Random r = new Random();

    public Menu(Game game, Handler handler, HUD hud) {
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (mouseOver(mx, my, 30, 15, 125, 45)) {
            if (volume) game.play("sounds/buttonPress.mp3");

            volume = !volume;
        }

        if (game.gameState == Game.STATE.Intro) {
            if (showStart) {
                if (mouseOver(mx, my, Game.WIDTH / 2 - (Game.WIDTH / 8) + (Game.WIDTH / 65), Game.HEIGHT / 2, Game.WIDTH / 5 + (Game.WIDTH / 75), Game.HEIGHT / 10)) {
                    if (volume) game.play("sounds/buttonPress.mp3");
                    trans1Intro = true;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    trans1Intro = false;

                    game.gameState = Game.STATE.Menu;
                }
            }
        }

        if (game.gameState == Game.STATE.Menu) {
            if (mouseOver(mx, my, Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 3), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
//                game.gameState = Game.STATE.Game;
//                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
//                handler.clearEnemies();
//                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH + 55), r.nextInt(Game.HEIGHT + 55), ID.BasicEnemy, handler));
                trans1Main = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans1Main = false;

                game.gameState = Game.STATE.Select;
                return;
            }

            if (mouseOver(mx, my, Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans2Main = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans2Main = false;

                game.gameState = Game.STATE.Options;
                return;
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans3Main = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans3Main = false;

                da6 = true;
                game.gameState = Game.STATE.Profile;
                return;
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                HUD.scheduler.shutdown();
                System.exit(0);
            }
        }

        if (game.gameState == Game.STATE.Online) {
            if (mouseOver(mx, my, Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans1Online = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans1Online = false;

                handler.addObject(new Load(Game.WIDTH - (Game.WIDTH / 3) - 120, Game.HEIGHT / 2, Game.WIDTH - (Game.WIDTH / 3) - 120, Game.WIDTH - (Game.WIDTH / 3) + 120, ID.Load, handler));
                game.gameState = Game.STATE.Choosing;
            }

            if (mouseOver(mx, my, Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans2Online = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans2Online = false;

                JOptionPane.showMessageDialog(null, "2v2 Online coming soon!", "Stay Tuned!", JOptionPane.INFORMATION_MESSAGE);
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans3Online = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans3Online = false;

                JOptionPane.showMessageDialog(null, "3v3 Online coming soon!", "Stay Tuned!", JOptionPane.INFORMATION_MESSAGE);
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans4Online = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans4Online = false;

                game.gameState = Game.STATE.Select;
                return;
            }
        }

        if (game.gameState == Game.STATE.Choosing) {
            if (mouseOver(mx, my, Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans1Choosing = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans1Choosing = false;

                cancelled = true;
                return;
            }
        }

        if (game.gameState == Game.STATE.Credits) {
            if (mouseOver(mx, my, Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans1Credits = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans1Credits = false;

                game.gameState = Game.STATE.Options;
                return;
            }
        }

        if (game.gameState == Game.STATE.Profile) {
            if (mouseOver(mx, my, Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans1Profile = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans1Profile = false;

                game.gameState = Game.STATE.Menu;
            }

            if (mouseOver(mx, my, Game.WIDTH / 3, Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans3Profile = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans3Profile = false;

                new NameEnter();
            }

            if (mouseOver(mx, my, Game.WIDTH / 2 + (Game.WIDTH / 5) - (Game.WIDTH / 125), Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans4Profile = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans4Profile = false;

                if (!Objects.equals(playerName, "QBer")) {
                    JOptionPane.showMessageDialog(null, "Squadron coming soon!", "Stay Tuned!", JOptionPane.INFORMATION_MESSAGE);
                    skins = false;
                    squadron = true;
                } else new NameEnter();
            }

            if (mouseOver(mx, my, Game.WIDTH / 3, Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans5Profile = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans5Profile = false;

                game.gameState = Game.STATE.Rank;
            }

            if (mouseOver(mx, my, Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans2Profile = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans2Profile = false;

                skins = true;
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT / 3, 64, 64)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                if (!Objects.equals(playerName, "QBer")) skin = "plain";
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 5), Game.HEIGHT / 3, 64, 64)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                if (!Objects.equals(playerName, "Qber")) skin = "creeper";
                else new NameEnter();
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 7), Game.HEIGHT / 3, 64, 64)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                if (!Objects.equals(playerName, "QBer")) skin = "zombie";
                else new NameEnter();
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT / 3 + (Game.HEIGHT / 13), 64, 64)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                if (!Objects.equals(playerName, "QBer")) skin = "skeleton";
                else new NameEnter();
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 5), Game.HEIGHT / 3 + (Game.HEIGHT / 13), 64, 64)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                if (!Objects.equals(playerName, "QBer")) skin = "enderman";
                else new NameEnter();
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 7), Game.HEIGHT / 3 + (Game.HEIGHT / 13), 64, 64)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                if (!Objects.equals(playerName, "QBer")) skin = "gift package";
                else new NameEnter();
            }
        }

        if (game.gameState == Game.STATE.Map) {
            if (mouseOver(mx, my, Game.WIDTH / 2 - (Game.WIDTH / 7), Game.HEIGHT / 2 - (Game.HEIGHT / 50), Game.WIDTH / 25, Game.HEIGHT / 35)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                game.map = game.map == 0 ? 4 : game.map - 1;
            }

            if (mouseOver(mx, my, Game.WIDTH / 2 + (Game.WIDTH / 9), Game.HEIGHT / 2 - (Game.HEIGHT / 50), Game.WIDTH / 25, Game.HEIGHT / 35)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                game.map = game.map == 4 ? 0 : game.map + 1;
            }

            if (mouseOver(mx, my, Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans1Map = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans1Map = false;

                game.gameState = Game.STATE.Select;
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans2Map = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans2Map = false;
                if (game.PlayerMode2) {
                    game.gameState = Game.STATE.Game;
                    handler.addObject(new Player2(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player2, null, null, handler));
                    try {
                        handler.addObject(new Player1(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player1, handler));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    handler.clearEnemies();
                    if (normal)
                        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH + 55), r.nextInt(Game.HEIGHT + 55), ID.BasicEnemy, handler));
                    else if (hard)
                        handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH + 55), r.nextInt(Game.HEIGHT + 55), ID.BasicEnemy, handler));

                    game.PlayerMode2 = true;
                    game.Mode1v1 = false;
                    game.Mode2v2 = false;
                    game.Mode3v3 = false;

                    game.diff = normal ? 0 : 1;
                } else {
                    game.gameState = Game.STATE.Game;
                    try {
                        handler.addObject(new Player1(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player1, handler));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    handler.clearEnemies();
                    if (normal)
                        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH + 55), r.nextInt(Game.HEIGHT + 55), ID.BasicEnemy, handler));
                    else if (hard)
                        handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH + 55), r.nextInt(Game.HEIGHT + 55), ID.BasicEnemy, handler));

                    game.PlayerMode2 = false;
                    game.Mode1v1 = false;
                    game.Mode2v2 = false;
                    game.Mode3v3 = false;

                    game.diff = normal ? 0 : 1;
                }
            }
        }

        if (game.gameState == Game.STATE.Rank) {
            if (mouseOver(mx, my, Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 8) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans1Rank = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans1Rank = false;

                game.gameState = Game.STATE.Profile;
            }
        }

        if (game.gameState == Game.STATE.ChooseHard) {
            if (mouseOver(mx, my, Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans1Choose = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans1Choose = false;

                normal = true;
                hard = false;
                game.gameState = Game.STATE.Map;
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans2Choose = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans2Choose = false;

                hard = true;
                normal = false;
                game.gameState = Game.STATE.Map;
            }

            if (mouseOver(mx, my, Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 8) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans3Choose = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans3Choose = false;

                game.gameState = Game.STATE.Select;
            }
        }

        if (game.gameState == Game.STATE.Options) {
            if (mouseOver(mx, my, Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans1Options = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans1Options = false;

                game.gameState = Game.STATE.Credits;
                return;
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans2Options = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans2Options = false;

                game.gameState = Game.STATE.Help;
                return;
            }

            if (mouseOver(mx, my, Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans3Options = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans3Options = false;

                game.gameState = Game.STATE.Menu;
                return;
            }
        }

        if (game.gameState == Game.STATE.Select) {
            if (mouseOver(mx, my, Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans1Difficulty = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans1Difficulty = false;
                if (!Objects.equals(playerName, "QBer")) {
                    game.gameState = Game.STATE.Map;
                    game.PlayerMode2 = false;
                    game.Mode1v1 = false;
                    game.Mode2v2= false;
                    game.Mode3v3 = false;
                    normal = true;
                    hard = false;
                } else new NameEnter();
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans2Difficulty = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans2Difficulty = false;

                if (!Objects.equals(playerName, "QBer")) {
                    game.gameState = Game.STATE.Map;
                    game.PlayerMode2 = false;
                    game.Mode1v1 = false;
                    game.Mode2v2 = false;

                    game.Mode3v3 = false;

                    normal = false;
                    hard = true;
                } else new NameEnter();
            }

            if (mouseOver(mx, my, Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans4Difficulty = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans4Difficulty = false;

                if (!Objects.equals(playerName, "QBer")) {
                    game.gameState = Game.STATE.ChooseHard;
                    game.PlayerMode2 = true;
                    game.Mode1v1 = false;
                    game.Mode2v2 = false;

                    game.Mode3v3 = false;


                } else new NameEnter();
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (Menu.volume) game.play("sounds/buttonPress.mp3");
                trans5Difficulty = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans5Difficulty = false;
                if (!Objects.equals(playerName, "QBer")) {
                    //game.gameState = Game.STATE.ChooseHard;
                    // make hard/normal
                } else new NameEnter();
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (Menu.volume) game.play("sounds/buttonPress.mp3");
                trans6Difficulty = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans6Difficulty = false;

                // make hard/normal
                //game.gameState = Game.STATE.ChooseHard;
                if (!Objects.equals(playerName, "QBer")) {
                    JOptionPane.showMessageDialog(null, "Squadron level coming soon!", "Stay Tuned!", JOptionPane.INFORMATION_MESSAGE);
                    game.PlayerMode2 = false;
                    game.Mode1v1 = false;
                    game.Mode2v2 = false;

                    game.Mode3v3 = false;

                } else new NameEnter();
            }

            if (mouseOver(mx, my, Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans3Difficulty = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans3Difficulty = false;

                game.gameState = Game.STATE.Menu;
            }
        }

        if (game.gameState == Game.STATE.Help) {
            if (homeHelp) {
                if (mouseOver(mx, my, Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                    if (volume) game.play("sounds/buttonPress.mp3");
                    trans1Help = true;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    trans1Help = false;

                    game.gameState = Game.STATE.Options;
                    homeHelp = false;
                    objectiveHelp = false;
                    controlsHelp = false;
                    enemiesHelp = false;
                    levelsHelp = false;
                }

                if (mouseOver(mx, my, Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                    if (volume) game.play("sounds/buttonPress.mp3");
                    trans2Help = true;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    trans2Help = false;

                    homeHelp = false;
                    objectiveHelp = true;
                    controlsHelp = false;
                    enemiesHelp = false;
                    levelsHelp = false;
                }

                if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                    if (volume) game.play("sounds/buttonPress.mp3");
                    trans3Help = true;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    trans3Help = false;

                    homeHelp = false;
                    objectiveHelp = false;
                    controlsHelp = true;
                    enemiesHelp = false;
                    levelsHelp = false;
                }

                if (mouseOver(mx, my, Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                    if (volume) game.play("sounds/buttonPress.mp3");
                    trans4Help = true;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    trans4Help = false;

                    homeHelp = false;
                    objectiveHelp = false;
                    controlsHelp = false;
                    enemiesHelp = true;
                    levelsHelp = false;
                }

                if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                    if (volume) game.play("sounds/buttonPress.mp3");
                    trans5Help = true;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    trans5Help = false;

                    homeHelp = false;
                    objectiveHelp = false;
                    controlsHelp = false;
                    enemiesHelp = false;
                    levelsHelp = true;
                }
            } else {
                if (mouseOver(mx, my, Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                    if (volume) game.play("sounds/buttonPress.mp3");
                    trans1Help = true;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    trans1Help = false;

                    homeHelp = true;
                    objectiveHelp = false;
                    controlsHelp = false;
                    enemiesHelp = false;
                    levelsHelp = false;
                }
            }
        }

        if (game.gameState == Game.STATE.End) {
            if (mouseOver(mx, my, Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                trans1End = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans1End = false;

                game.gameState = Game.STATE.Menu;
                hud.setLevel(1);
                hud.setScore(0);
            }
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            return my > y && my < y + height;
        } else return false;
    }

    public void tick() throws SQLException {
        if (da6) {
            da6 = false;
            XP = Integer.parseInt(game.dbGet(game.conn, "SELECT XP FROM stats WHERE userName = " + playerName, "XP"));
            skin = game.dbGet(game.conn, "SELECT skin FROM stats WHERE userName = " + playerName, "skin");
            achievements = (int[]) game.dbGetArray(game.conn, "SELECT achievements FROM stats WHERE userName = " + playerName, "achievements").getArray();
            games = Integer.parseInt(game.dbGet(game.conn, "SELECT games FROM stats WHERE userName = " + playerName, "games"));
            totalCubes = Integer.parseInt(game.dbGet(game.conn, "SELECT totalCubes FROM stats WHERE userName = " + playerName, "totalCubes"));
            maxCube = Integer.parseInt(game.dbGet(game.conn, "SELECT maxCube FROM stats WHERE userName = " + playerName, "maxCube"));
            distance = Integer.parseInt(game.dbGet(game.conn, "SELECT distance FROM stats WHERE userName = " + playerName, "distance"));
            skin = game.dbGet(game.conn, "SELECT skin FROM stats WHERE userName = " + playerName, "skin");
            playerLevel = Integer.parseInt(game.dbGet(game.conn, "SELECT level FROM stats WHERE userName = " + playerName, "level"));
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                da6 = true;
            }
        }, 5000);
    }

    public void render(Graphics g) throws SQLException {
        Timer timer = new Timer();
        if (chooseNewName) {
            g.setColor(Color.RED);
            g.setFont(new Font("arial", Font.BOLD, Game.WIDTH / 20));
            g.drawString("Choose Another Name", Game.WIDTH / 2 - (Game.WIDTH / 8), Game.HEIGHT / 2);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    chooseNewName = false;
                }
            }, 2000);
        }

        g.setColor(Color.WHITE);
        g.drawLine(30, 30, 30, 45);
        g.drawLine(30, 30, 45, 30);
        g.drawLine(30, 45, 45, 45);
        g.drawLine(45, 30, 60,15);
        g.drawLine(45, 45, 60,60);
        g.drawLine(60, 15, 60,60);
        if (volume) {
            g.drawLine(75, 30, 75,45);
            g.drawLine(75, 30, 65,15);
            g.drawLine(75, 45, 65,60);
        } else {
            g.drawLine(80, 15, 125, 60);
            g.drawLine(80, 15, 125, 60);
            g.drawLine(125, 15, 80, 60);
        }
        if (game.gameState == Game.STATE.Intro && showStart) {
            Font font = new Font("arial", 1, Game.WIDTH / 15);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            g.setColor(Color.WHITE);
            g.setFont(font);

            g.drawString("QBism", Game.WIDTH / 2 - (Game.WIDTH / 8) + (Game.WIDTH / 65), Game.HEIGHT / 3);

            g.setFont(font2);
            g.drawString("By: Rayyan Zahid Anwar", Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 2 - (Game.HEIGHT / 25));

            g.setFont(new Font("arial", 1, Game.WIDTH / 45));
            g.drawString("Coming Soon: ", Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 2 + (Game.HEIGHT / 6));
            g.drawString("Chat", Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 2 + (Game.HEIGHT / 4));
            g.drawString("Squadron", Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 2 + (Game.HEIGHT / 3));
            g.drawString("Online level", Game.WIDTH / 2 + (Game.WIDTH / 12), Game.HEIGHT / 2 + (Game.HEIGHT / 4));

            g.setFont(font2);
            if (trans1Intro) {
                g.fillRect(Game.WIDTH / 2 - (Game.WIDTH / 8) + (Game.WIDTH / 65), Game.HEIGHT / 2, Game.WIDTH / 5 + (Game.WIDTH / 75), Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Start", Game.WIDTH / 2 - (Game.WIDTH / 8) + (Game.WIDTH / 65) + (Game.WIDTH / 14), Game.HEIGHT / 2 + (Game.HEIGHT / 15));
        }
        if (game.gameState == Game.STATE.Menu) {
            Font font = new Font("arial", 1, Game.WIDTH / 25);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            g.setFont(font);

            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawString("QBism", Game.WIDTH / 2 - (Game.WIDTH / 15), Game.HEIGHT / 15);
            g.setColor(Color.WHITE);

            g.setFont(font2);
            if (trans1Main) {
                g.fillRect(Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Play", Game.WIDTH / 4 - (Game.WIDTH / 30), Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 60));
            g.setColor(Color.WHITE);
            if (trans2Main) {
                g.fillRect(Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Options", Game.WIDTH / 4 - (Game.WIDTH / 17), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));

            g.setColor(Color.WHITE);
            if (trans3Main) {
                g.fillRect(Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Profile", Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 20), Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 60));
            g.setColor(Color.WHITE);
            g.drawString("Quit", Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 30), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));
        } else if (game.gameState == Game.STATE.Online) {
            Font font = new Font("arial", 1, Game.WIDTH / 25);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            Font font3 = new Font("arial", 1, Game.WIDTH / 45);

            g.setFont(font);
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawString("Online", Game.WIDTH / 2 - (Game.WIDTH / 13), Game.HEIGHT / 15);

            g.setColor(Color.WHITE);
            g.setFont(font2);
            if (trans1Online) {
                g.fillRect(Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("1v1", Game.WIDTH / 4 - (Game.WIDTH / 32), Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 60));
            g.setColor(Color.WHITE);
            if (trans2Online) {
                g.fillRect(Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("2v2", Game.WIDTH / 4 - (Game.WIDTH / 32), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));

            g.setColor(Color.WHITE);
            if (trans3Online) {
                g.fillRect(Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("3v3", Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 32), Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 60));
            g.setColor(Color.WHITE);
            if (trans4Online) {
                g.fillRect(Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Back", Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 30), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));
        } else if (game.gameState == Game.STATE.Choosing) {
            Font font = new Font("arial", 1, Game.WIDTH / 25);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            Font font3 = new Font("arial", 1, Game.WIDTH / 45);
            g.setFont(font);

            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawString("Matchmaking", Game.WIDTH / 2 - (Game.WIDTH / 7), Game.HEIGHT / 15);

            g.setColor(Color.WHITE);
            g.setFont(font3);

            g.drawString(playerName, Game.WIDTH / 3, Game.HEIGHT / 3);


            g.setFont(font2);
            g.setColor(Color.WHITE);

            g.drawString("vs", Game.WIDTH / 2 - (Game.WIDTH / 105), Game.HEIGHT / 2);

            if (cancelled) {
                g.drawString( "Cancelled.", Game.WIDTH - (Game.WIDTH / 3), Game.HEIGHT / 2);
                Timer timer1 = new Timer();
                timer1.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        cancelled = false;
                        timer.cancel();
                        game.gameState = Game.STATE.Online;
                    }
                }, 3000);
            }

            g.setColor(Color.RED);

            if (trans1Choosing) {
                g.fillRect(Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Cancel", Game.WIDTH / 6 - (Game.WIDTH / 22), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));
        } else if (game.gameState == Game.STATE.Map) {
            Font font = new Font("arial", 1, Game.WIDTH / 25);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            g.setFont(font);

            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawString("Map", Game.WIDTH / 2 - (Game.WIDTH / 17), Game.HEIGHT / 15);
            g.setColor(Color.WHITE);

            g.setFont(font2);
            g.drawString("Map " + (Game.map + 1), Game.WIDTH / 2 - (Game.WIDTH / 25), Game.HEIGHT / 2);

            g.drawString("←", Game.WIDTH / 2 - (Game.WIDTH / 8), Game.HEIGHT / 2);
            g.drawString("→", Game.WIDTH / 2 + (Game.WIDTH / 9), Game.HEIGHT / 2);

            if (trans1Map) {
                g.fillRect(Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Back", Game.WIDTH / 6 - (Game.WIDTH / 30), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));

            g.setColor(Color.WHITE);

            if (trans2Map) {
                g.fillRect(Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Go", Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 50), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));
        } else if (game.gameState == Game.STATE.Help) {
            Font font = new Font("arial", 1, Game.WIDTH / 25);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            Font font3 = new Font("arial", 1, Game.WIDTH / 45);
            g.setFont(font);

            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawString("Help", Game.WIDTH / 2 - (Game.WIDTH / 17), Game.HEIGHT / 15);
            g.setColor(Color.WHITE);

            if (controlsHelp) {
                g.setColor(Color.WHITE);
                g.setFont(font3);

                g.drawString("App: ",  Game.WIDTH / 2 - (Game.WIDTH / 3), Game.HEIGHT / 4);
                g.drawString("Laptop: ", Game.WIDTH - (Game.WIDTH / 3), Game.HEIGHT / 4);
                g.drawString("Use joy stick to move", Game.WIDTH / 25, Game.HEIGHT / 4 + (Game.HEIGHT / 15));
                g.drawString("Use arrow keys to move", Game.WIDTH - (Game.WIDTH / 3) - (Game.WIDTH / 8), Game.HEIGHT / 4 + (Game.HEIGHT / 15));
                g.drawString("Press 'p' to pause", Game.WIDTH - (Game.WIDTH / 3) - (Game.WIDTH / 8), Game.HEIGHT / 4 + (Game.HEIGHT / 7));
                g.drawString("Press buttons to enter shop and pause", Game.WIDTH / 25, Game.HEIGHT / 4 + (Game.HEIGHT / 7));
                g.drawString("Press 'space' to enter shop", Game.WIDTH - (Game.WIDTH / 3) - (Game.WIDTH / 8), Game.HEIGHT / 4 + (Game.HEIGHT / 3));
                g.drawString("Press 'ESC' to exit game", Game.WIDTH - (Game.WIDTH / 3) - (Game.WIDTH / 8), Game.HEIGHT / 2);
                g.drawString("Click to use power-ups", Game.WIDTH / 25, Game.HEIGHT / 2);
                g.drawString("Press 'SHIFT + arrow' to use bullets", Game.WIDTH - (Game.WIDTH / 3) - (Game.WIDTH / 8), Game.HEIGHT / 2 + (Game.HEIGHT / 6));
                g.drawString("Press '1', '2', and '3' to use power-ups", Game.WIDTH - (Game.WIDTH / 3) - (Game.WIDTH / 8), Game.HEIGHT / 2 + (Game.HEIGHT / 4));
                g.drawString("Press 'Button + joy stick' to use bullets", Game.WIDTH / 25, Game.HEIGHT / 4 + (Game.HEIGHT / 3));
            }    

            if (enemiesHelp) {
                g.setColor(Color.WHITE);
                g.setFont(font2);

                g.drawString("BasicEnemy: ", Game.WIDTH / 4, Game.HEIGHT / 3);
                g.setFont(font3);
                g.drawString("The BasicEnemy bounces off walls.", Game.WIDTH / 6, Game.HEIGHT / 3 + (Game.HEIGHT / 25));

                g.setFont(font2);
                g.drawString("FastEnemy: ", Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT / 3);
                g.setFont(font3);
                g.drawString("The FastEnemy bounces off", Game.WIDTH - (Game.WIDTH / 3), Game.HEIGHT / 3 + (Game.HEIGHT / 25));
                g.drawString("walls  faster than BasicEnemy.", Game.WIDTH - (Game.WIDTH / 3), Game.HEIGHT / 3 + (Game.HEIGHT / 25) + (Game.HEIGHT / 25));

                g.setFont(font2);
                g.drawString("HardEnemy: ", Game.WIDTH / 4, Game.HEIGHT - (Game.HEIGHT / 3));
                g.setFont(font3);
                g.drawString("The HardEnemy changes speed every", Game.WIDTH / 6, Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 25));
                g.drawString("time it bounces.", Game.WIDTH / 6, Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 25) + (Game.HEIGHT / 25));

                g.setFont(font2);
                g.drawString("SmartEnemy: ", Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT - (Game.HEIGHT / 3));
                g.setFont(font3);
                g.drawString("The SmartEnemy follows you.", Game.WIDTH - (Game.WIDTH / 3), Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 25));
            }

            if (levelsHelp) {
                g.setColor(Color.WHITE);
                g.setFont(font2);

                g.drawString("Normal/Hard: ", Game.WIDTH / 4, Game.HEIGHT / 3);
                g.setFont(font3);
                g.drawString("Normal and hard are difficulties.", Game.WIDTH / 6, Game.HEIGHT / 3 + (Game.HEIGHT / 25));
                g.drawString("Hard is simply harder than normal.", Game.WIDTH / 6, Game.HEIGHT / 3 + (Game.HEIGHT / 25) + (Game.HEIGHT / 25));

                g.setFont(font2);
                g.drawString("2-player", Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT / 3);
                g.setFont(font3);
                g.drawString("2-player mode is simply 2", Game.WIDTH - (Game.WIDTH / 3), Game.HEIGHT / 3 + (Game.HEIGHT / 25));
                g.drawString("players on the same PC.", Game.WIDTH - (Game.WIDTH / 3), Game.HEIGHT / 3 + (Game.HEIGHT / 25) + (Game.HEIGHT / 25));

                g.setFont(font2);
                g.drawString("Squadron", Game.WIDTH / 4, Game.HEIGHT - (Game.HEIGHT / 3));
                g.setFont(font3);
                g.drawString("Squadron mode lets you", Game.WIDTH / 6, Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 25));
                g.drawString("compete with your squadron.", Game.WIDTH / 6, Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 25) + (Game.HEIGHT / 25));

                g.setFont(font2);
                g.drawString("Online", Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT - (Game.HEIGHT / 3));
                g.setFont(font3);
                g.drawString("Online mode randomly pairs", Game.WIDTH - (Game.WIDTH / 3), Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 25));
                g.drawString("you with other people.", Game.WIDTH - (Game.WIDTH / 3), Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 25) + (Game.HEIGHT / 25));
            }

            if (objectiveHelp) {
                g.setColor(Color.WHITE);
                g.setFont(font3);
                g.drawString("Objective: ", Game.WIDTH / 2 - (Game.WIDTH / 15), Game.HEIGHT / 2 - (Game.HEIGHT / 6) + (Game.HEIGHT / 6));
                g.drawString("Survive as long as possible", Game.WIDTH / 2 - (Game.WIDTH / 7), Game.HEIGHT / 2 - (Game.HEIGHT / 6) + (Game.HEIGHT / 5));
                g.drawString("If there is any problem, simply restart the game.", Game.WIDTH / 4, Game.HEIGHT / 2 - (Game.HEIGHT / 6) + (Game.HEIGHT / 4));
            }

            g.setFont(font2);
            if (homeHelp) {
                if (trans2Help) {
                    g.fillRect(Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                    g.setColor(Color.BLACK);
                }
                g.drawString("Objective", Game.WIDTH / 4 - (Game.WIDTH / 16), Game.HEIGHT / 5 + (Game.HEIGHT / 60));
                g.setColor(Color.WHITE);

                if (trans3Help) {
                    g.fillRect(Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                    g.setColor(Color.BLACK);
                }
                g.drawString("Controls", Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 17), Game.HEIGHT / 5 + (Game.HEIGHT / 60));
                g.setColor(Color.WHITE);

                if (trans4Help) {
                    g.fillRect(Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                    g.setColor(Color.BLACK);
                }
                g.drawString("Enemies", Game.WIDTH / 4 - (Game.WIDTH / 20), Game.HEIGHT / 2 + (Game.HEIGHT / 60));
                g.setColor(Color.WHITE);

                if (trans5Help) {
                    g.fillRect(Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                    g.setColor(Color.BLACK);
                }
                g.drawString("Level", Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 28), Game.HEIGHT / 2 + (Game.HEIGHT / 60));
                g.setColor(Color.WHITE);
            }
        
            if (trans1Help) {
                g.fillRect(Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Back", Game.WIDTH / 6 - (Game.WIDTH / 30), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));
        } else if (game.gameState == Game.STATE.Profile) {
            skins = true;

            Font font = new Font("arial", 1, Game.WIDTH / 25);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            Font font3 = new Font("arial", 1, Game.WIDTH / 45);
            g.setFont(font);

            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawString("Profile", Game.WIDTH / 2 - (Game.WIDTH / 13), Game.HEIGHT / 15);
            g.setColor(Color.WHITE);

            // 3 Buttons side-by-side on top, below, left side changing, right side description
            // rectangle with changing and description
            g.drawRect(Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT / 5 - (Game.HEIGHT / 20) + (Game.HEIGHT / 10) + 5, Game.WIDTH - (Game.WIDTH / 10), Game.HEIGHT / 2 + 25);

            // Buttons

            g.setFont(font2);
            if (trans2Profile) {
                g.fillRect(Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Skins", Game.WIDTH / 6 - (Game.WIDTH / 28), Game.HEIGHT / 5 + (Game.HEIGHT / 60));

            g.setColor(Color.WHITE);

            if (trans3Profile) {
                g.fillRect(Game.WIDTH / 3, Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Change Name", Game.WIDTH / 3 + (Game.WIDTH / 30), Game.HEIGHT / 5 + (Game.HEIGHT / 60));

            g.setColor(Color.WHITE);

            if (trans4Profile) {
                g.fillRect(Game.WIDTH / 2 + (Game.WIDTH / 5) - (Game.WIDTH / 125), Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Squadron", Game.WIDTH / 2 + (Game.WIDTH / 5) - (Game.WIDTH / 125) + (Game.WIDTH / 17), Game.HEIGHT / 5 + (Game.HEIGHT / 60));

            g.setColor(Color.WHITE);

            g.drawString(playerName, Game.WIDTH / 15, Game.HEIGHT / 3);
            switch (skin) {
                case "plain":
                    g.setColor(Color.WHITE);
                    g.fillRect(Game.WIDTH / 15, Game.HEIGHT / 3 + (Game.HEIGHT / 50), Game.WIDTH / 6, Game.WIDTH / 6);
                    break;
                case "creeper":
                    g.setColor(Color.GREEN);
                    g.fillRect(Game.WIDTH / 15, Game.HEIGHT / 3 + (Game.HEIGHT / 50), Game.WIDTH / 6, Game.WIDTH / 6);
                    g.setColor(Color.BLACK);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 36), Game.HEIGHT / 3 + (Game.HEIGHT / 50) + (Game.HEIGHT / 30), Game.WIDTH / 23, Game.WIDTH / 23);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 10), Game.HEIGHT / 3 + (Game.HEIGHT / 50) + (Game.HEIGHT / 30), Game.WIDTH / 23, Game.WIDTH / 23);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 50) + (Game.WIDTH / 20), Game.HEIGHT / 3 + (Game.HEIGHT / 45) + (Game.HEIGHT / 30) + Game.WIDTH / 25, Game.WIDTH / 32, Game.HEIGHT / 9);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 20), Game.HEIGHT / 2 - (Game.HEIGHT / 100), Game.WIDTH / 50, Game.HEIGHT / 9);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 10), Game.HEIGHT / 2 - (Game.HEIGHT / 100), Game.WIDTH / 50, Game.HEIGHT / 9);
                    break;
                case "zombie":
                    g.setColor(new Color(5, 97, 2));
                    g.fillRect(Game.WIDTH / 15, Game.HEIGHT / 3 + (Game.HEIGHT / 50), Game.WIDTH / 6, Game.WIDTH / 6);
                    g.setColor(new Color(2, 153, 75));
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 36), Game.HEIGHT / 3 + (Game.HEIGHT / 50) + (Game.HEIGHT / 20), Game.WIDTH / 10, Game.HEIGHT / 7);
                    g.fillRect(Game.WIDTH / 15, Game.HEIGHT / 3 + (Game.HEIGHT / 25), Game.WIDTH / 75, Game.HEIGHT / 25);
                    g.fillRect(Game.WIDTH / 15, Game.HEIGHT / 2, Game.WIDTH / 75, Game.HEIGHT / 25);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 18), Game.HEIGHT / 3 + (Game.HEIGHT / 50) + (Game.HEIGHT / 5), Game.WIDTH / 35, Game.HEIGHT / 55);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 13), Game.HEIGHT / 3 + (Game.HEIGHT / 50) + (Game.HEIGHT / 5), Game.WIDTH / 75, Game.HEIGHT / 25);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 7), Game.HEIGHT / 3 + (Game.HEIGHT / 50) + (Game.HEIGHT / 5), Game.WIDTH / 75, Game.HEIGHT / 25);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 7), Game.HEIGHT / 3 + (Game.HEIGHT / 50) + (Game.HEIGHT / 10), Game.WIDTH / 75, Game.HEIGHT / 25);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 16), Game.HEIGHT / 3 + (Game.HEIGHT / 50) + (Game.HEIGHT / 50), Game.WIDTH / 35, Game.HEIGHT / 55);
                    g.setColor(Color.BLACK);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 35), Game.HEIGHT / 3 + (Game.HEIGHT / 50) + (Game.HEIGHT / 8), Game.WIDTH / 30, Game.HEIGHT / 45);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 10), Game.HEIGHT / 3 + (Game.HEIGHT / 50) + (Game.HEIGHT / 8), Game.WIDTH / 30, Game.HEIGHT / 45);
                    break;
                case "skeleton":
                    g.setColor(new Color(135, 135, 135));
                    g.fillRect(Game.WIDTH / 15, Game.HEIGHT / 3 + (Game.HEIGHT / 50), Game.WIDTH / 6, Game.WIDTH / 6);
                    g.setColor(Color.BLACK);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 35), Game.HEIGHT / 3 + (Game.HEIGHT / 8), Game.WIDTH / 30, Game.HEIGHT / 45);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 10), Game.HEIGHT / 3 + (Game.HEIGHT / 8), Game.WIDTH / 30, Game.HEIGHT / 45);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 35), Game.HEIGHT / 3 + (Game.HEIGHT / 5), Game.WIDTH / 19 + (Game.WIDTH / 19), Game.HEIGHT / 45);
                    break;
                case "enderman":
                    g.setColor(new Color(36, 36, 36));
                    g.fillRect(Game.WIDTH / 15, Game.HEIGHT / 3 + (Game.HEIGHT / 50), Game.WIDTH / 6, Game.WIDTH / 6);
                    g.setColor(new Color(232, 3, 252));
                    g.fillRect(Game.WIDTH / 15, Game.HEIGHT / 3 + (Game.HEIGHT / 50) + (Game.HEIGHT / 10), Game.WIDTH / 18, Game.HEIGHT / 45);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 9), Game.HEIGHT / 3 + (Game.HEIGHT / 50) + (Game.HEIGHT / 10), Game.WIDTH / 18, Game.HEIGHT / 45);
                    break;
                case "gift package":
                    g.setColor(Color.GREEN);
                    g.fillRect(Game.WIDTH / 15, Game.HEIGHT / 3 + (Game.WIDTH / 15), Game.WIDTH / 6, Game.WIDTH / 6);
                    g.setColor(Color.RED);
                    g.fillRect(Game.WIDTH / 15 + (Game.WIDTH / 15), Game.HEIGHT / 3 + (Game.HEIGHT / 10), Game.WIDTH / 33, Game.WIDTH / 6);
                    g.fillOval(Game.WIDTH / 15 + (Game.WIDTH / 15), Game.HEIGHT / 3 + (Game.HEIGHT / 15), Game.WIDTH / 33, Game.WIDTH / 33);
                    g.fillOval(Game.WIDTH / 15 + (Game.WIDTH / 50), Game.HEIGHT / 3 + (Game.HEIGHT / 22), Game.WIDTH / 15, Game.HEIGHT / 15);
                    g.fillOval(Game.WIDTH / 15 + (Game.WIDTH / 13), Game.HEIGHT / 3 + (Game.HEIGHT / 22), Game.WIDTH / 15, Game.HEIGHT / 15);
                    break;
            }

            g.setColor(Color.WHITE);

            //plain
            g.fillRect(Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT / 3, 64, 64);
            //creeper
            g.setColor(Color.GREEN);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 5), Game.HEIGHT / 3, 64, 64);
            g.setColor(Color.BLACK);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 5) + 8, Game.HEIGHT / 3 + 8, 18, 18);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 5) + 38, Game.HEIGHT / 3 + 8, 18, 18);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 5) + 26, Game.HEIGHT / 3 + 24, 12, 28);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 5) + 16, Game.HEIGHT / 3 + 32, 10, 28);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 5) + 38, Game.HEIGHT / 3 + 32, 10, 28);
            //zombie
            g.setColor(new Color(5, 97, 2));
            g.fillRect(Game.WIDTH - (Game.WIDTH / 7), Game.HEIGHT / 3, 64, 64);
            g.setColor(new Color(2, 153, 75));
            g.fillRect(Game.WIDTH - (Game.WIDTH / 7) + 8, Game.HEIGHT / 3 + 16, 40, 32);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 7) + 32, Game.HEIGHT / 3 + 56, 16, 8);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 7) + 8, Game.HEIGHT / 3, 16, 8);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 7) + 56, Game.HEIGHT / 3 + 16, 8, 8);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 7), Game.HEIGHT / 3 + 32, 8, 8);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 7) + 8, Game.HEIGHT / 3 + 56, 8, 8);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 7) + 48, Game.HEIGHT / 3, 8, 8);
            g.setColor(Color.BLACK);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 7) + 8, Game.HEIGHT / 3 + 28, 16, 8);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 7) + 40, Game.HEIGHT / 3 + 28, 16, 8);
            g.setColor(new Color(5, 97, 2));
            g.fillRect(Game.WIDTH - (Game.WIDTH / 7) + 24, Game.HEIGHT / 3 + 36, 16, 8);
            //skeleton
            g.setColor(new Color(135, 135, 135));
            g.fillRect(Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT / 3 + (Game.HEIGHT / 13), 64, 64);
            g.setColor(Color.BLACK);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 4) + 8, Game.HEIGHT / 3 + (Game.HEIGHT / 13) + 32, 16, 8);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 4) + 40, Game.HEIGHT / 3 + (Game.HEIGHT / 13) + 32, 16, 8);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 4) + 8, Game.HEIGHT / 3 + (Game.HEIGHT / 13) + 48, 48, 8);
            //enderman
            g.setColor(new Color(36, 36, 36));
            g.fillRect(Game.WIDTH - (Game.WIDTH / 5), Game.HEIGHT / 3 + (Game.HEIGHT / 13), 64, 64);
            g.setColor(new Color(232, 3, 252));
            g.fillRect(Game.WIDTH - (Game.WIDTH / 5), Game.HEIGHT / 3 + (Game.HEIGHT / 13) + 32, 24, 8);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 5) + 40, Game.HEIGHT / 3 + (Game.HEIGHT / 13) + 32, 24, 8);
            //gift package
            g.setColor(Color.GREEN);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 7), Game.HEIGHT / 3 + (Game.HEIGHT / 13), 64, 64);
            g.setColor(Color.RED);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 7) + 28, Game.HEIGHT / 3 + (Game.HEIGHT / 13), 12, 64);
            g.fillOval(Game.WIDTH - (Game.WIDTH / 7) + 8, Game.HEIGHT / 3 + (Game.HEIGHT / 13) - 16, 24, 16);
            g.fillOval(Game.WIDTH - (Game.WIDTH / 7) + 36, Game.HEIGHT / 3 + (Game.HEIGHT / 13) - 16, 24, 16);
            g.fillOval(Game.WIDTH - (Game.WIDTH / 7) + 28, Game.HEIGHT / 3 + (Game.HEIGHT / 13) - 8, 12, 12);

            g.setColor(Color.WHITE);

            g.setFont(font3);
            g.drawString("XP: " + XP, Game.WIDTH / 3, Game.HEIGHT / 3);
            g.drawString("Total games: " + games, Game.WIDTH / 3 + (Game.WIDTH / 10), Game.HEIGHT / 3);
            g.drawString("Points made: " + points, Game.WIDTH / 3, Game.HEIGHT / 3 + (Game.HEIGHT / 25));
            g.drawString("Total Cubes: " + totalCubes, Game.WIDTH / 3 + (Game.WIDTH / 5), Game.HEIGHT / 3 + (Game.HEIGHT / 25));
            g.drawString("Max Cube: " + maxCube, Game.WIDTH / 3, Game.HEIGHT / 3 + (Game.HEIGHT / 25) + (Game.HEIGHT / 25));
            g.drawString("Distance: " + distance, Game.WIDTH / 3 + (Game.WIDTH / 6), Game.HEIGHT / 3 + (Game.HEIGHT / 25) + (Game.HEIGHT / 25));


            if (trans5Profile) {
                g.fillRect(Game.WIDTH / 3, Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Rank", Game.WIDTH / 3 + (Game.HEIGHT / 6), Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 60));

            g.setColor(Color.WHITE);

            g.setFont(font2);
            if (trans1Profile) {
                g.fillRect(Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Back", Game.WIDTH / 6 - (Game.WIDTH / 30), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));
        } if (game.gameState == Game.STATE.ChooseHard) {
            Font font = new Font("arial", 1, Game.WIDTH / 25);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            Font font3 = new Font("arial", 1, Game.WIDTH / 40);

            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.setFont(font);

            g.drawString("Difficulty", Game.WIDTH / 2 - (Game.WIDTH / 1), Game.HEIGHT / 15);

            g.setFont(font2);
            g.setColor(Color.WHITE);

            if (trans1Choose) {
                g.fillRect(Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.WHITE);
            }
            g.drawString("Easy", Game.WIDTH / 4 - (Game.WIDTH / 30), Game.HEIGHT / 2 + (Game.HEIGHT / 60));

            if (trans2Choose) {
                g.fillRect(Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.WHITE);
            }
            g.drawString("Hard", Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 30), Game.HEIGHT / 2 + (Game.HEIGHT / 60));

            if (trans3Choose) {
                g.fillRect(Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 8) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Back", Game.WIDTH / 6 - (Game.WIDTH / 25), Game.HEIGHT - (Game.HEIGHT / 8) + (Game.HEIGHT / 60));
        } else if (game.gameState == Game.STATE.Rank) {
            Font font = new Font("arial", 1, Game.WIDTH / 25);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            Font font3 = new Font("arial", 1, Game.WIDTH / 40);

            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.setFont(font);

            g.drawString("Rank", Game.WIDTH / 2 - (Game.WIDTH / 17), Game.HEIGHT / 15);

            g.setFont(font3);
            g.setColor(Color.WHITE);
            g.drawString("Position", Game.WIDTH / 6, Game.HEIGHT / 5);

            g.drawString("Name", Game.WIDTH / 3, Game.HEIGHT / 5);

            g.drawString("Score", Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT / 5);

            g.setFont(font2);
            g.drawString("1", Game.WIDTH / 6, Game.HEIGHT / 4);
            g.drawString("2", Game.WIDTH / 6, Game.HEIGHT / 4 + (Game.HEIGHT / 10));
            g.drawString("3", Game.WIDTH / 6, Game.HEIGHT / 4 + (Game.HEIGHT / 10) + (Game.HEIGHT / 10));
            g.drawString("4", Game.WIDTH / 6, Game.HEIGHT / 4 + (Game.HEIGHT / 10) + (Game.HEIGHT / 10) + (Game.HEIGHT / 10));
            g.drawString("5", Game.WIDTH / 6, Game.HEIGHT / 4 + (Game.HEIGHT / 10) + (Game.HEIGHT / 10) + (Game.HEIGHT / 10) + (Game.HEIGHT / 10));

            g.drawString(Server.bestName, Game.WIDTH / 3, Game.HEIGHT / 4);
            g.drawString(Server.bestName2, Game.WIDTH / 3, Game.HEIGHT / 4 + (Game.HEIGHT / 10));
            g.drawString(Server.bestName3, Game.WIDTH / 3, Game.HEIGHT / 4 + (Game.HEIGHT / 10) + (Game.HEIGHT / 10));
            g.drawString(Server.bestName4, Game.WIDTH / 3, Game.HEIGHT / 4 + (Game.HEIGHT / 10) + (Game.HEIGHT / 10) + (Game.HEIGHT / 10));
            g.drawString(Server.bestName5, Game.WIDTH / 3, Game.HEIGHT / 4 + (Game.HEIGHT / 10) + (Game.HEIGHT / 10) + (Game.HEIGHT / 10) + (Game.HEIGHT / 10));

            g.drawString(Integer.toString(Server.bestScore), Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT / 4);
            g.drawString(Integer.toString(Server.secondBestScore), Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT / 4 + (Game.HEIGHT / 10));
            g.drawString(Integer.toString(Server.thirdBestScore), Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT / 4 + (Game.HEIGHT / 10) + (Game.HEIGHT / 10));
            g.drawString(Integer.toString(Server.fourthBestScore), Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT / 4 + (Game.HEIGHT / 10) + (Game.HEIGHT / 10) + (Game.HEIGHT / 10));
            g.drawString(Integer.toString(Server.fifthBestScore), Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT / 4 + (Game.HEIGHT / 10) + (Game.HEIGHT / 10) + (Game.HEIGHT / 10) + (Game.HEIGHT / 10));

            if (trans1Rank) {
                g.fillRect(Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 8) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Back", Game.WIDTH / 6 - (Game.WIDTH / 25), Game.HEIGHT - (Game.HEIGHT / 8) + (Game.HEIGHT / 60));
        } else if (game.gameState == Game.STATE.Finished) {
            Font font = new Font("arial", 1, Game.WIDTH / 25);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            Font font3 = new Font("arial", 1, Game.WIDTH / 40);
            g.setFont(font);

            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawString("Game Won!",  Game.WIDTH / 2 - (Game.WIDTH / 11), Game.HEIGHT / 15);
            g.setColor(Color.WHITE);

            g.setFont(font3);
            g.drawString("You finished with to cube : " + hud.getLevel(), Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 3);
            g.drawString("Your final score was : " + hud.score, Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 3 + (Game.HEIGHT / 15));
            g.drawString("Your final points were : " + hud.getPoints1(), Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 3 + (Game.HEIGHT / 7));
            if (Game.PlayerMode2) g.drawString("Player won: " + HUD.playerWon, Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 4);
//            if (Game.onlineMode) g.drawString("Player won: " + HUD.playerWonOnline, Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 4);

            g.setFont(font2);
            if (trans1End) {
                g.fillRect(Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Home", Game.WIDTH / 6 - (Game.WIDTH / 25), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));
        } else if (game.gameState == Game.STATE.End) {
            Font font = new Font("arial", 1, Game.WIDTH / 25);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            Font font3 = new Font("arial", 1, Game.WIDTH / 40);
            g.setFont(font);

            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawString("Game Over",  Game.WIDTH / 2 - (Game.WIDTH / 11), Game.HEIGHT / 15);
            g.setColor(Color.WHITE);

            g.setFont(font3);
            g.drawString("You made it to cube : " + hud.getLevel(), Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 3);
            g.drawString("Your final score was : " + hud.score, Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 3 + (Game.HEIGHT / 15));
            g.drawString("Your final points were : " + hud.getPoints1(), Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 3 + (Game.HEIGHT / 7));
            if (Game.PlayerMode2) g.drawString("Player won: " + HUD.playerWon, Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 4);
//            if (Game.onlineMode) g.drawString("Player won: " + HUD.playerWonOnline, Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 4);

            g.setFont(font2);
            if (trans1End) {
                g.fillRect(Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Home", Game.WIDTH / 6 - (Game.WIDTH / 25), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));
        } else if (game.gameState == Game.STATE.Select) {
            Font font = new Font("arial", 1, Game.WIDTH / 25);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            Font font3 = new Font("arial", 1, Game.WIDTH / 40);
            g.setFont(font);

            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawString("Level", Game.WIDTH / 2 - (Game.WIDTH / 15), Game.HEIGHT / 15);
            g.setColor(Color.WHITE);

            g.setFont(font2);
            if (game.normalWon) {
                g.setColor(Color.GREEN);
                g.drawString("Won!", Game.WIDTH / 4 - Game.WIDTH / 50, Game.HEIGHT / 5 - (Game.HEIGHT / 50));
            }
            if (locked) {
                g.setColor(Color.RED);
                g.drawString("Locked!", Game.WIDTH / 2 - (Game.WIDTH / 30), Game.HEIGHT / 7);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        locked = false;
                    }
                }, 2000);
            }
            if (trans1Difficulty) {
                g.fillRect(Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Easy", Game.WIDTH / 4 - (Game.WIDTH / 30), Game.HEIGHT / 5 + (Game.HEIGHT / 60));
            g.setColor(Color.WHITE);

            if (game.hardWon) {
                g.setColor(Color.GREEN);
                g.drawString("Won!", Game.WIDTH / 4 - Game.WIDTH / 50, Game.HEIGHT / 5 - (Game.HEIGHT / 50));
            }
            if (trans2Difficulty) {
                g.fillRect(Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Hard", Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 30), Game.HEIGHT / 5 + (Game.HEIGHT / 60));
            g.setColor(Color.WHITE);

            if (game.p2normalWon || game.p2hardWon) {
                g.setColor(Color.GREEN);
                g.drawString("Won!", Game.WIDTH / 4 - Game.WIDTH / 50, Game.HEIGHT / 5 - (Game.HEIGHT / 50));
            }
            if (trans4Difficulty) {
                g.fillRect(Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("2-Player", Game.WIDTH / 4 - (Game.WIDTH / 18), Game.HEIGHT / 2 + (Game.HEIGHT / 60));
            g.setColor(Color.WHITE);

            // do for these 2
            if (trans5Difficulty) {
                g.fillRect(Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Online", Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 25), Game.HEIGHT / 2 + (Game.HEIGHT / 60));
            g.setColor(Color.WHITE);

            if (trans6Difficulty) {
                g.fillRect(Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Squadron", Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 17), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));
            g.setColor(Color.WHITE);

            g.setFont(font2);
            if (trans3Difficulty) {
                g.fillRect(Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Back", Game.WIDTH / 4 - (Game.WIDTH / 30), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));
        } else if (game.gameState == Game.STATE.Options) {
            Font font = new Font("arial", 1, Game.WIDTH / 25);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            Font font3 = new Font("arial", 1, Game.WIDTH / 40);
            g.setFont(font);

            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawString("Options", Game.WIDTH / 2 - (Game.WIDTH / 13), Game.HEIGHT / 15);
            g.setColor(Color.WHITE);

            g.setFont(font2);
            if (trans1Options) {
                g.fillRect(Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Credits", Game.WIDTH / 4 - (Game.WIDTH / 20), Game.HEIGHT / 2 + (Game.HEIGHT / 60));

            g.setColor(Color.WHITE);
            if (trans2Options) {
                g.fillRect(Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Help", Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 30), Game.HEIGHT / 2 + (Game.HEIGHT / 60));

            g.setColor(Color.WHITE);
            if (trans3Options) {
                g.fillRect(Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Back", Game.WIDTH / 6 - (Game.WIDTH / 30), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));
        } else if (game.gameState == Game.STATE.Credits) {
            Font font = new Font("arial", 1, Game.WIDTH / 25);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            Font font3 = new Font("arial", 1, Game.WIDTH / 40);
            g.setFont(font);

            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawString("Credits", Game.WIDTH / 2 - (Game.WIDTH / 13), Game.HEIGHT / 15);
            g.setColor(Color.WHITE);

            g.setFont(font3);
            g.drawString("Designed and Developed by: ", Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 3);
            g.drawString("Rayyan Zahid Anwar", Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 3 + (Game.HEIGHT / 15));
            g.drawString("Special Thanks to: ", Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 2);
            g.drawString("Zack Berenger", Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 2 + (Game.HEIGHT / 15));

            g.setFont(font2);
            if (trans1Credits) {
                g.fillRect(Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Back", Game.WIDTH / 6 - (Game.WIDTH / 30), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));
        }
    }
}
