package observer;

public class AutoSaveModule implements NetworkStatusHandlerInterface{

	@Override
	public void connectionDown() {
		System.out.println("Create a local copy");
		
	}

	@Override
	public void connectionUp() {
		// TODO Auto-generated method stub
		System.out.println("Reloading game level");
	}

}
