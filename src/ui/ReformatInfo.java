package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ReformatInfo extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReformatInfo frame = new ReformatInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReformatInfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setRootPaneCheckingEnabled(false);
		setTitle("\u5173\u4E8EReformat");
		setBounds(100, 100, 839, 813);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ReformatInfo.class.getResource("/img/Reformat.jpg")));
		getContentPane().add(label, BorderLayout.CENTER);

	}

}
