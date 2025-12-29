//package JAVA.Internshala.Exercise_Questions;

public class Rectangle implements Drawable, Resizable{
    
    private int width;
    private int height;
    private String Color;

    public Rectangle(int width,int height){
        this.width=width;
        this.height=height;
    }

    @Override
    public void draw(){
        System.out.println("Rectangle is drawn with width: "+width+" & height: "+height);
    }

    @Override
    public void resize(int width, int height){
        this.width=width;
        this.height=height;
        System.out.println("New Width is: "+width+"New Height is: "+height);
    }

    public void color(String Color){
        this.Color=Color;
        System.out.println("The Color of Rectangle is: "+Color);
    }
}
