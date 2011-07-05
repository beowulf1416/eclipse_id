package org.tomale.id.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.tomale.id.wizard.ConnectionWizard;

public class AddConnectionHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ConnectionWizard wizard = new ConnectionWizard();
		WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShell(event), 
				wizard);
		wizard.init(HandlerUtil.getActiveWorkbenchWindow(event).getWorkbench(), null);
		dialog.setTitle(wizard.getWindowTitle());
		dialog.open();
		
		return null;
	}

}
