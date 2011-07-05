package org.tomale.id.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.tomale.id.ui.views.ConnectionsView;

public class ShowConnectionsViewHandler extends AbstractHandler implements
		IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		try {
			HandlerUtil.getActiveWorkbenchWindow(event).
				getActivePage().showView(ConnectionsView.VIEW_ID);
		}catch(PartInitException e){
			
		}
		return null;
	}

}
