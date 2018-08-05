package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.BookTypeDao;
import model.BookType;
import util.StringUtil;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookTypeAddUI extends JFrame {

	private JPanel contentPane;
	private JTextField name;	private JTextArea desc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddUI frame = new BookTypeAddUI();
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
	public BookTypeAddUI() {
		setTitle("\u6DFB\u52A0\u56FE\u4E66\u7C7B\u522B");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 609, 591);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		
		JLabel lblNewLabel = new JLabel("\u7C7B\u522B\u63CF\u8FF0");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 20));
		
		JLabel lbll = new JLabel("\u7C7B\u522B\u540D\u79F0");
		lbll.setFont(new Font("幼圆", Font.PLAIN, 20));
		
		name = new JTextField();
		name.setFont(new Font("宋体", Font.PLAIN, 20));
		name.setColumns(10);
		
		desc = new JTextArea();
		desc.setFont(new Font("Monospaced", Font.PLAIN, 17));
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertPerform(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   name.setText("");
			   desc.setText("");
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(99)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(77)
							.addComponent(btnNewButton)
							.addGap(73)
							.addComponent(btnNewButton_1)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lbll)
									.addGap(18)
									.addComponent(name, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(desc))
								.addComponent(label))
							.addGap(85))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(118)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lbll)
							.addGap(18)
							.addComponent(label))
						.addComponent(name, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(desc, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(53))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void insertPerform(ActionEvent e) {
		String n = name.getText();
		String d = desc.getText();
		if(StringUtil.isEmpty(n)) {
			JOptionPane.showMessageDialog(null, "名字不能为空");
			return ;
		}
		
		BookType bt = new BookType(n,d);
		int i = new BookTypeDao().addBookType(bt);
		if(i==1) {
		JOptionPane.showMessageDialog(null, "添加成功");
		}else {
			JOptionPane.showMessageDialog(null, "添加失败");
		}
	}
	
	public Thread getThread() {
		return Thread.currentThread();
	}
}
