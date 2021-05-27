package ro.ase.csie.cts.homework3.builder;

import ro.ase.csie.cts.homework3.ServerInterface;

public class Server implements ServerInterface{

	protected String ipAddress;
	protected int port;
	protected int maxConnections;
	protected boolean connected;
	protected boolean disconnected;
	
	private Server( ) {
		
	}
	
	private Server(String ipAddress, int port, int maxConnections, boolean connect, boolean disconnect) {
		super();
		this.ipAddress = ipAddress;
		this.port = port;
		this.maxConnections = maxConnections;
		this.connected = connect;
		this.disconnected = disconnect;
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
		this.connected = true;
		this.disconnected = false;
		return this.connected;
	}

	@Override
	public boolean disconnect() {
		this.connected = false;
		this.disconnected = true;
		return this.disconnected;
	}
	
	public static class ServerBuilder {
		
		private Server server = null;
		
		public ServerBuilder(String address, int port) {
			server = new Server();
			server.ipAddress = address;
			server.port = port;
		}
		
		public ServerBuilder addMaxConnections(int connections) {
			server.maxConnections = connections;
			return this;
		}
		
		public ServerBuilder addConnected(boolean connected) {
			server.connected = connected;
			return this;
		}
		
		public ServerBuilder addDisconnected(boolean disconnected) {
			server.disconnected = disconnected;
			return this;
		}
		
		public Server build() {
			return this.server;
		}
	}
}
