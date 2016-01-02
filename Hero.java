/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourgame;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 *
 * @author Me4
 */
public class Hero extends JPanel {
    
    double x = 400;
    double y = 0;
    
    double speed = 0;
    double boost = 2.2;
    double acceleration = 0;
    int maxSpeed = 30;
    
    double fallSpeed = 0;
    double fallSpeedSquared = 0;
    double fallAcceleration = 0.1;
    int maxFallSpeed = 24;
    
    int jump = 0;

    public Hero(){
        initilize();
    }
    
    private void initilize(){
        
    }
    
    public void move(){
        speed += acceleration;
        if(speed > maxSpeed)
            speed = maxSpeed;
        if(speed < -maxSpeed){
            speed = -maxSpeed;
        }
        if(speed > 0 && speed <= boost)
            speed = boost;
        if(speed < 0 && speed >= -boost){
            speed = -boost;
        }
        x += speed;
    }
    
    public void gravity(){
        
        fallSpeed += fallAcceleration;
        fallSpeedSquared = fallSpeed * (fallSpeed * 0.5);
        if (fallSpeedSquared > maxFallSpeed){
            fallSpeedSquared = maxFallSpeed;
        }
        fallSpeedSquared += jump;
        y += fallSpeedSquared;
        if(y > 500){
            fallSpeed = 0;
            jump = 0;
            y = 500;
        }
    }
    
    public void paint(Graphics g) {
        g.drawRect ((int) x, (int) y, 10, 10);  
    }
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
            acceleration = -0.5;
        }
        if (key == KeyEvent.VK_RIGHT){
            acceleration = 0.5;
        }
        if (key == KeyEvent.VK_SPACE){
            jump =-12;
        }        
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT){            
            acceleration = 0;
            speed = 0;
        }
        if (key == KeyEvent.VK_RIGHT){            
            acceleration = 0;
            speed = 0;
        }
        if (key == KeyEvent.VK_SPACE){
            jump = -5;
        }        
    }
}
