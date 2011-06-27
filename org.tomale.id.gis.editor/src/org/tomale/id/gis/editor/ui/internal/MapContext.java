package org.tomale.id.gis.editor.ui.internal;

import java.awt.geom.AffineTransform;

import org.eclipse.swt.graphics.Point;

public class MapContext {

	Point _centerAt;
	int _scale;
	
	AffineTransform _transform;
	
	public Point getCenterAt(){
		return _centerAt;
	}
	
	public void setCenterAt(final Point centerAt){
		_centerAt = centerAt;
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
