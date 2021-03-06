package org.tomale.id.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.tomale.id.dal.IConnectionProvider;

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
		
		IConnectionProvider provider = _provider.getSelectedProvider();
		if(provider != null){
			IWizard wizard = provider.getWizard();
			WizardDialog dialog = new WizardDialog(getShell(), wizard);
			dialog.setTitle(wizard.getWindowTitle());
			dialog.open();
			
			return true;
		}
		
		return false;
	}
	
}
