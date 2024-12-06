import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class MovingWall2 extends GameObject {
    Handler handler;

    public MovingWall2(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
      
        // change this value
        velX = -5;
        // not this one
        velY = 0;
    }

    @Override
    public Rectangle getBounds() { return new Rectangle((int) x, (int) y + MovingWall.holeY + 64, Game.WIDTH / 22, Game.HEIGHT - MovingWall.holeY); }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (x < 0) handler.removeObject(this);

    }

    @Override
    public void render(Graphics g) {
        if (Player1.forceField) {
            g.setColor(Color.RED);
            g.fillRect((int) x, (int) y, Game.WIDTH / 22, Game.HEIGHT - MovingWall.holeY);
        } else {
            if (!Player1.damageDeal) {
                g.setColor(new Color(179, 52, 52));
                g.fillRect((int) x, (int) y, Game.WIDTH / 22, Game.HEIGHT - MovingWall.holeY);
            } else {
                g.setColor(Color.RED);
                g.fillRect((int) x, (int) y, Game.WIDTH / 22, Game.HEIGHT - MovingWall.holeY);
            }
        }
    }
}
