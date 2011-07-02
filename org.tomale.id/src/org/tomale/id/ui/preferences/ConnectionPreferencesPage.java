package org.tomale.id.ui.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ConnectionPreferencesPage extends PreferencePage
	implements IWorkbenchPreferencePage {
	public ConnectionPreferencesPage() {
	}

	TableViewer _cns;
	
	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}
	
	@Override
	protected Control createContents(Composite parent) {
		
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout gl_container = new GridLayout();
		gl_container.numColumns = 2;
		container.setLayout(gl_container);
		
		_cns = new TableViewer(container);
		_cns.setContentProvider(new ConnectionContentProvider());
		_cns.setLabelProvider(new ConnectionLabelProvider());
		
		Table table = _cns.getTable();
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		TableColumn tblclmnName = new TableColumn(table, SWT.NONE);
		tblclmnName.setToolTipText("Name");
		tblclmnName.setWidth(100);
		tblclmnName.setText("Name");
		
		TableColumn tblclmnProvider = new TableColumn(table, SWT.NONE);
		tblclmnProvider.setWidth(100);
		tblclmnProvider.setText("Provider");
		
		Button btnAdd = new Button(container, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAdd.setText("Add");
		
		Button btnRemove = new Button(container, SWT.NONE);
		btnRemove.setText("Remove");
		_cns.setLabelProvider(new ConnectionLabelProvider());
		
		return container;
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
