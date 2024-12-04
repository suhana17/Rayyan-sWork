import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class demoHUD {

    public static boolean renderThis = true;

    private int angle;

    private boolean da = true;

    Timer timer = new Timer();

    public void tick() {
        if (da && angle != 360) angle += 3;
        else {
            da = false;
//            if (da) {
//                timer.schedule(new TimerTask() {
//                    public void run() {
//                        timer.cancel();
//                        if (angle >= 360) {
//                            angle = 360;
//                            angle -= 5;
//                        }
//                    }
//                }, 1000);
//                da = false;
//            }
            angle -= 6;
            if (angle <= 0) {
                Menu.showStart = true;
                renderThis = false;
            }
        }
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(56, 166, 69));
        g2d.setStroke(new BasicStroke(25));
        g2d.drawArc(Game.WIDTH / 2 - (Game.WIDTH / 8), Game.HEIGHT / 4, Game.WIDTH / 4, Game.WIDTH / 4, Game.WIDTH / 2 - (Game.WIDTH / 8), angle);
        
        g2d.setFont(new Font("arial", 1, Game.WIDTH / 35));
        g2d.setColor(Color.WHITE);
        g2d.drawString("Welcome!", Game.WIDTH / 2 - (Game.WIDTH / 15), Game.HEIGHT / 2);
    }
}
