import java.awt.*;
import java.util.Random;

public class FastEnemy extends GameObject {

    private Handler handler;

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 3;
        velY = 30;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 55) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 30) velX *= -1;

        if (Game.map == 1) {
            // side side (velX)
            if (((x >= Game.WIDTH / 3 && x <= Game.WIDTH / 3 + (Game.WIDTH / 150)) || (x <= Game.WIDTH / 3 + (Game.WIDTH / 3) && x >= Game.WIDTH / 3 + (Game.WIDTH / 3) - (Game.WIDTH / 150))) && (y >= Game.HEIGHT / 2 - (Game.HEIGHT / 4) && y <= Game.HEIGHT / 2 - (Game.HEIGHT / 4) + (Game.HEIGHT / 15))) velX *= -1;

            // top bottom (velY)
            if (((y >= Game.HEIGHT / 2 - (Game.HEIGHT / 4) && y <= Game.HEIGHT / 2 - (Game.HEIGHT / 4) + (Game.HEIGHT / 150) || (y <= Game.HEIGHT / 2 - (Game.HEIGHT / 4) + (Game.HEIGHT / 15) && y >= Game.HEIGHT / 2 - (Game.HEIGHT / 4) + (Game.HEIGHT / 15) - (Game.HEIGHT / 150)))) && (x >= Game.WIDTH / 3 && x <= Game.WIDTH / 3 + (Game.WIDTH / 3))) velY *= -1;
        }

        if (Game.map == 3) {
            // side side (velX)
            if (((x >= Game.WIDTH / 2 - (Game.WIDTH / 15) && x <= Game.WIDTH / 2 - (Game.WIDTH / 15) + (Game.WIDTH / 150)) || (x <= Game.WIDTH / 2 - (Game.WIDTH / 15) + Game.WIDTH / 25 && x >= Game.WIDTH / 2 - (Game.WIDTH / 15) + (Game.WIDTH / 25) - (Game.WIDTH / 150))) && (y >= Game.HEIGHT - (Game.HEIGHT / 5) && y <= Game.HEIGHT)) velX *= -1;

            // top bottom (velY)
            if ((y >= Game.HEIGHT - (Game.HEIGHT / 5) && y <= Game.HEIGHT - (Game.HEIGHT / 5) + (Game.HEIGHT / 150)) && (x >= Game.WIDTH / 2 - (Game.WIDTH / 15) && x <= Game.WIDTH / 2 - (Game.WIDTH / 15) + (Game.WIDTH / 25))) velY *= -1;

            // other wall
            if ((x >= Game.WIDTH - (Game.WIDTH / 6) - 32 && x <= Game.WIDTH - (Game.WIDTH / 6) + (Game.WIDTH / 150)) && (y >= Game.HEIGHT / 3 && y <= Game.HEIGHT / 3 + (Game.HEIGHT / 13))) velX *= -1;

            if (((y >= Game.HEIGHT / 3 - 32 && y <= Game.HEIGHT / 3 + (Game.HEIGHT / 150)) || (y <= Game.HEIGHT / 3 + (Game.HEIGHT / 13) && y >= Game.HEIGHT / 3 + (Game.HEIGHT / 13) - (Game.HEIGHT / 150))) && (x >= Game.WIDTH - (Game.WIDTH / 6) && x <= Game.WIDTH)) velY *= -1;
        }

        if (Game.map == 4) {
            // right wall
            if (((y >= Game.HEIGHT - (Game.HEIGHT / 3) && y <= Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 150)) || (y <= Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 15) && y >= Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 15) - (Game.HEIGHT / 150))) && (x >= 0 && x <= Game.WIDTH / 4)) velY *= -1;

            if ((x <= Game.WIDTH / 4 && x >= Game.WIDTH / 4 - (Game.WIDTH / 150)) && (y >= Game.HEIGHT - (Game.HEIGHT / 3) && y <= Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 15))) velX *= -1;

            // bottom wall
            if (((x >= Game.WIDTH / 2 + (Game.WIDTH / 25) && x <= Game.WIDTH / 2 + (Game.WIDTH / 25) + (Game.WIDTH / 150)) || (x <= Game.WIDTH / 2 + (Game.WIDTH / 25) && x >= Game.WIDTH / 2 + (Game.WIDTH / 25) - (Game.WIDTH / 150))) && (y >= Game.HEIGHT - (Game.HEIGHT / 3) && y <= Game.HEIGHT)) velX *= -1;

            if ((y >= Game.HEIGHT - (Game.HEIGHT / 3) && y <= Game.HEIGHT - (Game.HEIGHT / 3) + (Game.HEIGHT / 150)) && (x >= Game.WIDTH / 2 + (Game.WIDTH / 25) && x <= Game.WIDTH / 2 + (Game.WIDTH / 25) + Game.WIDTH / 30)) velY *= -1;

            // right wall
            if (((x >= Game.WIDTH - (Game.WIDTH / 3) && x <= Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 150)) || (x <= Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 30) && x >= Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 30) - (Game.WIDTH / 150))) && (y >= 0 && y <= Game.HEIGHT / 3)) velX *= -1;

            if ((y <= Game.HEIGHT / 3 && y >= Game.HEIGHT / 3 - (Game.HEIGHT / 150)) && (x >= Game.WIDTH - (Game.WIDTH / 3) && x <= Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 30))) velY *= -1;
        }

        if (Player1.forceField) handler.addObject(new Trail(x, y, 16, 16, ID.Trail, Color.CYAN, 0.1f, handler));
        else {
            if (!Player1.damageDeal)
                handler.addObject(new Trail(x, y, 16, 16, ID.Trail, new Color(38, 171, 162), 0.1f, handler));
            else handler.addObject(new Trail(x, y, 16, 16, ID.Trail, Color.CYAN, 0.1f, handler));
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int) x, (int) y, 16, 16);
    }
}
