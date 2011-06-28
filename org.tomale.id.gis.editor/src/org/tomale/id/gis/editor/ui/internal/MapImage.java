package org.tomale.id.gis.editor.ui.internal;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;

public class MapImage {

	BufferedImage _buffer;
	Rectangle _rect;
	
	MapContext _context;
	
	boolean requireRebuild = false;
	
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
		
		requireRebuild = true;
	}
	
	public BufferedImage getImage(){
		
		if(_buffer == null || requireRebuild){
			_buffer = new BufferedImage(_rect.width, _rect.height, BufferedImage.TYPE_INT_ARGB);
			
			// draw background
			Graphics2D g = _buffer.createGraphics();
			g.setBackground(Color.WHITE);
			g.fillRect(0, 0, _buffer.getWidth(), _buffer.getHeight());
			
		}
		return _buffer;
		
	}
	
}
