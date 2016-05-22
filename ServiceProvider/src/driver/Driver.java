package driver;
import java.awt.EventQueue;

import javax.swing.JOptionPane;

import SPGui.ServiceProviderGuiFrame;

/**
 * Main Driver.
 * @author Jiaqi Zhang
 *
 */
public class Driver {

	/**
	 * Launch the program.
	 * @param args no argument
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceProviderGuiFrame frame = new ServiceProviderGuiFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
	}
}
