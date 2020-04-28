/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Observer;
import Controller.State;
import View.Gui;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import static javafx.application.Platform.exit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



/**
 *
 */
public class Player {
    private int xPlayer;
    private int yPlayer;
    private int lives=5;
    private int score;
    private int numberOfBullets=6;
    public static Player p1=null;
    List<Observer> observers=new ArrayList<>();
    private State state;
    

    public Player() {
        this.xPlayer = xPlayer;
        this.yPlayer = yPlayer;
        state=null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
     //   notifyAllObservers();
    }

    public int getNumberOfBullets() {
        return numberOfBullets;
    }

    public void setNumberOfBullets(int numberOfBullets) {
        this.numberOfBullets = numberOfBullets;
    }
    
    
    public int getxPlayer() {
        return xPlayer;
    }

    public void setxPlayer(int xPlayer) {
        this.xPlayer = xPlayer;
    }

    public int getyPlayer() {
        return yPlayer;
    }

    public void setyPlayer(int yPlayer) {
        this.yPlayer = yPlayer;
    }
    public void draw(Graphics g)
    {
         ImageIcon im = new ImageIcon("girl - Copy.png");
        g.drawImage(im.getImage(), 30 *xPlayer, 30 *yPlayer, null);
    }
    public int check()
    {
        if(numberOfBullets==0)
        {
           JOptionPane.showMessageDialog(null, "No more bullets.");
           return 0;
        }
      return 1;
    }
     public void notifyAllObservers(){
      for(Observer observer:observers)
         observer.update();
   }
   public void attach(Observer observer)
   {
       observers.add(observer);
   }
    
     public static Player getInstance(){
    
        if(p1==null){
        p1=new Player();}
        return p1;
    
    }
     
   public void won(){
     if(xPlayer==29&&yPlayer==29)
     {
          if(Gui.y<30)
               score=score*3;
       else if(Gui.y<70)
               score=score*2;
       else if(Gui.y>70)
              score=score*1;
            //p.setScore(p.getScore*Gui.y);
           JOptionPane.showMessageDialog(null, "YOU WON!");
           System.exit(0);
     }
   }

   public void score (int time)
   {
       if(time<30)
           score=score*2;
       else if(time< 70)
           score=(int) (score*1.5);
       else if(time<120)
           score=(int) (score*1.3);
           
   }
}
    
    

