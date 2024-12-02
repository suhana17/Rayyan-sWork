import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Load extends GameObject {

    private Handler handler;

    int startX;
    int endX;

    private int secondsTook = 1;

    private float timerTime = 500;

    public Load(int x, int y, int startX, int endX, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.startX = startX;
        this.endX = endX;

        velX = 6;
        velY = 0;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    @Override
    public void tick() {
        if (Menu.cancelled) handler.removeObject(this);

        x += velX;
        y += velY;

        timerTime++;
        if (timerTime / 100 == Math.floor(timerTime / 100)) {
            secondsTook++;
        }

        if (x <= startX || x >= endX) velX *= -1;

        handler.addObject(new Trail(x, y, 16, 16, ID.Trail, Color.GREEN, 0.075f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", 1, Game.WIDTH / 60));
        g.drawString("Loading... " + secondsTook, startX + 30, (int) y - 15);

        g.setColor(Color.GREEN);
        g.fillRect((int) x, (int) y, 16, 16);
    }
}
