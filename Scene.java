/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author Me4 and me
 */
public class Scene extends JPanel implements ActionListener {
    
    private Timer timer;
    private Hero hero;
    private final int DELAY = 10;
    
    public Scene(){
        initilize();
    }
    
    private void initilize(){
        addKeyListener( new TAdapter() );
        setFocusable(true);
        setBackground(Color.CYAN);
        
        hero = new Hero();
        
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        hero.paint(g);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        hero.move();
        hero.gravity();
        repaint();
    }
    
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            hero.keyPressed(e);
        }
        
        @Override
        public void keyReleased(KeyEvent e){
            hero.keyReleased(e);
        }
    }
    
}
