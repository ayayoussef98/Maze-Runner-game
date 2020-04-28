/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Gui;
import View.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 */
public class KeyController implements KeyListener {

    Gui w;
    Panel panel1;
    public static int x,y;
    public static Boolean pause=false,ahmed=false;

    public KeyController(Panel p) {
    panel1=p;
    }
    

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (panel1.p.getLives() == 0) {
                Panel.mode = 1;
            } else {
                panel1.moveRight();
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            if (panel1.p.getLives() == 0) {
                Panel.mode = 2;
            } else {
                panel1.moveLeft();
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            if (panel1.p.getLives()== 0) {
                Panel.mode = 3;
            } else {
                panel1.moveDown();
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            if (panel1.p.getLives() == 4) {
                Panel.mode = 3;
            } else {
                panel1.moveUp();
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
//          w .start();
            //x=1;
            //public int y;
            panel1.remove();
        
        }
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            pause=false;
            ahmed=true;
            
        }
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            pause = true;
      //      System.out.println(pause);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
