package org.tomale.id.gis.editor.ui.internal;

import java.awt.image.BufferedImage;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;

public class MapImage {

	BufferedImage _buffer;
	Rectangle _rect;
	
	MapContext _context;
	
	public MapContext getContext(){
		return _context;
	}
	
	public void setContext(final MapContext context){
		_context = context;
	}
	
	public Rectangle getBounds(){
		return _rect;
	}
	
	public void setBounds(final Rectangle rectangle){
		_rect = rectangle;
		_rect.height = _rect.height * 3;
		_rect.width = _rect.width * 3;
	}
	
	public Image getImage(){
		
		// TODO getImage
		
		return null;
		
	}
	
}
