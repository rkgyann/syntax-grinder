class Shape {
    void draw(){
        System.out.println("Drawing a Shape");
    }
}

//Derived class
class Circle extends Shape {
    void drawCircle() {
        System.out.println("Drawing a Circle");
    }
}

//another derived class
class ColoredCircle extends Circle {
    void drawColoredCircle() {
        System.out.println("Drawing a Colored Circle");
    }
}
