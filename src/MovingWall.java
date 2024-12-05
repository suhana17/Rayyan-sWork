import java.awt.*;
import javax.swing.*;

public class MovingWall extends GameObject {
    Handler handler;
  
    public MovingWall(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        // change this value
        velX = -5;
        // not this one
        velY = 0;
    }

    @Override
    public Rectangle getBounds() { return new Rectangle((int) x, (int) y, Game.WIDTH / 15, Game.HEIGHT); }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (x < 0) handler.removeObject(this);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, Game.WIDTH / 15, Game.HEIGHT);
    }
}
