package org.tomale.id.provider.connection.mysql;

import org.eclipse.jface.wizard.WizardPage;
import org.tomale.id.dal.IConnectionProvider;
import org.tomale.id.provider.connection.mysql.wizard.MySQLConnectionWizardPage;

public class MySQLConnectionProvider implements IConnectionProvider {

	MySQLConnectionWizardPage _page;
	
	@Override
	public WizardPage getWizardPage() {
		if(_page == null){
			_page = new MySQLConnectionWizardPage();
		}
		return _page;
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
