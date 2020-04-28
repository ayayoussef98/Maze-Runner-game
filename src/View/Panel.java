/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ImageLoader;
import Controller.KeyController;
import static Controller.KeyController.pause;
import Controller.Pause;
import Controller.Play;
import Model.Armor;
import Model.ArmorDecorator;
import Model.Bullet;
import Model.BulletGift;
import Model.Factory;
import Model.GrassGround;
import Model.HealthBomb;
import Model.HealthGift;
import Model.Player;
import Model.ScoreBomb;
import Model.StoneGround;
import Model.Stones;
import Model.Trees;
import Model.bomb;
import Model.wall;
import Controller.Observer;
import Controller.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 */
public class Panel extends JPanel implements KeyListener {

    String motion;
    public Player p = Player.getInstance();
    Stones stones = new Stones();
    bomb bomb = new bomb();
    HealthBomb healthbomb = new HealthBomb();
    ScoreBomb scorebomb = new ScoreBomb();
    StoneGround stoneground = new StoneGround();
    GrassGround grassground = new GrassGround();
    HealthGift healthgift = new HealthGift();
    BulletGift bulletgift = new BulletGift();
    Bullet b= new Bullet();
    Armor armor=new Armor();
    Trees trees = new Trees();
    wall w = new wall();
    public static String wallName;
    public static int mode;
    ArmorDecorator armordec=new  ArmorDecorator();
    boolean flag;
    Pause stop= new Pause();
    Play continueGame= new Play();
    //public static 
    //Gui gui = new Gui();
    /*public Panel(Player player)
    
    {
        this.p=player;
       this.p.attach(this);
    }*/

    public String getWallName() {
        return wallName;
    }

    public void setWallName(String wallName) {
        this.wallName = wallName;
    }

    Random r;
    BufferedImage sprite;

