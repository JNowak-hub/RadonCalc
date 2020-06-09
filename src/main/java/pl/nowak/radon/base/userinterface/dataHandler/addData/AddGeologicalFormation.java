package pl.nowak.radon.base.userinterface.dataHandler.addData;

import java.awt.Window;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import converter.districtConverter.DistrictStoreJsonConverter;
import converter.geologicalFormationConverter.GeologicalFormationStoreJsonConverter;
import pl.nowak.radon.base.models.district.DistrictStore;
import pl.nowak.radon.base.models.geologicalformation.GeologicalFormationStore;
import pl.nowak.radon.base.models.geologicalformation.GeologicalFormationTableModel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddGeologicalFormation {

	private JFrame frame;
	private JTable geologicalFormationTable;
	private JFileChooser chooser;
	private GeologicalFormationStore store;
	private DistrictStore districtStore;
	private JTextField geologicalFormationIdTextField;

	public AddGeologicalFormation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		chooser = new JFileChooser();
		chooser.showOpenDialog(frame);
		store = (GeologicalFormationStore) new GeologicalFormationStoreJsonConverter(chooser.getSelectedFile().getAbsolutePath()).fromJson().get();
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(312, 11, 302, 291);
		frame.getContentPane().add(scrollPane);
		
		
		final GeologicalFormationTableModel model = new GeologicalFormationTableModel(store);
		final DefaultTableModel dtm = new DefaultTableModel(model.GetGeologicalFormationtData(store), model.getColumnsNames());
		dtm.setColumnIdentifiers(model.getColumnsNames());
		geologicalFormationTable = new JTable();
		geologicalFormationTable.setEnabled(false);
		geologicalFormationTable.setModel(dtm);
		geologicalFormationTable.setBackground(SystemColor.controlHighlight);
		geologicalFormationTable.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLUE, Color.CYAN, Color.GREEN, Color.ORANGE));
		geologicalFormationTable.setForeground(SystemColor.desktop);
		geologicalFormationTable.setFillsViewportHeight(true);
		geologicalFormationTable.setCellSelectionEnabled(true);
		geologicalFormationTable.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(geologicalFormationTable);
		
		JLabel addFormationDescriptionLabel = new JLabel("Add Geological Formation Description");
		addFormationDescriptionLabel.setBounds(10, 98, 182, 25);
		frame.getContentPane().add(addFormationDescriptionLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 134, 182, 67);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblAddGeologicalFormation = new JLabel("Add Geological Formation Id");
		lblAddGeologicalFormation.setBounds(10, 18, 182, 25);
		frame.getContentPane().add(lblAddGeologicalFormation);
		
		geologicalFormationIdTextField = new JTextField();
		geologicalFormationIdTextField.setBounds(10, 54, 86, 20);
		frame.getContentPane().add(geologicalFormationIdTextField);
		geologicalFormationIdTextField.setColumns(10);
		geologicalFormationIdTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				geologicalFormationIdTextField.setText("");
			}
		});

		geologicalFormationIdTextField.addKeyListener(new KeyAdapter() {
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
		
		JLabel lblChooseDistrict = new JLabel("Choose district data base");
		lblChooseDistrict.setBounds(10, 224, 182, 25);
		frame.getContentPane().add(lblChooseDistrict);
		


		
		JLabel lblChooseDistrict_1 = new JLabel("Choose District");
		lblChooseDistrict_1.setBounds(10, 296, 182, 25);
		frame.getContentPane().add(lblChooseDistrict_1);
		
		JComboBox districtsComboBox = new JComboBox();
		districtsComboBox.setBounds(10, 332, 182, 22);
		frame.getContentPane().add(districtsComboBox);
		
		
		JButton btnChooseDataBase = new JButton("Choose Data Base");
		btnChooseDataBase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(frame);
				districtStore = (DistrictStore) new DistrictStoreJsonConverter(chooser.getSelectedFile().getAbsolutePath()).fromJson().get();

			}
		});
		btnChooseDataBase.setBackground(SystemColor.activeCaption);
		btnChooseDataBase.setBounds(7, 260, 185, 25);
		frame.getContentPane().add(btnChooseDataBase);

	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
