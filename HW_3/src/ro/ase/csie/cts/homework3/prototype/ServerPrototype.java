package ro.ase.csie.cts.homework3.prototype;

import ro.ase.csie.cts.homework3.ServerInterface;
import ro.ase.csie.cts.homework3.singleton.ServerSingleton;

public class ServerPrototype implements ServerInterface, Cloneable{

	private static ServerSingleton server;
	
	private String ipAddress;
	private int port;
	private int maxConnections;
	private boolean connectStatus;
	private boolean disconnect;
	
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
		this.disconnect = false;
		return this.getConnectStatus();
	}

	@Override
	public boolean disconnect() {
		this.setConnectStatus(false);
		this.disconnect = true;
		return this.disconnect;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		ServerPrototype prototype = new ServerPrototype();
		prototype.ipAddress = this.ipAddress;
		prototype.port = this.port;
		prototype.maxConnections = this.maxConnections;
		prototype.setConnectStatus(this.getConnectStatus());
		prototype.disconnect = this.disconnect;
		
		return prototype;
	}
	
	private ServerPrototype() {
		
	}

	public ServerPrototype(String ipAddress, int port, int maxConnections, boolean connect, boolean disconnect) {
		this.ipAddress = ipAddress;
		this.port = port;
		this.maxConnections = maxConnections;
		this.connectStatus = connect;
		this.disconnect = disconnect;
	}

	public boolean getConnectStatus() {
		return connectStatus;
	}

	public void setConnectStatus(boolean connectStatus) {
		this.connectStatus = connectStatus;
	}
}
