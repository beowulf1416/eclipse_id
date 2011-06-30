package org.tomale.id.gis.editor.ui.internal;

import java.util.ArrayList;

import org.eclipse.swt.graphics.Rectangle;

public class MapLayer {

	String _name;
	boolean _visible;
	boolean _readonly;
	
	public MapLayer(){
		
	}
	
	public String getName(){
		return _name;
	}
	
	public void setName(final String name){
		_name = name;
	}
	
	public boolean isVisible(){
		return _visible;
	}
	
	public void setVisible(final boolean visible){
		_visible = visible;
	}
	
	public boolean isReadOnly(){
		return _readonly;
	}
	
	public void setReadonly(final boolean readOnly){
		_readonly = readOnly;
	}
	
	ArrayList<MapElement> getElements(final Rectangle rectangle){
		// TODO getElements
		return new ArrayList<MapElement>();
		
	}
	
}
