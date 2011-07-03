package org.tomale.id.provider.connection.file;

import org.eclipse.jface.wizard.WizardPage;
import org.tomale.id.dal.IConnectionProvider;
import org.tomale.id.wizard.FileConnectionProviderWizardPage;

public class FileConnectionProvider implements IConnectionProvider {

	FileConnectionProviderWizardPage _page;
	
	@Override
	public WizardPage getWizardPage() {
		if(_page == null){
			_page = new FileConnectionProviderWizardPage();
		}
		return _page;
	}

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
	
	

}
