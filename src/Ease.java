import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Ease extends JPanel implements KeyListener, MouseListener {
    private boolean start = false;
    public int mouseX;
    public int mouseY;
    public int height;
    public int width;
    public int refreshRate;
    private Frame frame;
    private Graphics2D g2d;
    private Timer t;
    private boolean close = false;

    public Ease(int width, int height, int refreshRate) throws InterruptedException {
        JFrame frame = new JFrame("Game");
        frame.add(this);
        frame.addKeyListener(this);
        frame.addMouseListener(this);
        frame.setVisible(true);
        frame.setSize(width, height + 22);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        this.frame = frame;
        this.width = width;
        this.height = height;
        //setting common defaults for a screen.^^^
        this.refreshRate = refreshRate;
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.err.println("EXIT.");
                System.exit(0);
            }
        });
    }
    public void paintComponent(Graphics g) {
        g2d = (Graphics2D)g;
        new Timer(refreshRate, taskPerformer).start();
        mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX() - frame.getX();
        mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY() - frame.getY();
        paint();
        if(close) {
            System.exit(0);
        }
    }

    ActionListener taskPerformer = evt -> {
        repaint();
    };
    public void paint() {}

    public void rect(int x, int y, int w, int h, Color c) {
        g2d.setColor(c);
        g2d.fillRect(x,y,w,h);
    }
    public void pixel(int x,int y,Color c) {
        g2d.setColor(c);
        g2d.fillRect(x,y,1,1);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}