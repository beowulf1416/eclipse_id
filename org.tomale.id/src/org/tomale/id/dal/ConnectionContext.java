package org.tomale.id.dal;

import java.util.HashMap;
import java.util.Iterator;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class ConnectionContext {

	String _extId = "";
	String _name = "";
	String _user = "";
	String _pw = "";
	
	HashMap<String, String> _props;
	
	public ConnectionContext(
			final String extensionPointId,
			final String name, 
			final String user, 
			final String password,
			final HashMap<String, String> properties){
		
		_extId = extensionPointId;
		
		_name = name;
		_user = user;
		_pw = password;
		
		_props = properties;
		
	}
	
	public String getName(){
		return _name;
	}
	
	public String getUser(){
		return _user;
	}
	
	public String getPassword(){
		return _pw;
	}
	
	public String getProperty(String name){
		return _props.containsKey(name) ? _props.get(name) : "";
	}

	@Override
	public String toString() {
		StringBuilder sz = new StringBuilder();
		
		sz.append("{");
		sz.append("extension:\""+ _extId +"\"");
		sz.append(",name:\""+ _name +"\"");
		sz.append(",user:\""+ _user +"\"");
		sz.append(",pw:\""+ _pw +"\"");
		
		for(String s : _props.keySet()){
			String v = _props.get(s);
			sz.append(","+s+":\""+v+"\"");
		}
		sz.append("}");
		return sz.toString();
		
	}
	
}
