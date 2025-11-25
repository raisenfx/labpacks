// Lab 7 icin.

public class PointCircleDemo {
    public static void main(String[] args) {
        
        Point p1 = new Point(3, 4);
        p1.printPoint();

        Circle c1 = new Circle(p1, 5);
        System.out.println();
        c1.printCircle();

        Point p2 = new Point(10, 12);

        double dist = p1.distance(p2);
        System.out.println("\nDistance between p1 and p2 = " + dist);
    }
}

