/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 */
public class HealthGift extends Gift {
    Player p=Player.getInstance();
   public void draw(Graphics g)
    {
          ImageIcon im = new ImageIcon("heart.png");
        g.drawImage(im.getImage(), 5 + xGift * 30, 5 + yGift * 30, null);
    }
   public void Calculate()
   {
       p.setLives(p.getLives()+1);
   }
}
