/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Ayah Soffar
 */
public class ImageLoader {
      public BufferedImage loadImage(String path) throws IOException{
        URL url=this.getClass().getResource(path);
        BufferedImage image=ImageIO.read(url);
        return image;
    }
    
}
