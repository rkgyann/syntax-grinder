public class Car implements V_ehicle{

	public Car() {
		super();
	}

	@Override
	public void start() {
		// TODO: Implement start method
        System.out.println("Car is Starting.");
	}

	@Override
	public void stop() {
		// TODO: Implement stop method
        System.out.println("Car is Stopping.");
	}

    //addition method
    public void drift(){
        System.out.println("Car is Drifting");
    }
}
