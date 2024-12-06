import javax.swing.*;
import java.awt.*;

public class DamageOrb extends GameObject {

    Handler handler;

    Image orb = new ImageIcon("images/damageOrb.png").getImage();

    public DamageOrb(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (x < 0 || x > Game.WIDTH || y > Game.HEIGHT) handler.removeObject(this);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(orb, (int) x, (int) y, 48, 48, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 48, 48);
    }
}
