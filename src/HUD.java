import java.awt.*;
import java.sql.Time;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HUD {

    public static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static int bounds = 0;
    public static int HEALTH = 100;

    public static boolean tickdatock;

    public static boolean levelUp = false;

    public static int P2HEALTH = 100;

//    public static boolean revivePrompt = false;

    public static boolean show3 = true;

    public static boolean show2 = true;

    public static boolean do2 = false;

    public static boolean show1 = true;

    public static boolean do1 = false;

    public static int score = 0;

    public static int dabing = 1;

    public static String playerWon;

    private boolean deactivate1Is = false;

    private boolean force1Is = false;

    private boolean deactivate2Is = false;

    private boolean force2Is = false;

    public static boolean waitBar1 = false;

    public static boolean waitBar2 = false;

    public static int bounds2 = 0;

    private static int timeWidth = 0;

    private static int timeWidth2 = 0;

    public static int p1points = 0;

    public static int cpuHEALTH = 100;

    public static int p2points = 0;

    private int level = 1;

    public static String power1 = "";
    public static String power2 = "";


    int scoreKeep = 0;
    public void tick() {
        if (tickdatock) {
            if (HEALTH == 0 && P2HEALTH != 0) playerWon = "2";
            else if (P2HEALTH == 0 && HEALTH != 0) playerWon = "1";
            score += dabing;
            scoreKeep += dabing;
            if (scoreKeep >= 2000) {
                scoreKeep = 0;
                if (Game.PlayerMode2) {
                    p1points++;
                    p2points++;
                } else {
                    p1points++;
                }
            }
        }
    }

    public static void pausePower1(int seconds) {
        if (Objects.equals(power1, "D")) Shop.deactivate1 = false;
        if (Objects.equals(power1, "F")) Shop.force1 = false;
        Runnable action = () -> {
            if (!(timeWidth == 46)) {
                if (timeWidth != 40) timeWidth += 5;
                else timeWidth += 3;
            } else {
                System.out.println("bello");
            }
        };

        for (int i = 0; i < seconds; i++) {
            scheduler.schedule(action, i, TimeUnit.SECONDS);
        }

        scheduler.schedule(() -> {
            if (Objects.equals(power1, "D")) Shop.deactivate1 = true;
            if (Objects.equals(power2, "F")) Shop.force1 = true;
            waitBar1 = false;
            timeWidth = 0;
        }, seconds, TimeUnit.SECONDS);
    }

    public static void pausePower2(int seconds) {
        if (Objects.equals(power2, "D")) Shop.deactivate2 = false;
        if (Objects.equals(power2, "F")) Shop.force2 = false;
        Runnable action = () -> {
            if (timeWidth2 != 40) timeWidth2 += 5;
            else timeWidth2 += 3;
        };

        for (int i = 0; i < seconds; i++) {
            scheduler.schedule(action, i, TimeUnit.SECONDS);
        }

        scheduler.schedule(() -> {
            if (Objects.equals(power2, "D")) Shop.deactivate2 = true;
            if (Objects.equals(power2, "F")) Shop.force2 = true;
            waitBar2 = false;
            timeWidth2 = 0;
        }, seconds, TimeUnit.SECONDS);
    }

    public static void waitBar1Ality() {
        waitBar1 = true;
        pausePower1(10);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeWidth = 0;
                timer.cancel();
            }
        }, 10000);
    }

    public static void waitBar2Ality() {
        waitBar2 = true;
        pausePower2(10);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeWidth2 = 0;
                timer.cancel();
            }
        }, 10000);
    }

    public void render(Graphics g) {

        g.setFont(new Font("arial", 1, Game.WIDTH / 80));
        Graphics2D g2d = (Graphics2D) g;
        if (!Game.PlayerMode2) {
            if (Player1.isTouchingHUD1) {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            } else {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            }
            g.setColor(Color.RED);
            g.fillRect(Game.WIDTH / 2 - ((200 + bounds) / 2), 10, 200 + bounds, 32);
            g.setColor(Color.GREEN);
            g.fillRect(Game.WIDTH / 2 - ((200 + bounds) / 2), 10, HEALTH * 2, 32);
            g.setColor(Color.WHITE);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            if (Player1.isTouchingInfo1) {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            } else {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            }
            g.drawString("Score : " + score, 15, Game.HEIGHT - 70);
            g.drawString("Cube : " + level, 15, Game.HEIGHT - 50);
            g.drawString("Points : " + p1points, 15, Game.HEIGHT - 90);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));

            g.drawRect(Game.WIDTH - 65, 0, 48, 48);
            g.drawRect(Game.WIDTH - 113, 0, 48, 48);
            if (Objects.equals(power1, "")) {
                g.setColor(Color.RED);
                g.drawLine(Game.WIDTH - 113, 0, Game.WIDTH - 65, 48);
                g.drawLine(Game.WIDTH - 65, 0, Game.WIDTH - 113, 48);
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.WHITE);
                g.setFont(new Font("arial", 1, Game.WIDTH / 35));
                g.drawString(power1, Game.WIDTH - 107, 43);
            }
            if (Objects.equals(power2, "")) {
                g.setColor(Color.RED);
                g.drawLine(Game.WIDTH - 65, 0, Game.WIDTH - 17, 48);
                g.drawLine(Game.WIDTH - 17, 0, Game.WIDTH - 65, 48);
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.WHITE);
                g.setFont(new Font("arial", 1, Game.WIDTH / 35));
                g.drawString(power2, Game.WIDTH - 55, 43);
            }
            if (waitBar1) {
                g.drawRect(Game.WIDTH - 113, 60, 48, 12);
                g.fillRect(Game.WIDTH - 112, 61, timeWidth, 11);
            }
            if (waitBar2) {
                g.drawRect(Game.WIDTH - 65, 60, 48, 12);
                g.fillRect(Game.WIDTH - 64, 61, timeWidth2, 11);
            }
            if (show3) {
                g.setFont(new Font("arial", 1, Game.WIDTH / 25));
                g.drawString("3", Game.WIDTH / 2 - (Game.WIDTH / 50), Game.HEIGHT / 2 - (Game.HEIGHT / 30));
            }
            if (do2) {
                if (show2) {
                    g.setFont(new Font("arial", 1, Game.WIDTH / 25));
                    g.drawString("2", Game.WIDTH / 2 - (Game.WIDTH / 50), Game.HEIGHT / 2 - (Game.HEIGHT / 30));
                }
            }
            if (do1) {
                if (show1) {
                    g.setFont(new Font("arial", 1, Game.WIDTH / 25));
                    g.drawString("1", Game.WIDTH / 2 - (Game.WIDTH / 50), Game.HEIGHT / 2 - (Game.HEIGHT / 30));
                }
            }

            if (levelUp) {
                g.setFont(new Font("arial", 1, Game.WIDTH / 25));
                g.drawString("Level " + getLevel(), Game.WIDTH / 2 - (Game.WIDTH / 16), Game.HEIGHT / 2 - (Game.HEIGHT / 30));
            }

