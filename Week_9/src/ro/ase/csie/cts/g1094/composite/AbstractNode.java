package ro.ase.csie.cts.g1094.composite;

public abstract class AbstractNode implements NPCActions{
	public abstract void addNewNode(AbstractNode node);
	public abstract void deleteNode(AbstractNode node);
	public abstract AbstractNode getNode(int index);
}
