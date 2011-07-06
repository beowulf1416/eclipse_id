package org.tomale.id.provider.connection.mysql;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.tomale.id.dal.IConnectionProvider;
import org.tomale.id.provider.connection.mysql.wizard.MySQLConnectionWizard;
import org.tomale.id.provider.connection.mysql.wizard.MySQLConnectionWizardPage;

public class MySQLConnectionProvider implements IConnectionProvider {

	MySQLConnectionWizard _wizard;

	@Override
	public IWizard getWizard() {
		if(_wizard == null){
			_wizard = new MySQLConnectionWizard();
		}
		return _wizard;
	}

	public MySQLConnectionProvider() {
		// TODO Auto-generated constructor stub
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
