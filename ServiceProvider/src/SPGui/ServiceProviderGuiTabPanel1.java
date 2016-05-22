package SPGui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLEditorKit;

import SP.*;

import javax.swing.JEditorPane;

import java.awt.GridLayout;
import java.util.ArrayList;

/**
 * GUI panel for the first tabbedpane - service ordered.
 * @author Jiaqi Zhang
 *
 */
public class ServiceProviderGuiTabPanel1 extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private JEditorPane editorPane;
	private ServiceProviderGuiTabPanel1_1 sptab1_1;
	private JScrollPane scrollPane;
	
	/**
	 * Create the panel.
	 */
	public ServiceProviderGuiTabPanel1() {
		setLayout(new GridLayout(2, 1));
		sptab1_1 = new ServiceProviderGuiTabPanel1_1();
		add(sptab1_1);
		
		editorPane = new JEditorPane();
		HTMLEditorKit kit = new HTMLEditorKit();
		editorPane.setEditorKit(kit);
		scrollPane = new JScrollPane(editorPane);
		add(scrollPane);

	}
	
	public void updateUpInfo(Customer c) {
		sptab1_1.updateInfo(c); // the method called is synchronized
	}
	
	/**
	 * Panel for the table.
	 * @author Jiaqi Zhang
	 *
	 */
	class ServiceProviderGuiTabPanel1_1 extends JPanel {

		private static final long serialVersionUID = 1L;
		private JTable table;
		private JScrollPane scrollPane;
		public ServiceProviderGuiTabPanel1_1() {
			setLayout(new BorderLayout(0, 0));
			table = new JTable();
			scrollPane = new JScrollPane(table);
			add(scrollPane);
		}
		public synchronized void updateInfo(Customer c) {
			removeAll();
			setLayout(new BorderLayout(0, 0));
			String[] columnNames = {"Service",
	                "Billable"};
			ArrayList<CustomerAccount> accounts = c.getAccounts();
			int n = accounts.size(), cnt = 0;
			String[][] data = new String[n][2];
			for(CustomerAccount a : accounts) {
				data[cnt][0] = a.getService().getName();
				data[cnt][1] = a.getBillable().toString();
				cnt++;
			}
			myTableModel tableModel = new myTableModel(data, columnNames);
			table = new JTable(tableModel);
			table.setEnabled(true);
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
				public synchronized void valueChanged(ListSelectionEvent e){
					int r= table.getSelectedRow();
					CustomerAccount a = accounts.get(r);
					Service service = a.getService();
					Billable billable = a.getBillable();
					String htmlString = "<html>"
			                + "<body>"
			                + service.toHtml() + "<br><br>" + billable.toHtml()
			                + "</body>";
			        editorPane.setText(htmlString);
				}
			});
			scrollPane = new JScrollPane(table);
			add(scrollPane);
		}
	}
	
	/**
	 * Table model, to make the table uneditable.
	 * @author Jiaqi Zhang
	 *
	 */
	class myTableModel extends DefaultTableModel {

		private static final long serialVersionUID = 1L;
		public myTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}
}


