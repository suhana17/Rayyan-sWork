import javax.management.relation.RelationNotFoundException;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import java.util.Random;

public class Shop extends MouseAdapter {

    private int B1 = 1;

    private int B12 = 1;

    private int B2 = 1;

    private int B22 = 1;

    private final int B3 = 1;

    private String currentPlayer;

    private int B4 = 1;

    private int B42 = 1;

    private int B5 = 1;

    private int B52 = 1;

    private int B6 = 2;

    private int B7 = 5;

    private final int B8 = 10;

    private final int B9 = 3;

    private boolean trans1 = false;

    private boolean trans2 = false;

    private boolean trans3 = false;

    private boolean trans4 = false;

    private boolean trans5 = false;

    private boolean trans6 = false;

    private boolean trans7 = false;

    private boolean trans8 = false;

    private boolean trans9 = false;

    private boolean check1 = false;

    private boolean check2 = false;

    private boolean check3 = false;

    private boolean check4 = false;

    private boolean check5 = false;

    private boolean check6 = false;

    private boolean check7 = false;

    private boolean check8 = false;

    private boolean check9 = false;

    private boolean player1Operation = true;

    private boolean player2Operation = false;

    private boolean transSwitch = false;

    private boolean notEnough = false;

    Random r = new Random();

    private int level1 = 0;

    private int level12 = 0;

    private int level2 = 0;

    private int level22 = 0;

    private int level4 = 0;

    private int level42 = 0;

    private int level5 = 0;

    private int level52 = 0;

    private int level6 = 0;

    private int level7 = 0;

    private int level8 = 0;

    private int level9 = 0;

    private boolean error = false;

    public static boolean bulletsOn = false;

    public static boolean deactivate1 = false;

    public static boolean deactivate2 = false;

    public static boolean force1 = false;

    public static boolean force2 = false;

    public static boolean teleport1 = false;

    public static boolean teleport2 = false;

    private boolean maxLevel6 = false;

    private boolean maxLevel1 = false;

    private boolean maxLevel2 = false;

    private boolean maxLevel4 = false;

    private boolean maxLevel5 = false;

    private boolean maxLevel7 = false;

    private boolean maxLevel8 = false;

    private boolean maxLevel9 = false;

    private boolean maxLevel12 = false;

    private boolean maxLevel22 = false;

    private boolean maxLevel42 = false;

    private boolean maxLevel52 = false;

    Handler handler;
    HUD hud;

