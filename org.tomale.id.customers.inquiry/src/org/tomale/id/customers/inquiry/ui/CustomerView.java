package org.tomale.id.customers.inquiry.ui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.custom.CTabItem;

public class CustomerView extends ViewPart {
	public CustomerView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		CTabFolder tabFolder = new CTabFolder(parent, SWT.BORDER);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmCommon = new CTabItem(tabFolder, SWT.NONE);
		tbtmCommon.setText("Common");
		
		CTabItem tbtmBilling = new CTabItem(tabFolder, SWT.NONE);
		tbtmBilling.setText("Billings");
		
		CTabItem tbtmPayments = new CTabItem(tabFolder, SWT.NONE);
		tbtmPayments.setText("Payments");
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
