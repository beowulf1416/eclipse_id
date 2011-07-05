package org.tomale.id.dal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.jface.preference.IPreferenceStore;
import org.tomale.id.Activator;

public class ConnectionManager {
	
	private final String PREF_KEY_CONNECTIONS = "connections";
	
	HashMap<String, ConnectionContext> _connections;
	
//	public ConnectionManager(){
//		_connections = new HashMap<String, ConnectionContext>();
//	}
	
	private void init(){
		
		_connections = new HashMap<String, ConnectionContext>();
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String s = store.getString(PREF_KEY_CONNECTIONS);
		s = s.replace("[{", "");
		s = s.replace("}]", "");
		s = s.replace("\"","");
		s = s.replace("},{","-");
		String[] ss = s.split("-");
		
		for(String s1 : ss){
			
			String extension = "";
			String name = "";
			String user = "";
			String pw = "";
			HashMap<String, String> properties = new HashMap<String, String>();
			
			String[] ss1 = s1.split(",");
			for(String s2 : ss1){

				if(!s2.isEmpty()){
					String[] ss2 = s2.split(":");
					
					String key = "";
					String value = "";
					
					if(ss2.length > 0){
						key = ss2[0];
					}
					
					if(ss2.length > 1){
						value = ss2[1];
					}
					
					
					if(key.equals("extension")){
						extension = value;
					} else if(key.equals("name")){
						name = value;
					} else if(key.equals("user")){
						user = value;
					} else if (key.equals("pw")){
						pw = value;
					} else {
						properties.put(key, value);
					}
				}
				
			}

			if(!name.isEmpty()){
				ConnectionContext context = new ConnectionContext(extension, name, user, pw, properties);
				_connections.put(name, context);
			}
		}
		
	}
	
	public ArrayList<ConnectionContext> getConnections(){
		
		if(_connections == null){
			init();
		}
		
		ArrayList<ConnectionContext> contexts = new ArrayList<ConnectionContext>();
		for(ConnectionContext c : _connections.values()){
			if(!c.getName().isEmpty()){
				contexts.add(c);
			}
		}
		
		return contexts;
		
	}
	
	public ConnectionContext getConnection(final String name){

		if(_connections == null){
			init();
		}
		
		if(_connections.containsKey(name)){
			return _connections.get(name);
		}
		return null;
		
	}
	
	public void addConnection(ConnectionContext context){
		
		if(_connections == null){
			init();
		}
		_connections.put(context.getName(), context);
		
	}
	
	public void save(){
		
		if(_connections == null){
			init();
		}
		
		StringBuilder sz = new StringBuilder();
		
		sz.append("[");
		Collection<ConnectionContext> contexts = _connections.values();
		Iterator<ConnectionContext> i = contexts.iterator();
		if(i.hasNext()){
			ConnectionContext next = i.next();
			if(!next.getName().isEmpty()){
				sz.append(next.toString());
			}
		}
		while(i.hasNext()){
			ConnectionContext next = i.next();
			if(!next.getName().isEmpty()){
				sz.append(",");
				sz.append(next.toString());
			}
		}
		sz.append("]");
		
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.putValue(PREF_KEY_CONNECTIONS, sz.toString());
		
	}
	
}
