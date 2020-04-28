/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 */
public class Factory {
    public wall getWall(String wallName)
    {
        try{
        if(wallName.equalsIgnoreCase("Stones"))
            return new Stones();
        else if(wallName.equalsIgnoreCase("Trees"))
           return new Trees();
        else
           return null;
        }
        catch (NullPointerException e){
        }
        return null;     
    }
    
}
