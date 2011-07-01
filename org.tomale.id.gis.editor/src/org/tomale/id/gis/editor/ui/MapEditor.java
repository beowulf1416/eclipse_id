package org.tomale.id.gis.editor.ui;

import java.awt.image.BufferedImage;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.ToolBar;
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
	
	Action _showLayers;
	
	public MapEditor(){
		_map = new MapImage();
	}
	
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
	
	public void createActions(){
		
		_showLayers = new Action() {
			public void run(){
				// TODO
			}
		};
		
	}
	
	public void createToolbar(){
		
		IToolBarManager mgr = getEditorSite().getActionBars().getToolBarManager();
		mgr.add(_showLayers);
		
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());

		_canvas = new Canvas(parent, SWT.NO_BACKGROUND | SWT.BORDER | 
				SWT.V_SCROLL | SWT.H_SCROLL);
		
		ScrollBar hscroll = _canvas.getHorizontalBar();
		hscroll.setMinimum(0);
		hscroll.setMaximum(100);
		hscroll.setSelection(50);
		hscroll.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ScrollBar vscroll = _canvas.getVerticalBar();
		vscroll.setMinimum(0);
		vscroll.setMaximum(100);
		vscroll.setSelection(50);
		vscroll.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
		
		_map.setBounds(parent.getBounds());
		
		
//		createActions();
//		createToolbar();
		
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
	
	public void scroll(){
		
	}

	@Override
	public void setFocus() {
		_canvas.setFocus();
	}

}
