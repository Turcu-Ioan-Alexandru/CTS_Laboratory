package ro.ase.csie.cts.g1094.composite;

import java.util.*;
import java.util.function.*;


public class Group extends AbstractNode{

	String description;
	List <AbstractNode> nodes = new ArrayList<>();
	
	
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(String playerName) {
		for(AbstractNode node : nodes) {
			node.attack(playerName);
		}
		
	}

	@Override
	public void retreat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNewNode(AbstractNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNode(AbstractNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AbstractNode getNode(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public Group(String description) {
		super();
		this.description = description;
	}

}
