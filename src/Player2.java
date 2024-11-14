import java.awt.*;

public class Player2 extends GameObject {

    Handler handler;

    public static int dajing = 2;

    public static boolean isTouchingHUD1 = false;

    public static boolean isTouchingHUD2 = false;

    public static boolean isTouchingInfo = false;

    public Player2(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = (int) Game.clamp(x, 0, Game.WIDTH - 48);
        y = (int) Game.clamp(y, 0, Game.HEIGHT - 71);

        isTouchingHUD1 = (x >= Game.WIDTH / 4 - ((200 + HUD.bounds) / 2) - 32 && x <= Game.WIDTH / 4 + ((200 + HUD.bounds) / 2)) && (y >= 0 && y <= 32);

        isTouchingHUD2 = (x >= Game.WIDTH - (Game.WIDTH / 4) - ((200 + HUD.bounds) / 2) - 32 && x <= Game.WIDTH - (Game.WIDTH / 4) + ((200 + HUD.bounds) / 2)) && (y >= 0 && y <= 32);

        isTouchingInfo = (x >= 0 & x <= 330) && (y >= Game.HEIGHT - 170 && y <= Game.HEIGHT);

        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.P2HEALTH -= dajing;
                }
            }

            if (tempObject.getId() == ID.Enemy2BossShip || tempObject.getId() == ID.EnemyBoss) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.P2HEALTH -= 99999999;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int) x, (int) y, 32, 32);
        g.setFont(new Font("arial", 1, Game.WIDTH / 75));
        g.drawString("P2: ", (int) x, (int) y - 16);
    }
}
