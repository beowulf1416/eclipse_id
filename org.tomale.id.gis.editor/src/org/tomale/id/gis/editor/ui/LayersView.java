package org.tomale.id.gis.editor.ui;

import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.part.ViewPart;

public class LayersView extends ViewPart {

	public final static String VIEW_ID = "org.tomale.id.gis.editor.view.layers";
	
	TableViewer _tblvwr;
	
	@Override
	public void createPartControl(Composite parent) {
		
		parent.setLayout(new FillLayout());
		
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout());
		
		_tblvwr = new TableViewer(container);
		_tblvwr.setContentProvider(new LayerContentProvider());
		_tblvwr.setLabelProvider(new LayerLabelProvider());
		
		Table tbl = _tblvwr.getTable();
		tbl.setHeaderVisible(true);
		
	}

	@Override
	public void setFocus() {
		_tblvwr.getTable().setFocus();
	}
	
	public class LayerContentProvider 
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
	
	public class LayerLabelProvider 
		extends BaseLabelProvider
		implements ITableLabelProvider {

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
