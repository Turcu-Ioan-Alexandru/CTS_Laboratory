package ro.ase.csie.cts.homework3.prototype;

import ro.ase.csie.cts.homework3.ServerInterface;
import ro.ase.csie.cts.homework3.singleton.ServerSingleton;

public class ServerPrototype implements ServerInterface, Cloneable{

	private static ServerSingleton server;
	
	private String ipAddress;
	private int port;
	private int maxConnections;
	private boolean hasConnection;
	private boolean isDisconnected;
	
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
		this.setConnectStatus(true);
		this.isDisconnected = false;
		return this.getConnectStatus();
	}

	@Override
	public boolean disconnect() {
		this.setConnectStatus(false);
		this.isDisconnected = true;
		return this.isDisconnected;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		ServerPrototype prototype = new ServerPrototype();
		prototype.ipAddress = this.ipAddress;
		prototype.port = this.port;
		prototype.maxConnections = this.maxConnections;
		prototype.setConnectStatus(this.getConnectStatus());
		prototype.isDisconnected = this.isDisconnected;
		
		return prototype;
	}
	
	private ServerPrototype() {
		
	}

	public ServerPrototype(String ipAddress, int port, int maxConnections, boolean connect, boolean disconnect) {
		this.ipAddress = ipAddress;
		this.port = port;
		this.maxConnections = maxConnections;
		this.hasConnection = connect;
		this.isDisconnected = disconnect;
	}

	public boolean getConnectStatus() {
		return hasConnection;
	}

	public void setConnectStatus(boolean connectStatus) {
		this.hasConnection = connectStatus;
	}
}
