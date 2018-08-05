package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setLocationRelativeTo(null);
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
	public Main() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 900);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		mnNewMenu_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManagerUI btm = new  BookTypeManagerUI();
				btm.setVisible(true);
				btm.setLocationRelativeTo(null);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mntmNewMenuItem_1.setIcon(new ImageIcon(Main.class.getResource("/img/\u7EF4\u62A4.png")));
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddUI f = new BookTypeAddUI();
				f.setVisible(true);	
			}
		});
		menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuItem_1.setIcon(new ImageIcon(Main.class.getResource("/img/set.png")));
		mnNewMenu_2.add(menuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookManagerUI().setVisible(true);
			}
		});
		menuItem_2.setIcon(new ImageIcon(Main.class.getResource("/img/\u7EF4\u62A4.png")));
		menuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu_3.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddUI ba= new BookAddUI();
				ba.setVisible(true);
				ba.setLocationRelativeTo(null);
			}
		});
		menuItem_3.setIcon(new ImageIcon(Main.class.getResource("/img/set.png")));
		menuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu_3.add(menuItem_3);
		
		JMenuItem menuItem = new JMenuItem("\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "是否退出系统？");
				if(res == 0) {
					dispose();
				}
			}
		});
		menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuItem.setIcon(new ImageIcon(Main.class.getResource("/img/exit.png")));
		mnNewMenu.add(menuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u5E2E\u52A9");
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5173\u4E8E Reformat");
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReformatInfo info = new ReformatInfo();
				info.setVisible(true);
				//table.add(info);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(Main.class.getResource("/img/heart.png")));
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		table.setBackground(SystemColor.menu);
		contentPane.add(table, BorderLayout.CENTER);
	}

}
