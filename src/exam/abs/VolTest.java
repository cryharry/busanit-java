package exam.abs;

interface Volume {
	public void volumeUp(int level);
	public void volumeDown(int level);
}

class TV implements Volume {
	private int VolLevel;
	
	public void TV() {
		VolLevel = 0;
	}
	
	public void volumeUp(int level) {
		System.out.println("TV 볼륨을 올려요");
		VolLevel += level;
	}
	
	public void volumeDown(int level) {
		System.out.println("TV 볼륨을 내려요");
		VolLevel -= level;
		if(VolLevel < 0)
			VolLevel = 0;
	}
}

class Radio implements Volume {
	private int VolLevel;
	
	public Radio() {
		VolLevel = 0;
	}
	public void volumeUp(int level) {
		System.out.println("라디오 볼륨을 올려요");
		VolLevel += level;
	}
	public void volumeDown(int level) {
		System.out.println("라디오 볼륨을 내려요");
		VolLevel -= level;
	}
}

interface AdvancedVolume extends Volume {
	public void volumeOff();
	public void volumeResume();
}

class Walkman implements AdvancedVolume {
	private int VolLevel;
	private int TmpVol;
	
	public Walkman() {
		VolLevel = 0;
	}
	
	public void volumePrint() {
		System.out.println("워크맨 볼륨은 " + VolLevel);
	}
	
	public void volumeOff() {
		// TODO 자동 생성된 메소드 스텁
		TmpVol =  VolLevel;
		VolLevel = 0;
		System.out.println("워크맨 볼륨을 꺼요");
		
	}
	public void volumeResume() {
		// TODO 자동 생성된 메소드 스텁
		VolLevel = TmpVol;
		System.out.println("워크맨 볼륨을 켜요");
		
	}
	public void volumeDown(int level) {
		// TODO 자동 생성된 메소드 스텁
		System.out.println("워크맨에 볼륨을 내려요");
		VolLevel -= level;
		
	}
	public void volumeUp(int level) {
		// TODO 자동 생성된 메소드 스텁
		System.out.println("워크맨 볼륨을 올려요");
		VolLevel += level;
	}
	
}

class Speaker implements Volume {
	private int VolLevel;
	
	public Speaker() {
		VolLevel = 0;
	}

	public void volumeDown(int level) {
		System.out.println("스피커 볼륨을 내려요");
		VolLevel -= level;
		if(VolLevel < 0)
			VolLevel = 0;
		
	}

	public void volumeUp(int level) {
		System.out.println("스피커 볼륨을 올려요");
		VolLevel += level;
		if(VolLevel > 100)
			VolLevel = 100;
		
	}
	
}

public class VolTest {
	public static void main(String args[]) {
		Radio radio = new Radio();
		TV tv = new TV();
		Speaker speaker = new Speaker();
		Volume vol[] = new Volume[4];
		Walkman walk = new Walkman();
		
		vol[0] = radio;
		vol[1] = tv;
		vol[2] = speaker;
		vol[3] = walk;
		
		radio.volumeUp(1);
		tv.volumeUp(1);
		speaker.volumeUp(1);
		System.out.println("");
		
		walk.volumeUp(10);
		walk.volumePrint();
		walk.volumeDown(5);
		walk.volumePrint();
		walk.volumeOff();
		walk.volumePrint();
		walk.volumeResume();
		walk.volumePrint();
		
		System.out.println("");
		System.out.println("이제부터는 인터페이스를 이용한 호출입니다요");
		
		for(int i=0; i<vol.length; i++)
			vol[i].volumeUp(1);
	}
}