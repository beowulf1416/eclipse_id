package org.tomale.id.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;

public class ConnectionProviderWizardPage extends WizardPage {

	ListViewer _lstvwr;
	
	/**
	 * Create the wizard.
	 */
	public ConnectionProviderWizardPage() {
		super("wizardPage");
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
			// TODO Auto-generated method stub
			return null;
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
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
