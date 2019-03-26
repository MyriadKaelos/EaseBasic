import Ease.Ease;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static java.awt.Color.*;

public class Example2 extends Ease {
    public int x;
    public int changeInX;
    public int y;
    public int changeInY;
    public int ccInY;
    public Enemy[] enemies;
    public int time;
    public boolean game = true;
    public int level;
    public Example2(int width, int height) throws InterruptedException {
        super(width, height, 25);
        this.x = width/2;
        this.y = 3*height/4;
        this.changeInX = 0;
        this.changeInY = 0;
        this.ccInY = 0;
        this.enemies = new Enemy[0];
        this.time = 0;
        this.level = 0;
    }
    public void paint() {
        if(game) {
            rect(0,(3*height/4)+10,width,height/4,green);
            time++;
            if (time > 50) {
                level++;
                time = 0;
                Enemy[] e = enemies;
                enemies = new Enemy[e.length + 1];
                for (int i = 0; i < e.length; i++) {
                    enemies[i] = e[i];
                }
                enemies[e.length] = new Enemy((int)(Math.random()*width),0,level);
            }
            rect(x, y, 10, 10, black);
            if (x + changeInX > width - 10 || x + changeInX < 0) {
                changeInX = 0;
            }
            x += changeInX;
            if(y + changeInY < 0) {changeInY = 0;}
            if (y + changeInY > 3 * height / 4) {
                changeInY = 0;
                ccInY = 0;
                y = 3*width/4;
            }
            y += changeInY;
            changeInY += ccInY;
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i].upDate(x, y)) {
                    System.out.println("DEAD");
                    game = false;
                    System.out.println("Press any Key to Try AGAIN");
                }
                rect(enemies[i].eX, enemies[i].eY, 10, 10, red);
            }
            text(100,100,"Score: " + String.valueOf(level*50+time),blue);
        }
    }
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a') {
            changeInX = -(4+level/5);
        } else if(e.getKeyChar() == 'd') {
            changeInX = (4+level/5);
        } else if(e.getKeyChar() == 's') {
            changeInX = 0;
            changeInY = 0;
        } else if(e.getKeyChar() == 'w') {
            ccInY = +1;
            changeInY = -(7+level/5);
        }
    }
    public void keyTyped(KeyEvent e) {
        if(!game) {
            enemies = new Enemy[0];
            time = 0;
            x = width/2;
            y = 3*height/4;
            game = true;
            level = 0;
        }
    }
}
