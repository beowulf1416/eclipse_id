package org.tomale.id.dal;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

public interface IConnectionProvider {

	public String getName();
	
	public Object getConnection();
	
	public WizardPage getWizardPage();
	
}
