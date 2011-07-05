package org.tomale.id.wizard;

import java.util.HashMap;

import org.eclipse.jface.wizard.Wizard;
import org.tomale.id.Activator;
import org.tomale.id.dal.ConnectionContext;
import org.tomale.id.dal.ConnectionManager;
import org.tomale.id.provider.connection.file.FileConnectionProvider;

public class FileConnectionWizard extends Wizard {

	FileConnectionProviderWizardPage _page;
	
	@Override
	public void addPages() {
		
		_page = new FileConnectionProviderWizardPage();
		addPage(_page);
		
	}

	@Override
	public boolean performFinish() {

		String file = _page.getFilename();
		String name = _page.getProviderName();
		if(!file.isEmpty()){
			
			HashMap<String, String> properties = new HashMap<String, String>();
			properties.put("file", file);
			
			ConnectionManager mgr = Activator.getDefault().getConnectionManager();
			mgr.addConnection(new ConnectionContext(FileConnectionProvider.PROVIDER_ID, name, 
					"", 
					"", 
					properties
					));
			mgr.save();
			
			return true;
		}
		
		return false;
	}

}
