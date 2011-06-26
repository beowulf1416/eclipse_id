package org.tomale.id.gis.editor.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.tomale.id.gis.editor.Activator;

public class MapEditorInput implements IEditorInput {

	@Override
	public Object getAdapter(Class adapter) {
		return null;
	}

	@Override
	public boolean exists() {
		return true;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return Activator.imageDescriptorFromPlugin("org.tomale.id.gis.editor", 
					"icons/bullet_ball_glass_green.png");
	}

	@Override
	public String getName() {
		return "Map Editor";
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	@Override
	public String getToolTipText() {
		return "Map Editor";
	}

}
