package org.tomale.id.ui.views;

import java.util.ArrayList;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;
import org.tomale.id.Activator;
import org.tomale.id.dal.ConnectionContext;

public class ConnectionsView extends ViewPart {

	TableViewer tableViewer;
	public static final String VIEW_ID = "org.tomale.id.ui.view.connections"; //$NON-NLS-1$
	private Table tbl;
	
	private static class ConnectionsContentProvider implements IStructuredContentProvider {
		@SuppressWarnings("unchecked")
		public Object[] getElements(Object inputElement) {
			try {
				return ((ArrayList<ConnectionContext>) inputElement).toArray();
			}catch(Exception e){
				Activator.getDefault().getLog().log(new Status(Status.ERROR, 
						Activator.PLUGIN_ID, "Unable to retrieve connections."));
				return new Object[0];
			}
		}
		public void dispose() {
		}
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
	
	private class ConnectionsLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}
		public String getColumnText(Object element, int columnIndex) {

			switch(columnIndex){
				case 0:{
					return ((ConnectionContext) element).getName();
				}
				case 1:{
					return ((ConnectionContext) element).toString();
				}
				default:{
					return "Unknown column index: "+columnIndex;
				}
			}
			
		}
	}

	public ConnectionsView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		{
			tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
			tbl = tableViewer.getTable();
			tbl.setHeaderVisible(true);
			{
				TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
				TableColumn tblclmnName = tableViewerColumn.getColumn();
				tblclmnName.setWidth(100);
				tblclmnName.setText("Name");
			}
			{
				TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
				TableColumn tblclmnSettings = tableViewerColumn.getColumn();
				tblclmnSettings.setWidth(100);
				tblclmnSettings.setText("Settings");
			}
			tableViewer.setLabelProvider(new ConnectionsLabelProvider());
			tableViewer.setContentProvider(new ConnectionsContentProvider());
			tableViewer.setInput(Activator.getDefault().getConnectionManager().getConnections());
		}

//		createActions();
//		initializeToolBar();
//		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		
	}

}
