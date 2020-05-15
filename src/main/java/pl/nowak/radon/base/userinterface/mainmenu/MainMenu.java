package pl.nowak.radon.base.userinterface.mainmenu;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu extends JFrame {
	JFrame mainFrame = new JFrame();
	JPanel mainPanel = new JPanel();
	JButton c1 = new JButton("c1");
	JButton c2 = new JButton("c2");
	JButton c3 = new JButton("c3");
	JButton c4 = new JButton("c4");

	public MainMenu() {
		buttons();
		initComponets();

	}

	public void initComponets() {
		mainFrame.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 4,
				Toolkit.getDefaultToolkit().getScreenSize().height / 4,
				Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	public void buttons() {
		mainFrame.add(mainPanel);
		GroupLayout layout = new GroupLayout(mainPanel);
		mainPanel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(c1).addComponent(c2)
				.addGroup(layout.createParallelGroup().addComponent(c3).addComponent(c4)));
		layout.setVerticalGroup(
				layout.createSequentialGroup().addGroup(layout.createParallelGroup()
						.addComponent(c1).addComponent(c2).addComponent(c3)).addComponent(c4));

	}

}
