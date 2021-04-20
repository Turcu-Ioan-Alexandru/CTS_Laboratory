package ro.ase.csie.cts.g1094.composite;

public class NPC extends AbstractNode{

	String name;
	int power;
	
	
	
	@Override
	public void addNewNode(AbstractNode node) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteNode(AbstractNode node) {
		throw new UnsupportedOperationException();
	}

	@Override
	public AbstractNode getNode(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void move() {
		System.out.println(String.format("%s is moving, name"));
	}

	@Override
	public void attack() {
		System.out.println(String.format("%s is attacking, name"));
		
	}

	@Override
	public void retreat() {
		System.out.println(String.format("%s is retreating, name"));
	}

	public NPC(String name, int power) {
		super();
		this.name = name;
		this.power = power;
	}
}
