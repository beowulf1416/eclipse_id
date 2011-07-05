package org.tomale.id.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;
import org.tomale.id.Activator;
import org.eclipse.swt.widgets.Label;

public class FileConnectionProviderWizardPage extends WizardPage {
	
	private Text txtFile;
	private Text txtName;

	public FileConnectionProviderWizardPage(){
		super("File connection provider page","File Connection Provider",Activator.getImageDescriptor("icons/file.jpg"));
		setPageComplete(false);
		setTitle("File Connection Provider");
		setDescription("Select a file");
	}

	@Override
	public void createControl(Composite parent) {

		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout(2, false));
		
		Label lblName = new Label(container, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name");
		
		txtName = new Text(container, SWT.BORDER);
		txtName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				setPageComplete(!txtName.getText().isEmpty() && !txtFile.getText().isEmpty());
			}
		});
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(getShell());
				txtFile.setText(dlg.open());
			}
		});
		btnBrowse.setText("Browse ...");
		
		txtFile = new Text(container, SWT.BORDER);
		txtFile.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				setPageComplete(!txtName.getText().isEmpty() && !txtFile.getText().isEmpty());
			}
		});
		txtFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
	}
	
	public String getProviderName(){
		return txtName.getText();
	}
	
	public String getFilename(){
		return txtFile.getText();
	}

}
