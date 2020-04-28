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
public class StoneGround extends Ground{
    public void draw(Graphics g){
         ImageIcon im = new ImageIcon("wall1.png");
         g.drawImage(im.getImage(), xGround* 30, yGround* 30, null);
    }
}
