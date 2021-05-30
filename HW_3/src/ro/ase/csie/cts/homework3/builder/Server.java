package ro.ase.csie.cts.homework3.builder;

import ro.ase.csie.cts.homework3.ServerInterface;

public class Server implements ServerInterface{

	public String ipAddress;
	public int port;
	public int maxConnections;
	public boolean hasConnection;
	public boolean isDisconnected;
	
	private Server( ) {
		
	}
	
	private Server(String ipAddress, int port, int maxConnections, boolean connect, boolean disconnect) {
		super();
		this.ipAddress = ipAddress;
		this.port = port;
		this.maxConnections = maxConnections;
		this.hasConnection = connect;
		this.isDisconnected = disconnect;
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
		this.hasConnection = true;
		this.isDisconnected = false;
		return this.hasConnection;
	}

	@Override
	public boolean disconnect() {
		this.hasConnection = false;
		this.isDisconnected = true;
		return this.isDisconnected;
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
			server.hasConnection = connected;
			return this;
		}
		
		public ServerBuilder addDisconnected(boolean disconnected) {
			server.isDisconnected = disconnected;
			return this;
		}
		
		public Server build() {
			return this.server;
		}
	}
}
