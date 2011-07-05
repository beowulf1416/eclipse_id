package org.tomale.id.provider.connection.file;

import org.eclipse.jface.wizard.IWizard;
import org.tomale.id.dal.IConnectionProvider;
import org.tomale.id.wizard.FileConnectionWizard;

public class FileConnectionProvider implements IConnectionProvider {

	public static final String PROVIDER_ID = "org.tomale.id.provider.connection.file.FileConnectionProvider";
	
	FileConnectionWizard wizard;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWizard getWizard() {
		if(wizard == null){
			wizard = new FileConnectionWizard();
		}
		return wizard;
	}

}
