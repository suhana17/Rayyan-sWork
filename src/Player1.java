import java.awt.*;
import java.util.Objects;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Player1 extends GameObject {

    Handler handler;

    public static int dax;
    public static int day;

    public static boolean isTouchingHUD1 = false;

    public static boolean isTouchingInfo1 = false;

    public static boolean isTouchingHUD21 = false;

    public static boolean isTouchingHUD22 = false;

    public static boolean isTouchingInfo2 = false;

    public static boolean damageDeal;

    public static int deactivateTime = 5000;

    public static int forceTime = 15000;

    Random r = new Random();

    public static boolean forceField = false;

    public static float dajing = 2;

    public Player1(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.x = dax;
        this.y = day;
        damageDeal = true;
        this.handler = handler;


        dax = r.nextInt(Game.WIDTH - 48);
        day = r.nextInt(Game.HEIGHT - 71);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) dax, (int) day, 32, 32);
    }

    @Override
    public void tick() {
        dax += velX;
        day += velY;

        x = dax;
        y = day;

        if (Game.map == 1) {
            if (day <= Game.HEIGHT / 2 - (Game.HEIGHT / 4) + (Game.HEIGHT / 15) && day >= Game.HEIGHT / 2 - (Game.HEIGHT / 4) + (Game.HEIGHT / 15) - (Game.HEIGHT / 150) && dax >= Game.WIDTH / 3 && dax <= Game.WIDTH / 3 + (Game.WIDTH / 3)) {
                day = Game.HEIGHT / 2 - (Game.HEIGHT / 4) + (Game.HEIGHT / 14);
            }

            if (dax >= Game.WIDTH / 3 - 32 && dax <= Game.WIDTH / 3 - 32 + (Game.WIDTH / 150) && day >= Game.HEIGHT / 2 - (Game.HEIGHT / 4) && day <= Game.HEIGHT / 2 - (Game.HEIGHT / 4) + (Game.HEIGHT / 15)) {
                dax = Game.WIDTH / 3 - 32;
            }

            if (dax <= Game.WIDTH / 3 + (Game.WIDTH / 3) && dax >= Game.WIDTH / 3 + (Game.WIDTH / 3) - (Game.WIDTH / 150) && day >= Game.HEIGHT / 2 - (Game.HEIGHT / 4) && day <= Game.HEIGHT / 2 - (Game.HEIGHT / 4) + (Game.HEIGHT / 15)) {
                dax = Game.WIDTH / 3 + (Game.WIDTH / 3);
            }

            if (day >= Game.HEIGHT / 2 - (Game.HEIGHT / 4) - 32 && day <= Game.HEIGHT / 2 - (Game.HEIGHT / 4) + (Game.HEIGHT / 150) && dax >= Game.WIDTH / 3 && dax <= Game.WIDTH / 3 + (Game.WIDTH / 3)) {
                day = Game.HEIGHT / 2 - (Game.HEIGHT / 4) - 32;
            }
        }

        if (Game.map == 3) {
            if (dax >= Game.WIDTH / 2 - (Game.WIDTH / 15) - 32 && dax <= Game.WIDTH / 2 - (Game.WIDTH / 15) - 32 + (Game.WIDTH / 150) && day >= Game.HEIGHT - (Game.HEIGHT / 5) - 32 && day <= Game.HEIGHT) {
                dax = Game.WIDTH / 2 - (Game.WIDTH / 15) - 32;
            }

            if (dax <= Game.WIDTH / 2 - (Game.WIDTH / 15) + (Game.WIDTH / 25) && dax >= Game.WIDTH / 2 - (Game.WIDTH / 15) + (Game.WIDTH / 25) - (Game.WIDTH / 150) && day >= Game.HEIGHT - (Game.HEIGHT / 5) - 32 && day <= Game.HEIGHT) {
                dax = Game.WIDTH / 2 - (Game.WIDTH / 15) + (Game.WIDTH / 25);
            }

            // other wall
            if (dax >= Game.WIDTH - (Game.WIDTH / 6) - 32 && dax <= Game.WIDTH - (Game.WIDTH / 6) + (Game.WIDTH / 150) && day >= Game.HEIGHT / 3 && day <= Game.HEIGHT / 3 + (Game.HEIGHT / 13)) {
                // this is side of wall, no other for dax because wall is satofied to right
                dax = Game.WIDTH - (Game.WIDTH / 6) - 32;
            }

            if (day >= Game.HEIGHT / 3 - 32 && day <= Game.HEIGHT / 3 + (Game.HEIGHT / 150) && dax >= Game.WIDTH - (Game.WIDTH / 6) && dax <= Game.WIDTH) {
                day = Game.HEIGHT / 3 - 32;
            }

            if (day <= Game.HEIGHT / 3 + (Game.HEIGHT / 13) && day >= Game.HEIGHT / 3 + (Game.HEIGHT / 13) - (Game.HEIGHT / 150) && dax >= Game.WIDTH - (Game.WIDTH / 6) && dax <= Game.WIDTH) {
                day = Game.HEIGHT / 3 + (Game.HEIGHT / 12);

            }

            // no top bottom because thorn is on top, and wall is satofied to ground
        }

        if (Game.map == 4) {
            // left wall

            //top bottom (velY)
            if ((day >= Game.HEIGHT - (Game.HEIGHT / 3) - 32 && day <= Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 150)) && (dax >= 0 && dax <= Game.WIDTH / 4)) {
                day = Game.HEIGHT - (Game.HEIGHT / 3) - 32;
            }

            if ((day <= Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 15) && day >= Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 15) - (Game.HEIGHT / 150)) && (dax >= 0 && dax <= Game.WIDTH / 4)) {
                day = Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 14);
            }

            // 1 side (velX)
            if ((dax <= Game.WIDTH / 4 && dax >= Game.WIDTH / 4 - (Game.WIDTH / 150)) && (day >= Game.HEIGHT - (Game.HEIGHT / 3) && day <= Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 15))) {
                dax = Game.WIDTH / 4;
            }

            // bottom wall

            // no top bottom because wall is satofied to ground, and thorn on toip

            if (dax >= Game.WIDTH / 2 + (Game.WIDTH / 25) - 32 && dax <= Game.WIDTH / 2 + (Game.WIDTH / 25) + (Game.WIDTH / 100) && (day >= Game.HEIGHT - (Game.HEIGHT / 3) - 32 && day <= Game.HEIGHT)) {
                dax = Game.WIDTH / 2 + (Game.WIDTH / 25) - 32;
            }

            if (dax <= Game.WIDTH / 2 + (Game.WIDTH / 25) + (Game.WIDTH / 30) && dax >= Game.WIDTH / 2 + (Game.WIDTH / 25) + (Game.WIDTH / 30) - (Game.WIDTH / 150) && day >= Game.HEIGHT - (Game.HEIGHT / 3) - 32 && day <= Game.HEIGHT) {
                dax = Game.WIDTH / 2 + (Game.WIDTH / 25) + (Game.WIDTH / 30);
            }

            // right wall

            if (dax >= Game.WIDTH - (Game.WIDTH / 3) - 32 && dax <= Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 150) && day >= -10 && day <= Game.HEIGHT / 3) {
                dax = Game.WIDTH - (Game.WIDTH / 3) - 32;
            }

            if (dax <= Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 30) && dax >= Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 30) - (Game.WIDTH / 150) && day >= -10 && day <= Game.HEIGHT / 3) {
                dax = Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 30);
            }

            if (day <= Game.HEIGHT / 3 && day >= Game.HEIGHT / 3 - (Game.HEIGHT / 150) && dax >= Game.WIDTH - (Game.WIDTH / 3) && dax <= Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 30)) {
                day = Game.HEIGHT / 3 + (Game.HEIGHT / 150);
            }
        }

        dax = (int) Game.clamp(dax, 0, Game.WIDTH - 48);
        day = (int) Game.clamp(day, 0, Game.HEIGHT - 71);

        isTouchingHUD1 = (dax >= Game.WIDTH / 2 - ((200 + HUD.bounds) / 2) - 32 && dax <= Game.WIDTH / 2 + ((200 + HUD.bounds) / 2)) && (day >= 0 && day <= 32);

        // make OTHERS
        isTouchingHUD21 = (dax >= Game.WIDTH / 4 - ((200 + HUD.bounds) / 2) - 32 && dax <= Game.WIDTH / 4 + ((200 + HUD.bounds) / 2)) && (day >= 0 && day <= 32);

        isTouchingHUD22 = (dax >= Game.WIDTH - (Game.WIDTH / 4) - ((200 + HUD.bounds) / 2) - 32 && dax <= Game.WIDTH - (Game.WIDTH / 4) + ((200 + HUD.bounds) / 2)) && (day >= 0 && day <= 32);

        isTouchingInfo2 = (dax >= 0 & dax <= 330) && (day >= Game.HEIGHT - 170 && day <= Game.HEIGHT);

        isTouchingInfo1 = (dax >= 0 & dax <= 180) && (day >= Game.HEIGHT - 118 && day <= Game.HEIGHT);

        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy | tempObject.getId() == ID.MovingWall) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    if (damageDeal) {
                        if (Menu.volume) Game.playerOfDamage.playMusic();
                        HUD.HEALTH -= dajing;
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Game.playerOfDamage.stopMusic();
                            }
                        }, 1000);
                    }
                }
            }

            if (tempObject.getId() == ID.Enemy2BossShip || tempObject.getId() == ID.EnemyBoss || tempObject.getId() == ID.Thorn) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    if (Menu.volume) Game.playerOfDamage.playMusic();
                    HUD.HEALTH -= 99999999;
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Game.playerOfDamage.stopMusic();
                        }
                    }, 1000);
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        if (Objects.equals(Menu.skin, "creeper")) {
            g.setColor(Color.GREEN);
            g.fillRect((int) dax, (int) day, 32, 32);
            g.setColor(Color.BLACK);
            g.fillRect((int) dax + 4, (int) day + 4, 9, 9);
            g.fillRect((int) dax + 19, (int) day + 4, 9, 9);
            g.fillRect((int) dax + 13, (int) day + 12, 6, 14);
            g.fillRect((int) dax + 8, (int) day + 16, 5, 14);
            g.fillRect((int) dax + 19, (int) day + 16, 5, 14);
        } else if (Objects.equals(Menu.skin, "plain")) {
            g.setColor(Color.WHITE);
            g.fillRect((int) dax, (int) day, 32, 32);
        } else if (Objects.equals(Menu.skin, "zombie")) {
            g.setColor(new Color(5, 97, 2));
            g.fillRect((int) dax, (int) day, 32, 32);
            g.setColor(new Color(2, 153, 75));
            g.fillRect((int) dax + 4, (int) day + 8, 20, 16);
            g.fillRect((int) dax + 16, (int) day + 28, 8, 4);
            g.fillRect((int) dax + 4, (int) day, 8, 4);
            g.fillRect((int) dax + 28, (int) day + 8, 4, 4);
            g.fillRect((int) dax, (int) day + 16, 4, 4);
            g.fillRect((int) dax + 4, (int) day + 28, 4, 4);
            g.fillRect((int) dax + 24, (int) day, 4, 4);
            g.setColor(Color.BLACK);
            g.fillRect((int) dax + 4, (int) day + 14, 8, 4);
            g.fillRect((int) dax + 20, (int) day + 14, 8, 4);
            g.setColor(new Color(5, 97, 2));
            g.fillRect((int) dax + 12, (int) day + 18, 8, 4);
        } else if (Objects.equals(Menu.skin, "skeleton")) {
            g.setColor(new Color(135, 135, 135));
            g.fillRect((int) dax, (int) day, 32, 32);
            g.setColor(Color.BLACK);
            g.fillRect((int) dax + 4, (int) day + 16, 8, 4);
            g.fillRect((int) dax + 20, (int) day + 16, 8, 4);
            g.fillRect((int) dax + 4, (int) day + 24, 24, 4);
        } else if (Objects.equals(Menu.skin, "enderman")) {
            g.setColor(new Color(36, 36, 36));
            g.fillRect((int) dax, (int) day, 32, 32);
            g.setColor(new Color(232, 3, 252));
            g.fillRect((int) dax, (int) day + 16, 12, 4);
            g.fillRect((int) dax + 20, (int) day + 16, 12, 4);
        } else if (Objects.equals(Menu.skin, "gift package")) {
            g.setColor(Color.GREEN);
            g.fillRect((int) dax, (int) day, 32, 32);
            g.setColor(Color.RED);
            g.fillRect((int) dax + 14, (int) day, 6, 32);
            g.fillOval((int) dax + 4, (int) day - 8, 12, 8);
            g.fillOval((int) dax + 18, (int) day - 8, 12, 8);
            g.fillOval((int) dax + 14, (int) day - 4, 6, 6);
        }
        if (forceField) {
            g.setColor(Color.YELLOW);
            g.drawOval((int) dax - 16, (int) day - 16, 64, 64);
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", 1, 15));
        g.drawString(Menu.playerName, (int) dax , (int) day - 16);
    }
}
