package rough;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class TrailRuner {

	private JFrame frame;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxTwo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrailRuner window = new TrailRuner();
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
	public TrailRuner() {
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
		
		
		JButton btnRun = new JButton("run");
		btnRun.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				if (chckbxTwo.isSelected()) {
				new rough().main(null);
				}
				if (chckbxNewCheckBox.isSelected()) {
					new Sam().main(null);
				}
				}
				
	
		});
		btnRun.setBounds(88, 143, 117, 29);
		frame.getContentPane().add(btnRun);
		
		chckbxNewCheckBox = new JCheckBox("one");
		chckbxNewCheckBox.setBounds(77, 26, 128, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		chckbxTwo = new JCheckBox("Two");
		chckbxTwo.setBounds(77, 61, 128, 23);
		frame.getContentPane().add(chckbxTwo);
	}
}
