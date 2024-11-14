import java.awt.*;

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
