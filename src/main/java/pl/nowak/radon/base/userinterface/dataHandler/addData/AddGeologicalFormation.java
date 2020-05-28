package pl.nowak.radon.base.userinterface.dataHandler.addData;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;

public class AddGeologicalFormation {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public AddGeologicalFormation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return null;
	}

}
