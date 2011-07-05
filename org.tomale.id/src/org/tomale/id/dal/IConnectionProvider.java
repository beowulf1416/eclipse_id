package org.tomale.id.dal;

import org.eclipse.jface.wizard.IWizard;

public interface IConnectionProvider {

	public String getName();
	
	public Object getConnection();
	
	public IWizard getWizard();
	
}
