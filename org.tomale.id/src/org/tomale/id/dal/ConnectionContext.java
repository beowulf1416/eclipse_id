package org.tomale.id.dal;

public class ConnectionContext {

	String _name = "";
	String _host = "";
	int _port = 0;
	String _user = "";
	String _pw = "";
	
	public ConnectionContext(final String name, 
			final String host, 
			final int port, 
			final String user, 
			final String password){
		_name = name;
		_host = host;
		_port = port;
		_user = user;
		_pw = password;
	}
	
	public String getName(){
		return _name;
	}
	
	public String getHost(){
		return _host;
	}
	
	public int getPort(){
		return _port;
	}
	
	public String getUser(){
		return _user;
	}
	
	public String getPassword(){
		return _pw;
	}
	
}
