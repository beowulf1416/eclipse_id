package org.tomale.id.gis.editor.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class LayerPreferencePage extends PreferencePage {
	
	TableViewer _tblvwr;
	
	public LayerPreferencePage() {
	}

	@Override
	protected Control createContents(Composite parent) {
		
		Composite container = new Composite(parent, SWT.NONE);
		parent.setLayout(new GridLayout());
		container.setLayout(new GridLayout(3, false));
		
		_tblvwr = new TableViewer(container);
		_tblvwr.setColumnProperties(new String[] {});
		_tblvwr.setContentProvider(new LayerContentProvider());
		_tblvwr.setLabelProvider(new LayerLabelProvider());
		Table tbl = _tblvwr.getTable();
		tbl.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, true, 3, 1));
		tbl.setHeaderVisible(true);
		
		TableColumn tblclmnEdit = new TableColumn(tbl, SWT.NONE);
		tblclmnEdit.setToolTipText("Edit");
		tblclmnEdit.setResizable(false);
		tblclmnEdit.setWidth(32);
		
		TableColumn tblclmnRemove = new TableColumn(tbl, SWT.NONE);
		tblclmnRemove.setResizable(false);
		tblclmnRemove.setToolTipText("Remove");
		tblclmnRemove.setWidth(32);
		
		TableColumn tblclmnName = new TableColumn(tbl, SWT.NONE);
		tblclmnName.setWidth(100);
		tblclmnName.setText("Name");
		
		TableColumn tblclmnVisible = new TableColumn(tbl, SWT.NONE);
		tblclmnVisible.setWidth(100);
		tblclmnVisible.setText("Visible");
		
		TableColumn tblclmnReadOnly = new TableColumn(tbl, SWT.NONE);
		tblclmnReadOnly.setWidth(100);
		tblclmnReadOnly.setText("Read Only");
		
		Button btnAdd = new Button(container, SWT.NONE);
		btnAdd.setText("Add");
		
		Button btnRemove = new Button(container, SWT.NONE);
		btnRemove.setText("Remove");
		
		Button btnEdit = new Button(container, SWT.NONE);
		btnEdit.setText("Edit");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		return container;
	}
	
	public class LayerContentProvider implements IStructuredContentProvider {

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
	
	public class LayerLabelProvider implements ITableLabelProvider {

		@Override
		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
