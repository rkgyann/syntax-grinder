public interface V_ehicle {
    
    //abstract
    void start();
    void stop();

    //defaults methods
    default void honk(){
        System.out.println("Honking the Horn");
    }

    //static methods
    static void sevice(){
        System.out.println("Vehicle is Serviced.");
    }
}
