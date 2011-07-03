package org.tomale.id.provider.connection.mysql.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

public class MySQLConnectionWizardPage extends WizardPage {
	private Text txtHost;
	private Text txtPort;
	private Text txtName;
	private Text txtUsername;
	private Text txtPassword;

	public MySQLConnectionWizardPage(){
		super("MySQL Connection Provider");
		setPageComplete(false);
		setTitle("MySQL Database connection provider");
		setDescription("Enter database connection parameters");
	}
	
	@Override
	public void createControl(Composite parent) {

		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout(2, false));
		
		Label lblHost = new Label(container, SWT.NONE);
		lblHost.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblHost.setText("Host");
		
		txtHost = new Text(container, SWT.BORDER);
		txtHost.setToolTipText("Database host");
		txtHost.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPort = new Label(container, SWT.NONE);
		lblPort.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPort.setText("Port");
		
		txtPort = new Text(container, SWT.BORDER);
		txtPort.setText("3306");
		txtPort.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblName = new Label(container, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name");
		
		txtName = new Text(container, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblUserName = new Label(container, SWT.NONE);
		lblUserName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblUserName.setText("User Name");
		
		txtUsername = new Text(container, SWT.BORDER);
		txtUsername.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPassword = new Label(container, SWT.NONE);
		lblPassword.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPassword.setText("Password");
		
		txtPassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
		txtPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
	}

}
