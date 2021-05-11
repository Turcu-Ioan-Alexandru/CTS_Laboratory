package ro.ase.csie.cts.g1094.chain;

public class ChatFilter extends ChatHandler{
	String language;
	
	public static String[] forbiddenWords = new String[] { "hate", "violent", "kill", "attack"};
	
	@Override
	public void processMessage(Message msg) {
		boolean isOk = true;
		for(String word : forbiddenWords) {
			if(msg.text.toLowerCase().contains(word))
			{
				isOk = false;
				break;
			}
		}
		
		if(!isOk) {
			System.out.println("Messsage not allowed");
		} 
		else {
			if(this.next != null) {
				this.next.processMessage(msg);
			}
		}
	}

	public ChatFilter(String language) {
		super();
		this.language = language;
	}
}
