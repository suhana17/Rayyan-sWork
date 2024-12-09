import java.awt.*;
import java.util.Objects;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Enemy3Boss extends GameObject {

    private Handler handler;

    private boolean da = true;

    private int timer = Game.HEIGHT / 9;
    private int timer2 = 50;

    public static int HP = 200;

    Random r = new Random();

    Timer timer1 = new Timer();

    public Enemy3Boss(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 0;
        velY = 2;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 128, 128);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (HP <= 0) {
            handler.removeObject(this);
            if (!Game.PlayerMode2 || Game.squadronMode) {
                if (Game.diff == 0) Game.normalWon = true;
                if (Game.diff == 1) Game.hardWon = true;
            } else if (Game.PlayerMode2) {
                if (Game.diff == 0) Game.p2normalWon = true;
                if (Game.diff == 1) Game.p2hardWon = true;
            } else if (Game.squadronMode) {
                // do stuff
            } else if (Game.Mode1v1 || Game.Mode2v2 || Game.Mode3v3 && Objects.equals(HUD.onlinePlayerWon, Menu.playerName)) {
                // do stuff
            }
            Game.gameState = Game.STATE.Finished;
            da = true;
            if (Menu.volume) Game.playerOfOver.playMusic();
            Game.hud.HEALTH = 100;
            Game.hud.P2HEALTH = 100;
//                    hud.revivePrompt = true;
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Game.playerOfOver.stopMusic();
                }
            }, 1000);
            String message = "score : " + HUD.getScore() + " player : " + Menu.playerName;
            int starter = -1;
            for (int i = 0; i < message.length(); i++) {
                if (Character.isDigit(message.charAt(i))) {
                    starter = i;
                    break;
                }
            }

            if (starter != -1) {
                int ender = starter;
                while (ender < message.length() && Character.isDigit(message.charAt(ender))) {
                    ender++;
                }

                String numberInString = message.substring(starter, ender);

                int score = Integer.parseInt(numberInString);
                String name = message.substring(18 + (ender - starter));

                if (score > Server.bestScore) {
                    Server.bestScore = score;
                    Server.bestName = name;
                }
                else if (score > Server.secondBestScore && score < Server.bestScore) {
                    Server.secondBestScore = score;
                    Server.bestName2 = name;
                }
                else if (score > Server.thirdBestScore && score < Server.secondBestScore) {
                    Server.thirdBestScore = score;
                    Server.bestName3 = name;
                }
                else if (score > Server.fourthBestScore && score < Server.thirdBestScore) {
                    Server.fourthBestScore = score;
                    Server.bestName4 = name;
                }
                else if (score > Server.fifthBestScore && score < Server.fourthBestScore) {
                    Server.fifthBestScore = score;
                    Server.bestName5 = name;
                }
            }
            Game.gameState = Game.STATE.End;
            handler.clearEnemies();
            for (int i = 0; i < 30; i++) {
                handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.MenuParticle, handler));
            }
        }

        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                da = false;
            }
        }, 5000);

        if (timer <= 0) velY = 0;
        else timer--;

        if (timer <= 0) timer2--;
        if (timer2 <= 0) {
            if (velX == 0) velX = 2;
            if (velX > 0) velX += 0.01f;
            else if (velX < 0) velX -= 0.01f;

            velX = Game.clamp(velX, -10, 10);
            int spawn = r.nextInt(10);
            if (spawn == 0) handler.addObject(new DamageOrb((int) x + 96, (int) y + 96, ID.DamageOrb, handler));
        }
        if (x <= 128 || x >= Game.WIDTH - 268) velX *= -1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int) x, (int) y, 128, 128);
        g.fillRect((int) x - 128, (int) y + 64, 128, 48);
        g.fillRect((int) x + 128, (int) y + 64, 128, 48);
        g.fillRect((int) x - 128, (int) y + 112, 16, 48);
        g.fillRect((int) x + 128, (int) y + 112, 16, 48);
        g.setColor(Color.RED);
        g.fillRect((int) x - 32, (int) y + 96, 16, 48);
        g.fillRect((int) x - 64, (int) y + 96, 16, 48);
        g.fillRect((int) x + 160, (int) y + 96, 16, 48);
        g.fillRect((int) x + 192, (int) y + 96, 16, 48);
        if (da) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Monospaced", Font.PLAIN, 15));
            g.drawString("Now you are done. Some might", (int) x + 128 + (Game.WIDTH / 15), (int) y + 32);
            g.drawString("address it as you being...", (int) x + 128 + (Game.WIDTH / 15), (int) y + 64);
            g.setFont(new Font("Monospaced", Font.BOLD, 15));
            g.drawString("COOKED.", (int) x + 128 + (Game.WIDTH / 15), (int) y + 96);
        }
        if (!Shop.bulletsOn) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Monospaced", Font.PLAIN, 15));
            g.drawString("Ah, I see you don't have bullets!", (int) x + 128 + (Game.WIDTH / 15), (int) y + 32);
            g.drawString("Tough luck! I see... ", (int) x + 128 + (Game.WIDTH / 15), (int) y + 64);
            g.drawString("It's won't be easy to beat me!", (int) x + 128 + (Game.WIDTH / 15), (int) y + 96);
        }

        // health
        g.setColor(Color.RED);
        g.fillRect((int) x - 36, (int) y + 150, 200, 15);
        g.setColor(Color.GREEN);
        g.fillRect((int) x - 32, (int) y + 150, HP * 2, 15);
    }
}
