package scott.trading.infra;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SWTGlobals {

	public static Display display = new Display();

	public static Shell shell = new Shell(display) ;


	public static void startSWT() {
		shell.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

	}
}
