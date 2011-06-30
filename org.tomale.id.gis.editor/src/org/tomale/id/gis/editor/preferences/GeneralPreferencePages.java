package org.tomale.id.gis.editor.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class GeneralPreferencePages extends PreferencePage {
	
	Canvas canvas;
	
	public GeneralPreferencePages() {
	}

	@Override
	protected Control createContents(Composite parent) {
		
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout gl_container = new GridLayout();
		container.setLayout(gl_container);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		Group grpColors = new Group(container, SWT.NONE);
		grpColors.setText("Colors");
		grpColors.setLayout(new GridLayout(3, false));
		
		Label lblBackground = new Label(grpColors, SWT.NONE);
		lblBackground.setText("Background");
		
		canvas = new Canvas(grpColors, SWT.BORDER);
		GridData gd_canvas = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_canvas.heightHint = 24;
		gd_canvas.widthHint = 24;
		canvas.setLayoutData(gd_canvas);
		
		Button button = new Button(grpColors, SWT.NONE);
		button.setText("...");
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				chooseColor();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				chooseColor();				
			}
		});
		
		return container;
	}

	private void chooseColor(){
		
		ColorDialog dlg = new ColorDialog(getShell());
		RGB rgb = dlg.open();
		canvas.setBackground(new Color(getShell().getDisplay(), rgb));
		
	}

	@Override
	public boolean performOk() {

		try {
			IPreferenceStore store = getPreferenceStore();
			return super.performOk();
		} catch(Exception e){
			
			setErrorMessage(e.getLocalizedMessage());
			
			return false;
		}
		
	}
}
