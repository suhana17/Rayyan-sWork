import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class demoHUD {

    public static boolean renderThis = true;

    private int angle;

    private boolean da = true;

    Timer timer = new Timer();

    public void tick() {
        if (angle != 360) angle++;
        else {
            if (da) {
                timer.schedule(new TimerTask() {
                    public void run() {
                        timer.cancel();
                        if (angle != 0) angle--;
                        else renderThis = false;
                    }
                }, 1000);
                da = false;
            }
            if (angle != 0) angle--;
            else {
                Menu.showStart = true;
                renderThis = false;
            }
        }
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                renderThis = false;
                timer.cancel();
            }
        }, 1500);
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(56, 166, 69));
        g2d.setStroke(new BasicStroke(5));
        g2d.drawArc(Game.WIDTH / 2 - (Game.WIDTH / 8), Game.HEIGHT / 2, Game.WIDTH / 4, Game.WIDTH / 4, Game.WIDTH / 2 - (Game.WIDTH / 8), angle);
        
        g2d.setFont(new Font("arial", 1, Game.WIDTH / 35);
        g2d.setColor(Color.WHITE);
        g2d.drawString("Welcome!", Game.WIDTH / 2 - (Game.WIDTH / 15), Game.HEIGHT / 2);
    }
}
