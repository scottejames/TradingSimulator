package scott.trading;

import net.miginfocom.swt.MigLayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import scott.trading.infra.SWTGlobals;

public class OrderBookViewer {
	
	private Shell _shell = null;
	private Table _table = null;
	
	OrderBookViewer()
	{
        _shell = new Shell(SWTGlobals.shell, SWT.DIALOG_TRIM);
        _shell.setSize(500, 500);
        _shell.setText("Order Book Viewer");

        MigLayout layout = new MigLayout("");
        layout.setColumnConstraints("[750,grow]");
        layout.setRowConstraints("[500,grow]");
        _shell.setLayout(layout);
        
        _table = new Table(_shell, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL
                | SWT.BORDER | SWT.FULL_SELECTION);
        
        _table.setLayoutData(layout);
       
        TableColumn columnName = new TableColumn(_table, SWT.NONE);
        columnName.setText("Name");
        columnName.setWidth(100);
        
        TableColumn columnDetails = new TableColumn(_table, SWT.NONE);
        columnDetails.setText("Details");
        columnDetails.setWidth(100);
        
        TableItem item1 = new TableItem(_table, SWT.NONE);
        item1.setText(new String[] { "Tim", "Hatton" });
        
        _table.setHeaderVisible(true);
        _table.setLinesVisible(true);
        
     

	}

}