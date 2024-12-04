import java.awt.*;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Player2 extends GameObject {

    Handler handler;

    public static int dajing = 2;

    private static String otherSkin;

    private static String otherName;

    public static boolean isTouchingHUD1 = false;

    public static boolean isTouchingHUD2 = false;

    public static int dax;

    public static int day;

    public static boolean isTouchingInfo = false;

    public Player2(int x, int y, ID id, String otherSkin, String otherName, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.x = dax;
        this.y = day;
        this.otherSkin = otherSkin;
        this.otherName = otherName;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    @Override
    public void tick() {
        x = dax;
        y = day;

        dax += velX;
        day += velY;

        x = (int) Game.clamp(x, 0, Game.WIDTH - 48);
        y = (int) Game.clamp(y, 0, Game.HEIGHT - 71);

        dax = (int) Game.clamp(dax, 0, Game.WIDTH - 48);
        day = (int) Game.clamp(day, 0, Game.HEIGHT - 71);

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

        isTouchingHUD1 = (dax >= Game.WIDTH / 4 - ((200 + HUD.bounds) / 2) - 32 && dax <= Game.WIDTH / 4 + ((200 + HUD.bounds) / 2)) && (day >= 0 && day <= 32);

        isTouchingHUD2 = (dax >= Game.WIDTH - (Game.WIDTH / 4) - ((200 + HUD.bounds) / 2) - 32 && dax <= Game.WIDTH - (Game.WIDTH / 4) + ((200 + HUD.bounds) / 2)) && (day >= 0 && day <= 32);

        isTouchingInfo = (dax >= 0 & dax <= 330) && (day >= Game.HEIGHT - 170 && day <= Game.HEIGHT);

        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject;
            if (handler.object.get(i) != null) {} tempObject = handler.object.get(i);
            if (tempObject != null) {
                if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy) {
                    if (getBounds().intersects(tempObject.getBounds())) {
                        if (Menu.volume) Game.playerOfDamage.playMusic();
                        HUD.P2HEALTH -= dajing;
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Game.playerOfDamage.stopMusic();
                            }
                        }, 1000);
                    }
                }
    
                if (tempObject.getId() == ID.Enemy2BossShip || tempObject.getId() == ID.EnemyBoss) {
                    if (getBounds().intersects(tempObject.getBounds())) {
                        if (Menu.volume) Game.playerOfDamage.playMusic();
                        HUD.P2HEALTH -= 99999999;
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
    }

    @Override
    public void render(Graphics g) {
        if (Game.PlayerMode2) {
            g.setColor(Color.WHITE);
            g.fillRect((int) dax, (int) day, 32, 32);
            g.setFont(new Font("arial", 1, Game.WIDTH / 75));
            g.drawString("P2: ", (int) dax, (int) day - 16);
        }
    }
}
