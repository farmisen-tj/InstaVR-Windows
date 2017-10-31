package com.sapizon.instavr.TestRunner;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.ImageIcon;
import javax.swing.JScrollBar;

@SuppressWarnings("unused")
public class Sapizon_Test_Runner {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox chckbxLoginTestWith;
	private JCheckBox chckbxLoginTestWith_1;
	private JCheckBox chckbxTestAuthoring;
	private JCheckBox chckbxTestBranding;
	private JCheckBox chckbxTestPreview;
	private JCheckBox chckbxTestPackage;
	private JCheckBox chckbxTestDownload;
	private JCheckBox chckbxTestAddVr;
	private JCheckBox chckbxTestToAdd;
	private JCheckBox chckbxTest;
	private JCheckBox chckbxTestToVerify;
	private JCheckBox chckbxTestToVerify_1;
	private JCheckBox chckbxLoginTestWith_2;
	private JCheckBox chckbxTestToUpload;
	private JCheckBox chckbxTestToUpload_1;
	private JCheckBox chckbxTestToReset;
	private JCheckBox chckbxTestToUpdate;
	private JCheckBox chckbxTestTo;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_1;
	private JRadioButton rdbtnChrome;
	private JRadioButton rdbtnEdgeBrowser;
	public WebDriver driver;
	private JButton btnNewButton;
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setBounds(100, 100, 796, 593);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(6, 43, 98, -21);
		frame.getContentPane().add(lblNewLabel);
		
