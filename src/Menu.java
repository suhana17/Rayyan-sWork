import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    public static boolean skins = false;

    public static String playerName = "QBer";

    public static boolean trans1Main = false;

    private static boolean trans5Difficulty = false;

    public static boolean trans4Difficulty = false;

    public static boolean trans6Difficulty = false;

    public static boolean trans1Intro = false;

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

    public static boolean volume = true;

    public static boolean cancelled = false;

    public static String skin = "plain";

    private boolean squadron = false;

    public static boolean trans2Difficulty = false;

    public static boolean trans3Difficulty = false;

    public static boolean trans1Profile = false;

    public static boolean trans1Rank = false;

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

                JOptionPane.showMessageDialog(null, "Squadron coming soon!", "Stay Tuned!", JOptionPane.INFORMATION_MESSAGE);
                skins = false;
                squadron = true;
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
                skin = "plain";
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 5), Game.HEIGHT / 3, 64, 64)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                skin = "creeper";
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 7), Game.HEIGHT / 3, 64, 64)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                skin = "zombie";
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT / 3 + (Game.HEIGHT / 13), 64, 64)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                skin = "skeleton";
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 5), Game.HEIGHT / 3 + (Game.HEIGHT / 13), 64, 64)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                skin = "enderman";
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 7), Game.HEIGHT / 3 + (Game.HEIGHT / 13), 64, 64)) {
                if (volume) game.play("sounds/buttonPress.mp3");
                skin = "gift package";
            }
        }

        if (game.gameState == Game.STATE.Map) {
            if (mouseOver(mx, my, Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10
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

                game.gameState = Game.STATE.Game;
                handler.addObject(new Player1(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player1, handler));
                handler.clearEnemies();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH + 55), r.nextInt(Game.HEIGHT + 55), ID.BasicEnemy, handler));

                game.PlayerMode2 = false;
                game.onlineMode = false;
                game.diff = 0;
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

                game.gameState = Game.STATE.Game;
                handler.addObject(new Player1(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player1, handler));
                handler.clearEnemies();
                handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH + 55), r.nextInt(Game.HEIGHT + 55), ID.BasicEnemy, handler));

                game.PlayerMode2 = false;
                game.onlineMode = false;
                game.diff = 1;
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

                game.gameState = Game.STATE.Game;
                handler.addObject(new Player1(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player1, handler));
                handler.clearEnemies();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH + 55), r.nextInt(Game.HEIGHT + 55), ID.BasicEnemy, handler));

                game.diff = 0;
                game.PlayerMode2 = true;
                game.onlineMode = false;
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

                game.gameState = Game.STATE.Online;
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

                JOptionPane.showMessageDialog(null, "Squadron level coming soon!", "Stay Tuned!", JOptionPane.INFORMATION_MESSAGE);
                game.PlayerMode2 = false;
                game.onlineMode = false;
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
                return;
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

    public void tick() {}

    public void render(Graphics g) {
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
        if (game.gameState == Game.STATE.Intro) {
            Font font = new Font("arial", 1, Game.WIDTH / 15);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            g.setColor(Color.WHITE);
            g.setFont(font);

            g.drawString("QBism", Game.WIDTH / 2 - (Game.WIDTH / 8) + (Game.WIDTH / 65), Game.HEIGHT / 3);

            g.setFont(font2);
            g.drawString("By: Rayyan Zahid Anwar", Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 2 - (Game.HEIGHT / 25));

            g.setFont(new Font("arial", 1, Game.WIDTH / 45));
            g.drawString("Coming Soon: ", Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 2 + (Game.HEIGHT / 6));
            g.drawString("Maps/chat", Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 2 + (Game.HEIGHT / 4));
            g.drawString("Squadron", Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 2 + (Game.HEIGHT / 3));
            g.drawString("More power-ups", Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 2 + (Game.HEIGHT / 3) + (Game.HEIGHT / 12));
            g.drawString("Online level", Game.WIDTH / 2 + (Game.WIDTH / 12), Game.HEIGHT / 2 + (Game.HEIGHT / 4));
            g.drawString("Stats", Game.WIDTH / 2 + (Game.WIDTH / 12), Game.HEIGHT / 2 + (Game.HEIGHT / 3));

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
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
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
            g.drawString("Map " + Game.map + 1, Game.WIDTH / 2 - (Game.WIDTH / 12), Game.HEIGHT / 2);

            g.drawString("←", Game.WIDTH / 2 - (Game.WIDTH / 8), Game.HEIGHT / 2);
            g.drawStrign("→", Game.WIDTH / 2 + (Game.WIDTH / 8), Game.HEIGHT / 2);

            if (trans1Map) {
                g.fillRect(Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Back", Game.WIDTH / 6 - (Game.WIDTH / 30), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));
        } else if (game.gameState == Game.STATE.Help) {
            Font font = new Font("arial", 1, Game.WIDTH / 25);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            Font font3 = new Font("arial", 1, Game.WIDTH / 45);
            g.setFont(font);

            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawString("Help", Game.WIDTH / 2 - (Game.WIDTH / 17), Game.HEIGHT / 15);
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

            g.drawString("Objective: ", Game.WIDTH / 7, Game.HEIGHT / 2 + (Game.HEIGHT / 6));
            g.drawString("Survive as long as possible", Game.WIDTH / 25, Game.HEIGHT / 2 + (Game.HEIGHT / 5));
            g.drawString("If there is any problem, simply restart the game.", Game.WIDTH / 25, Game.HEIGHT / 2 + (Game.HEIGHT / 4));

            g.setFont(font2);
            if (trans1Help) {
                g.fillRect(Game.WIDTH / 6 - (Game.WIDTH / 8), Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Back", Game.WIDTH / 6 - (Game.WIDTH / 30), Game.HEIGHT - (Game.HEIGHT / 6) + (Game.HEIGHT / 60));
        } else if (game.gameState == Game.STATE.Profile) {
            skins = true;
            Font font = new Font("arial", 1, Game.WIDTH / 25);
            Font font2 = new Font("arial", 1, Game.WIDTH / 35);
            Font font3 = new Font("arial", 1, Game.WIDTH / 40);
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

            g.drawString("Stats coming soon!", Game.WIDTH / 3, Game.HEIGHT / 3);

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
        } if (game.gameState == Game.STATE.Rank) {
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
            g.drawString("Difficulty", Game.WIDTH / 2 - (Game.WIDTH / 11), Game.HEIGHT / 15);
            g.setColor(Color.WHITE);

            g.setFont(font2);
            if (trans1Difficulty) {
                g.fillRect(Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Easy", Game.WIDTH / 4 - (Game.WIDTH / 30), Game.HEIGHT / 5 + (Game.HEIGHT / 60));
            g.setColor(Color.WHITE);

            if (trans2Difficulty) {
                g.fillRect(Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 8), Game.HEIGHT / 5 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Hard", Game.WIDTH - (Game.WIDTH / 4) - (Game.WIDTH / 30), Game.HEIGHT / 5 + (Game.HEIGHT / 60));
            g.setColor(Color.WHITE);

            if (trans4Difficulty) {
                g.fillRect(Game.WIDTH / 4 - (Game.WIDTH / 8), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("2-Player", Game.WIDTH / 4 - (Game.WIDTH / 18), Game.HEIGHT / 2 + (Game.HEIGHT / 60));
            g.setColor(Color.WHITE);

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
