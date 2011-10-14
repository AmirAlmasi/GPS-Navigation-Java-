
/*
 * TransparentBackground.java
 * Created on May, 3, 2011, 6:06:43 PM
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

/**
 * The class is used to make a transparent components.
 * @author Amir Almasi
 * @version 0.2
 */
public class TransparentBackground extends JComponent
        implements ComponentListener, WindowFocusListener, Runnable {

    // variable declration
    private JFrame _frame;
    private BufferedImage _background;
    private long _lastUpdate = 0;
    private boolean _refreshRequested = true;
    private Robot _robot;
    private Rectangle _screenRect;
    private ConvolveOp _blurOp;
    private Color c;

    /**
     * Constructor
     * @param frame
     * @param c
     */
    public TransparentBackground(JFrame frame, Color c) {
        _frame = frame;
        this.c = c;
        try {
            _robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            return;
        }
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        _screenRect = new Rectangle(dim.width, dim.height);
        float[] my_kernel = {
            0.10f, 0.10f, 0.10f,
            0.10f, 0.20f, 0.10f,
            0.10f, 0.10f, 0.10f};
        _blurOp = new ConvolveOp(new Kernel(3, 3, my_kernel));
        updateBackground();
        _frame.addComponentListener(this);
        _frame.addWindowFocusListener(this);
        new Thread(this).start();
    }

    /**
     *  A method to upgrade the background.
     */
    protected void updateBackground() {
        _background = _robot.createScreenCapture(_screenRect);
    }

    /**
     * A method to refresh the frame.
     */
    protected void refresh() {
        if (_frame.isVisible() && this.isVisible()) {
            repaint();
            _refreshRequested = true;
            _lastUpdate = System.currentTimeMillis();
        }
    }

    /**
     * A method to paint, beside that the information that we need 
     * is in this method to be paint.
     * @param g
     */
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Helvetica", Font.BOLD, 20);
        Point pos = this.getLocationOnScreen();
        BufferedImage buf = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        buf.getGraphics().drawImage(_background, -pos.x, -pos.y, null);
        Image img = _blurOp.filter(buf, null);
        g2.drawImage(img, 0, 0, null);
        g2.setFont(font);
        // information about the software.
        g2.drawString("GPS Development:", 20, 50);
        g2.drawString("System displays user's locations by connecting GPS ", 20, 100);
        g2.drawString(" unit to the user's laptop, Moreover, the shortest ", 20, 150);
        g2.drawString(" distance between user's location and selected destination is measured. ", 20, 200);
        g2.drawString(" An academic project carried out in 2011.", 20, 250);
        g2.setColor(new Color(250, 50, 50, 50));
//                g2.setColor(new Color(250,c.getGreen(),c.getBlue(),c.getAlpha()));
        g2.fillRect(0, 0, getWidth(), getHeight());

    }

    /**
     * 
     * @param e
     */
    public void componentHidden(ComponentEvent e) {
    }

    /**
     * A method to repaint the components.
     * @param e
     */
    public void componentMoved(ComponentEvent e) {
        repaint();
    }

    /**
     * A method to repaint the components.
     * @param e
     */
    public void componentResized(ComponentEvent e) {
        repaint();
    }

    /**
     * A method to repaint the components.
     * @param e
     */
    public void componentShown(ComponentEvent e) {
        repaint();
    }

    /**
     * A method to repaint the components.
     * @param e
     */
    public void windowGainedFocus(WindowEvent e) {
        refresh();
    }

    /**
     * A method to repaint the components.
     * @param e
     */
    public void windowLostFocus(WindowEvent e) {
        refresh();
    }

    /**
     * The run method to be used in threads.
     */
    public void run() {
        try {
            while (true) {
                Thread.sleep(100);
                long now = System.currentTimeMillis();
                if (_refreshRequested && ((now - _lastUpdate) > 1000)) {
                    if (_frame.isVisible()) {
                        Point location = _frame.getLocation();
                        _frame.setLocation(-_frame.getWidth(), -_frame.getHeight());
                        updateBackground();
                        _frame.setLocation(location);
                        refresh();
                    }
                    _lastUpdate = now;
                    _refreshRequested = false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
