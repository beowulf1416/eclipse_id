package org.tomale.id.dal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.eclipse.jface.preference.IPreferenceStore;
import org.tomale.id.Activator;

public class ConnectionManager {
	
	private final String PREF_KEY_CONNECTIONS = "connections";
	
	HashMap<String, ConnectionContext> _connections;
	
	public ConnectionManager(){
		_connections = new HashMap<String, ConnectionContext>();
	}
	
	private void init(){
		
		_connections = new HashMap<String, ConnectionContext>();
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String s = store.getString(PREF_KEY_CONNECTIONS);
		s.replace("[{", "");
		s.replace("}]", "");
		s.replace("},{","-");
		String[] ss = s.split("-");
		
		for(String s1 : ss){
			
			String extension = "";
			String name = "";
			String user = "";
			String pw = "";
			HashMap<String, String> properties = new HashMap<String, String>();
			
			String[] ss1 = s1.split(",");
			for(String s2 : ss1){
				
				String[] ss2 = s2.split(":");
				
				if(ss2[0].equals("extension")){
					extension = ss2[1];
				} else if(ss2[0].equals("name")){
					name = ss2[1];
				} else if(ss2[0].equals("user")){
					user = ss2[1];
				} else if (ss2[0].equals("pw")){
					pw = ss2[1];
				} else {
					properties.put(ss2[0], ss2[1]);
				}
				
			}
			
			
		}
		
	}
	
	public ConnectionContext getConnection(final String name){

		if(_connections.containsKey(name)){
			return _connections.get(name);
		}
		return null;
		
	}
	
	public void addConnection(ConnectionContext context){
		
		_connections.put(context.getName(), context);
		
	}
	
	public void save(){
		
		StringBuilder sz = new StringBuilder();
		
		sz.append("[");
		Collection<ConnectionContext> contexts = _connections.values();
		Iterator<ConnectionContext> i = contexts.iterator();
		if(i.hasNext()){
			sz.append(i.next().toString());
		}
		while(i.hasNext()){
			sz.append(",");
			sz.append(i.next().toString());
		}
		sz.append("]");
		
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.putValue(PREF_KEY_CONNECTIONS, sz.toString());
		
	}
	
}
