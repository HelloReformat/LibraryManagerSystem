package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.UserDao;
import model.User;
import util.StringUtil;

public class LoginUI {

	private JFrame frame;
	private JTextField user_ID;
	private JTextField user_Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
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
	public LoginUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u767B\u9646\u754C\u9762");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("幼圆", Font.BOLD, 20));
		label.setIcon(new ImageIcon(LoginUI.class.getResource("/img/book (1).png")));
		
		JLabel lblid = new JLabel("\u7528\u6237ID\uFF1A");
		lblid.setIcon(new ImageIcon(LoginUI.class.getResource("/img/user.png")));
		
		JLabel label_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_2.setIcon(new ImageIcon(LoginUI.class.getResource("/img/key.png")));
		
		user_ID = new JTextField();
		user_ID.setColumns(10);
		
		user_Password = new JTextField();
		user_Password.setColumns(10);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginActionPerformed(e);
			}	
		});
		
		JButton button_2 = new JButton("\u91CD\u7F6E");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetActionPerformed(e);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(119)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(129)
							.addComponent(button)
							.addGap(70)
							.addComponent(button_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(79)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addGap(31)
									.addComponent(user_Password, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblid)
									.addGap(24)
									.addComponent(user_ID, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))))
					.addGap(70))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(label)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addComponent(lblid)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addComponent(user_ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(user_Password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addContainerGap(62, Short.MAX_VALUE))
						.addComponent(button_2)))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void LoginActionPerformed(ActionEvent e) {
        String userID = user_ID.getText();
        String userPW = user_Password.getText();
        
        if(StringUtil.isEmpty(userID)) {
        	JOptionPane.showMessageDialog(null, "用户名不能为空");
        	return;
        }
        
        if(StringUtil.isEmpty(userPW)) {
        	JOptionPane.showMessageDialog(null, "密码不能为空");
        	return;
        }
        
        User user = new UserDao().login(userID,userPW) ;
        if(user==null) {
        	JOptionPane.showMessageDialog(null, "用户名密码错误");
        	return;
        }else {
        	frame.dispose();
        	new Main().setVisible(true);
        }
	}
	
	private void ResetActionPerformed(ActionEvent e) {
		user_ID.setText("");
		user_Password.setText("");	
	}

	
}
