package org.tomale.id.wizard;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.Wizard;
import org.tomale.id.Activator;

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
			
			IPreferenceStore store = Activator.getDefault().getPreferenceStore();
			store.setValue("provider.connection.file." + name, file);
			
			return true;
		}
		
		return false;
	}

}
