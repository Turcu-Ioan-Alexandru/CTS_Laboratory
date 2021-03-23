package ro.ase.csie.cts.g1094.singleton;

public class DbConnection {
	String connString;
	String schema;
	
	private DbConnection() {
		System.out.println("Creating a connection");
		System.out.println("Loading config");
		this.connString = "127.0.0.1:1443";
		this.schema = "cts";
	}
	
	private static DbConnection connection = null;
	
	private DbConnection(String connection, String schema) {
		super();
		this.connString = connection;
		this.schema = schema;
	}
	
	public static DbConnection getConnection() {
		if(DbConnection.connection == null) {
			connection = new DbConnection();
		}
		return DbConnection.connection;
	}
	
	//this is misleading, not clean
	//others will think they have multiple connections
	public static DbConnection getConnection(String conn, String schema) {
		if(DbConnection.connection == null) {
			connection = new DbConnection(conn, schema);
		}
		return DbConnection.connection;
	}
}
