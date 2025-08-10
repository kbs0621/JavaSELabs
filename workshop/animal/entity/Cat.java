package workshop.animal.entity;

public class Cat extends Animal implements Pet{
	private String name;
	
	public Cat(String name) {
		super(4);
		this.name = name;
	}
	
	// public Aniaml()
	public Cat() {
		//super();
		this("");
	}
	
	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public void play() {
		System.out.println("고양이는 공을 가지고 놀아요!");
	}

	@Override
	public void eat() {
		System.out.println("고양이는 쥐를 먹어요");
		
		
	}
	
	
}
