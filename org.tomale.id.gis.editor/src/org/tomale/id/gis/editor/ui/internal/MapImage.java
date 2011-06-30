package org.tomale.id.gis.editor.ui.internal;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class MapImage {

	BufferedImage _buffer;
	Rectangle _rect;
	
	MapContext _context;
	ArrayList<MapLayer> _layers = new ArrayList<MapLayer>();
	HashMap<String, ArrayList<MapElement>> _elements = new HashMap<String, ArrayList<MapElement>>();
	
	boolean _requireRebuild = false;
	
	public MapContext getContext(){
		return _context;
	}
	
	public void setContext(final MapContext context){
		_context = context;
		
		_requireRebuild = true;
	}
	
	public Rectangle getBounds(){
		return _rect;
	}
	
	public void setBounds(final Rectangle rectangle){
		_rect = new Rectangle(0, 0, rectangle.width*3, rectangle.height*3);
		
		_requireRebuild = true;
	}
	
	public BufferedImage getImage(){
		
		if(_buffer == null || _requireRebuild){
			_buffer = new BufferedImage(_rect.width, _rect.height, BufferedImage.TYPE_INT_ARGB);
			
			// retrieve elements to draw
			int width = _buffer.getWidth();
			int height = _buffer.getHeight();
			
			Point center = _context.getCenter();
			int scale = _context.getScale();
			
			Rectangle rect = new Rectangle(center.x-(width/2)*scale, 
					center.y-(height/2)*scale, 
					width*scale, 
					height*scale);
			
			_elements = new HashMap<String, ArrayList<MapElement>>();
			for(MapLayer l : _layers){
				if(l.isVisible()){
					_elements.put(l.getName(), l.getElements(rect));
				}
			}
			
			// draw background
			Graphics2D g = _buffer.createGraphics();
			g.setBackground(Color.WHITE);
			g.fillRect(0, 0, width, height);
			
			// TODO set transform
			
			// draw elements
			for(MapLayer l : _layers){
				if(l.isVisible()){
					for(MapElement element : _elements.get(l.getName())){
						// TODO draw this element
					}
				}
			}
		}
		return _buffer;
		
	}
	
}
