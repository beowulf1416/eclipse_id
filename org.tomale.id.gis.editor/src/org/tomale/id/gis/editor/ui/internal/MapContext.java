package org.tomale.id.gis.editor.ui.internal;

import java.awt.geom.AffineTransform;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class MapContext {

	Point _centerAt;
	int _scale;
	
	AffineTransform _transform;
	
	public MapContext(final int scale, final Point center){
		_scale = scale;
		_centerAt = center;
	}
	
	public MapContext(){
		_scale = 1;
		_centerAt = new Point(0,0);
	}
	
	public Point getCenter(){
		return _centerAt;
	}
	
	public void setCenter(final Point center){
		_centerAt = center;
	}
	
	public int getScale(){
		return _scale;
	}
	
	public void setScale(final int scale){
		_scale = scale;
	}
	
	public AffineTransform getTransform(){
		return _transform;
	}
	
}
