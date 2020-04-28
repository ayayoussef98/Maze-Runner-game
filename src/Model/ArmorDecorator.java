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
public class ArmorDecorator extends Player {
    public void draw(Graphics g)
    {
        super.draw(g);
        ImageIcon im = new ImageIcon("armor.png");
        g.drawImage(im.getImage(), getxPlayer()* 30, getyPlayer() *30,null);
    }
    
}
