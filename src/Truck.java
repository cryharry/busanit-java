class Truck extends Car{

	public void  speedUp(int speed) {
		velocity += speed;
		
		if(velocity > 100)
			velocity = 100;
	}
	
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Car myCar;
		Truck myTruck;
		
		myTruck = new Truck();
		myTruck.speedUp(200);
		System.out.println("속도는 " + myTruck.velocity);
		
		//myCar = new Car();
		
		myCar = (Car)myTruck;
		System.out.println("속도는 " +myCar.velocity ); 

	}

	@Override
	public void speedDown(int speed) {
		// TODO 자동 생성된 메소드 스텁
		
	}

}
