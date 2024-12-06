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
                } else if (hud.getLevel() == 12) {
                    handler.clearEnemies();
                    handler.addObject(new Enemy2Boss(Game.WIDTH / 2, -240, ID.Enemy2Boss, handler));
                } else if (hud.getLevel() == 14) {
                    handler.clearEnemies();
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, false, ID.SmartEnemy, handler));
                    handler.addObject(new BasicEnemy(16, 0, ID.BasicEnemy, handler));
                    handler.addObject(new BasicEnemy(Game.WIDTH - 16, 0, ID.BasicEnemy, handler));
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                } else if (hud.getLevel() == 15) {
                    handler.clearEnemies();
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                    hud.dading = 250;
                } else if (hud.getLevel() == 16) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 17) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 18) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 19) {
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 20) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 21) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 22) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 23) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                    hud.dading = 750;
                } else if (hud.getLevel() == 24) {
                    handler.clearEnemies();
                    hud.dading = 500;
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, false, ID.SmartEnemy, handler));
                    handler.addObject(new MovingWall(Game.WIDTH, 0, ID.MovingWall, handler));
                    handler.addObject(new MovingWall2(Game.WIDTH, 0, ID.MovingWall, handler));
                } else if (hud.getLevel() == 25) {
                    handler.addObject(new MovingWall(Game.WIDTH, 0, ID.MovingWall, handler));
                    handler.addObject(new MovingWall2(Game.WIDTH, 0, ID.MovingWall, handler));
                } else if (hud.getLevel() == 26) {
                    handler.addObject(new MovingWall(Game.WIDTH, 0, ID.MovingWall, handler));
                    handler.addObject(new MovingWall2(Game.WIDTH, 0, ID.MovingWall, handler));
                } else if (hud.getLevel() == 27) {
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                    handler.addObject(new MovingWall(Game.WIDTH, 0, ID.MovingWall, handler));
                    handler.addObject(new MovingWall2(Game.WIDTH, 0, ID.MovingWall, handler));
                } else if (hud.getLevel() == 28) {
                    handler.addObject(new MovingWall(Game.WIDTH, 0, ID.MovingWall, handler));
                    handler.addObject(new MovingWall2(Game.WIDTH, 0, ID.MovingWall, handler));
                } else if (hud.getLevel() == 29) {
                    handler.addObject(new MovingWall(Game.WIDTH, 0, ID.MovingWall, handler));
                    handler.addObject(new MovingWall2(Game.WIDTH, 0, ID.MovingWall, handler));
                } else if (hud.getLevel() == 30) {
                    handler.clearEnemies();
                    handler.addObject(new Enemy3Boss(Game.WIDTH / 2, -240, ID.Enemy3Boss, handler));
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
                } else if (hud.getLevel() == 8) {
                    handler.clearEnemies();
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, false, ID.SmartEnemy, handler));
                    handler.addObject(new Enemy1Boss(Game.WIDTH / 2, -240, ID.EnemyBoss, handler));
                } else if (hud.getLevel() == 10) {
                    handler.clearEnemies();
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, false, ID.SmartEnemy, handler));
                    handler.addObject(new Enemy2Boss(Game.WIDTH / 2, -240, ID.Enemy2Boss, handler));
                } else if (hud.getLevel() == 11) {
                    handler.clearEnemies();
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, false, ID.SmartEnemy, handler));
                    handler.addObject(new BasicEnemy(16, 0, ID.BasicEnemy, handler));
                    handler.addObject(new BasicEnemy(Game.WIDTH - 16, 0, ID.BasicEnemy, handler));
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                } else if (hud.getLevel() == 12) {
                    handler.clearEnemies();
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                    hud.dading = 250;
                } else if (hud.getLevel() == 13) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 14) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 15) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 16) {
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 17) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 18) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 19) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 20) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.BasicEnemy, handler));
                    hud.dading = 750;
                } else if (hud.getLevel() == 21) {
                    handler.clearEnemies();
                    hud.dading = 500;
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, false, ID.SmartEnemy, handler));
                    handler.addObject(new MovingWall(Game.WIDTH, 0, ID.MovingWall, handler));
                    handler.addObject(new MovingWall2(Game.WIDTH, 0, ID.MovingWall, handler));
                } else if (hud.getLevel() == 22) {
                    handler.addObject(new MovingWall(Game.WIDTH, 0, ID.MovingWall, handler));
                    handler.addObject(new MovingWall2(Game.WIDTH, 0, ID.MovingWall, handler));
                } else if (hud.getLevel() == 23) {
                    handler.addObject(new MovingWall(Game.WIDTH, 0, ID.MovingWall, handler));
                    handler.addObject(new MovingWall2(Game.WIDTH, 0, ID.MovingWall, handler));
                } else if (hud.getLevel() == 24) {
                    handler.addObject(new Coin(r.nextInt(Game.WIDTH / 2) + 50, r.nextInt(Game.HEIGHT / 2) + 50, ID.Coin, handler));
                    handler.addObject(new MovingWall(Game.WIDTH, 0, ID.MovingWall, handler));
                    handler.addObject(new MovingWall2(Game.WIDTH, 0, ID.MovingWall, handler));
                } else if (hud.getLevel() == 25) {
                    handler.addObject(new MovingWall(Game.WIDTH, 0, ID.MovingWall, handler));
                    handler.addObject(new MovingWall2(Game.WIDTH, 0, ID.MovingWall, handler));
                } else if (hud.getLevel() == 26) {
                    handler.addObject(new MovingWall(Game.WIDTH, 0, ID.MovingWall, handler));
                    handler.addObject(new MovingWall2(Game.WIDTH, 0, ID.MovingWall, handler));
                } else if (hud.getLevel() == 27) {
                    handler.clearEnemies();
                    handler.addObject(new Enemy3Boss(Game.WIDTH / 2, -240, ID.Enemy3Boss, handler));
                }
            }
        }
        if (Game.gameState != Game.STATE.Game) {
            scoreKeep = 0;
        }
    }
}
