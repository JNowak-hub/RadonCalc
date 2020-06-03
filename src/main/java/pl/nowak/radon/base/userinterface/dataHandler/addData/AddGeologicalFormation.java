package pl.nowak.radon.base.userinterface.dataHandler.addData;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import converter.districtConverter.DistrictStoreJsonConverter;
import pl.nowak.radon.base.models.district.DistrictStore;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class AddGeologicalFormation {

	private JFrame frame;
	private JTable table;
	private JTextField geologicalForamtionDescription;
	private JTextField geologicalFormationId;
	private DistrictStore districtStore;	
	private JFileChooser chooser;


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
//		chooser = new JFileChooser();
//		chooser.showOpenDialog(frame);
//		districtStore = (DistrictStore) new DistrictStoreJsonConverter(chooser.getSelectedFile().getAbsolutePath()).fromJson().get();
//		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 626, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 23, 261, 293);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(124, 252, 0));
		table.setBackground(Color.CYAN);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Insert Geological Foramtion description");
		lblNewLabel.setBounds(10, 11, 202, 28);
		frame.getContentPane().add(lblNewLabel);
		
		geologicalForamtionDescription = new JTextField();
		geologicalForamtionDescription.setBounds(10, 50, 202, 68);
		frame.getContentPane().add(geologicalForamtionDescription);
		geologicalForamtionDescription.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Insert Geological Foramation ID");
		lblNewLabel_1.setBounds(10, 129, 202, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		geologicalFormationId = new JTextField();
		geologicalFormationId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				geologicalFormationId.setText("");
			}
		});

		geologicalFormationId.addKeyListener(new KeyAdapter() {
			private boolean number(char zn) {
				if (zn >= '0' && zn <= '9')
					return true;

				return false;
			}

			@Override
			public void keyTyped(KeyEvent ke) {
				if (!number(ke.getKeyChar()))
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.isControlDown() && ke.getKeyCode() == KeyEvent.VK_V) {
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					DataFlavor flavor = DataFlavor.stringFlavor;
					String clip = "";

					try {
						clip = (String) clipboard.getData(flavor);
					} catch (UnsupportedFlavorException ex) {
						JOptionPane.showMessageDialog(frame, "It's not a number");
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(frame, "Error occured");
					}

					for (int i = 0; i < clip.length(); i++) {
						if (!number(clip.charAt(i))) {
							ke.consume();
							break;
						}
					}
				}
			}
		});
		geologicalFormationId.setBounds(10, 168, 86, 20);
		frame.getContentPane().add(geologicalFormationId);
		geologicalFormationId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Select District");
		lblNewLabel_2.setBounds(10, 199, 202, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox districtComboBox = new JComboBox(districtStore.getDistrictsNames());
		districtComboBox.setForeground(Color.WHITE);
		districtComboBox.setBackground(Color.LIGHT_GRAY);
		districtComboBox.setBounds(10, 238, 202, 22);
		frame.getContentPane().add(districtComboBox);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Yes, exit", "No, stay"};
				int i = JOptionPane.showOptionDialog(frame,
						"Do you really want to exit ? \n" + 
				"All unsaved changes will be lost", "Do you want to exit?",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(i == 0)
					frame.dispose();
			}
		});
		btnExit.setBounds(482, 341, 118, 38);
		frame.getContentPane().add(btnExit);

		
		JButton btnAddFormation = new JButton("Add Formation");
		btnAddFormation.setBounds(7, 293, 118, 38);
		frame.getContentPane().add(btnAddFormation);
		
		JButton btnAddToDataBase = new JButton("Add to database");
		btnAddToDataBase.setBounds(10, 341, 115, 38);
		frame.getContentPane().add(btnAddToDataBase);
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return null;
	}
}
