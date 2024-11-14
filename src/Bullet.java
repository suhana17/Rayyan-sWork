import java.awt.*;
import java.util.Objects;

public class Bullet extends GameObject {

    Handler handler;
    String direction;
    public Bullet(int x, int y, String direction, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.direction = direction;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (Objects.equals(direction, "U")) {
            velX = 0;
            velY = -6;
        }
        if (Objects.equals(direction, "D")) {
            velX = 0;
            velY = 6;
        }
        if (Objects.equals(direction, "R")) {
            velX = 6;
            velY = 0;
        }
        if (Objects.equals(direction, "L")) {
            velX = -6;
            velY = 0;
        }

        if (x >= Game.WIDTH + 50 || x <= 0 || y >= Game.HEIGHT + 75 || y <= 0) {
            handler.removeObject(this);
        }

        handler.addObject(new Trail(x, y, 16, 16, ID.Trail, Color.GRAY, 0.1f, handler));

        collision();
    }

    private void collision() {
        for (int i = 1; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i - 1);

            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(tempObject);
                    handler.removeObject(this);
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect((int) x, (int) y, 16, 16);
    }
}
