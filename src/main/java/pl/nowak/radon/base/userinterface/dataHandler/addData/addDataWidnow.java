package pl.nowak.radon.base.userinterface.dataHandler.addData;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDataWidnow {

	private JFrame frmAddDataManager;

	/**
	 * Create the application.
	 */
	public AddDataWidnow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddDataManager = new JFrame();
		frmAddDataManager.setTitle("Add data manager");
		getFrame().setBounds(100, 100, 647, 418);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddDataManager.getContentPane().setLayout(null);
		
		JButton addDistrictButton = new JButton("Add new District");
		addDistrictButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					AddDistrictWindow window = new AddDistrictWindow();
					window.getFrame().setVisible(true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		addDistrictButton.setBounds(36, 156, 149, 51);
		frmAddDataManager.getContentPane().add(addDistrictButton);
		
		JButton addGeologicalFormationButton = new JButton("Add new Geological Formation");
		addGeologicalFormationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddGeologicalFormation window = new AddGeologicalFormation();
					window.getFrame().setVisible(true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
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
