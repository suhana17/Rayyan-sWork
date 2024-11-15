import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class KeyInput extends KeyAdapter {

    private final Handler handler;

    private boolean d1On = false;

    private boolean d2On = false;

    private boolean f1On = false;

    private boolean f2On = false;

    private boolean dobullets = true;

    private final boolean[] keyDown1 = new boolean[4];

    private final boolean[] keyDown2 = new boolean[4];

    Game game;

    public KeyInput(Handler handler, Game game) {
        this.handler = handler;
        this.game = game;

        keyDown1[0] = false;
        keyDown1[1] = false;
        keyDown1[2] = false;
        keyDown1[3] = false;

        keyDown2[0] = false;
        keyDown2[1] = false;
        keyDown2[2] = false;
        keyDown2[3] = false;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player1) {
                if (key == KeyEvent.VK_UP) {
                    tempObject.setVelY(-handler.speed);
                    keyDown1[0] = true;
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setVelY(handler.speed);
                    keyDown1[1] = true;
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setVelX(handler.speed);
                    keyDown1[2] = true;
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setVelX(-handler.speed);
                    keyDown1[3] = true;
                }
                Timer timer = new Timer();
                if (!Game.PlayerMode2) {
                    if (Shop.bulletsOn) {
                        if (e.isShiftDown()) {
                            if (key == KeyEvent.VK_UP) {
                                if (dobullets) {
                                    handler.addObject(new Bullet(Player1.dax + 8, Player1.day, "U", ID.Bullet, handler));
                                    dobullets = false;
                                    timer.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            dobullets = true;
                                        }
                                    }, 1000);
                                }
                            }
                            if (key == KeyEvent.VK_DOWN) {
                                if (dobullets) {
                                    handler.addObject(new Bullet(Player1.dax + 8, Player1.day + 64, "D", ID.Bullet, handler));
                                    dobullets = false;
                                    timer.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            dobullets = true;
                                        }
                                    }, 1000);
                                }
                            }
                            if (key == KeyEvent.VK_RIGHT) {
                                if (dobullets) {
                                    handler.addObject(new Bullet(Player1.dax + 64, Player1.day + 8, "R", ID.Bullet, handler));
                                    dobullets = false;
                                    timer.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            dobullets = true;
                                        }
                                    }, 1000);
                                }
                            }
                            if (key == KeyEvent.VK_LEFT) {
                                if (dobullets) {
                                    handler.addObject(new Bullet(Player1.dax, Player1.day + 8, "L", ID.Bullet, handler));
                                    dobullets = false;
                                    timer.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            dobullets = true;
                                        }
                                    }, 1000);
                                }
                            }
                        }
                    }
                }
            }
            if (Game.PlayerMode2) {
                if (tempObject.getId() == ID.Player2) {
                    if (key == KeyEvent.VK_W) {
                        tempObject.setVelY(-handler.speed2);
                        keyDown2[0] = true;
                    }
                    if (key == KeyEvent.VK_S) {
                        tempObject.setVelY(handler.speed2);
                        keyDown2[1] = true;
                    }
                    if (key == KeyEvent.VK_A) {
                        tempObject.setVelX(-handler.speed2);
                        keyDown2[2] = true;
                    }
                    if (key == KeyEvent.VK_D) {
                        tempObject.setVelX(handler.speed2);
                        keyDown2[3] = true;
                    }
                }
            }
        }

        if (!Game.PlayerMode2) {
            if (key == KeyEvent.VK_1) {
                if (Shop.deactivate1) {
                    if (!f2On) {
                        d1On = true;
                        Player1.damageDeal = false;
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Player1.damageDeal = true;
                                d1On = false;
                                HUD.waitBar1Ality();
                                timer.cancel();
                            }
                        }, Player1.deactivateTime);
                    }
                }
                if (Shop.force1) {
                    if (!d2On) {
                        f1On = true;
                        Player1.forceField = true;
                        Player1.damageDeal = false;
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Player1.forceField = false;
                                Player1.damageDeal = true;
                                HUD.waitBar1Ality();
                                f1On = false;
                                timer.cancel();
                            }
                        }, Player1.forceTime);
                    }
                }
            }

            if (key == KeyEvent.VK_2) {
                if (Shop.deactivate2) {
                    if (!f1On) {
                        d2On = true;
                        Player1.damageDeal = false;
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Player1.damageDeal = true;
                                HUD.waitBar2Ality();
                                d2On = false;
                                timer.cancel();
                            }
                        }, Player1.deactivateTime);
                    }
                }
                if (Shop.force2) {
                    if (!d1On) {
                        f2On = true;
                        Player1.forceField = true;
                        Player1.damageDeal = false;
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Player1.forceField = false;
                                Player1.damageDeal = true;
                                HUD.waitBar2Ality();
                                f2On = false;
                                timer.cancel();
                            }
                        }, Player1.forceTime);
                    }
                }
            }
        }

        if (key == KeyEvent.VK_P) {
            if (game.gameState == Game.STATE.Game) {
                Game.paused = !Game.paused;
            }
        }
        if (key == KeyEvent.VK_SPACE) {
            if (Game.gameState == Game.STATE.Game) Game.gameState = Game.STATE.Shop;
            else if (Game.gameState == Game.STATE.Shop) Game.gameState = Game.STATE.Game;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            HUD.scheduler.shutdown();
            System.exit(0);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player1) {
                if (key == KeyEvent.VK_UP) keyDown1[0] = false;
                if (key == KeyEvent.VK_DOWN) keyDown1[1] = false;
                if (key == KeyEvent.VK_RIGHT) keyDown1[2] = false;
                if (key == KeyEvent.VK_LEFT) keyDown1[3] = false;

                if (!keyDown1[0] && !keyDown1[1]) tempObject.setVelY(0);

                if (!keyDown1[2] && !keyDown1[3]) tempObject.setVelX(0);
            }
            if (Game.PlayerMode2) {
                if (tempObject.getId() == ID.Player2) {
                    if (key == KeyEvent.VK_W) keyDown2[0] = false;
                    if (key == KeyEvent.VK_S) keyDown2[1] = false;
                    if (key == KeyEvent.VK_A) keyDown2[2] = false;
                    if (key == KeyEvent.VK_D) keyDown2[3] = false;

                    if (!keyDown2[0] && !keyDown2[1]) tempObject.setVelY(0);

                    if (!keyDown2[2] && !keyDown2[3]) tempObject.setVelX(0);
                }
            }
        }
    }

}
