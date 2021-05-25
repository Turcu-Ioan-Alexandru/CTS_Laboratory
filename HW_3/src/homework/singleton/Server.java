package homework.singleton;

import homework.server.ServerInterface;

/**
 * @author Alex
 *
 */
public class Server implements ServerInterface{

	private static Server server;
	
	private String ipAddress;
	private int port;
	private int maxConnections;
	private boolean connect;
	private boolean disconnect;
	
	private Server(String ipAddress, int port, int maxConnections, boolean connect, boolean disconnect) {
		this.ipAddress = ipAddress;
		this.port = port;
		this.maxConnections = maxConnections;
		this.connect = connect;
		this.disconnect = disconnect;
	}
	
	@Override
	public String getIpAddress() {
		return "IP Address: " + this.ipAddress;
	}

	@Override
	public int getPort() {
		return this.port;
	}

	@Override
	public int getMaxConnections() {
		return this.maxConnections;
	}

	@Override
	public boolean connect() {
		this.connect = true;
		this.disconnect = false;
		return this.connect;
	}

	@Override
	public boolean disconnect() {
		this.connect = false;
		this.disconnect = true;
		return this.disconnect;
	}
	
	public static Server getInstance() {
		if(server == null) {
			String address = "placeholer";
			int port = (int) Math.random();
			int maxConnect = 100;
			boolean connected = true;
			boolean disconnect = false;
			server = new Server(address, port, maxConnect, connected, disconnect);
		}
		return server;
	}
}
