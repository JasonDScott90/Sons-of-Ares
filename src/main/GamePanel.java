package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {

    private final int SCREEN_WIDTH = 600;
    private final int SCREEN_HEIGHT = 600;

    private MouseInputs mouseInputs;
    public float xDelta = 100, yDelta = 100;
    private float xDir = 1f, yDir = 1f;
    private Color color = Color.gray;
    private Random random;

    public GamePanel(){
        random = new Random();
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

    }

    public void changeYDelta(int value){
        this.yDelta += value;

    }

    public void setRectPos(int x, int y){
        this.xDelta = x;
        this.yDelta = y;

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // draw title on background, might need to do it differently
        drawTitle(g);

        // mouse follower thing
        g.setColor(color);
        updateRectangle();
        g.fillRoundRect((int)xDelta, (int)yDelta, 20, 20, 5, 5);



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
    private void updateRectangle(){
        xDelta += xDir;
        if(xDelta > 400 || xDelta < 0) {
            xDir *= 1;
            color = getRndColor();
        }
        yDelta += yDir;
        if(yDelta > 400 || yDelta < 0) {
            yDir *= 1;
            color = getRndColor();
        }
    }

    private Color getRndColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color(r,g,b);
    }
}
