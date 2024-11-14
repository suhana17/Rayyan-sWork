import java.awt.*;
import java.util.Random;

public class Enemy2Boss extends GameObject {

    private Handler handler;

    private boolean dading = false;

    private int timer = Game.HEIGHT / 9;
    private int timer2 = 50;
    Random r = new Random();

    public Enemy2Boss(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 0;
        velY = 2;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 128, 128);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (timer <= 0) velY = 0;
        else timer--;

        if (timer <= 0) timer2--;
        if (timer2 <= 0) {
            velX = Game.clamp(velX, -10, 10);
            if (!dading) {
                for (int i = 0; i < 4; i++)
                    handler.addObject(new Enemy2BossShip((int) x + 96, (int) y + 96, ID.Enemy2BossShip, i, handler));
                dading = true;
            }
            velY = -2;
        }
        if (y == -240) {
            velY = 0;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, 128, 128);
    }
}
