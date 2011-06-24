package org.tomale.id.power.customers.inquiry.ui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;

public class CustomerBrowserView extends ViewPart {
	private Table table;
	private Text text;
	public CustomerBrowserView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout gl_container = new GridLayout(1,false);
		container.setLayout(gl_container);
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite.setLayout(new GridLayout(3, false));
		
		Combo combo = new Combo(composite, SWT.READ_ONLY);
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_combo.widthHint = 25;
		combo.setLayoutData(gd_combo);
		
		text = new Text(composite, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text.widthHint = 75;
		text.setLayoutData(gd_text);
		
		Button btnFind = new Button(composite, SWT.NONE);
		btnFind.setText("Find");
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
