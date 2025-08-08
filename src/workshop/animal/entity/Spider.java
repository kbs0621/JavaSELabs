package workshop.animal.entity;

public class Spider extends Animal {
	
	public Spider() {
		super(8);
	}
	
	@Override
	public void eat() {
		System.out.println("거미는 곤충을 먹어요!");

	}

}