//        if (revivePrompt) {
//            // Make mouseOvers for
//            // buttons and make no thanks
//            // button lead to Game Over
//            // Not going to game over
//            // directly is already done
//            // in Game.
//            // Also turn off revivePrompt
//            // on pressing of no thanks
//            g.setColor(Color.GREEN);
//            g.fillRect(Game.WIDTH / 2 - (Game.WIDTH / 15), Game.HEIGHT / 2 - (Game.HEIGHT / 20), Game.WIDTH / 5, Game.HEIGHT / 3);
//
//            g.setColor(Color.BLACK);
//            g.setFont(new Font("arial", 1, Game.WIDTH / 35));
//            g.drawString("Revive", Game.WIDTH / 2 - (Game.WIDTH / 30), Game.HEIGHT / 2 - (Game.HEIGHT / 20) + (Game.HEIGHT / 50));
//
//            g.setColor(Color.ORANGE);
//            g.fillRect(Game.WIDTH / 2 - (Game.WIDTH / 15) + (Game.WIDTH / 25), Game.HEIGHT / 2 - (Game.HEIGHT / 20) + (Game.HEIGHT / 30), Game.WIDTH / 6, Game.HEIGHT / 5);
//
//            g.setColor(Color.WHITE);
//            g.drawString("AD", Game.WIDTH / 2 - (Game.WIDTH / 100), Game.HEIGHT / 2);
//
//            g.setColor(Color.GRAY);
//            g.fillRect(Game.WIDTH / 2 - (Game.WIDTH / 15) + (Game.WIDTH / 25), Game.HEIGHT / 2 + (Game.HEIGHT / 50), Game.WIDTH / 6, Game.HEIGHT / 25);
//
//            g.setColor(Color.BLACK);
//            g.drawString("No Thanks", Game.WIDTH / 2 - (Game.WIDTH / 50), Game.HEIGHT / 2);
//
//            // shadow
//            g.setColor(new Color(127, 135, 138));
//            g.fillRect(Game.WIDTH / 2 - (Game.WIDTH / 15) + 5, Game.HEIGHT / 2 - (Game.HEIGHT / 20) + 5, Game.WIDTH / 5, Game.HEIGHT / 3);
//        }
        } else {
            if (Player1.isTouchingHUD21 || Player2.isTouchingHUD1) {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            } else {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            }
            // this is for the
            // first player
            g.setColor(Color.WHITE);
            g.drawString("P1: ", Game.WIDTH / 4 - (Game.WIDTH / 10), 25);
            g.setColor(Color.RED);
            g.fillRect(Game.WIDTH / 4 - ((200 + bounds) / 2), 10, 200 + bounds, 32);
            g.setColor(Color.GREEN);
            g.fillRect(Game.WIDTH / 4 - ((200 + bounds) / 2), 10, HEALTH * 2, 32);
            g.setColor(Color.WHITE);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));

            if (Player1.isTouchingHUD22 || Player2.isTouchingHUD2) {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            } else {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            }
            // this is for the
            // second player
            g.drawString("P2: ", Game.WIDTH - (Game.WIDTH / 3) - (Game.WIDTH / 25), 25);
            g.setColor(Color.RED);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 4) - ((200 + bounds2) / 2), 10, 200 + bounds2, 32);
            g.setColor(Color.GREEN);
            g.fillRect(Game.WIDTH - (Game.WIDTH / 4) - ((200 + bounds2) / 2), 10, P2HEALTH * 2, 32);
            g.setColor(Color.WHITE);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));


            if (Player1.isTouchingInfo2 || Player2.isTouchingInfo) {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            } else {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            }
            // this is for the
            // first player
            g.drawString("P1: ", 15, Game.HEIGHT - 130);
            g.drawString("Count : " + score, 15, Game.HEIGHT - 70);
            g.drawString("Cube : " + level, 15, Game.HEIGHT - 50);
            g.drawString("Points : " + p1points, 15, Game.HEIGHT - 90);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));

            if (Player1.isTouchingInfo2 || Player2.isTouchingInfo) {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            } else {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            }
            // this is for the
            // second player
            g.drawString("P2: ", 175, Game.HEIGHT - 130);
            g.drawString("Count : " + score, 175, Game.HEIGHT - 70);
            g.drawString("Cube : " + level, 175, Game.HEIGHT - 50);
            g.drawString("Points : " + p2points, 175, Game.HEIGHT - 90);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));

            if (show3) {
                g.setFont(new Font("arial", 1, Game.WIDTH / 25));
                g.drawString("3", Game.WIDTH / 2 - (Game.WIDTH / 50), Game.HEIGHT / 2 - (Game.HEIGHT / 30));
            }
            if (do2) {
                if (show2) {
                    g.setFont(new Font("arial", 1, Game.WIDTH / 25));
                    g.drawString("2", Game.WIDTH / 2 - (Game.WIDTH / 50), Game.HEIGHT / 2 - (Game.HEIGHT / 30));
                }
            }
            if (do1) {
                if (show1) {
                    g.setFont(new Font("arial", 1, Game.WIDTH / 25));
                    g.drawString("1", Game.WIDTH / 2 - (Game.WIDTH / 50), Game.HEIGHT / 2 - (Game.HEIGHT / 30));
                }
            }
        }
    }

    public static int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static int getPoints1() { return p1points; }

    public void setPoints1(int points) { this.p1points = points; }

    public static int getPoints2() {
        return p2points;
    }

    public void setPoints2(int p2points) {
        this.p2points = p2points;
    }

    public void show321() {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                show3 = false;
                do2 = true;
            }
        }, 1000);

        if (do2) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    do2 = false;
                    show2 = false;
                    do1 = true;
                }
            }, 1000);
            if (do1) {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        do1 = false;
                        show1 = false;
                        show2 = false;
                        do2 = false;
                        tickdatock = true;
                        Spawn.doit = true;
                        timer.cancel();
                    }
                }, 1000);
            }
        }
    }
}

