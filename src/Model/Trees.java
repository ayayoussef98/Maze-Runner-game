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
public class Trees extends wall{
    public void draw(Graphics g)
    {
        ImageIcon im = new ImageIcon("trees.png");
        g.drawImage(im.getImage(),xWall*30,yWall*30,null);
    }
}
