package org.tomale.id.wizard;

import org.eclipse.jface.wizard.Wizard;

public class FileConnectionWizard extends Wizard {

	FileConnectionProviderWizardPage _page;
	
	@Override
	public void addPages() {
		
		_page = new FileConnectionProviderWizardPage();
		addPage(_page);
		
	}

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return false;
	}

}
