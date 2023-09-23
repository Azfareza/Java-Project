public class MyPoint {
    private double x, y;
    MyPoint() {
        this(0, 0);
    }

    MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double xCor() {
        return x;
    }

    public double yCor() {
        return y;
    }


    public double distance(double a, double b) {
        return 
            Math.sqrt(Math.pow(a - x, 2) + Math.pow(b - y, 2));
    }

    public static double distance(double a, double b, double x, double y) {
        return 
             Math.sqrt(Math.pow(a - x, 2) + Math.pow(b - y, 2));
    }

    public double distance(MyPoint point2) {
        return 
            Math.sqrt(Math.pow(point2.xCor() - x, 2) + Math.pow(point2.yCor() - y, 2));
    }
}
