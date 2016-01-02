/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourgame;

import java.awt.Color;
import java.awt.Graphics;


public class Character extends Hero
{      
    int center = (int)(getWidth()/2);
        
    int head = (int)(getHeight()/4);
    int legs = (int)(getHeight()/4);
    int torso = (int)((getHeight()) / 2.5);
    int arms = 30;
        
    public Character(){}  
        
    public void setValues(int x1, int y1, int width1, int height1) {
        x = x1;
        y = y1;
        width = width1;
        height = height1;
    }
	
    public void draw(Graphics g) 
    {
        g.setColor(Color.black);
        torso(g);
        legs(g);
        head(g);
        arms(g);
    }
        
    private void torso(Graphics g)
    {  
        g.drawLine( 
            getX() + center,
            getY() + head, 
            getX() + center, 
            getY() + head + torso
        );
    }
        
    private void legs(Graphics g)
    {
        //RIGHT LEG
        g.drawLine( 
            getX() + center,
            getY() + head + torso, 
            getX() + getWidth(), 
            getY() + getHeight()
        );
            
            //LEFT LEG
        g.drawLine( 
            getX() + center,
            getY() + head + torso, 
            getX(), 
            getY() + getHeight()
        );
    }
        
    private void head(Graphics g)
    {
        g.drawRect( 
            getX() + center - (int)(head/2), 
            getY(), 
            head, 
            head
        );
    }
        
    private void arms(Graphics g)
    {
        g.drawLine( 
            getX() + center,
            getY() + head + (int)(torso/3), 
            getX(), 
            getY() + head + (int)(torso*3)/4
        );
            
        g.drawLine( 
            getX() + center,
            getY() + head + (int)(torso/3), 
            getX() + getWidth(), 
            getY() + head + (int)(torso*3)/4
        );
    }
        
        
    @Override
    public int getX() {
	return x;
    }
	
    @Override
    public int getY() {
	return y;
    }

    @Override
    public int getWidth() {
	return width;
    }

    @Override
    public int getHeight() {
	return height;
    }
}
    