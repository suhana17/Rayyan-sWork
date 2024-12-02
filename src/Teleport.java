import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.Key;
import java.util.Timer;
import java.util.TimerTask;

public class Teleport extends MouseAdapter {

    Handler handler;

    public static boolean done = false;

    public static int x;

    public static int y;

    Timer timer = new Timer();

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    public void tick() {
        if (!done) x = MouseInfo.getPointerInfo().getLocation().x;
        if (!done) y = MouseInfo.getPointerInfo().getLocation().y;
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        if (!done) g2d.setColor(Color.WHITE);
        else g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(5));
        g2d.setFont(new Font("arial", 1, Game.WIDTH / 35));


        g2d.drawRect((int) x, (int) y, 32, 32);
        g2d.setColor(Color.WHITE);
        g2d.drawString("Choose a point to teleport.", Game.WIDTH / 2 - (Game.WIDTH / 6), Game.HEIGHT / 10);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        x = mx;
        y = my;

        done = true;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                done = false;
                Player1.dax = x;
                Player1.day = y;
                if (Shop.teleport1) KeyInput.t1On = false;
                if (Shop.teleport2) KeyInput.t2On = false;
            }
        }, 1000);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}