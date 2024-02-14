import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhysicsPanel extends JPanel implements Runnable {

    Ball b = new Ball(300,100,30, 10);

    public static int g = -10;

    private Thread time;

    private final int DELAY = 25;
    public long t = System.currentTimeMillis();
    public PhysicsPanel() {
        setPreferredSize(new Dimension(800, 550));
        setFocusable(true);

        JSlider slide = new JSlider(0,300,10);
        slide.setPaintTrack(true);
        JLabel l = new JLabel();
        l.setText("Gravity = " + slide.getValue());
        slide.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                g = -1*slide.getValue();
                l.setText("Gravity = " + slide.getValue());
            }
        });
        JButton reset = new JButton("RESET");
        reset.addActionListener(e -> {
            b.setV(0);
            g = -10;
            slide.setValue(10);
            b.setY(100);
        });
        add(l);
        add(slide);
        add(reset);
    }
    public void movement() {
        //ball
        b.movement();
        //b.changeV(-1*(g/10));
        //if(b.getPos()[1] >=500) {b.changeV(-1*2*(b.getV()) - (g/10));}

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        b.draw(g);

    }
    @Override
    public void addNotify() {
        super.addNotify();

        time = new Thread(this);
        time.start();
    }
    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
        while (true) {
            movement();
            repaint();
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                time.sleep(sleep);
            } catch (InterruptedException e) {

                String msg = String.format("Thread interrupted: %s", e.getMessage());

                JOptionPane.showMessageDialog(this, msg, "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            beforeTime = System.currentTimeMillis();
        }
    }
}
