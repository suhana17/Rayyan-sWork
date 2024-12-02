import java.awt.*;
import java.util.Random;

public class MenuParticle extends GameObject {

    private Handler handler;
    Random r = new Random();
    private Color col;

    int dir = 0;

    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = (r.nextInt(10 - -10)  + -10);
        velY = (r.nextInt(10 - -10)  + -10);
        if (velX == 0) velX = 1;
        if (velY == 0) velY = 1;
        col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    @Override
    public void tick() {
        if (Game.gameState != Game.STATE.Choosing) {
            x += velX;
            y += velY;

            if (y <= 0 || y >= Game.HEIGHT - 55) velY *= -1;
            if (x <= 0 || x >= Game.WIDTH - 30) velX *= -1;

            handler.addObject(new Trail(x, y, 16, 16, ID.Trail, col, 0.1f, handler));
        }
    }

    @Override
    public void render(Graphics g) {
        if (Game.gameState != Game.STATE.Choosing) {
            g.setColor(col);
            g.fillRect((int) x, (int) y, 16, 16);
        }
    }
}
