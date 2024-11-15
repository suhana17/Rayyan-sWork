import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Coin extends GameObject {

    Handler handler;

    private Timer timer;

    public Coin(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        timer = new Timer();
        startDespawnTimer();
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 64, 64);
    }

    @Override
    public void tick() {
        collision();
    }

    private void startDespawnTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                despawn();
            }
        }, 3000);
    }

    private void despawn() {
        handler.object.remove(this);
        timer.cancel();
    }

    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player1) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.p1points += 2;
                    handler.object.remove(this);
                }
            }
            if (tempObject.getId() == ID.Player2) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.p2points += 2;
                    handler.object.remove(this);
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval((int) x, (int) y, 64, 64);
        g.setColor(new Color(255, 136, 0));
        g.setFont(new Font("arial", 1, Game.WIDTH / 85));
        g.drawString("COIN", (int) x + ((int) x / 11) , (int) y + ((int) y / 3));
    }
}
