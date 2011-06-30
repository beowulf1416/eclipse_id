package org.tomale.id.gis.editor.ui;

import java.awt.image.BufferedImage;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.tomale.id.gis.editor.ui.internal.ImageConverter;
import org.tomale.id.gis.editor.ui.internal.MapContext;
import org.tomale.id.gis.editor.ui.internal.MapImage;

public class MapEditor extends EditorPart {

	public final static String EDITOR_ID = "org.tomale.id.gis.editor.map";
	
	MapImage _map;
	MapContext _context;
	
	Canvas _canvas;
	Image swtImage;
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		
		setSite(site);
		setInput(input);

	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		
		_canvas = new Canvas(parent, SWT.NO_BACKGROUND | SWT.BORDER | 
				SWT.V_SCROLL | SWT.H_SCROLL);
		_canvas.addControlListener(new ControlListener() {
			
			@Override
			public void controlResized(ControlEvent e) {
				resize();
			}
			
			@Override
			public void controlMoved(ControlEvent e) {
				// do nothing
			}
		});
		
		_canvas.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				paint(e.gc);
			}
			
		});
		
		_map = new MapImage();
		_map.setBounds(parent.getBounds());
	}
	
	public void resize(){
		_map.setBounds(_canvas.getClientArea());
	}
	
	public void paint(GC gc){
		
		// draw background color
		BufferedImage bufferedImage = _map.getImage();
		swtImage = new Image(gc.getDevice(), ImageConverter.convertToSWT(bufferedImage));
		gc.drawImage(swtImage, 0, 0);
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
