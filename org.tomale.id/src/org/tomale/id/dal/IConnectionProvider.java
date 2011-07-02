package org.tomale.id.dal;

public interface IConnectionProvider {

	public String getName();
	
	public Object getConnection();
	
}