    public static int board[][] = {
        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1},
        {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1},
        {1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1},
        {1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1},
        {1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1},
        {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1},
        {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    public static int shapes[][] = {{0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},
    {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
    {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},
    {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1},
    {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1},
    {1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1},
    {1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
    {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1},
    {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
    {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
    {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1},
    {1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1},
    {1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1},
    {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1},
    {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1},
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    public String getMotion() {
        return motion;
    }

    public void setMotion(String motion) {
        this.motion = motion;
    }

    public Panel() {
      //   this.p.attach(this);
        for (int i = 0; i < 10; i++) {
            r = new Random();
            healthbomb.setxBomb(r.nextInt(30));
            healthbomb.setyBomb(r.nextInt(30));
            while (shapes[healthbomb.getyBomb()][healthbomb.getxBomb()] == 1 ) {
                healthbomb.setxBomb((r.nextInt(30)));
                healthbomb.setyBomb(r.nextInt(30));
            }
            shapes[healthbomb.getyBomb()][healthbomb.getxBomb()] = 2;
        }
        for (int i = 0; i < 5; i++) {
            r = new Random();
            scorebomb.setxBomb(r.nextInt(30));
            scorebomb.setyBomb(r.nextInt(30));
            while (shapes[scorebomb.getyBomb()][scorebomb.getxBomb()] == 1) {
                scorebomb.setxBomb(r.nextInt(30));
                scorebomb.setyBomb(r.nextInt(30));
            }
            shapes[scorebomb.getyBomb()][scorebomb.getxBomb()] = 3;
        }
        for (int i = 0; i < 5; i++) {
            r = new Random();
            healthgift.setxGift(r.nextInt(30));
            healthgift.setyGift(r.nextInt(30));
            while (shapes[healthgift.getyGift()][healthgift.getxGift()] == 1) {
                healthgift.setxGift(r.nextInt(30));
                healthgift.setyGift(r.nextInt(30));
            }
            shapes[healthgift.getyGift()][healthgift.getxGift()] = 4;}
     for (int i = 0; i < 5; i++) {
            r = new Random();
            bulletgift.setxGift(r.nextInt(30));
            bulletgift.setyGift(r.nextInt(30));
            while (shapes[bulletgift.getyGift()][bulletgift.getxGift()] == 1 ) {
                bulletgift.setxGift(r.nextInt(30));
                bulletgift.setyGift(r.nextInt(30));
            }
            shapes[bulletgift.getyGift()][bulletgift.getxGift()] = 5;
        }   
       /*for (int i = 0; i < 5; i++) {
            r = new Random();
            bulletgift.setxGift(r.nextInt(30));
            bulletgift.setyGift(r.nextInt(30));
            while (shapes[bulletgift.getyGift()][bulletgift.getxGift()] == 1 ) {
                bulletgift.setxGift(r.nextInt(30));
                bulletgift.setyGift(r.nextInt(30));
            }
            shapes[bulletgift.getyGift()][bulletgift.getxGift()] = 5;
        }*/
        for (int i = 0; i < 7; i++) {
            r = new Random();
            trees.setxWall(r.nextInt(30));
            trees.setyWall(r.nextInt(30));
            while (shapes[trees.getyWall()][trees.getxWall()] == 1 ) {
                trees.setxWall(r.nextInt(30));
                trees.setyWall(r.nextInt(30));
            }
            shapes[trees.getyWall()][trees.getxWall()] = 6;
            //board[trees.getxWall()][trees.getyWall()]=0;
            wallName = "Trees";
        }
        for (int i = 0; i < 5; i++) {
            r = new Random();
            armor.setxGift(r.nextInt(30));
            armor.setyGift(r.nextInt(30));
            while (shapes[armor.getyGift()][armor.getxGift()] == 1) {
                armor.setxGift(r.nextInt(30));
                armor.setyGift(r.nextInt(30));
            }
            shapes[armor.getyGift()][armor.getxGift()] = 7;
           
        }
    }

    private void initialize() throws IOException {

        ImageLoader loader = new ImageLoader();

        BufferedImage SpriteSheet = null;
        SpriteSheet = loader.loadImage("girl.png");
        Sprite ss = new Sprite(SpriteSheet);
        sprite = ss.getImage(0, 0, 16, 17);

    }

//    public void paint(Graphics g) {
//        g.drawImage(sprite, 100, 100, 50, 50, null);
//        repaint();
//
//    }
    @Override
    protected void paintComponent(Graphics g) {
        int x = 10;
        int y = 10;
        super.paintComponent(g);
        Factory factory = new Factory();
        wall wl = factory.getWall(wallName);
        //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {

                if (board[i][j] == 1) {
                    //Stones st = (Stones) wl;
                    stones.setxWall(j);
                    stones.setyWall(i);
                    stones.draw(g);
                } else {
                    stoneground.setxGround(j);
                    stoneground.setyGround(i);
                    stoneground.draw(g);
                }
                if (shapes[i][j] == 2) {
                    healthbomb.setxBomb(j);
                    healthbomb.setyBomb(i);
                    healthbomb.draw(g);
                } else if (shapes[i][j] == 3) {
                    scorebomb.setxBomb(j);
                    scorebomb.setyBomb(i);
                    scorebomb.draw(g);
                } else if (shapes[i][j] == 4) {
                    healthgift.setxGift(j);
                    healthgift.setyGift(i);
                    healthgift.draw(g);
                } else if (shapes[i][j] == 5) {
                    bulletgift.setxGift(j);
                    bulletgift.setyGift(i);
                    bulletgift.draw(g);
                } else if (shapes[i][j] == 6) {
                    Trees tr = (Trees) wl;
                    tr.setxWall(j);
                    tr.setyWall(i);
                    tr.draw(g);
                }
                else if (shapes[i][j] == 7) {
                    armor.setxGift(j);
                    armor.setyGift(i);
                    armor.draw(g);
                }
            }
        }
//        if(KeyController.x==1){
//            b.draw(g);
//        }
//        
       if(flag==true){
           armordec.draw(g);
           }
       else
       p.draw(g);
    }

    public void bomb() {
         if(flag==false){
        if (shapes[p.getyPlayer()][p.getxPlayer()] == 2) {
            healthbomb.Calculate();

            //board[player.getyPlayer()][player.getxPlayer()]=0;
            shapes[p.getyPlayer()][p.getxPlayer()] = 0;
        }
       // if (p.getLives() == 0) {
             if (p.getLives() == 0) {
              if(Gui.y<30)
               p.setScore(p.getScore()*3);
       else if(Gui.y<70)
               p.setScore((int) (p.getScore()*2));
       else if(Gui.y>70)
              p.setScore((int)(p.getScore()*1));
            //p.setScore(p.getScore*Gui.y);
            JOptionPane.showMessageDialog(null, "Game over, your final project with respect to time is "+p.getScore());
            System.exit(0);
//            if (mode == 1) {
//                p.setxPlayer(p.getxPlayer() + 1);
//            } else if (mode == 2) {
//                p.setxPlayer(p.getxPlayer() - 1);
//            } else if (mode == 3) {
//                p.setyPlayer(p.getyPlayer() + 1);
//            } else if (mode == 4) {
//                p.setyPlayer(p.getyPlayer() - 1);
//            }
//            repaint();
//            JOptionPane.showMessageDialog(null, "Game Over");
//            Gui x = new Gui();
//            x.hide();
//            p.setxPlayer(0);
//            p.setyPlayer(0);
//            p.setLives(5);
//            p.setNumberOfBullets(6);
//            p.setScore(0);

        }

        if (shapes[p.getyPlayer()][p.getxPlayer()] == 3) {
            scorebomb.Calculate();
            shapes[p.getyPlayer()][p.getxPlayer()] = 0;
        }
        if (shapes[p.getyPlayer()][p.getxPlayer()] == 4) {
            healthgift.Calculate();
            shapes[p.getyPlayer()][p.getxPlayer()] = 0;
        }
        if (shapes[p.getyPlayer()][p.getxPlayer()] == 5) {
            bulletgift.Calculate();
            shapes[p.getyPlayer()][p.getxPlayer()] = 0;
        }
        if(shapes[p.getyPlayer()][p.getxPlayer()]==7)
        {    flag=true;
            shapes[p.getyPlayer()][p.getxPlayer()]=0;
            System.out.println("aya");
            armordec.setxPlayer(p.getxPlayer());
            armordec.setyPlayer(p.getyPlayer());
            
        }}
         else{
        if (shapes[armordec.getyPlayer()][armordec.getxPlayer()] == 2) {
            healthbomb.Calculate();

            //board[player.getyPlayer()][player.getxPlayer()]=0;
            shapes[armordec.getyPlayer()][armordec.getxPlayer()] = 0;
        }
       /* if (armordec.getLives() == 0) {
            if (mode == 1) {
                armordec.setxPlayer(armordec.getxPlayer() + 1);
            } else if (mode == 2) {
                armordec.setxPlayer(armordec.getxPlayer() - 1);
            } else if (mode == 3) {
                armordec.setyPlayer(armordec.getyPlayer() + 1);
            } else if (mode == 4) {
                armordec.setyPlayer(armordec.getyPlayer() - 1);
            }
            repaint();
            JOptionPane.showMessageDialog(null, "Game Over");
            Gui x = new Gui();
            x.hide();
            p.setxPlayer(0);
            p.setyPlayer(0);
            p.setLives(5);
            p.setNumberOfBullets(6);
            p.setScore(0);

        }*/

        if (shapes[armordec.getyPlayer()][armordec.getxPlayer()] == 3) {
            flag=false;
            shapes[armordec.getyPlayer()][armordec.getxPlayer()] = 0;
            p.setxPlayer(armordec.getxPlayer());
            p.setyPlayer(armordec.getyPlayer());
        }
        if (shapes[armordec.getyPlayer()][armordec.getxPlayer()] == 4) {
            healthgift.Calculate();
            shapes[armordec.getyPlayer()][armordec.getxPlayer()] = 0;
        }
        if (shapes[armordec.getyPlayer()][armordec.getxPlayer()] == 5) {
            bulletgift.Calculate();
            shapes[armordec.getyPlayer()][armordec.getxPlayer()] = 0;
        }
        if(shapes[armordec.getyPlayer()][armordec.getxPlayer()]==7)
        {    flag=true;
            shapes[armordec.getyPlayer()][armordec.getxPlayer()]=0;
           // System.out.println("aya");
           // armordec.setxPlayer(p.getxPlayer());
            //armordec.setyPlayer(p.getyPlayer());
            
        }}
  
  
    }

    public void moveRight() {
        if (pause == false) {
           continueGame.doAction(p);
            if (p.getxPlayer() != 29) {
                if (board[p.getyPlayer()][p.getxPlayer() + 1] == 0 && shapes[p.getyPlayer()][p.getxPlayer() + 1] != 6) {
                if(flag==false)
//                       armordec.setxPlayer(armordec.getxPlayer()+1);
//                   else
                    p.setxPlayer(p.getxPlayer() + 1);
                    
                    bomb();
                    repaint();
                    motion = "right";
                } else {
                    motion = "right";
                }
            }
            if(armordec.getxPlayer()!=29){
                if (board[armordec.getyPlayer()][armordec.getxPlayer() + 1] == 0 && shapes[armordec.getyPlayer()][armordec.getxPlayer() + 1] != 6) {
                   
                    armordec.setxPlayer(armordec.getxPlayer() + 1);
                    
                    bomb();
                    repaint();
                    motion = "right";
                } else {
                    motion = "right";
                }
            }
        }
        else
        {
           stop.doAction(p);
            JOptionPane.showMessageDialog(null, "Press enter to continue.");
        }
            
        /*if(shapes[p.getyPlayer()][p.getxPlayer()+1]==7)
            flag=true;*/

        p.won();
    }

    public void moveLeft() {
        if(pause==false){
            
        continueGame.doAction(p);
        if (p.getxPlayer() != 0) {
            if (board[p.getyPlayer()][p.getxPlayer() - 1] == 0 && shapes[p.getyPlayer()][p.getxPlayer() - 1] != 6) {
//                if(flag==true)
//                       armordec.setxPlayer(armordec.getxPlayer()-1);
//                else 
                    p.setxPlayer(p.getxPlayer() - 1);
                bomb();
                repaint();
                motion = "left";
            }else {
                    motion = "left";
                }
               if(armordec.getxPlayer()!=0){
                if (board[armordec.getyPlayer()][armordec.getxPlayer() - 1] == 0 && shapes[armordec.getyPlayer()][armordec.getxPlayer() -1] != 6) {
                   
                    armordec.setxPlayer(armordec.getxPlayer() - 1);
                    
                    bomb();
                    repaint();
                    motion = "left";
                } 
            else {
                motion = "left";
            }
        }}}
        else{
             stop.doAction(p);
            JOptionPane.showMessageDialog(null, "Press enter to continue.");
        }
         /*if(shapes[p.getyPlayer()][p.getxPlayer()-1]==7)
            flag=true;*/
        p.won();
    }

    public void moveDown() {
        if(pause==false){
            
        continueGame.doAction(p);
        if (p.getyPlayer() != 29) {
            if (board[p.getyPlayer() + 1][p.getxPlayer()] == 0 && shapes[p.getyPlayer() + 1][p.getxPlayer()] != 6) {
//                if(flag==true)
//                       armordec.setyPlayer(armordec.getyPlayer()+1);
//                else
                     p.setyPlayer(p.getyPlayer() + 1);
                bomb();
                repaint();
                motion = "down";

            }else {
                    motion = "down";
                }    
               if(armordec.getyPlayer()!=29){
                if (board[armordec.getyPlayer()+1][armordec.getxPlayer()] == 0 && shapes[armordec.getyPlayer()+1][armordec.getxPlayer()] != 6) {
                   
                    armordec.setyPlayer(armordec.getyPlayer() + 1);
                    
                    bomb();
                    repaint();
                    motion = "down";
                }}} 
            else {
                motion = "down";
            }
        }
        else{
             stop.doAction(p);
            JOptionPane.showMessageDialog(null, "Press enter to continue.");
        }
         /*if(shapes[p.getyPlayer()+1][p.getxPlayer()]==7)
            flag=true;*/
        p.won();
    }

    public void moveUp() {
        if(pause==false){
       continueGame.doAction(p);
            if (p.getyPlayer() != 0) {
            if (board[p.getyPlayer() - 1][p.getxPlayer()] == 0 && shapes[p.getyPlayer() - 1][p.getxPlayer()] != 6) {
//                if(flag==true)
//                       armordec.setyPlayer(armordec.getyPlayer()-1);
//                else 
                      p.setyPlayer(p.getyPlayer() - 1);
                bomb();
                repaint();
                motion = "up";

            }
//            else {
//                    motion = "up";
//                } 
        
             if(armordec.getyPlayer()!=0){
                if (board[armordec.getyPlayer()-1][armordec.getxPlayer()] == 0 && shapes[armordec.getyPlayer()-1][armordec.getxPlayer()] != 6) {     
                    armordec.setyPlayer(armordec.getyPlayer()-1);
                    
                    bomb();
                    repaint();
                    motion = "up";
                }
              }}
//        else {
//                motion = "up";
//            }
        } 
        else{
             stop.doAction(p);
            JOptionPane.showMessageDialog(null, "Press enter to continue.");
        }
        // if(shapes[p.getyPlayer()-1][p.getxPlayer()]==7)
          //  flag=true;
        p.won();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        /*if (e.getKeyChar() == KeyEvent.VK_RIGHT) {
         player.setxPlayer(player.getxPlayer()+5);
         repaint();
         }
         if (e.getKeyChar() == KeyEvent.VK_LEFT) {
         player.setxPlayer(player.getxPlayer()-5);
         repaint();
         }
         if (e.getKeyChar() == KeyEvent.VK_DOWN) {
         player.setyPlayer(player.getxPlayer()+5);
         repaint();
         }
         if (e.getKeyChar() == KeyEvent.VK_UP) {
         player.setyPlayer(player.getxPlayer()-5);
         repaint();
         }*/
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

public void remove() {

        int i = 0;
        int y1=0,x1=0;
        if(flag==false){
        if (p.check() == 1) {
            try{
            if (motion.equals("up")) {
                for(i=1;i<30;i++){
            if(shapes[p.getyPlayer()-i][p.getxPlayer()]==6 || shapes[p.getyPlayer()-i][p.getxPlayer()]==2 ||
                    shapes[p.getyPlayer()-i][p.getxPlayer()]==4 || shapes[p.getyPlayer()-i][p.getxPlayer()]==5){
              
                board[p.getyPlayer()-i][p.getxPlayer()] = 0;
                shapes[p.getyPlayer()-i][p.getxPlayer()] = 0;
                p.setScore(p.getScore() + 100);
                p.setNumberOfBullets(p.getNumberOfBullets() - 1);
                 //b.setxBullet(x1);
            break;}
            else if(shapes[p.getyPlayer()-i][p.getxPlayer()]==1)
            { p.setNumberOfBullets(p.getNumberOfBullets() - 1);
                break;
            }}
               repaint(); 
            } else if (motion.equals("down")) {
                 for(i=1;i<30;i++){
            if(shapes[p.getyPlayer()+i][p.getxPlayer()]==6 || shapes[p.getyPlayer()+i][p.getxPlayer()]==2 ||
                    shapes[p.getyPlayer()+i][p.getxPlayer()]==4 || shapes[p.getyPlayer()+i][p.getxPlayer()]==5){
              
                 board[p.getyPlayer()+i ][p.getxPlayer() ] = 0;
                shapes[p.getyPlayer()+i ][p.getxPlayer()] = 0;
                 p.setScore(p.getScore() + 100);
                 p.setNumberOfBullets(p.getNumberOfBullets() - 1);
                
            break;}
            else if(shapes[p.getyPlayer()+i][p.getxPlayer()]==1)
            { p.setNumberOfBullets(p.getNumberOfBullets() - 1);
                break;
            }
                }
repaint();
            }
          else if (motion.equals("right")) {
             
                     for(i=1;i<30;i++){
            if(shapes[p.getyPlayer()][p.getxPlayer()+i]==6 || shapes[p.getyPlayer()][p.getxPlayer()+i]==2 ||
                    shapes[p.getyPlayer()][p.getxPlayer()+i]==4 || shapes[p.getyPlayer()][p.getxPlayer()+i]==5){
                 

                 board[p.getyPlayer() ][p.getxPlayer()+i ] = 0;
                shapes[p.getyPlayer() ][p.getxPlayer() +i] = 0;

                p.setScore(p.getScore() + 100);
                 p.setNumberOfBullets(p.getNumberOfBullets() - 1);
                 b.setxBullet(p.getxPlayer());
                 b.setyBullet(p.getyPlayer()); 
           
            break;}
            else if(shapes[p.getyPlayer()][p.getxPlayer()+i]==1)
            { p.setNumberOfBullets(p.getNumberOfBullets() - 1);
                break;
            }
                }
                repaint();}
                
                 else if (motion.equals("left")) {
                   for(i=1;i<30;i++){
            if(shapes[p.getyPlayer()][p.getxPlayer()-i]==6 || shapes[p.getyPlayer()][p.getxPlayer()-i]==2 ||
                    shapes[p.getyPlayer()][p.getxPlayer()-i]==4 || shapes[p.getyPlayer()][p.getxPlayer()-i]==5){
              
                 board[p.getyPlayer() ][p.getxPlayer()-i ] = 0;
                shapes[p.getyPlayer() ][p.getxPlayer() -i] = 0;
                 p.setScore(p.getScore() + 100);
                 p.setNumberOfBullets(p.getNumberOfBullets() - 1);
                 break;
            }
            else if(shapes[p.getyPlayer()][p.getxPlayer()-i]==1)
            { p.setNumberOfBullets(p.getNumberOfBullets() - 1);
                break;
            
                }}
                repaint();
                }}
            catch(Exception e){}}}
        else{
            if (armordec.check() == 1) {
            if (motion.equals("up")) {
                for(i=1;i<30;i++){
            if(shapes[armordec.getyPlayer()-i][armordec.getxPlayer()]==6 || shapes[armordec.getyPlayer()-i][armordec.getxPlayer()]==2 ||
                    shapes[armordec.getyPlayer()-i][armordec.getxPlayer()]==4 || shapes[armordec.getyPlayer()-i][armordec.getxPlayer()]==5){
              
                board[armordec.getyPlayer()-i][armordec.getxPlayer()] = 0;
                shapes[armordec.getyPlayer()-i][armordec.getxPlayer()] = 0;
                armordec.setScore(armordec.getScore() + 100);
                armordec.setNumberOfBullets(armordec.getNumberOfBullets() - 1);
                 //b.setxBullet(x1);
            break;}
            else if(shapes[armordec.getyPlayer()-i][armordec.getxPlayer()]==1)
            { armordec.setNumberOfBullets(armordec.getNumberOfBullets() - 1);
                break;
            }}
               repaint(); 
            } else if (motion.equals("down")) {
                 for(i=1;i<30;i++){
            if(shapes[armordec.getyPlayer()+i][armordec.getxPlayer()]==6 || shapes[armordec.getyPlayer()+i][armordec.getxPlayer()]==2 ||
                    shapes[armordec.getyPlayer()+i][armordec.getxPlayer()]==4 || shapes[armordec.getyPlayer()+i][armordec.getxPlayer()]==5){
              
                 board[armordec.getyPlayer()+i ][armordec.getxPlayer() ] = 0;
                shapes[armordec.getyPlayer()+i ][armordec.getxPlayer()] = 0;
                 armordec.setScore(armordec.getScore() + 100);
                 armordec.setNumberOfBullets(armordec.getNumberOfBullets() - 1);
                
            break;}
            else if(shapes[armordec.getyPlayer()+i][armordec.getxPlayer()]==1)
            { armordec.setNumberOfBullets(armordec.getNumberOfBullets() - 1);
                break;
            }
                }
repaint();
            }
          else if (motion.equals("right")) {
             
                     for(i=1;i<30;i++){
            if(shapes[armordec.getyPlayer()][armordec.getxPlayer()+i]==6 || shapes[armordec.getyPlayer()][armordec.getxPlayer()+i]==2 ||
                    shapes[armordec.getyPlayer()][armordec.getxPlayer()+i]==4 || shapes[armordec.getyPlayer()][armordec.getxPlayer()+i]==5){
                 

                 board[armordec.getyPlayer() ][armordec.getxPlayer()+i ] = 0;
                shapes[armordec.getyPlayer() ][armordec.getxPlayer() +i] = 0;

                armordec.setScore(armordec.getScore() + 100);
                 armordec.setNumberOfBullets(armordec.getNumberOfBullets() - 1);
                 b.setxBullet(armordec.getxPlayer());
                 b.setyBullet(armordec.getyPlayer()); 
           
            break;}
            else if(shapes[armordec.getyPlayer()][armordec.getxPlayer()+i]==1)
            { armordec.setNumberOfBullets(armordec.getNumberOfBullets() - 1);
                break;
            }
                }
                repaint();}
                
                 else if (motion.equals("left")) {
                   for(i=1;i<30;i++){
            if(shapes[armordec.getyPlayer()][armordec.getxPlayer()-i]==6 || shapes[armordec.getyPlayer()][armordec.getxPlayer()-i]==2 ||
                    shapes[armordec.getyPlayer()][armordec.getxPlayer()-i]==4 || shapes[armordec.getyPlayer()][armordec.getxPlayer()-i]==5){
              
                 board[armordec.getyPlayer() ][armordec.getxPlayer()-i ] = 0;
                shapes[armordec.getyPlayer() ][armordec.getxPlayer() -i] = 0;
                 armordec.setScore(armordec.getScore() + 100);
                 armordec.setNumberOfBullets(armordec.getNumberOfBullets() - 1);
                 break;
            }
            else if(shapes[armordec.getyPlayer()][armordec.getxPlayer()-i]==1)
            { armordec.setNumberOfBullets(armordec.getNumberOfBullets() - 1);
                break;
            
                }}
                repaint();
                }}
        }}
          // return 0;
    

//    @Override
//    public void update() {
//    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//Gui gui;
//   @Override
//    public void update() {
//     
//       Gui.setLabel((int)p.getScore()+"");
//        System.out.println(p.getScore());
//    }           
   
    }
    

