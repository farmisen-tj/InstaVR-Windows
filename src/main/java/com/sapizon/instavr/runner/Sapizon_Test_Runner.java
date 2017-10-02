package com.sapizon.instavr.runner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Font;

public class Sapizon_Test_Runner {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sapizon_Test_Runner window = new Sapizon_Test_Runner();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sapizon_Test_Runner() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setBounds(100, 100, 796, 593);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(6, 43, 98, -21);
		frame.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnChrome = new JRadioButton("Chrome");
		rdbtnChrome.setBounds(16, 96, 141, 23);
		frame.getContentPane().add(rdbtnChrome);
		
		JButton btnNewButton = new JButton("RUN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(0, 204, 255));
		btnNewButton.setBounds(191, 536, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBackground(new Color(51, 204, 255));
		btnCancel.setBounds(321, 536, 117, 29);
		frame.getContentPane().add(btnCancel);
		
		JRadioButton rdbtnEdgeBrowser = new JRadioButton("IE Browser");
		rdbtnEdgeBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnEdgeBrowser.setBounds(16, 131, 141, 23);
		frame.getContentPane().add(rdbtnEdgeBrowser);
		
		textField = new JTextField();
		textField.setBounds(157, 95, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 130, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JCheckBox chckbxLoginTestWith = new JCheckBox("Login Test With Valid credintials");
		chckbxLoginTestWith.setBounds(39, 208, 307, 23);
		frame.getContentPane().add(chckbxLoginTestWith);
		
		JCheckBox chckbxLoginTestWith_1 = new JCheckBox("Login Test With Invalid Credintials");
		chckbxLoginTestWith_1.setBounds(39, 275, 316, 23);
		frame.getContentPane().add(chckbxLoginTestWith_1);
		
		JCheckBox chckbxTestAuthoring = new JCheckBox("Test Verify Authoring");
		chckbxTestAuthoring.setBounds(39, 307, 248, 23);
		frame.getContentPane().add(chckbxTestAuthoring);
		
		JCheckBox chckbxTestBranding = new JCheckBox("Test Verify Branding ");
		chckbxTestBranding.setBounds(39, 342, 248, 23);
		frame.getContentPane().add(chckbxTestBranding);
		
		JCheckBox chckbxTestPreview = new JCheckBox("Test Verify Preview");
		chckbxTestPreview.setBounds(39, 376, 223, 23);
		frame.getContentPane().add(chckbxTestPreview);
		
		JCheckBox chckbxTestPackage = new JCheckBox("Test Verify Package");
		chckbxTestPackage.setBounds(39, 411, 248, 23);
		frame.getContentPane().add(chckbxTestPackage);
		
		JCheckBox chckbxTestDownload = new JCheckBox("Test Verify Download ");
		chckbxTestDownload.setBounds(39, 446, 248, 23);
		frame.getContentPane().add(chckbxTestDownload);
		
		JCheckBox chckbxTestAddVr = new JCheckBox("Test Click to Add VR Is Present");
		chckbxTestAddVr.setBounds(39, 481, 307, 23);
		frame.getContentPane().add(chckbxTestAddVr);
		
		JCheckBox chckbxTestToAdd = new JCheckBox("Test To Select Image From FileManager");
		chckbxTestToAdd.setBounds(358, 208, 307, 23);
		frame.getContentPane().add(chckbxTestToAdd);
		
		JCheckBox chckbxTest = new JCheckBox("Test To Verify Link");
		chckbxTest.setBounds(358, 239, 277, 23);
		frame.getContentPane().add(chckbxTest);
		
		JCheckBox chckbxTestToVerify = new JCheckBox("Test To Verify Hotspot");
		chckbxTestToVerify.setBounds(358, 274, 215, 23);
		frame.getContentPane().add(chckbxTestToVerify);
		
		JCheckBox chckbxTestToVerify_1 = new JCheckBox("Test To Verify Action");
		chckbxTestToVerify_1.setBounds(358, 309, 237, 23);
		frame.getContentPane().add(chckbxTestToVerify_1);
		
		JCheckBox chckbxLoginTestWith_2 = new JCheckBox("Login Test With Blank Credintials");
		chckbxLoginTestWith_2.setBounds(39, 243, 258, 23);
		frame.getContentPane().add(chckbxLoginTestWith_2);
		
		JCheckBox chckbxTestToUpload = new JCheckBox("Test To Upload Image From Local Machine");
		chckbxTestToUpload.setBounds(358, 342, 307, 23);
		frame.getContentPane().add(chckbxTestToUpload);
		
		JCheckBox chckbxTestToUpload_1 = new JCheckBox("Test To Upload Video From Local Machine");
		chckbxTestToUpload_1.setBounds(358, 377, 316, 23);
		frame.getContentPane().add(chckbxTestToUpload_1);
		
		JCheckBox chckbxTestToReset = new JCheckBox("Test To Reset Camara");
		chckbxTestToReset.setBounds(358, 411, 248, 23);
		frame.getContentPane().add(chckbxTestToReset);
		
		JCheckBox chckbxTestToUpdate = new JCheckBox("Test To Update New Image");
		chckbxTestToUpdate.setBounds(358, 446, 249, 23);
		frame.getContentPane().add(chckbxTestToUpdate);
		
		JCheckBox chckbxTestTo = new JCheckBox("Test To Verify Offset Slidbar ");
		chckbxTestTo.setBounds(358, 481, 284, 23);
		frame.getContentPane().add(chckbxTestTo);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("RadioButtonMenuItem.selectionBackground"));
		panel.setBounds(0, 0, 806, 45);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Automaion Test Execution Platform");
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Palatino", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(UIManager.getColor("RadioButtonMenuItem.selectionForeground"));
	}
}
