import java.awt.*;

public class Tracer {

    private Ball b;
    private int delay;
    private int count = 0;
    public Tracer(Ball b,int delay) {
        this.b = b;
        this.delay = delay;
    }

    public void draw(Graphics g) {
        Color trans = new Color(0,0,255,127);
        g.setColor(trans);
        if(count > delay) {
            g.fillOval(b.pos[count-(delay+1)][0],b.pos[count-(delay+1)][1],b.getSize(),b.getSize());
        }
        count++;
        if(count == delay+11) {count = delay+1;}




    }

}
