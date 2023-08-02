package main;

import inputs.KeyboardInputs;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow(GamePanel gamePanel){
        JFrame jFrame = new JFrame();
        jFrame.setSize(600, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        
    }
}
