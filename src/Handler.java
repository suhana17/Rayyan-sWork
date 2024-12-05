import java.awt.*;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class Handler {

    public int speed = 8;

    public int speed2 = 8;

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        if (Game.gameState == Game.STATE.Game) {
            if (HUD.tickdatock) {
                for (int i = 0; i < object.size(); i++) {
                    GameObject tempObject = object.get(i);

                    tempObject.tick();
                }
            }
        } else {
            for (int i = 0; i < object.size(); i++) {
                GameObject tempObject = object.get(i);

                if (tempObject != null) tempObject.tick();
            }
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size() - 1; i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void clearEnemies() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            if (tempObject.getId() == ID.Player1) {
                object.clear();
                if (Game.gameState != Game.STATE.End)
                    addObject(new Player1(Game.WIDTH / 2, Game.HEIGHT / 2, ID.Player1, this));
            }
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

}
