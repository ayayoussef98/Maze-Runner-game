/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Gui;
import View.Panel;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Monkia
 */
public class Stones extends wall{
   
   
    
    public void draw(Graphics g)
    {
        ImageIcon im = new ImageIcon("wall3.jpg");
        g.drawImage(im.getImage(),xWall*30,yWall*30,null);
    }
    
}
