package org.tomale.id.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;

public class FileConnectionProviderWizardPage extends WizardPage {
	private Text txtFile;

	public FileConnectionProviderWizardPage(){
		super("File Connection Provider");
		setPageComplete(false);
		setTitle("File Connection Provider");
		setDescription("Select a file");
	}
	
	@Override
	public boolean isPageComplete() {
		return !txtFile.getText().isEmpty();
	}

	@Override
	public void createControl(Composite parent) {

		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		txtFile = new Text(container, SWT.BORDER);
		txtFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(getShell());
				txtFile.setText(dlg.open());
				setPageComplete(!txtFile.getText().isEmpty());
			}
		});
		btnBrowse.setText("Browse ...");
		
	}

}
