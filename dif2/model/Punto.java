package dif2.model;

public class Punto {
    private int x,y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distancia (Punto p) {
        int dx = this.x - p.x;
        int dy = this.y - p.y;
        return dx * dx + dy * dy;
    }
}