package org.tomale.id.provider.connection.mysql.wizard;

import org.eclipse.jface.wizard.Wizard;

public class MySQLConnectionWizard extends Wizard {

	MySQLConnectionWizardPage _page;
	
	@Override
	public void addPages() {
		_page = new MySQLConnectionWizardPage();
		addPage(_page);
	}



	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return false;
	}

}
