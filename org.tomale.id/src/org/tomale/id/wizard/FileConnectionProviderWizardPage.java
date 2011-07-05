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

public class FileConnectionProviderWizardPage extends WizardPage {
	
	private Text txtFile;

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
		container.setLayout(new GridLayout(1, false));
		
		txtFile = new Text(container, SWT.BORDER);
		txtFile.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				setPageComplete(!txtFile.getText().isEmpty());
			}
		});
		txtFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(getShell());
				txtFile.setText(dlg.open());
			}
		});
		btnBrowse.setText("Browse ...");
		
	}
	
	public String getFilename(){
		return txtFile.getText();
	}

	public String getSettings() {
		return "{filename=\"" + txtFile.getText() + "\"}";
	}

}
