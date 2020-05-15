package pl.nowak.radon.base.userinterface.dataHandler.addData;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class addDataWidnow {

	private JFrame frmAddDataManager;

	/**
	 * Create the application.
	 */
	public addDataWidnow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddDataManager = new JFrame();
		frmAddDataManager.setTitle("Add data manager");
		getFrame().setBounds(100, 100, 647, 418);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddDataManager.getContentPane().setLayout(null);
		
		JButton addDistrictButton = new JButton("Add new District");
		addDistrictButton.setBounds(36, 156, 149, 51);
		frmAddDataManager.getContentPane().add(addDistrictButton);
		
		JButton addGeologicalFormationButton = new JButton("Add new Geological Formation");
		addGeologicalFormationButton.setBounds(233, 156, 177, 51);
		frmAddDataManager.getContentPane().add(addGeologicalFormationButton);
		
		JButton addLocationButton = new JButton("Add new Location");
		addLocationButton.setBounds(455, 156, 149, 51);
		frmAddDataManager.getContentPane().add(addLocationButton);
	}

	public JFrame getFrame() {
		return frmAddDataManager;
	}

}
