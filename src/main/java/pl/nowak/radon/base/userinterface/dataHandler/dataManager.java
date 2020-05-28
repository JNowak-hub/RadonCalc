package pl.nowak.radon.base.userinterface.dataHandler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import pl.nowak.radon.base.userinterface.dataHandler.addData.AddDataWidnow;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dataManager {

	private JFrame frmDataManager;	

	/**
	 * Create the application.
	 */
	public dataManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDataManager = new JFrame();
		frmDataManager.setTitle("Data Manager");
		getFrame().setBounds(100, 100, 696, 458);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDataManager.getContentPane().setLayout(null);
		
		JButton addDataButton = new JButton("Add Data");
		addDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddDataWidnow window = new AddDataWidnow();
					window.getFrame().setVisible(true);
				} catch (Exception x) {
					JOptionPane.showMessageDialog(frmDataManager, "Cannot open add data manager", "Error", JOptionPane.ERROR_MESSAGE, null);
					x.printStackTrace();
				}
			}
		});
		addDataButton.setBounds(29, 25, 217, 66);
		frmDataManager.getContentPane().add(addDataButton);
	}

	public JFrame getFrame() {
		return frmDataManager;
	}

}