		rdbtnChrome = new JRadioButton("Chrome");
		rdbtnChrome.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(rdbtnChrome.isSelected()) {
					comboBox.enable();
					comboBox_1.disable();
				}
				if(rdbtnChrome.isSelected()) {
					btnNewButton.setVisible(true);		
				}
				else {
					btnNewButton.setVisible(false);
				}
			}
			
		});
		buttonGroup.add(rdbtnChrome);
		rdbtnChrome.setBounds(16, 96, 141, 23);
		frame.getContentPane().add(rdbtnChrome);
		
		btnNewButton = new JButton("RUN");
		btnNewButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				if (chckbxLoginTestWith.isSelected()) {
					new ValidCredentials().main(null);
				}
				
				if (chckbxLoginTestWith_2.isSelected()) {
					new BlankCredentials().main(null);
					}
				
				if (chckbxLoginTestWith_1.isSelected()) {
					new InvalidCredentials().main(null);
					}
				
				if (chckbxTestAuthoring.isSelected()) {
					new VerifyAuthoring().main(null);
					}
				
				if (chckbxTestBranding.isSelected()) {
					new VerifyBranding().main(null);
					}
				
				if (chckbxTestPreview.isSelected()) {
					new VerifyPreview().main(null);
					}
				
				if (chckbxTestPackage.isSelected()) {
					new VerifyPackage().main(null);
					}
				
				if (chckbxTestDownload.isSelected()) {
					new VerifyDownload().main(null);
					}

				if (chckbxTestAddVr.isSelected()) {
					new AddContent().main(null);
					}

				if (chckbxTestToAdd.isSelected()) {
					new VerifyFilemanager().main(null);
					}
				
				if (chckbxTest.isSelected()) {
					new VerifyLink().main(null);
					}
				if (chckbxTestToVerify.isSelected()) {
					new VerifyHotspot().main(null);
					}
				
				if (chckbxTestToVerify_1.isSelected()) {
					new VerifyActions().main(null);
					}
				if (chckbxTestToUpload.isSelected()) {
					new UploadImage().main(null);
					}
				if (chckbxTestToUpload_1.isSelected()) {
					new UploadVideo().main(null);
					}
				if (chckbxTestToReset.isSelected()) {
					new ResetCamara().main(null);
					}
				if (chckbxTestTo.isSelected()) {
					new ResetCamara().main(null);
					}
				if (chckbxTestToUpdate.isSelected()) {
					UpdateImage img = new UpdateImage();
					img.main(null);
					}
				
				/*	if(rdbtnChrome.isSelected()){
					System.setProperty("webdriver.chrom.driver", System.getProperty("user.dir") +"chromedriver");
					 ChromeOptions options = new ChromeOptions();
					 options.addArguments("--start-fullscreen");
					 driver = new ChromeDriver(options);		
			}*/
				
			}
		});
		btnNewButton.setBackground(new Color(0, 204, 255));
		btnNewButton.setBounds(191, 536, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

				
			}
		});
	
		btnCancel.setBackground(new Color(51, 204, 255));
		btnCancel.setBounds(321, 536, 117, 29);
		frame.getContentPane().add(btnCancel);
		
	 rdbtnEdgeBrowser = new JRadioButton("IE Browser");
		buttonGroup.add(rdbtnEdgeBrowser);
		rdbtnEdgeBrowser.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(rdbtnEdgeBrowser.isSelected()) {
					comboBox.disable();
					comboBox_1.enable();
				}
			}
		});
		rdbtnEdgeBrowser.setBounds(16, 131, 141, 23);
		frame.getContentPane().add(rdbtnEdgeBrowser);
		
		chckbxLoginTestWith = new JCheckBox("Login Test With Valid credintials");
	
		chckbxLoginTestWith.setBounds(39, 208, 307, 23);
		frame.getContentPane().add(chckbxLoginTestWith);
		
		 chckbxLoginTestWith_1 = new JCheckBox("Login Test With Invalid Credintials");
		
		chckbxLoginTestWith_1.setBounds(39, 275, 316, 23);
		frame.getContentPane().add(chckbxLoginTestWith_1);
		
		 chckbxTestAuthoring = new JCheckBox("Test Verify Authoring");
		
		chckbxTestAuthoring.setBounds(39, 307, 248, 23);
		frame.getContentPane().add(chckbxTestAuthoring);
		
		 chckbxTestBranding = new JCheckBox("Test Verify Branding ");
	
		chckbxTestBranding.setBounds(39, 342, 248, 23);
		frame.getContentPane().add(chckbxTestBranding);
		
		chckbxTestPreview = new JCheckBox("Test Verify Preview");
		
		chckbxTestPreview.setBounds(39, 376, 223, 23);
		frame.getContentPane().add(chckbxTestPreview);
		
		 chckbxTestPackage = new JCheckBox("Test Verify Package");
	
		chckbxTestPackage.setBounds(39, 411, 248, 23);
		frame.getContentPane().add(chckbxTestPackage);
		
		 chckbxTestDownload = new JCheckBox("Test Verify Download ");
	
		chckbxTestDownload.setBounds(39, 446, 248, 23);
		frame.getContentPane().add(chckbxTestDownload);
		
		 chckbxTestAddVr = new JCheckBox("Test Click to Add VR Is Present");
		
		chckbxTestAddVr.setBounds(39, 481, 307, 23);
		frame.getContentPane().add(chckbxTestAddVr);
		
		chckbxTestToAdd = new JCheckBox("Test To Verify FileManager");
		
		chckbxTestToAdd.setBounds(358, 208, 307, 23);
		frame.getContentPane().add(chckbxTestToAdd);
		
		 chckbxTest = new JCheckBox("Test To Verify Link");
		
		chckbxTest.setBounds(358, 239, 277, 23);
		frame.getContentPane().add(chckbxTest);
		
		 chckbxTestToVerify = new JCheckBox("Test To Verify Hotspot");
	
		chckbxTestToVerify.setBounds(358, 274, 215, 23);
		frame.getContentPane().add(chckbxTestToVerify);
		
		 chckbxTestToVerify_1 = new JCheckBox("Test To Verify Action");
		
		chckbxTestToVerify_1.setBounds(358, 309, 237, 23);
		frame.getContentPane().add(chckbxTestToVerify_1);
		
		chckbxLoginTestWith_2 = new JCheckBox("Login Test With Blank Credintials");
	
		chckbxLoginTestWith_2.setBounds(39, 243, 258, 23);
		frame.getContentPane().add(chckbxLoginTestWith_2);
		
		chckbxTestToUpload = new JCheckBox("Test To Upload Image From Local Machine");
		
		chckbxTestToUpload.setBounds(358, 342, 307, 23);
		frame.getContentPane().add(chckbxTestToUpload);
		
		chckbxTestToUpload_1 = new JCheckBox("Test To Upload Video From Local Machine");
		
		chckbxTestToUpload_1.setBounds(358, 377, 316, 23);
		frame.getContentPane().add(chckbxTestToUpload_1);
		
		 chckbxTestToReset = new JCheckBox("Test To Reset Camara");
		
		chckbxTestToReset.setBounds(358, 411, 248, 23);
		frame.getContentPane().add(chckbxTestToReset);
		
		 chckbxTestToUpdate = new JCheckBox("Test To Update New Image");
		
		chckbxTestToUpdate.setBounds(358, 446, 249, 23);
		frame.getContentPane().add(chckbxTestToUpdate);
		
		 chckbxTestTo = new JCheckBox("Test To Verify Offset Slidbar ");
		
		chckbxTestTo.setBounds(358, 481, 284, 23);
		frame.getContentPane().add(chckbxTestTo);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("RadioButtonMenuItem.selectionBackground"));
		panel.setBounds(0, 0, 806, 45);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Automaion Test Execution Platform");
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("PT Serif Caption", Font.BOLD, 18));
		lblNewLabel_1.setForeground(UIManager.getColor("RadioButtonMenuItem.selectionForeground"));
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1 Instance", "2 Instance", "3 Instance"}));
		comboBox.setBounds(157, 96, 130, 27);
		frame.getContentPane().add(comboBox);
		
		 comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1 Instance", "2 Instance", "3 Instance"}));
		comboBox_1.setBounds(157, 131, 130, 27);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/apple/Desktop/Webp.net-resizeimage (2).png"));
		lblNewLabel_2.setBounds(16, 43, 193, 45);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
