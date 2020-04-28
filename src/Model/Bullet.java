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
public class Bullet {
    private int xBullet;
    private int yBullet;

    public int getxBullet() {
        return xBullet;
    }

    public void setxBullet(int xBullet) {
        this.xBullet = xBullet;
    }

    public int getyBullet() {
        return yBullet;
    }

    public void setyBullet(int yBullet) {
        this.yBullet = yBullet;
    }
     public void draw(Graphics g){
        ImageIcon im = new ImageIcon("bullet.jpg");
        g.drawImage(im.getImage(), 5 + xBullet* 30, 5 + yBullet * 30, null);
    }
    
    
}
