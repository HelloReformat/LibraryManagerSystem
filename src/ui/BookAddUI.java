package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import dao.BookDao;
import dao.BookTypeDao;
import model.Book;
import model.BookType;
import util.MysqlUtil;
import util.StringUtil;

public class BookAddUI extends JFrame {

	private JPanel contentPane;
	private JTextField nametxt;
	private JTextField authortxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField pricetxt;
	private JComboBox typebox;
	private JTextArea desctxt;
	private JRadioButton man;
	private JRadioButton woman;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddUI frame = new BookAddUI();
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
	public BookAddUI() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				try {
					fillBookType();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 693, 749);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0");
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005");
		lblNewLabel_1.setFont(new Font("幼圆", Font.BOLD, 20));
		
		nametxt = new JTextField();
		nametxt.setFont(new Font("宋体", Font.PLAIN, 20));
		nametxt.setColumns(10);
		
		authortxt = new JTextField();
		authortxt.setFont(new Font("宋体", Font.PLAIN, 20));
		authortxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F5C\u8005\u6027\u522B");
		lblNewLabel_2.setFont(new Font("幼圆", Font.BOLD, 20));
		
		man = new JRadioButton("\u7537");
		man.setFont(new Font("宋体", Font.PLAIN, 20));
		buttonGroup.add(man);
		
		woman = new JRadioButton("\u5973");
		woman.setFont(new Font("宋体", Font.PLAIN, 20));
		buttonGroup.add(woman);
		
		JLabel label = new JLabel("\u56FE\u4E66\u4EF7\u683C");
		label.setFont(new Font("幼圆", Font.BOLD, 20));
		
		pricetxt = new JTextField();
		pricetxt.setFont(new Font("宋体", Font.PLAIN, 20));
		pricetxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B");
		label_1.setFont(new Font("幼圆", Font.BOLD, 20));
		
		typebox = new JComboBox();
		typebox.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u63CF\u8FF0");
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		
		desctxt = new JTextArea();
		desctxt.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addBook(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetPerform(e);
			}
		});
		
		JButton button_2 = new JButton("\u65B0\u5EFA\u56FE\u4E66\u7C7B\u6BD4");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookTypeAddUI().setVisible(true);	
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2)
									.addGap(18)
									.addComponent(desctxt, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_1)
											.addGap(18)
											.addComponent(typebox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_2)
												.addComponent(lblNewLabel))
											.addGap(18)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(nametxt, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(man)
													.addGap(34)
													.addComponent(woman)))))
									.addGap(36)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(button_2)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblNewLabel_1)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(authortxt, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(label)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(pricetxt)))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(185)
							.addComponent(button)
							.addGap(89)
							.addComponent(button_1)))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(nametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(authortxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(87)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(man)
						.addComponent(woman)
						.addComponent(label)
						.addComponent(pricetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(92)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(typebox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2))
					.addGap(90)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(desctxt, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(37))
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	private void resetPerform(ActionEvent e) {
		nametxt.setText("");
		authortxt.setText("");
		pricetxt.setText("");
		desctxt.setText("");
		typebox.setSelectedIndex(0);
	}

	private void addBook(ActionEvent e) throws SQLException {	
		String name = nametxt.getText();
		String author = authortxt.getText();
		String sex ;
		if(man.isSelected())sex = "男";
		else sex = "女";
		String price = pricetxt.getText();
		String typeID = ((BookType)typebox.getSelectedItem()).getId();
		String desc = desctxt.getText();
		
		if(StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "名字不能为空");
			return;
		}
		
		if(StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "作者不能为空");
			return;
		}
		
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "价格不能为空");
			return;
		}
		
		if(StringUtil.isEmpty(desc)) {
			JOptionPane.showMessageDialog(null, "图书描述不能为空");
			return;
		}
		
		Book b = new Book(name, author, sex, price, typeID, desc);
		int result = new BookDao().add(b);
		if(result == 1) {
			JOptionPane.showMessageDialog(null, "添加成功");
		}else {
			JOptionPane.showMessageDialog(null, "添加失败");
		}
	}

	private void fillBookType() throws SQLException {
		Connection con = MysqlUtil.getCon();
		ResultSet rs = new BookTypeDao().listAll();
		typebox.removeAllItems();
		while(rs.next()) {
			BookType bt = new  BookType();
			bt.setId(rs.getString(1));
			bt.setBookTypeName(rs.getString(2));
			typebox.addItem(bt);
		}
		
	}
}
