package observer;

public class UINotificationsModule implements NetworkStatusHandlerInterface{

	@Override
	public void connectionDown() {
		// TODO Auto-generated method stub
		System.out.println("Alert: Connection lost");
	}

	@Override
	public void connectionUp() {
		// TODO Auto-generated method stub
		System.out.println("Alert: Lets play again!");
	}

}
