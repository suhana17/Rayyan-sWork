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

        if (Game.map == 1) {
            // side side (velX)
            if (((x >= Game.WIDTH / 3 && x <= Game.WIDTH / 3 + (Game.WIDTH / 150)) || (x <= Game.WIDTH / 3 + (Game.WIDTH / 3) && x >= Game.WIDTH / 3 + (Game.WIDTH / 3) - (Game.WIDTH / 150))) && (y >= Game.HEIGHT / 2 - (Game.HEIGHT / 4) && y <= Game.HEIGHT / 2 - (Game.HEIGHT / 4) + (Game.HEIGHT / 15))) {
                if (velX < 0) velX = -(r.nextInt(15) + 1) * -1;
                else velX = (r.nextInt(15) + 1) * -1;
            }

            // top bottom (velY)
            if (((y >= Game.HEIGHT / 2 - (Game.HEIGHT / 4) && y <= Game.HEIGHT / 2 - (Game.HEIGHT / 4) + (Game.HEIGHT / 150) || (y <= Game.HEIGHT / 2 - (Game.HEIGHT / 4) + (Game.HEIGHT / 15) && y >= Game.HEIGHT / 2 - (Game.HEIGHT / 4) + (Game.HEIGHT / 15) - (Game.HEIGHT / 150)))) && (x >= Game.WIDTH / 3 && x <= Game.WIDTH / 3 + (Game.WIDTH / 3))) {
                if (velY < 0) velY = -(r.nextInt(15) + 1) * -1;
                else velY = (r.nextInt(15) + 1) * -1;
            }
        }

        if (Game.map == 3) {
            // side side (velX)
            if (((x >= Game.WIDTH / 2 - (Game.WIDTH / 15) && x <= Game.WIDTH / 2 - (Game.WIDTH / 15) + (Game.WIDTH / 150)) || (x <= Game.WIDTH / 2 - (Game.WIDTH / 15) + Game.WIDTH / 25 && x >= Game.WIDTH / 2 - (Game.WIDTH / 15) + (Game.WIDTH / 25) - (Game.WIDTH / 150))) && (y >= Game.HEIGHT - (Game.HEIGHT / 5) && y <= Game.HEIGHT)) {
                if (velX < 0) velX = -(r.nextInt(15) + 1) * -1;
                else velX = (r.nextInt(15) + 1) * -1;
            }

            // top bottom (velY)
            if ((y >= Game.HEIGHT - (Game.HEIGHT / 5) && y <= Game.HEIGHT - (Game.HEIGHT / 5) + (Game.HEIGHT / 150)) && (x >= Game.WIDTH / 2 - (Game.WIDTH / 15) && x <= Game.WIDTH / 2 - (Game.WIDTH / 15) + (Game.WIDTH / 25))) {
                if (velY < 0) velY = -(r.nextInt(15) + 1) * -1;
                else velY = (r.nextInt(15) + 1) * -1;
            }

            // other wall
            if ((x >= Game.WIDTH - (Game.WIDTH / 6) - 32 && x <= Game.WIDTH - (Game.WIDTH / 6) + (Game.WIDTH / 150)) && (y >= Game.HEIGHT / 3 && y <= Game.HEIGHT / 3 + (Game.HEIGHT / 13))) {
                if (velX < 0) velX = -(r.nextInt(15) + 1) * -1;
                else velX = (r.nextInt(15) + 1) * -1;
            }

            if (((y >= Game.HEIGHT / 3 - 32 && y <= Game.HEIGHT / 3 + (Game.HEIGHT / 150)) || (y <= Game.HEIGHT / 3 + (Game.HEIGHT / 13) && y >= Game.HEIGHT / 3 + (Game.HEIGHT / 13) - (Game.HEIGHT / 150))) && (x >= Game.WIDTH - (Game.WIDTH / 6) && x <= Game.WIDTH)) {
                if (velY < 0) velY = -(r.nextInt(15) + 1) * -1;
                else velY = (r.nextInt(15) + 1) * -1;
            }
        }

        if (Game.map == 5) {
            // right wall
            if (((y >= Game.HEIGHT - (Game.HEIGHT / 3) && y <= Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 150)) || (y <= Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 15) && y >= Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 15) - (Game.HEIGHT / 150))) && (x >= 0 && x <= Game.WIDTH / 4)) {
                if (velY < 0) velY = -(r.nextInt(15) + 1) * -1;
                else velY = (r.nextInt(15) + 1) * -1;
            }

            if ((x <= Game.WIDTH / 4 && x >= Game.WIDTH / 4 - (Game.WIDTH / 150)) && (y >= Game.HEIGHT - (Game.HEIGHT / 3) && y <= Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 15))) {
                if (velY < 0) velY = -(r.nextInt(15) + 1) * -1;
                else velY = (r.nextInt(15) + 1) * -1;
            }

            // bottom wall
            if (((x >= Game.WIDTH / 2 + (Game.WIDTH / 25) && x <= Game.WIDTH / 2 + (Game.WIDTH / 25) + (Game.WIDTH / 150)) || (x <= Game.WIDTH / 2 + (Game.WIDTH / 25) && x >= Game.WIDTH / 2 + (Game.WIDTH / 25) - (Game.WIDTH / 150))) && (y >= Game.HEIGHT - (Game.HEIGHT / 3) && y <= Game.HEIGHT)) {
                if (velX < 0) velX = -(r.nextInt(15) + 1) * -1;
                else velX = (r.nextInt(15) + 1) * -1;
            }

            if ((y >= Game.HEIGHT - (Game.HEIGHT / 3) && y <= Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 150)) && (x >= Game.WIDTH / 2 + (Game.WIDTH / 25) && x <= Game.WIDTH / 2 + (Game.WIDTH / 25) + Game.WIDTH / 30)) {
                if (velY < 0) velY = -(r.nextInt(15) + 1) * -1;
                else velY = (r.nextInt(15) + 1) * -1;
            }

            // right wall
            if (((x >= Game.WIDTH - (Game.WIDTH / 3) && x <= Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 150)) || (x <= Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 30) && x >= Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 30) - (Game.WIDTH / 150))) && (y >= 0 && y <= Game.HEIGHT / 3)) {
                if (velX < 0) velX = -(r.nextInt(15) + 1) * -1;
                else velX = (r.nextInt(15) + 1) * -1;
            }

            if ((y <= Game.HEIGHT / 3 && y >= Game.HEIGHT / 3 - (Game.HEIGHT / 150)) && (x >= Game.WIDTH - (Game.WIDTH / 3) && x <= Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 30))) {
                if (velY < 0) velY = -(r.nextInt(15) + 1) * -1;
                else velY = (r.nextInt(15) + 1) * -1;
            }
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
