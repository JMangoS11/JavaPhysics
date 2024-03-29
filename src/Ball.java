import java.awt.*;

public class Ball {
    private int x,y,size;
    private double energy;
    private double v;
    private double m;
    int count = 0;
    Tracer t1 = new Tracer(this,5);
    Tracer t2 = new Tracer(this,3);
    Tracer t3 = new Tracer(this,1);
    public int[][] pos = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
    public Ball(int x, int y, int size, double mass) {
        this.x = x;
        this.y = y;
        this.size = size;
        m = mass;
        energy = mass * PhysicsPanel.g * y+1000;
        v = 1;
    }

    public double getV() {return v;}
    public void setV(double v) {this.v = v;}
    public void changeV(double m) {v += m;}
    public int getSize() {
        return size;
    }
    public void setSize(int size) {this.size = size;}
    public void changeSize(int s) {size+= s;}
    public int[] getPos() {return new int[]{x, y};}
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    public void setEnergy(double e) {energy = e;}
    public void changeX(int x) {this.x += x;}
    public void changeY(int y) {this.y += y;}
    public double getEnergy() {return energy;}

    public void movement() {
        double pe = m * PhysicsPanel.g * y;
        double ke = energy - pe;
        v = Math.sqrt(2 * ke / m) / 10;
    }

    public void draw(Graphics g) {
        y += v;
        pos[count] = new int[]{x, y};
        count++;
        if(count == 10) {count = 0;}
        g.setColor(Color.BLACK);
        g.fillOval(x,y,size,size);
        t1.draw(g);
        t2.draw(g);
        t3.draw(g);

    }
}

