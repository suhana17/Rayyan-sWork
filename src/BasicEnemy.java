import java.awt.*;

public class BasicEnemy extends GameObject {

    private Handler handler;

    public static int dax;

    public static int day;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.x = dax;
        this.y = day;

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

        if (y <= 0 || y >= Game.HEIGHT - 55) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 30) velX *= -1;

        if (Player1.forceField) handler.addObject(new Trail(x, y, 16, 16, ID.Trail, Color.RED, 0.075f, handler));
        else {
            if (!Player1.damageDeal) handler.addObject(new Trail(x, y, 16, 16, ID.Trail, new Color(179, 52, 52), 0.075f, handler));
            else handler.addObject(new Trail(x, y, 16, 16, ID.Trail, Color.RED, 0.075f, handler));
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, 16, 16);
    }
}
