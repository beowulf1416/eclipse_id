package org.tomale.id.gis.editor.ui.internal;

import java.awt.image.BufferedImage;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;

public class MapImage {

	BufferedImage _buffer;
	Rectangle _rect;
	
	public Rectangle getBounds(){
		return _rect;
	}
	
	public void setBounds(final Rectangle rectangle){
		_rect = rectangle;
	}
	
	public Image getImage(){
		
		// TODO getImage
		
		return null;
		
	}
	
}
