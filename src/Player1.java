import java.awt.*;

public class Player1 extends GameObject {

    Handler handler;

    public static int dax;
    public static int day;

    public static boolean isTouchingHUD1 = false;

    public static boolean isTouchingInfo1 = false;

    public static boolean isTouchingHUD21 = false;

    public static boolean isTouchingHUD22 = false;

    public static boolean isTouchingInfo2 = false;

    public static boolean damageDeal = true;

    public static int deactivateTime = 5000;

    public static int forceTime = 15000;

    public static boolean forceField = false;

    public static float dajing = 2;

    public Player1(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.x = dax;
        this.y = day;
        this.handler = handler;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        dax += velX;
        day += velY;

        damageDeal = !forceField;

        x = (int) Game.clamp(x, 0, Game.WIDTH - 48);
        y = (int) Game.clamp(y, 0, Game.HEIGHT - 71);

        dax = (int) Game.clamp(x, 0, Game.WIDTH - 48);
        day = (int) Game.clamp(y, 0, Game.HEIGHT - 71);

        isTouchingHUD1 = (x >= Game.WIDTH / 2 - ((200 + HUD.bounds) / 2) - 32 && x <= Game.WIDTH / 2 + ((200 + HUD.bounds) / 2)) && (y >= 0 && y <= 32);

        // make OTHERS
        isTouchingHUD21 = (x >= Game.WIDTH / 4 - ((200 + HUD.bounds) / 2) - 32 && x <= Game.WIDTH / 4 + ((200 + HUD.bounds) / 2)) && (y >= 0 && y <= 32);

        isTouchingHUD22 = (x >= Game.WIDTH - (Game.WIDTH / 4) - ((200 + HUD.bounds) / 2) - 32 && x <= Game.WIDTH - (Game.WIDTH / 4) + ((200 + HUD.bounds) / 2)) && (y >= 0 && y <= 32);

        isTouchingInfo2 = (x >= 0 & x <= 330) && (y >= Game.HEIGHT - 170 && y <= Game.HEIGHT);

        isTouchingInfo1 = (x >= 0 & x <= 180) && (y >= Game.HEIGHT - 118 && y <= Game.HEIGHT);

        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    if (damageDeal) {
                        HUD.HEALTH -= dajing;
                    }
                }
            }

            if (tempObject.getId() == ID.Enemy2BossShip || tempObject.getId() == ID.EnemyBoss) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 99999999;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int) x, (int) y, 32, 32);
        g.setColor(Color.BLACK);
        g.fillRect((int) x + 4, (int) y + 4, 9, 9);
        g.fillRect((int) x + 19, (int) y + 4, 9, 9);
        g.fillRect((int) x + 13,  (int) y + 12, 6, 14);
        g.fillRect((int) x + 8, (int) y + 16, 5, 14);
        g.fillRect((int) x + 19, (int) y + 16, 5, 14);
        if (forceField) {
            g.setColor(Color.YELLOW);
            g.drawOval((int) x - 16, (int) y - 16, 64, 64);
        }
        if (Game.PlayerMode2) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("arial", 1, Game.WIDTH / 75));
            g.drawString("P1: ", (int) x , (int) y - 16);
        }
    }
}