/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourgame;

import java.awt.EventQueue;

import javax.swing.JFrame;
/**
 *
 * @author Me4
 */
public class OurGame extends JFrame {

    public OurGame(){
        initilize();
    }
    private void initilize(){
        add( new Scene() );
        setSize(800, 600);
        
        //setTitle('Our Game');
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run(){
                OurGame ex = new OurGame();
                ex.setVisible(true);
            }
        });
    }
    
}
