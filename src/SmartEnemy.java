import java.awt.*;

public class SmartEnemy extends GameObject {

    private Handler handler;

    private boolean playerToGoTo;

    private GameObject player;

    private GameObject player2;

    public SmartEnemy(int x, int y, boolean playerToGoTo, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.playerToGoTo = playerToGoTo;

        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ID.Player1) player = handler.object.get(i);
            if (handler.object.get(i).getId() == ID.Player2) player2 = handler.object.get(i);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        float diffX;
        float diffY;
        float distance;
        if (!playerToGoTo) {
            diffX = x - player.getX() - 8;
            diffY = y - player.getY() - 12;
            distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
        } else {
            diffX = x - player2.getX() - 8;
            diffY = y - player2.getY() - 12;
            distance = (float) Math.sqrt((x - player2.getX()) * (x - player2.getX()) + (y - player2.getY()) * (y - player2.getY()));
        }
        velX = ((-1 / distance) * diffX);
        velY = ((-1 / distance) * diffY);


//        if (y <= 0 || y >= Game.HEIGHT - 55) velY *= -1;
//        if (x <= 0 || x >= Game.WIDTH - 30) velX *= -1;

        if (Player1.forceField) handler.addObject(new Trail(x, y, 16, 16, ID.Trail, Color.GREEN, 0.025f, handler));
        else {
            if (!Player1.damageDeal)
                handler.addObject(new Trail(x, y, 16, 16, ID.Trail, new Color(31, 173, 62), 0.025f, handler));
            else handler.addObject(new Trail(x, y, 16, 16, ID.Trail, Color.GREEN, 0.025f, handler));
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int) x, (int) y, 16, 16);
    }
}
