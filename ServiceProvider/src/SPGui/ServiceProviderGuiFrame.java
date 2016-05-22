package SPGui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

/**
 * JFrame for the program.
 * @author Jiaqi Zhang
 *
 */
public class ServiceProviderGuiFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ServiceProviderGuiPanel servicePanel;
	private File file; // Customer information file

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public ServiceProviderGuiFrame() throws IOException {
		setTitle ("Service Provider");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 400);
		setPreferredSize(new Dimension(750, 400));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.setCurrentDirectory(new File("."));
				fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
				fileChooser.showOpenDialog(null);
				file = fileChooser.getSelectedFile(); 
				try {
					servicePanel = new ServiceProviderGuiPanel(file);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
				servicePanel.setVisible(true);
				contentPane.add(servicePanel);
				pack();
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				servicePanel.saveServiceProvider(file);
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnNewMenu = new JMenu("Look and Feel");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmMetal = new JMenuItem("Metal");
		mnNewMenu.add(mntmMetal);
		
		JMenuItem mntmMotif = new JMenuItem("Motif");
		mnNewMenu.add(mntmMotif);
		
		JMenuItem mntmSystem = new JMenuItem("SystemLook(Windows/Mac/..)");
		mnNewMenu.add(mntmSystem);
		
		mntmMetal.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent a)
			{
				changeLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			}
		});
		
		mntmMotif.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent a)
			{
				changeLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			}
		});
		
		mntmSystem.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent a)
			{
				changeLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	/**
	 * Change look and feel.
	 * @param lookAndFeel look and feel
	 */
	public void changeLookAndFeel(String lookAndFeel) {
		try {
			UIManager.setLookAndFeel(lookAndFeel);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		SwingUtilities.updateComponentTreeUI(this);
	}
}
