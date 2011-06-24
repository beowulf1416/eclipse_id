package org.tomale.id.ui.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class ConnectionPreferencesPage extends PreferencePage
	implements IWorkbenchPreferencePage {

	TableViewer _cns;
	
	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}
	
	@Override
	protected Control createContents(Composite parent) {
		
		parent.setLayout(new FillLayout());
		
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout());
		
		_cns = new TableViewer(container);
		_cns.setLabelProvider(new ConnectionLabelProvider());
		
		return null;
	}
	
	public class ConnectionLabelProvider extends LabelProvider {
		
	}
	
	public class ConnectionContentProvider 
		implements IStructuredContentProvider {

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

}
