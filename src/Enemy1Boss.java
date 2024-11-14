import java.awt.*;
import java.util.Random;

public class Enemy1Boss extends GameObject {

    private Handler handler;

    private int timer = Game.HEIGHT / 9;
    private int timer2 = 50;
    Random r = new Random();

    public Enemy1Boss(int x, int y, ID id, Handler handler) {
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
            if (velX == 0) velX = 2;
            if (velX > 0) velX += 0.01f;
            else if (velX < 0) velX -= 0.01f;

            velX = Game.clamp(velX, -10, 10);
            int spawn = r.nextInt(5);
            if (spawn == 0) handler.addObject(new EnemyBossBullet((int) x + 96, (int) y + 96, ID.BasicEnemy, handler));
        }
        if (x <= 0 || x >= Game.WIDTH - 140) velX *= -1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect((int) x, (int) y, 128, 128);
    }
}
