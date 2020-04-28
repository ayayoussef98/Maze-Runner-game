/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.image.BufferedImage;

/**
 *
 * @author Ayah Soffar
 */
public class Sprite {
        public BufferedImage sprite;
    BufferedImage sprites[];
    

    public Sprite(BufferedImage sprite) {
        this.sprite = sprite;
    }
    public BufferedImage getImage(int x,int y,int width,int height){
        BufferedImage sp=sprite.getSubimage(x, y, width,height);
        return sp;
    }
    
    
}
