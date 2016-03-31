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
public class Hero extends JPanel 
{
    
    int x = 50;
    int y = 700;
    
    int width = 40;
    int height = 120;
    
    double speed = 0;
    double boost = 1.2;
    double acceleration = 0; // value set to 0.1 when button pressed.
    int maxSpeed = 10;
    boolean speedReleased = false;
    
   // double fallSpeed = 0;
   //  double fallSpeedSquared = 0;
   // double fallAcceleration = 0.1;
   // int maxFallSpeed = 24;
    
    double jump = 0;
    double fall = 0;
    double peak = 0; // max value of total jump == speed * -10
    double velocity = 0; // set to -10 once jump is pressed
    boolean inMotion = false;
    double jumpSpeed = 0; // is set to the speed achieved prior to the jump.
    
    
    public Hero(){
        initilize();
    }
    
    private void initilize()
    {
    }
    
    public void move(){
        speed += acceleration;
        if(inMotion == false){            
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
            if(speedReleased == true){
                speed = 0;
                acceleration =0;
                speedReleased = false;
            }
        } else if(inMotion == true) {
            speed = jumpSpeed;
        }
        
        
        x += speed;
    }
    
    public void gravity(){
        
        
        
        if(peak >= 0){
            velocity -= jump;
            fall += velocity;
            if(fall <= peak){
                y -= velocity;                
            } else {
                y += velocity;
            }    
        }
        if(y > 700){
            velocity = 0;
            jump = 0;
            inMotion = false;
            fall = 0;
            peak = 0;
            y = 700;
            jumpSpeed = 0;
            speed -= (acceleration*5);
            //System.out.print("landed");
        }
        
       /*
        fallSpeed += fallAcceleration;
        fallSpeedSquared = fallSpeed * (fallSpeed * 0.5);
        if (fallSpeedSquared > maxFallSpeed){
            fallSpeedSquared = maxFallSpeed;
        }
        fallSpeedSquared += jump;
        y += fallSpeedSquared;
        if(y > 700){
            fallSpeed = 0;
            jump = 0;
            y = 700;
        }
       */
    }
        
    @Override
    public void paint(Graphics g) 
    {
        Character Jerry = new Character(); 
        Jerry.setValues(x,y,width,height);
        Jerry.draw(g);
    }

    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
            acceleration = -0.1;
        }
        if (key == KeyEvent.VK_RIGHT){
            acceleration = 0.1;
        }
        if (key == KeyEvent.VK_SPACE){
            if(inMotion == false){
                if(speed != 0){
                    inMotion = true;
                    jump = Math.abs(speed * 0.1);
                    peak = Math.abs(speed) * 350;
                    velocity = Math.abs(speed) * 3.5;
                    jumpSpeed = speed;
                }
            }
        }        
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
            acceleration = 0;
            speed = 0;
            speedReleased = true;
        }
        if (key == KeyEvent.VK_RIGHT){            
            acceleration = 0;
            speed = 0;
            speedReleased = true;
        }
        if (key == KeyEvent.VK_SPACE){
           // jump = 0;
        }        
    }
    

}
