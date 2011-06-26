package org.tomale.id.gis.editor.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class LayersView extends ViewPart {

	public final static String VIEW_ID = "org.tomale.id.gis.editor.view.layers";
	
	@Override
	public void createPartControl(Composite parent) {
		
		parent.setLayout(new FillLayout());
		
		Composite container = new Composite(parent, SWT.NONE);
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
