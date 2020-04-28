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
public class BulletGift extends Gift{
  Player p=Player.getInstance();
    public void draw(Graphics g)
    {
          ImageIcon im = new ImageIcon("gift2.png");
        g.drawImage(im.getImage(), 5 + xGift * 30, 5 + yGift * 30, null);
    }
   public void Calculate(){
       if(p.getNumberOfBullets()<6)
         p.setNumberOfBullets(p.getNumberOfBullets()+1);
   }
}
