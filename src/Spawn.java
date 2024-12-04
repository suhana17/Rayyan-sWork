import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Spawn {

    private Handler handler;
    private HUD hud;

    private Game game;

    public static boolean doit;

    public static int scoreKeep = 0;

    private Random r = new Random();

    public Spawn(Handler handler, HUD hud, Game game) {
        this.handler = handler;
        this.hud = hud;
        this.game = game;
    }

    public void tick() {
        if (doit) scoreKeep++;
        if (scoreKeep >= 2000) {
            scoreKeep = 0;
            HUD.levelUp = true;
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    HUD.levelUp = false;
                }
            }, 3000);
            hud.setLevel(hud.getLevel() + 1);

            if (game.diff == 0) {
                if (hud.getLevel() == 2) {
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, false, ID.SmartEnemy, handler));
                    if (Game.PlayerMode2) handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, true, ID.SmartEnemy, handler));
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 3) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 4) {
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 5) {
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 6) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                }else if (hud.getLevel() == 7) {
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.FastEnemy, handler));
                } else if (hud.getLevel() == 8) {
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.FastEnemy, handler));
                } else if (hud.getLevel() == 10) {
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.FastEnemy, handler));
                } else if (hud.getLevel() == 11) {
                    handler.clearEnemies();
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                    handler.addObject(new Enemy1Boss(Game.WIDTH / 2, -240, ID.EnemyBoss, handler));
                } else if (hud.getLevel() == 15) {
                    handler.clearEnemies();
                    handler.addObject(new Enemy2Boss(Game.WIDTH / 2, -240, ID.Enemy2Boss, handler));
                }
            } else if (game.diff == 1) {
                if (hud.getLevel() == 2) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                    handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 3) {
                    if (Game.PlayerMode2) handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, true, ID.SmartEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, false, ID.SmartEnemy, handler));
                    handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 4) {
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                    handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 5) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.FastEnemy, handler));
                } else if (hud.getLevel() == 6) {
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.FastEnemy, handler));
                } else if (hud.getLevel() == 10) {
                    handler.clearEnemies();
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, false, ID.SmartEnemy, handler));
                    handler.addObject(new Enemy1Boss(Game.WIDTH / 2, -240, ID.EnemyBoss, handler));
                } else if (hud.getLevel() == 15) {
                    handler.clearEnemies();
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, false, ID.SmartEnemy, handler));
                    handler.addObject(new Enemy2Boss(Game.WIDTH / 2, -240, ID.Enemy2Boss, handler));
                }
            }
        }
        if (Game.gameState != Game.STATE.Game) {
            scoreKeep = 0;
        }
    }
}
