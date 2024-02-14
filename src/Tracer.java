import java.awt.*;

public class Tracer {

    private Ball b;
    private int count = 0;
    public Tracer(Ball b) {
        this.b = b;
    }

    public void draw(Graphics g) {
        Color trans = new Color(0,0,255,127);
        g.setColor(trans);
        if(count > 4) {
            g.fillOval(b.pos[count-5][0],b.pos[count-5][1],b.getSize(),b.getSize());
        }
        count++;
        if(count == 15) {count = 5;}




    }

}
