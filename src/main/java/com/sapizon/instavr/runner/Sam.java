package com.sapizon.instavr.runner;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.sapizon.instavr.test.T001_Test_LoginTest;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sam {

	private JFrame frame;
	private JCheckBox chckbxProgram;
	private JCheckBox chckbxProgram_1;
	private JButton btnRun;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sam window = new Sam();
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
	public Sam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox chckbxProgram = new JCheckBox("program1");
		chckbxProgram.setBounds(89, 48, 128, 23);
		frame.getContentPane().add(chckbxProgram);
		
		JCheckBox chckbxProgram_1 = new JCheckBox("Program2");
		chckbxProgram_1.setBounds(89, 92, 128, 23);
		frame.getContentPane().add(chckbxProgram_1);
		
		JButton btnRun = new JButton("RUN");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRun.setBounds(89, 176, 117, 29);
		frame.getContentPane().add(btnRun);
	}
}