    public Shop(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void render(Graphics g) {

        g.setFont(new Font("arial", 0, Game.WIDTH / 25));

        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g.drawString("SHOP", Game.WIDTH/2 - (Game.WIDTH / 15), Game.HEIGHT / 8);
        g.setColor(Color.white);

        g.setFont(new Font("arial", 1, Game.WIDTH / 60));
        if (trans1) {
            g.fillRect(Game.WIDTH / 6, Game.HEIGHT / 4, Game.WIDTH / 7, Game.HEIGHT / 7);
            g.setColor(Color.BLACK);
        }
        if (Game.PlayerMode2) {
            if (player1Operation) {
                g.drawString("Upgrade Health", Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 25));
                g.drawString("Cost: " + B1, Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 15));
            } else if (player2Operation) {
                g.drawString("Upgrade Health", Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 25));
                g.drawString("Cost: " + B12, Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 15));
            }
        } else {
            g.drawString("Upgrade Health", Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 25));
            g.drawString("Cost: " + B1, Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 15));
        }
        if (player1Operation) {
            if (!maxLevel1) {
                g.drawString("Level : " + level1, Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 11));
            } else {
                g.setColor(Color.RED);
                g.drawString("Max Level", Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 11));
                g.setColor(Color.WHITE);
            }
        } else if (player2Operation) {
            if (!maxLevel12) {
                g.drawString("Level : " + level12, Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 11));
            } else {
                g.setColor(Color.RED);
                g.drawString("Max Level", Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 11));
                g.setColor(Color.WHITE);
            }
        }
        if (check1) {
            g.setColor(Color.GREEN);
            g.drawString("Done!", Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 7));
        }

        g.setColor(Color.WHITE);

        if (trans2) {
            g.fillRect(Game.WIDTH / 2 - Game.WIDTH / 12, Game.HEIGHT / 4, Game.WIDTH / 7, Game.HEIGHT / 7);
            g.setColor(Color.BLACK);
        }
        if (Game.PlayerMode2) {
            if (player1Operation) {
                g.drawString("Upgrade Speed", Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 25));
                g.drawString("Cost: " + B2, Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 15));
            } else if (player2Operation) {
                g.drawString("Upgrade Speed", Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 25));
                g.drawString("Cost: " + B22, Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 15));
            }
        } else {
            g.drawString("Upgrade Speed", Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 25));
            g.drawString("Cost: " + B2, Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 15));
        }
        if (player1Operation) {
            if (!maxLevel2) {
                g.drawString("Level : " + level2, Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 11));
            } else {
                g.setColor(Color.RED);
                g.drawString("Max Level", Game.WIDTH / 2 + (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 11));
                g.setColor(Color.WHITE);
            }
        } else if (player2Operation) {
            if (!maxLevel22) {
                g.drawString("Level : " + level22, Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 11));
            } else {
                g.setColor(Color.RED);
                g.drawString("Max Level", Game.WIDTH / 2 + (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 11));
                g.setColor(Color.WHITE);
            }
        }
        if (check2) {
            g.setColor(Color.GREEN);
            g.drawString("Done!", Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 7));
        }

        g.setColor(Color.WHITE);

        if (trans3) {
            g.fillRect(Game.WIDTH - (Game.WIDTH / 3), Game.HEIGHT / 4, Game.WIDTH / 7, Game.HEIGHT / 7);
            g.setColor(Color.BLACK);
        }
        g.drawString("Refill Health", Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 25));
        g.drawString("Cost: " + B3, Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 15));
        if (check3) {
            g.setColor(Color.GREEN);
            g.drawString("Done!", Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 100), Game.HEIGHT / 4 + (Game.HEIGHT / 7));
        }

        g.setColor(Color.WHITE);

        if (trans5) {
            g.fillRect(Game.WIDTH / 2 - Game.WIDTH / 12, Game.HEIGHT / 2 - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7);
            g.setColor(Color.BLACK);
        }
        if (Game.PlayerMode2) {
            if (player1Operation) {
                g.drawString("Less Danger", Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 25));
                g.drawString("Cost: " + B5, Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 2);
            } else if (player2Operation) {
                g.drawString("Less Danger", Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 25));
                g.drawString("Cost: " + B52, Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 2);
            }
        } else {
            g.drawString("Less Danger", Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 25));
            g.drawString("Cost: " + B5, Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 2);
        }
        if (player1Operation) {
            if (!maxLevel5) {
                g.drawString("Level: " + level5, Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
            } else {
                g.setColor(Color.RED);
                g.drawString("Max Level", Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
            }
        } else if (player2Operation) {
            if (!maxLevel52) {
                g.drawString("Level: " + level52, Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
            } else {
                g.setColor(Color.RED);
                g.drawString("Max Level", Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
            }
        }
        if (check5) {
            g.setColor(Color.GREEN);
            g.drawString("Done!", Game.WIDTH / 2 - (Game.WIDTH / 12) + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 7));
        }

        if (trans4) {
            g.fillRect(Game.WIDTH / 6, Game.HEIGHT / 2 - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7);
            g.setColor(Color.BLACK);
        }
        if (Game.PlayerMode2) {
            if (player1Operation) {
                g.drawString("Score Faster", Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 25));
                g.drawString("Cost: " + B4, Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 15));
            } else if (player2Operation) {
                g.drawString("Score Faster", Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 25));
                g.drawString("Cost: " + B42, Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 15));
            }
        } else {
            g.drawString("Score Faster", Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 25));
            g.drawString("Cost: " + B4, Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 15));
        }
        if (player1Operation) {
            if (!maxLevel4) {
                g.drawString("Level: " + level4, Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
            } else {
                g.setColor(Color.RED);
                g.drawString("Max Level", Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
                g.setColor(Color.WHITE);
            }
        } else if (player2Operation) {
            if (!maxLevel42) {
                g.drawString("Level: " + level42, Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
            } else {
                g.setColor(Color.RED);
                g.drawString("Max Level", Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
                g.setColor(Color.WHITE);
            }
        }
        if (check4) {
            g.setColor(Color.GREEN);
            g.drawString("Done!", Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 7));
        }

        g.setColor(Color.WHITE);
        if (!Game.PlayerMode2) {
            if (trans6) {
                g.fillRect(Game.WIDTH - (Game.WIDTH / 3), Game.HEIGHT / 2 - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7);
                g.setColor(Color.BLACK);
            }
            g.drawString("Deactivate", Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 25));
            g.drawString("Cost: " + B6, Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 100), Game.HEIGHT / 2);
            if (!maxLevel6) {
                g.drawString("Level: " + level6, Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
            } else {
                g.setColor(Color.RED);
                g.drawString("Max Level", Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
                g.setColor(Color.WHITE);
            }
            if (check6) {
                g.setColor(Color.GREEN);
                g.drawString("Done!", Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 100), Game.HEIGHT / 2 - (Game.HEIGHT / 15) + (Game.HEIGHT / 7));
            }

            g.setColor(Color.WHITE);
            if (Objects.equals(Menu.skin, "enderman")) {
                if (trans7) {
                    g.fillRect(Game.WIDTH / 6, Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7);
                    g.setColor(Color.BLACK);
                }
                g.drawString("Force Field", Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 25));
                g.drawString("Cost: " + B7, Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3));
                if (!maxLevel7) {
                    g.drawString("Level: " + level7, Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
                } else {
                    g.setColor(Color.RED);
                    g.drawString("Max Level", Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
                    g.setColor(Color.WHITE);
                }
                if (check7) {
                    g.setColor(Color.GREEN);
                    g.drawString("Done!", Game.WIDTH / 6 + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 7));
                }

                g.setColor(Color.WHITE);

                if (trans8) {
                    g.fillRect(Game.WIDTH / 2 - Game.WIDTH / 12, Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7);
                    g.setColor(Color.BLACK);
                }
                g.drawString("Shoot Bullets", Game.WIDTH / 2 - Game.WIDTH / 12 + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 25));
                g.drawString("Cost: " + B8, Game.WIDTH / 2 - Game.WIDTH / 12 + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3));
                if (!maxLevel8) {
                    g.drawString("Level: " + level8, Game.WIDTH / 2 - Game.WIDTH / 12 + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
                } else {
                    g.setColor(Color.RED);
                    g.drawString("Max Level", Game.WIDTH / 2 - Game.WIDTH / 12 + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
                    g.setColor(Color.WHITE);
                }
                if (check8) {
                    g.setColor(Color.GREEN);
                    g.drawString("Done!", Game.WIDTH / 2 - Game.WIDTH / 12 + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 7));
                }

                g.setColor(Color.WHITE);

                if (trans9) {
                    g.fillRect(Game.WIDTH - (Game.WIDTH / 3), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7);
                    g.setColor(Color.BLACK);
                }
                g.drawString("Teleport", Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 25));
                g.drawString("Cost: " + B9, Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3));
                if (!maxLevel9) {
                    g.drawString("Level: " + level9, Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
                } else {
                    g.setColor(Color.RED);
                    g.drawString("Max Level", Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
                    g.setColor(Color.WHITE);
                }
                if (check9) {
                    g.setColor(Color.GREEN);
                    g.drawString("Done!", Game.WIDTH - (Game.WIDTH / 3) + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 7));
                }

                g.setColor(Color.WHITE);
            } else {
                if (trans7) {
                    g.fillRect(Game.WIDTH / 4 + (Game.WIDTH / 25), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7);
                    g.setColor(Color.BLACK);
                }
                g.drawString("Force Field", Game.WIDTH / 4 + (Game.WIDTH / 25) + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 25));
                g.drawString("Cost: " + B7, Game.WIDTH / 4 + (Game.WIDTH / 25) + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3));
                if (!maxLevel7) {
                    g.drawString("Level: " + level7, Game.WIDTH / 4 + (Game.WIDTH / 25) + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
                } else {
                    g.setColor(Color.RED);
                    g.drawString("Max Level", Game.WIDTH / 4 + (Game.WIDTH / 25) + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
                    g.setColor(Color.WHITE);
                }
                if (check7) {
                    g.setColor(Color.GREEN);
                    g.drawString("Done!", Game.WIDTH / 4 + (Game.WIDTH / 25) + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 7));
                }

                g.setColor(Color.WHITE);

                if (trans8) {
                    g.fillRect(Game.WIDTH / 2 + (Game.WIDTH / 20), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7);
                    g.setColor(Color.BLACK);
                }
                g.drawString("Shoot Bullets", Game.WIDTH / 2 + (Game.WIDTH / 20) + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 25));
                g.drawString("Cost: " + B8, Game.WIDTH / 2 + (Game.WIDTH / 20) + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3));
                if (!maxLevel8) {
                    g.drawString("Level: " + level8, Game.WIDTH / 2 + (Game.WIDTH / 20) + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
                } else {
                    g.setColor(Color.RED);
                    g.drawString("Max Level", Game.WIDTH / 2 + (Game.WIDTH / 20) + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 11));
                    g.setColor(Color.WHITE);
                }
                if (check8) {
                    g.setColor(Color.GREEN);
                    g.drawString("Done!", Game.WIDTH / 2 + (Game.WIDTH / 20) + (Game.WIDTH / 100), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15) + (Game.HEIGHT / 7));
                }
            }
        }

        if (Game.PlayerMode2) {
            g.setColor(Color.WHITE);
            if (transSwitch) {
                g.fillRect(Game.WIDTH / 10, Game.HEIGHT - (Game.HEIGHT / 4), Game.WIDTH / 4, Game.HEIGHT / 10);
                g.setColor(Color.BLACK);
            }
            g.drawString("Switch Player", Game.WIDTH / 6, Game.HEIGHT - (Game.HEIGHT / 6) - (Game.HEIGHT / 50));
        }

        if (Game.PlayerMode2) {
            g.setColor(Color.WHITE);
            if (player1Operation) currentPlayer = "1";
            else if (player2Operation) currentPlayer = "2";
            g.drawString("Player: " + currentPlayer, Game.WIDTH / 2 - (Game.WIDTH / 25), Game.HEIGHT - (Game.HEIGHT / 4));
        }

        if (notEnough) {
            g.setColor(Color.RED);
            g.drawString("Not Enough Yet... Keep Trying!", Game.WIDTH / 2 - (Game.WIDTH / 25), Game.HEIGHT - (Game.HEIGHT / 7));
        }

        if (error) {
            g.setColor(Color.RED);
            g.drawString("You already have 2 power-ups...", Game.WIDTH / 2 - (Game.WIDTH / 25), Game.HEIGHT - (Game.HEIGHT / 5));
        }

        g.setColor(Color.WHITE);
        if (!Game.PlayerMode2) {
            g.drawString("Points : " + hud.getPoints1(), Game.WIDTH / 2 - (Game.WIDTH / 25), Game.HEIGHT - (Game.HEIGHT / 10));
        } else {
            if (player1Operation) g.drawString("Points : " + hud.getPoints1(), Game.WIDTH / 2 - (Game.WIDTH / 25), Game.HEIGHT - (Game.HEIGHT / 10));
            else if (player2Operation) g.drawString("Points : " + hud.getPoints2(), Game.WIDTH / 2 - (Game.WIDTH / 25), Game.HEIGHT - (Game.HEIGHT / 10));
        }
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (Game.gameState == Game.STATE.Shop) {

            if (mouseOver(mx, my, Game.WIDTH / 6, Game.HEIGHT / 4, Game.WIDTH / 7, Game.HEIGHT / 7)) {
                if (Menu.volume) Game.play("sounds/buttonPress.mp3");
                if (!Game.PlayerMode2) {
                    if (level1 != 5) {
                        trans1 = true;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        trans1 = false;
                        if (hud.getPoints1() >= B1) {
                            check1 = true;
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            check1 = false;
                            hud.setPoints1(hud.getPoints1() - B1);
                            B1 += 1;
                            level1++;
                            hud.bounds += 20;
                            hud.HEALTH = (100 + (hud.bounds / 2));
                        } else {
                            notEnough = true;
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            notEnough = false;
                        }
                    } else {
                        maxLevel1 = true;
                    }
                } else {
                    if (player1Operation) {
                        if (level1 != 5) {
                            trans1 = true;
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            trans1 = false;
                            if (hud.getPoints1() >= B1) {
                                check1 = true;
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                check1 = false;
                                hud.setPoints1(hud.getPoints1() - B1);
                                B1 += 1;
                                level1++;
                                hud.bounds += 20;
                                hud.HEALTH = (100 + (hud.bounds / 2));
                            } else {
                                notEnough = true;
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                notEnough = false;
                            }
                        } else {
                            maxLevel2 = true;
                        }
                    } else if (player2Operation) {
                        if (level12 != 5) {
                            trans1 = true;
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            trans1 = false;
                            if (hud.getPoints2() >= B12) {
                                check1 = true;
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                check1 = false;
                                hud.setPoints2(hud.getPoints2() - B12);
                                B12 += 1;
                                level12++;
                                hud.bounds2 += 20;
                                hud.P2HEALTH = (100 + (hud.bounds2 / 2));
                            } else {
                                notEnough = true;
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                notEnough = false;
                            }
                        } else {
                            maxLevel22 = false;
                        }
                    }
                }
            }

            if (mouseOver(mx, my, Game.WIDTH / 2 - Game.WIDTH / 12, Game.HEIGHT / 4, Game.WIDTH / 7, Game.HEIGHT / 7)) {
                if (Menu.volume) Game.play("sounds/buttonPress.mp3");
                if (!Game.PlayerMode2) {
                    if (level2 != 5) {
                        trans2 = true;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        trans2 = false;
                        if (hud.getPoints1() >= B2) {
                            check2 = true;
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            check2 = false;
                            hud.setPoints1(hud.getPoints1() - B2);
                            B2 += 1;
                            level2++;
                            handler.speed += 2;
                        } else {
                            notEnough = true;
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            notEnough = false;
                        }
                    } else {
                        maxLevel2 = true;
                    }
                } else {
                    if (player1Operation) {
                        if (level2 != 5) {
                            trans2 = true;
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            trans2 = false;
                            if (hud.getPoints1() >= B2) {
                                check2 = true;
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                check2 = false;
                                hud.setPoints1(hud.getPoints1() - B2);
                                B2 += 1;
                                level2++;
                                handler.speed += 2;
                            } else {
                                notEnough = true;
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                notEnough = false;
                            }
                        } else {
                            maxLevel2 = true;
                        }
                    } else if (player2Operation) {
                        if (level22 != 5) {
                            trans2 = true;
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            trans2 = false;
                            if (hud.getPoints2() >= B22) {
                                check2 = true;
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                check2 = false;
                                hud.setPoints1(hud.getPoints2() - B22);
                                B22 += 1;
                                level22++;
                                handler.speed2 += 2;
                            } else {
                                notEnough = true;
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                notEnough = false;
                            }
                        } else {
                            maxLevel22 = true;
                        }
                    }
                }
            }

            if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 3), Game.HEIGHT / 4, Game.WIDTH / 7, Game.HEIGHT / 7)) {
                if (Menu.volume) Game.play("sounds/buttonPress.mp3");
                trans3 = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                trans3 = false;
                if (!Game.PlayerMode2) {
                    if (hud.getPoints1() >= B3) {
                        check3 = true;
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        check3 = false;
                        hud.setPoints1(hud.getPoints1() - B3);
                        hud.HEALTH = (100 + (hud.bounds / 2));
                    } else {
                        notEnough = true;
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        notEnough = false;
                    }
                } else {
                    if (player1Operation) {
                        if (hud.getPoints1() >= B3) {
                            check3 = true;
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            check3 = false;
                            hud.setPoints1(hud.getPoints1() - B3);
                            hud.HEALTH = (100 + (hud.bounds / 2));
                        } else {
                            notEnough = true;
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            notEnough = false;
                        }
                    } else if (player2Operation) {
                        if (hud.getPoints2() >= B3) {
                            check3 = true;
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            check3 = false;
                            hud.setPoints2(hud.getPoints2() - B3);
                            hud.P2HEALTH = (100 + (hud.bounds2 / 2));
                        } else {
                            notEnough = true;
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            notEnough = false;
                        }
                    }
                }
            }

            if (mouseOver(mx, my, Game.WIDTH / 10, Game.HEIGHT - (Game.HEIGHT / 4), Game.WIDTH / 4, Game.HEIGHT / 10)) {
                if (Menu.volume) Game.play("sounds/buttonPress.mp3");
                transSwitch = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                transSwitch = false;
                player2Operation = !player2Operation;
                player1Operation = !player1Operation;
            }

            if (mouseOver(mx, my, Game.WIDTH / 2 - Game.WIDTH / 12, Game.HEIGHT / 2 - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7)) {
                if (Menu.volume) Game.play("sounds/buttonPress.mp3");
                if (!Game.PlayerMode2) {
                    if (level5 != 3) {
                        trans5 = true;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        trans5 = false;
                        if (hud.getPoints1() >= B5) {
                            check5 = true;
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            check5 = false;
                            hud.setPoints1(hud.getPoints1() - B5);
                            B5 += 1;
                            level5++;
                            Player1.dajing -= 0.5;
                        } else {
                            notEnough = true;
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            notEnough = false;
                        }
                    } else {
                        maxLevel5 = true;
                    }
                } else {
                    if (player1Operation) {
                        if (level5 != 3) {
                            trans5 = true;
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            trans5 = false;
                            if (hud.getPoints1() >= B5) {
                                check5 = true;
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                check5 = false;
                                hud.setPoints1(hud.getPoints1() - B5);
                                B5 += 1;
                                level5++;
                                Player1.dajing -= 0.5;
                            } else {
                                notEnough = true;
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                notEnough = false;
                            }
                        } else {
                            maxLevel5 = true;
                        }
                    } else if (player2Operation) {
                        if (level52 != 3) {
                            trans5 = true;
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            trans5 = false;
                            if (hud.getPoints2() >= B52) {
                                check5 = true;
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                check5 = false;
                                hud.setPoints2(hud.getPoints2() - B5);
                                B52 += 1;
                                level52++;
                                Player2.dajing -= 0.5;
                            } else {
                                notEnough = true;
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                notEnough = false;
                            }
                        } else {
                            maxLevel52 = true;
                        }
                    }
                }
            }

            if (mouseOver(mx, my, Game.WIDTH / 6, Game.HEIGHT / 2 - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7)) {
                if (Menu.volume) Game.play("sounds/buttonPress.mp3");
                if (!Game.PlayerMode2) {
                    if (level4 != 5) {
                        trans4 = true;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        trans4 = false;
                        if (hud.getPoints1() >= B4) {
                            check4 = true;
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            check4 = false;
                            hud.setPoints1(hud.getPoints1() - B4);
                            B4 += 1;
                            hud.dabing++;
                            level4++;
                        } else {
                            notEnough = true;
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            notEnough = false;
                        }
                    } else {
                        maxLevel4 = true;
                    }
                } else {
                    if (player1Operation) {
                        if (level4 != 5) {
                            trans4 = true;
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            trans4 = false;
                            if (hud.getPoints1() >= B4) {
                                check4 = true;
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                check4 = false;
                                hud.setPoints1(hud.getPoints1() - B4);
                                B4 += 1;
                                hud.dabing++;
                                level4++;
                            } else {
                                notEnough = true;
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                notEnough = false;
                            }
                        } else {
                            maxLevel4 = true;
                        }
                    } else if (player2Operation) {
                        if (level42 != 5) {
                            trans4 = true;
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            trans4 = false;
                            if (hud.getPoints2() >= B42) {
                                check4 = true;
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                check4 = false;
                                hud.setPoints2(hud.getPoints2() - B42);
                                B42 += 1;
                                hud.dabing2++;
                                level42++;
                            } else {
                                notEnough = true;
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                notEnough = false;
                            }
                        } else {
                            maxLevel42 = true;
                        }
                    }
                }
            }



            if (!Game.PlayerMode2) {
                if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 3), Game.HEIGHT / 2 - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7)) {
                    if (Menu.volume) Game.play("sounds/buttonPress.mp3");
                    if (level6 != 5) {
                        trans6 = true;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        trans6 = false;
                        if (hud.getPoints1() >= B6) {
                            check6 = true;
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            check6 = false;
                            hud.setPoints1(hud.getPoints1() - B6);
                            B6 += 1;
                            level6++;
                            if (level6 == 1) {
                                if (Objects.equals(HUD.power1, "")) {
                                    deactivate1 = true;
                                    HUD.power1 = "D";
                                } else if (!Objects.equals(HUD.power1, "") && Objects.equals(HUD.power2, "")) {
                                    deactivate2 = true;
                                    HUD.power2 = "D";
                                } else {
                                    error = true;
                                    try {
                                        Thread.sleep(3000);
                                    } catch (InterruptedException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                    error = false;
                                }
                            } else {
                                Player1.deactivateTime++;
                            }
                        } else {
                            notEnough = true;
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            notEnough = false;
                        }
                    } else {
                        maxLevel6 = true;
                    }
                }

                if (Objects.equals(Menu.skin, "enderman")) {
                    if (mouseOver(mx, my, Game.WIDTH / 6, Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7)) {
                        if (Menu.volume) Game.play("sounds/buttonPress.mp3");
                        if (level7 != 5) {
                            trans7 = true;
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            trans7 = false;
                            if (hud.getPoints1() >= B7) {
                                check7 = true;
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                check7 = false;
                                hud.setPoints1(hud.getPoints1() - B7);
                                B7 += 1;
                                level7++;
                                if (level7 == 1) {
                                    if (Objects.equals(HUD.power1, "")) {
                                        force1 = true;
                                        HUD.power1 = "F";
                                    } else if (!Objects.equals(HUD.power1, "") && Objects.equals(HUD.power2, "")) {
                                        force2 = true;
                                        HUD.power2 = "F";
                                    } else {
                                        error = true;
                                        try {
                                            Thread.sleep(3000);
                                        } catch (InterruptedException ex) {
                                            throw new RuntimeException(ex);
                                        }
                                        error = false;
                                    }
                                } else {
                                    Player1.forceTime++;
                                }
                            } else {
                                notEnough = true;
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                notEnough = false;
                            }
                        } else {
                            maxLevel7 = true;
                        }
                    }
                    if (mouseOver(mx, my, Game.WIDTH / 2 - Game.WIDTH / 12, Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7)) {
                        if (Menu.volume) Game.play("sounds/buttonPress.mp3");
                        trans8 = true;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        trans8 = false;
                        if (level8 != 1) {
                            if (hud.getPoints1() >= B8) {
                                check8 = true;
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                check8 = false;
                                hud.setPoints1(hud.getPoints1() - B8);
                                bulletsOn = true;
                                maxLevel8 = true;
                            } else {
                                notEnough = true;
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                notEnough = false;
                            }
                        } else {
                            maxLevel8 = true;
                        }
                    }
                    if (mouseOver(mx, my, Game.WIDTH - (Game.WIDTH / 3), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7)) {
                        if (Menu.volume) Game.play("sounds/buttonPress.mp3");
                        trans9 = true;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        trans9 = false;
                        if (level9 != 1) {
                            if (hud.getPoints1() >= B9) {
                                check9 = true;
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                check9 = false;
                                hud.setPoints1(hud.getPoints1() - B9);

                                if (Objects.equals(HUD.power1, "")) {
                                    teleport1 = true;
                                    HUD.power1 = "T";
                                } else if (!Objects.equals(HUD.power1, "") && Objects.equals(HUD.power2, "")) {
                                    teleport2 = true;
                                    HUD.power2 = "T";
                                } else {
                                    error = true;
                                    try {
                                        Thread.sleep(3000);
                                    } catch (InterruptedException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                    error = false;
                                }
                            } else {
                                notEnough = true;
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                notEnough = false;
                            }
                        } else {
                            maxLevel9 = true;
                        }
                    }

                } else {
                    if (mouseOver(mx, my, Game.WIDTH / 4 + (Game.WIDTH / 25), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7)) {
                        if (Menu.volume) Game.play("sounds/buttonPress.mp3");
                        if (level7 != 5) {
                            trans7 = true;
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            trans7 = false;
                            if (hud.getPoints1() >= B7) {
                                check7 = true;
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                check7 = false;
                                hud.setPoints1(hud.getPoints1() - B7);
                                B7 += 1;
                                level7++;
                                if (level7 == 1) {
                                    if (Objects.equals(HUD.power1, "")) {
                                        force1 = true;
                                        HUD.power1 = "F";
                                    } else if (!Objects.equals(HUD.power1, "") && Objects.equals(HUD.power2, "")) {
                                        force2 = true;
                                        HUD.power2 = "F";
                                    } else {
                                        error = true;
                                        try {
                                            Thread.sleep(3000);
                                        } catch (InterruptedException ex) {
                                            throw new RuntimeException(ex);
                                        }
                                        error = false;
                                    }
                                } else {
                                    Player1.forceTime++;
                                }
                            } else {
                                notEnough = true;
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                                notEnough = false;
                            }
                        } else {
                            maxLevel7 = true;
                        }
                    }
                    if (mouseOver(mx, my, Game.WIDTH / 2 + (Game.WIDTH / 20), Game.HEIGHT - (Game.HEIGHT / 3) - (Game.HEIGHT / 15), Game.WIDTH / 7, Game.HEIGHT / 7)) {
                        if (Menu.volume) Game.play("sounds/buttonPress.mp3");
                        trans8 = true;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        trans8 = false;
                        if (hud.getPoints1() >= B8) {
                            check8 = true;
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            check8 = false;
                            hud.setPoints1(hud.getPoints1() - B8);
                            bulletsOn = true;
                            maxLevel8 = true;
                        } else {
                            notEnough = true;
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            notEnough = false;
                        }
                    }
                }
            }
        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            return my > y && my < y + height;
        } else return false;
    }
}
