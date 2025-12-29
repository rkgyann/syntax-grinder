public class V_ehicle_Application {
    public static void main(String[] args) {
        
        Car mycar=new Car();
        mycar.start();
        mycar.stop();
        mycar.drift();

        //static -> class, not object
        V_ehicle.sevice();
        
        mycar.drift();//default
    }
}
 