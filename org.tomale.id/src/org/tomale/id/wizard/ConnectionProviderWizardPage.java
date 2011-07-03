package org.tomale.id.wizard;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.tomale.id.Activator;
import org.tomale.id.dal.IConnectionProvider;

public class ConnectionProviderWizardPage extends WizardPage {

	ListViewer _lstvwr;
	
	WizardPage _page;
	
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
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		_lstvwr = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
		_lstvwr.setContentProvider(new ConnectionContentProvider());
		_lstvwr.setLabelProvider(new ConnectionLabelProvider());
		
		List lstProvider = _lstvwr.getList();
		lstProvider.setFocus();

		_lstvwr.setInput(Activator.getConnectionProviders());

		setPageComplete(!_lstvwr.getSelection().isEmpty());
	}

	@Override
	public boolean isPageComplete() {
		return !_lstvwr.getSelection().isEmpty();
	}

	@Override
	public IWizardPage getNextPage() {
		
		if(!_lstvwr.getSelection().isEmpty()){
			
			StructuredSelection selection = (StructuredSelection) _lstvwr.getSelection();
			IConfigurationElement element = (IConfigurationElement) selection.getFirstElement();
			try {
				Object o = element.createExecutableExtension("class");
				if(o instanceof IConnectionProvider){
					IConnectionProvider provider = (IConnectionProvider) o;
					_page = provider.getWizardPage();
				
					((ConnectionWizard) getWizard()).addConnectionWizardPage(_page);
				}
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return super.getNextPage();
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
