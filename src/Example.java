import Ease.Ease;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static java.awt.Color.black;

public class Example extends Ease {
    Data d;
    int x;
    boolean left;
    public Example(int width, int height) throws InterruptedException {
        super(width, height, 50);
        d = new Data("Hello",7);
        x = 0;
        left = false;
    }
    public void paint() {
        rect(x,height/2,10,10,black);
        if(x < 0) left = false;
        if(x > width-10) left = true;
        x+=(left)?-3:3;
    }
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a') {
            System.err.println(d.getString());
        } else if(e.getKeyChar() == 'c' || e.getKeyChar() == 'v') {
            if (left) {
                left = false;
            } else {
                left = true;
            }
        } else {
            System.err.println(d.parseString("world"));
        }
    }
    public void mouseClicked(MouseEvent e) {
        System.err.println(mouseX + " : " + mouseY + " " + d.i);
    }
}
