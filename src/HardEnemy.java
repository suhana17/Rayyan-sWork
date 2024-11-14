import java.awt.*;
import java.util.Random;

public class HardEnemy extends GameObject {
    private Handler handler;
    private Random r = new Random();

    public HardEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 8;
        velY = 8;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 55) {
            if (velY < 0) velY = -(r.nextInt(15) + 1) * -1;
            else velY = (r.nextInt(15) + 1) * -1;
        }
        if (x <= 0 || x >= Game.WIDTH - 30) {
            if (velX < 0) velX = -(r.nextInt(15) + 1) * -1;
            else velX = (r.nextInt(15) + 1) * -1;
        }

        if (x > Game.WIDTH || y > Game.HEIGHT || x < -50 || y < -50) {
            handler.object.remove(this);
            handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
        }

        if (Player1.forceField) handler.addObject(new Trail(x, y, 16, 16, ID.Trail, Color.YELLOW, 0.05f, handler));
        else {
            if (!Player1.damageDeal)
                handler.addObject(new Trail(x, y, 16, 16, ID.Trail, new Color(169, 173, 31), 0.05f, handler));
            else handler.addObject(new Trail(x, y, 16, 16, ID.Trail, Color.YELLOW, 0.05f, handler));
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int) x, (int) y, 16, 16);
    }
}
