import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class demoHUD {

    public static int health = 100;

    private int bounds = 0;

    public static boolean renderThis = true;

    public void tick() {
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(Game.WIDTH / 2 - ((200 + bounds) / 2), Game.HEIGHT / 5, 200 + bounds, 32);
        g.setColor(Color.GREEN);
        g.fillRect(Game.WIDTH / 2 - ((200 + bounds) / 2), Game.HEIGHT / 5, health*2, 32);
    }
}
