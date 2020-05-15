package pl.nowak.radon.base.userinterface.mainmenu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import pl.nowak.radon.base.userinterface.dataHandler.dataManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu2 {

	public JFrame frmSandradon;

	public JFrame getFrame() {
		return frmSandradon;
	}

	/**
	 * Create the application.
	 */
	public MainMenu2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSandradon = new JFrame();
		frmSandradon.setTitle("SandRadon");
		frmSandradon.setBounds(100, 100, 679, 465);
		frmSandradon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSandradon.getContentPane().setLayout(null);

		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Yes, exit", "No, stay"};
				int i = JOptionPane.showOptionDialog(frmSandradon,
						"Do you really want to exit ? \n" + 
				"All unsaved changes will be lost", "Do you want to exit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(i == 0)
				System.exit(1);
			}
		});
		exitButton.setBounds(537, 375, 116, 40);
		frmSandradon.getContentPane().add(exitButton);
		
		JButton dataManagmet = new JButton("Manage Data");
		dataManagmet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dataManager window = new dataManager();
					window.getFrame().setVisible(true);
				} catch (Exception x) {
					JOptionPane.showMessageDialog(frmSandradon, "Cannot open data manager", "Error", JOptionPane.ERROR_MESSAGE, null);
					x.printStackTrace();
				}
			}
		});
		dataManagmet.setBounds(45, 53, 162, 61);
		frmSandradon.getContentPane().add(dataManagmet);
	}
}
