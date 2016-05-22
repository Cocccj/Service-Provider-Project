package SPGui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JTree;
import javax.swing.border.EtchedBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import SP.*;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 * main GUI panel
 * @author Jiaqi
 *
 */
public class ServiceProviderGuiPanel extends JPanel {


	private static final long serialVersionUID = 1L;
	private ServiceProvider sp = new ServiceProvider("Service Provider"); // Service Provider

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public ServiceProviderGuiPanel(File file) throws IOException {
		setLayout(new BorderLayout(0, 0));
		
		sp.loadCustomers(file);
		LinkedHashMap<String, Customer> customers = (LinkedHashMap<String, Customer>)sp.getCustomers();
		
		//JTree
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("Customers");
		Iterator<Map.Entry<String, Customer>> iter = customers.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Customer> entry = iter.next();
			node1.add(new DefaultMutableTreeNode(entry.getValue().getName()));
		}
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(sp.getName());
		top.add(node1);
		JTree tree = new JTree(top);
		tree.collapseRow(0);
		add(tree, BorderLayout.WEST);
		
		//JTabbedPane
		
		ServiceProviderGuiTabPanel1 sptab1 = new ServiceProviderGuiTabPanel1();
		ServiceProviderGuiTabPanel2 sptab2 = new ServiceProviderGuiTabPanel2();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Services Ordered", null, sptab1, "Tab #1");
		tabbedPane.addTab("Customer Information", null, sptab2, "Tab #2");
		add(tabbedPane, BorderLayout.CENTER);
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (node == null || !node.isLeaf())	return;
			    String customerName = node.toString();
				Customer c = customers.get(customerName);
				sptab1.updateUpInfo(c);
				sptab2.updateInfo(c);
				repaint();
			}
		});
	}
	
	public void saveServiceProvider(File file) {
		try {
			sp.saveCustomers(file); // the method called is synchronized
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}

	/**
	 * GUI panel for the second tabbedpane - customer information.
	 * @author Jiaqi Zhang
	 *
	 */
	class ServiceProviderGuiTabPanel2 extends JPanel {

		
		private static final long serialVersionUID = 1L;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		private JTextField textField_5;
		private JTextField textField_6;

		/**
		 * Create the panel.
		 */
		public ServiceProviderGuiTabPanel2() {
			setLayout(null);
			
			JButton btnModify = new JButton("Modify");
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String id = textField.getText();
					String name = textField_1.getText();
					String street = textField_2.getText();
					String city = textField_3.getText();
					String state = textField_4.getText();
					String zip = textField_5.getText();
					sp.updateCustomer(id, name, new Address(street, city, state, zip)); // the method called is synchronized
				}
			});
			btnModify.setBounds(152, 224, 117, 29);
			add(btnModify);
			
			JButton btnHelp = new JButton("Help");
			btnHelp.setBounds(298, 224, 117, 29);
			add(btnHelp);
			
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel.setBounds(42, 19, 479, 193);
			add(panel);
			panel.setLayout(null);
			
			JLabel lblId = new JLabel("Id");
			lblId.setBounds(6, 6, 61, 16);
			panel.add(lblId);
			
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(6, 33, 61, 16);
			panel.add(lblName);
			
			JLabel lblStreet = new JLabel("Street");
			lblStreet.setBounds(6, 60, 61, 16);
			panel.add(lblStreet);
			
			JLabel lblCity = new JLabel("City");
			lblCity.setBounds(6, 87, 61, 16);
			panel.add(lblCity);
			
			JLabel lblState = new JLabel("State");
			lblState.setBounds(6, 114, 61, 16);
			panel.add(lblState);
			
			JLabel lblZip = new JLabel("Zip");
			lblZip.setBounds(6, 141, 61, 16);
			panel.add(lblZip);
			
			JLabel lblOrderDate = new JLabel("Order Date");
			lblOrderDate.setBounds(6, 168, 102, 16);
			panel.add(lblOrderDate);
			
			textField = new JTextField();
			textField.setBounds(237, 1, 236, 26);		
			textField.setEditable(false);
			panel.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(237, 28, 236, 26);
			textField_1.setEditable(false);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(237, 55, 236, 26);
			panel.add(textField_2);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setBounds(237, 82, 236, 26);
			panel.add(textField_3);
			textField_3.setColumns(10);
			
			textField_4 = new JTextField();
			textField_4.setBounds(237, 109, 236, 26);
			panel.add(textField_4);
			textField_4.setColumns(10);
			
			textField_5 = new JTextField();
			textField_5.setBounds(237, 136, 236, 26);
			panel.add(textField_5);
			textField_5.setColumns(10);
			
			textField_6 = new JTextField();
			textField_6.setBounds(237, 163, 236, 26);
			textField_6.setEditable(false);
			panel.add(textField_6);
			textField_6.setColumns(10);
		}
		
		/**
		 * Update information.
		 * @param customer customer
		 */
		public synchronized void updateInfo(Customer customer) {
			textField.setText(customer.getId());
			textField_1.setText(customer.getName());
			textField_2.setText(customer.getAddress().getStreet());
			textField_3.setText(customer.getAddress().getCity());
			textField_4.setText(customer.getAddress().getState());
			textField_5.setText(customer.getAddress().getZip());
			textField_6.setText(customer.getDate().toString());
		}
	}
}
