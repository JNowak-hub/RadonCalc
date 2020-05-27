package pl.nowak.radon.base.userinterface.dataHandler.addData;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.TableColumn;

import converter.districtConverter.DistrictJsonConverter;
import converter.districtConverter.DistrictStoreJsonConverter;
import pl.nowak.radon.base.models.district.District;
import pl.nowak.radon.base.models.district.DistrictStore;
import pl.nowak.radon.base.models.district.DistrictTableModel;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class addDistrictWindow {

	private JFrame frame;
	private JTextField districtNameText;
	private JTextField txtEnterDistrictId;
	private DistrictStore store;
	private JTable tableDistricts;
	private JFileChooser chooser;

	/**
	 * Create the application.
	 */
	public addDistrictWindow() {
		chooser = new JFileChooser();
		chooser.showOpenDialog(frame);
		store = (DistrictStore) new DistrictStoreJsonConverter(chooser.getSelectedFile().getAbsolutePath()).fromJson().get();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		getFrame().setBounds(100, 100, 619, 362);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextPane districtNameTextPane = new JTextPane();
		districtNameTextPane.setEditable(false);
		districtNameTextPane.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		districtNameTextPane.setText("Enter District name");
		districtNameTextPane.setBounds(10, 11, 184, 25);
		frame.getContentPane().add(districtNameTextPane);

		districtNameText = new JTextField();
		districtNameText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				districtNameText.setText("");
			}
		});
		districtNameText.setText("enter district name here");
		districtNameText.setBounds(10, 47, 184, 20);
		frame.getContentPane().add(districtNameText);
		districtNameText.setColumns(10);

		final JTextPane txtpnEnterDistrictId = new JTextPane();
		txtpnEnterDistrictId.setEditable(false);
		txtpnEnterDistrictId.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		txtpnEnterDistrictId.setText("Enter District Id");
		txtpnEnterDistrictId.setBounds(10, 98, 184, 25);
		frame.getContentPane().add(txtpnEnterDistrictId);

		txtEnterDistrictId = new JTextField();
		txtEnterDistrictId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEnterDistrictId.setText("");
			}
		});

		txtEnterDistrictId.addKeyListener(new KeyAdapter() {
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
		
		
		txtEnterDistrictId.setText("enter district id here");
		txtEnterDistrictId.setBounds(10, 134, 184, 20);
		frame.getContentPane().add(txtEnterDistrictId);
		txtEnterDistrictId.setColumns(10);

		JButton addDistrictBtt = new JButton("Add District");
		addDistrictBtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.addDistrict(new District(districtNameText.getText(), Integer.parseInt(txtpnEnterDistrictId.getText())));
				districtNameText.setText("");
				txtpnEnterDistrictId.setText("");
			}
		});
		addDistrictBtt.setBounds(10, 201, 136, 50);
		frame.getContentPane().add(addDistrictBtt);
		
		
		Object[] columnsNames = {"District ID", "District Name"};
		DistrictTableModel model = new DistrictTableModel(store);
		tableDistricts = new JTable(model.GetDistrictData(store), model.getColumnsNames());
		tableDistricts.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), new Color(0, 255, 255), Color.CYAN, Color.MAGENTA));
		tableDistricts.setFillsViewportHeight(true);
		tableDistricts.setCellSelectionEnabled(true);
		tableDistricts.setColumnSelectionAllowed(true);
		tableDistricts.setEnabled(false);
		tableDistricts.setBounds(275, 11, 239, 212);
		
		frame.getContentPane().add(tableDistricts);
		
		JButton exitBtt = new JButton("Exit");
		exitBtt.addActionListener(new ActionListener() {
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
		exitBtt.setBounds(486, 262, 107, 50);
		frame.getContentPane().add(exitBtt);
		
		JButton addToDataBaseBtt = new JButton("Add all to database");
		addToDataBaseBtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				//int returnValue = chooser.showOpenDialog(null);
				 int returnValue = chooser.showSaveDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooser.getSelectedFile();
					DistrictStoreJsonConverter converter = new DistrictStoreJsonConverter(selectedFile.getAbsolutePath());
					converter.toJson(store);
				}
			}
		});
		addToDataBaseBtt.setBounds(10, 262, 136, 50);
		frame.getContentPane().add(addToDataBaseBtt);
	}

	public JFrame getFrame() {
		return frame;
	}
}
