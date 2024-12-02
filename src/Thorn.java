import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Objects;

public class Thorn extends GameObject {

    Handler handler;

    String direction;

    Image image = new ImageIcon("images/thorn.png").getImage();;

    public Thorn(int x, int y, ID id, String direction, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.direction = direction;

        if (Objects.equals(direction, "straight forward")) image = new ImageIcon("images/thorn.png").getImage();
        if (Objects.equals(direction, "right")) image = new ImageIcon("images/thornRight.png").getImage();
        if (Objects.equals(direction, "left")) image = new ImageIcon("images/thornLeft.png").getImage();
        if (Objects.equals(direction, "backward")) image = new ImageIcon("images/thornBack.png").getImage();
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(image, (int) x, (int) y, 60, 70, null);
    }

    @Override
    public Rectangle getBounds() {
        if (Objects.equals(direction, "straight forward") || Objects.equals(direction, "backward")) return new Rectangle((int) x, (int) y, 60, 70);
        if (Objects.equals(direction, "right") || Objects.equals(direction, "left")) return new Rectangle((int) x, (int) y, 70, 60);
        return new Rectangle((int) x, (int) y,70, 70);
    }
}
