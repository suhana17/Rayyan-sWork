import java.awt.*;

public class Wall extends GameObject {

    int width, height;

    Handler handler;

    public Wall(int x, int y, int width, int height, ID id, Handler handler) {
        super(x, y, id);
        this.width = width;
        this.height = height;
        this.handler = handler;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        System.out.println("bello");
        g.setColor(Color.GRAY);
        g.fillRect((int) x, (int) y, width, height);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, width, height);
    }
}
