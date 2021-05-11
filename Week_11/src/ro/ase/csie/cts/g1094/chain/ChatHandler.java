package ro.ase.csie.cts.g1094.chain;

public abstract class ChatHandler {
	ChatHandler next;
	
	public ChatHandler getNext() {
		return next;
	}

	public void setNext(ChatHandler next) {
		this.next = next;
	}

	public abstract void processMessage(Message msg);
}
