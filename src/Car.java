
abstract class Car {
	protected int velocity;
	protected int wheelNum;
	protected String carName;
	
	abstract public void speedUp(int speed);
	
	abstract public void speedDown(int speed);
	
	public void stop() {
		velocity = 0;
	}

}
