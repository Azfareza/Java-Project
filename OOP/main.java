public class main {
    public static void main(String[] args) {
        MyPoint pointA = new MyPoint();  MyPoint pointB = new MyPoint(10, 30.5);
        double a = 0, b = 0, x = 10, y = 30.5; 

        System.out.println("Jarak dari point A ke point B: " + pointA.distance(pointB));
        System.out.println("Jarak dari kordinat x, y (" + x + ", " + y + ")" + " ke a, b (" + a + ", " + b + "): " + MyPoint.distance(a, b, x, y));
        System.out.println("Jarak dari point A ke kordinat (" + x + ", " + y + "): " + pointA.distance(x, y) + "\n\n");
    }
}

