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
 * @author Monkia
 */
public class HealthBomb extends bomb {
    Player p=Player.getInstance();
    public void draw(Graphics g)
    {
        ImageIcon im = new ImageIcon("b.png");
        g.drawImage(im.getImage(), 5 + xBomb * 30, 5 + yBomb * 30, null);
    }
  public void Calculate(){
      p.setLives(p.getLives()-1);
  }
}
