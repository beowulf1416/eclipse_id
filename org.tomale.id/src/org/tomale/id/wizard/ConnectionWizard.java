package org.tomale.id.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class ConnectionWizard extends Wizard implements INewWizard {

	ConnectionProviderWizardPage _provider;
	
	public ConnectionWizard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {

		_provider = new ConnectionProviderWizardPage();
		addPage(_provider);
		
	}

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return false;
	}

}
