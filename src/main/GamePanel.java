package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final int SCREEN_WIDTH = 600;
    private final int SCREEN_HEIGHT = 600;

    private MouseInputs mouseInputs;
    public int xDelta = 100, yDelta = 100;

    public GamePanel(){
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        setFocusable(true);

        // Background color
        this.setBackground(Color.darkGray);
    }

    public void changeXDelta(int value){
        this.xDelta += value;
        repaint();
    }

    public void changeYDelta(int value){
        this.yDelta += value;
        repaint();
    }

    public void setRectPos(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // draw title on background, might need to do it differently
        drawTitle(g);

        // mouse follower thing
        g.setColor(Color.gray);
        g.fillRoundRect(xDelta, yDelta, 20, 20, 5, 5);

    }

    public void drawTitle(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("FUTURA", Font.ITALIC, 50));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.setColor(Color.RED);
        g.drawString("SONS OF ARES", (SCREEN_WIDTH - metrics2.stringWidth("SONS OF ARES")) / 2, SCREEN_HEIGHT / 2);
        g.setColor(Color.GRAY);
        g.drawString("SONS OF ARES", (SCREEN_WIDTH - metrics2.stringWidth("SONS OF ARES")) / 2 -1, SCREEN_HEIGHT / 2 -1);

    }
}
