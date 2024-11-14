import java.awt.*;
import java.util.Random;

public class Enemy2BossShip extends GameObject {

    private int index;
    private Handler handler;

    private int timer = Game.HEIGHT / 9;
    private int timer2 = 50;
    Random r = new Random();

    public Enemy2BossShip(int x, int y, ID id, int index, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.index = index;

        velX = 0;
        velY = index - 1;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (timer <= 0) velY = 0;
        else timer--;

        if (timer <= 0) timer2--;
        if (timer2 <= 0) {
            if (velX == 0) velX = index + 1;
            if (velX > 0) velX += 0.01f;
            else if (velX < 0) velX -= 0.01f;

            velX = Game.clamp(velX, -10, 10);
            int spawn = r.nextInt(20);
            if (spawn == 0) handler.addObject(new EnemyBossBullet((int) x + 24, (int) y + 24, ID.BasicEnemy, handler));
        }
        if (x <= 0 || x >= Game.WIDTH - 44) velX *= -1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, 16, 16);
        g.fillRect((int) x + 32, (int) y, 16, 16);
        g.fillRect((int) x + 16, (int) y - 16, 16, 16);
        g.fillRect((int) x + 16, (int) y, 16, 16);
        g.fillRect((int) x + 16, (int) y + 16, 16, 16);
        g.fillRect((int) x, (int) y + 16, 16, 16);
        g.fillRect((int) x + 32, (int) y + 16, 16, 16);
        g.fillRect((int) x, (int) y + 32, 16, 16);
        g.fillRect((int) x + 32, (int) y + 32, 16, 16);
        g.fillRect((int) x + 8, (int) y + 48, 8, 8);
        g.fillRect((int) x + 32, (int) y + 48, 8, 8);
    }
}
