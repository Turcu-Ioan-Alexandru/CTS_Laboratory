package ro.ase.csie.cts.g1094.chain;

public class TestChain {

	public static void main(String[] args) {
		
		ChatHandler languageFilter = new ChatFilter("English");
		ChatHandler privateChat = new PrivateChat();
		ChatHandler globalChat = new GlobalChat();
		
		languageFilter.setNext(privateChat);
		privateChat.setNext(globalChat);
		
		ChatHandler chatServer = languageFilter;
		
		//chatServer.processMessage(new Message("@everyone", "kill him", 10));
	}

}
