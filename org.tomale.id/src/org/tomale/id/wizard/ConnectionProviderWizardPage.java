package org.tomale.id.wizard;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.tomale.id.Activator;
import org.tomale.id.dal.IConnectionProvider;

public class ConnectionProviderWizardPage extends WizardPage {

	ListViewer _lstvwr;
	
	WizardPage _page;
	private Text txtName;
	
	/**
	 * Create the wizard.
	 */
	public ConnectionProviderWizardPage() {
		super("Connection Providers");
		setPageComplete(false);
		setTitle("Connection Provider");
		setDescription("Select a connection provider");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(2, false));
		
		Label lblName = new Label(container, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name");
		
		txtName = new Text(container, SWT.BORDER);
		txtName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				setPageComplete(!txtName.getText().isEmpty() && !_lstvwr.getSelection().isEmpty());
			}
		});
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		_lstvwr = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
		_lstvwr.setContentProvider(new ConnectionContentProvider());
		_lstvwr.setLabelProvider(new ConnectionLabelProvider());
		
		List lstProvider = _lstvwr.getList();
		lstProvider.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPageComplete(!txtName.getText().isEmpty() && !_lstvwr.getSelection().isEmpty());
			}
		});
		lstProvider.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		_lstvwr.setInput(Activator.getConnectionProviders());
		
		txtName.setFocus();
	}
	
	public IConnectionProvider getSelectedProvider(){
		
		if(!_lstvwr.getSelection().isEmpty()){
			StructuredSelection selection = (StructuredSelection) _lstvwr.getSelection();
			IConfigurationElement element = (IConfigurationElement) selection.getFirstElement();
			try {
				Object o = element.createExecutableExtension("class");
				if(o != null){
					IConnectionProvider provider = (IConnectionProvider) o;
					return provider;
				}
			}catch(CoreException e){
				setErrorMessage(e.getMessage());
			}
		}
		return null;
		
	}

	public class ConnectionContentProvider implements IStructuredContentProvider {

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return (IConfigurationElement[]) inputElement;
		}
		
	}
	
	public class ConnectionLabelProvider extends BaseLabelProvider 
		implements ILabelProvider {

		@Override
		public Image getImage(Object element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getText(Object element) {
			return ((IConfigurationElement) element).getAttribute("name");
		}
		
	}

}
