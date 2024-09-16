package vn.iostar.configs;

import java.sql.Connection;

import java.sql.DriverManager;

public class DBConnectSQL {
	private final String serverName = "SWEETLOVE";
	private final String dbName = "ltwebct4";
	private final String portNumber = "1433";
	private final String instance = "";
	
	
	private final String userID = "sa";
	private final String password = "Quan028@";

	public Connection getConnection() throws Exception{

	
				String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + " ;databaseName="
						+ dbName;

				if (instance == null || instance.trim().isEmpty())
					url = "jdbc:sqlserver://" + serverName + " ;databaseName="
							+ dbName;
				return DriverManager.getConnection(url, userID, password);
			
			
		
	}
	
	public static void main(String[] args) throws Exception {
        try {
        	System.out.println(new DBConnectSQL().getConnection());
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
}