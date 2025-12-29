import java.util.Random;

class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

public class CircleArray {
    public static void main(String[] args) {
        Circle[] circleArray = new Circle[5];
        Random rand = new Random();
        double totalArea = 0;

        for (int i = 0; i < circleArray.length; i++) {
            double r = rand.nextDouble() * 10;
            circleArray[i] = new Circle(r);
            totalArea += circleArray[i].area();
        }
        System.out.println("Total area: " + totalArea);
    }
}
